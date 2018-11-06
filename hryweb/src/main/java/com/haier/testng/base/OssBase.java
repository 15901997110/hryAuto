package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: OssBase
 * @Author: 自动生成
 * @Date: 2018/11/06 16:53:31
 */
@SKey("Oss")
public class OssBase extends Base {
    public OssBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/behaviorAnalysisFacade/addMarketingPushMessage", desc = "推送消息")
    public String _behaviorAnalysisFacade_addMarketingPushMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/behaviorAnalysisFacade/addMarketingSendRewards", desc = "发送奖励")
    public String _behaviorAnalysisFacade_addMarketingSendRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/behaviorAnalysisFacade/addMarketingSendSms", desc = "发送短信")
    public String _behaviorAnalysisFacade_addMarketingSendSms(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/behaviorAnalysisFacade/getAllUserBehaviorAnalysisResult", desc = "查询所有用户")
    public String _behaviorAnalysisFacade_getAllUserBehaviorAnalysisResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/behaviorAnalysisFacade/getBehaviorAnalysisResult", desc = "根据营销行为查询用户")
    public String _behaviorAnalysisFacade_getBehaviorAnalysisResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/behaviorAnalysisFacade/getMarketingBehaviorAnalysisRecord", desc = "获取查询的信息")
    public String _behaviorAnalysisFacade_getMarketingBehaviorAnalysisRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/behaviorAnalysisFacade/getMarketingBehaviorAnalysisRecordList", desc = "获取查询的信息分页列表")
    public String _behaviorAnalysisFacade_getMarketingBehaviorAnalysisRecordList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/addBlcakList", desc = "加入黑名单")
    public String _commonFacade_addBlcakList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/executeTask", desc = "执行任务")
    public String _commonFacade_executeTask(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/getAccountBalance", desc = "获取账户余额")
    public String _commonFacade_getAccountBalance(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/getAccountBalanceAlarm", desc = "获取账户预警金额")
    public String _commonFacade_getAccountBalanceAlarm(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/getFeatureWhiteList", desc = "根据hryid获取功能列表信息")
    public String _commonFacade_getFeatureWhiteList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/getOperatingAccountExpense", desc = "根据时间获取运营户支出信息")
    public String _commonFacade_getOperatingAccountExpense(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/getOperatingAccountRecharge", desc = "根据时间获取运营户支出信息")
    public String _commonFacade_getOperatingAccountRecharge(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/pushMessage", desc = "推送消息")
    public String _commonFacade_pushMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/sendSms", desc = "批量发送短信")
    public String _commonFacade_sendSms(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/commonFacade/setAccountBalanceAlarm", desc = "设置账户预警金额和邮箱")
    public String _commonFacade_setAccountBalanceAlarm(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/compensateFacade/addPrepaymentCompensateRecord", desc = "提前还款补偿")
    public String _compensateFacade_addPrepaymentCompensateRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/compensateFacade/addReservationCompensateRecord", desc = "预约补偿")
    public String _compensateFacade_addReservationCompensateRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleBirthFacade/deleteByBatchNo", desc = "删除活动活动规则")
    public String _consoleBirthFacade_deleteByBatchNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleBirthFacade/getBirthRuleByBatchNo", desc = "根据批次号查询生日特权规则")
    public String _consoleBirthFacade_getBirthRuleByBatchNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleBirthFacade/getBirthRuleByPromotionActivityId", desc = "根据活动ID查询生日特权规则")
    public String _consoleBirthFacade_getBirthRuleByPromotionActivityId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleBirthFacade/saveActivityRule", desc = "保存活动规则配置")
    public String _consoleBirthFacade_saveActivityRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleMemberLevelFacade/addMemberInvestRule", desc = "新增投资奖励权益规则")
    public String _consoleMemberLevelFacade_addMemberInvestRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleMemberLevelFacade/deleteMemberInvestRule", desc = "删除投资奖励权益规则")
    public String _consoleMemberLevelFacade_deleteMemberInvestRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleMemberLevelFacade/getMemberLevelList", desc = "查询会员等级规则列表")
    public String _consoleMemberLevelFacade_getMemberLevelList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleMemberLevelFacade/queryMemberInvestActivityRuleInfo", desc = "查询投资奖励权益活动和规则信息")
    public String _consoleMemberLevelFacade_queryMemberInvestActivityRuleInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleMemberLevelFacade/queryMemberInvestRule", desc = "查询投资奖励权益规则")
    public String _consoleMemberLevelFacade_queryMemberInvestRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleMemberLevelFacade/setMemberLevelList", desc = "设置会员等级规则")
    public String _consoleMemberLevelFacade_setMemberLevelList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consoleMemberLevelFacade/updateMemberInvestRule", desc = "更新投资奖励权益规则")
    public String _consoleMemberLevelFacade_updateMemberInvestRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/addBlackList", desc = "新增黑名单")
    public String _consolePromotionFacade_addBlackList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/addMerchantChannel", desc = "新增商户活动渠道")
    public String _consolePromotionFacade_addMerchantChannel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/addPromotionActivity", desc = "新增活动信息")
    public String _consolePromotionFacade_addPromotionActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/addPromotionActivityRule", desc = "新增活动规则")
    public String _consolePromotionFacade_addPromotionActivityRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/deleteBlackList", desc = "删除黑名单")
    public String _consolePromotionFacade_deleteBlackList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/deletePromotionActivityRule", desc = "删除活动规则")
    public String _consolePromotionFacade_deletePromotionActivityRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getInvestRankActivity", desc = "查询打榜活动")
    public String _consolePromotionFacade_getInvestRankActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getMerchantChannel", desc = "查询商户渠道信息")
    public String _consolePromotionFacade_getMerchantChannel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getMerchantChannelList", desc = "查询商户渠道列表")
    public String _consolePromotionFacade_getMerchantChannelList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getPromotionActivity", desc = "查询活动信息")
    public String _consolePromotionFacade_getPromotionActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getPromotionActivityDetail", desc = "查看推广活动活动及其活动规则信息")
    public String _consolePromotionFacade_getPromotionActivityDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getPromotionActivityList", desc = "获取推广活动列表: 1、渠道ID为空: 查询全部推广; 2、渠道ID为0: 查询普通推广; 3、其他渠道ID: 查询商户推广;")
    public String _consolePromotionFacade_getPromotionActivityList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getPromotionActivityRule", desc = "查看活动规则")
    public String _consolePromotionFacade_getPromotionActivityRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getPromotionActivityRuleList", desc = "查看推广活动规则列表")
    public String _consolePromotionFacade_getPromotionActivityRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/getPromotionRewardsInfo", desc = "查询推广活动奖励统计信息")
    public String _consolePromotionFacade_getPromotionRewardsInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/queryBlackList", desc = "查询黑名单")
    public String _consolePromotionFacade_queryBlackList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/saveInvestRankActivity", desc = "保存打榜活动")
    public String _consolePromotionFacade_saveInvestRankActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/updateInvestRankActivity", desc = "更新打榜活动")
    public String _consolePromotionFacade_updateInvestRankActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/updateMerchantChannel", desc = "修改商户活动渠道")
    public String _consolePromotionFacade_updateMerchantChannel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/updatePromotionActivity", desc = "更新活动信息")
    public String _consolePromotionFacade_updatePromotionActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consolePromotionFacade/updatePromotionActivityRule", desc = "更新活动规则")
    public String _consolePromotionFacade_updatePromotionActivityRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/activateCoupon", desc = "激活券")
    public String _couponFacade_activateCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/addBatchCoupon", desc = "批量生成券/券包")
    public String _couponFacade_addBatchCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/addCouponCategory", desc = "添加CouponCategory信息")
    public String _couponFacade_addCouponCategory(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/addCouponGroup", desc = "添加CouponGroup信息")
    public String _couponFacade_addCouponGroup(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/addGrabCouponActivity", desc = "新增领券活动")
    public String _couponFacade_addGrabCouponActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/addPrepaidCoupon", desc = "新增抵扣券")
    public String _couponFacade_addPrepaidCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/auditBatchCoupon", desc = "批量生成券审核")
    public String _couponFacade_auditBatchCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/batchSendThirdPartyCoupon", desc = "第三方券信息上传")
    public String _couponFacade_batchSendThirdPartyCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/deleteBatchCoupon", desc = "批量生成券删除")
    public String _couponFacade_deleteBatchCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/exchangePrepaidCouponWithLcj", desc = "抵用金兑换抵扣券")
    public String _couponFacade_exchangePrepaidCouponWithLcj(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/freezeCoupon", desc = "冻结券")
    public String _couponFacade_freezeCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/generateCouponRewards", desc = "生成优惠券奖励，生成的Coupon状态为COUPON_INTERNAL_ACTIVITY")
    public String _couponFacade_generateCouponRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getAvailableCouponList", desc = "查询当前产品可用券列表")
    public String _couponFacade_getAvailableCouponList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getAvailableRewardsListForBid", desc = "查询用户智能标的可用券")
    public String _couponFacade_getAvailableRewardsListForBid(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getBatchCouponDetailList", desc = "批量生成券查看(返回某一批次生成的券信息列表)")
    public String _couponFacade_getBatchCouponDetailList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getBatchCouponList", desc = "批量生成券/券包查询")
    public String _couponFacade_getBatchCouponList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getBidSubsidyValue", desc = "查询投资加息金额")
    public String _couponFacade_getBidSubsidyValue(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCountForNonSendCoupon", desc = "获取第三方券未发放的个数")
    public String _couponFacade_getCountForNonSendCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCoupon", desc = "券使用情况查询")
    public String _couponFacade_getCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponAmount", desc = "券数量统计")
    public String _couponFacade_getCouponAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponAndGroupItemList", desc = "会员的券和券包信息")
    public String _couponFacade_getCouponAndGroupItemList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponCategory", desc = "获取CouponCategory信息")
    public String _couponFacade_getCouponCategory(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponCategoryAndGroupList", desc = "获取CouponCategory/CouponGroup列表")
    public String _couponFacade_getCouponCategoryAndGroupList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponCategoryAndGroupListForActivity", desc = "查询配置活动券/券包列表")
    public String _couponFacade_getCouponCategoryAndGroupListForActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponCategoryList", desc = "获取CouponCategoryList信息")
    public String _couponFacade_getCouponCategoryList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponDetailList", desc = "券明细查询")
    public String _couponFacade_getCouponDetailList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponDoubledCategoryList", desc = "获取CouponCategory信息")
    public String _couponFacade_getCouponDoubledCategoryList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponGroup", desc = "获取CouponGroup信息")
    public String _couponFacade_getCouponGroup(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponSubsidyValue", desc = "获取加息券收益")
    public String _couponFacade_getCouponSubsidyValue(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getCouponValue", desc = "券金额统计")
    public String _couponFacade_getCouponValue(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getExchangePrepaidCouponList", desc = "获取可兑换的抵扣券列表")
    public String _couponFacade_getExchangePrepaidCouponList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getGrabCouponActivity", desc = "查看领券活动")
    public String _couponFacade_getGrabCouponActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getImportThirdPartyCoupon", desc = "查询异业券文件列表")
    public String _couponFacade_getImportThirdPartyCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getLcjExchangeRecordList", desc = "获取已兑换记录")
    public String _couponFacade_getLcjExchangeRecordList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getPrepaidCouponInfo", desc = "查询抵扣券信息")
    public String _couponFacade_getPrepaidCouponInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getReportThirdPartyCouponRewards", desc = "查询异业券发放列表")
    public String _couponFacade_getReportThirdPartyCouponRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getSummarizingPayout", desc = "发放汇总")
    public String _couponFacade_getSummarizingPayout(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getUnfulfilledSubsidy", desc = "提前还款导致减少的贴息和加息")
    public String _couponFacade_getUnfulfilledSubsidy(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getUsablePrepaidCouponList", desc = "获取可用抵扣券列表")
    public String _couponFacade_getUsablePrepaidCouponList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getUsedPrepaidCouponOrderList", desc = "获取使用抵扣券订单列表")
    public String _couponFacade_getUsedPrepaidCouponOrderList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/getUsedSummarizing", desc = "使用汇总")
    public String _couponFacade_getUsedSummarizing(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/grabCoupon", desc = "领取券")
    public String _couponFacade_grabCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryCouponList", desc = "查询用户券信息列表")
    public String _couponFacade_queryCouponList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryFreezeRewards", desc = "查询冻结奖励")
    public String _couponFacade_queryFreezeRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryGrabCouponActivity", desc = "定时发放券查看")
    public String _couponFacade_queryGrabCouponActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryGrabCouponSessionItem", desc = "查询某一时间段有哪些奖励")
    public String _couponFacade_queryGrabCouponSessionItem(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryGrabCouponSessionItemByDate", desc = "查询某天有哪些奖励")
    public String _couponFacade_queryGrabCouponSessionItemByDate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryGrabCouponSessionSummary", desc = "查询某一时间段有哪些场次（概要）")
    public String _couponFacade_queryGrabCouponSessionSummary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryMemberRewardList", desc = "查询会员推广奖励-抵用券")
    public String _couponFacade_queryMemberRewardList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/queryNextGrabCouponSessionItemByDate", desc = "查询某天之后的第一天有哪些奖励")
    public String _couponFacade_queryNextGrabCouponSessionItemByDate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/refundCoupon", desc = "券退款")
    public String _couponFacade_refundCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/unFreezeCoupon", desc = "解冻券")
    public String _couponFacade_unFreezeCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/updateCouponGroup", desc = "编辑CouponGroup信息")
    public String _couponFacade_updateCouponGroup(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/updateGrabCouponActivity", desc = "编辑领券活动")
    public String _couponFacade_updateGrabCouponActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/updatePrepaidCoupon", desc = "修改抵扣券")
    public String _couponFacade_updatePrepaidCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/useCoupon", desc = "券使用")
    public String _couponFacade_useCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/couponFacade/validateCoupon", desc = "券使用验证")
    public String _couponFacade_validateCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getGasProductList", desc = "获取加油卡产品列表")
    public String _juheFacade_getGasProductList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getPaymentResult", desc = "获取充值结果")
    public String _juheFacade_getPaymentResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getPhoneCardProductList", desc = "获取手机充值产品列表")
    public String _juheFacade_getPhoneCardProductList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getPhoneDataProductList", desc = "获取手机流量产品列表")
    public String _juheFacade_getPhoneDataProductList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getProductDetailInfo", desc = "获取产品详细信息")
    public String _juheFacade_getProductDetailInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getProductList", desc = "获取产品列表")
    public String _juheFacade_getProductList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getRechargeCardNumberRecords", desc = "获取用户充值号码信息")
    public String _juheFacade_getRechargeCardNumberRecords(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/getTradingRecords", desc = "获取交易记录（充值记录）")
    public String _juheFacade_getTradingRecords(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juheFacade/purchaseProduct", desc = "购买产品")
    public String _juheFacade_purchaseProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanUnderUmbrellaFacade/addLoansUnderUmbrellaRegisterInfo", desc = "增加伞下贷注册信息")
    public String _loanUnderUmbrellaFacade_addLoansUnderUmbrellaRegisterInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lotteryFacade/drawLottery", desc = "抽奖")
    public String _lotteryFacade_drawLottery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lotteryFacade/getLastLotteryRecord", desc = "最近获奖列表")
    public String _lotteryFacade_getLastLotteryRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lotteryFacade/getLotteryQualification", desc = "查询摇奖资格信息")
    public String _lotteryFacade_getLotteryQualification(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lotteryFacade/getLotteryRecord", desc = "查询获奖记录")
    public String _lotteryFacade_getLotteryRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lotteryFacade/getTopInvestmentList", desc = "用户年总投资金额排名列表")
    public String _lotteryFacade_getTopInvestmentList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lotteryFacade/getUserInvestmentForLottery", desc = "我的投资金额，根据当前抽奖活动决定时间范围")
    public String _lotteryFacade_getUserInvestmentForLottery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/addUserMessage", desc = "新增消息")
    public String _memberLevelFacade_addUserMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/checkIn", desc = "会员签到")
    public String _memberLevelFacade_checkIn(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/deleteMemberMonthlyCouponRule", desc = "删除会员每月返券权益规则")
    public String _memberLevelFacade_deleteMemberMonthlyCouponRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/deleteMemberUpGradeRule", desc = "删除会员每月返券权益规则")
    public String _memberLevelFacade_deleteMemberUpGradeRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getCheckInSeriesInfo", desc = "获取会员连续签到信息")
    public String _memberLevelFacade_getCheckInSeriesInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getCheckInState", desc = "查看用户某日是否签到")
    public String _memberLevelFacade_getCheckInState(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getCheckInStatisticInfo", desc = "查询用户签到统计信息")
    public String _memberLevelFacade_getCheckInStatisticInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberCheckinActivityInfo", desc = "查看会员签到活动信息")
    public String _memberLevelFacade_getMemberCheckinActivityInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberCheckinRuleList", desc = "查看会员签到权益规则列表")
    public String _memberLevelFacade_getMemberCheckinRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberLevelActivity", desc = "获取会员等级活动信息")
    public String _memberLevelFacade_getMemberLevelActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberLevelDetail", desc = "获取会员等级详情")
    public String _memberLevelFacade_getMemberLevelDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberLevelDetailByLoginName", desc = "根据登录名获取会员等级详情")
    public String _memberLevelFacade_getMemberLevelDetailByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberLevelList", desc = "查询会员等级规则列表")
    public String _memberLevelFacade_getMemberLevelList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberLevelPointHistory", desc = "获取会员历史积分变动")
    public String _memberLevelFacade_getMemberLevelPointHistory(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberLevelPointTrend", desc = "获取会员积分趋势")
    public String _memberLevelFacade_getMemberLevelPointTrend(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberMonthlyCouponActivityInfo", desc = "查看会员每月返券活动信息")
    public String _memberLevelFacade_getMemberMonthlyCouponActivityInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberMonthlyCouponRuleList", desc = "查看会员规则列表")
    public String _memberLevelFacade_getMemberMonthlyCouponRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberPrivilege", desc = "查看当前用户等级参与活动规则信息")
    public String _memberLevelFacade_getMemberPrivilege(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberRewardsStatisticInfo", desc = "查询会员权益奖励统计信息")
    public String _memberLevelFacade_getMemberRewardsStatisticInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberUpGradeActivityInfo", desc = "查看会员升级活动信息")
    public String _memberLevelFacade_getMemberUpGradeActivityInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/getMemberUpGradeRuleList", desc = "查看会员升级规则列表")
    public String _memberLevelFacade_getMemberUpGradeRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/queryCheckInDays", desc = "根据时间范围查询哪些天有签到信息")
    public String _memberLevelFacade_queryCheckInDays(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/queryCheckInRewardsValue", desc = "查询指定时间段累计签到金")
    public String _memberLevelFacade_queryCheckInRewardsValue(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/queryMemberLevelRewards", desc = "查询会员权益奖励信息")
    public String _memberLevelFacade_queryMemberLevelRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/queryRewardsInfoMessageList", desc = "查看券奖励的消息列表")
    public String _memberLevelFacade_queryRewardsInfoMessageList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/queryUserMessageList", desc = "查看消息列表")
    public String _memberLevelFacade_queryUserMessageList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/readUserMessage", desc = "读取消息")
    public String _memberLevelFacade_readUserMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/saveMemberCheckinRule", desc = "新增会员签到权益规则")
    public String _memberLevelFacade_saveMemberCheckinRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/saveMemberMonthlyCouponRule", desc = "新增会员每月返券权益规则")
    public String _memberLevelFacade_saveMemberMonthlyCouponRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/saveMemberUpGradeRule", desc = "新增礼包升级权益规则")
    public String _memberLevelFacade_saveMemberUpGradeRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberLevelFacade/setMemberLevelList", desc = "设置会员等级规则")
    public String _memberLevelFacade_setMemberLevelList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/addMediaAd", desc = "添加媒体广告信息")
    public String _miscConsoleFacade_addMediaAd(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/addMediaNews", desc = "添加媒体新闻")
    public String _miscConsoleFacade_addMediaNews(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/appPushMessage", desc = "app消息推送")
    public String _miscConsoleFacade_appPushMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/batchDeleteMediaNews", desc = "批量删除媒体新闻")
    public String _miscConsoleFacade_batchDeleteMediaNews(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/deleteMediaAd", desc = "删除媒体广告信息")
    public String _miscConsoleFacade_deleteMediaAd(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/deleteMediaNews", desc = "删除媒体新闻")
    public String _miscConsoleFacade_deleteMediaNews(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/getMediaAdById", desc = "根据id获取媒体广告信息")
    public String _miscConsoleFacade_getMediaAdById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/getMediaAdList", desc = "获取媒体广告列表")
    public String _miscConsoleFacade_getMediaAdList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/getMediaNews", desc = "获取媒体新闻")
    public String _miscConsoleFacade_getMediaNews(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/queryMediaNews", desc = "查询媒体新闻")
    public String _miscConsoleFacade_queryMediaNews(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/queryMediaNewsList", desc = "查询媒体新闻列表")
    public String _miscConsoleFacade_queryMediaNewsList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/stickMediaAd", desc = "置顶媒体广告信息")
    public String _miscConsoleFacade_stickMediaAd(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/updateMediaAd", desc = "编辑媒体广告信息信息")
    public String _miscConsoleFacade_updateMediaAd(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/updateMediaNews", desc = "更新媒体新闻")
    public String _miscConsoleFacade_updateMediaNews(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscConsoleFacade/uploadImgFile", desc = "上传图片")
    public String _miscConsoleFacade_uploadImgFile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/addAdvertisement", desc = "新增广告信息")
    public String _miscContentFacade_addAdvertisement(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/addMiscContent", desc = "添加misc_content信息")
    public String _miscContentFacade_addMiscContent(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/batchAddOrModifyH5LandingPage", desc = "批量新增/修改海融易H5 landingPage广告")
    public String _miscContentFacade_batchAddOrModifyH5LandingPage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/batchOfflineH5LandingPage", desc = "批量下线海融易H5 landingPage广告")
    public String _miscContentFacade_batchOfflineH5LandingPage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/deleteAdvertisement", desc = "删除广告信息")
    public String _miscContentFacade_deleteAdvertisement(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/deleteMiscContent", desc = "删除misc_content信息")
    public String _miscContentFacade_deleteMiscContent(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/getAdvertisement", desc = "获取广告信息")
    public String _miscContentFacade_getAdvertisement(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/getMiscContent", desc = "根据id获取misc_content信息")
    public String _miscContentFacade_getMiscContent(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/getMiscContentList", desc = "获取misc_content列表")
    public String _miscContentFacade_getMiscContentList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/offLineAdvertisement", desc = "下线广告信息")
    public String _miscContentFacade_offLineAdvertisement(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/queryAdvertisementList", desc = "查询广告信息")
    public String _miscContentFacade_queryAdvertisementList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/queryBidProductList", desc = "查询标的产品列表")
    public String _miscContentFacade_queryBidProductList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/queryRecommendBidList", desc = "查询推荐标的信息")
    public String _miscContentFacade_queryRecommendBidList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/queryRecommendBidProduct", desc = "查询推荐标信息列表")
    public String _miscContentFacade_queryRecommendBidProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/setRecommendBidList", desc = "更新推荐标的信息")
    public String _miscContentFacade_setRecommendBidList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/sortAdvertisement", desc = "排序广告信息")
    public String _miscContentFacade_sortAdvertisement(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/stickMiscContent", desc = "置顶misc_content信息")
    public String _miscContentFacade_stickMiscContent(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/updateAdvertisement", desc = "编辑广告信息")
    public String _miscContentFacade_updateAdvertisement(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/updateMiscContent", desc = "编辑misc_content信息")
    public String _miscContentFacade_updateMiscContent(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/miscContentFacade/updateState", desc = "编辑state信息")
    public String _miscContentFacade_updateState(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/addActivateUserRule", desc = "新增唤醒好友活动规则")
    public String _promotionFacade_addActivateUserRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/addPaymentRebateRule", desc = "新增投资完成抽奖活动规则")
    public String _promotionFacade_addPaymentRebateRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/addPromotionChannel", desc = "添加推广渠道信息")
    public String _promotionFacade_addPromotionChannel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/addReturnMoneyRule", desc = "新增回款奖励活动规则")
    public String _promotionFacade_addReturnMoneyRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/checkActivatable", desc = "检查某个用户是否能被唤醒")
    public String _promotionFacade_checkActivatable(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/deleteActivateUserRule", desc = "删除唤醒好友活动规则")
    public String _promotionFacade_deleteActivateUserRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/deletePaymentRebateRule", desc = "删除投资完成抽奖活动规则")
    public String _promotionFacade_deletePaymentRebateRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/deleteReturnMoneyRule", desc = "删除回款奖励活动规则")
    public String _promotionFacade_deleteReturnMoneyRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getActivatableUserByPromoter", desc = "获取可以唤醒用户列表")
    public String _promotionFacade_getActivatableUserByPromoter(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getActivateUserRule", desc = "获取唤醒好友活动规则")
    public String _promotionFacade_getActivateUserRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getDailyTaskList", desc = "获取每日任务列表")
    public String _promotionFacade_getDailyTaskList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getEndTimeWithThirdPartActivity", desc = "获取第三方活动的结束时间")
    public String _promotionFacade_getEndTimeWithThirdPartActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getInviteUserRewardsQuantity", desc = "推荐人邀请用户首投活动获得奖励次数")
    public String _promotionFacade_getInviteUserRewardsQuantity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPageActivityList", desc = "获取活动列表: 1、extraInfo1==null: 查询全部推广; 2、extraInfo1==0: 查询普通推广; 3、其他: 查询商户推广")
    public String _promotionFacade_getPageActivityList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPaymentRebate", desc = "投资完成获取未领奖奖励信息或者投资成功广告信息")
    public String _promotionFacade_getPaymentRebate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPaymentRebateRewards", desc = "领取投资返奖活动奖励")
    public String _promotionFacade_getPaymentRebateRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPaymentRebateRuleDetail", desc = "查看投资完成抽奖活动规则")
    public String _promotionFacade_getPaymentRebateRuleDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPromotionChannelList", desc = "获取推广渠道列表")
    public String _promotionFacade_getPromotionChannelList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPromotionInvestRewardRuleList", desc = "获取推广活动投资有奖规则列表")
    public String _promotionFacade_getPromotionInvestRewardRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPromotionRegisterReward", desc = "获取用户已发放的注册奖励信息")
    public String _promotionFacade_getPromotionRegisterReward(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getPromotionUriInfo", desc = "获取用户推广信息")
    public String _promotionFacade_getPromotionUriInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getUserPromotionInfo", desc = "根据推广码查询用户信息")
    public String _promotionFacade_getUserPromotionInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getUserPromotionRewardsInfo", desc = "获取某个用户的推荐奖励信息")
    public String _promotionFacade_getUserPromotionRewardsInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/getUserSometimePromotionRewardsInfo", desc = "获取某个用户某段时间内推荐用户而获得的奖励信息")
    public String _promotionFacade_getUserSometimePromotionRewardsInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/queryActivateUserRuleList", desc = "查询唤醒好友活动规则列表")
    public String _promotionFacade_queryActivateUserRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/queryPaymentRebateRuleList", desc = "查询投资完成抽奖活动规则列表")
    public String _promotionFacade_queryPaymentRebateRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/queryPromotionActivityRewards", desc = "查询推广奖励")
    public String _promotionFacade_queryPromotionActivityRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/queryPromotionRelationList", desc = "查询推广关系")
    public String _promotionFacade_queryPromotionRelationList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/queryReturnMoneyRuleList", desc = "查询回款奖励活动规则列表")
    public String _promotionFacade_queryReturnMoneyRuleList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/updateActivateUserRule", desc = "编辑唤醒好友活动规则")
    public String _promotionFacade_updateActivateUserRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/updatePaymentRebateRule", desc = "编辑投资完成抽奖活动规则")
    public String _promotionFacade_updatePaymentRebateRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotionFacade/updateReturnMoneyRule", desc = "编辑回款奖励活动规则")
    public String _promotionFacade_updateReturnMoneyRule(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/addDepositRelation", desc = "增加存管推荐关系")
    public String _provisionalFacade_addDepositRelation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/addMeetingPlaceRecord", desc = "参加线下见面会")
    public String _provisionalFacade_addMeetingPlaceRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/checkUserTeamFlag", desc = "检查用户是否可以加入战队")
    public String _provisionalFacade_checkUserTeamFlag(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/drawCoupon", desc = "领券")
    public String _provisionalFacade_drawCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/getCollectCardInfo", desc = "获取用户集卡信息")
    public String _provisionalFacade_getCollectCardInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/getDrawCouponFlag", desc = "获取融易发专属领券活动领取状态")
    public String _provisionalFacade_getDrawCouponFlag(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/getLastCreateActivity", desc = "查询最新创建的活动信息")
    public String _provisionalFacade_getLastCreateActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/getThirdAnniversaryInvestRank", desc = "查询用户三周年活动投资排名")
    public String _provisionalFacade_getThirdAnniversaryInvestRank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/joinTeam", desc = "加入战队")
    public String _provisionalFacade_joinTeam(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/joinWorldCupTeam", desc = "加入世界杯比赛的战队")
    public String _provisionalFacade_joinWorldCupTeam(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryCollectCardStatisticRecord", desc = "获取平台集卡活动统计信息")
    public String _provisionalFacade_queryCollectCardStatisticRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryDepositActivity", desc = "查询存管的活动信息")
    public String _provisionalFacade_queryDepositActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryDepositRelationRewards", desc = "查询存管推荐奖励信息")
    public String _provisionalFacade_queryDepositRelationRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryGuoqingAvailableCoupon", desc = "查询国庆活动可领取券")
    public String _provisionalFacade_queryGuoqingAvailableCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryMeetingPlaceApply", desc = "查询是否已经参加线下见面会")
    public String _provisionalFacade_queryMeetingPlaceApply(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/querySinglesDayTeamStatisticList", desc = "获取双十一战队统计列表")
    public String _provisionalFacade_querySinglesDayTeamStatisticList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/querySinglesDayUserStatisticInfo", desc = "获取双十一个人信息记录")
    public String _provisionalFacade_querySinglesDayUserStatisticInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryThirdAnniversaryAvailableCoupon", desc = "查询三周年活动可领取券")
    public String _provisionalFacade_queryThirdAnniversaryAvailableCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryThirdAnniversaryInvestRankActivity", desc = "查询三周年排行榜活动信息")
    public String _provisionalFacade_queryThirdAnniversaryInvestRankActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryWorldCupGameRecords", desc = "查询用户世界杯比赛战绩")
    public String _provisionalFacade_queryWorldCupGameRecords(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/queryWorldCupGames", desc = "查询世界杯赛事信息")
    public String _provisionalFacade_queryWorldCupGames(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/receivingGuoqingCoupon", desc = "国庆活动领券")
    public String _provisionalFacade_receivingGuoqingCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/receivingThirdAnniversaryCoupon", desc = "三周年活动领券")
    public String _provisionalFacade_receivingThirdAnniversaryCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/saveTmpInvitee", desc = "保存被邀请者信息")
    public String _provisionalFacade_saveTmpInvitee(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/provisionalFacade/updateSinglesDayUserStatisticsInfo", desc = "更新个人投资统计记录")
    public String _provisionalFacade_updateSinglesDayUserStatisticsInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/reportFacade/queryMerchantRewardsReport", desc = "商户推广返现总览")
    public String _reportFacade_queryMerchantRewardsReport(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/reportFacade/queryOrderSubsidyReport", desc = "查询已发放加息券明细")
    public String _reportFacade_queryOrderSubsidyReport(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/batchSendRewards", desc = "批量发放奖励请求")
    public String _rewardsFacade_batchSendRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/freezeLcj", desc = "冻结理财金")
    public String _rewardsFacade_freezeLcj(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/getManualRewardsDetails", desc = "查询人工发放奖励列明细")
    public String _rewardsFacade_getManualRewardsDetails(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/getManualRewardsList", desc = "查询没有限制的人数的人工发放奖励列表")
    public String _rewardsFacade_getManualRewardsList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/getUserLcjDetail", desc = "查询用户抵用金详情")
    public String _rewardsFacade_getUserLcjDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/getUserProfitInfo", desc = "获取用户收益信息（待收加速收益、已收加速收益、待收加息、已收加息）")
    public String _rewardsFacade_getUserProfitInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/queryLcjListByStatus", desc = "根据状态查询抵用金信息")
    public String _rewardsFacade_queryLcjListByStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/returnLcj", desc = "抵用金退款")
    public String _rewardsFacade_returnLcj(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/sendRewards", desc = "手动发放抵用金奖励")
    public String _rewardsFacade_sendRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/unFreezeLcj", desc = "解冻理财金")
    public String _rewardsFacade_unFreezeLcj(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rewardsFacade/useLcj", desc = "使用抵用金")
    public String _rewardsFacade_useLcj(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/addShareActivity", desc = "新增送祝福活动")
    public String _shareActivityFacade_addShareActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/generateShareInfo", desc = "生成新的分享信息")
    public String _shareActivityFacade_generateShareInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/getShareActivityInfo", desc = "查询祝福活动相关信息")
    public String _shareActivityFacade_getShareActivityInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/getShareItemInfo", desc = "获取分享信息")
    public String _shareActivityFacade_getShareItemInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/getShareResult", desc = "获取分享结果")
    public String _shareActivityFacade_getShareResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/receiveSharedItem", desc = "收下祝福")
    public String _shareActivityFacade_receiveSharedItem(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/recoverSharedItem", desc = "撤销分享")
    public String _shareActivityFacade_recoverSharedItem(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/shareActivityFacade/updateShareActivity", desc = "修改送祝福活动")
    public String _shareActivityFacade_updateShareActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getChannelPromotionUri", desc = "根据用户获取推广码（链接）")
    public String _tpPromotionFacade_getChannelPromotionUri(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getDailyPromotionRewards", desc = "查询奖励信息")
    public String _tpPromotionFacade_getDailyPromotionRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getPromotionActivity", desc = "查询活动信息")
    public String _tpPromotionFacade_getPromotionActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getPromotionRewards", desc = "查询好友投资记录")
    public String _tpPromotionFacade_getPromotionRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getPromotionUri", desc = "根据用户获取推广码（链接）")
    public String _tpPromotionFacade_getPromotionUri(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getRegisteredUserBehaviorData", desc = "查询已注册用户行为数据")
    public String _tpPromotionFacade_getRegisteredUserBehaviorData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getSummaryPromotionRewards", desc = "查询奖励总额信息")
    public String _tpPromotionFacade_getSummaryPromotionRewards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/getUserType", desc = "查询是否属于客服可跟进用户")
    public String _tpPromotionFacade_getUserType(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/queryChannelInfo", desc = "查询渠道数据总览")
    public String _tpPromotionFacade_queryChannelInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tpPromotionFacade/rebindPromotionRelation", desc = "重新绑定推广关系")
    public String _tpPromotionFacade_rebindPromotionRelation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/addHryIdMapper", desc = "添加hry_id_mapper信息")
    public String _userFacade_addHryIdMapper(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getInvestRankingDetail", desc = "查询当前投资打榜活动")
    public String _userFacade_getInvestRankingDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getPersonalInvestRank", desc = "查询个人当前投资打榜信息")
    public String _userFacade_getPersonalInvestRank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUserInvestRank", desc = "查询用户投资排名")
    public String _userFacade_getUserInvestRank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
