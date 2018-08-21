package com.haier.testng.test;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.po.HryTest;
import com.haier.testng.base.XindaiyyBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.SetCookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @Description: XindaiyyDefaultTest
 * @Author: 自动生成
 * @Date: 2018/08/17 14:34:00
 */
@Slf4j
public class XindaiyyProcessTest extends XindaiyyBase {
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
        try {
            login();
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    public void login() throws HttpProcessException {
        String url = "http://10.25" + envId + ".104.1:8211/hry-uni-login/login";
        Header headerContentType = new BasicHeader("Content-Type", "application/x-www-form-urlencoded");
        Header headerCookie = new BasicHeader("Cookie", "__login_name=supper2; __login_expied=7; __login_sys=cbp");
        String requestId = UUID.randomUUID().toString().replaceAll("-", "");
        Map<String, Object> map = new HashMap<>();
        map.put("loginName", "supper2");
        map.put("password", "kjt123");
        map.put("dynamicCode", "");
        map.put("requestId", requestId);
        map.put("sysCode", "cbp");
        Header[] headers = new Header[]{headerContentType, headerCookie};

        HttpConfig config = HttpConfig.custom().url(url).headers(headers, true).map(map).encoding("utf-8");

        String post = HttpClientUtil.post(config);
        log.info("登录响应结果:" + post);
        log.info("login执行完成!!!");

        Header[] resHeaders = config.headers();
        for (Header header : resHeaders) {
            if (header.getName().equals("Set-Cookie")) {
                HeaderElement[] elements = header.getElements();
//                NameValuePair[] nameValuePairs = elements[0].getParameters();
                String name = elements[0].getName();
                String value = elements[0].getValue();
                SetCookie cookie = new BasicClientCookie(name, value);
                NameValuePair domain = elements[0].getParameterByName("Domain");
                cookie.setDomain(domain.getValue());
                cookie.setPath("/");
                cookieStore = new BasicCookieStore();
                cookieStore.addCookie(cookie);
                break;
            }
        }
    }

    @Test(testName = "/cbp-web/book/addBookInfo.json", dataProvider = "provider", description = "新建预约")
    public void cbp_web_book_addBookInfo_json(HryTest hryTest) {
        String actual = this._cbp_web_book_addBookInfo_json(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-web/book/audit.json", dataProvider = "provider", description = "审核预约")
    public void cbp_web_book_audit_json(HryTest hryTest) {
        String actual = this._cbp_web_book_audit_json(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-web/book/queryBookList.json", dataProvider = "provider", description = "查询预约列表")
    public void cbp_web_book_queryBookList_json(HryTest hryTest) {
        log.info("查询预约列表接口测试开始------");
        String actual = this._cbp_web_book_queryBookList_json(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-web/book/review.json", dataProvider = "provider", description = "预约复核")
    public void cbp_web_book_review_json(HryTest hryTest) {
        String actual = this._cbp_web_book_review_json(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

}
