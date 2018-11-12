package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.PgwBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: PgwDefaultTest
 * @Author: 自动生成
 * @Date: 2018/11/12 14:21:00
 */
@Slf4j
public class PgwDefaultTest extends PgwBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public PgwDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/accountBalanceQueryFacade/accountBalanceQuery", dataProvider = "provider", description = "账户余额查询")
    public void accountBalanceQueryFacade_accountBalanceQuery(HryTest hryTest) {
        String actual = super._accountBalanceQueryFacade_accountBalanceQuery(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundPurchaseFacade/fundPurchase", dataProvider = "provider", description = "基金申购")
    public void fundPurchaseFacade_fundPurchase(HryTest hryTest) {
        String actual = super._fundPurchaseFacade_fundPurchase(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundShareQueryFacade/fundShareQuery", dataProvider = "provider", description = "基金份额查询")
    public void fundShareQueryFacade_fundShareQuery(HryTest hryTest) {
        String actual = super._fundShareQueryFacade_fundShareQuery(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/gatewayPostNotifyFacade/kjtPayNotify", dataProvider = "provider", description = "快捷通回调")
    public void gatewayPostNotifyFacade_kjtPayNotify(HryTest hryTest) {
        String actual = super._gatewayPostNotifyFacade_kjtPayNotify(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/instantTradeFacade/instantTrade", dataProvider = "provider", description = "即时收单")
    public void instantTradeFacade_instantTrade(HryTest hryTest) {
        String actual = super._instantTradeFacade_instantTrade(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "provider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(HryTest hryTest) {
        String actual = super._payToAccountFacade_payToAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/payToCardFacade/payToCard", dataProvider = "provider", description = "付款到卡")
    public void payToCardFacade_payToCard(HryTest hryTest) {
        String actual = super._payToCardFacade_payToCard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询")
    public void tradeQueryFacade_tradeQuery(HryTest hryTest) {
        String actual = super._tradeQueryFacade_tradeQuery(hryTest);
        supperAssert(actual, hryTest);
    }

}
