package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

/**
 * @Description: json封装类,提供json与各种对象互转的方法及异常处理
 * @Author: luqiwei
 * @Date: 2018/5/3 11:28
 */
@Slf4j
public class JsonUtil {

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
    public static String getParam(JSONObject definitions,String definitionName){
        if(definitionName.contains("/")){
            definitionName.substring(definitionName.lastIndexOf("/"));
        }
        JSONObject jsonObject = definitions.getJSONObject(definitionName);
        jsonObject.getJSONObject("properties");
        return null;
    }
}
