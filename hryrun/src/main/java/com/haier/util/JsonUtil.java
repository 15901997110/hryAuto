package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

/**
 * @Description: json封装类,提供json与各种对象互转的方法及异常处理
 * @Author: luqiwei
 * @Date: 2018/5/3 11:28
 */
public class JsonUtil {
    private static final Log log= LogFactory.getLog(JsonUtil.class);

    public static JSONObject str2JsonObj(String json){
        try {
            return JSON.parseObject(json);
        } catch (Exception e) {

            log.error(json,e);
            return null;
        }
    }
    public static JSONArray str2JsonArr(String json){
        try{
            return JSON.parseArray(json);
        }catch (Exception e){
            log.error("",e);
            return null;
        }
    }
    public static Map<String,Object> str2Map(String json){
        try {
            return  (Map<String,Object>) JSON.parse(json);
        } catch (Exception e) {
            log.error("",e);
            return null;
        }
    }
}
