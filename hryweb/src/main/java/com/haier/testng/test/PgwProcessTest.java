package com.haier.testng.test;

import com.alibaba.fastjson.JSONObject;
import com.haier.po.HryTest;
import com.haier.testng.base.PgwBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Slf4j
public class PgwProcessTest extends PgwBase {
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy","testingId"})
    public PgwProcessTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy,String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy,testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    public String requestNo;

    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "provider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(HryTest test) {
        String actual = super._payToAccountFacade_payToAccount(test);
        JSONObject actualJsonObject = JSONObject.parseObject(actual);
        requestNo = actualJsonObject.getString("requestNo");

        AssertUtil.supperAssert(actual, test);
    }

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询", dependsOnMethods = "payToAccountFacade_payToAccount")
    public void tradeQueryFacade_tradeQuery(HryTest test) {
        String actual = super._tradeQueryFacade_tradeQuery(test);
        AssertUtil.supperAssert(actual, test);
    }
}
