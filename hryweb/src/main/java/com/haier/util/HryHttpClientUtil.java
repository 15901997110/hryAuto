package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpMethods;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.config.SpringContextHolder;
import com.haier.config.ZdyProperty;
import com.haier.enums.*;
import com.haier.exception.HryException;
import com.haier.po.HryTest;
import com.haier.testng.base.Base;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.message.BasicHeader;
import org.testng.Reporter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 封装httpClientUtil
 * @Author: luqiwei
 * @Date: 2018/5/19 11:03
 */
@Slf4j
public class HryHttpClientUtil {
    private static Boolean debugFlag;

    static {
        ZdyProperty bean = SpringContextHolder.getBean(ZdyProperty.class);
        debugFlag = bean.getDebug();
    }

    /**
     * 最底层的封装方法
     *
     * @return
     */
    public static String send(String url, Integer requestMethodType, Integer contentType, Integer requestParamType, String param, Header[] headers, CookieStore cookieStore) {
        //请求方式,现在仅支持Post/Get
        HttpMethods methodType;
        if (RequestMethodTypeEnum.getValue(requestMethodType) != null) {
            if (requestMethodType.equals(RequestMethodTypeEnum.POST.getId())) {
                methodType = HttpMethods.POST;
            } else {
                methodType = HttpMethods.GET;
            }
        } else {//缺省时,请求方式为GET
            methodType = HttpMethods.GET;
        }

        //请求Header
        Header header;
        if (ContentTypeEnum.getValue(contentType) != null) {
            header = new BasicHeader("Content-Type", ContentTypeEnum.getValue(contentType));
        } else {//如果不指明ContentType类型,默认按照浏览器请求处理
            header = new BasicHeader("Content-Type", ContentTypeEnum.X_WWW_FORM_URLENCODED.getValue());
        }
        Header[] requestHeaders = ArrayUtils.add(headers, header);

        //HryCookie
        HttpClientContext context = null;
        if (cookieStore != null) {
            context = new HttpClientContext();
            context.setCookieStore(cookieStore);
        }


        HttpConfig config = HttpConfig.custom().url(url).encoding("utf-8").method(methodType).headers(requestHeaders);
        if (context != null) {
            config.context(context);
        }
        //设置请求参数
        if (StringUtils.isNotBlank(param) && requestParamType != null) {
            if (requestParamType.equals(RequestParamTypeEnum.JSON.getId())) {
                config.json(param);
            } else if (requestParamType.equals(RequestParamTypeEnum.MAP.getId())) {
                Map map = JSON.parseObject(param).toJavaObject(Map.class);
                config.map(map);
            }

        }

        //发送请求
        String responseEntity;
        try {
            responseEntity = HttpClientUtil.send(config);
        } catch (HttpProcessException e) {
            log.error("", e);
            responseEntity = e.getMessage();
        }

        //打印日志

        Reporter.log("实际请求参数:" + param);
        log.info("实际请求参数:" + param);
        log.info("请求Url:" + config.url());
        Reporter.log("请求Url:" + config.url());
        log.info("请求方式:" + config.method().getName());
        Reporter.log("请求方式:" + config.method().getName());

        if (headers != null && headers.length > 0) {
            log.info("请求Headers:");
            Reporter.log("请求Headers:");
            for (Header h : headers) {
                log.info("  " + h.getName() + ":" + h.getValue());
                Reporter.log("  " + h.getName() + ":" + h.getValue());
            }
        }
        log.info("响应实体:" + responseEntity);

        return responseEntity;
    }


