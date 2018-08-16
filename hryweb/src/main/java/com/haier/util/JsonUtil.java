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
}
