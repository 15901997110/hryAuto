package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.exception.HryException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

    public static Boolean isMatch(Map<String, Object> expected, JSONObject actual) {
        if (expected == null || expected.size() == 0) {
            return false;
        }
        for (Map.Entry<String, Object> entry : expected.entrySet()) {
            if (!isMatch(entry.getKey(), entry.getValue(), actual)) {
                return false;
            }
        }
        //所有key-value都已经通过校验,则返回true
        return true;
    }

    /**
     * 将JSONObject解析到不能再解析为止,如果发现key相同,则比较Value的值
     *
     * @param key
     * @param value
     * @param actual
     * @return
     */
    private static Boolean isMatch(String key, Object value, JSONObject actual) {
        for (Map.Entry<String, Object> entry : actual.entrySet()) {
            String actualKey = entry.getKey();
            Object actualValue = entry.getValue();
            if (actualValue instanceof JSONObject) {
                isMatch(key, value, (JSONObject) actualValue);
            } else if (actualValue instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) actualValue;
                for (int i = 0; i < jsonArray.size(); i++) {
                    Object o = jsonArray.get(i);
                    if (o instanceof JSONObject) {
                        isMatch(key, value, (JSONObject) o);
                    } else {
                        if (key.equals(actualKey)) {
                            if (isMatch(value, o)) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                if (key.equals(actualKey)) {
                    if (isMatch(value, actualValue)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    /**
     * 比较对象
     *
     * @param expected
     * @param actual
     * @return
     */
    private static Boolean isMatch(Object expected, Object actual) {
        if (expected == null || actual == null) {
            if (expected == null && actual == null) {
                return true;
            }
        }
        if (actual.equals(expected)) {
            return true;
        }
        if (actual.toString().contains(expected.toString())) {
            return true;
        }
        if (actual.toString().matches(expected.toString())) {
            return true;
        }
        return false;
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
