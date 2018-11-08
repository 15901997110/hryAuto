package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.UEPlanBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: UEPlanDefaultTest
 * @Author: 自动生成
 * @Date: 2018/11/08 18:13:29
 */
@Slf4j
public class UEPlanDefaultTest extends UEPlanBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public UEPlanDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/p2pToUePlanFacade/getUeAuthOrderInfo", dataProvider = "provider", description = "获取Ue系统授权订单信息")
    public void p2pToUePlanFacade_getUeAuthOrderInfo(HryTest hryTest) {
        String actual = super._p2pToUePlanFacade_getUeAuthOrderInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/p2pToUePlanFacade/getUeProductInfo", dataProvider = "provider", description = "获取优易智投产品详情")
    public void p2pToUePlanFacade_getUeProductInfo(HryTest hryTest) {
        String actual = super._p2pToUePlanFacade_getUeProductInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/p2pToUePlanFacade/getUeProductRealStatistics", dataProvider = "provider", description = "优易智投实时募集统计")
    public void p2pToUePlanFacade_getUeProductRealStatistics(HryTest hryTest) {
        String actual = super._p2pToUePlanFacade_getUeProductRealStatistics(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/UeCbpFrontFacade/queryUeProductList", dataProvider = "provider", description = "优易智投产品编号查询接口")
    public void UeCbpFrontFacade_queryUeProductList(HryTest hryTest) {
        String actual = super._UeCbpFrontFacade_queryUeProductList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/UeCbpFrontFacade/registerUeProductAmount", dataProvider = "provider", description = "优易智投金额登记接口")
    public void UeCbpFrontFacade_registerUeProductAmount(HryTest hryTest) {
        String actual = super._UeCbpFrontFacade_registerUeProductAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/UeCbpFrontFacade/sumToBeMatchAmount", dataProvider = "provider", description = "获取优易智投待匹配总金额")
    public void UeCbpFrontFacade_sumToBeMatchAmount(HryTest hryTest) {
        String actual = super._UeCbpFrontFacade_sumToBeMatchAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanAuthInvestFacade/userAuthInvest", dataProvider = "provider", description = "用户授权投资")
    public void uePlanAuthInvestFacade_userAuthInvest(HryTest hryTest) {
        String actual = super._uePlanAuthInvestFacade_userAuthInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanAuthInvestFacade/userCancelAuthInvest", dataProvider = "provider", description = "用户取消授权投资")
    public void uePlanAuthInvestFacade_userCancelAuthInvest(HryTest hryTest) {
        String actual = super._uePlanAuthInvestFacade_userCancelAuthInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/addUeProduct", dataProvider = "provider", description = "新增优易智投产品配置，供后台使用")
    public void uePlanConsoleFacade_addUeProduct(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_addUeProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/disableUeProduct", dataProvider = "provider", description = "停用优易智投产品")
    public void uePlanConsoleFacade_disableUeProduct(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_disableUeProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/enableUeProduct", dataProvider = "provider", description = "启用优易智投产品")
    public void uePlanConsoleFacade_enableUeProduct(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_enableUeProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/getUeBidInfo", dataProvider = "provider", description = "查看优易智投标的详细信息")
    public void uePlanConsoleFacade_getUeBidInfo(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_getUeBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/getUeProductConfig", dataProvider = "provider", description = "查看优易智投服务配置信息")
    public void uePlanConsoleFacade_getUeProductConfig(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_getUeProductConfig(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/queryUeAuthOrderList", dataProvider = "provider", description = "查询授权订单信息列表")
    public void uePlanConsoleFacade_queryUeAuthOrderList(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_queryUeAuthOrderList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/queryUeBidList", dataProvider = "provider", description = "查询优易智投标的信息列表")
    public void uePlanConsoleFacade_queryUeBidList(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_queryUeBidList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/queryUeCancelOrderList", dataProvider = "provider", description = "查询撤销订单信息列表")
    public void uePlanConsoleFacade_queryUeCancelOrderList(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_queryUeCancelOrderList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/queryUeMatchAndCancelOrderList", dataProvider = "provider", description = "查看授权订单匹配(撤销)的标的信息")
    public void uePlanConsoleFacade_queryUeMatchAndCancelOrderList(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_queryUeMatchAndCancelOrderList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/queryUeProductConfigList", dataProvider = "provider", description = "查询优易智投服务配置信息列表")
    public void uePlanConsoleFacade_queryUeProductConfigList(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_queryUeProductConfigList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/queryUeProductDailyAmountList", dataProvider = "provider", description = "查看优易智投产品日需求金额列表")
    public void uePlanConsoleFacade_queryUeProductDailyAmountList(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_queryUeProductDailyAmountList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/queryUeProductItemList", dataProvider = "provider", description = "查询优易智投产品每日汇总信息列表")
    public void uePlanConsoleFacade_queryUeProductItemList(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_queryUeProductItemList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanConsoleFacade/updateUeProduct", dataProvider = "provider", description = "修改优易智投产品配置")
    public void uePlanConsoleFacade_updateUeProduct(HryTest hryTest) {
        String actual = super._uePlanConsoleFacade_updateUeProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/getMyUeAuthOrder", dataProvider = "provider", description = "获取我的优易智投详情")
    public void uePlanFrontFacade_getMyUeAuthOrder(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_getMyUeAuthOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/getUeInvestRecord", dataProvider = "provider", description = "获取优易智投用户投资记录")
    public void uePlanFrontFacade_getUeInvestRecord(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_getUeInvestRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/getUeInvestRecordDetail", dataProvider = "provider", description = "交易记录 - 出借记录详情")
    public void uePlanFrontFacade_getUeInvestRecordDetail(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_getUeInvestRecordDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/getUeProductDetail", dataProvider = "provider", description = "优易智投服务列表 - 获取优易智投详情")
    public void uePlanFrontFacade_getUeProductDetail(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_getUeProductDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/listMyCancelUeAuthOrder", dataProvider = "provider", description = "历史记录 - 获取我的优易撤销记录")
    public void uePlanFrontFacade_listMyCancelUeAuthOrder(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_listMyCancelUeAuthOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/listMySettledUeAuthOrder", dataProvider = "provider", description = "历史记录 - 获取我的优易智投结清记录")
    public void uePlanFrontFacade_listMySettledUeAuthOrder(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_listMySettledUeAuthOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/listMyUeInvest", dataProvider = "provider", description = "我的出借 - 优易智投列表")
    public void uePlanFrontFacade_listMyUeInvest(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_listMyUeInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/listUeAuthOrderContract", dataProvider = "provider", description = "根据授权订单号查询该订单的合同")
    public void uePlanFrontFacade_listUeAuthOrderContract(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_listUeAuthOrderContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/listUeInvestRecord", dataProvider = "provider", description = "交易记录 - 出借记录列表")
    public void uePlanFrontFacade_listUeInvestRecord(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_listUeInvestRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/listUeProduct", dataProvider = "provider", description = "首页AND列表 - 获取优易智投服务列表")
    public void uePlanFrontFacade_listUeProduct(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_listUeProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/queryAvailablePlanByCoupon", dataProvider = "provider", description = "根据条件查询可用的券信息")
    public void uePlanFrontFacade_queryAvailablePlanByCoupon(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_queryAvailablePlanByCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/uePlanFrontFacade/queryAvailablePlanByLcj", dataProvider = "provider", description = "根据条件查询可用的理财金信息")
    public void uePlanFrontFacade_queryAvailablePlanByLcj(HryTest hryTest) {
        String actual = super._uePlanFrontFacade_queryAvailablePlanByLcj(hryTest);
        supperAssert(actual, hryTest);
    }

}
