package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: ZhuanleBase
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@SKey("Zhuanle")
public class ZhuanleBase extends Base {
    public ZhuanleBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }
    @Uri(value = "/arap/query-by-range", desc = "资金日历查询")
    public String _arap_query_by_range(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/config/historic-rate", desc = "获取参考历史年化区间")
    public String _auto_bidding_config_historic_rate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/config/list", desc = "自动投标设置")
    public String _auto_bidding_config_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/config/save", desc = "保存或修改自动投标设置并开启自动投标")
    public String _auto_bidding_config_save(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/earn-list", desc = "赚钱明细")
    public String _auto_bidding_earn_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/earn-list-dashboard", desc = "赚钱明细")
    public String _auto_bidding_earn_list_dashboard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/manual", desc = "自动投标指南")
    public String _auto_bidding_manual(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/matching-list", desc = "快速匹配明细")
    public String _auto_bidding_matching_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/statistics", desc = "智能投标主页")
    public String _auto_bidding_statistics(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/update-status", desc = "暂停或恢复自动投标")
    public String _auto_bidding_update_status(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/auto-bidding/user-config", desc = "获取自动投标设置")
    public String _auto_bidding_user_config(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bank/agreements", desc = "retrieveAgreementByBankCode")
    public String _bank_agreements(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bank/bind-QuickPayBank", desc = "bindQuickPayBank")
    public String _bank_bind_QuickPayBank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bank/get-cardBin", desc = "根据卡号获取卡Bin信息")
    public String _bank_get_cardBin(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bank/querySupportBank", desc = "querySupportBank")
    public String _bank_querySupportBank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bank/querySupportBankList", desc = "querySupportBankList")
    public String _bank_querySupportBankList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bank/remove-bankCard", desc = "removeBankCard")
    public String _bank_remove_bankCard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bank/single-bind-quickPayBank", desc = "singleBindQuickPayBank")
    public String _bank_single_bind_quickPayBank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/banner/list-by-position", desc = "listByPosition")
    public String _banner_list_by_position(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/banner/queryByCategory", desc = "queryByCategory")
    public String _banner_queryByCategory(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/banner/startup-banner", desc = "app启动页广告")
    public String _banner_startup_banner(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bid/aggregated-bid-info", desc = "查询标的详情")
    public String _bid_aggregated_bid_info(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bid/category-list/v2", desc = "listCompositeBidCategories")
    public String _bid_category_list_v2(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bid/invest/balance-check", desc = "balanceCheck")
    public String _bid_invest_balance_check(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bid/list-by-category/v2", desc = "listBidByCategory")
    public String _bid_list_by_category_v2(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bid/query-by-discount", desc = "根据优惠券搜索支持的标的")
    public String _bid_query_by_discount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bid/top-products", desc = "查询置顶的标的列表")
    public String _bid_top_products(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bill/detail", desc = "queryDetail")
    public String _bill_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bill/getUnionBillList", desc = "getUnionBillList")
    public String _bill_getUnionBillList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bindPromotionCode", desc = "绑定推广码")
    public String _bindPromotionCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cash-flow/list", desc = "查询资金流水列表-v3.0.2")
    public String _cash_flow_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/checkin/home", desc = "home")
    public String _checkin_home(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/checkin/perform", desc = "doCheckIn")
    public String _checkin_perform(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/checkin/records", desc = "queryCheckInRecords")
    public String _checkin_records(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/checkin/rules", desc = "queryCheckInRules")
    public String _checkin_rules(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/my-reservations", desc = "queryUserReservationList")
    public String _consumer_finance_my_reservations(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation-detail", desc = "我的预约记录详情")
    public String _consumer_finance_reservation_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/create-apply", desc = "创建预约单")
    public String _consumer_finance_reservation_create_apply(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/frozen-share-detail", desc = "queryFrozenShareDetail4Reservation")
    public String _consumer_finance_reservation_frozen_share_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/frozen-share-list", desc = "queryFrozenShares4Reservation")
    public String _consumer_finance_reservation_frozen_share_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/hot-products", desc = "查询预约计划列表-v3.0.2")
    public String _consumer_finance_reservation_hot_products(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/invest-detail", desc = "查询预约计划的交易详情")
    public String _consumer_finance_reservation_invest_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/matched-bid-detail", desc = "查询匹配的标的详情-v3.0.2")
    public String _consumer_finance_reservation_matched_bid_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/matched-bid-list", desc = "查询匹配的标的列表")
    public String _consumer_finance_reservation_matched_bid_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/plan-detail", desc = "查询预约详情")
    public String _consumer_finance_reservation_plan_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/plan-list", desc = "查询预约计划列表")
    public String _consumer_finance_reservation_plan_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/plan-summary", desc = "查询预约申请概要信息")
    public String _consumer_finance_reservation_plan_summary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumer-finance/reservation/purchased-products", desc = "queryPurchasedProduct4Reservation")
    public String _consumer_finance_reservation_purchased_products(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/activeCoupon", desc = "activeCoupon")
    public String _coupon_activeCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/getAvailableCouponList", desc = "根据标的搜索可用的优惠信息")
    public String _coupon_getAvailableCouponList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/getCouponAmount", desc = "getCouponAmount")
    public String _coupon_getCouponAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/getCouponList", desc = "根据状态(1：未使用；2：已使用；3：已过期)查询我的理财券")
    public String _coupon_getCouponList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/getCouponScreening", desc = "getCouponScreening")
    public String _coupon_getCouponScreening(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/grabCoupon", desc = "grabCoupon")
    public String _coupon_grabCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/profit-benchmark", desc = "获取加息券预期收益的基准")
    public String _coupon_profit_benchmark(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/coupon/queryCoupon4Grab", desc = "queryCoupon4Grab")
    public String _coupon_queryCoupon4Grab(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customer-service/customer-info", desc = "showCustomerInfo")
    public String _customer_service_customer_info(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customer-service/show-dialog", desc = "阿里客服系统接入入口")
    public String _customer_service_show_dialog(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/bid/detail", desc = "债权投资人查看债权详情")
    public String _czz_bid_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/bid/list", desc = "列表页债转标的查询")
    public String _czz_bid_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/bid/orderAnPay", desc = "createOrder")
    public String _czz_bid_orderAnPay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/bid/place-order", desc = "placeOrder")
    public String _czz_bid_place_order(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/bid/prebuy", desc = "prebuy")
    public String _czz_bid_prebuy(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/bid/queryInvestOrder", desc = "queryInvestOrder")
    public String _czz_bid_queryInvestOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/bid/recommend-list", desc = "首页推荐债转标的查询")
    public String _czz_bid_recommend_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/cancel", desc = "撤销申请并且同步返回申请结果")
    public String _czz_cancel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/publish", desc = "发起债权转让申请并且同步返回申请结果")
    public String _czz_publish(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/queryCzzDetail", desc = "查询纯债转转让详细信息")
    public String _czz_queryCzzDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/queryCzzRecord", desc = "查询债权转让申请记录")
    public String _czz_queryCzzRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/czz/queryPublishInfo", desc = "查询用于发布的信息")
    public String _czz_queryPublishInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/auth/prepare", desc = "准备发起开通存管请求")
    public String _depository_auth_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/bank-card-change/prepare", desc = "准备发起换绑银行卡请求")
    public String _depository_bank_card_change_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/passwd-getback/prepare", desc = "准备发起存管密码找回请求")
    public String _depository_passwd_getback_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/passwd-update/prepare", desc = "准备发起存管密码修改请求")
    public String _depository_passwd_update_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/passwd-verify/prepare", desc = "准备发起存管密码验证请求")
    public String _depository_passwd_verify_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/recharge/prepare", desc = "准备发起存管充值")
    public String _depository_recharge_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/reserved-phone-change/prepare", desc = "准备发起更新手机请求-v3.0.2")
    public String _depository_reserved_phone_change_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/trade-details", desc = "存管交易记录详情查询")
    public String _depository_trade_details(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/trade-records", desc = "存管交易记录查询")
    public String _depository_trade_records(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/user-active/prepare", desc = "准备发起激活存管请求")
    public String _depository_user_active_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/depository/withdraw/prepare", desc = "准备发起存管提现")
    public String _depository_withdraw_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/finance/dashboard", desc = "hryDashboard")
    public String _finance_dashboard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/finance/getInvestDetail", desc = "查询交易详情")
    public String _finance_getInvestDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/finance/getMybids", desc = "用户投资列表")
    public String _finance_getMybids(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/fund-query-benefit", desc = "queryFundBenefit")
    public String _fund_fund_query_benefit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/fund-query-order", desc = "queryFundOrder")
    public String _fund_fund_query_order(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/fund-query-profitDate", desc = "queryProfitDate")
    public String _fund_fund_query_profitDate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/fund-query-rate", desc = "queryFundRate")
    public String _fund_fund_query_rate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/fund-turnout-account", desc = "fundTurnOutToAccount")
    public String _fund_fund_turnout_account(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/fund-turnout-bank", desc = "fundTurnOutToBank")
    public String _fund_fund_turnout_bank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/getBalanceSetting", desc = "getBalSetting")
    public String _fund_getBalanceSetting(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/h5hry/open", desc = "openAccount4h5")
    public String _fund_h5hry_open(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/open-fundaccount", desc = "openFundAccount")
    public String _fund_open_fundaccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/queryFundBill", desc = "queryFundBill")
    public String _fund_queryFundBill(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/queryMyFund", desc = "queryMyFund")
    public String _fund_queryMyFund(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/queryOrderDetail", desc = "queryOrderDetail")
    public String _fund_queryOrderDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/queryTtjLimit", desc = "queryTtjLimit")
    public String _fund_queryTtjLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/shift-new", desc = "shiftNewFund")
    public String _fund_shift_new(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/summary", desc = "queryFundSummary")
    public String _fund_summary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/transfer/qualification", desc = "查询用户是否可以把天天聚转入存管账户")
    public String _fund_transfer_qualification(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/updateBalanceSetting", desc = "updateBalSetting")
    public String _fund_updateBalanceSetting(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/v2/fund-in", desc = "newFundIn")
    public String _fund_v2_fund_in(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/v2/fund-query-order", desc = "queryFundOrderForV2")
    public String _fund_v2_fund_query_order(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fund/v2/updateBalanceSetting", desc = "updateBalSettingV2")
    public String _fund_v2_updateBalanceSetting(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/h5/asset/kjt-acct-balance", desc = "queryKjtAndTtjBalance")
    public String _h5_asset_kjt_acct_balance(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/h5/asset/summary", desc = "顺逛资产查询")
    public String _h5_asset_summary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/h5/dep/account-info", desc = "查询H5用户的账户信息")
    public String _h5_dep_account_info(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/h5/investment/bid/benefit-permillion", desc = "getBenefitPerMillion")
    public String _h5_investment_bid_benefit_permillion(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/h5/investment/p2p-records", desc = "queryUserP2PInvestRecords")
    public String _h5_investment_p2p_records(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/haier/account/bind", desc = "海尔集团用户绑定")
    public String _haier_account_bind(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/haier/sign-in", desc = "海尔集团用户登录")
    public String _haier_sign_in(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home-dispatch/hot-bid-list", desc = "热门推荐标的列表查询-v3.0.2")
    public String _home_dispatch_hot_bid_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home-dispatch/news", desc = "新闻列表")
    public String _home_dispatch_news(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home-dispatch/novice-bid-list", desc = "新客专享标的查询")
    public String _home_dispatch_novice_bid_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home-dispatch/recommend-bid-list", desc = "查询预约专区和精选投资列表")
    public String _home_dispatch_recommend_bid_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home-dispatch/top-area-dashboard", desc = "查询顶部banner和运营活动区信息")
    public String _home_dispatch_top_area_dashboard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home/dialogs", desc = "newDialogs")
    public String _home_dialogs(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home/h5", desc = "h5home")
    public String _home_h5(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home/headers", desc = "headers")
    public String _home_headers(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home/queryHryStat", desc = "queryHryStat")
    public String _home_queryHryStat(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home/queryRecommendBid", desc = "queryRecommendBid")
    public String _home_queryRecommendBid(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home/user-asset", desc = "queryMyAsset")
    public String _home_user_asset(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/home/v2", desc = "home")
    public String _home_v2(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/bid/detail", desc = "债权投资人查看债权详情")
    public String _huijin_bid_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/bid/list", desc = "queryHuijinBidList")
    public String _huijin_bid_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/bid/prebuy", desc = "prebuy")
    public String _huijin_bid_prebuy(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/bid/purchase-result", desc = "queryInvestOrder")
    public String _huijin_bid_purchase_result(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/bid/purchase/prepare", desc = "拾财计划申购")
    public String _huijin_bid_purchase_prepare(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/bid/recommend-list", desc = "queryTop3BidList")
    public String _huijin_bid_recommend_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/cancel", desc = "cancel")
    public String _huijin_cancel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/publish", desc = "发起转让申请")
    public String _huijin_publish(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/queryHuijinRecord", desc = "queryHuijinRecord")
    public String _huijin_queryHuijinRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/queryHuijinRecordDetail", desc = "拾财计划发起人查询计划详情")
    public String _huijin_queryHuijinRecordDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/queryMyBuybackSummary", desc = "queryMyBuybackSummary")
    public String _huijin_queryMyBuybackSummary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/queryPlan", desc = "queryPlan")
    public String _huijin_queryPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijin/queryPublishInfo", desc = "转让发起人查询用于转让的计划")
    public String _huijin_queryPublishInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lcj/exchange", desc = "exchange")
    public String _lcj_exchange(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lcj/exchange-coupon/list", desc = "queryToBeExchangedCoupons")
    public String _lcj_exchange_coupon_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lcj/getLcjBalance", desc = "getLcjBalance")
    public String _lcj_getLcjBalance(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lcj/getLcjDetails", desc = "getLcjDetails")
    public String _lcj_getLcjDetails(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/login", desc = "会员登录，建议使用/sign-in接口")
    public String _login(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/logout", desc = "退出")
    public String _logout(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member-grade/definition", desc = "queryMemberGradeDefinition")
    public String _member_grade_definition(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member-grade/home", desc = "home")
    public String _member_grade_home(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member-grade/privilege", desc = "queryMemberPrivilege")
    public String _member_grade_privilege(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member-grade/privilege-detail", desc = "queryMemberGradePrivilegeDetail")
    public String _member_grade_privilege_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member-grade/query-rewards-message", desc = "queryUserRewardsMessage")
    public String _member_grade_query_rewards_message(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member-grade/upgrade-gift", desc = "queryUserRewardsAfterUpgrade")
    public String _member_grade_upgrade_gift(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/acct-attrs", desc = "查询用户的账户属性信息-v3.0.2")
    public String _member_acct_attrs(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/agreeNewUserLicense", desc = "agreeNewUserLicense")
    public String _member_agreeNewUserLicense(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/check-account", desc = "checkAccount")
    public String _member_check_account(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/checkAccount4FindPassword", desc = "checkAccount4FindPassword")
    public String _member_checkAccount4FindPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/dep-elements", desc = "存管开户前查询用户资料")
    public String _member_dep_elements(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/dialogs", desc = "dialogs")
    public String _member_dialogs(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/get-bank-CardList", desc = "getBankCardList")
    public String _member_get_bank_CardList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/homepage/app-list", desc = "我的应用列表-V3.0.2")
    public String _member_homepage_app_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/homepage/app-list/v3", desc = "我的应用列表-V3.0.2")
    public String _member_homepage_app_list_v3(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/homepage/asset-allocation", desc = "查询账户资产配置信息-v3.0.2")
    public String _member_homepage_asset_allocation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/homepage/brief-account-info", desc = "查询账户简要信息-v3.0.2")
    public String _member_homepage_brief_account_info(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/homepage/my-assets", desc = "我的总资产-v3.0.2")
    public String _member_homepage_my_assets(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/p2p/check-account", desc = "p2pCheckAccount")
    public String _member_p2p_check_account(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/queryCurrentUser", desc = "queryCurrentUser")
    public String _member_queryCurrentUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/queryUserStatusForH5", desc = "queryUserStatusForH5")
    public String _member_queryUserStatusForH5(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/risk-assessment/perform", desc = "riskAssessmentPerform")
    public String _member_risk_assessment_perform(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/risk-assessment/questions", desc = "queryRiskAssessmentTopics")
    public String _member_risk_assessment_questions(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/upgradingAccount", desc = "upgradeAccount")
    public String _member_upgradingAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/v2/get-accountInfo", desc = "getAccountInfoV2")
    public String _member_v2_get_accountInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/verify-account", desc = "verifyAccount")
    public String _member_verify_account(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/verify-idCard", desc = "verifyIdCard")
    public String _member_verify_idCard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/verify-phone-bind-status", desc = "checkWhetherPhoneWasBound")
    public String _member_verify_phone_bind_status(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/member/ym/check-account", desc = "ymcheckAccount")
    public String _member_ym_check_account(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/message/queryMessage", desc = "getMessage")
    public String _message_queryMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/message/queryMessageReadStatusStat", desc = "getMessageReadStatus")
    public String _message_queryMessageReadStatusStat(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/message/queryYellowBarMessage", desc = "queryYellowBarMessage")
    public String _message_queryYellowBarMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/message/setAllMessageRead", desc = "setAllMessageRead")
    public String _message_setAllMessageRead(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/message/setMessageRead", desc = "setMessageRead")
    public String _message_setMessageRead(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/mng/iosIsVerify", desc = "iosIsVerify")
    public String _mng_iosIsVerify(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/mng/queryMaintence", desc = "systemMaintence")
    public String _mng_queryMaintence(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/newGuestGift", desc = "查询新手大礼包")
    public String _newGuestGift(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/one-annua/gameReword", desc = "gameReword")
    public String _operation_one_annua_gameReword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/query-scratch", desc = "queryScratchAfterInvest")
    public String _operation_query_scratch(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/query1111Activity", desc = "query1111Activity")
    public String _operation_query1111Activity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/queryInvestStat4Wakeup", desc = "queryInvestStat4Wakeup")
    public String _operation_queryInvestStat4Wakeup(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/queryWakeupList", desc = "queryWakeupList")
    public String _operation_queryWakeupList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/recommendActivity", desc = "queryRecommendActivity")
    public String _operation_recommendActivity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/recommendProfit", desc = "queryRecommendProfit")
    public String _operation_recommendProfit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/scratch-ticket", desc = "scratchTicket")
    public String _operation_scratch_ticket(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/scratch/perform", desc = "scratchTicketAdaptor")
    public String _operation_scratch_perform(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/scratch/query", desc = "scratchQueryAdaptor")
    public String _operation_scratch_query(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/operation/taskList", desc = "taskList")
    public String _operation_taskList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oss/banner-list", desc = "根据位置查询Banner")
    public String _oss_banner_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oss/getDiscoveryDetail", desc = "getDiscoveryDetail")
    public String _oss_getDiscoveryDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oss/getMiscContent", desc = "getMiscContent")
    public String _oss_getMiscContent(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oss/getMiscContentList", desc = "getMiscContentList")
    public String _oss_getMiscContentList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/password/set-password", desc = "setPassword")
    public String _password_set_password(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/password/update-password", desc = "updatePassword")
    public String _password_update_password(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotion/query-promoter", desc = "queryPromoter")
    public String _promotion_query_promoter(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotion/queryShareInfo", desc = "promoteUri")
    public String _promotion_queryShareInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/promotion/uri", desc = "promoteUri")
    public String _promotion_uri(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryLatestCategoryUpdate", desc = "queryLatestCategoryUpdate")
    public String _queryLatestCategoryUpdate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/share/bid-detail-share", desc = "标的详情分享")
    public String _share_bid_detail_share(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sign-in", desc = "用户登录")
    public String _sign_in(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sms/checkVerifyCode", desc = "checkVerifyCode")
    public String _sms_checkVerifyCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sms/sendEmailVerifyCode", desc = "sendEmailVerifyCode")
    public String _sms_sendEmailVerifyCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sms/sendSMS", desc = "sendSMS")
    public String _sms_sendSMS(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tender/p2p/order-result", desc = "查看p2p标的投资下单结果")
    public String _tender_p2p_order_result(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tender/p2p/place-order", desc = "存管p2p标的投资下单")
    public String _tender_p2p_place_order(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/v2/register", desc = "注册并且设置登陆密码")
    public String _v2_register(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/version/backgroudCheck", desc = "checkAppVersion")
    public String _version_backgroudCheck(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/version/check", desc = "checkAppVersion")
    public String _version_check(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/withdraw/queryAllProvCities", desc = "queryAllProvinces")
    public String _withdraw_queryAllProvCities(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/withdraw/queryBranches", desc = "queryBranches")
    public String _withdraw_queryBranches(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/withdraw/queryFundoutLimit", desc = "queryFundoutLimit")
    public String _withdraw_queryFundoutLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/withdraw/queryNeedBankBranch", desc = "queryNeedBankBranch")
    public String _withdraw_queryNeedBankBranch(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/withdraw/withdraw-card", desc = "withdrawToCard")
    public String _withdraw_withdraw_card(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/aip/create", desc = "创建(或修改)定投计划")
    public String _ym_account_aip_create(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/aip/detail", desc = "查询定投计划的详情")
    public String _ym_account_aip_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/aip/histories", desc = "查询定投计划的历史记录列表")
    public String _ym_account_aip_histories(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/aip/list", desc = "查询定投计划列表")
    public String _ym_account_aip_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/aip/next-pay-time", desc = "根据用户输入的定投周期查询下一次自动扣款的时间")
    public String _ym_account_aip_next_pay_time(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/aip/update-status", desc = "修改定投计划的状态")
    public String _ym_account_aip_update_status(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/attributes", desc = "查询用户账户属性")
    public String _ym_account_attributes(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/bank-card/list", desc = "查询盈米绑定的银行卡")
    public String _ym_account_bank_card_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/hold-position-history", desc = "查询我的持仓历史记录")
    public String _ym_account_hold_position_history(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/my-fund-detail", desc = "查询用户持有基金的详情")
    public String _ym_account_my_fund_detail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/my-fund-list", desc = "查询用户的持仓基金列表")
    public String _ym_account_my_fund_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-account/share-info", desc = "基金赎回之前查询基金份额的相关信息")
    public String _ym_account_share_info(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-fund/redeem", desc = "赎回")
    public String _ym_fund_redeem(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-fund/simple-info", desc = "查询基金的一些简要信息")
    public String _ym_fund_simple_info(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-result/query", desc = "交易结果查询")
    public String _ym_result_query(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ym-result/trade-record-list", desc = "查询用户某个基金的的交易记录列表")
    public String _ym_result_trade_record_list(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
