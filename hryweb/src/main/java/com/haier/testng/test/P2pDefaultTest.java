package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.P2pBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: P2pDefaultTest
 * @Author: 自动生成
 * @Date: 2018/09/03 20:16:25
 */
@Slf4j
public class P2pDefaultTest extends P2pBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/agreementFacade/addProductInstruction", dataProvider = "provider", description = "增加产品说明书")
    public void agreementFacade_addProductInstruction(HryTest hryTest) {
        String actual = this._agreementFacade_addProductInstruction(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getAgreementTemplate", dataProvider = "provider", description = "根据标的ID获取协议模版")
    public void agreementFacade_getAgreementTemplate(HryTest hryTest) {
        String actual = this._agreementFacade_getAgreementTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getBidAgreement", dataProvider = "provider", description = "根据标的ID获取协议")
    public void agreementFacade_getBidAgreement(HryTest hryTest) {
        String actual = this._agreementFacade_getBidAgreement(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getHuijinAgreementTemplate", dataProvider = "provider", description = "根据债权ID获取拾财计划协议模版")
    public void agreementFacade_getHuijinAgreementTemplate(HryTest hryTest) {
        String actual = this._agreementFacade_getHuijinAgreementTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getHuijinContract", dataProvider = "provider", description = "获取合同内容")
    public void agreementFacade_getHuijinContract(HryTest hryTest) {
        String actual = this._agreementFacade_getHuijinContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getProductContract", dataProvider = "provider", description = "获取合同内容")
    public void agreementFacade_getProductContract(HryTest hryTest) {
        String actual = this._agreementFacade_getProductContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getProductInstructionList", dataProvider = "provider", description = "获取产品说明书列表")
    public void agreementFacade_getProductInstructionList(HryTest hryTest) {
        String actual = this._agreementFacade_getProductInstructionList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getProductInstructions", dataProvider = "provider", description = "根据标的ID获取产品说明书")
    public void agreementFacade_getProductInstructions(HryTest hryTest) {
        String actual = this._agreementFacade_getProductInstructions(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/getTransferOfDebtContract", dataProvider = "provider", description = "获取债转合同内容")
    public void agreementFacade_getTransferOfDebtContract(HryTest hryTest) {
        String actual = this._agreementFacade_getTransferOfDebtContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/queryProductInstruction", dataProvider = "provider", description = "获取产品说明书")
    public void agreementFacade_queryProductInstruction(HryTest hryTest) {
        String actual = this._agreementFacade_queryProductInstruction(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/agreementFacade/updateProductInstructions", dataProvider = "provider", description = "更新产品说明书")
    public void agreementFacade_updateProductInstructions(HryTest hryTest) {
        String actual = this._agreementFacade_updateProductInstructions(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/alterNativeRechargeFacade/addAlterNativeRecharge", dataProvider = "provider", description = "代充值")
    public void alterNativeRechargeFacade_addAlterNativeRecharge(HryTest hryTest) {
        String actual = this._alterNativeRechargeFacade_addAlterNativeRecharge(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/alterNativeRechargeFacade/queryAlterNativeList", dataProvider = "provider", description = "查询代充值列表")
    public void alterNativeRechargeFacade_queryAlterNativeList(HryTest hryTest) {
        String actual = this._alterNativeRechargeFacade_queryAlterNativeList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/assetsResourceFacade/loan", dataProvider = "provider", description = "线上放款")
    public void assetsResourceFacade_loan(HryTest hryTest) {
        String actual = this._assetsResourceFacade_loan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/assetsResourceFacade/queryAssets", dataProvider = "provider", description = "查询资产信息")
    public void assetsResourceFacade_queryAssets(HryTest hryTest) {
        String actual = this._assetsResourceFacade_queryAssets(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/assetsResourceFacade/updateAssfinance", dataProvider = "provider", description = "线上融资(标的发布/废弃)")
    public void assetsResourceFacade_updateAssfinance(HryTest hryTest) {
        String actual = this._assetsResourceFacade_updateAssfinance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/assistFacade/updateBidInfoById", dataProvider = "provider", description = "更改标的信息")
    public void assistFacade_updateBidInfoById(HryTest hryTest) {
        String actual = this._assistFacade_updateBidInfoById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/assistFacade/updateEnclosureByBid", dataProvider = "provider", description = "更新标的附件")
    public void assistFacade_updateEnclosureByBid(HryTest hryTest) {
        String actual = this._assistFacade_updateEnclosureByBid(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/assistFacade/updateSystemVariable", dataProvider = "provider", description = "更改配置")
    public void assistFacade_updateSystemVariable(HryTest hryTest) {
        String actual = this._assistFacade_updateSystemVariable(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/getAggregatedBidDetail", dataProvider = "provider", description = "查询聚合标的信息，包括标的基础信息、项目描述、借款方信息、风险措施、审核信息")
    public void bidFacade_getAggregatedBidDetail(HryTest hryTest) {
        String actual = this._bidFacade_getAggregatedBidDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/getBidCategoryList", dataProvider = "provider", description = "获取标的Tag")
    public void bidFacade_getBidCategoryList(HryTest hryTest) {
        String actual = this._bidFacade_getBidCategoryList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/getBidDetailByIdList", dataProvider = "provider", description = "根据List[Id]查询标的信息(不包含消金标的)")
    public void bidFacade_getBidDetailByIdList(HryTest hryTest) {
        String actual = this._bidFacade_getBidDetailByIdList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/getBidRuleConfigById", dataProvider = "provider", description = "根据ID获取标的配置规则")
    public void bidFacade_getBidRuleConfigById(HryTest hryTest) {
        String actual = this._bidFacade_getBidRuleConfigById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/getBidTypeList", dataProvider = "provider", description = "获取标的Type")
    public void bidFacade_getBidTypeList(HryTest hryTest) {
        String actual = this._bidFacade_getBidTypeList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/getTotalAmountBybidAndUser", dataProvider = "provider", description = "根据用户获取指定标的累计投资金额")
    public void bidFacade_getTotalAmountBybidAndUser(HryTest hryTest) {
        String actual = this._bidFacade_getTotalAmountBybidAndUser(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/queryBidDetailByIdList", dataProvider = "provider", description = "根据List[Id]查询标的信息（所有的包含消金标的信息）")
    public void bidFacade_queryBidDetailByIdList(HryTest hryTest) {
        String actual = this._bidFacade_queryBidDetailByIdList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/queryBidListCond", dataProvider = "provider", description = "根据条件查询标的信息")
    public void bidFacade_queryBidListCond(HryTest hryTest) {
        String actual = this._bidFacade_queryBidListCond(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/queryBidRuleConfigByCondition", dataProvider = "provider", description = "根据条件查询标的配置规则")
    public void bidFacade_queryBidRuleConfigByCondition(HryTest hryTest) {
        String actual = this._bidFacade_queryBidRuleConfigByCondition(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/queryCouponBidListByQueryCond", dataProvider = "provider", description = "根据条件查询标的信息列表(投资券筛选可投标的)")
    public void bidFacade_queryCouponBidListByQueryCond(HryTest hryTest) {
        String actual = this._bidFacade_queryCouponBidListByQueryCond(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/queryExchangeInfo", dataProvider = "provider", description = "查询所有交易所信息")
    public void bidFacade_queryExchangeInfo(HryTest hryTest) {
        String actual = this._bidFacade_queryExchangeInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/queryLcjBidListByQueryCond", dataProvider = "provider", description = "根据条件查询标的信息列表(理财金筛选可投标的)")
    public void bidFacade_queryLcjBidListByQueryCond(HryTest hryTest) {
        String actual = this._bidFacade_queryLcjBidListByQueryCond(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/saveBidRuleConfig", dataProvider = "provider", description = "新增标的配置规则")
    public void bidFacade_saveBidRuleConfig(HryTest hryTest) {
        String actual = this._bidFacade_saveBidRuleConfig(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/updateBidRuleConfig", dataProvider = "provider", description = "修改标的配置规则")
    public void bidFacade_updateBidRuleConfig(HryTest hryTest) {
        String actual = this._bidFacade_updateBidRuleConfig(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bidFacade/updateBidRuleConfigEnabledStatus", dataProvider = "provider", description = "修改标的配置启用状态")
    public void bidFacade_updateBidRuleConfigEnabledStatus(HryTest hryTest) {
        String actual = this._bidFacade_updateBidRuleConfigEnabledStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/caculateCfRepayPlan", dataProvider = "provider", description = "根据预约计划编号计算还款计划")
    public void cfFacade_caculateCfRepayPlan(HryTest hryTest) {
        String actual = this._cfFacade_caculateCfRepayPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/createReserveOrder", dataProvider = "provider", description = "预约投资（消金下单）")
    public void cfFacade_createReserveOrder(HryTest hryTest) {
        String actual = this._cfFacade_createReserveOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/examineOrAbandonCfPlan", dataProvider = "provider", description = "审批／废弃 预约计划")
    public void cfFacade_examineOrAbandonCfPlan(HryTest hryTest) {
        String actual = this._cfFacade_examineOrAbandonCfPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/generateCfReservationPlan", dataProvider = "provider", description = "生成消金预约计划")
    public void cfFacade_generateCfReservationPlan(HryTest hryTest) {
        String actual = this._cfFacade_generateCfReservationPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getCfAgreementTemplate", dataProvider = "provider", description = "根据消金协议模版HTML")
    public void cfFacade_getCfAgreementTemplate(HryTest hryTest) {
        String actual = this._cfFacade_getCfAgreementTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getCfReservationPlan", dataProvider = "provider", description = "查询消金预约计划")
    public void cfFacade_getCfReservationPlan(HryTest hryTest) {
        String actual = this._cfFacade_getCfReservationPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getCfReserveInvestPage", dataProvider = "provider", description = "获取预约资产列表（console 后台专用）")
    public void cfFacade_getCfReserveInvestPage(HryTest hryTest) {
        String actual = this._cfFacade_getCfReserveInvestPage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getCfReserveOrderDetail", dataProvider = "provider", description = "获取预约记录详情（console 后台专用）")
    public void cfFacade_getCfReserveOrderDetail(HryTest hryTest) {
        String actual = this._cfFacade_getCfReserveOrderDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getCfReserveOrderPage", dataProvider = "provider", description = "获取预约记录列表（console 后台专用）")
    public void cfFacade_getCfReserveOrderPage(HryTest hryTest) {
        String actual = this._cfFacade_getCfReserveOrderPage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getInvestmentProperty", dataProvider = "provider", description = "获取用户投资资产信息")
    public void cfFacade_getInvestmentProperty(HryTest hryTest) {
        String actual = this._cfFacade_getInvestmentProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getInvestorInfoByBidId", dataProvider = "provider", description = "获取投资人投资信息")
    public void cfFacade_getInvestorInfoByBidId(HryTest hryTest) {
        String actual = this._cfFacade_getInvestorInfoByBidId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getMyInvestPlanRecord", dataProvider = "provider", description = "我的投资-计划")
    public void cfFacade_getMyInvestPlanRecord(HryTest hryTest) {
        String actual = this._cfFacade_getMyInvestPlanRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getMyReservationOrderInfo", dataProvider = "provider", description = "获取我的预约信息，包括订单总数量")
    public void cfFacade_getMyReservationOrderInfo(HryTest hryTest) {
        String actual = this._cfFacade_getMyReservationOrderInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getPlanAssetDetail", dataProvider = "provider", description = "我的预约：获取用户的计划资产详情")
    public void cfFacade_getPlanAssetDetail(HryTest hryTest) {
        String actual = this._cfFacade_getPlanAssetDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getPlanTradeDetail", dataProvider = "provider", description = "根据预约订单编码查询预约记录详情")
    public void cfFacade_getPlanTradeDetail(HryTest hryTest) {
        String actual = this._cfFacade_getPlanTradeDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getReservationPlanOrder", dataProvider = "provider", description = "根据预约订单号查询预约记录详情")
    public void cfFacade_getReservationPlanOrder(HryTest hryTest) {
        String actual = this._cfFacade_getReservationPlanOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getReservationPlanOrderDetail", dataProvider = "provider", description = "根据预约订单编码查询预约记录详情")
    public void cfFacade_getReservationPlanOrderDetail(HryTest hryTest) {
        String actual = this._cfFacade_getReservationPlanOrderDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getReserveOrderByRequestNo", dataProvider = "provider", description = "查询预约投资（消金下单）订单及状态")
    public void cfFacade_getReserveOrderByRequestNo(HryTest hryTest) {
        String actual = this._cfFacade_getReserveOrderByRequestNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/getReserveOrderDetail", dataProvider = "provider", description = "查询预约订单详情(H5专用)")
    public void cfFacade_getReserveOrderDetail(HryTest hryTest) {
        String actual = this._cfFacade_getReserveOrderDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryBiddingOrder", dataProvider = "provider", description = "根据预约计划查询已购买标的")
    public void cfFacade_queryBiddingOrder(HryTest hryTest) {
        String actual = this._cfFacade_queryBiddingOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryCfBidByCfPlan", dataProvider = "provider", description = "根据预约计划查询标的信息（console 后台专用）")
    public void cfFacade_queryCfBidByCfPlan(HryTest hryTest) {
        String actual = this._cfFacade_queryCfBidByCfPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryCfOrderByCfPlan", dataProvider = "provider", description = "根据预约计划查询预约记录（console 后台专用）")
    public void cfFacade_queryCfOrderByCfPlan(HryTest hryTest) {
        String actual = this._cfFacade_queryCfOrderByCfPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryCfPlanByCondition", dataProvider = "provider", description = "根据条件查询预约计划(console 后台专用)")
    public void cfFacade_queryCfPlanByCondition(HryTest hryTest) {
        String actual = this._cfFacade_queryCfPlanByCondition(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryCfPlanDetail", dataProvider = "provider", description = "根据预约计划详情（console 后台专用）")
    public void cfFacade_queryCfPlanDetail(HryTest hryTest) {
        String actual = this._cfFacade_queryCfPlanDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryCouponReservationPlanByCond", dataProvider = "provider", description = "根据条件查询预约计划（投资券筛选可预约计划）")
    public void cfFacade_queryCouponReservationPlanByCond(HryTest hryTest) {
        String actual = this._cfFacade_queryCouponReservationPlanByCond(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryRepayRecord", dataProvider = "provider", description = "根据预约计划查询回款明细")
    public void cfFacade_queryRepayRecord(HryTest hryTest) {
        String actual = this._cfFacade_queryRepayRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryReservationPlanByStatus", dataProvider = "provider", description = "预约专区:根据预约状态查询预约记录列表，")
    public void cfFacade_queryReservationPlanByStatus(HryTest hryTest) {
        String actual = this._cfFacade_queryReservationPlanByStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryReservationPlanDetail", dataProvider = "provider", description = "预约详情:根据预约计划编号查询详情")
    public void cfFacade_queryReservationPlanDetail(HryTest hryTest) {
        String actual = this._cfFacade_queryReservationPlanDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryReservationPlanOrder", dataProvider = "provider", description = "我的预约列表：页面：交易记录-出借记录-预约列表")
    public void cfFacade_queryReservationPlanOrder(HryTest hryTest) {
        String actual = this._cfFacade_queryReservationPlanOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cfFacade/queryUnfreezeOrders", dataProvider = "provider", description = "解冻订单查询，后台管理专用")
    public void cfFacade_queryUnfreezeOrders(HryTest hryTest) {
        String actual = this._cfFacade_queryUnfreezeOrders(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/frontEndFacade/listReservationPlan", dataProvider = "provider", description = "获取消金计划列表")
    public void frontEndFacade_listReservationPlan(HryTest hryTest) {
        String actual = this._frontEndFacade_listReservationPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/frontEndFacade/queryNoviceBidDetail", dataProvider = "provider", description = "查询首页新手标的")
    public void frontEndFacade_queryNoviceBidDetail(HryTest hryTest) {
        String actual = this._frontEndFacade_queryNoviceBidDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/frontEndFacade/queryNoviceBidList", dataProvider = "provider", description = "查询首页新手标的,app专用")
    public void frontEndFacade_queryNoviceBidList(HryTest hryTest) {
        String actual = this._frontEndFacade_queryNoviceBidList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/applyDebtSale", dataProvider = "provider", description = "申请单笔债权出让")
    public void huijinPlanFacade_applyDebtSale(HryTest hryTest) {
        String actual = this._huijinPlanFacade_applyDebtSale(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/changeDebtType", dataProvider = "provider", description = "改变债权类型，用于债权转让")
    public void huijinPlanFacade_changeDebtType(HryTest hryTest) {
        String actual = this._huijinPlanFacade_changeDebtType(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/freezeAndApplyDebtSale", dataProvider = "provider", description = "冻结债权并且申请单笔债权出让")
    public void huijinPlanFacade_freezeAndApplyDebtSale(HryTest hryTest) {
        String actual = this._huijinPlanFacade_freezeAndApplyDebtSale(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/freezeDebt", dataProvider = "provider", description = "冻结债权")
    public void huijinPlanFacade_freezeDebt(HryTest hryTest) {
        String actual = this._huijinPlanFacade_freezeDebt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/getBidRecordIdByDebtId", dataProvider = "provider", description = "根据债权ID 查询投标记录ID")
    public void huijinPlanFacade_getBidRecordIdByDebtId(HryTest hryTest) {
        String actual = this._huijinPlanFacade_getBidRecordIdByDebtId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/getDebtInfo", dataProvider = "provider", description = "获取债权信息")
    public void huijinPlanFacade_getDebtInfo(HryTest hryTest) {
        String actual = this._huijinPlanFacade_getDebtInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/getDebtInfoByBidRecordId", dataProvider = "provider", description = "根据投标记录ID 查询债权信息")
    public void huijinPlanFacade_getDebtInfoByBidRecordId(HryTest hryTest) {
        String actual = this._huijinPlanFacade_getDebtInfoByBidRecordId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/getTradingRepayment", dataProvider = "provider", description = "获取债权转让后P2P还款详细信息")
    public void huijinPlanFacade_getTradingRepayment(HryTest hryTest) {
        String actual = this._huijinPlanFacade_getTradingRepayment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/lockDebt", dataProvider = "provider", description = "锁定/解锁债权")
    public void huijinPlanFacade_lockDebt(HryTest hryTest) {
        String actual = this._huijinPlanFacade_lockDebt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/loseDebt", dataProvider = "provider", description = "债权丧权")
    public void huijinPlanFacade_loseDebt(HryTest hryTest) {
        String actual = this._huijinPlanFacade_loseDebt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/transferDebt", dataProvider = "provider", description = "债权转让接口")
    public void huijinPlanFacade_transferDebt(HryTest hryTest) {
        String actual = this._huijinPlanFacade_transferDebt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/unfreezeAndCancelDebtSale", dataProvider = "provider", description = "解冻债权并且取消单笔债权出让")
    public void huijinPlanFacade_unfreezeAndCancelDebtSale(HryTest hryTest) {
        String actual = this._huijinPlanFacade_unfreezeAndCancelDebtSale(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/huijinPlanFacade/unfreezeDebt", dataProvider = "provider", description = "解冻债权")
    public void huijinPlanFacade_unfreezeDebt(HryTest hryTest) {
        String actual = this._huijinPlanFacade_unfreezeDebt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/createInvestOrder", dataProvider = "provider", description = "投资下单")
    public void investFacade_createInvestOrder(HryTest hryTest) {
        String actual = this._investFacade_createInvestOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getBiddingStatusByVoucherNo", dataProvider = "provider", description = "根据凭证号查询投标状态")
    public void investFacade_getBiddingStatusByVoucherNo(HryTest hryTest) {
        String actual = this._investFacade_getBiddingStatusByVoucherNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getInvestmentInfo", dataProvider = "provider", description = "获取用户投资信息")
    public void investFacade_getInvestmentInfo(HryTest hryTest) {
        String actual = this._investFacade_getInvestmentInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getInvestmentProperty", dataProvider = "provider", description = "获取用户投资资产信息")
    public void investFacade_getInvestmentProperty(HryTest hryTest) {
        String actual = this._investFacade_getInvestmentProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getInvestStatusByOrderId", dataProvider = "provider", description = "根据订单号查询投资状态")
    public void investFacade_getInvestStatusByOrderId(HryTest hryTest) {
        String actual = this._investFacade_getInvestStatusByOrderId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getInvestStatusByRequestNo", dataProvider = "provider", description = "根据用户预处理请求流水号查询投资状态(查询非消金投资)")
    public void investFacade_getInvestStatusByRequestNo(HryTest hryTest) {
        String actual = this._investFacade_getInvestStatusByRequestNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getMyInvestDetail", dataProvider = "provider", description = "查询我的投资交易详情")
    public void investFacade_getMyInvestDetail(HryTest hryTest) {
        String actual = this._investFacade_getMyInvestDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getNumberOfBidders", dataProvider = "provider", description = "获取标的ID获取该标的已经投资的人数")
    public void investFacade_getNumberOfBidders(HryTest hryTest) {
        String actual = this._investFacade_getNumberOfBidders(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getOfflineOrder", dataProvider = "provider", description = "获取用户海利计划投资记录")
    public void investFacade_getOfflineOrder(HryTest hryTest) {
        String actual = this._investFacade_getOfflineOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getOfflineProperty", dataProvider = "provider", description = "获取用户海利计划资产信息")
    public void investFacade_getOfflineProperty(HryTest hryTest) {
        String actual = this._investFacade_getOfflineProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/getUserPurchaseRecordListByHryId", dataProvider = "provider", description = "查询用户所有投资记录信息")
    public void investFacade_getUserPurchaseRecordListByHryId(HryTest hryTest) {
        String actual = this._investFacade_getUserPurchaseRecordListByHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/investCountStatistics", dataProvider = "provider", description = "根据hryIdList统计用户投资笔数")
    public void investFacade_investCountStatistics(HryTest hryTest) {
        String actual = this._investFacade_investCountStatistics(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/investCountStatisticsByHryId", dataProvider = "provider", description = "根据hryId统计单个用户投资笔数")
    public void investFacade_investCountStatisticsByHryId(HryTest hryTest) {
        String actual = this._investFacade_investCountStatisticsByHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/noviceCheck", dataProvider = "provider", description = "投标，新手效验")
    public void investFacade_noviceCheck(HryTest hryTest) {
        String actual = this._investFacade_noviceCheck(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryAllPrincipalAndInterestReceived", dataProvider = "provider", description = "根据hryId查询用户全部待收本息")
    public void investFacade_queryAllPrincipalAndInterestReceived(HryTest hryTest) {
        String actual = this._investFacade_queryAllPrincipalAndInterestReceived(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryInvestByCond", dataProvider = "provider", description = "查询条件查询投资列表（console后台）")
    public void investFacade_queryInvestByCond(HryTest hryTest) {
        String actual = this._investFacade_queryInvestByCond(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryInvestRecord", dataProvider = "provider", description = "获取我的投资列表信息")
    public void investFacade_queryInvestRecord(HryTest hryTest) {
        String actual = this._investFacade_queryInvestRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryMyInvest", dataProvider = "provider", description = "查询我的投资列表")
    public void investFacade_queryMyInvest(HryTest hryTest) {
        String actual = this._investFacade_queryMyInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryPurchaseCondByHryIdList", dataProvider = "provider", description = "批量查询指定用户的投资情况")
    public void investFacade_queryPurchaseCondByHryIdList(HryTest hryTest) {
        String actual = this._investFacade_queryPurchaseCondByHryIdList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryPurchaseRecordList", dataProvider = "provider", description = "查询投资记录")
    public void investFacade_queryPurchaseRecordList(HryTest hryTest) {
        String actual = this._investFacade_queryPurchaseRecordList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryRepaymentRecordList", dataProvider = "provider", description = "根据条件查询用户投资还款信息列表")
    public void investFacade_queryRepaymentRecordList(HryTest hryTest) {
        String actual = this._investFacade_queryRepaymentRecordList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investFacade/queryTotalMoney", dataProvider = "provider", description = "根据条件查询用户投资总金额")
    public void investFacade_queryTotalMoney(HryTest hryTest) {
        String actual = this._investFacade_queryTotalMoney(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investReservationFacade/addShortMsgBlackList", dataProvider = "provider", description = "添加短信黑名单")
    public void investReservationFacade_addShortMsgBlackList(HryTest hryTest) {
        String actual = this._investReservationFacade_addShortMsgBlackList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investReservationFacade/getInvestReservationList", dataProvider = "provider", description = "获取代客理财")
    public void investReservationFacade_getInvestReservationList(HryTest hryTest) {
        String actual = this._investReservationFacade_getInvestReservationList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investReservationFacade/getShortMsgBlackList", dataProvider = "provider", description = "获取短信黑名单列表")
    public void investReservationFacade_getShortMsgBlackList(HryTest hryTest) {
        String actual = this._investReservationFacade_getShortMsgBlackList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/investReservationFacade/removeFromBlackList", dataProvider = "provider", description = "允许短信")
    public void investReservationFacade_removeFromBlackList(HryTest hryTest) {
        String actual = this._investReservationFacade_removeFromBlackList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/loanByBid", dataProvider = "provider", description = "标的放款")
    public void loanFacade_loanByBid(HryTest hryTest) {
        String actual = this._loanFacade_loanByBid(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/loanByCommand", dataProvider = "provider", description = "单独调用一个命令，慎用")
    public void loanFacade_loanByCommand(HryTest hryTest) {
        String actual = this._loanFacade_loanByCommand(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/loanNotify", dataProvider = "provider", description = "异步通知，仅供测试")
    public void loanFacade_loanNotify(HryTest hryTest) {
        String actual = this._loanFacade_loanNotify(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/queryLoanBid", dataProvider = "provider", description = "查询待放款标的信息")
    public void loanFacade_queryLoanBid(HryTest hryTest) {
        String actual = this._loanFacade_queryLoanBid(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/queryLoanBidDetail", dataProvider = "provider", description = "查询放款标的信息")
    public void loanFacade_queryLoanBidDetail(HryTest hryTest) {
        String actual = this._loanFacade_queryLoanBidDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/queryLoanOrder", dataProvider = "provider", description = "查询已放款标的信息")
    public void loanFacade_queryLoanOrder(HryTest hryTest) {
        String actual = this._loanFacade_queryLoanOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/queryUserLoanOrders", dataProvider = "provider", description = "查询放款订单")
    public void loanFacade_queryUserLoanOrders(HryTest hryTest) {
        String actual = this._loanFacade_queryUserLoanOrders(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/resendContractMq", dataProvider = "provider", description = "合同系统MQ重发")
    public void loanFacade_resendContractMq(HryTest hryTest) {
        String actual = this._loanFacade_resendContractMq(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanFacade/specifyTransfer", dataProvider = "provider", description = "触发指定交易确认")
    public void loanFacade_specifyTransfer(HryTest hryTest) {
        String actual = this._loanFacade_specifyTransfer(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageFacade/messageFacade", dataProvider = "provider", description = "发送消息")
    public void messageFacade_messageFacade(HryTest hryTest) {
        String actual = this._messageFacade_messageFacade(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/addBatchOfflinePlan", dataProvider = "provider", description = "批量添加计划")
    public void offlinePlanFacade_addBatchOfflinePlan(HryTest hryTest) {
        String actual = this._offlinePlanFacade_addBatchOfflinePlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/addOfflinePlan", dataProvider = "provider", description = "添加计划")
    public void offlinePlanFacade_addOfflinePlan(HryTest hryTest) {
        String actual = this._offlinePlanFacade_addOfflinePlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/getOfflinePlan", dataProvider = "provider", description = "查询计划")
    public void offlinePlanFacade_getOfflinePlan(HryTest hryTest) {
        String actual = this._offlinePlanFacade_getOfflinePlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/getOfflinePlanDetail", dataProvider = "provider", description = "WEB-查询产品详情")
    public void offlinePlanFacade_getOfflinePlanDetail(HryTest hryTest) {
        String actual = this._offlinePlanFacade_getOfflinePlanDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/getUserInvestOrder", dataProvider = "provider", description = "获取用户投资订单")
    public void offlinePlanFacade_getUserInvestOrder(HryTest hryTest) {
        String actual = this._offlinePlanFacade_getUserInvestOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/getWhetherInvest", dataProvider = "provider", description = "是否发起投资")
    public void offlinePlanFacade_getWhetherInvest(HryTest hryTest) {
        String actual = this._offlinePlanFacade_getWhetherInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/invalidOrder", dataProvider = "provider", description = "作废订单")
    public void offlinePlanFacade_invalidOrder(HryTest hryTest) {
        String actual = this._offlinePlanFacade_invalidOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/listOfflineIssuerAndConsignee", dataProvider = "provider", description = "获取发行人和承销商信息")
    public void offlinePlanFacade_listOfflineIssuerAndConsignee(HryTest hryTest) {
        String actual = this._offlinePlanFacade_listOfflineIssuerAndConsignee(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/listOfflineRepayOrder", dataProvider = "provider", description = "获取用户还款订单")
    public void offlinePlanFacade_listOfflineRepayOrder(HryTest hryTest) {
        String actual = this._offlinePlanFacade_listOfflineRepayOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/listReleaseOfflinePlan", dataProvider = "provider", description = "WEB-查询上线产品列表")
    public void offlinePlanFacade_listReleaseOfflinePlan(HryTest hryTest) {
        String actual = this._offlinePlanFacade_listReleaseOfflinePlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/queryInvestByPage", dataProvider = "provider", description = "根据条件分页查询投资记录")
    public void offlinePlanFacade_queryInvestByPage(HryTest hryTest) {
        String actual = this._offlinePlanFacade_queryInvestByPage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/queryOfflinePlan", dataProvider = "provider", description = "分页查询计划")
    public void offlinePlanFacade_queryOfflinePlan(HryTest hryTest) {
        String actual = this._offlinePlanFacade_queryOfflinePlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/resetOfflineRepayOrder", dataProvider = "provider", description = "重置还款订单")
    public void offlinePlanFacade_resetOfflineRepayOrder(HryTest hryTest) {
        String actual = this._offlinePlanFacade_resetOfflineRepayOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/setOnOffOfOfflinePlan", dataProvider = "provider", description = "设置线下理财上下线")
    public void offlinePlanFacade_setOnOffOfOfflinePlan(HryTest hryTest) {
        String actual = this._offlinePlanFacade_setOnOffOfOfflinePlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/updateOfflinePlan", dataProvider = "provider", description = "修改计划")
    public void offlinePlanFacade_updateOfflinePlan(HryTest hryTest) {
        String actual = this._offlinePlanFacade_updateOfflinePlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/updateUserInvestOrder", dataProvider = "provider", description = "修改用户投资订单")
    public void offlinePlanFacade_updateUserInvestOrder(HryTest hryTest) {
        String actual = this._offlinePlanFacade_updateUserInvestOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/userInvest", dataProvider = "provider", description = "后台-用户预约")
    public void offlinePlanFacade_userInvest(HryTest hryTest) {
        String actual = this._offlinePlanFacade_userInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/offlinePlanFacade/userReservation", dataProvider = "provider", description = "WEB-用户预约")
    public void offlinePlanFacade_userReservation(HryTest hryTest) {
        String actual = this._offlinePlanFacade_userReservation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/orderFacade/exportPurchaseRecord", dataProvider = "provider", description = "导出查询投资记录")
    public void orderFacade_exportPurchaseRecord(HryTest hryTest) {
        String actual = this._orderFacade_exportPurchaseRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/orderFacade/getRealTimePurchaseRecord", dataProvider = "provider", description = "获取首页实时理财信息")
    public void orderFacade_getRealTimePurchaseRecord(HryTest hryTest) {
        String actual = this._orderFacade_getRealTimePurchaseRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/orderFacade/getRepaymentStatusByOrderIdList", dataProvider = "provider", description = "批量查询订单还款状态")
    public void orderFacade_getRepaymentStatusByOrderIdList(HryTest hryTest) {
        String actual = this._orderFacade_getRepaymentStatusByOrderIdList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/orderFacade/queryPurchaseRecord", dataProvider = "provider", description = "查询投资记录")
    public void orderFacade_queryPurchaseRecord(HryTest hryTest) {
        String actual = this._orderFacade_queryPurchaseRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/orderFacade/queryPurchaseRecordDetail", dataProvider = "provider", description = "根据投标记录查询标的信息")
    public void orderFacade_queryPurchaseRecordDetail(HryTest hryTest) {
        String actual = this._orderFacade_queryPurchaseRecordDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/platformMarkingFacade/addAlterNativeRecharge", dataProvider = "provider", description = "新增页面获取用户ID")
    public void platformMarkingFacade_addAlterNativeRecharge(HryTest hryTest) {
        String actual = this._platformMarkingFacade_addAlterNativeRecharge(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/platformMarkingFacade/creatPlatformMarking", dataProvider = "provider", description = "平台营销")
    public void platformMarkingFacade_creatPlatformMarking(HryTest hryTest) {
        String actual = this._platformMarkingFacade_creatPlatformMarking(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/platformMarkingFacade/queryAlterNativeList", dataProvider = "provider", description = "查询代充值列表")
    public void platformMarkingFacade_queryAlterNativeList(HryTest hryTest) {
        String actual = this._platformMarkingFacade_queryAlterNativeList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/platformMarkingFacade/selectUserInfo", dataProvider = "provider", description = "查询用户信息")
    public void platformMarkingFacade_selectUserInfo(HryTest hryTest) {
        String actual = this._platformMarkingFacade_selectUserInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/productFacade/generateBatchProduct", dataProvider = "provider", description = "批量发标")
    public void productFacade_generateBatchProduct(HryTest hryTest) {
        String actual = this._productFacade_generateBatchProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/productFacade/generateProduct", dataProvider = "provider", description = "发标接口")
    public void productFacade_generateProduct(HryTest hryTest) {
        String actual = this._productFacade_generateProduct(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/productFacade/getBatchReleaseLog", dataProvider = "provider", description = "批量发标记录查询")
    public void productFacade_getBatchReleaseLog(HryTest hryTest) {
        String actual = this._productFacade_getBatchReleaseLog(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/productFacade/queryEntrustPayOrder", dataProvider = "provider", description = "【console】查询委托支付授权订单")
    public void productFacade_queryEntrustPayOrder(HryTest hryTest) {
        String actual = this._productFacade_queryEntrustPayOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/productFacade/queryProductByCreditId", dataProvider = "provider", description = "确认发标是否成功")
    public void productFacade_queryProductByCreditId(HryTest hryTest) {
        String actual = this._productFacade_queryProductByCreditId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryTransferOfDebtFacade/getMyAssetByTransferOfDebt", dataProvider = "provider", description = "获取我的债转投资资产信息")
    public void queryTransferOfDebtFacade_getMyAssetByTransferOfDebt(HryTest hryTest) {
        String actual = this._queryTransferOfDebtFacade_getMyAssetByTransferOfDebt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryTransferOfDebtFacade/getRepaymentDetail", dataProvider = "provider", description = "获取回款债转详情")
    public void queryTransferOfDebtFacade_getRepaymentDetail(HryTest hryTest) {
        String actual = this._queryTransferOfDebtFacade_getRepaymentDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryTransferOfDebtFacade/listMyTransferOfDebt", dataProvider = "provider", description = "获取我的债转投资列表信息")
    public void queryTransferOfDebtFacade_listMyTransferOfDebt(HryTest hryTest) {
        String actual = this._queryTransferOfDebtFacade_listMyTransferOfDebt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryTransferOfDebtFacade/listRepaymentDetails", dataProvider = "provider", description = "获取回款债转列表")
    public void queryTransferOfDebtFacade_listRepaymentDetails(HryTest hryTest) {
        String actual = this._queryTransferOfDebtFacade_listRepaymentDetails(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/createAdjustAccountOrder", dataProvider = "provider", description = "创建调账订单")
    public void rechargeAndWithdrawFacade_createAdjustAccountOrder(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_createAdjustAccountOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/createRechargeOrder", dataProvider = "provider", description = "充值")
    public void rechargeAndWithdrawFacade_createRechargeOrder(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_createRechargeOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/createWithdrawOrder", dataProvider = "provider", description = "提现")
    public void rechargeAndWithdrawFacade_createWithdrawOrder(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_createWithdrawOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/directRecharge", dataProvider = "provider", description = "自动充值")
    public void rechargeAndWithdrawFacade_directRecharge(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_directRecharge(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/directWithdraw", dataProvider = "provider", description = "自动提现")
    public void rechargeAndWithdrawFacade_directWithdraw(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_directWithdraw(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryAdjustAccountOrder", dataProvider = "provider", description = "查询调账订单")
    public void rechargeAndWithdrawFacade_queryAdjustAccountOrder(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_queryAdjustAccountOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryRechargeList", dataProvider = "provider", description = "【console】查询充值订单列表")
    public void rechargeAndWithdrawFacade_queryRechargeList(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_queryRechargeList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryRechargeRecord", dataProvider = "provider", description = "前端查询充值交易记录")
    public void rechargeAndWithdrawFacade_queryRechargeRecord(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_queryRechargeRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryRechargeRecordDetail", dataProvider = "provider", description = "前端查询充值交易记录详情")
    public void rechargeAndWithdrawFacade_queryRechargeRecordDetail(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_queryRechargeRecordDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryWithdrawList", dataProvider = "provider", description = "【console】查询所有用户提现列表")
    public void rechargeAndWithdrawFacade_queryWithdrawList(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_queryWithdrawList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryWithdrawRecord", dataProvider = "provider", description = "前端查询用户提现订单")
    public void rechargeAndWithdrawFacade_queryWithdrawRecord(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_queryWithdrawRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryWithdrawRecordDetail", dataProvider = "provider", description = "前端查询提现交易详情")
    public void rechargeAndWithdrawFacade_queryWithdrawRecordDetail(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_queryWithdrawRecordDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/sumWithdrawPending", dataProvider = "provider", description = "查询提现中的总金额")
    public void rechargeAndWithdrawFacade_sumWithdrawPending(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_sumWithdrawPending(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/reconFacade/queryBackrollReconciliation", dataProvider = "provider", description = "查询资金回退充值订单对账信息")
    public void reconFacade_queryBackrollReconciliation(HryTest hryTest) {
        String actual = this._reconFacade_queryBackrollReconciliation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/reconFacade/queryCommissionInfo", dataProvider = "provider", description = "查询佣金对账信息")
    public void reconFacade_queryCommissionInfo(HryTest hryTest) {
        String actual = this._reconFacade_queryCommissionInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/reconFacade/queryRechargeReconciliation", dataProvider = "provider", description = "查询充值订单对账信息")
    public void reconFacade_queryRechargeReconciliation(HryTest hryTest) {
        String actual = this._reconFacade_queryRechargeReconciliation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/reconFacade/queryReconInfo", dataProvider = "provider", description = "查询交易对账信息")
    public void reconFacade_queryReconInfo(HryTest hryTest) {
        String actual = this._reconFacade_queryReconInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/reconFacade/queryWithdrawReconciliation", dataProvider = "provider", description = "查询提现充值订单对账信息")
    public void reconFacade_queryWithdrawReconciliation(HryTest hryTest) {
        String actual = this._reconFacade_queryWithdrawReconciliation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/regionFacade/getSubRegion", dataProvider = "provider", description = "根据ID查询上级地区信息")
    public void regionFacade_getSubRegion(HryTest hryTest) {
        String actual = this._regionFacade_getSubRegion(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/regionFacade/regionInfo", dataProvider = "provider", description = "查询地区信息接口")
    public void regionFacade_regionInfo(HryTest hryTest) {
        String actual = this._regionFacade_regionInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/financierRepayment", dataProvider = "provider", description = "融资人还款")
    public void repaymentFacade_financierRepayment(HryTest hryTest) {
        String actual = this._repaymentFacade_financierRepayment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/financierRepaymentWithExinterest", dataProvider = "provider", description = "融资人还款(无息)。场景：募集成功、放款后，借款人又不借了。")
    public void repaymentFacade_financierRepaymentWithExinterest(HryTest hryTest) {
        String actual = this._repaymentFacade_financierRepaymentWithExinterest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/financierStatistics", dataProvider = "provider", description = "融资统计")
    public void repaymentFacade_financierStatistics(HryTest hryTest) {
        String actual = this._repaymentFacade_financierStatistics(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/getBidHkjh", dataProvider = "provider", description = "查询标的标还款记录(标的应还款信息查询接口)")
    public void repaymentFacade_getBidHkjh(HryTest hryTest) {
        String actual = this._repaymentFacade_getBidHkjh(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/getFinancierRepaymentOrder", dataProvider = "provider", description = "查询融资人还款记录 详情")
    public void repaymentFacade_getFinancierRepaymentOrder(HryTest hryTest) {
        String actual = this._repaymentFacade_getFinancierRepaymentOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/getInvestorRepaymentDetail", dataProvider = "provider", description = "查询投资人收款明细详情")
    public void repaymentFacade_getInvestorRepaymentDetail(HryTest hryTest) {
        String actual = this._repaymentFacade_getInvestorRepaymentDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/getRepayingDetail", dataProvider = "provider", description = "查询最近一期还款详情")
    public void repaymentFacade_getRepayingDetail(HryTest hryTest) {
        String actual = this._repaymentFacade_getRepayingDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/getReserveRepaymentDetail", dataProvider = "provider", description = "查询投资人-预约回款详情")
    public void repaymentFacade_getReserveRepaymentDetail(HryTest hryTest) {
        String actual = this._repaymentFacade_getReserveRepaymentDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/listFinancierRepaymentOrders", dataProvider = "provider", description = "查询融资人还款记录")
    public void repaymentFacade_listFinancierRepaymentOrders(HryTest hryTest) {
        String actual = this._repaymentFacade_listFinancierRepaymentOrders(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/listFinancierRepaymentOrdersConsole", dataProvider = "provider", description = "查询融资人还款记录（console使用）")
    public void repaymentFacade_listFinancierRepaymentOrdersConsole(HryTest hryTest) {
        String actual = this._repaymentFacade_listFinancierRepaymentOrdersConsole(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/listFinancierRepaymentPlans", dataProvider = "provider", description = "查询标的还款明细")
    public void repaymentFacade_listFinancierRepaymentPlans(HryTest hryTest) {
        String actual = this._repaymentFacade_listFinancierRepaymentPlans(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/listInvestorRepaymentDetails", dataProvider = "provider", description = "查询投资人收款明细")
    public void repaymentFacade_listInvestorRepaymentDetails(HryTest hryTest) {
        String actual = this._repaymentFacade_listInvestorRepaymentDetails(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/listInvestorRepaymentDetailsConsole", dataProvider = "provider", description = "查询投资人收款明细（Console使用）")
    public void repaymentFacade_listInvestorRepaymentDetailsConsole(HryTest hryTest) {
        String actual = this._repaymentFacade_listInvestorRepaymentDetailsConsole(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/prepayment", dataProvider = "provider", description = "融资人提前还款")
    public void repaymentFacade_prepayment(HryTest hryTest) {
        String actual = this._repaymentFacade_prepayment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/prepaymentApplication", dataProvider = "provider", description = "提前还款申请与审核")
    public void repaymentFacade_prepaymentApplication(HryTest hryTest) {
        String actual = this._repaymentFacade_prepaymentApplication(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryBiddersHkjh", dataProvider = "provider", description = "查询用户投标还款计划信息")
    public void repaymentFacade_queryBiddersHkjh(HryTest hryTest) {
        String actual = this._repaymentFacade_queryBiddersHkjh(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryCfBiddingOrderHkjh", dataProvider = "provider", description = "查询用户预约标的还款计划信息")
    public void repaymentFacade_queryCfBiddingOrderHkjh(HryTest hryTest) {
        String actual = this._repaymentFacade_queryCfBiddingOrderHkjh(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryExistsPrepaymentPlan", dataProvider = "provider", description = "查询已经提前还款的计划详情")
    public void repaymentFacade_queryExistsPrepaymentPlan(HryTest hryTest) {
        String actual = this._repaymentFacade_queryExistsPrepaymentPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryPerfectHkjh", dataProvider = "provider", description = "查询标的还款计划")
    public void repaymentFacade_queryPerfectHkjh(HryTest hryTest) {
        String actual = this._repaymentFacade_queryPerfectHkjh(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryPrepaymentApplication", dataProvider = "provider", description = "查询提前还款标的信息")
    public void repaymentFacade_queryPrepaymentApplication(HryTest hryTest) {
        String actual = this._repaymentFacade_queryPrepaymentApplication(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryPrepaymentPlan", dataProvider = "provider", description = "查询提前还款计划")
    public void repaymentFacade_queryPrepaymentPlan(HryTest hryTest) {
        String actual = this._repaymentFacade_queryPrepaymentPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryRepayingBids", dataProvider = "provider", description = "查询还款中标的")
    public void repaymentFacade_queryRepayingBids(HryTest hryTest) {
        String actual = this._repaymentFacade_queryRepayingBids(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryRepaymentBids", dataProvider = "provider", description = "融资查询")
    public void repaymentFacade_queryRepaymentBids(HryTest hryTest) {
        String actual = this._repaymentFacade_queryRepaymentBids(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryRepaymentDetail", dataProvider = "provider", description = "【console】查询标的还款、代偿详情")
    public void repaymentFacade_queryRepaymentDetail(HryTest hryTest) {
        String actual = this._repaymentFacade_queryRepaymentDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryRepaymentList", dataProvider = "provider", description = "【console】查询标的还款、代偿列表")
    public void repaymentFacade_queryRepaymentList(HryTest hryTest) {
        String actual = this._repaymentFacade_queryRepaymentList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryReserveRepaymentDetails", dataProvider = "provider", description = "查询投资人-预约回款列表")
    public void repaymentFacade_queryReserveRepaymentDetails(HryTest hryTest) {
        String actual = this._repaymentFacade_queryReserveRepaymentDetails(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/querySettledBids", dataProvider = "provider", description = "查询已结清标的")
    public void repaymentFacade_querySettledBids(HryTest hryTest) {
        String actual = this._repaymentFacade_querySettledBids(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/queryUnpaidBidDetail", dataProvider = "provider", description = "【console】查询待还款标的详情")
    public void repaymentFacade_queryUnpaidBidDetail(HryTest hryTest) {
        String actual = this._repaymentFacade_queryUnpaidBidDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/rebuildInvestorRepaymentDetailsConsole", dataProvider = "provider", description = "重发失败的还款确认明细（Console使用）")
    public void repaymentFacade_rebuildInvestorRepaymentDetailsConsole(HryTest hryTest) {
        String actual = this._repaymentFacade_rebuildInvestorRepaymentDetailsConsole(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/repaymentFacade/reserveRepayment", dataProvider = "provider", description = "预约还款")
    public void repaymentFacade_reserveRepayment(HryTest hryTest) {
        String actual = this._repaymentFacade_reserveRepayment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/stockPrepaymentApplyFacade/applyStockPrepayment", dataProvider = "provider", description = "存量数据申请提前还款")
    public void stockPrepaymentApplyFacade_applyStockPrepayment(HryTest hryTest) {
        String actual = this._stockPrepaymentApplyFacade_applyStockPrepayment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/stockPrepaymentApplyFacade/listStockPrepayment", dataProvider = "provider", description = "根据条件查询存量提前还款列表")
    public void stockPrepaymentApplyFacade_listStockPrepayment(HryTest hryTest) {
        String actual = this._stockPrepaymentApplyFacade_listStockPrepayment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/stockPrepaymentApplyFacade/listStockPrepaymentByIds", dataProvider = "provider", description = "根据条件查询存量提前还款列表")
    public void stockPrepaymentApplyFacade_listStockPrepaymentByIds(HryTest hryTest) {
        String actual = this._stockPrepaymentApplyFacade_listStockPrepaymentByIds(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addBatchEnclosure", dataProvider = "provider", description = "新增批量附件")
    public void tenderFacade_addBatchEnclosure(HryTest hryTest) {
        String actual = this._tenderFacade_addBatchEnclosure(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addBidExtraInfo", dataProvider = "provider", description = "新增标的附加信息")
    public void tenderFacade_addBidExtraInfo(HryTest hryTest) {
        String actual = this._tenderFacade_addBidExtraInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addBidLabel", dataProvider = "provider", description = "新增标的的标签")
    public void tenderFacade_addBidLabel(HryTest hryTest) {
        String actual = this._tenderFacade_addBidLabel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addCarBidDetail", dataProvider = "provider", description = "保存车抵押表抵押物信息")
    public void tenderFacade_addCarBidDetail(HryTest hryTest) {
        String actual = this._tenderFacade_addCarBidDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addCarBidDetailList", dataProvider = "provider", description = "保存车抵押表抵押物列表信息")
    public void tenderFacade_addCarBidDetailList(HryTest hryTest) {
        String actual = this._tenderFacade_addCarBidDetailList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addEnclosure", dataProvider = "provider", description = "新增附件")
    public void tenderFacade_addEnclosure(HryTest hryTest) {
        String actual = this._tenderFacade_addEnclosure(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addExchangeInfo", dataProvider = "provider", description = "增加交易所信息")
    public void tenderFacade_addExchangeInfo(HryTest hryTest) {
        String actual = this._tenderFacade_addExchangeInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addLabelInfo", dataProvider = "provider", description = "增加标签")
    public void tenderFacade_addLabelInfo(HryTest hryTest) {
        String actual = this._tenderFacade_addLabelInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/addTenderBidInfo", dataProvider = "provider", description = "保存标的信息接口")
    public void tenderFacade_addTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_addTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/agreeTenderBidInfo", dataProvider = "provider", description = "审核同意标的信息接口")
    public void tenderFacade_agreeTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_agreeTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/checkReleaseQueueBidValiad", dataProvider = "provider", description = "校验发布队列标的有效性")
    public void tenderFacade_checkReleaseQueueBidValiad(HryTest hryTest) {
        String actual = this._tenderFacade_checkReleaseQueueBidValiad(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/createAccountsPayableDetail", dataProvider = "provider", description = "增加融租债转账款信息")
    public void tenderFacade_createAccountsPayableDetail(HryTest hryTest) {
        String actual = this._tenderFacade_createAccountsPayableDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/createBidToCopy", dataProvider = "provider", description = "根据当前标的复制创建新标的")
    public void tenderFacade_createBidToCopy(HryTest hryTest) {
        String actual = this._tenderFacade_createBidToCopy(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/deleteAccountsPayableDetail", dataProvider = "provider", description = "删除融租债转账款信息")
    public void tenderFacade_deleteAccountsPayableDetail(HryTest hryTest) {
        String actual = this._tenderFacade_deleteAccountsPayableDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/deleteAccountsPayableDetailList", dataProvider = "provider", description = "删除融租债转账款信息(根据标的ID)")
    public void tenderFacade_deleteAccountsPayableDetailList(HryTest hryTest) {
        String actual = this._tenderFacade_deleteAccountsPayableDetailList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/deleteBidLabel", dataProvider = "provider", description = "删除标的的标签")
    public void tenderFacade_deleteBidLabel(HryTest hryTest) {
        String actual = this._tenderFacade_deleteBidLabel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/deleteCarBidDetail", dataProvider = "provider", description = "删除车抵押表抵押物信息")
    public void tenderFacade_deleteCarBidDetail(HryTest hryTest) {
        String actual = this._tenderFacade_deleteCarBidDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/deleteEnclosure", dataProvider = "provider", description = "删除附件")
    public void tenderFacade_deleteEnclosure(HryTest hryTest) {
        String actual = this._tenderFacade_deleteEnclosure(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/deleteLabelInfo", dataProvider = "provider", description = "删除标签")
    public void tenderFacade_deleteLabelInfo(HryTest hryTest) {
        String actual = this._tenderFacade_deleteLabelInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/disagreeTenderBidInfo", dataProvider = "provider", description = "审核不同意标的信息接口")
    public void tenderFacade_disagreeTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_disagreeTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/discardTenderBidInfo", dataProvider = "provider", description = "作废标的信息接口")
    public void tenderFacade_discardTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_discardTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getBidExtraInfo", dataProvider = "provider", description = "查询标的附加信息")
    public void tenderFacade_getBidExtraInfo(HryTest hryTest) {
        String actual = this._tenderFacade_getBidExtraInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getCarBidDetails", dataProvider = "provider", description = "查询车抵押表抵押物信息")
    public void tenderFacade_getCarBidDetails(HryTest hryTest) {
        String actual = this._tenderFacade_getCarBidDetails(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getCbpLoanInfoByLoanId", dataProvider = "provider", description = "查询信贷信息")
    public void tenderFacade_getCbpLoanInfoByLoanId(HryTest hryTest) {
        String actual = this._tenderFacade_getCbpLoanInfoByLoanId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getEnclosure", dataProvider = "provider", description = "查询附件")
    public void tenderFacade_getEnclosure(HryTest hryTest) {
        String actual = this._tenderFacade_getEnclosure(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getEnclosureTypes", dataProvider = "provider", description = "查询附件类型")
    public void tenderFacade_getEnclosureTypes(HryTest hryTest) {
        String actual = this._tenderFacade_getEnclosureTypes(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getExchangeInfoByBidId", dataProvider = "provider", description = "根据标的ID获取交易所信息")
    public void tenderFacade_getExchangeInfoByBidId(HryTest hryTest) {
        String actual = this._tenderFacade_getExchangeInfoByBidId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getExchangeInfoById", dataProvider = "provider", description = "根据交易所ID获取交易所信息")
    public void tenderFacade_getExchangeInfoById(HryTest hryTest) {
        String actual = this._tenderFacade_getExchangeInfoById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getLabelInfos", dataProvider = "provider", description = "查询标签")
    public void tenderFacade_getLabelInfos(HryTest hryTest) {
        String actual = this._tenderFacade_getLabelInfos(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getLabelInfosByBid", dataProvider = "provider", description = "查询标的标签")
    public void tenderFacade_getLabelInfosByBid(HryTest hryTest) {
        String actual = this._tenderFacade_getLabelInfosByBid(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getRepayPlanPage", dataProvider = "provider", description = "后台查询还款计划（分页）")
    public void tenderFacade_getRepayPlanPage(HryTest hryTest) {
        String actual = this._tenderFacade_getRepayPlanPage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getTenderBidInfo", dataProvider = "provider", description = "发标后台标的详情接口")
    public void tenderFacade_getTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_getTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getTenderBidList", dataProvider = "provider", description = "发标后台列表接口")
    public void tenderFacade_getTenderBidList(HryTest hryTest) {
        String actual = this._tenderFacade_getTenderBidList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/getUserLogDetailPageInfo", dataProvider = "provider", description = "获取用户日志分页信息")
    public void tenderFacade_getUserLogDetailPageInfo(HryTest hryTest) {
        String actual = this._tenderFacade_getUserLogDetailPageInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/miscarryBid", dataProvider = "provider", description = "指定待放款的标的流标")
    public void tenderFacade_miscarryBid(HryTest hryTest) {
        String actual = this._tenderFacade_miscarryBid(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/preReleaseTenderBidInfo", dataProvider = "provider", description = "预发布标的信息接口")
    public void tenderFacade_preReleaseTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_preReleaseTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/queryAccountsPayableDetail", dataProvider = "provider", description = "查询融租债转账款信息")
    public void tenderFacade_queryAccountsPayableDetail(HryTest hryTest) {
        String actual = this._tenderFacade_queryAccountsPayableDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/queryAllExchangeInfo", dataProvider = "provider", description = "获取全部交易所信息")
    public void tenderFacade_queryAllExchangeInfo(HryTest hryTest) {
        String actual = this._tenderFacade_queryAllExchangeInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/queryBidCheckList", dataProvider = "provider", description = "查询标的审核信息")
    public void tenderFacade_queryBidCheckList(HryTest hryTest) {
        String actual = this._tenderFacade_queryBidCheckList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/queryBidListByQueueId", dataProvider = "provider", description = "根据标的发布队列查询标的列表信息")
    public void tenderFacade_queryBidListByQueueId(HryTest hryTest) {
        String actual = this._tenderFacade_queryBidListByQueueId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/queryBidReleaseQueueByCond", dataProvider = "provider", description = "根据条件查询标的发布队列")
    public void tenderFacade_queryBidReleaseQueueByCond(HryTest hryTest) {
        String actual = this._tenderFacade_queryBidReleaseQueueByCond(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/releaseTenderBidInfo", dataProvider = "provider", description = "发布标的信息接口")
    public void tenderFacade_releaseTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_releaseTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/saveBidReleaseQueue", dataProvider = "provider", description = "新增标的发布队列")
    public void tenderFacade_saveBidReleaseQueue(HryTest hryTest) {
        String actual = this._tenderFacade_saveBidReleaseQueue(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/settingScheduleReleaseTime", dataProvider = "provider", description = "设置标的定时发布时间")
    public void tenderFacade_settingScheduleReleaseTime(HryTest hryTest) {
        String actual = this._tenderFacade_settingScheduleReleaseTime(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/submitBidInfo", dataProvider = "provider", description = "提交标的信息")
    public void tenderFacade_submitBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_submitBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/updateAccountsPayableDetail", dataProvider = "provider", description = "更新融租债转账款信息")
    public void tenderFacade_updateAccountsPayableDetail(HryTest hryTest) {
        String actual = this._tenderFacade_updateAccountsPayableDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/updateBidExtraInfo", dataProvider = "provider", description = "更新标的附加信息")
    public void tenderFacade_updateBidExtraInfo(HryTest hryTest) {
        String actual = this._tenderFacade_updateBidExtraInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/updateBidReleaseQueue", dataProvider = "provider", description = "修改标的发布队列")
    public void tenderFacade_updateBidReleaseQueue(HryTest hryTest) {
        String actual = this._tenderFacade_updateBidReleaseQueue(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/updateCarBidDetail", dataProvider = "provider", description = "更新车抵押表抵押物信息")
    public void tenderFacade_updateCarBidDetail(HryTest hryTest) {
        String actual = this._tenderFacade_updateCarBidDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/updateExchangeInfo", dataProvider = "provider", description = "更新交易所信息")
    public void tenderFacade_updateExchangeInfo(HryTest hryTest) {
        String actual = this._tenderFacade_updateExchangeInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/updateLabel", dataProvider = "provider", description = "更新标签")
    public void tenderFacade_updateLabel(HryTest hryTest) {
        String actual = this._tenderFacade_updateLabel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tenderFacade/updateTenderBidInfo", dataProvider = "provider", description = "更新标的信息")
    public void tenderFacade_updateTenderBidInfo(HryTest hryTest) {
        String actual = this._tenderFacade_updateTenderBidInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yyTradeStatFacade/annualInvestmentAmount", dataProvider = "provider", description = "根据投资时间和海融易id,查询该时间段内的年化投资总额")
    public void yyTradeStatFacade_annualInvestmentAmount(HryTest hryTest) {
        String actual = this._yyTradeStatFacade_annualInvestmentAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yyTradeStatFacade/getInvestmentTotalAmount", dataProvider = "provider", description = "根据投资时间和ID，查询用户该时间段内的投资金额")
    public void yyTradeStatFacade_getInvestmentTotalAmount(HryTest hryTest) {
        String actual = this._yyTradeStatFacade_getInvestmentTotalAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yyTradeStatFacade/loanCalculate", dataProvider = "provider", description = "贷款/收益计算器")
    public void yyTradeStatFacade_loanCalculate(HryTest hryTest) {
        String actual = this._yyTradeStatFacade_loanCalculate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yyTradeStatFacade/queryBidOrderByBidRecordId", dataProvider = "provider", description = "根据投资记录号（bidRecordId）查询投资订单")
    public void yyTradeStatFacade_queryBidOrderByBidRecordId(HryTest hryTest) {
        String actual = this._yyTradeStatFacade_queryBidOrderByBidRecordId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yyTradeStatFacade/queryBidOrderByOrderId", dataProvider = "provider", description = "根据投资订单号（orderId）查询投资订单）")
    public void yyTradeStatFacade_queryBidOrderByOrderId(HryTest hryTest) {
        String actual = this._yyTradeStatFacade_queryBidOrderByOrderId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yyTradeStatFacade/totalInvestmentAmount", dataProvider = "provider", description = "根据投资时间和海融易id,查询这段时间内的投资总金额")
    public void yyTradeStatFacade_totalInvestmentAmount(HryTest hryTest) {
        String actual = this._yyTradeStatFacade_totalInvestmentAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yyTradeStatFacade/twoAnniversary", dataProvider = "provider", description = "根据投资时间和ID，查询用户该时间段内的投资金额(只包含标的期限30天以上)")
    public void yyTradeStatFacade_twoAnniversary(HryTest hryTest) {
        String actual = this._yyTradeStatFacade_twoAnniversary(hryTest);
        supperAssert(actual, hryTest);
    }

}
