package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.po.Params;
import com.haier.testng.base.PgwBase;
import com.haier.testng.base.PgwBase2;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: PgwTestDefault
 * @Author: 自动生成
 * @Date: 2018/08/08 17:35:33
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class PgwTestDefault extends PgwBase2 {
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }


    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "provider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(HryTest hryTest) {
        String actual = this._payToAccountFacade_payToAccount(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }


    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询")
    public void tradeQueryFacade_tradeQuery(HryTest hryTest) {
        String actual = this._tradeQueryFacade_tradeQuery(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

}
