package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.ZhuanleBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: ZhuanleDefaultTest
 * @Author: 自动生成
 * @Date: 2018/11/15 14:56:54
 */
@Slf4j
public class ZhuanleDefaultTest extends ZhuanleBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public ZhuanleDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/arap/query-by-range", dataProvider = "provider", description = "资金日历查询")
    public void arap_query_by_range(HryTest hryTest) {
        String actual = super._arap_query_by_range(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/config/historic-rate", dataProvider = "provider", description = "获取参考历史年化区间")
    public void auto_bidding_config_historic_rate(HryTest hryTest) {
        String actual = super._auto_bidding_config_historic_rate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/config/list", dataProvider = "provider", description = "自动投标设置")
    public void auto_bidding_config_list(HryTest hryTest) {
        String actual = super._auto_bidding_config_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/config/save", dataProvider = "provider", description = "保存或修改自动投标设置并开启自动投标")
    public void auto_bidding_config_save(HryTest hryTest) {
        String actual = super._auto_bidding_config_save(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/earn-list", dataProvider = "provider", description = "赚钱明细")
    public void auto_bidding_earn_list(HryTest hryTest) {
        String actual = super._auto_bidding_earn_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/earn-list-dashboard", dataProvider = "provider", description = "赚钱明细")
    public void auto_bidding_earn_list_dashboard(HryTest hryTest) {
        String actual = super._auto_bidding_earn_list_dashboard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/manual", dataProvider = "provider", description = "自动投标指南")
    public void auto_bidding_manual(HryTest hryTest) {
        String actual = super._auto_bidding_manual(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/matching-list", dataProvider = "provider", description = "快速匹配明细")
    public void auto_bidding_matching_list(HryTest hryTest) {
        String actual = super._auto_bidding_matching_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/statistics", dataProvider = "provider", description = "智能投标主页")
    public void auto_bidding_statistics(HryTest hryTest) {
        String actual = super._auto_bidding_statistics(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/update-status", dataProvider = "provider", description = "暂停或恢复自动投标")
    public void auto_bidding_update_status(HryTest hryTest) {
        String actual = super._auto_bidding_update_status(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/auto-bidding/user-config", dataProvider = "provider", description = "获取自动投标设置")
    public void auto_bidding_user_config(HryTest hryTest) {
        String actual = super._auto_bidding_user_config(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bank/agreements", dataProvider = "provider", description = "retrieveAgreementByBankCode")
    public void bank_agreements(HryTest hryTest) {
        String actual = super._bank_agreements(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bank/get-cardBin", dataProvider = "provider", description = "根据卡号获取卡Bin信息")
    public void bank_get_cardBin(HryTest hryTest) {
        String actual = super._bank_get_cardBin(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bank/querySupportBank", dataProvider = "provider", description = "querySupportBank")
    public void bank_querySupportBank(HryTest hryTest) {
        String actual = super._bank_querySupportBank(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bank/querySupportBankList", dataProvider = "provider", description = "querySupportBankList")
    public void bank_querySupportBankList(HryTest hryTest) {
        String actual = super._bank_querySupportBankList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/banner/list-by-position", dataProvider = "provider", description = "listByPosition")
    public void banner_list_by_position(HryTest hryTest) {
        String actual = super._banner_list_by_position(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/banner/queryByCategory", dataProvider = "provider", description = "queryByCategory")
    public void banner_queryByCategory(HryTest hryTest) {
        String actual = super._banner_queryByCategory(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/banner/startup-banner", dataProvider = "provider", description = "app启动页广告")
    public void banner_startup_banner(HryTest hryTest) {
        String actual = super._banner_startup_banner(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bid/aggregated-bid-info", dataProvider = "provider", description = "查询标的详情")
    public void bid_aggregated_bid_info(HryTest hryTest) {
        String actual = super._bid_aggregated_bid_info(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bid/category-list/v2", dataProvider = "provider", description = "listCompositeBidCategories")
    public void bid_category_list_v2(HryTest hryTest) {
        String actual = super._bid_category_list_v2(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bid/list-by-category/v2", dataProvider = "provider", description = "listBidByCategory")
    public void bid_list_by_category_v2(HryTest hryTest) {
        String actual = super._bid_list_by_category_v2(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bid/query-by-discount", dataProvider = "provider", description = "根据优惠券搜索支持的标的")
    public void bid_query_by_discount(HryTest hryTest) {
        String actual = super._bid_query_by_discount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bid/query-by-rebate", dataProvider = "provider", description = "根据优惠信息搜索支持的标的")
    public void bid_query_by_rebate(HryTest hryTest) {
        String actual = super._bid_query_by_rebate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bid/top-products", dataProvider = "provider", description = "查询置顶的标的列表")
    public void bid_top_products(HryTest hryTest) {
        String actual = super._bid_top_products(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bill/detail", dataProvider = "provider", description = "queryDetail")
    public void bill_detail(HryTest hryTest) {
        String actual = super._bill_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bill/getUnionBillList", dataProvider = "provider", description = "getUnionBillList")
    public void bill_getUnionBillList(HryTest hryTest) {
        String actual = super._bill_getUnionBillList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bindPromotionCode", dataProvider = "provider", description = "绑定推广码")
    public void bindPromotionCode(HryTest hryTest) {
        String actual = super._bindPromotionCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cash-flow/list", dataProvider = "provider", description = "查询资金流水列表")
    public void cash_flow_list(HryTest hryTest) {
        String actual = super._cash_flow_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/checkin/home", dataProvider = "provider", description = "home")
    public void checkin_home(HryTest hryTest) {
        String actual = super._checkin_home(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/checkin/perform", dataProvider = "provider", description = "doCheckIn")
    public void checkin_perform(HryTest hryTest) {
        String actual = super._checkin_perform(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/checkin/records", dataProvider = "provider", description = "queryCheckInRecords")
    public void checkin_records(HryTest hryTest) {
        String actual = super._checkin_records(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/checkin/rules", dataProvider = "provider", description = "queryCheckInRules")
    public void checkin_rules(HryTest hryTest) {
        String actual = super._checkin_rules(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/my-reservations", dataProvider = "provider", description = "queryUserReservationList")
    public void consumer_finance_my_reservations(HryTest hryTest) {
        String actual = super._consumer_finance_my_reservations(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation-detail", dataProvider = "provider", description = "我的预约记录详情")
    public void consumer_finance_reservation_detail(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/hot-products", dataProvider = "provider", description = "查询预约计划列表")
    public void consumer_finance_reservation_hot_products(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_hot_products(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/invest-detail", dataProvider = "provider", description = "查询预约计划的交易详情")
    public void consumer_finance_reservation_invest_detail(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_invest_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/matched-bid-detail", dataProvider = "provider", description = "查询匹配的标的详情")
    public void consumer_finance_reservation_matched_bid_detail(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_matched_bid_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/matched-bid-list", dataProvider = "provider", description = "查询匹配的标的列表")
    public void consumer_finance_reservation_matched_bid_list(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_matched_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/plan-detail", dataProvider = "provider", description = "查询预约详情")
    public void consumer_finance_reservation_plan_detail(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_plan_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/plan-list", dataProvider = "provider", description = "查询预约计划列表")
    public void consumer_finance_reservation_plan_list(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_plan_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/plan-summary", dataProvider = "provider", description = "查询预约申请概要信息")
    public void consumer_finance_reservation_plan_summary(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_plan_summary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumer-finance/reservation/purchased-products", dataProvider = "provider", description = "queryPurchasedProduct4Reservation")
    public void consumer_finance_reservation_purchased_products(HryTest hryTest) {
        String actual = super._consumer_finance_reservation_purchased_products(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/coupon/activeCoupon", dataProvider = "provider", description = "activeCoupon")
    public void coupon_activeCoupon(HryTest hryTest) {
        String actual = super._coupon_activeCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/coupon/getAvailableCouponList", dataProvider = "provider", description = "根据标的搜索可用的优惠信息")
    public void coupon_getAvailableCouponList(HryTest hryTest) {
        String actual = super._coupon_getAvailableCouponList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/coupon/getCouponAmount", dataProvider = "provider", description = "getCouponAmount")
    public void coupon_getCouponAmount(HryTest hryTest) {
        String actual = super._coupon_getCouponAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/coupon/getCouponList", dataProvider = "provider", description = "根据状态(1：未使用；2：已使用；3：已过期)查询我的理财券")
    public void coupon_getCouponList(HryTest hryTest) {
        String actual = super._coupon_getCouponList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/coupon/grabCoupon", dataProvider = "provider", description = "grabCoupon")
    public void coupon_grabCoupon(HryTest hryTest) {
        String actual = super._coupon_grabCoupon(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/coupon/profit-benchmark", dataProvider = "provider", description = "获取加息券预期收益的基准")
    public void coupon_profit_benchmark(HryTest hryTest) {
        String actual = super._coupon_profit_benchmark(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/coupon/queryCoupon4Grab", dataProvider = "provider", description = "queryCoupon4Grab")
    public void coupon_queryCoupon4Grab(HryTest hryTest) {
        String actual = super._coupon_queryCoupon4Grab(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customer-service/customer-info", dataProvider = "provider", description = "showCustomerInfo")
    public void customer_service_customer_info(HryTest hryTest) {
        String actual = super._customer_service_customer_info(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customer-service/show-dialog", dataProvider = "provider", description = "阿里客服系统接入入口")
    public void customer_service_show_dialog(HryTest hryTest) {
        String actual = super._customer_service_show_dialog(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/bid/detail", dataProvider = "provider", description = "债权投资人查看债权详情")
    public void czz_bid_detail(HryTest hryTest) {
        String actual = super._czz_bid_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/bid/list", dataProvider = "provider", description = "列表页债转标的查询")
    public void czz_bid_list(HryTest hryTest) {
        String actual = super._czz_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/bid/orderAnPay", dataProvider = "provider", description = "createOrder")
    public void czz_bid_orderAnPay(HryTest hryTest) {
        String actual = super._czz_bid_orderAnPay(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/bid/place-order", dataProvider = "provider", description = "placeOrder")
    public void czz_bid_place_order(HryTest hryTest) {
        String actual = super._czz_bid_place_order(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/bid/prebuy", dataProvider = "provider", description = "prebuy")
    public void czz_bid_prebuy(HryTest hryTest) {
        String actual = super._czz_bid_prebuy(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/bid/queryInvestOrder", dataProvider = "provider", description = "queryInvestOrder")
    public void czz_bid_queryInvestOrder(HryTest hryTest) {
        String actual = super._czz_bid_queryInvestOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/bid/recommend-list", dataProvider = "provider", description = "首页推荐债转标的查询")
    public void czz_bid_recommend_list(HryTest hryTest) {
        String actual = super._czz_bid_recommend_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/cancel", dataProvider = "provider", description = "撤销申请并且同步返回申请结果")
    public void czz_cancel(HryTest hryTest) {
        String actual = super._czz_cancel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/publish", dataProvider = "provider", description = "发起债权转让申请并且同步返回申请结果")
    public void czz_publish(HryTest hryTest) {
        String actual = super._czz_publish(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/queryCzzDetail", dataProvider = "provider", description = "查询纯债转转让详细信息")
    public void czz_queryCzzDetail(HryTest hryTest) {
        String actual = super._czz_queryCzzDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/queryCzzRecord", dataProvider = "provider", description = "查询债权转让申请记录")
    public void czz_queryCzzRecord(HryTest hryTest) {
        String actual = super._czz_queryCzzRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/czz/queryPublishInfo", dataProvider = "provider", description = "查询用于发布的信息")
    public void czz_queryPublishInfo(HryTest hryTest) {
        String actual = super._czz_queryPublishInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/auth/prepare", dataProvider = "provider", description = "准备发起开通存管请求")
    public void depository_auth_prepare(HryTest hryTest) {
        String actual = super._depository_auth_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/bank-card-change/prepare", dataProvider = "provider", description = "准备发起换绑银行卡请求")
    public void depository_bank_card_change_prepare(HryTest hryTest) {
        String actual = super._depository_bank_card_change_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/passwd-getback/prepare", dataProvider = "provider", description = "准备发起存管密码找回请求")
    public void depository_passwd_getback_prepare(HryTest hryTest) {
        String actual = super._depository_passwd_getback_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/passwd-update/prepare", dataProvider = "provider", description = "准备发起存管密码修改请求")
    public void depository_passwd_update_prepare(HryTest hryTest) {
        String actual = super._depository_passwd_update_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/passwd-verify/prepare", dataProvider = "provider", description = "准备发起存管密码验证请求")
    public void depository_passwd_verify_prepare(HryTest hryTest) {
        String actual = super._depository_passwd_verify_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/recharge/prepare", dataProvider = "provider", description = "准备发起存管充值")
    public void depository_recharge_prepare(HryTest hryTest) {
        String actual = super._depository_recharge_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/reserved-phone-change/prepare", dataProvider = "provider", description = "准备发起更新手机请求")
    public void depository_reserved_phone_change_prepare(HryTest hryTest) {
        String actual = super._depository_reserved_phone_change_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/trade-details", dataProvider = "provider", description = "存管交易记录详情查询")
    public void depository_trade_details(HryTest hryTest) {
        String actual = super._depository_trade_details(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/trade-records", dataProvider = "provider", description = "存管交易记录查询")
    public void depository_trade_records(HryTest hryTest) {
        String actual = super._depository_trade_records(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/user-active/prepare", dataProvider = "provider", description = "准备发起激活存管请求")
    public void depository_user_active_prepare(HryTest hryTest) {
        String actual = super._depository_user_active_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/withdraw/conditions", dataProvider = "provider", description = "提现操作前的条件查询")
    public void depository_withdraw_conditions(HryTest hryTest) {
        String actual = super._depository_withdraw_conditions(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/depository/withdraw/prepare", dataProvider = "provider", description = "准备发起存管提现")
    public void depository_withdraw_prepare(HryTest hryTest) {
        String actual = super._depository_withdraw_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/finance/dashboard", dataProvider = "provider", description = "hryDashboard")
    public void finance_dashboard(HryTest hryTest) {
        String actual = super._finance_dashboard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/finance/getInvestDetail", dataProvider = "provider", description = "查询交易详情")
    public void finance_getInvestDetail(HryTest hryTest) {
        String actual = super._finance_getInvestDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/finance/getMybids", dataProvider = "provider", description = "用户投资列表")
    public void finance_getMybids(HryTest hryTest) {
        String actual = super._finance_getMybids(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/h5/asset/summary", dataProvider = "provider", description = "顺逛资产查询")
    public void h5_asset_summary(HryTest hryTest) {
        String actual = super._h5_asset_summary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/h5/dep/account-info", dataProvider = "provider", description = "查询H5用户的账户信息")
    public void h5_dep_account_info(HryTest hryTest) {
        String actual = super._h5_dep_account_info(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/h5/investment/p2p-records", dataProvider = "provider", description = "queryUserP2PInvestRecords")
    public void h5_investment_p2p_records(HryTest hryTest) {
        String actual = super._h5_investment_p2p_records(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/haier/account/bind", dataProvider = "provider", description = "海尔集团用户绑定")
    public void haier_account_bind(HryTest hryTest) {
        String actual = super._haier_account_bind(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/haier/sign-in", dataProvider = "provider", description = "海尔集团用户登录")
    public void haier_sign_in(HryTest hryTest) {
        String actual = super._haier_sign_in(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home-dispatch/hot-bid-list", dataProvider = "provider", description = "热门推荐标的列表查询")
    public void home_dispatch_hot_bid_list(HryTest hryTest) {
        String actual = super._home_dispatch_hot_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home-dispatch/news", dataProvider = "provider", description = "新闻列表")
    public void home_dispatch_news(HryTest hryTest) {
        String actual = super._home_dispatch_news(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home-dispatch/novice-bid-list", dataProvider = "provider", description = "新客专享标的查询")
    public void home_dispatch_novice_bid_list(HryTest hryTest) {
        String actual = super._home_dispatch_novice_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home-dispatch/recommend-bid-list", dataProvider = "provider", description = "查询预约专区和精选投资列表")
    public void home_dispatch_recommend_bid_list(HryTest hryTest) {
        String actual = super._home_dispatch_recommend_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home-dispatch/top-area-dashboard", dataProvider = "provider", description = "查询顶部banner和运营活动区信息")
    public void home_dispatch_top_area_dashboard(HryTest hryTest) {
        String actual = super._home_dispatch_top_area_dashboard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home-dispatch/ue-wrappers", dataProvider = "provider", description = "优易智投推荐列表")
    public void home_dispatch_ue_wrappers(HryTest hryTest) {
        String actual = super._home_dispatch_ue_wrappers(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home/dialogs", dataProvider = "provider", description = "newDialogs")
    public void home_dialogs(HryTest hryTest) {
        String actual = super._home_dialogs(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home/h5", dataProvider = "provider", description = "h5home")
    public void home_h5(HryTest hryTest) {
        String actual = super._home_h5(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home/queryHryStat", dataProvider = "provider", description = "queryHryStat")
    public void home_queryHryStat(HryTest hryTest) {
        String actual = super._home_queryHryStat(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home/queryRecommendBid", dataProvider = "provider", description = "queryRecommendBid")
    public void home_queryRecommendBid(HryTest hryTest) {
        String actual = super._home_queryRecommendBid(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home/user-asset", dataProvider = "provider", description = "queryMyAsset")
    public void home_user_asset(HryTest hryTest) {
        String actual = super._home_user_asset(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/home/v2", dataProvider = "provider", description = "home")
    public void home_v2(HryTest hryTest) {
        String actual = super._home_v2(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investment-record/dashboard", dataProvider = "provider", description = "我的投资主页")
    public void investment_record_dashboard(HryTest hryTest) {
        String actual = super._investment_record_dashboard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investment-record/normal-bid-list", dataProvider = "provider", description = "散标列表查询")
    public void investment_record_normal_bid_list(HryTest hryTest) {
        String actual = super._investment_record_normal_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investment-record/settled-bid-list", dataProvider = "provider", description = "我的出借:结清和撤销的记录查询")
    public void investment_record_settled_bid_list(HryTest hryTest) {
        String actual = super._investment_record_settled_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lcj/exchange", dataProvider = "provider", description = "exchange")
    public void lcj_exchange(HryTest hryTest) {
        String actual = super._lcj_exchange(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lcj/exchange-coupon/list", dataProvider = "provider", description = "queryToBeExchangedCoupons")
    public void lcj_exchange_coupon_list(HryTest hryTest) {
        String actual = super._lcj_exchange_coupon_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lcj/getLcjBalance", dataProvider = "provider", description = "getLcjBalance")
    public void lcj_getLcjBalance(HryTest hryTest) {
        String actual = super._lcj_getLcjBalance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lcj/getLcjDetails", dataProvider = "provider", description = "getLcjDetails")
    public void lcj_getLcjDetails(HryTest hryTest) {
        String actual = super._lcj_getLcjDetails(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/logout", dataProvider = "provider", description = "退出")
    public void logout(HryTest hryTest) {
        String actual = super._logout(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member-grade/definition", dataProvider = "provider", description = "queryMemberGradeDefinition")
    public void member_grade_definition(HryTest hryTest) {
        String actual = super._member_grade_definition(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member-grade/home", dataProvider = "provider", description = "home")
    public void member_grade_home(HryTest hryTest) {
        String actual = super._member_grade_home(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member-grade/privilege", dataProvider = "provider", description = "queryMemberPrivilege")
    public void member_grade_privilege(HryTest hryTest) {
        String actual = super._member_grade_privilege(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member-grade/privilege-detail", dataProvider = "provider", description = "queryMemberGradePrivilegeDetail")
    public void member_grade_privilege_detail(HryTest hryTest) {
        String actual = super._member_grade_privilege_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member-grade/query-rewards-message", dataProvider = "provider", description = "queryUserRewardsMessage")
    public void member_grade_query_rewards_message(HryTest hryTest) {
        String actual = super._member_grade_query_rewards_message(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member-grade/upgrade-gift", dataProvider = "provider", description = "queryUserRewardsAfterUpgrade")
    public void member_grade_upgrade_gift(HryTest hryTest) {
        String actual = super._member_grade_upgrade_gift(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/acct-attrs", dataProvider = "provider", description = "查询用户的账户属性信息")
    public void member_acct_attrs(HryTest hryTest) {
        String actual = super._member_acct_attrs(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/agreeNewUserLicense", dataProvider = "provider", description = "agreeNewUserLicense")
    public void member_agreeNewUserLicense(HryTest hryTest) {
        String actual = super._member_agreeNewUserLicense(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/check-account", dataProvider = "provider", description = "checkAccount")
    public void member_check_account(HryTest hryTest) {
        String actual = super._member_check_account(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/checkAccount4FindPassword", dataProvider = "provider", description = "checkAccount4FindPassword")
    public void member_checkAccount4FindPassword(HryTest hryTest) {
        String actual = super._member_checkAccount4FindPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/dep-elements", dataProvider = "provider", description = "存管开户前查询用户资料")
    public void member_dep_elements(HryTest hryTest) {
        String actual = super._member_dep_elements(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/dialogs", dataProvider = "provider", description = "dialogs")
    public void member_dialogs(HryTest hryTest) {
        String actual = super._member_dialogs(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/homepage/app-list/v3", dataProvider = "provider", description = "我的应用列表")
    public void member_homepage_app_list_v3(HryTest hryTest) {
        String actual = super._member_homepage_app_list_v3(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/homepage/asset-allocation", dataProvider = "provider", description = "查询账户资产配置信息")
    public void member_homepage_asset_allocation(HryTest hryTest) {
        String actual = super._member_homepage_asset_allocation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/homepage/brief-account-info", dataProvider = "provider", description = "查询账户简要信息")
    public void member_homepage_brief_account_info(HryTest hryTest) {
        String actual = super._member_homepage_brief_account_info(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/homepage/my-assets", dataProvider = "provider", description = "我的总资产")
    public void member_homepage_my_assets(HryTest hryTest) {
        String actual = super._member_homepage_my_assets(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/queryCurrentUser", dataProvider = "provider", description = "queryCurrentUser")
    public void member_queryCurrentUser(HryTest hryTest) {
        String actual = super._member_queryCurrentUser(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/queryUserStatusForH5", dataProvider = "provider", description = "queryUserStatusForH5")
    public void member_queryUserStatusForH5(HryTest hryTest) {
        String actual = super._member_queryUserStatusForH5(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/risk-assessment/perform", dataProvider = "provider", description = "riskAssessmentPerform")
    public void member_risk_assessment_perform(HryTest hryTest) {
        String actual = super._member_risk_assessment_perform(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/risk-assessment/questions", dataProvider = "provider", description = "queryRiskAssessmentTopics")
    public void member_risk_assessment_questions(HryTest hryTest) {
        String actual = super._member_risk_assessment_questions(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/verify-account", dataProvider = "provider", description = "verifyAccount")
    public void member_verify_account(HryTest hryTest) {
        String actual = super._member_verify_account(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/member/verify-idCard", dataProvider = "provider", description = "verifyIdCard")
    public void member_verify_idCard(HryTest hryTest) {
        String actual = super._member_verify_idCard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/message/queryMessage", dataProvider = "provider", description = "getMessage")
    public void message_queryMessage(HryTest hryTest) {
        String actual = super._message_queryMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/message/queryMessageReadStatusStat", dataProvider = "provider", description = "getMessageReadStatus")
    public void message_queryMessageReadStatusStat(HryTest hryTest) {
        String actual = super._message_queryMessageReadStatusStat(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/message/queryYellowBarMessage", dataProvider = "provider", description = "queryYellowBarMessage")
    public void message_queryYellowBarMessage(HryTest hryTest) {
        String actual = super._message_queryYellowBarMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/message/setAllMessageRead", dataProvider = "provider", description = "setAllMessageRead")
    public void message_setAllMessageRead(HryTest hryTest) {
        String actual = super._message_setAllMessageRead(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/message/setMessageRead", dataProvider = "provider", description = "setMessageRead")
    public void message_setMessageRead(HryTest hryTest) {
        String actual = super._message_setMessageRead(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/mng/iosIsVerify", dataProvider = "provider", description = "iosIsVerify")
    public void mng_iosIsVerify(HryTest hryTest) {
        String actual = super._mng_iosIsVerify(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/mng/queryMaintence", dataProvider = "provider", description = "systemMaintence")
    public void mng_queryMaintence(HryTest hryTest) {
        String actual = super._mng_queryMaintence(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/newGuestGift", dataProvider = "provider", description = "查询新手大礼包")
    public void newGuestGift(HryTest hryTest) {
        String actual = super._newGuestGift(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/one-annua/gameReword", dataProvider = "provider", description = "gameReword")
    public void operation_one_annua_gameReword(HryTest hryTest) {
        String actual = super._operation_one_annua_gameReword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/query-scratch", dataProvider = "provider", description = "queryScratchAfterInvest")
    public void operation_query_scratch(HryTest hryTest) {
        String actual = super._operation_query_scratch(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/query1111Activity", dataProvider = "provider", description = "query1111Activity")
    public void operation_query1111Activity(HryTest hryTest) {
        String actual = super._operation_query1111Activity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/recommendActivity", dataProvider = "provider", description = "queryRecommendActivity")
    public void operation_recommendActivity(HryTest hryTest) {
        String actual = super._operation_recommendActivity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/recommendProfit", dataProvider = "provider", description = "queryRecommendProfit")
    public void operation_recommendProfit(HryTest hryTest) {
        String actual = super._operation_recommendProfit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/scratch-ticket", dataProvider = "provider", description = "scratchTicket")
    public void operation_scratch_ticket(HryTest hryTest) {
        String actual = super._operation_scratch_ticket(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/scratch/perform", dataProvider = "provider", description = "scratchTicketAdaptor")
    public void operation_scratch_perform(HryTest hryTest) {
        String actual = super._operation_scratch_perform(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/operation/scratch/query", dataProvider = "provider", description = "scratchQueryAdaptor")
    public void operation_scratch_query(HryTest hryTest) {
        String actual = super._operation_scratch_query(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oss/banner-list", dataProvider = "provider", description = "根据位置查询Banner")
    public void oss_banner_list(HryTest hryTest) {
        String actual = super._oss_banner_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oss/getDiscoveryDetail", dataProvider = "provider", description = "getDiscoveryDetail")
    public void oss_getDiscoveryDetail(HryTest hryTest) {
        String actual = super._oss_getDiscoveryDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oss/getMiscContent", dataProvider = "provider", description = "getMiscContent")
    public void oss_getMiscContent(HryTest hryTest) {
        String actual = super._oss_getMiscContent(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oss/getMiscContentList", dataProvider = "provider", description = "getMiscContentList")
    public void oss_getMiscContentList(HryTest hryTest) {
        String actual = super._oss_getMiscContentList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/password/set-password", dataProvider = "provider", description = "setPassword")
    public void password_set_password(HryTest hryTest) {
        String actual = super._password_set_password(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/password/update-password", dataProvider = "provider", description = "updatePassword")
    public void password_update_password(HryTest hryTest) {
        String actual = super._password_update_password(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotion/query-promoter", dataProvider = "provider", description = "queryPromoter")
    public void promotion_query_promoter(HryTest hryTest) {
        String actual = super._promotion_query_promoter(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotion/queryShareInfo", dataProvider = "provider", description = "promoteUri")
    public void promotion_queryShareInfo(HryTest hryTest) {
        String actual = super._promotion_queryShareInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/promotion/uri", dataProvider = "provider", description = "promoteUri")
    public void promotion_uri(HryTest hryTest) {
        String actual = super._promotion_uri(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryLatestCategoryUpdate", dataProvider = "provider", description = "queryLatestCategoryUpdate")
    public void queryLatestCategoryUpdate(HryTest hryTest) {
        String actual = super._queryLatestCategoryUpdate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/share/bid-detail-share", dataProvider = "provider", description = "标的详情分享")
    public void share_bid_detail_share(HryTest hryTest) {
        String actual = super._share_bid_detail_share(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sign-in", dataProvider = "provider", description = "用户登录")
    public void sign_in(HryTest hryTest) {
        String actual = super._sign_in(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sms/checkVerifyCode", dataProvider = "provider", description = "checkVerifyCode")
    public void sms_checkVerifyCode(HryTest hryTest) {
        String actual = super._sms_checkVerifyCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sms/sendEmailVerifyCode", dataProvider = "provider", description = "sendEmailVerifyCode")
    public void sms_sendEmailVerifyCode(HryTest hryTest) {
        String actual = super._sms_sendEmailVerifyCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sms/sendSMS", dataProvider = "provider", description = "sendSMS")
    public void sms_sendSMS(HryTest hryTest) {
        String actual = super._sms_sendSMS(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tender/p2p/order-result", dataProvider = "provider", description = "查看p2p标的投资下单结果")
    public void tender_p2p_order_result(HryTest hryTest) {
        String actual = super._tender_p2p_order_result(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tender/p2p/place-order", dataProvider = "provider", description = "存管p2p标的投资下单")
    public void tender_p2p_place_order(HryTest hryTest) {
        String actual = super._tender_p2p_place_order(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/authorize/cancel", dataProvider = "provider", description = "优易智投授权撤销")
    public void ue_authorize_cancel(HryTest hryTest) {
        String actual = super._ue_authorize_cancel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/authorize/perform", dataProvider = "provider", description = "优易智投授权申请")
    public void ue_authorize_perform(HryTest hryTest) {
        String actual = super._ue_authorize_perform(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/authorize/prepare", dataProvider = "provider", description = "准备发起授权申请")
    public void ue_authorize_prepare(HryTest hryTest) {
        String actual = super._ue_authorize_prepare(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/details", dataProvider = "provider", description = "优易智投详情查询")
    public void ue_details(HryTest hryTest) {
        String actual = super._ue_details(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/invest-details", dataProvider = "provider", description = "优易智投投资详情")
    public void ue_invest_details(HryTest hryTest) {
        String actual = super._ue_invest_details(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/matched-bid-detail", dataProvider = "provider", description = "查询匹配的标的详情")
    public void ue_matched_bid_detail(HryTest hryTest) {
        String actual = super._ue_matched_bid_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/matched-bid-list", dataProvider = "provider", description = "查询匹配的标的列表")
    public void ue_matched_bid_list(HryTest hryTest) {
        String actual = super._ue_matched_bid_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ue/wrapper-list", dataProvider = "provider", description = "优易智投列表查询")
    public void ue_wrapper_list(HryTest hryTest) {
        String actual = super._ue_wrapper_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/v2/register", dataProvider = "provider", description = "注册并且设置登陆密码")
    public void v2_register(HryTest hryTest) {
        String actual = super._v2_register(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/version/backgroudCheck", dataProvider = "provider", description = "checkAppVersion")
    public void version_backgroudCheck(HryTest hryTest) {
        String actual = super._version_backgroudCheck(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/version/check", dataProvider = "provider", description = "checkAppVersion")
    public void version_check(HryTest hryTest) {
        String actual = super._version_check(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/aip/detail", dataProvider = "provider", description = "查询定投计划的详情")
    public void ym_account_aip_detail(HryTest hryTest) {
        String actual = super._ym_account_aip_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/aip/histories", dataProvider = "provider", description = "查询定投计划的历史记录列表")
    public void ym_account_aip_histories(HryTest hryTest) {
        String actual = super._ym_account_aip_histories(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/aip/list", dataProvider = "provider", description = "查询定投计划列表")
    public void ym_account_aip_list(HryTest hryTest) {
        String actual = super._ym_account_aip_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/aip/next-pay-time", dataProvider = "provider", description = "根据用户输入的定投周期查询下一次自动扣款的时间")
    public void ym_account_aip_next_pay_time(HryTest hryTest) {
        String actual = super._ym_account_aip_next_pay_time(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/aip/update-status", dataProvider = "provider", description = "修改定投计划的状态")
    public void ym_account_aip_update_status(HryTest hryTest) {
        String actual = super._ym_account_aip_update_status(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/attributes", dataProvider = "provider", description = "查询用户账户属性")
    public void ym_account_attributes(HryTest hryTest) {
        String actual = super._ym_account_attributes(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/bank-card/list", dataProvider = "provider", description = "查询盈米绑定的银行卡")
    public void ym_account_bank_card_list(HryTest hryTest) {
        String actual = super._ym_account_bank_card_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/hold-position-history", dataProvider = "provider", description = "查询我的持仓历史记录")
    public void ym_account_hold_position_history(HryTest hryTest) {
        String actual = super._ym_account_hold_position_history(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/my-fund-detail", dataProvider = "provider", description = "查询用户持有基金的详情")
    public void ym_account_my_fund_detail(HryTest hryTest) {
        String actual = super._ym_account_my_fund_detail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/my-fund-list", dataProvider = "provider", description = "查询用户的持仓基金列表")
    public void ym_account_my_fund_list(HryTest hryTest) {
        String actual = super._ym_account_my_fund_list(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-account/share-info", dataProvider = "provider", description = "基金赎回之前查询基金份额的相关信息")
    public void ym_account_share_info(HryTest hryTest) {
        String actual = super._ym_account_share_info(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-fund/redeem", dataProvider = "provider", description = "赎回")
    public void ym_fund_redeem(HryTest hryTest) {
        String actual = super._ym_fund_redeem(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-fund/simple-info", dataProvider = "provider", description = "查询基金的一些简要信息")
    public void ym_fund_simple_info(HryTest hryTest) {
        String actual = super._ym_fund_simple_info(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-result/query", dataProvider = "provider", description = "交易结果查询")
    public void ym_result_query(HryTest hryTest) {
        String actual = super._ym_result_query(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/ym-result/trade-record-list", dataProvider = "provider", description = "查询用户某个基金的的交易记录列表")
    public void ym_result_trade_record_list(HryTest hryTest) {
        String actual = super._ym_result_trade_record_list(hryTest);
        supperAssert(actual, hryTest);
    }

}