    public static <T extends Base> String send(HryTest test, T entity) {
        if (debugFlag) {
            log.info(test.getTservice().getServicekey() + "(" + test.getTservice().getId() + ")");
            log.info(test.getTi().getIuri() + "(" + test.getTi().getId() + ")");
            log.info(test.getTcase().getCasename() + "(" + test.getTcase().getId() + ")");
            log.info("------------------------------------------------------");
            return "";
        }
        log.info("");
        log.info("--------------s=" + test.getTservice().getServicekey() + " i=" + test.getTi().getIuri() + " c=" + test.getTcase().getId() + "开始------------------");
        String url = HttpTypeEnum.getValue(test.getTservice().getHttptype()) + "://" + test.getTservicedetail().getHostinfo() + test.getTi().getIuri();
        Map<String, String> requestHeaderMap = null;
        String headerStr = test.getTcase().getRequestheader();
        if (StringUtils.isNotBlank(headerStr)) {
            JSONObject headerJSON = JSONUtil.str2JSONObj(headerStr);
            if (headerJSON != null && headerJSON.size() > 0) {
                requestHeaderMap = headerJSON.toJavaObject(Map.class);
            }
        }

        //获取测试对象中的Header和Cookie
        Map<String, String> entityHeaderMap = null;
        CookieStore entityCookieStore = null;
        if (entity != null) {
            Header[] entityHeaders = entity.headers;
            if (entityHeaders != null && entityHeaders.length > 0) {
                entityHeaderMap = Arrays.stream(entityHeaders).collect(Collectors.toMap(Header::getName, Header::getValue));
            }
            entityCookieStore = entity.cookieStore;
        }

        //合并header,如果requestHeader中的值为null,则尝试从entityHeader中取相应的值
        Map<String, String> finalHeaderMap = new HashMap<>();
        if (requestHeaderMap != null) {
            if (entityHeaderMap != null) {
                for (String requestHeaderKey : requestHeaderMap.keySet()) {
                    if (requestHeaderMap.get(requestHeaderKey) == null && entityHeaderMap.get(requestHeaderKey) != null) {//requestHeaderValue为null时,才尝试从Entity中取值
                        finalHeaderMap.put(requestHeaderKey, entityHeaderMap.get(requestHeaderKey));
                        continue;
                    }
                    //如果requestHeaderValue不为null,或者虽然为null,但是在entity中也找不到同名的非null value,则保留原Header
                    finalHeaderMap.put(requestHeaderKey, requestHeaderMap.get(requestHeaderKey));
                }
            } else {
                finalHeaderMap = requestHeaderMap;
            }
        }
        //合并用例中的Header和测试类中的Header
        Header[] requestHeaders = null;
        for (Map.Entry<String, String> entry : finalHeaderMap.entrySet()) {
            requestHeaders = ArrayUtils.add(requestHeaders, new BasicHeader(entry.getKey(), entry.getValue()));
        }

        //参数替换
        log.info("--------前置处理Start-----------");
        String param = ReplaceUtil.replaceBefore(test.getTcase().getRequestparam(), test.getTservicedetail().getDbinfo(), entity);
        log.info("--------前置处理End-------------");
        log.info("--------httpClientStart--------");
        String responseBody = send(
                url,
                test.getTi().getIrequestmethod(),
                test.getTi().getIcontenttype(),
                test.getTi().getIparamtype(),
                param,
                requestHeaders,
                entityCookieStore
        );
        log.info("--------httpClientEnd----------");
        log.info("--------后置处理Start-----------");
        ReplaceUtil.replaceAfter(test.getTcase().getCafter(), responseBody, test.getTservicedetail().getDbinfo(), entity);
        log.info("--------后置处理End-------------");
        log.info("--------------s=" + test.getTservice().getServicekey() + " i=" + test.getTi().getIuri() + " c=" + test.getTcase().getId() + "结束------------------");
        return responseBody;

    }

    public static <T> String send(String url, Integer requestMethod, T param) throws HttpProcessException {

        HttpConfig httpConfig;
        if (Objects.isNull(param)) {//参数为null,则不带参发送请求
            httpConfig = HttpConfig.custom().url(url).encoding("utf-8");
        } else if (param instanceof JSONObject) {//参数为json类型,发起json请求

            Header header = new BasicHeader("Content-Type", "application/json;charset=utf-8");
            Header[] headers = {header};
            JSONObject jsonObject = (JSONObject) param;

            httpConfig = HttpConfig.custom().url(url).encoding("utf-8").json(JSONObject.toJSONString(jsonObject));
            httpConfig.headers(headers);

        } else if (param instanceof Map) {//参数为map类型
            Map map = (Map) param;
            httpConfig = HttpConfig.custom().url(url).encoding("utf-8").map(map);
        } else {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "http请求无法发送,暂时只支持Json格式的参数");
        }
        if (requestMethod == RequestMethodTypeEnum.GET.getId()) {
            return HttpClientUtil.get(httpConfig);
        } else {
            return HttpClientUtil.post(httpConfig);
        }
    }

    public static String send(String url, Integer requestMethodType, Integer contentType, Integer requestParamType, String param) {
        return send(url, requestMethodType, contentType, requestParamType, param, null, null);
    }

    public static String get(String url) {
        return send(url, RequestMethodTypeEnum.GET.getId(), null, null, null);
    }

/*    private static <T extends Base> String replaceParam(String param, String dbInfo, T entity) {
        if (StringUtils.isNotBlank(param)) {
            Reporter.log("用例设计参数:" + param.replaceAll("<", "＜").replaceAll(">", "＞"));
            param = ReplaceUtil.replace(param, dbInfo, entity);
        } else {
            Reporter.log("用例设计参数:null");
        }
        return param;
    }*/
}
