package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.exception.HryException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: json封装类, 提供json与各种对象互转的方法及异常处理
 * @Author: luqiwei
 * @Date: 2018/5/3 11:28
 */
@Slf4j
public class JsonUtil {

    public static JSONObject str2JsonObj(String json) {
        try {
            return JSON.parseObject(json);
        } catch (Exception e) {

            log.error(json, e);
            return null;
        }
    }

    public static JSONArray str2JsonArr(String json) {
        try {
            return JSON.parseArray(json);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    public static Map<String, Object> str2Map(String json) {
        try {
            return (Map<String, Object>) JSON.parse(json);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

/*    public static String getParam(JSONObject definitions, String definitionName) {
        if (definitionName.contains("/")) {
            definitionName.substring(definitionName.lastIndexOf("/"));
        }
        JSONObject jsonObject = definitions.getJSONObject(definitionName);
        jsonObject.getJSONObject("properties");
        return null;
    }

    public static void jsonRefdeserialize(JSONObject refObject, JSONObject definitions,JSONObject retJsonObject) {
        String refValue = refObject.getString("$ref");
        if (!Objects.isNull(refValue)) {
            // "$ref": "#/definitions/GetCheckFileResultDetailsRequest"
            String definitionName = refValue.substring(refValue.lastIndexOf("/"));
            JSONObject definitionJsonObject = definitions.getJSONObject(definitionName);
            JSONArray requiredJsonArray = null;//必填字段集合
            try {
                requiredJsonArray= definitionJsonObject.getJSONArray("required");//没有必填项时,将不存在这个key
            } catch (Exception e) {
            }
            JSONObject propertiesJsonObject=definitionJsonObject.getJSONObject("properties");
            for(Map.Entry<String,Object> entry: propertiesJsonObject.entrySet()){
                String key=entry.getKey();
                Object value=entry.getValue();
                retJsonObject.put(key,value);
            }
        }
    }*/
}
