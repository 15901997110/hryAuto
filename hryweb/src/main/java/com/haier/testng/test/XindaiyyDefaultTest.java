package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.XindaiyyBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: XindaiyyDefaultTest
 * @Author: 自动生成
 * @Date: 2018/08/16 20:32:25
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class XindaiyyDefaultTest extends XindaiyyBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
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
        String actual = this._cbp_web_book_queryBookList_json(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-web/book/review.json", dataProvider = "provider", description = "预约复核")
    public void cbp_web_book_review_json(HryTest hryTest) {
        String actual = this._cbp_web_book_review_json(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

}
