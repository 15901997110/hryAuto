package com.haier.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.google.gson.JsonObject;
import com.haier.enums.ContentTypeEnum;
import com.haier.enums.RequestMethodTypeEnum;
import com.haier.mapper.TiMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import com.haier.service.ImportService;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.collections.Maps;

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
        criteria.andServicekeyEqualTo(serviceKey).andIsdelEqualTo(0);
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
        criteria.andIstatusNotEqualTo(-1);//筛选状态!=-1(非删除的数据)
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
                //ti.setIcontenttype：如果contentTypeEnum存在就获取id，不存在则是-1
                List consumes = (List) postJsonObject.get("consumes");
                String consumesType = consumes.get(0).toString();
                if (ContentTypeEnum.getId(consumesType) != null) {
                    ti.setIcontenttype(ContentTypeEnum.getId(consumesType));
                } else {
                    ti.setIcontenttype(-1);
                }
                //解析Json，设置Iparamsample和Iheadersample
                JSONArray parameJsonObject = postJsonObject.getJSONArray("parameters");

                if (parameJsonObject != null && parameJsonObject.size() > 0) {
                    Map<String, Object> headermap = new LinkedHashMap<>();

                    for (Object jsonObj : parameJsonObject) {
                        JSONObject jsonObject1 = (JSONObject) jsonObj;
                        //JSONObject object = JSONObject.parseObject(String.valueOf(jsonObj));
                        if ("header".equals(jsonObject1.getString("in"))) {
                            headermap.put((jsonObject1.getString("name")), jsonObject1.get("default"));
                            //ti.setIheadersample(JSONUtils.toJSONString(headermap));
                        }
                        if ("body".equals(jsonObject1.get("in"))) {

                            //设置特殊的iparamsample字段
                            // Map<String, Object> schema = object.getJSONObject("schema");
                            JSONObject schema = jsonObject1.getJSONObject("schema");
                            //如果schema为空
                            if (Objects.isNull(schema)) {
                                log.info("parameter中in=body,但是Schema获取不到值 -----" + iUri);
/*                            Map<String, Object> paramsamplemap = new LinkedHashMap<>();
                            paramsamplemap.put(object.getString("name"), object.get("type"));
                            ti.setIparamsample(JSONUtils.toJSONString(paramsamplemap));*/
                            } else {
                                //判断schema下的ref是否存在，存在
                                String ref = schema.getString("$ref");
                                StringBuilder paramsamples = new StringBuilder();
                                parseRef(ref, definitions, paramsamples);

                                String paramSmapleJSON = JSONUtil.verify(paramsamples.toString());
                                if (paramSmapleJSON != null) {
                                    if (paramSmapleJSON.length() > 5000) {
                                        String params = paramsamples.substring(0, 4999);
                                        ti.setIparamsample(params);
                                        log.error("长度超过限制了，请注意！数据为：======" + paramsamples);
                                    } else {
                                        ti.setIparamsample(paramSmapleJSON);
                                    }
                                } else {
                                    if (paramsamples != null) {
                                        if (paramsamples.length() > 5000) {
                                            ti.setIparamsample(paramsamples.substring(0, 4999));
                                        } else {
                                            ti.setIparamsample(paramsamples.toString());
                                        }
                                    }
                                }

                           /* if (Objects.nonNull(schema.get("$ref"))) {

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
                            }*/
                            }
                        }
                    }
                    if (headermap.size() > 0) {
                        ti.setIheadersample(JSONUtils.toJSONString(headermap));
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
    private static void parseRef(String ref, JSONObject definitions, StringBuilder paramsamples) {
        if (ref == null || ref.length() == 0) {
            return;
        }
        //ref值的/之后的最后一段字英文字符
        String refKey = ref.substring(ref.lastIndexOf("/") + 1);
        JSONObject refValue = definitions.getJSONObject(refKey);

        JSONObject propertiesJSONObject = refValue.getJSONObject("properties");
        if (Objects.nonNull(propertiesJSONObject)) {
            paramsamples.append("{");

            for (String paramName : propertiesJSONObject.keySet()) {
                paramsamples.append("\"").append(paramName).append("\":");

                JSONObject paramValueJSONObject = propertiesJSONObject.getJSONObject(paramName);

                String paramValueType = paramValueJSONObject.getString("type");
                if ("array".equals(paramValueType)) {
                    JSONObject itemsJSONObject = paramValueJSONObject.getJSONObject("items");
                    String ref1 = itemsJSONObject.getString("$ref");
                    if (StringUtils.isNotBlank(ref1)) {
                        paramsamples.append("[");
                        parseRef(ref1, definitions, paramsamples);
                        paramsamples.append("]");
                        paramsamples.replace(paramsamples.lastIndexOf("]"), paramsamples.lastIndexOf("]") + 1, "],");
                    } else {
                        log.info("array 中的item为null");
                        /*String samples = itemsJSONObject.get("type").toString();
                        if ("integer".equals(samples)) {
                            paramsamples.append("[").append(samples.replace("integer", "0")).append("],");
                        } else if ("string".equals(samples)) {
                            paramsamples.append("[\"").append(samples.replace("string", "")).append("\"],");
                        } else if ("number".equals(samples)) {
                            paramsamples.append("[").append(samples.replace("number", "0")).append("],");
                        } else {
                            paramsamples.append("[").append(samples).append("],");
                        }*/
                        //paramsamples.append("[").append(items.get("type").toString().replace("array", "L")).append("],");
                    }
                } else if ("integer".equals(paramValueType) || "number".equals(paramValueType)) {
                    paramsamples.append("0,");
                } else if ("string".equals(paramValueType)) {
                    paramsamples.append("\"").append("\",");
                } else if ("boolean".equals(paramValueType)) {
                    paramsamples.append("true,");
                }
                /*else if ("number".equals(paramValueType)) {
                    paramsamples.append(paramValueType.toString().replace("number", "0")).append(",");
                }*/ /*else if (Objects.nonNull(paramValueType)) {
                    if ("type".equals(paramValueObjectKey) && (!"string".equals(v)) && (!"integer".equals(v)) && (!"array".equals(v))) {
                        paramsamples.append("\"").append(v.toString()).append("\",");
                    } else if ("$ref".equals(paramValueObjectKey)) {
                        parseRef(v.toString().replace("#", ""), ti, refValue, paramsamples);
                        paramsamples.append(",");
                        //paramsamples.replace(paramsamples.lastIndexOf(","), paramsamples.lastIndexOf(",") + 1, "");
                    }
                }*/
               /* else {
                    ti.setIparamsample(null);
                }*/

            }
            if (paramsamples.lastIndexOf(",") >= 0) {
                paramsamples.replace(paramsamples.lastIndexOf(","), paramsamples.lastIndexOf(",") + 1, "");
                paramsamples.append("}");
            }
        }
    }
}
