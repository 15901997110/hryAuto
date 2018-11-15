package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.IBSBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: IBSDefaultTest
 * @Author: 自动生成
 * @Date: 2018/11/12 14:21:00
 */
@Slf4j
public class IBSDefaultTest extends IBSBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public IBSDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/ibsFrontFacade/closeIntelligentInvest", dataProvider = "provider", description = "关闭智能投资")
    public void ibsFrontFacade_closeIntelligentInvest(HryTest hryTest) {
        String actual = super._ibsFrontFacade_closeIntelligentInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/getUserPermissionInfoOfIntelligent", dataProvider = "provider", description = "获取智能投资的用户权限信息")
    public void ibsFrontFacade_getUserPermissionInfoOfIntelligent(HryTest hryTest) {
        String actual = super._ibsFrontFacade_getUserPermissionInfoOfIntelligent(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/modifyIntelligentInvest", dataProvider = "provider", description = "修改智能投资方案")
    public void ibsFrontFacade_modifyIntelligentInvest(HryTest hryTest) {
        String actual = super._ibsFrontFacade_modifyIntelligentInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/openIntelligentInvest", dataProvider = "provider", description = "开启智能投资")
    public void ibsFrontFacade_openIntelligentInvest(HryTest hryTest) {
        String actual = super._ibsFrontFacade_openIntelligentInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/pauseIntelligentInvest", dataProvider = "provider", description = "暂停智能投资")
    public void ibsFrontFacade_pauseIntelligentInvest(HryTest hryTest) {
        String actual = super._ibsFrontFacade_pauseIntelligentInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/queryBlankContract", dataProvider = "provider", description = "获取智能投资签订合同空模板信息")
    public void ibsFrontFacade_queryBlankContract(HryTest hryTest) {
        String actual = super._ibsFrontFacade_queryBlankContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/queryLatestPlanInfo", dataProvider = "provider", description = "查询最新的用户投资方案详情")
    public void ibsFrontFacade_queryLatestPlanInfo(HryTest hryTest) {
        String actual = super._ibsFrontFacade_queryLatestPlanInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/queryPlanStatus", dataProvider = "provider", description = "根据用户Id查询用户智能投资开启状态")
    public void ibsFrontFacade_queryPlanStatus(HryTest hryTest) {
        String actual = super._ibsFrontFacade_queryPlanStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/queryPlatformLimit", dataProvider = "provider", description = "查询平台当前限额")
    public void ibsFrontFacade_queryPlatformLimit(HryTest hryTest) {
        String actual = super._ibsFrontFacade_queryPlatformLimit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/querySysRetentionLimit", dataProvider = "provider", description = "查询智投系统配置")
    public void ibsFrontFacade_querySysRetentionLimit(HryTest hryTest) {
        String actual = super._ibsFrontFacade_querySysRetentionLimit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/queryUserBiddingOrders", dataProvider = "provider", description = "查询用户智能投资记录")
    public void ibsFrontFacade_queryUserBiddingOrders(HryTest hryTest) {
        String actual = super._ibsFrontFacade_queryUserBiddingOrders(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/queryUserInvestStaticAmount", dataProvider = "provider", description = "查询用户投资统计金额")
    public void ibsFrontFacade_queryUserInvestStaticAmount(HryTest hryTest) {
        String actual = super._ibsFrontFacade_queryUserInvestStaticAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsFrontFacade/resetIntelligentInvest", dataProvider = "provider", description = "恢复智能投资")
    public void ibsFrontFacade_resetIntelligentInvest(HryTest hryTest) {
        String actual = super._ibsFrontFacade_resetIntelligentInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsSystemConfigFacade/querySystemConfig", dataProvider = "provider", description = "查询参数配置-【console使用】")
    public void ibsSystemConfigFacade_querySystemConfig(HryTest hryTest) {
        String actual = super._ibsSystemConfigFacade_querySystemConfig(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsSystemConfigFacade/querySystemSupportBidType", dataProvider = "provider", description = "查询系统支持标的类型-【console使用】")
    public void ibsSystemConfigFacade_querySystemSupportBidType(HryTest hryTest) {
        String actual = super._ibsSystemConfigFacade_querySystemSupportBidType(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsSystemConfigFacade/updateSystemConfig", dataProvider = "provider", description = "更新参数配置-【console使用】")
    public void ibsSystemConfigFacade_updateSystemConfig(HryTest hryTest) {
        String actual = super._ibsSystemConfigFacade_updateSystemConfig(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ibsSystemConfigFacade/updateSystemSupportBidType", dataProvider = "provider", description = "更新标的类型-【console使用】")
    public void ibsSystemConfigFacade_updateSystemSupportBidType(HryTest hryTest) {
        String actual = super._ibsSystemConfigFacade_updateSystemSupportBidType(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/intelligentBiddingPlanDetailFacade/queryIntelligentBiddingPlanDetail", dataProvider = "provider", description = "智投投标方案明细查询-【console使用】")
    public void intelligentBiddingPlanDetailFacade_queryIntelligentBiddingPlanDetail(HryTest hryTest) {
        String actual = super._intelligentBiddingPlanDetailFacade_queryIntelligentBiddingPlanDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/statisticsFacade/queryAllFastEarnStatistics", dataProvider = "provider", description = "全部用户的快准赚统计")
    public void statisticsFacade_queryAllFastEarnStatistics(HryTest hryTest) {
        String actual = super._statisticsFacade_queryAllFastEarnStatistics(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/statisticsFacade/queryFastEarnStatisticsByUser", dataProvider = "provider", description = "单个用户的快准赚统计")
    public void statisticsFacade_queryFastEarnStatisticsByUser(HryTest hryTest) {
        String actual = super._statisticsFacade_queryFastEarnStatisticsByUser(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/systemDailyLimitFacade/getSystemDailyLimit", dataProvider = "provider", description = "查询限额-【console使用】")
    public void systemDailyLimitFacade_getSystemDailyLimit(HryTest hryTest) {
        String actual = super._systemDailyLimitFacade_getSystemDailyLimit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/systemDailyLimitFacade/updateSystemDailyLimit", dataProvider = "provider", description = "更新限额")
    public void systemDailyLimitFacade_updateSystemDailyLimit(HryTest hryTest) {
        String actual = super._systemDailyLimitFacade_updateSystemDailyLimit(hryTest);
        supperAssert(actual, hryTest);
    }

}
