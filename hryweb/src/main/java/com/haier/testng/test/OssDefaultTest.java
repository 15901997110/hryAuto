package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.OssBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: OssDefaultTest
 * @Author: 自动生成
 * @Date: 2018/09/03 20:54:08
 */
@Slf4j
public class OssDefaultTest extends OssBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/accelerationFacade/addAccelerationPlan", dataProvider = "provider", description = "用户参加收益加速活动")
    public void accelerationFacade_addAccelerationPlan(HryTest hryTest) {
        String actual = this._accelerationFacade_addAccelerationPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accelerationFacade/getAccelerationPlanDetail", dataProvider = "provider", description = "获取收益加速计划详情")
    public void accelerationFacade_getAccelerationPlanDetail(HryTest hryTest) {
        String actual = this._accelerationFacade_getAccelerationPlanDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accelerationFacade/getAccelerationProductInfo", dataProvider = "provider", description = "获取收益加速标的信息")
    public void accelerationFacade_getAccelerationProductInfo(HryTest hryTest) {
        String actual = this._accelerationFacade_getAccelerationProductInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accelerationFacade/getAccelerationRecord", dataProvider = "provider", description = "获取收益加速记录")
    public void accelerationFacade_getAccelerationRecord(HryTest hryTest) {
        String actual = this._accelerationFacade_getAccelerationRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accelerationFacade/getAccelerationResult", dataProvider = "provider", description = "获取用户加速的结果")
    public void accelerationFacade_getAccelerationResult(HryTest hryTest) {
        String actual = this._accelerationFacade_getAccelerationResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accelerationFacade/getAcceleratorInfo", dataProvider = "provider", description = "获取收益加速好友信息")
    public void accelerationFacade_getAcceleratorInfo(HryTest hryTest) {
        String actual = this._accelerationFacade_getAcceleratorInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accelerationFacade/getDailyAccelerationInfo", dataProvider = "provider", description = "获取收益加速标的信息")
    public void accelerationFacade_getDailyAccelerationInfo(HryTest hryTest) {
        String actual = this._accelerationFacade_getDailyAccelerationInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accelerationFacade/getOrderAccelerationInfo", dataProvider = "provider", description = "获取订单的加速信息")
    public void accelerationFacade_getOrderAccelerationInfo(HryTest hryTest) {
        String actual = this._accelerationFacade_getOrderAccelerationInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/behaviorAnalysisFacade/addMarketingPushMessage", dataProvider = "provider", description = "推送消息")
    public void behaviorAnalysisFacade_addMarketingPushMessage(HryTest hryTest) {
        String actual = this._behaviorAnalysisFacade_addMarketingPushMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/behaviorAnalysisFacade/addMarketingSendRewards", dataProvider = "provider", description = "发送奖励")
    public void behaviorAnalysisFacade_addMarketingSendRewards(HryTest hryTest) {
        String actual = this._behaviorAnalysisFacade_addMarketingSendRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/behaviorAnalysisFacade/addMarketingSendSms", dataProvider = "provider", description = "发送短信")
    public void behaviorAnalysisFacade_addMarketingSendSms(HryTest hryTest) {
        String actual = this._behaviorAnalysisFacade_addMarketingSendSms(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/behaviorAnalysisFacade/getAllUserBehaviorAnalysisResult", dataProvider = "provider", description = "查询所有用户")
    public void behaviorAnalysisFacade_getAllUserBehaviorAnalysisResult(HryTest hryTest) {
        String actual = this._behaviorAnalysisFacade_getAllUserBehaviorAnalysisResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/behaviorAnalysisFacade/getBehaviorAnalysisResult", dataProvider = "provider", description = "根据营销行为查询用户")
    public void behaviorAnalysisFacade_getBehaviorAnalysisResult(HryTest hryTest) {
        String actual = this._behaviorAnalysisFacade_getBehaviorAnalysisResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/behaviorAnalysisFacade/getMarketingBehaviorAnalysisRecord", dataProvider = "provider", description = "获取查询的信息")
    public void behaviorAnalysisFacade_getMarketingBehaviorAnalysisRecord(HryTest hryTest) {
        String actual = this._behaviorAnalysisFacade_getMarketingBehaviorAnalysisRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/behaviorAnalysisFacade/getMarketingBehaviorAnalysisRecordList", dataProvider = "provider", description = "获取查询的信息分页列表")
    public void behaviorAnalysisFacade_getMarketingBehaviorAnalysisRecordList(HryTest hryTest) {
        String actual = this._behaviorAnalysisFacade_getMarketingBehaviorAnalysisRecordList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/addBlcakList", dataProvider = "provider", description = "加入黑名单")
    public void commonFacade_addBlcakList(HryTest hryTest) {
        String actual = this._commonFacade_addBlcakList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/executeTask", dataProvider = "provider", description = "执行任务")
    public void commonFacade_executeTask(HryTest hryTest) {
        String actual = this._commonFacade_executeTask(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/getAccountBalance", dataProvider = "provider", description = "获取账户余额")
    public void commonFacade_getAccountBalance(HryTest hryTest) {
        String actual = this._commonFacade_getAccountBalance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/getAccountBalanceAlarm", dataProvider = "provider", description = "获取账户预警金额")
    public void commonFacade_getAccountBalanceAlarm(HryTest hryTest) {
        String actual = this._commonFacade_getAccountBalanceAlarm(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/getFeatureWhiteList", dataProvider = "provider", description = "根据hryid获取功能列表信息")
    public void commonFacade_getFeatureWhiteList(HryTest hryTest) {
        String actual = this._commonFacade_getFeatureWhiteList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/getOperatingAccountExpense", dataProvider = "provider", description = "根据时间获取运营户支出信息")
    public void commonFacade_getOperatingAccountExpense(HryTest hryTest) {
        String actual = this._commonFacade_getOperatingAccountExpense(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/getOperatingAccountRecharge", dataProvider = "provider", description = "根据时间获取运营户支出信息")
    public void commonFacade_getOperatingAccountRecharge(HryTest hryTest) {
        String actual = this._commonFacade_getOperatingAccountRecharge(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/pushMessage", dataProvider = "provider", description = "推送消息")
    public void commonFacade_pushMessage(HryTest hryTest) {
        String actual = this._commonFacade_pushMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/sendSms", dataProvider = "provider", description = "批量发送短信")
    public void commonFacade_sendSms(HryTest hryTest) {
        String actual = this._commonFacade_sendSms(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/commonFacade/setAccountBalanceAlarm", dataProvider = "provider", description = "设置账户预警金额和邮箱")
    public void commonFacade_setAccountBalanceAlarm(HryTest hryTest) {
        String actual = this._commonFacade_setAccountBalanceAlarm(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/compensateFacade/addPrepaymentCompensateRecord", dataProvider = "provider", description = "提前还款补偿")
    public void compensateFacade_addPrepaymentCompensateRecord(HryTest hryTest) {
        String actual = this._compensateFacade_addPrepaymentCompensateRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/compensateFacade/addReservationCompensateRecord", dataProvider = "provider", description = "预约补偿")
    public void compensateFacade_addReservationCompensateRecord(HryTest hryTest) {
        String actual = this._compensateFacade_addReservationCompensateRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/addMerchantChannel", dataProvider = "provider", description = "新增商户活动渠道")
    public void consolePromotionFacade_addMerchantChannel(HryTest hryTest) {
        String actual = this._consolePromotionFacade_addMerchantChannel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/addPromotionActivity", dataProvider = "provider", description = "新增活动信息")
    public void consolePromotionFacade_addPromotionActivity(HryTest hryTest) {
        String actual = this._consolePromotionFacade_addPromotionActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/addPromotionActivityRule", dataProvider = "provider", description = "新增活动规则")
    public void consolePromotionFacade_addPromotionActivityRule(HryTest hryTest) {
        String actual = this._consolePromotionFacade_addPromotionActivityRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/deletePromotionActivityRule", dataProvider = "provider", description = "删除活动规则")
    public void consolePromotionFacade_deletePromotionActivityRule(HryTest hryTest) {
        String actual = this._consolePromotionFacade_deletePromotionActivityRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getInvestRankActivity", dataProvider = "provider", description = "查询打榜活动")
    public void consolePromotionFacade_getInvestRankActivity(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getInvestRankActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getMerchantChannel", dataProvider = "provider", description = "查询商户渠道信息")
    public void consolePromotionFacade_getMerchantChannel(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getMerchantChannel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getMerchantChannelList", dataProvider = "provider", description = "查询商户渠道列表")
    public void consolePromotionFacade_getMerchantChannelList(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getMerchantChannelList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getPromotionActivity", dataProvider = "provider", description = "查询活动信息")
    public void consolePromotionFacade_getPromotionActivity(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getPromotionActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getPromotionActivityDetail", dataProvider = "provider", description = "查看推广活动活动及其活动规则信息")
    public void consolePromotionFacade_getPromotionActivityDetail(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getPromotionActivityDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getPromotionActivityList", dataProvider = "provider", description = "获取推广活动列表: 1、渠道ID为空: 查询全部推广; 2、渠道ID为0: 查询普通推广; 3、其他渠道ID: 查询商户推广;")
    public void consolePromotionFacade_getPromotionActivityList(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getPromotionActivityList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getPromotionActivityRule", dataProvider = "provider", description = "查看活动规则")
    public void consolePromotionFacade_getPromotionActivityRule(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getPromotionActivityRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getPromotionActivityRuleList", dataProvider = "provider", description = "查看推广活动规则列表")
    public void consolePromotionFacade_getPromotionActivityRuleList(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getPromotionActivityRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/getPromotionRewardsInfo", dataProvider = "provider", description = "查询推广活动奖励统计信息")
    public void consolePromotionFacade_getPromotionRewardsInfo(HryTest hryTest) {
        String actual = this._consolePromotionFacade_getPromotionRewardsInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/saveInvestRankActivity", dataProvider = "provider", description = "保存打榜活动")
    public void consolePromotionFacade_saveInvestRankActivity(HryTest hryTest) {
        String actual = this._consolePromotionFacade_saveInvestRankActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/updateInvestRankActivity", dataProvider = "provider", description = "更新打榜活动")
    public void consolePromotionFacade_updateInvestRankActivity(HryTest hryTest) {
        String actual = this._consolePromotionFacade_updateInvestRankActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/updateMerchantChannel", dataProvider = "provider", description = "修改商户活动渠道")
    public void consolePromotionFacade_updateMerchantChannel(HryTest hryTest) {
        String actual = this._consolePromotionFacade_updateMerchantChannel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/updatePromotionActivity", dataProvider = "provider", description = "更新活动信息")
    public void consolePromotionFacade_updatePromotionActivity(HryTest hryTest) {
        String actual = this._consolePromotionFacade_updatePromotionActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consolePromotionFacade/updatePromotionActivityRule", dataProvider = "provider", description = "更新活动规则")
    public void consolePromotionFacade_updatePromotionActivityRule(HryTest hryTest) {
        String actual = this._consolePromotionFacade_updatePromotionActivityRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/activateCoupon", dataProvider = "provider", description = "激活券")
    public void couponFacade_activateCoupon(HryTest hryTest) {
        String actual = this._couponFacade_activateCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/addBatchCoupon", dataProvider = "provider", description = "批量生成券/券包")
    public void couponFacade_addBatchCoupon(HryTest hryTest) {
        String actual = this._couponFacade_addBatchCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/addCouponCategory", dataProvider = "provider", description = "添加CouponCategory信息")
    public void couponFacade_addCouponCategory(HryTest hryTest) {
        String actual = this._couponFacade_addCouponCategory(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/addCouponGroup", dataProvider = "provider", description = "添加CouponGroup信息")
    public void couponFacade_addCouponGroup(HryTest hryTest) {
        String actual = this._couponFacade_addCouponGroup(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/addGrabCouponActivity", dataProvider = "provider", description = "新增领券活动")
    public void couponFacade_addGrabCouponActivity(HryTest hryTest) {
        String actual = this._couponFacade_addGrabCouponActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/addPrepaidCoupon", dataProvider = "provider", description = "新增抵扣券")
    public void couponFacade_addPrepaidCoupon(HryTest hryTest) {
        String actual = this._couponFacade_addPrepaidCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/auditBatchCoupon", dataProvider = "provider", description = "批量生成券审核")
    public void couponFacade_auditBatchCoupon(HryTest hryTest) {
        String actual = this._couponFacade_auditBatchCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/batchSendThirdPartyCoupon", dataProvider = "provider", description = "第三方券信息上传")
    public void couponFacade_batchSendThirdPartyCoupon(HryTest hryTest) {
        String actual = this._couponFacade_batchSendThirdPartyCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/deleteBatchCoupon", dataProvider = "provider", description = "批量生成券删除")
    public void couponFacade_deleteBatchCoupon(HryTest hryTest) {
        String actual = this._couponFacade_deleteBatchCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/exchangePrepaidCouponWithLcj", dataProvider = "provider", description = "抵用金兑换抵扣券")
    public void couponFacade_exchangePrepaidCouponWithLcj(HryTest hryTest) {
        String actual = this._couponFacade_exchangePrepaidCouponWithLcj(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/generateCouponRewards", dataProvider = "provider", description = "生成优惠券奖励，生成的Coupon状态为COUPON_INTERNAL_ACTIVITY")
    public void couponFacade_generateCouponRewards(HryTest hryTest) {
        String actual = this._couponFacade_generateCouponRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getAvailableCouponList", dataProvider = "provider", description = "查询当前产品可用券列表")
    public void couponFacade_getAvailableCouponList(HryTest hryTest) {
        String actual = this._couponFacade_getAvailableCouponList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getBatchCouponDetailList", dataProvider = "provider", description = "批量生成券查看(返回某一批次生成的券信息列表)")
    public void couponFacade_getBatchCouponDetailList(HryTest hryTest) {
        String actual = this._couponFacade_getBatchCouponDetailList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getBatchCouponList", dataProvider = "provider", description = "批量生成券/券包查询")
    public void couponFacade_getBatchCouponList(HryTest hryTest) {
        String actual = this._couponFacade_getBatchCouponList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getBidSubsidyValue", dataProvider = "provider", description = "查询投资加息金额")
    public void couponFacade_getBidSubsidyValue(HryTest hryTest) {
        String actual = this._couponFacade_getBidSubsidyValue(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCountForNonSendCoupon", dataProvider = "provider", description = "获取第三方券未发放的个数")
    public void couponFacade_getCountForNonSendCoupon(HryTest hryTest) {
        String actual = this._couponFacade_getCountForNonSendCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCoupon", dataProvider = "provider", description = "券使用情况查询")
    public void couponFacade_getCoupon(HryTest hryTest) {
        String actual = this._couponFacade_getCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponAmount", dataProvider = "provider", description = "券数量统计")
    public void couponFacade_getCouponAmount(HryTest hryTest) {
        String actual = this._couponFacade_getCouponAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponAndGroupItemList", dataProvider = "provider", description = "会员的券和券包信息")
    public void couponFacade_getCouponAndGroupItemList(HryTest hryTest) {
        String actual = this._couponFacade_getCouponAndGroupItemList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponCategory", dataProvider = "provider", description = "获取CouponCategory信息")
    public void couponFacade_getCouponCategory(HryTest hryTest) {
        String actual = this._couponFacade_getCouponCategory(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponCategoryAndGroupList", dataProvider = "provider", description = "获取CouponCategory/CouponGroup列表")
    public void couponFacade_getCouponCategoryAndGroupList(HryTest hryTest) {
        String actual = this._couponFacade_getCouponCategoryAndGroupList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponCategoryAndGroupListForActivity", dataProvider = "provider", description = "查询配置活动券/券包列表")
    public void couponFacade_getCouponCategoryAndGroupListForActivity(HryTest hryTest) {
        String actual = this._couponFacade_getCouponCategoryAndGroupListForActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponCategoryList", dataProvider = "provider", description = "获取CouponCategoryList信息")
    public void couponFacade_getCouponCategoryList(HryTest hryTest) {
        String actual = this._couponFacade_getCouponCategoryList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponDetailList", dataProvider = "provider", description = "券明细查询")
    public void couponFacade_getCouponDetailList(HryTest hryTest) {
        String actual = this._couponFacade_getCouponDetailList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponDoubledCategoryList", dataProvider = "provider", description = "获取CouponCategory信息")
    public void couponFacade_getCouponDoubledCategoryList(HryTest hryTest) {
        String actual = this._couponFacade_getCouponDoubledCategoryList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponGroup", dataProvider = "provider", description = "获取CouponGroup信息")
    public void couponFacade_getCouponGroup(HryTest hryTest) {
        String actual = this._couponFacade_getCouponGroup(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponSubsidyValue", dataProvider = "provider", description = "获取加息券收益")
    public void couponFacade_getCouponSubsidyValue(HryTest hryTest) {
        String actual = this._couponFacade_getCouponSubsidyValue(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getCouponValue", dataProvider = "provider", description = "券金额统计")
    public void couponFacade_getCouponValue(HryTest hryTest) {
        String actual = this._couponFacade_getCouponValue(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getExchangePrepaidCouponList", dataProvider = "provider", description = "获取可兑换的抵扣券列表")
    public void couponFacade_getExchangePrepaidCouponList(HryTest hryTest) {
        String actual = this._couponFacade_getExchangePrepaidCouponList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getGrabCouponActivity", dataProvider = "provider", description = "查看领券活动")
    public void couponFacade_getGrabCouponActivity(HryTest hryTest) {
        String actual = this._couponFacade_getGrabCouponActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getImportThirdPartyCoupon", dataProvider = "provider", description = "查询异业券文件列表")
    public void couponFacade_getImportThirdPartyCoupon(HryTest hryTest) {
        String actual = this._couponFacade_getImportThirdPartyCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getLcjExchangeRecordList", dataProvider = "provider", description = "获取已兑换记录")
    public void couponFacade_getLcjExchangeRecordList(HryTest hryTest) {
        String actual = this._couponFacade_getLcjExchangeRecordList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getPrepaidCouponInfo", dataProvider = "provider", description = "查询抵扣券信息")
    public void couponFacade_getPrepaidCouponInfo(HryTest hryTest) {
        String actual = this._couponFacade_getPrepaidCouponInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getReportThirdPartyCouponRewards", dataProvider = "provider", description = "查询异业券发放列表")
    public void couponFacade_getReportThirdPartyCouponRewards(HryTest hryTest) {
        String actual = this._couponFacade_getReportThirdPartyCouponRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getSummarizingPayout", dataProvider = "provider", description = "发放汇总")
    public void couponFacade_getSummarizingPayout(HryTest hryTest) {
        String actual = this._couponFacade_getSummarizingPayout(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getUnfulfilledSubsidy", dataProvider = "provider", description = "提前还款导致减少的贴息和加息")
    public void couponFacade_getUnfulfilledSubsidy(HryTest hryTest) {
        String actual = this._couponFacade_getUnfulfilledSubsidy(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getUsablePrepaidCouponList", dataProvider = "provider", description = "获取可用抵扣券列表")
    public void couponFacade_getUsablePrepaidCouponList(HryTest hryTest) {
        String actual = this._couponFacade_getUsablePrepaidCouponList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getUsedPrepaidCouponOrderList", dataProvider = "provider", description = "获取使用抵扣券订单列表")
    public void couponFacade_getUsedPrepaidCouponOrderList(HryTest hryTest) {
        String actual = this._couponFacade_getUsedPrepaidCouponOrderList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/getUsedSummarizing", dataProvider = "provider", description = "使用汇总")
    public void couponFacade_getUsedSummarizing(HryTest hryTest) {
        String actual = this._couponFacade_getUsedSummarizing(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/grabCoupon", dataProvider = "provider", description = "领取券")
    public void couponFacade_grabCoupon(HryTest hryTest) {
        String actual = this._couponFacade_grabCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/queryCouponList", dataProvider = "provider", description = "查询用户券信息列表")
    public void couponFacade_queryCouponList(HryTest hryTest) {
        String actual = this._couponFacade_queryCouponList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/queryGrabCouponActivity", dataProvider = "provider", description = "定时发放券查看")
    public void couponFacade_queryGrabCouponActivity(HryTest hryTest) {
        String actual = this._couponFacade_queryGrabCouponActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/queryGrabCouponSessionItem", dataProvider = "provider", description = "查询某一时间段有哪些奖励")
    public void couponFacade_queryGrabCouponSessionItem(HryTest hryTest) {
        String actual = this._couponFacade_queryGrabCouponSessionItem(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/queryGrabCouponSessionItemByDate", dataProvider = "provider", description = "查询某天有哪些奖励")
    public void couponFacade_queryGrabCouponSessionItemByDate(HryTest hryTest) {
        String actual = this._couponFacade_queryGrabCouponSessionItemByDate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/queryGrabCouponSessionSummary", dataProvider = "provider", description = "查询某一时间段有哪些场次（概要）")
    public void couponFacade_queryGrabCouponSessionSummary(HryTest hryTest) {
        String actual = this._couponFacade_queryGrabCouponSessionSummary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/queryMemberRewardList", dataProvider = "provider", description = "查询会员推广奖励-抵用券")
    public void couponFacade_queryMemberRewardList(HryTest hryTest) {
        String actual = this._couponFacade_queryMemberRewardList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/queryNextGrabCouponSessionItemByDate", dataProvider = "provider", description = "查询某天之后的第一天有哪些奖励")
    public void couponFacade_queryNextGrabCouponSessionItemByDate(HryTest hryTest) {
        String actual = this._couponFacade_queryNextGrabCouponSessionItemByDate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/refundCoupon", dataProvider = "provider", description = "券退款")
    public void couponFacade_refundCoupon(HryTest hryTest) {
        String actual = this._couponFacade_refundCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/updateCouponGroup", dataProvider = "provider", description = "编辑CouponGroup信息")
    public void couponFacade_updateCouponGroup(HryTest hryTest) {
        String actual = this._couponFacade_updateCouponGroup(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/updateGrabCouponActivity", dataProvider = "provider", description = "编辑领券活动")
    public void couponFacade_updateGrabCouponActivity(HryTest hryTest) {
        String actual = this._couponFacade_updateGrabCouponActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/updatePrepaidCoupon", dataProvider = "provider", description = "修改抵扣券")
    public void couponFacade_updatePrepaidCoupon(HryTest hryTest) {
        String actual = this._couponFacade_updatePrepaidCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/useCoupon", dataProvider = "provider", description = "券使用")
    public void couponFacade_useCoupon(HryTest hryTest) {
        String actual = this._couponFacade_useCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/couponFacade/validateCoupon", dataProvider = "provider", description = "券使用验证")
    public void couponFacade_validateCoupon(HryTest hryTest) {
        String actual = this._couponFacade_validateCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getRegisteredUserBehaviorData", dataProvider = "provider", description = "查询已注册用户行为数据")
    public void customerFacade_getRegisteredUserBehaviorData(HryTest hryTest) {
        String actual = this._customerFacade_getRegisteredUserBehaviorData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getUserType", dataProvider = "provider", description = "查询是否属于客服可跟进用户")
    public void customerFacade_getUserType(HryTest hryTest) {
        String actual = this._customerFacade_getUserType(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/queryChannelInfo", dataProvider = "provider", description = "查询渠道数据总览")
    public void customerFacade_queryChannelInfo(HryTest hryTest) {
        String actual = this._customerFacade_queryChannelInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/queryUserRegisterResult", dataProvider = "provider", description = "查询用户注册结果")
    public void customerFacade_queryUserRegisterResult(HryTest hryTest) {
        String actual = this._customerFacade_queryUserRegisterResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getGasProductList", dataProvider = "provider", description = "获取加油卡产品列表")
    public void juheFacade_getGasProductList(HryTest hryTest) {
        String actual = this._juheFacade_getGasProductList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getPaymentResult", dataProvider = "provider", description = "获取充值结果")
    public void juheFacade_getPaymentResult(HryTest hryTest) {
        String actual = this._juheFacade_getPaymentResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getPhoneCardProductList", dataProvider = "provider", description = "获取手机充值产品列表")
    public void juheFacade_getPhoneCardProductList(HryTest hryTest) {
        String actual = this._juheFacade_getPhoneCardProductList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getPhoneDataProductList", dataProvider = "provider", description = "获取手机流量产品列表")
    public void juheFacade_getPhoneDataProductList(HryTest hryTest) {
        String actual = this._juheFacade_getPhoneDataProductList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getProductDetailInfo", dataProvider = "provider", description = "获取产品详细信息")
    public void juheFacade_getProductDetailInfo(HryTest hryTest) {
        String actual = this._juheFacade_getProductDetailInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getProductList", dataProvider = "provider", description = "获取产品列表")
    public void juheFacade_getProductList(HryTest hryTest) {
        String actual = this._juheFacade_getProductList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getRechargeCardNumberRecords", dataProvider = "provider", description = "获取用户充值号码信息")
    public void juheFacade_getRechargeCardNumberRecords(HryTest hryTest) {
        String actual = this._juheFacade_getRechargeCardNumberRecords(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/getTradingRecords", dataProvider = "provider", description = "获取交易记录（充值记录）")
    public void juheFacade_getTradingRecords(HryTest hryTest) {
        String actual = this._juheFacade_getTradingRecords(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/juheFacade/purchaseProduct", dataProvider = "provider", description = "购买产品")
    public void juheFacade_purchaseProduct(HryTest hryTest) {
        String actual = this._juheFacade_purchaseProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanUnderUmbrellaFacade/addLoansUnderUmbrellaRegisterInfo", dataProvider = "provider", description = "增加伞下贷注册信息")
    public void loanUnderUmbrellaFacade_addLoansUnderUmbrellaRegisterInfo(HryTest hryTest) {
        String actual = this._loanUnderUmbrellaFacade_addLoansUnderUmbrellaRegisterInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lotteryFacade/drawLottery", dataProvider = "provider", description = "抽奖")
    public void lotteryFacade_drawLottery(HryTest hryTest) {
        String actual = this._lotteryFacade_drawLottery(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lotteryFacade/getLastLotteryRecord", dataProvider = "provider", description = "最近获奖列表")
    public void lotteryFacade_getLastLotteryRecord(HryTest hryTest) {
        String actual = this._lotteryFacade_getLastLotteryRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lotteryFacade/getLotteryQualification", dataProvider = "provider", description = "查询摇奖资格信息")
    public void lotteryFacade_getLotteryQualification(HryTest hryTest) {
        String actual = this._lotteryFacade_getLotteryQualification(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lotteryFacade/getLotteryRecord", dataProvider = "provider", description = "查询获奖记录")
    public void lotteryFacade_getLotteryRecord(HryTest hryTest) {
        String actual = this._lotteryFacade_getLotteryRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lotteryFacade/getTopInvestmentList", dataProvider = "provider", description = "用户年总投资金额排名列表")
    public void lotteryFacade_getTopInvestmentList(HryTest hryTest) {
        String actual = this._lotteryFacade_getTopInvestmentList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lotteryFacade/getUserInvestmentForLottery", dataProvider = "provider", description = "我的投资金额，根据当前抽奖活动决定时间范围")
    public void lotteryFacade_getUserInvestmentForLottery(HryTest hryTest) {
        String actual = this._lotteryFacade_getUserInvestmentForLottery(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/addUserMessage", dataProvider = "provider", description = "新增消息")
    public void memberLevelFacade_addUserMessage(HryTest hryTest) {
        String actual = this._memberLevelFacade_addUserMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/checkIn", dataProvider = "provider", description = "会员签到")
    public void memberLevelFacade_checkIn(HryTest hryTest) {
        String actual = this._memberLevelFacade_checkIn(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/deleteMemberMonthlyCouponRule", dataProvider = "provider", description = "删除会员每月返券权益规则")
    public void memberLevelFacade_deleteMemberMonthlyCouponRule(HryTest hryTest) {
        String actual = this._memberLevelFacade_deleteMemberMonthlyCouponRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/deleteMemberUpGradeRule", dataProvider = "provider", description = "删除会员每月返券权益规则")
    public void memberLevelFacade_deleteMemberUpGradeRule(HryTest hryTest) {
        String actual = this._memberLevelFacade_deleteMemberUpGradeRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getCheckInState", dataProvider = "provider", description = "查看用户某日是否签到")
    public void memberLevelFacade_getCheckInState(HryTest hryTest) {
        String actual = this._memberLevelFacade_getCheckInState(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getCheckInStatisticInfo", dataProvider = "provider", description = "查询用户签到统计信息")
    public void memberLevelFacade_getCheckInStatisticInfo(HryTest hryTest) {
        String actual = this._memberLevelFacade_getCheckInStatisticInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberCheckinActivityInfo", dataProvider = "provider", description = "查看会员签到活动信息")
    public void memberLevelFacade_getMemberCheckinActivityInfo(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberCheckinActivityInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberCheckinRuleList", dataProvider = "provider", description = "查看会员签到权益规则列表")
    public void memberLevelFacade_getMemberCheckinRuleList(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberCheckinRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberLevelActivity", dataProvider = "provider", description = "获取会员等级活动信息")
    public void memberLevelFacade_getMemberLevelActivity(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberLevelActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberLevelDetail", dataProvider = "provider", description = "获取会员等级详情")
    public void memberLevelFacade_getMemberLevelDetail(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberLevelDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberLevelDetailByLoginName", dataProvider = "provider", description = "根据登录名获取会员等级详情")
    public void memberLevelFacade_getMemberLevelDetailByLoginName(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberLevelDetailByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberLevelList", dataProvider = "provider", description = "查询会员等级规则列表")
    public void memberLevelFacade_getMemberLevelList(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberLevelList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberMonthlyCouponActivityInfo", dataProvider = "provider", description = "查看会员签到活动信息")
    public void memberLevelFacade_getMemberMonthlyCouponActivityInfo(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberMonthlyCouponActivityInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberMonthlyCouponRuleList", dataProvider = "provider", description = "查看会员规则列表")
    public void memberLevelFacade_getMemberMonthlyCouponRuleList(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberMonthlyCouponRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberRewardsStatisticInfo", dataProvider = "provider", description = "查询会员权益奖励统计信息")
    public void memberLevelFacade_getMemberRewardsStatisticInfo(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberRewardsStatisticInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberUpGradeActivityInfo", dataProvider = "provider", description = "查看会员升级活动信息")
    public void memberLevelFacade_getMemberUpGradeActivityInfo(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberUpGradeActivityInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/getMemberUpGradeRuleList", dataProvider = "provider", description = "查看会员规则列表")
    public void memberLevelFacade_getMemberUpGradeRuleList(HryTest hryTest) {
        String actual = this._memberLevelFacade_getMemberUpGradeRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/queryCheckInDays", dataProvider = "provider", description = "根据时间范围查询哪些天有签到信息")
    public void memberLevelFacade_queryCheckInDays(HryTest hryTest) {
        String actual = this._memberLevelFacade_queryCheckInDays(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/queryCheckInRewardsValue", dataProvider = "provider", description = "查询指定时间段累计签到金")
    public void memberLevelFacade_queryCheckInRewardsValue(HryTest hryTest) {
        String actual = this._memberLevelFacade_queryCheckInRewardsValue(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/queryRewardsInfoMessageList", dataProvider = "provider", description = "查看券奖励的消息列表")
    public void memberLevelFacade_queryRewardsInfoMessageList(HryTest hryTest) {
        String actual = this._memberLevelFacade_queryRewardsInfoMessageList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/queryUserMessageList", dataProvider = "provider", description = "查看消息列表")
    public void memberLevelFacade_queryUserMessageList(HryTest hryTest) {
        String actual = this._memberLevelFacade_queryUserMessageList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/readUserMessage", dataProvider = "provider", description = "读取消息")
    public void memberLevelFacade_readUserMessage(HryTest hryTest) {
        String actual = this._memberLevelFacade_readUserMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/saveMemberCheckinRule", dataProvider = "provider", description = "新增会员签到权益规则")
    public void memberLevelFacade_saveMemberCheckinRule(HryTest hryTest) {
        String actual = this._memberLevelFacade_saveMemberCheckinRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/saveMemberMonthlyCouponRule", dataProvider = "provider", description = "新增会员每月返券权益规则")
    public void memberLevelFacade_saveMemberMonthlyCouponRule(HryTest hryTest) {
        String actual = this._memberLevelFacade_saveMemberMonthlyCouponRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/saveMemberUpGradeRule", dataProvider = "provider", description = "新增礼包升级权益规则")
    public void memberLevelFacade_saveMemberUpGradeRule(HryTest hryTest) {
        String actual = this._memberLevelFacade_saveMemberUpGradeRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberLevelFacade/setMemberLevelList", dataProvider = "provider", description = "设置会员等级规则")
    public void memberLevelFacade_setMemberLevelList(HryTest hryTest) {
        String actual = this._memberLevelFacade_setMemberLevelList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/addMediaAd", dataProvider = "provider", description = "添加媒体广告信息")
    public void miscConsoleFacade_addMediaAd(HryTest hryTest) {
        String actual = this._miscConsoleFacade_addMediaAd(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/addMediaNews", dataProvider = "provider", description = "添加媒体新闻")
    public void miscConsoleFacade_addMediaNews(HryTest hryTest) {
        String actual = this._miscConsoleFacade_addMediaNews(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/appPushMessage", dataProvider = "provider", description = "app消息推送")
    public void miscConsoleFacade_appPushMessage(HryTest hryTest) {
        String actual = this._miscConsoleFacade_appPushMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/batchDeleteMediaNews", dataProvider = "provider", description = "批量删除媒体新闻")
    public void miscConsoleFacade_batchDeleteMediaNews(HryTest hryTest) {
        String actual = this._miscConsoleFacade_batchDeleteMediaNews(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/deleteMediaAd", dataProvider = "provider", description = "删除媒体广告信息")
    public void miscConsoleFacade_deleteMediaAd(HryTest hryTest) {
        String actual = this._miscConsoleFacade_deleteMediaAd(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/deleteMediaNews", dataProvider = "provider", description = "删除媒体新闻")
    public void miscConsoleFacade_deleteMediaNews(HryTest hryTest) {
        String actual = this._miscConsoleFacade_deleteMediaNews(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/getMediaAdById", dataProvider = "provider", description = "根据id获取媒体广告信息")
    public void miscConsoleFacade_getMediaAdById(HryTest hryTest) {
        String actual = this._miscConsoleFacade_getMediaAdById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/getMediaAdList", dataProvider = "provider", description = "获取媒体广告列表")
    public void miscConsoleFacade_getMediaAdList(HryTest hryTest) {
        String actual = this._miscConsoleFacade_getMediaAdList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/getMediaNews", dataProvider = "provider", description = "获取媒体新闻")
    public void miscConsoleFacade_getMediaNews(HryTest hryTest) {
        String actual = this._miscConsoleFacade_getMediaNews(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/queryMediaNews", dataProvider = "provider", description = "查询媒体新闻")
    public void miscConsoleFacade_queryMediaNews(HryTest hryTest) {
        String actual = this._miscConsoleFacade_queryMediaNews(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/queryMediaNewsList", dataProvider = "provider", description = "查询媒体新闻列表")
    public void miscConsoleFacade_queryMediaNewsList(HryTest hryTest) {
        String actual = this._miscConsoleFacade_queryMediaNewsList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/stickMediaAd", dataProvider = "provider", description = "置顶媒体广告信息")
    public void miscConsoleFacade_stickMediaAd(HryTest hryTest) {
        String actual = this._miscConsoleFacade_stickMediaAd(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/updateMediaAd", dataProvider = "provider", description = "编辑媒体广告信息信息")
    public void miscConsoleFacade_updateMediaAd(HryTest hryTest) {
        String actual = this._miscConsoleFacade_updateMediaAd(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/updateMediaNews", dataProvider = "provider", description = "更新媒体新闻")
    public void miscConsoleFacade_updateMediaNews(HryTest hryTest) {
        String actual = this._miscConsoleFacade_updateMediaNews(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscConsoleFacade/uploadImgFile", dataProvider = "provider", description = "上传图片")
    public void miscConsoleFacade_uploadImgFile(HryTest hryTest) {
        String actual = this._miscConsoleFacade_uploadImgFile(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/addAdvertisement", dataProvider = "provider", description = "新增广告信息")
    public void miscContentFacade_addAdvertisement(HryTest hryTest) {
        String actual = this._miscContentFacade_addAdvertisement(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/addMiscContent", dataProvider = "provider", description = "添加misc_content信息")
    public void miscContentFacade_addMiscContent(HryTest hryTest) {
        String actual = this._miscContentFacade_addMiscContent(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/batchAddOrModifyH5LandingPage", dataProvider = "provider", description = "批量新增/修改海融易H5 landingPage广告")
    public void miscContentFacade_batchAddOrModifyH5LandingPage(HryTest hryTest) {
        String actual = this._miscContentFacade_batchAddOrModifyH5LandingPage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/batchOfflineH5LandingPage", dataProvider = "provider", description = "批量下线海融易H5 landingPage广告")
    public void miscContentFacade_batchOfflineH5LandingPage(HryTest hryTest) {
        String actual = this._miscContentFacade_batchOfflineH5LandingPage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/deleteAdvertisement", dataProvider = "provider", description = "删除广告信息")
    public void miscContentFacade_deleteAdvertisement(HryTest hryTest) {
        String actual = this._miscContentFacade_deleteAdvertisement(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/deleteMiscContent", dataProvider = "provider", description = "删除misc_content信息")
    public void miscContentFacade_deleteMiscContent(HryTest hryTest) {
        String actual = this._miscContentFacade_deleteMiscContent(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/getAdvertisement", dataProvider = "provider", description = "获取广告信息")
    public void miscContentFacade_getAdvertisement(HryTest hryTest) {
        String actual = this._miscContentFacade_getAdvertisement(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/getMiscContent", dataProvider = "provider", description = "根据id获取misc_content信息")
    public void miscContentFacade_getMiscContent(HryTest hryTest) {
        String actual = this._miscContentFacade_getMiscContent(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/getMiscContentList", dataProvider = "provider", description = "获取misc_content列表")
    public void miscContentFacade_getMiscContentList(HryTest hryTest) {
        String actual = this._miscContentFacade_getMiscContentList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/offLineAdvertisement", dataProvider = "provider", description = "下线广告信息")
    public void miscContentFacade_offLineAdvertisement(HryTest hryTest) {
        String actual = this._miscContentFacade_offLineAdvertisement(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/queryAdvertisementList", dataProvider = "provider", description = "查询广告信息")
    public void miscContentFacade_queryAdvertisementList(HryTest hryTest) {
        String actual = this._miscContentFacade_queryAdvertisementList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/queryBidProductList", dataProvider = "provider", description = "查询标的产品列表")
    public void miscContentFacade_queryBidProductList(HryTest hryTest) {
        String actual = this._miscContentFacade_queryBidProductList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/queryRecommendBidList", dataProvider = "provider", description = "查询推荐标的信息")
    public void miscContentFacade_queryRecommendBidList(HryTest hryTest) {
        String actual = this._miscContentFacade_queryRecommendBidList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/queryRecommendBidProduct", dataProvider = "provider", description = "查询推荐标信息列表")
    public void miscContentFacade_queryRecommendBidProduct(HryTest hryTest) {
        String actual = this._miscContentFacade_queryRecommendBidProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/setRecommendBidList", dataProvider = "provider", description = "更新推荐标的信息")
    public void miscContentFacade_setRecommendBidList(HryTest hryTest) {
        String actual = this._miscContentFacade_setRecommendBidList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/sortAdvertisement", dataProvider = "provider", description = "排序广告信息")
    public void miscContentFacade_sortAdvertisement(HryTest hryTest) {
        String actual = this._miscContentFacade_sortAdvertisement(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/stickMiscContent", dataProvider = "provider", description = "置顶misc_content信息")
    public void miscContentFacade_stickMiscContent(HryTest hryTest) {
        String actual = this._miscContentFacade_stickMiscContent(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/updateAdvertisement", dataProvider = "provider", description = "编辑广告信息")
    public void miscContentFacade_updateAdvertisement(HryTest hryTest) {
        String actual = this._miscContentFacade_updateAdvertisement(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/updateMiscContent", dataProvider = "provider", description = "编辑misc_content信息")
    public void miscContentFacade_updateMiscContent(HryTest hryTest) {
        String actual = this._miscContentFacade_updateMiscContent(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/miscContentFacade/updateState", dataProvider = "provider", description = "编辑state信息")
    public void miscContentFacade_updateState(HryTest hryTest) {
        String actual = this._miscContentFacade_updateState(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/addActivateUserRule", dataProvider = "provider", description = "新增唤醒好友活动规则")
    public void promotionFacade_addActivateUserRule(HryTest hryTest) {
        String actual = this._promotionFacade_addActivateUserRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/addPaymentRebateRule", dataProvider = "provider", description = "新增投资完成抽奖活动规则")
    public void promotionFacade_addPaymentRebateRule(HryTest hryTest) {
        String actual = this._promotionFacade_addPaymentRebateRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/addPromotionChannel", dataProvider = "provider", description = "添加推广渠道信息")
    public void promotionFacade_addPromotionChannel(HryTest hryTest) {
        String actual = this._promotionFacade_addPromotionChannel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/addReturnMoneyRule", dataProvider = "provider", description = "新增回款奖励活动规则")
    public void promotionFacade_addReturnMoneyRule(HryTest hryTest) {
        String actual = this._promotionFacade_addReturnMoneyRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/checkActivatable", dataProvider = "provider", description = "检查某个用户是否能被唤醒")
    public void promotionFacade_checkActivatable(HryTest hryTest) {
        String actual = this._promotionFacade_checkActivatable(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/deleteActivateUserRule", dataProvider = "provider", description = "删除唤醒好友活动规则")
    public void promotionFacade_deleteActivateUserRule(HryTest hryTest) {
        String actual = this._promotionFacade_deleteActivateUserRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/deletePaymentRebateRule", dataProvider = "provider", description = "删除投资完成抽奖活动规则")
    public void promotionFacade_deletePaymentRebateRule(HryTest hryTest) {
        String actual = this._promotionFacade_deletePaymentRebateRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/deleteReturnMoneyRule", dataProvider = "provider", description = "删除回款奖励活动规则")
    public void promotionFacade_deleteReturnMoneyRule(HryTest hryTest) {
        String actual = this._promotionFacade_deleteReturnMoneyRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getActivatableUserByPromoter", dataProvider = "provider", description = "获取可以唤醒用户列表")
    public void promotionFacade_getActivatableUserByPromoter(HryTest hryTest) {
        String actual = this._promotionFacade_getActivatableUserByPromoter(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getActivateUserRule", dataProvider = "provider", description = "获取唤醒好友活动规则")
    public void promotionFacade_getActivateUserRule(HryTest hryTest) {
        String actual = this._promotionFacade_getActivateUserRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getDailyTaskList", dataProvider = "provider", description = "获取每日任务列表")
    public void promotionFacade_getDailyTaskList(HryTest hryTest) {
        String actual = this._promotionFacade_getDailyTaskList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getEndTimeWithThirdPartActivity", dataProvider = "provider", description = "获取第三方活动的结束时间")
    public void promotionFacade_getEndTimeWithThirdPartActivity(HryTest hryTest) {
        String actual = this._promotionFacade_getEndTimeWithThirdPartActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getInviteUserRewardsQuantity", dataProvider = "provider", description = "推荐人邀请用户首投活动获得奖励次数")
    public void promotionFacade_getInviteUserRewardsQuantity(HryTest hryTest) {
        String actual = this._promotionFacade_getInviteUserRewardsQuantity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPageActivityList", dataProvider = "provider", description = "获取活动列表: 1、extraInfo1==null: 查询全部推广; 2、extraInfo1==0: 查询普通推广; 3、其他: 查询商户推广")
    public void promotionFacade_getPageActivityList(HryTest hryTest) {
        String actual = this._promotionFacade_getPageActivityList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPaymentRebate", dataProvider = "provider", description = "投资完成获取未领奖奖励信息或者投资成功广告信息")
    public void promotionFacade_getPaymentRebate(HryTest hryTest) {
        String actual = this._promotionFacade_getPaymentRebate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPaymentRebateRewards", dataProvider = "provider", description = "领取投资返奖活动奖励")
    public void promotionFacade_getPaymentRebateRewards(HryTest hryTest) {
        String actual = this._promotionFacade_getPaymentRebateRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPaymentRebateRuleDetail", dataProvider = "provider", description = "查看投资完成抽奖活动规则")
    public void promotionFacade_getPaymentRebateRuleDetail(HryTest hryTest) {
        String actual = this._promotionFacade_getPaymentRebateRuleDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPromotionChannelList", dataProvider = "provider", description = "获取推广渠道列表")
    public void promotionFacade_getPromotionChannelList(HryTest hryTest) {
        String actual = this._promotionFacade_getPromotionChannelList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPromotionInvestRewardRuleList", dataProvider = "provider", description = "获取推广活动投资有奖规则列表")
    public void promotionFacade_getPromotionInvestRewardRuleList(HryTest hryTest) {
        String actual = this._promotionFacade_getPromotionInvestRewardRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPromotionRegisterReward", dataProvider = "provider", description = "获取用户已发放的注册奖励信息")
    public void promotionFacade_getPromotionRegisterReward(HryTest hryTest) {
        String actual = this._promotionFacade_getPromotionRegisterReward(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getPromotionUriInfo", dataProvider = "provider", description = "获取用户推广信息")
    public void promotionFacade_getPromotionUriInfo(HryTest hryTest) {
        String actual = this._promotionFacade_getPromotionUriInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getUserPromotionInfo", dataProvider = "provider", description = "根据推广码查询用户信息")
    public void promotionFacade_getUserPromotionInfo(HryTest hryTest) {
        String actual = this._promotionFacade_getUserPromotionInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getUserPromotionRewardsInfo", dataProvider = "provider", description = "获取某个用户的推荐奖励信息")
    public void promotionFacade_getUserPromotionRewardsInfo(HryTest hryTest) {
        String actual = this._promotionFacade_getUserPromotionRewardsInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/getUserSometimePromotionRewardsInfo", dataProvider = "provider", description = "获取某个用户某段时间内推荐用户而获得的奖励信息")
    public void promotionFacade_getUserSometimePromotionRewardsInfo(HryTest hryTest) {
        String actual = this._promotionFacade_getUserSometimePromotionRewardsInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/queryActivateUserRuleList", dataProvider = "provider", description = "查询唤醒好友活动规则列表")
    public void promotionFacade_queryActivateUserRuleList(HryTest hryTest) {
        String actual = this._promotionFacade_queryActivateUserRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/queryPaymentRebateRuleList", dataProvider = "provider", description = "查询投资完成抽奖活动规则列表")
    public void promotionFacade_queryPaymentRebateRuleList(HryTest hryTest) {
        String actual = this._promotionFacade_queryPaymentRebateRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/queryPromotionRelationList", dataProvider = "provider", description = "查询推广关系")
    public void promotionFacade_queryPromotionRelationList(HryTest hryTest) {
        String actual = this._promotionFacade_queryPromotionRelationList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/queryReturnMoneyRuleList", dataProvider = "provider", description = "查询回款奖励活动规则列表")
    public void promotionFacade_queryReturnMoneyRuleList(HryTest hryTest) {
        String actual = this._promotionFacade_queryReturnMoneyRuleList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/updateActivateUserRule", dataProvider = "provider", description = "编辑唤醒好友活动规则")
    public void promotionFacade_updateActivateUserRule(HryTest hryTest) {
        String actual = this._promotionFacade_updateActivateUserRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/updatePaymentRebateRule", dataProvider = "provider", description = "编辑投资完成抽奖活动规则")
    public void promotionFacade_updatePaymentRebateRule(HryTest hryTest) {
        String actual = this._promotionFacade_updatePaymentRebateRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotionFacade/updateReturnMoneyRule", dataProvider = "provider", description = "编辑回款奖励活动规则")
    public void promotionFacade_updateReturnMoneyRule(HryTest hryTest) {
        String actual = this._promotionFacade_updateReturnMoneyRule(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/addDepositRelation", dataProvider = "provider", description = "增加存管推荐关系")
    public void provisionalFacade_addDepositRelation(HryTest hryTest) {
        String actual = this._provisionalFacade_addDepositRelation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/addMeetingPlaceRecord", dataProvider = "provider", description = "参加线下见面会")
    public void provisionalFacade_addMeetingPlaceRecord(HryTest hryTest) {
        String actual = this._provisionalFacade_addMeetingPlaceRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/checkUserTeamFlag", dataProvider = "provider", description = "检查用户是否可以加入战队")
    public void provisionalFacade_checkUserTeamFlag(HryTest hryTest) {
        String actual = this._provisionalFacade_checkUserTeamFlag(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/drawCoupon", dataProvider = "provider", description = "领券")
    public void provisionalFacade_drawCoupon(HryTest hryTest) {
        String actual = this._provisionalFacade_drawCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/getCollectCardInfo", dataProvider = "provider", description = "获取用户集卡信息")
    public void provisionalFacade_getCollectCardInfo(HryTest hryTest) {
        String actual = this._provisionalFacade_getCollectCardInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/getDrawCouponFlag", dataProvider = "provider", description = "获取融易发专属领券活动领取状态")
    public void provisionalFacade_getDrawCouponFlag(HryTest hryTest) {
        String actual = this._provisionalFacade_getDrawCouponFlag(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/getLastCreateActivity", dataProvider = "provider", description = "查询最新创建的活动信息")
    public void provisionalFacade_getLastCreateActivity(HryTest hryTest) {
        String actual = this._provisionalFacade_getLastCreateActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/getThirdAnniversaryInvestRank", dataProvider = "provider", description = "查询用户三周年活动投资排名")
    public void provisionalFacade_getThirdAnniversaryInvestRank(HryTest hryTest) {
        String actual = this._provisionalFacade_getThirdAnniversaryInvestRank(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/joinTeam", dataProvider = "provider", description = "加入战队")
    public void provisionalFacade_joinTeam(HryTest hryTest) {
        String actual = this._provisionalFacade_joinTeam(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/joinWorldCupTeam", dataProvider = "provider", description = "加入世界杯比赛的战队")
    public void provisionalFacade_joinWorldCupTeam(HryTest hryTest) {
        String actual = this._provisionalFacade_joinWorldCupTeam(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryCollectCardStatisticRecord", dataProvider = "provider", description = "获取平台集卡活动统计信息")
    public void provisionalFacade_queryCollectCardStatisticRecord(HryTest hryTest) {
        String actual = this._provisionalFacade_queryCollectCardStatisticRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryDepositActivity", dataProvider = "provider", description = "查询存管的活动信息")
    public void provisionalFacade_queryDepositActivity(HryTest hryTest) {
        String actual = this._provisionalFacade_queryDepositActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryDepositRelationRewards", dataProvider = "provider", description = "查询存管推荐奖励信息")
    public void provisionalFacade_queryDepositRelationRewards(HryTest hryTest) {
        String actual = this._provisionalFacade_queryDepositRelationRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryGuoqingAvailableCoupon", dataProvider = "provider", description = "查询国庆活动可领取券")
    public void provisionalFacade_queryGuoqingAvailableCoupon(HryTest hryTest) {
        String actual = this._provisionalFacade_queryGuoqingAvailableCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryMeetingPlaceApply", dataProvider = "provider", description = "查询是否已经参加线下见面会")
    public void provisionalFacade_queryMeetingPlaceApply(HryTest hryTest) {
        String actual = this._provisionalFacade_queryMeetingPlaceApply(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/querySinglesDayTeamStatisticList", dataProvider = "provider", description = "获取双十一战队统计列表")
    public void provisionalFacade_querySinglesDayTeamStatisticList(HryTest hryTest) {
        String actual = this._provisionalFacade_querySinglesDayTeamStatisticList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/querySinglesDayUserStatisticInfo", dataProvider = "provider", description = "获取双十一个人信息记录")
    public void provisionalFacade_querySinglesDayUserStatisticInfo(HryTest hryTest) {
        String actual = this._provisionalFacade_querySinglesDayUserStatisticInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryThirdAnniversaryAvailableCoupon", dataProvider = "provider", description = "查询三周年活动可领取券")
    public void provisionalFacade_queryThirdAnniversaryAvailableCoupon(HryTest hryTest) {
        String actual = this._provisionalFacade_queryThirdAnniversaryAvailableCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryThirdAnniversaryInvestRankActivity", dataProvider = "provider", description = "查询三周年排行榜活动信息")
    public void provisionalFacade_queryThirdAnniversaryInvestRankActivity(HryTest hryTest) {
        String actual = this._provisionalFacade_queryThirdAnniversaryInvestRankActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryWorldCupGameRecords", dataProvider = "provider", description = "查询用户世界杯比赛战绩")
    public void provisionalFacade_queryWorldCupGameRecords(HryTest hryTest) {
        String actual = this._provisionalFacade_queryWorldCupGameRecords(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/queryWorldCupGames", dataProvider = "provider", description = "查询世界杯赛事信息")
    public void provisionalFacade_queryWorldCupGames(HryTest hryTest) {
        String actual = this._provisionalFacade_queryWorldCupGames(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/receivingGuoqingCoupon", dataProvider = "provider", description = "国庆活动领券")
    public void provisionalFacade_receivingGuoqingCoupon(HryTest hryTest) {
        String actual = this._provisionalFacade_receivingGuoqingCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/receivingThirdAnniversaryCoupon", dataProvider = "provider", description = "三周年活动领券")
    public void provisionalFacade_receivingThirdAnniversaryCoupon(HryTest hryTest) {
        String actual = this._provisionalFacade_receivingThirdAnniversaryCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/saveTmpInvitee", dataProvider = "provider", description = "保存被邀请者信息")
    public void provisionalFacade_saveTmpInvitee(HryTest hryTest) {
        String actual = this._provisionalFacade_saveTmpInvitee(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/provisionalFacade/updateSinglesDayUserStatisticsInfo", dataProvider = "provider", description = "更新个人投资统计记录")
    public void provisionalFacade_updateSinglesDayUserStatisticsInfo(HryTest hryTest) {
        String actual = this._provisionalFacade_updateSinglesDayUserStatisticsInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/reportFacade/queryMerchantRewardsReport", dataProvider = "provider", description = "商户推广返现总览")
    public void reportFacade_queryMerchantRewardsReport(HryTest hryTest) {
        String actual = this._reportFacade_queryMerchantRewardsReport(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/reportFacade/queryOrderSubsidyReport", dataProvider = "provider", description = "查询已发放加息券明细")
    public void reportFacade_queryOrderSubsidyReport(HryTest hryTest) {
        String actual = this._reportFacade_queryOrderSubsidyReport(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/batchSendRewards", dataProvider = "provider", description = "批量发放奖励请求")
    public void rewardsFacade_batchSendRewards(HryTest hryTest) {
        String actual = this._rewardsFacade_batchSendRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/getManualRewardsDetails", dataProvider = "provider", description = "查询人工发放奖励列明细")
    public void rewardsFacade_getManualRewardsDetails(HryTest hryTest) {
        String actual = this._rewardsFacade_getManualRewardsDetails(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/getManualRewardsList", dataProvider = "provider", description = "查询没有限制的人数的人工发放奖励列表")
    public void rewardsFacade_getManualRewardsList(HryTest hryTest) {
        String actual = this._rewardsFacade_getManualRewardsList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/getUserLcjDetail", dataProvider = "provider", description = "查询用户抵用金详情")
    public void rewardsFacade_getUserLcjDetail(HryTest hryTest) {
        String actual = this._rewardsFacade_getUserLcjDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/getUserProfitInfo", dataProvider = "provider", description = "获取用户收益信息（待收加速收益、已收加速收益、待收加息、已收加息）")
    public void rewardsFacade_getUserProfitInfo(HryTest hryTest) {
        String actual = this._rewardsFacade_getUserProfitInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/queryLcjListByStatus", dataProvider = "provider", description = "根据状态查询抵用金信息")
    public void rewardsFacade_queryLcjListByStatus(HryTest hryTest) {
        String actual = this._rewardsFacade_queryLcjListByStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/returnLcj", dataProvider = "provider", description = "抵用金退款")
    public void rewardsFacade_returnLcj(HryTest hryTest) {
        String actual = this._rewardsFacade_returnLcj(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/sendRewards", dataProvider = "provider", description = "手动发放抵用金奖励")
    public void rewardsFacade_sendRewards(HryTest hryTest) {
        String actual = this._rewardsFacade_sendRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rewardsFacade/useLcj", dataProvider = "provider", description = "使用抵用金")
    public void rewardsFacade_useLcj(HryTest hryTest) {
        String actual = this._rewardsFacade_useLcj(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/addShareActivity", dataProvider = "provider", description = "新增送祝福活动")
    public void shareActivityFacade_addShareActivity(HryTest hryTest) {
        String actual = this._shareActivityFacade_addShareActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/generateShareInfo", dataProvider = "provider", description = "生成新的分享信息")
    public void shareActivityFacade_generateShareInfo(HryTest hryTest) {
        String actual = this._shareActivityFacade_generateShareInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/getShareActivityInfo", dataProvider = "provider", description = "查询祝福活动相关信息")
    public void shareActivityFacade_getShareActivityInfo(HryTest hryTest) {
        String actual = this._shareActivityFacade_getShareActivityInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/getShareItemInfo", dataProvider = "provider", description = "获取分享信息")
    public void shareActivityFacade_getShareItemInfo(HryTest hryTest) {
        String actual = this._shareActivityFacade_getShareItemInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/getShareResult", dataProvider = "provider", description = "获取分享结果")
    public void shareActivityFacade_getShareResult(HryTest hryTest) {
        String actual = this._shareActivityFacade_getShareResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/receiveSharedItem", dataProvider = "provider", description = "收下祝福")
    public void shareActivityFacade_receiveSharedItem(HryTest hryTest) {
        String actual = this._shareActivityFacade_receiveSharedItem(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/recoverSharedItem", dataProvider = "provider", description = "撤销分享")
    public void shareActivityFacade_recoverSharedItem(HryTest hryTest) {
        String actual = this._shareActivityFacade_recoverSharedItem(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/shareActivityFacade/updateShareActivity", dataProvider = "provider", description = "修改送祝福活动")
    public void shareActivityFacade_updateShareActivity(HryTest hryTest) {
        String actual = this._shareActivityFacade_updateShareActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tpPromotionFacade/getDailyPromotionRewards", dataProvider = "provider", description = "查询奖励信息")
    public void tpPromotionFacade_getDailyPromotionRewards(HryTest hryTest) {
        String actual = this._tpPromotionFacade_getDailyPromotionRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tpPromotionFacade/getPromotionActivity", dataProvider = "provider", description = "查询活动信息")
    public void tpPromotionFacade_getPromotionActivity(HryTest hryTest) {
        String actual = this._tpPromotionFacade_getPromotionActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tpPromotionFacade/getPromotionRewards", dataProvider = "provider", description = "查询好友投资记录")
    public void tpPromotionFacade_getPromotionRewards(HryTest hryTest) {
        String actual = this._tpPromotionFacade_getPromotionRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tpPromotionFacade/getPromotionUri", dataProvider = "provider", description = "根据用户获取推广码（链接）")
    public void tpPromotionFacade_getPromotionUri(HryTest hryTest) {
        String actual = this._tpPromotionFacade_getPromotionUri(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tpPromotionFacade/getSummaryPromotionRewards", dataProvider = "provider", description = "查询奖励总额信息")
    public void tpPromotionFacade_getSummaryPromotionRewards(HryTest hryTest) {
        String actual = this._tpPromotionFacade_getSummaryPromotionRewards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tpPromotionFacade/rebindPromotionRelation", dataProvider = "provider", description = "重新绑定推广关系")
    public void tpPromotionFacade_rebindPromotionRelation(HryTest hryTest) {
        String actual = this._tpPromotionFacade_rebindPromotionRelation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/addHryIdMapper", dataProvider = "provider", description = "添加hry_id_mapper信息")
    public void userFacade_addHryIdMapper(HryTest hryTest) {
        String actual = this._userFacade_addHryIdMapper(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getInvestRankingDetail", dataProvider = "provider", description = "查询当前投资打榜活动")
    public void userFacade_getInvestRankingDetail(HryTest hryTest) {
        String actual = this._userFacade_getInvestRankingDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getPersonalInvestRank", dataProvider = "provider", description = "查询个人当前投资打榜信息")
    public void userFacade_getPersonalInvestRank(HryTest hryTest) {
        String actual = this._userFacade_getPersonalInvestRank(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserInvestRank", dataProvider = "provider", description = "查询用户投资排名")
    public void userFacade_getUserInvestRank(HryTest hryTest) {
        String actual = this._userFacade_getUserInvestRank(hryTest);
        supperAssert(actual, hryTest);
    }

}
