package com.haier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.enums.RequestMethodTypeEnum;
import com.haier.mapper.TiMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import com.haier.service.ImportService;
import com.haier.util.HryHttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/19 13:21
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class ImportServiceImpl implements ImportService {
    @Autowired
    TserviceMapper tserviceMapper;

    @Autowired
    TiMapper tiMapper;

    private TserviceExample tserviceExample = new TserviceExample();

    private Tservice tservice = new Tservice();

    @Override
    public String sendGet(String url) {
        String jsonResponse;
        try {
            jsonResponse = HryHttpClientUtil.send(url, RequestMethodTypeEnum.GET.getId(), null);
        } catch (HttpProcessException e) {
            log.info("请求地址为:" + url);
            log.error("请求swaggerUrl时发生异常", e);
            return null;
        }
        return jsonResponse;
    }

    /**
     * @description: 根据serviceKey查询返回serviceId, 如果不存在, 则根据此serviceKey创建一
     * 条新记录并返回serviceId
     * @params: [serviceKey, serviceName]
     * @return: java.lang.Integer
     * @author: luqiwei
     * @date: 2018-05-21
     */
    @Override
    public Integer findServiceId(String serviceKey, String serviceName, String realName) {
        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        criteria.andServicekeyEqualTo(serviceKey).andIsdelEqualTo((short) 0);
        List<Tservice> tservices = tserviceMapper.selectByExample(tserviceExample);

        if (tservices != null && tservices.size() > 0) {//有记录,则取出第一条记录的ID
            return tservices.get(0).getId();

        } else {//无记录,则插入一条记录,返回插入serviceId
            tservice.setServicekey(serviceKey);
            tservice.setServicename(serviceName);
            tservice.setEditor(realName);
            tserviceMapper.insertSelective(tservice);
            return tservice.getId();
        }
    }

    @Override
    public ImportInterfaceResult importInterface(Integer serviceId, JSONObject jsonObject, Boolean overwrite, String iDev) {
        String serviceKey = jsonObject.getJSONObject("info").getString("title").trim();
        String serviceName = jsonObject.getJSONObject("info").getString("description").trim();

        ImportInterfaceResult result = new ImportInterfaceResult();
        result.setServiceId(serviceId);
        result.setServiceKey(serviceKey);
        result.setServiceName(serviceName);
        List<String> insertList = new ArrayList<String>();
        List<String> updateList = new ArrayList<String>();
        List<String> failList = new ArrayList<String>();


        //获取接口表(ti)已经存在的记录,by serviceId
        TiExample tiExample = new TiExample();
        TiExample.Criteria criteria = tiExample.createCriteria();
        criteria.andServiceidEqualTo(serviceId);//筛选serviceId
        criteria.andIstatusNotEqualTo((short) -1);//筛选状态!=-1(非删除的数据)
        List<Ti> tis = tiMapper.selectByExample(tiExample);//ti表中所有的此serviceId存在的记录的集合,(不包括删除的)
        List<String> existIuri = new ArrayList<String>();
        Map<String, Integer> existIuriId = new HashMap<String, Integer>();//后续更新记录时会用到primaryKey
        if (tis != null) {
            for (Ti i : tis) {
                existIuri.add(i.getIuri());
                existIuriId.put(i.getIuri(), i.getId());
            }
        }

        JSONObject paths = jsonObject.getJSONObject("paths");//获取path:
        //definitions主要用于获取示例参数,这里暂时忽略,获取示例参数将改由Selenium从页面抓取
        JSONObject definitions = jsonObject.getJSONObject("definitions");//获取definitions

        //解析paths,
        for (Map.Entry<String, Object> entry : paths.entrySet()) {
            String iUri = entry.getKey();//ti.iuri
            try {
                JSONObject iUriJsonObject = (JSONObject) entry.getValue();
                JSONObject postJsonObject = iUriJsonObject.getJSONObject("post");
                String summary = postJsonObject.getString("summary");//接口描述信息,作为i.remark插入

                Ti ti = new Ti();
                ti.setServiceid(serviceId);
                ti.setIuri(iUri);
                ti.setRemark(summary);
                ti.setIdev(iDev);
                //ti.setUpdatetime(new Date());modify by luqiwei:此字段mysql会自动更新,无需设置
                //解析Json，设置Iparamsample
                List parameJsonObject = postJsonObject.getJSONArray("parameters");
                //如果parameJsonObject为空，则直接赋值为空
                if(parameJsonObject.size()==0){
                    ti.setIparamsample("");
                }else {
                    Map<String, Object> parametersMap = (Map<String, Object>) parameJsonObject.get(0);
                    Map<String, Object> schema = (Map<String, Object>) parametersMap.get("schema");
                    if (Objects.isNull(schema)) {
                        StringBuilder paramsample = new StringBuilder();
                        paramsample.append("{");
                        for (int i = 0; i < parameJsonObject.size(); i++) {
                            Map<String, Object> Mapparameters = (Map<String, Object>) parameJsonObject.get(i);
                            for (String listkey : Mapparameters.keySet()) {
                                Object listvalue = Mapparameters.get(listkey);
                                if (Objects.nonNull(listkey)) {
                                    if ("name".equals(listkey)) {
                                        paramsample.append(listvalue.toString()).append("=");
                                    } else if ("type".equals(listkey)) {
                                        paramsample.append(listvalue.toString()).append("&");
                                    }
                                }
                            }
                        }
                        paramsample.append("}");
                        if (paramsample.lastIndexOf("&") >= 0) {
                            paramsample.replace(paramsample.lastIndexOf("&"), paramsample.lastIndexOf("&") + 1, "");
                        }
                        ti.setIparamsample(paramsample.toString());
                    } else {
                        //判断schema下的ref是否存在，存在
                        if (Objects.nonNull(schema.get("$ref"))) {
                            String ref = schema.get("$ref").toString();
                            StringBuilder paramsamples = new StringBuilder();
                            parseRef(ref, ti, definitions, paramsamples);
                        } else {//不存在
                            StringBuilder params = new StringBuilder();
                            params.append("{");
                            String mps = schema.get("type").toString();
                            if ("string".equals(mps)) {
                                params.append("\"").append(schema.get("type").toString().replace("string", "")).append("\"");
                            } else if ("integer".equals(mps)) {
                                params.append(schema.get("type").toString().replace("integer", "0"));
                            } else {
                                params.append("\"").append(schema.get("type").toString()).append("\"");
                            }
                            params.append("}");
                            ti.setIparamsample(params.toString());
                        }
                    }
                }

                if (Objects.isNull(existIuri) || !existIuri.contains(iUri)) {//如果existIurl==null,说明此serviceId没有对应
                    // 的接口记录,以下则可放心插入,
                    //或者existIuri虽然不为null,但是并不包含此条需要插入的ti记录,此情况也可以直接插入
                    try {
                        tiMapper.insertSelective(ti);
                        insertList.add(iUri);
                    } catch (Exception e) {
                        log.error("插入接口数据失败", e);
                        failList.add(iUri + ":插入数据失败");//记录失败的iUri
                    }
                } else {//existIuri不是null&&existIuri包含当前要插入的记录
                    if (overwrite) {//如果overwrite==true,则覆盖存在的记录,将数据更新
                        ti.setId(existIuriId.get(iUri));
                        try {
                            tiMapper.updateByPrimaryKeySelective(ti);
                            updateList.add(iUri);
                        } catch (Exception e) {
                            log.error("更新接口数据失败", e);
                            failList.add(iUri + ":更新数据失败");
                        }
                    } else {//如果overwrite==false,则不覆盖记录,直接忽略这条ti记录
                        failList.add(iUri + ":存在重复的记录");
                    }
                }
            } catch (Exception e) {
                log.error(iUri + "解析json错误", e);
            }
        }

        //构建返回信息
        result.setTotalCount(paths.size());
        result.setInsertCount(insertList.size());
        result.setInsertList(insertList);
        result.setUpdateCount(updateList.size());
        result.setUpdateList(updateList);
        result.setFailCount(failList.size());
        result.setFailList(failList);

        return result;
    }

    //ref内层嵌套json解析
    private static void parseRef(String ref, Ti ti, Map<String, Object> definitions, StringBuilder paramsamples) {
        if (org.apache.commons.lang.StringUtils.isNotBlank(ref) && ref.contains("/")) {
            //ref值的/之后的最后一段字英文字符
            String defKey = ref.substring(ref.lastIndexOf("/") + 1, ref.length());
            Map<String, Object> definitionsMap = (Map<String, Object>) definitions.get(defKey);
            Map<String, Object> properties = (Map<String, Object>) definitionsMap.get("properties");
            if (Objects.nonNull(properties)) {
                paramsamples.append("{");
                for (String propertieKey : properties.keySet()) {
                    paramsamples.append("\"").append(propertieKey).append("\":");
                    Map<String, Object> propertiesValue = (Map<String, Object>) properties.get(propertieKey);
                    for (String k : propertiesValue.keySet()) {
                        Object v = propertiesValue.get(k);
                        if ("array".equals(v)) {
                            Map<String, Object> items = (Map<String, Object>) propertiesValue.get("items");
                            if (Objects.nonNull(items.get("$ref"))) {
                                ref = items.get("$ref").toString();
                                paramsamples.append("[");
                                parseRef(ref, ti, definitions, paramsamples);
                                paramsamples.append("]");
                                paramsamples.replace(paramsamples.lastIndexOf("]"), paramsamples.lastIndexOf("]") + 1, "],");
                            } else {
                                String samples = items.get("type").toString();
                                if ("integer".equals(samples)){
                                    paramsamples.append("[").append(samples.replace("integer", "0")).append("],");
                                }else if ("string".equals(samples)){
                                    paramsamples.append("[\"").append(samples.replace("string", "")).append("\"],");
                                }else if ("number".equals(samples)){
                                    paramsamples.append("[").append(samples.replace("number", "0")).append("],");
                                } else {
                                    paramsamples.append("[").append(samples).append("],");
                                }
                                //paramsamples.append("[").append(items.get("type").toString().replace("array", "L")).append("],");
                            }
                        } else if ("integer".equals(v)) {
                            //paramsamples.append("\"").append(v.toString().replace("integer","0")).append("\",");
                            paramsamples.append(v.toString().replace("integer", "0")).append(",");
                        } else if ("string".equals(v)) {
                            paramsamples.append("\"").append(v.toString().replace("string", "")).append("\",");
                        } else if ("number".equals(v)) {
                            //paramsamples.append("\"").append(v.toString().replace("number","0")).append("\",");
                            paramsamples.append(v.toString().replace("number", "0")).append(",");
                        } else if (Objects.nonNull(v)) {
                            if ("type".equals(k) && (!"string".equals(v)) && (!"integer".equals(v)) && (!"array".equals(v))) {
                                paramsamples.append("\"").append(v.toString()).append("\",");
                            } else if ("$ref".equals(k)) {
                                parseRef(v.toString().replace("#", ""), ti, definitions, paramsamples);
                                paramsamples.append(",");
                                //paramsamples.replace(paramsamples.lastIndexOf(","), paramsamples.lastIndexOf(",") + 1, "");
                            }
                        } else {
                            ti.setIparamsample(null);
                        }
                    }
                }
                if (paramsamples.lastIndexOf(",") >= 0) {
                    paramsamples.replace(paramsamples.lastIndexOf(","), paramsamples.lastIndexOf(",") + 1, "");
                    paramsamples.append("}");
                }
                //log.info("解析结果为：======" + paramsamples);
                //字符长度超过5000时，截取5000个字符
                if (paramsamples.length() > 5000) {
                    String params = paramsamples.substring(0, 5000);
                    ti.setIparamsample(params.replaceAll("\"0\"", "0"));
                    log.error("长度超过限制了，请注意！数据为：======" + paramsamples);
                } else {
                    //ti.setIparamsample(paramsamples.toString().replaceAll("\"0\"", "0"));
                    ti.setIparamsample(paramsamples.toString());
                }
            }
        } else {
            ti.setIparamsample(null);
        }
    }
}
