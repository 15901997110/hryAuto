package com.haier.util;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.anno.HryCookie;
import com.haier.anno.HryHeader;
import com.haier.config.SpringContextHolder;
import com.haier.po.*;
import com.haier.service.TcaseService;
import com.haier.service.TiService;
import com.haier.testng.base.Base;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.SetCookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Reporter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/9/3 16:20
 */
@Slf4j
public class LoginUtil {
    private static UnionLoginConfig unionLoginConfig = SpringContextHolder.getBean(UnionLoginConfig.class);

    /**
     * zhuanle 登录
     */
    public static <T extends Base> void zhuanleLogin(Tservice tservice, Tservicedetail tservicedetail, String iUri, T entity) {
        TiService tiService = SpringContextHolder.getBean(TiService.class);
        TcaseService tcaseService = SpringContextHolder.getBean(TcaseService.class);
        Ti tiCondition = new Ti();
        tiCondition.setServiceid(tservicedetail.getServiceid());
        tiCondition.setIuri(iUri);

        List<Ti> tis = tiService.selectByCondition(tiCondition);

        Ti ti = null;
        for (Ti i : tis) {
            if (i.getIuri().equals(iUri)) {
                ti = i;
            }
        }
        if (ti == null) {
            return;
        }
        Tcase tcaseCondition = new Tcase();
        tcaseCondition.setEnvid(tservicedetail.getEnvid());
        tcaseCondition.setIid(ti.getId());
        List<Tcase> tcases = tcaseService.selectByCondition(tcaseCondition);

        if (tcases.size() == 0) {
            log.error("未找到Case,查询条件iid=" + tcaseCondition.getIid() + ",envId=" + tcaseCondition.getEnvid());
            return;
        }
        Tcase tcase = tcases.get(0);

        HryTest test = new HryTest();
        test.setTservice(tservice);
        test.setTservicedetail(tservicedetail);
        test.setTi(ti);
        test.setTcase(tcase);
        String loginRes = HryHttpClientUtil.send(test, null);

        log.info("zhuanle登录返回:" + loginRes);
        JSONObject jsonObject = JSONUtil.str2JSONObj(loginRes);

        if (jsonObject != null) {
            try {
                String auth = jsonObject.getJSONObject("body").getString("auth");
                Header header = new BasicHeader("X-KJT-Auth", auth);
                Field[] fields = entity.getClass().getFields();
                for (Field field : fields) {
                    if (field.getAnnotation(HryHeader.class) != null) {
                        field.set(entity, ArrayUtils.add(null, header));
                        Reporter.log("登录成功,设置auth=" + auth);
                        break;
                    }
                }
            } catch (Exception e) {
                Reporter.log(e.getMessage());
                log.error("登录返回结果中寻找auth发生异常");
            }

        } else {
            log.error("登录失败");
            Reporter.log("登录失");
        }

    }

    /**
     * 联合登录 ,如果未传入sysCode,默认登录cbp-信贷系统
     */
    public static <T extends Base> void unionLogin(Tservicedetail tservicedetail, T entity, String sysCode) {
        Reporter.log(unionLoginConfig.toString());
        List<LoginInfoDetail> loginInfoDetails = unionLoginConfig.getLoginInfoDetails();
        LoginInfoDetail lid = null;
        for (LoginInfoDetail loginInfoDetail : loginInfoDetails) {
            if (tservicedetail.getEnvid().equals(loginInfoDetail.getEnvId())) {
                lid = loginInfoDetail;
                break;
            }
        }
        if (lid == null) {
            return;
        }

        Header headerContentType = new BasicHeader("Content-Type", "application/x-www-form-urlencoded");
        Header headerCookie = new BasicHeader("Cookie", "__login_name=supper2; __login_expied=7; __login_sys=" + (sysCode == null ? "cbp" : sysCode));
        String requestId = UUID.randomUUID().toString().replaceAll("-", "");
        Map<String, Object> map = new HashMap<>();
        map.put("loginName", lid.getUsername());
        map.put("password", lid.getPassword());
        map.put("dynamicCode", "");
        map.put("requestId", requestId);
        map.put("sysCode", sysCode == null ? "cbp" : sysCode);
        Header[] headers = new Header[]{headerContentType, headerCookie};
        HttpConfig config = HttpConfig.custom().url(lid.getUrl()).headers(headers, true).map(map).encoding("utf-8");

        try {
            HttpClientUtil.post(config);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }

        String hostinfo = tservicedetail.getHostinfo();
        String domain;

        if (hostinfo.contains(":")) {
            domain = hostinfo.substring(0, hostinfo.indexOf(":"));
        } else if (hostinfo.contains("/")) {
            domain = hostinfo.substring(0, hostinfo.indexOf("/"));
        } else {
            domain = hostinfo;
        }
        CookieStore cookieStore = null;
        Header[] resHeaders = config.headers();
        for (Header header : resHeaders) {
            if (header.getName().equals("Set-Cookie")) {
                HeaderElement[] elements = header.getElements();
                String name = elements[0].getName();
                String value = elements[0].getValue();
                SetCookie cookie = new BasicClientCookie(name, value);
//                NameValuePair domain = elements[0].getParameterByName("Domain");
                cookie.setDomain(domain);
                cookie.setPath("/");

                cookieStore = new BasicCookieStore();
                cookieStore.addCookie(cookie);
                break;
            }
        }

        if (cookieStore == null) {
            log.error("联合登录失败");
            return;
        }


        ReflectUtil.setFirstPublicFieldValueByAnno(entity, HryCookie.class, cookieStore);
    }
}
