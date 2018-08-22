package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.haier.enums.AssertTypeEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Tcase;
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
public class JSONUtil {

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

    /**
     *@description: 校验字符串是否符合JSON格式,如果符合,返回JSON格式化后的字符串,否则,返回null
     *@params: 待校验的json字符串
     *@return: JSON格式化后的字符串
     *@author: luqiwei
     *@date: 2018-08-21
     */
    public static String verify(String json) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(json, Feature.OrderedField);
            json = JSONObject.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue);
        } catch (RuntimeException e) {
            json = null;
        } finally {
            return json;
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
}
