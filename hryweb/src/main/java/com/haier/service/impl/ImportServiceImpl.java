package com.haier.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.enums.ContentTypeEnum;
import com.haier.enums.StatusEnum;
import com.haier.mapper.TserviceMapper;
import com.haier.po.ImportInterfaceResult;
import com.haier.po.Ti;
import com.haier.service.ImportService;
import com.haier.service.TiService;
import com.haier.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    TiService tiService;

    @Override
    public ImportInterfaceResult importInterface(Integer serviceId, JSONObject jsonObject, Boolean overwrite, String iDev) {
        String serviceKey = jsonObject.getJSONObject("info").getString("title");
        String serviceName = jsonObject.getJSONObject("info").getString("description");

        ImportInterfaceResult result = new ImportInterfaceResult();
        result.setServiceId(serviceId);
        result.setServiceKey(serviceKey);
        result.setServiceName(serviceName);
        List<String> insertList = new ArrayList<>();
        List<String> updateList = new ArrayList<>();
        List<String> failList = new ArrayList<>();

        //获取接口表(ti)已经存在的记录,by serviceId
        Ti condition = new Ti();
        condition.setServiceid(serviceId);
        List<Ti> tis = tiService.selectAllStatusByCondition(condition);//ti表中所有的此serviceId存在的记录的集合,包括删除与作废的
        List<String> existIuri = new ArrayList<>();
        List<String> deleteIuri = new ArrayList<>();
        List<String> invalidIuri = new ArrayList<>();
        Map<String, Integer> existIuriId = new HashMap<>();//后续更新记录时会用到primaryKey
        Map<String, Integer> deleteIuriId = new HashMap<>();
        Map<String, Integer> invalidIuriId = new HashMap<>();
        for (Ti i : tis) {
            if (i.getIstatus() > 0) {
                existIuri.add(i.getIuri());
                existIuriId.put(i.getIuri(), i.getId());
            }
            if (i.getIstatus().equals(StatusEnum._ONE.getId())) {
                deleteIuri.add(i.getIuri());
                deleteIuriId.put(i.getIuri(), i.getId());
            }
            if (i.getIstatus().equals(StatusEnum._TWO.getId())) {
                invalidIuri.add(i.getIuri());
                invalidIuriId.put(i.getIuri(), i.getId());
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

                JSONArray consumes = postJsonObject.getJSONArray("consumes");
                String consumesType = consumes.getString(0);
                if (ContentTypeEnum.getId(consumesType) != null) {
                    ti.setIcontenttype(ContentTypeEnum.getId(consumesType));
                } else {
                    ti.setIcontenttype(-1);
                }
                //解析Json，设置Iparamsample和Iheadersample
                JSONArray parametersJSONArr = postJsonObject.getJSONArray("parameters");

                if (parametersJSONArr != null && parametersJSONArr.size() > 0) {
                    Map<String, Object> headermap = new LinkedHashMap<>();
                    for (Object obj : parametersJSONArr) {
                        JSONObject someoneParameterJSONObj;
                        if (obj instanceof JSONObject) {
                            someoneParameterJSONObj = (JSONObject) obj;
                        } else {
                            continue;
                        }

                        if ("header".equals(someoneParameterJSONObj.getString("in"))) {
                            headermap.put((someoneParameterJSONObj.getString("name")), someoneParameterJSONObj.get("default"));
                        }
                        if ("body".equals(someoneParameterJSONObj.get("in")) && ti.getIparamsample() == null) {//ti.iparamsample如果存在值,则不执行这里的逻辑
                            //设置特殊的iparamsample字段
                            JSONObject schema = someoneParameterJSONObj.getJSONObject("schema");
                            //如果schema为空
                            if (Objects.isNull(schema)) {
                                log.info("parameter中in=body,但是Schema获取不到值 -----" + iUri);
                            } else {
                                //判断schema下的ref是否存在
                                String ref = schema.getString("$ref");
                                StringBuilder paramsamples = new StringBuilder();
                                parseRef(ref, definitions, paramsamples);

                                //设置paramsample
                                String paramSmapleJSON = JSONUtil.verify(paramsamples.toString());
                                if (paramSmapleJSON != null) {
                                    if (paramSmapleJSON.length() > 5000) {
                                        String params = paramsamples.substring(0, 4999);
                                        ti.setIparamsample(params);
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
                            }
                        }
                    }
                    if (headermap.size() > 0) {
                        //设置headersmaple
                        ti.setIheadersample(JSONUtils.toJSONString(headermap));
                    }
                }


                //如果此接口已经作废,并且此接口不在有效接口的列表中,则直接忽略,
                if (invalidIuri.size() > 0 && invalidIuri.contains(iUri) && (existIuri.size() == 0 || !existIuri.contains(iUri))) {
                    failList.add(iUri + "(已作废)");
                    continue;
                }
                //如果此服务下不存在接口,或者虽然存在接口,但是不包含当前这条接口记录
                if (existIuri.size() == 0 || !existIuri.contains(iUri)) {
                    tiService.insertOne(ti);
                    insertList.add(iUri);
                } else {//existIuri.size()>0 && existIuri包含当前要插入的记录

                    if (overwrite) {//如果overwrite==true,则覆盖存在的记录,将数据更新
                        ti.setId(existIuriId.get(iUri));
                        tiService.updateOne(ti);
                        updateList.add(iUri);
                        existIuri.remove(iUri);
                    } else {//如果overwrite==false,则不覆盖记录,直接忽略这条ti记录
                        failList.add(iUri + "(已存在)");
                        existIuri.remove(iUri);
                    }
                }
            } catch (Exception e) {
                log.error(iUri + "解析json错误", e);
            }
        }
        List<String> deleteList = new ArrayList<>();
        //如果existIuri没有被remove,则说明这些Iuri没有存在于最新的swagger文档中,此时,将删除这些接口
        for (int i = 0; i < existIuri.size(); i++) {
            Integer deleteId = existIuriId.get(existIuri.get(i));
            tiService.deleteOne(deleteId);
            deleteList.add(existIuri.get(i));
        }


        //构建返回信息
        result.setTotalCount(paths.size());
        result.setInsertCount(insertList.size());
        result.setInsertList(insertList);
        result.setUpdateCount(updateList.size());
        result.setUpdateList(updateList);
        result.setFailCount(failList.size());
        result.setFailList(failList);
        result.setDeleteCount(deleteList.size());
        result.setDeleteList(deleteList);

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
        //ref打开后获取type和properties
        String type = refValue.getString("type");
        JSONObject propertiesJSONObject = refValue.getJSONObject("properties");
        //type为object且properties不为空
        if ("object".equals(type) && Objects.nonNull(propertiesJSONObject)) {
            paramsamples.append("{");
            for (String paramName : propertiesJSONObject.keySet()) {
                paramsamples.append("\"").append(paramName).append("\":");
                JSONObject paramValueJSONObject = propertiesJSONObject.getJSONObject(paramName);
                String paramValueType = paramValueJSONObject.getString("type");
                //properties的参数类型判断
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
                    }
                } else if ("integer".equals(paramValueType) || "number".equals(paramValueType)) {
                    paramsamples.append("0,");
                } else if ("string".equals(paramValueType)) {
                    paramsamples.append("\"").append("\",");
                } else if ("boolean".equals(paramValueType)) {
                    paramsamples.append("true,");
                }else if ("object".equals(paramValueType)) {
                    JSONObject additionalPropertiesobj = paramValueJSONObject.getJSONObject("additionalProperties");
                    String objectPropertiestype = additionalPropertiesobj.getString("type");
                    if("object".equals(objectPropertiestype)||"array".equals(objectPropertiestype)){
                        paramsamples.append("{},");
                    }
                } else if(StringUtils.isBlank(paramValueType)) {
                    String propertiesref = paramValueJSONObject.getString("$ref");
                    if (StringUtils.isNotBlank(propertiesref)){
                        parseRef(propertiesref, definitions, paramsamples);
                        paramsamples.replace(paramsamples.lastIndexOf("}"), paramsamples.lastIndexOf("}") + 1, "},");
                    }
                }
            }
            if (paramsamples.lastIndexOf(",") >= 0) {
                paramsamples.replace(paramsamples.lastIndexOf(","), paramsamples.lastIndexOf(",") + 1, "");
                paramsamples.append("}");
            }
        }else if ("object".equals(type) && Objects.isNull(propertiesJSONObject)){
            paramsamples.append(" ");
        }
    }
}
