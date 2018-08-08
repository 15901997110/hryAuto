package com.haier.testng.test;

import com.alibaba.fastjson.JSONObject;
import com.haier.po.Params;
import com.haier.testng.base.PgwBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Slf4j
public class PgwTestProcess extends PgwBase {
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        init(serviceId, envId, caseDesigner, i_c);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    private String requestNo;

    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "provider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(Params params) {
        String actual = this.payToAccountFacade_payToAccount(baseUrl, dbInfo, params);
        JSONObject actualJsonObject = JSONObject.parseObject(actual);
        requestNo = actualJsonObject.getString("requestNo");

        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
        Assert.assertTrue(false);
    }

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询", dependsOnMethods = "payToAccountFacade_payToAccount")
    public void tradeQueryFacade_tradeQuery(Params params) {
        String actual = this.tradeQueryFacade_tradeQuery(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }
}
