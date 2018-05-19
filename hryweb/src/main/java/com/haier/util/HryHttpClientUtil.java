package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.enums.ContentTypeEnum;
import com.haier.enums.RequestMethodTypeEnum;
import com.haier.enums.RequestParamTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: 封装httpClientUtil
 * @Author: luqiwei
 * @Date: 2018/5/19 11:03
 */
@Slf4j
public class HryHttpClientUtil {
    public static <T> String send(String url, RequestMethodTypeEnum requestMethodType, T param) throws HttpProcessException {

        HttpConfig httpConfig = null;

        if (Objects.isNull(param)) {//参数为null,则不带参发送请求
            httpConfig = HttpConfig.custom().url(url).encoding("utf-8");
        } else if (param instanceof JSONObject) {//参数为json类型,发起json请求
            JSONObject jsonObject = (JSONObject) param;
            httpConfig = HttpConfig.custom().url(url).encoding("utf-8").json(JSONObject.toJSONString(jsonObject));
        } else if (param instanceof Map) {//参数为map类型
            Map map = (Map) param;
            httpConfig = HttpConfig.custom().url(url).encoding("utf-8").map(map);
        }
        if(httpConfig==null){
            log.error("传入参数类型无法识别,现只支持null,JSONObject.class,Map.class");
            return null;
        }
        if (requestMethodType == RequestMethodTypeEnum.REQUEST_METHOD_GET) {
            return HttpClientUtil.get(httpConfig);
        } else {
            return HttpClientUtil.post(httpConfig);
        }
    }
}
