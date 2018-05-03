package com.haier.util;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.enums.ContentTypeEnum;
import com.haier.enums.RequestMethodTypeEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;

/**
 * @Description:对arronlong httpclient的二次封装
 * @Author: luqiwei
 * @Date: 2018/5/2 16:07
 */
public class HryHttpClientUtil {
    private static Log log = LogFactory.getLog(HryHttpClientUtil.class);
    /**
     *@description:发送请求
     *@params: [requestMethod, url, paramType, param]
     *@return: java.lang.String
     *@author: luqiwei
     *@date: 2018-05-02
     */
    public static String send(int requestMethod,String url,Integer paramType,String param){
        Header[] headers= HttpHeader.custom().other("content-type", ContentTypeEnum.getValue(paramType)+";charset=utf-8").build();
        HttpConfig httpConfig= HttpConfig.custom().headers(headers).url(url).encoding("utf-8");

        //根据paramType配置请求参数类型
        if(ContentTypeEnum.getValue(paramType).equalsIgnoreCase("application/json")){
            httpConfig.json(param);
        }else if (ContentTypeEnum.getValue(paramType).equalsIgnoreCase("application/x-www-form-urlencoded")){
            //do application/x-www-form-urlencoded post
            //...
        }

        return sendRequest(requestMethod, url, paramType, param, httpConfig);
    }

    private static String sendRequest(int requestMethod, String url, Integer paramType, String param, HttpConfig httpConfig) {
        String response=null;
        //根据requestMethod发送不同方式的请求
        if(RequestMethodTypeEnum.getValue(requestMethod).equalsIgnoreCase("get")){
            //处理get请求
            try {
                response = HttpClientUtil.get(httpConfig);

            } catch (HttpProcessException e) {
                log.error("",e);
            }
        }else if(RequestMethodTypeEnum.getValue(requestMethod).equalsIgnoreCase("post")){
            //处理post请求
            try {
                response=HttpClientUtil.post(httpConfig);
                log.info(response);
            } catch (HttpProcessException e) {
                log.error("",e);
            }
        }
        log.info("请求地址:"+url);
        log.info("参数类型|参数:"+paramType+"|"+param);
        log.info("返回内容:"+response);
        return response;
    }



}
