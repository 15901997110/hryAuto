package com.haier.testng.test;

import com.haier.po.Params;
import com.haier.testng.base.P2pBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
/**
 * @Description: P2pTestDefault
 * @Author: 自动生成
 * @Date: 2018/08/08 17:35:33
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class P2pTestDefault extends P2pBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        init(serviceId, envId, caseDesigner, i_c);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/agreementFacade/addProductInstruction", dataProvider = "provider", description = "增加产品说明书")
    public void agreementFacade_addProductInstruction(Params params) {
        String actual = this.agreementFacade_addProductInstruction(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getAgreementTemplate", dataProvider = "provider", description = "根据标的ID获取协议模版")
    public void agreementFacade_getAgreementTemplate(Params params) {
        String actual = this.agreementFacade_getAgreementTemplate(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getBidAgreement", dataProvider = "provider", description = "根据标的ID获取协议")
    public void agreementFacade_getBidAgreement(Params params) {
        String actual = this.agreementFacade_getBidAgreement(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getHuijinAgreementTemplate", dataProvider = "provider", description = "根据债权ID获取拾财计划协议模版")
    public void agreementFacade_getHuijinAgreementTemplate(Params params) {
        String actual = this.agreementFacade_getHuijinAgreementTemplate(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getHuijinContract", dataProvider = "provider", description = "获取合同内容")
    public void agreementFacade_getHuijinContract(Params params) {
        String actual = this.agreementFacade_getHuijinContract(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getProductContract", dataProvider = "provider", description = "获取合同内容")
    public void agreementFacade_getProductContract(Params params) {
        String actual = this.agreementFacade_getProductContract(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getProductInstructionList", dataProvider = "provider", description = "获取产品说明书列表")
    public void agreementFacade_getProductInstructionList(Params params) {
        String actual = this.agreementFacade_getProductInstructionList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getProductInstructions", dataProvider = "provider", description = "根据标的ID获取产品说明书")
    public void agreementFacade_getProductInstructions(Params params) {
        String actual = this.agreementFacade_getProductInstructions(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/getTransferOfDebtContract", dataProvider = "provider", description = "获取债转合同内容")
    public void agreementFacade_getTransferOfDebtContract(Params params) {
        String actual = this.agreementFacade_getTransferOfDebtContract(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/queryProductInstruction", dataProvider = "provider", description = "获取产品说明书")
    public void agreementFacade_queryProductInstruction(Params params) {
        String actual = this.agreementFacade_queryProductInstruction(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/agreementFacade/updateProductInstructions", dataProvider = "provider", description = "更新产品说明书")
    public void agreementFacade_updateProductInstructions(Params params) {
        String actual = this.agreementFacade_updateProductInstructions(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/alterNativeRechargeFacade/addAlterNativeRecharge", dataProvider = "provider", description = "代充值")
    public void alterNativeRechargeFacade_addAlterNativeRecharge(Params params) {
        String actual = this.alterNativeRechargeFacade_addAlterNativeRecharge(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/alterNativeRechargeFacade/queryAlterNativeList", dataProvider = "provider", description = "查询代充值列表")
    public void alterNativeRechargeFacade_queryAlterNativeList(Params params) {
        String actual = this.alterNativeRechargeFacade_queryAlterNativeList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/assetsResourceFacade/loan", dataProvider = "provider", description = "线上放款")
    public void assetsResourceFacade_loan(Params params) {
        String actual = this.assetsResourceFacade_loan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/assetsResourceFacade/queryAssets", dataProvider = "provider", description = "查询资产信息")
    public void assetsResourceFacade_queryAssets(Params params) {
        String actual = this.assetsResourceFacade_queryAssets(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/assetsResourceFacade/updateAssfinance", dataProvider = "provider", description = "线上融资(标的发布/废弃)")
    public void assetsResourceFacade_updateAssfinance(Params params) {
        String actual = this.assetsResourceFacade_updateAssfinance(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/assistFacade/updateBidInfoById", dataProvider = "provider", description = "更改标的信息")
    public void assistFacade_updateBidInfoById(Params params) {
        String actual = this.assistFacade_updateBidInfoById(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/assistFacade/updateEnclosureByBid", dataProvider = "provider", description = "更新标的附件")
    public void assistFacade_updateEnclosureByBid(Params params) {
        String actual = this.assistFacade_updateEnclosureByBid(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/assistFacade/updateSystemVariable", dataProvider = "provider", description = "更改配置")
    public void assistFacade_updateSystemVariable(Params params) {
        String actual = this.assistFacade_updateSystemVariable(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/getAggregatedBidDetail", dataProvider = "provider", description = "查询聚合标的信息，包括标的基础信息、项目描述、借款方信息、风险措施、审核信息")
    public void bidFacade_getAggregatedBidDetail(Params params) {
        String actual = this.bidFacade_getAggregatedBidDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/getBidCategoryList", dataProvider = "provider", description = "获取标的Tag")
    public void bidFacade_getBidCategoryList(Params params) {
        String actual = this.bidFacade_getBidCategoryList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/getBidDetailByIdList", dataProvider = "provider", description = "根据List[Id]查询标的信息(不包含消金标的)")
    public void bidFacade_getBidDetailByIdList(Params params) {
        String actual = this.bidFacade_getBidDetailByIdList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/getBidRuleConfigById", dataProvider = "provider", description = "根据ID获取标的配置规则")
    public void bidFacade_getBidRuleConfigById(Params params) {
        String actual = this.bidFacade_getBidRuleConfigById(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/getBidTypeList", dataProvider = "provider", description = "获取标的Type")
    public void bidFacade_getBidTypeList(Params params) {
        String actual = this.bidFacade_getBidTypeList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/getTotalAmountBybidAndUser", dataProvider = "provider", description = "根据用户获取指定标的累计投资金额")
    public void bidFacade_getTotalAmountBybidAndUser(Params params) {
        String actual = this.bidFacade_getTotalAmountBybidAndUser(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/queryBidDetailByIdList", dataProvider = "provider", description = "根据List[Id]查询标的信息（所有的包含消金标的信息）")
    public void bidFacade_queryBidDetailByIdList(Params params) {
        String actual = this.bidFacade_queryBidDetailByIdList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/queryBidListCond", dataProvider = "provider", description = "根据条件查询标的信息")
    public void bidFacade_queryBidListCond(Params params) {
        String actual = this.bidFacade_queryBidListCond(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/queryBidRuleConfigByCondition", dataProvider = "provider", description = "根据条件查询标的配置规则")
    public void bidFacade_queryBidRuleConfigByCondition(Params params) {
        String actual = this.bidFacade_queryBidRuleConfigByCondition(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/queryCouponBidListByQueryCond", dataProvider = "provider", description = "根据条件查询标的信息列表(投资券筛选可投标的)")
    public void bidFacade_queryCouponBidListByQueryCond(Params params) {
        String actual = this.bidFacade_queryCouponBidListByQueryCond(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/queryExchangeInfo", dataProvider = "provider", description = "查询所有交易所信息")
    public void bidFacade_queryExchangeInfo(Params params) {
        String actual = this.bidFacade_queryExchangeInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/queryLcjBidListByQueryCond", dataProvider = "provider", description = "根据条件查询标的信息列表(理财金筛选可投标的)")
    public void bidFacade_queryLcjBidListByQueryCond(Params params) {
        String actual = this.bidFacade_queryLcjBidListByQueryCond(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/saveBidRuleConfig", dataProvider = "provider", description = "新增标的配置规则")
    public void bidFacade_saveBidRuleConfig(Params params) {
        String actual = this.bidFacade_saveBidRuleConfig(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/updateBidRuleConfig", dataProvider = "provider", description = "修改标的配置规则")
    public void bidFacade_updateBidRuleConfig(Params params) {
        String actual = this.bidFacade_updateBidRuleConfig(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bidFacade/updateBidRuleConfigEnabledStatus", dataProvider = "provider", description = "修改标的配置启用状态")
    public void bidFacade_updateBidRuleConfigEnabledStatus(Params params) {
        String actual = this.bidFacade_updateBidRuleConfigEnabledStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/caculateCfRepayPlan", dataProvider = "provider", description = "根据预约计划编号计算还款计划")
    public void cfFacade_caculateCfRepayPlan(Params params) {
        String actual = this.cfFacade_caculateCfRepayPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/createReserveOrder", dataProvider = "provider", description = "预约投资（消金下单）")
    public void cfFacade_createReserveOrder(Params params) {
        String actual = this.cfFacade_createReserveOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/examineOrAbandonCfPlan", dataProvider = "provider", description = "审批／废弃 预约计划")
    public void cfFacade_examineOrAbandonCfPlan(Params params) {
        String actual = this.cfFacade_examineOrAbandonCfPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/generateCfReservationPlan", dataProvider = "provider", description = "生成消金预约计划")
    public void cfFacade_generateCfReservationPlan(Params params) {
        String actual = this.cfFacade_generateCfReservationPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getCfAgreementTemplate", dataProvider = "provider", description = "根据消金协议模版HTML")
    public void cfFacade_getCfAgreementTemplate(Params params) {
        String actual = this.cfFacade_getCfAgreementTemplate(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getCfReservationPlan", dataProvider = "provider", description = "查询消金预约计划")
    public void cfFacade_getCfReservationPlan(Params params) {
        String actual = this.cfFacade_getCfReservationPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getCfReserveInvestPage", dataProvider = "provider", description = "获取预约资产列表（console 后台专用）")
    public void cfFacade_getCfReserveInvestPage(Params params) {
        String actual = this.cfFacade_getCfReserveInvestPage(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getCfReserveOrderDetail", dataProvider = "provider", description = "获取预约记录详情（console 后台专用）")
    public void cfFacade_getCfReserveOrderDetail(Params params) {
        String actual = this.cfFacade_getCfReserveOrderDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getCfReserveOrderPage", dataProvider = "provider", description = "获取预约记录列表（console 后台专用）")
    public void cfFacade_getCfReserveOrderPage(Params params) {
        String actual = this.cfFacade_getCfReserveOrderPage(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getInvestmentProperty", dataProvider = "provider", description = "获取用户投资资产信息")
    public void cfFacade_getInvestmentProperty(Params params) {
        String actual = this.cfFacade_getInvestmentProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getInvestorInfoByBidId", dataProvider = "provider", description = "获取投资人投资信息")
    public void cfFacade_getInvestorInfoByBidId(Params params) {
        String actual = this.cfFacade_getInvestorInfoByBidId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getMyInvestPlanRecord", dataProvider = "provider", description = "我的投资-计划")
    public void cfFacade_getMyInvestPlanRecord(Params params) {
        String actual = this.cfFacade_getMyInvestPlanRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getMyReservationOrderInfo", dataProvider = "provider", description = "获取我的预约信息，包括订单总数量")
    public void cfFacade_getMyReservationOrderInfo(Params params) {
        String actual = this.cfFacade_getMyReservationOrderInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getPlanAssetDetail", dataProvider = "provider", description = "我的预约：获取用户的计划资产详情")
    public void cfFacade_getPlanAssetDetail(Params params) {
        String actual = this.cfFacade_getPlanAssetDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getPlanTradeDetail", dataProvider = "provider", description = "根据预约订单编码查询预约记录详情")
    public void cfFacade_getPlanTradeDetail(Params params) {
        String actual = this.cfFacade_getPlanTradeDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getReservationPlanOrder", dataProvider = "provider", description = "根据预约订单号查询预约记录详情")
    public void cfFacade_getReservationPlanOrder(Params params) {
        String actual = this.cfFacade_getReservationPlanOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getReservationPlanOrderDetail", dataProvider = "provider", description = "根据预约订单编码查询预约记录详情")
    public void cfFacade_getReservationPlanOrderDetail(Params params) {
        String actual = this.cfFacade_getReservationPlanOrderDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getReserveOrderByRequestNo", dataProvider = "provider", description = "查询预约投资（消金下单）订单及状态")
    public void cfFacade_getReserveOrderByRequestNo(Params params) {
        String actual = this.cfFacade_getReserveOrderByRequestNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/getReserveOrderDetail", dataProvider = "provider", description = "查询预约订单详情(H5专用)")
    public void cfFacade_getReserveOrderDetail(Params params) {
        String actual = this.cfFacade_getReserveOrderDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryBiddingOrder", dataProvider = "provider", description = "根据预约计划查询已购买标的")
    public void cfFacade_queryBiddingOrder(Params params) {
        String actual = this.cfFacade_queryBiddingOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryCfBidByCfPlan", dataProvider = "provider", description = "根据预约计划查询标的信息（console 后台专用）")
    public void cfFacade_queryCfBidByCfPlan(Params params) {
        String actual = this.cfFacade_queryCfBidByCfPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryCfOrderByCfPlan", dataProvider = "provider", description = "根据预约计划查询预约记录（console 后台专用）")
    public void cfFacade_queryCfOrderByCfPlan(Params params) {
        String actual = this.cfFacade_queryCfOrderByCfPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryCfPlanByCondition", dataProvider = "provider", description = "根据条件查询预约计划(console 后台专用)")
    public void cfFacade_queryCfPlanByCondition(Params params) {
        String actual = this.cfFacade_queryCfPlanByCondition(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryCfPlanDetail", dataProvider = "provider", description = "根据预约计划详情（console 后台专用）")
    public void cfFacade_queryCfPlanDetail(Params params) {
        String actual = this.cfFacade_queryCfPlanDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryCouponReservationPlanByCond", dataProvider = "provider", description = "根据条件查询预约计划（投资券筛选可预约计划）")
    public void cfFacade_queryCouponReservationPlanByCond(Params params) {
        String actual = this.cfFacade_queryCouponReservationPlanByCond(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryRepayRecord", dataProvider = "provider", description = "根据预约计划查询回款明细")
    public void cfFacade_queryRepayRecord(Params params) {
        String actual = this.cfFacade_queryRepayRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryReservationPlanByStatus", dataProvider = "provider", description = "预约专区:根据预约状态查询预约记录列表，")
    public void cfFacade_queryReservationPlanByStatus(Params params) {
        String actual = this.cfFacade_queryReservationPlanByStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryReservationPlanDetail", dataProvider = "provider", description = "预约详情:根据预约计划编号查询详情")
    public void cfFacade_queryReservationPlanDetail(Params params) {
        String actual = this.cfFacade_queryReservationPlanDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryReservationPlanOrder", dataProvider = "provider", description = "我的预约列表：页面：交易记录-出借记录-预约列表")
    public void cfFacade_queryReservationPlanOrder(Params params) {
        String actual = this.cfFacade_queryReservationPlanOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/cfFacade/queryUnfreezeOrders", dataProvider = "provider", description = "解冻订单查询，后台管理专用")
    public void cfFacade_queryUnfreezeOrders(Params params) {
        String actual = this.cfFacade_queryUnfreezeOrders(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/frontEndFacade/listReservationPlan", dataProvider = "provider", description = "获取消金计划列表")
    public void frontEndFacade_listReservationPlan(Params params) {
        String actual = this.frontEndFacade_listReservationPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/frontEndFacade/queryNoviceBidDetail", dataProvider = "provider", description = "查询首页新手标的")
    public void frontEndFacade_queryNoviceBidDetail(Params params) {
        String actual = this.frontEndFacade_queryNoviceBidDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/frontEndFacade/queryNoviceBidList", dataProvider = "provider", description = "查询首页新手标的,app专用")
    public void frontEndFacade_queryNoviceBidList(Params params) {
        String actual = this.frontEndFacade_queryNoviceBidList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/getFundRate", dataProvider = "provider", description = "收益率信息查询")
    public void fundFacade_getFundRate(Params params) {
        String actual = this.fundFacade_getFundRate(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/applyDebtSale", dataProvider = "provider", description = "申请单笔债权出让")
    public void huijinPlanFacade_applyDebtSale(Params params) {
        String actual = this.huijinPlanFacade_applyDebtSale(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/changeDebtType", dataProvider = "provider", description = "改变债权类型，用于债权转让")
    public void huijinPlanFacade_changeDebtType(Params params) {
        String actual = this.huijinPlanFacade_changeDebtType(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/freezeAndApplyDebtSale", dataProvider = "provider", description = "冻结债权并且申请单笔债权出让")
    public void huijinPlanFacade_freezeAndApplyDebtSale(Params params) {
        String actual = this.huijinPlanFacade_freezeAndApplyDebtSale(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/freezeDebt", dataProvider = "provider", description = "冻结债权")
    public void huijinPlanFacade_freezeDebt(Params params) {
        String actual = this.huijinPlanFacade_freezeDebt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/getBidRecordIdByDebtId", dataProvider = "provider", description = "根据债权ID 查询投标记录ID")
    public void huijinPlanFacade_getBidRecordIdByDebtId(Params params) {
        String actual = this.huijinPlanFacade_getBidRecordIdByDebtId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/getDebtInfo", dataProvider = "provider", description = "获取债权信息")
    public void huijinPlanFacade_getDebtInfo(Params params) {
        String actual = this.huijinPlanFacade_getDebtInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/getDebtInfoByBidRecordId", dataProvider = "provider", description = "根据投标记录ID 查询债权信息")
    public void huijinPlanFacade_getDebtInfoByBidRecordId(Params params) {
        String actual = this.huijinPlanFacade_getDebtInfoByBidRecordId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/getTradingRepayment", dataProvider = "provider", description = "获取债权转让后P2P还款详细信息")
    public void huijinPlanFacade_getTradingRepayment(Params params) {
        String actual = this.huijinPlanFacade_getTradingRepayment(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/lockDebt", dataProvider = "provider", description = "锁定/解锁债权")
    public void huijinPlanFacade_lockDebt(Params params) {
        String actual = this.huijinPlanFacade_lockDebt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/loseDebt", dataProvider = "provider", description = "债权丧权")
    public void huijinPlanFacade_loseDebt(Params params) {
        String actual = this.huijinPlanFacade_loseDebt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/transferDebt", dataProvider = "provider", description = "债权转让接口")
    public void huijinPlanFacade_transferDebt(Params params) {
        String actual = this.huijinPlanFacade_transferDebt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/unfreezeAndCancelDebtSale", dataProvider = "provider", description = "解冻债权并且取消单笔债权出让")
    public void huijinPlanFacade_unfreezeAndCancelDebtSale(Params params) {
        String actual = this.huijinPlanFacade_unfreezeAndCancelDebtSale(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/huijinPlanFacade/unfreezeDebt", dataProvider = "provider", description = "解冻债权")
    public void huijinPlanFacade_unfreezeDebt(Params params) {
        String actual = this.huijinPlanFacade_unfreezeDebt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/createInvestOrder", dataProvider = "provider", description = "投资下单")
    public void investFacade_createInvestOrder(Params params) {
        String actual = this.investFacade_createInvestOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getBiddingStatusByVoucherNo", dataProvider = "provider", description = "根据凭证号查询投标状态")
    public void investFacade_getBiddingStatusByVoucherNo(Params params) {
        String actual = this.investFacade_getBiddingStatusByVoucherNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getInvestmentInfo", dataProvider = "provider", description = "获取用户投资信息")
    public void investFacade_getInvestmentInfo(Params params) {
        String actual = this.investFacade_getInvestmentInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getInvestmentProperty", dataProvider = "provider", description = "获取用户投资资产信息")
    public void investFacade_getInvestmentProperty(Params params) {
        String actual = this.investFacade_getInvestmentProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getInvestStatusByOrderId", dataProvider = "provider", description = "根据订单号查询投资状态")
    public void investFacade_getInvestStatusByOrderId(Params params) {
        String actual = this.investFacade_getInvestStatusByOrderId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getInvestStatusByRequestNo", dataProvider = "provider", description = "根据用户预处理请求流水号查询投资状态(查询非消金投资)")
    public void investFacade_getInvestStatusByRequestNo(Params params) {
        String actual = this.investFacade_getInvestStatusByRequestNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getMyInvestDetail", dataProvider = "provider", description = "查询我的投资交易详情")
    public void investFacade_getMyInvestDetail(Params params) {
        String actual = this.investFacade_getMyInvestDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getNumberOfBidders", dataProvider = "provider", description = "获取标的ID获取该标的已经投资的人数")
    public void investFacade_getNumberOfBidders(Params params) {
        String actual = this.investFacade_getNumberOfBidders(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getOfflineOrder", dataProvider = "provider", description = "获取用户海利计划投资记录")
    public void investFacade_getOfflineOrder(Params params) {
        String actual = this.investFacade_getOfflineOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getOfflineProperty", dataProvider = "provider", description = "获取用户海利计划资产信息")
    public void investFacade_getOfflineProperty(Params params) {
        String actual = this.investFacade_getOfflineProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/getUserPurchaseRecordListByHryId", dataProvider = "provider", description = "查询用户所有投资记录信息")
    public void investFacade_getUserPurchaseRecordListByHryId(Params params) {
        String actual = this.investFacade_getUserPurchaseRecordListByHryId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/investCountStatistics", dataProvider = "provider", description = "根据hryIdList统计用户投资笔数")
    public void investFacade_investCountStatistics(Params params) {
        String actual = this.investFacade_investCountStatistics(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/investCountStatisticsByHryId", dataProvider = "provider", description = "根据hryId统计单个用户投资笔数")
    public void investFacade_investCountStatisticsByHryId(Params params) {
        String actual = this.investFacade_investCountStatisticsByHryId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/noviceCheck", dataProvider = "provider", description = "投标，新手效验")
    public void investFacade_noviceCheck(Params params) {
        String actual = this.investFacade_noviceCheck(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryAllPrincipalAndInterestReceived", dataProvider = "provider", description = "根据hryId查询用户全部待收本息")
    public void investFacade_queryAllPrincipalAndInterestReceived(Params params) {
        String actual = this.investFacade_queryAllPrincipalAndInterestReceived(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryInvestByCond", dataProvider = "provider", description = "查询条件查询投资列表（console后台）")
    public void investFacade_queryInvestByCond(Params params) {
        String actual = this.investFacade_queryInvestByCond(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryInvestRecord", dataProvider = "provider", description = "获取我的投资列表信息")
    public void investFacade_queryInvestRecord(Params params) {
        String actual = this.investFacade_queryInvestRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryMyInvest", dataProvider = "provider", description = "查询我的投资列表")
    public void investFacade_queryMyInvest(Params params) {
        String actual = this.investFacade_queryMyInvest(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryPurchaseCondByHryIdList", dataProvider = "provider", description = "批量查询指定用户的投资情况")
    public void investFacade_queryPurchaseCondByHryIdList(Params params) {
        String actual = this.investFacade_queryPurchaseCondByHryIdList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryPurchaseRecordList", dataProvider = "provider", description = "查询投资记录")
    public void investFacade_queryPurchaseRecordList(Params params) {
        String actual = this.investFacade_queryPurchaseRecordList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryRepaymentRecordList", dataProvider = "provider", description = "根据条件查询用户投资还款信息列表")
    public void investFacade_queryRepaymentRecordList(Params params) {
        String actual = this.investFacade_queryRepaymentRecordList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investFacade/queryTotalMoney", dataProvider = "provider", description = "根据条件查询用户投资总金额")
    public void investFacade_queryTotalMoney(Params params) {
        String actual = this.investFacade_queryTotalMoney(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investReservationFacade/addShortMsgBlackList", dataProvider = "provider", description = "添加短信黑名单")
    public void investReservationFacade_addShortMsgBlackList(Params params) {
        String actual = this.investReservationFacade_addShortMsgBlackList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investReservationFacade/getInvestReservationList", dataProvider = "provider", description = "获取代客理财")
    public void investReservationFacade_getInvestReservationList(Params params) {
        String actual = this.investReservationFacade_getInvestReservationList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investReservationFacade/getShortMsgBlackList", dataProvider = "provider", description = "获取短信黑名单列表")
    public void investReservationFacade_getShortMsgBlackList(Params params) {
        String actual = this.investReservationFacade_getShortMsgBlackList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/investReservationFacade/removeFromBlackList", dataProvider = "provider", description = "允许短信")
    public void investReservationFacade_removeFromBlackList(Params params) {
        String actual = this.investReservationFacade_removeFromBlackList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/loanByBid", dataProvider = "provider", description = "标的放款")
    public void loanFacade_loanByBid(Params params) {
        String actual = this.loanFacade_loanByBid(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/loanByCommand", dataProvider = "provider", description = "单独调用一个命令，慎用")
    public void loanFacade_loanByCommand(Params params) {
        String actual = this.loanFacade_loanByCommand(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/loanNotify", dataProvider = "provider", description = "异步通知，仅供测试")
    public void loanFacade_loanNotify(Params params) {
        String actual = this.loanFacade_loanNotify(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/queryLoanBid", dataProvider = "provider", description = "查询待放款标的信息")
    public void loanFacade_queryLoanBid(Params params) {
        String actual = this.loanFacade_queryLoanBid(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/queryLoanBidDetail", dataProvider = "provider", description = "查询放款标的信息")
    public void loanFacade_queryLoanBidDetail(Params params) {
        String actual = this.loanFacade_queryLoanBidDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/queryLoanOrder", dataProvider = "provider", description = "查询已放款标的信息")
    public void loanFacade_queryLoanOrder(Params params) {
        String actual = this.loanFacade_queryLoanOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/queryUserLoanOrders", dataProvider = "provider", description = "查询放款订单")
    public void loanFacade_queryUserLoanOrders(Params params) {
        String actual = this.loanFacade_queryUserLoanOrders(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/resendContractMq", dataProvider = "provider", description = "合同系统MQ重发")
    public void loanFacade_resendContractMq(Params params) {
        String actual = this.loanFacade_resendContractMq(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanFacade/specifyTransfer", dataProvider = "provider", description = "触发指定交易确认")
    public void loanFacade_specifyTransfer(Params params) {
        String actual = this.loanFacade_specifyTransfer(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/messageFacade/messageFacade", dataProvider = "provider", description = "发送消息")
    public void messageFacade_messageFacade(Params params) {
        String actual = this.messageFacade_messageFacade(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/addBatchOfflinePlan", dataProvider = "provider", description = "批量添加计划")
    public void offlinePlanFacade_addBatchOfflinePlan(Params params) {
        String actual = this.offlinePlanFacade_addBatchOfflinePlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/addOfflinePlan", dataProvider = "provider", description = "添加计划")
    public void offlinePlanFacade_addOfflinePlan(Params params) {
        String actual = this.offlinePlanFacade_addOfflinePlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/getOfflinePlan", dataProvider = "provider", description = "查询计划")
    public void offlinePlanFacade_getOfflinePlan(Params params) {
        String actual = this.offlinePlanFacade_getOfflinePlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/getOfflinePlanDetail", dataProvider = "provider", description = "WEB-查询产品详情")
    public void offlinePlanFacade_getOfflinePlanDetail(Params params) {
        String actual = this.offlinePlanFacade_getOfflinePlanDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/getUserInvestOrder", dataProvider = "provider", description = "获取用户投资订单")
    public void offlinePlanFacade_getUserInvestOrder(Params params) {
        String actual = this.offlinePlanFacade_getUserInvestOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/getWhetherInvest", dataProvider = "provider", description = "是否发起投资")
    public void offlinePlanFacade_getWhetherInvest(Params params) {
        String actual = this.offlinePlanFacade_getWhetherInvest(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/invalidOrder", dataProvider = "provider", description = "作废订单")
    public void offlinePlanFacade_invalidOrder(Params params) {
        String actual = this.offlinePlanFacade_invalidOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/listOfflineIssuerAndConsignee", dataProvider = "provider", description = "获取发行人和承销商信息")
    public void offlinePlanFacade_listOfflineIssuerAndConsignee(Params params) {
        String actual = this.offlinePlanFacade_listOfflineIssuerAndConsignee(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/listOfflineRepayOrder", dataProvider = "provider", description = "获取用户还款订单")
    public void offlinePlanFacade_listOfflineRepayOrder(Params params) {
        String actual = this.offlinePlanFacade_listOfflineRepayOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/listReleaseOfflinePlan", dataProvider = "provider", description = "WEB-查询上线产品列表")
    public void offlinePlanFacade_listReleaseOfflinePlan(Params params) {
        String actual = this.offlinePlanFacade_listReleaseOfflinePlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/queryInvestByPage", dataProvider = "provider", description = "根据条件分页查询投资记录")
    public void offlinePlanFacade_queryInvestByPage(Params params) {
        String actual = this.offlinePlanFacade_queryInvestByPage(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/queryOfflinePlan", dataProvider = "provider", description = "分页查询计划")
    public void offlinePlanFacade_queryOfflinePlan(Params params) {
        String actual = this.offlinePlanFacade_queryOfflinePlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/resetOfflineRepayOrder", dataProvider = "provider", description = "重置还款订单")
    public void offlinePlanFacade_resetOfflineRepayOrder(Params params) {
        String actual = this.offlinePlanFacade_resetOfflineRepayOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/setOnOffOfOfflinePlan", dataProvider = "provider", description = "设置线下理财上下线")
    public void offlinePlanFacade_setOnOffOfOfflinePlan(Params params) {
        String actual = this.offlinePlanFacade_setOnOffOfOfflinePlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/updateOfflinePlan", dataProvider = "provider", description = "修改计划")
    public void offlinePlanFacade_updateOfflinePlan(Params params) {
        String actual = this.offlinePlanFacade_updateOfflinePlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/updateUserInvestOrder", dataProvider = "provider", description = "修改用户投资订单")
    public void offlinePlanFacade_updateUserInvestOrder(Params params) {
        String actual = this.offlinePlanFacade_updateUserInvestOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/userInvest", dataProvider = "provider", description = "后台-用户预约")
    public void offlinePlanFacade_userInvest(Params params) {
        String actual = this.offlinePlanFacade_userInvest(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/offlinePlanFacade/userReservation", dataProvider = "provider", description = "WEB-用户预约")
    public void offlinePlanFacade_userReservation(Params params) {
        String actual = this.offlinePlanFacade_userReservation(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/orderFacade/exportPurchaseRecord", dataProvider = "provider", description = "导出查询投资记录")
    public void orderFacade_exportPurchaseRecord(Params params) {
        String actual = this.orderFacade_exportPurchaseRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/orderFacade/getRealTimePurchaseRecord", dataProvider = "provider", description = "获取首页实时理财信息")
    public void orderFacade_getRealTimePurchaseRecord(Params params) {
        String actual = this.orderFacade_getRealTimePurchaseRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/orderFacade/getRepaymentStatusByOrderIdList", dataProvider = "provider", description = "批量查询订单还款状态")
    public void orderFacade_getRepaymentStatusByOrderIdList(Params params) {
        String actual = this.orderFacade_getRepaymentStatusByOrderIdList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/orderFacade/queryPurchaseRecord", dataProvider = "provider", description = "查询投资记录")
    public void orderFacade_queryPurchaseRecord(Params params) {
        String actual = this.orderFacade_queryPurchaseRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/orderFacade/queryPurchaseRecordDetail", dataProvider = "provider", description = "根据投标记录查询标的信息")
    public void orderFacade_queryPurchaseRecordDetail(Params params) {
        String actual = this.orderFacade_queryPurchaseRecordDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/platformMarkingFacade/addAlterNativeRecharge", dataProvider = "provider", description = "新增页面获取用户ID")
    public void platformMarkingFacade_addAlterNativeRecharge(Params params) {
        String actual = this.platformMarkingFacade_addAlterNativeRecharge(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/platformMarkingFacade/creatPlatformMarking", dataProvider = "provider", description = "平台营销")
    public void platformMarkingFacade_creatPlatformMarking(Params params) {
        String actual = this.platformMarkingFacade_creatPlatformMarking(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/platformMarkingFacade/queryAlterNativeList", dataProvider = "provider", description = "查询代充值列表")
    public void platformMarkingFacade_queryAlterNativeList(Params params) {
        String actual = this.platformMarkingFacade_queryAlterNativeList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/platformMarkingFacade/selectUserInfo", dataProvider = "provider", description = "查询用户信息")
    public void platformMarkingFacade_selectUserInfo(Params params) {
        String actual = this.platformMarkingFacade_selectUserInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/productFacade/generateBatchProduct", dataProvider = "provider", description = "批量发标")
    public void productFacade_generateBatchProduct(Params params) {
        String actual = this.productFacade_generateBatchProduct(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/productFacade/generateProduct", dataProvider = "provider", description = "发标接口")
    public void productFacade_generateProduct(Params params) {
        String actual = this.productFacade_generateProduct(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/productFacade/getBatchReleaseLog", dataProvider = "provider", description = "批量发标记录查询")
    public void productFacade_getBatchReleaseLog(Params params) {
        String actual = this.productFacade_getBatchReleaseLog(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/productFacade/queryEntrustPayOrder", dataProvider = "provider", description = "【console】查询委托支付授权订单")
    public void productFacade_queryEntrustPayOrder(Params params) {
        String actual = this.productFacade_queryEntrustPayOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/productFacade/queryProductByCreditId", dataProvider = "provider", description = "确认发标是否成功")
    public void productFacade_queryProductByCreditId(Params params) {
        String actual = this.productFacade_queryProductByCreditId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/queryTransferOfDebtFacade/getMyAssetByTransferOfDebt", dataProvider = "provider", description = "获取我的债转投资资产信息")
    public void queryTransferOfDebtFacade_getMyAssetByTransferOfDebt(Params params) {
        String actual = this.queryTransferOfDebtFacade_getMyAssetByTransferOfDebt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/queryTransferOfDebtFacade/getRepaymentDetail", dataProvider = "provider", description = "获取回款债转详情")
    public void queryTransferOfDebtFacade_getRepaymentDetail(Params params) {
        String actual = this.queryTransferOfDebtFacade_getRepaymentDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/queryTransferOfDebtFacade/listMyTransferOfDebt", dataProvider = "provider", description = "获取我的债转投资列表信息")
    public void queryTransferOfDebtFacade_listMyTransferOfDebt(Params params) {
        String actual = this.queryTransferOfDebtFacade_listMyTransferOfDebt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/queryTransferOfDebtFacade/listRepaymentDetails", dataProvider = "provider", description = "获取回款债转列表")
    public void queryTransferOfDebtFacade_listRepaymentDetails(Params params) {
        String actual = this.queryTransferOfDebtFacade_listRepaymentDetails(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/createAdjustAccountOrder", dataProvider = "provider", description = "创建调账订单")
    public void rechargeAndWithdrawFacade_createAdjustAccountOrder(Params params) {
        String actual = this.rechargeAndWithdrawFacade_createAdjustAccountOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/createRechargeOrder", dataProvider = "provider", description = "充值")
    public void rechargeAndWithdrawFacade_createRechargeOrder(Params params) {
        String actual = this.rechargeAndWithdrawFacade_createRechargeOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/createWithdrawOrder", dataProvider = "provider", description = "提现")
    public void rechargeAndWithdrawFacade_createWithdrawOrder(Params params) {
        String actual = this.rechargeAndWithdrawFacade_createWithdrawOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/directRecharge", dataProvider = "provider", description = "自动充值")
    public void rechargeAndWithdrawFacade_directRecharge(Params params) {
        String actual = this.rechargeAndWithdrawFacade_directRecharge(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/directWithdraw", dataProvider = "provider", description = "自动提现")
    public void rechargeAndWithdrawFacade_directWithdraw(Params params) {
        String actual = this.rechargeAndWithdrawFacade_directWithdraw(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryAdjustAccountOrder", dataProvider = "provider", description = "查询调账订单")
    public void rechargeAndWithdrawFacade_queryAdjustAccountOrder(Params params) {
        String actual = this.rechargeAndWithdrawFacade_queryAdjustAccountOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryRechargeList", dataProvider = "provider", description = "【console】查询充值订单列表")
    public void rechargeAndWithdrawFacade_queryRechargeList(Params params) {
        String actual = this.rechargeAndWithdrawFacade_queryRechargeList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryRechargeRecord", dataProvider = "provider", description = "前端查询充值交易记录")
    public void rechargeAndWithdrawFacade_queryRechargeRecord(Params params) {
        String actual = this.rechargeAndWithdrawFacade_queryRechargeRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryRechargeRecordDetail", dataProvider = "provider", description = "前端查询充值交易记录详情")
    public void rechargeAndWithdrawFacade_queryRechargeRecordDetail(Params params) {
        String actual = this.rechargeAndWithdrawFacade_queryRechargeRecordDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryWithdrawList", dataProvider = "provider", description = "【console】查询所有用户提现列表")
    public void rechargeAndWithdrawFacade_queryWithdrawList(Params params) {
        String actual = this.rechargeAndWithdrawFacade_queryWithdrawList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryWithdrawRecord", dataProvider = "provider", description = "前端查询用户提现订单")
    public void rechargeAndWithdrawFacade_queryWithdrawRecord(Params params) {
        String actual = this.rechargeAndWithdrawFacade_queryWithdrawRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/queryWithdrawRecordDetail", dataProvider = "provider", description = "前端查询提现交易详情")
    public void rechargeAndWithdrawFacade_queryWithdrawRecordDetail(Params params) {
        String actual = this.rechargeAndWithdrawFacade_queryWithdrawRecordDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/rechargeAndWithdrawFacade/sumWithdrawPending", dataProvider = "provider", description = "查询提现中的总金额")
    public void rechargeAndWithdrawFacade_sumWithdrawPending(Params params) {
        String actual = this.rechargeAndWithdrawFacade_sumWithdrawPending(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/reconFacade/queryBackrollReconciliation", dataProvider = "provider", description = "查询资金回退充值订单对账信息")
    public void reconFacade_queryBackrollReconciliation(Params params) {
        String actual = this.reconFacade_queryBackrollReconciliation(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/reconFacade/queryCommissionInfo", dataProvider = "provider", description = "查询佣金对账信息")
    public void reconFacade_queryCommissionInfo(Params params) {
        String actual = this.reconFacade_queryCommissionInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/reconFacade/queryRechargeReconciliation", dataProvider = "provider", description = "查询充值订单对账信息")
    public void reconFacade_queryRechargeReconciliation(Params params) {
        String actual = this.reconFacade_queryRechargeReconciliation(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/reconFacade/queryReconInfo", dataProvider = "provider", description = "查询交易对账信息")
    public void reconFacade_queryReconInfo(Params params) {
        String actual = this.reconFacade_queryReconInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/reconFacade/queryWithdrawReconciliation", dataProvider = "provider", description = "查询提现充值订单对账信息")
    public void reconFacade_queryWithdrawReconciliation(Params params) {
        String actual = this.reconFacade_queryWithdrawReconciliation(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/regionFacade/getSubRegion", dataProvider = "provider", description = "根据ID查询上级地区信息")
    public void regionFacade_getSubRegion(Params params) {
        String actual = this.regionFacade_getSubRegion(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/regionFacade/regionInfo", dataProvider = "provider", description = "查询地区信息接口")
    public void regionFacade_regionInfo(Params params) {
        String actual = this.regionFacade_regionInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/financierRepayment", dataProvider = "provider", description = "融资人还款")
    public void repaymentFacade_financierRepayment(Params params) {
        String actual = this.repaymentFacade_financierRepayment(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/financierRepaymentWithExinterest", dataProvider = "provider", description = "融资人还款(无息)。场景：募集成功、放款后，借款人又不借了。")
    public void repaymentFacade_financierRepaymentWithExinterest(Params params) {
        String actual = this.repaymentFacade_financierRepaymentWithExinterest(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/financierStatistics", dataProvider = "provider", description = "融资统计")
    public void repaymentFacade_financierStatistics(Params params) {
        String actual = this.repaymentFacade_financierStatistics(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/getBidHkjh", dataProvider = "provider", description = "查询标的标还款记录(标的应还款信息查询接口)")
    public void repaymentFacade_getBidHkjh(Params params) {
        String actual = this.repaymentFacade_getBidHkjh(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/getFinancierRepaymentOrder", dataProvider = "provider", description = "查询融资人还款记录 详情")
    public void repaymentFacade_getFinancierRepaymentOrder(Params params) {
        String actual = this.repaymentFacade_getFinancierRepaymentOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/getInvestorRepaymentDetail", dataProvider = "provider", description = "查询投资人收款明细详情")
    public void repaymentFacade_getInvestorRepaymentDetail(Params params) {
        String actual = this.repaymentFacade_getInvestorRepaymentDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/getRepayingDetail", dataProvider = "provider", description = "查询最近一期还款详情")
    public void repaymentFacade_getRepayingDetail(Params params) {
        String actual = this.repaymentFacade_getRepayingDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/getReserveRepaymentDetail", dataProvider = "provider", description = "查询投资人-预约回款详情")
    public void repaymentFacade_getReserveRepaymentDetail(Params params) {
        String actual = this.repaymentFacade_getReserveRepaymentDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/listFinancierRepaymentOrders", dataProvider = "provider", description = "查询融资人还款记录")
    public void repaymentFacade_listFinancierRepaymentOrders(Params params) {
        String actual = this.repaymentFacade_listFinancierRepaymentOrders(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/listFinancierRepaymentOrdersConsole", dataProvider = "provider", description = "查询融资人还款记录（console使用）")
    public void repaymentFacade_listFinancierRepaymentOrdersConsole(Params params) {
        String actual = this.repaymentFacade_listFinancierRepaymentOrdersConsole(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/listFinancierRepaymentPlans", dataProvider = "provider", description = "查询标的还款明细")
    public void repaymentFacade_listFinancierRepaymentPlans(Params params) {
        String actual = this.repaymentFacade_listFinancierRepaymentPlans(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/listInvestorRepaymentDetails", dataProvider = "provider", description = "查询投资人收款明细")
    public void repaymentFacade_listInvestorRepaymentDetails(Params params) {
        String actual = this.repaymentFacade_listInvestorRepaymentDetails(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/listInvestorRepaymentDetailsConsole", dataProvider = "provider", description = "查询投资人收款明细（Console使用）")
    public void repaymentFacade_listInvestorRepaymentDetailsConsole(Params params) {
        String actual = this.repaymentFacade_listInvestorRepaymentDetailsConsole(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/prepayment", dataProvider = "provider", description = "融资人提前还款")
    public void repaymentFacade_prepayment(Params params) {
        String actual = this.repaymentFacade_prepayment(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/prepaymentApplication", dataProvider = "provider", description = "提前还款申请与审核")
    public void repaymentFacade_prepaymentApplication(Params params) {
        String actual = this.repaymentFacade_prepaymentApplication(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryBiddersHkjh", dataProvider = "provider", description = "查询用户投标还款计划信息")
    public void repaymentFacade_queryBiddersHkjh(Params params) {
        String actual = this.repaymentFacade_queryBiddersHkjh(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryCfBiddingOrderHkjh", dataProvider = "provider", description = "查询用户预约标的还款计划信息")
    public void repaymentFacade_queryCfBiddingOrderHkjh(Params params) {
        String actual = this.repaymentFacade_queryCfBiddingOrderHkjh(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryExistsPrepaymentPlan", dataProvider = "provider", description = "查询已经提前还款的计划详情")
    public void repaymentFacade_queryExistsPrepaymentPlan(Params params) {
        String actual = this.repaymentFacade_queryExistsPrepaymentPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryPerfectHkjh", dataProvider = "provider", description = "查询标的还款计划")
    public void repaymentFacade_queryPerfectHkjh(Params params) {
        String actual = this.repaymentFacade_queryPerfectHkjh(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryPrepaymentApplication", dataProvider = "provider", description = "查询提前还款标的信息")
    public void repaymentFacade_queryPrepaymentApplication(Params params) {
        String actual = this.repaymentFacade_queryPrepaymentApplication(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryPrepaymentPlan", dataProvider = "provider", description = "查询提前还款计划")
    public void repaymentFacade_queryPrepaymentPlan(Params params) {
        String actual = this.repaymentFacade_queryPrepaymentPlan(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryRepayingBids", dataProvider = "provider", description = "查询还款中标的")
    public void repaymentFacade_queryRepayingBids(Params params) {
        String actual = this.repaymentFacade_queryRepayingBids(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryRepaymentBids", dataProvider = "provider", description = "融资查询")
    public void repaymentFacade_queryRepaymentBids(Params params) {
        String actual = this.repaymentFacade_queryRepaymentBids(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryRepaymentDetail", dataProvider = "provider", description = "【console】查询标的还款、代偿详情")
    public void repaymentFacade_queryRepaymentDetail(Params params) {
        String actual = this.repaymentFacade_queryRepaymentDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryRepaymentList", dataProvider = "provider", description = "【console】查询标的还款、代偿列表")
    public void repaymentFacade_queryRepaymentList(Params params) {
        String actual = this.repaymentFacade_queryRepaymentList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryReserveRepaymentDetails", dataProvider = "provider", description = "查询投资人-预约回款列表")
    public void repaymentFacade_queryReserveRepaymentDetails(Params params) {
        String actual = this.repaymentFacade_queryReserveRepaymentDetails(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/querySettledBids", dataProvider = "provider", description = "查询已结清标的")
    public void repaymentFacade_querySettledBids(Params params) {
        String actual = this.repaymentFacade_querySettledBids(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/queryUnpaidBidDetail", dataProvider = "provider", description = "【console】查询待还款标的详情")
    public void repaymentFacade_queryUnpaidBidDetail(Params params) {
        String actual = this.repaymentFacade_queryUnpaidBidDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/rebuildInvestorRepaymentDetailsConsole", dataProvider = "provider", description = "重发失败的还款确认明细（Console使用）")
    public void repaymentFacade_rebuildInvestorRepaymentDetailsConsole(Params params) {
        String actual = this.repaymentFacade_rebuildInvestorRepaymentDetailsConsole(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/repaymentFacade/reserveRepayment", dataProvider = "provider", description = "预约还款")
    public void repaymentFacade_reserveRepayment(Params params) {
        String actual = this.repaymentFacade_reserveRepayment(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/stockPrepaymentApplyFacade/applyStockPrepayment", dataProvider = "provider", description = "存量数据申请提前还款")
    public void stockPrepaymentApplyFacade_applyStockPrepayment(Params params) {
        String actual = this.stockPrepaymentApplyFacade_applyStockPrepayment(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/stockPrepaymentApplyFacade/listStockPrepayment", dataProvider = "provider", description = "根据条件查询存量提前还款列表")
    public void stockPrepaymentApplyFacade_listStockPrepayment(Params params) {
        String actual = this.stockPrepaymentApplyFacade_listStockPrepayment(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/stockPrepaymentApplyFacade/listStockPrepaymentByIds", dataProvider = "provider", description = "根据条件查询存量提前还款列表")
    public void stockPrepaymentApplyFacade_listStockPrepaymentByIds(Params params) {
        String actual = this.stockPrepaymentApplyFacade_listStockPrepaymentByIds(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addBatchEnclosure", dataProvider = "provider", description = "新增批量附件")
    public void tenderFacade_addBatchEnclosure(Params params) {
        String actual = this.tenderFacade_addBatchEnclosure(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addBidExtraInfo", dataProvider = "provider", description = "新增标的附加信息")
    public void tenderFacade_addBidExtraInfo(Params params) {
        String actual = this.tenderFacade_addBidExtraInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addBidLabel", dataProvider = "provider", description = "新增标的的标签")
    public void tenderFacade_addBidLabel(Params params) {
        String actual = this.tenderFacade_addBidLabel(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addCarBidDetail", dataProvider = "provider", description = "保存车抵押表抵押物信息")
    public void tenderFacade_addCarBidDetail(Params params) {
        String actual = this.tenderFacade_addCarBidDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addCarBidDetailList", dataProvider = "provider", description = "保存车抵押表抵押物列表信息")
    public void tenderFacade_addCarBidDetailList(Params params) {
        String actual = this.tenderFacade_addCarBidDetailList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addEnclosure", dataProvider = "provider", description = "新增附件")
    public void tenderFacade_addEnclosure(Params params) {
        String actual = this.tenderFacade_addEnclosure(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addExchangeInfo", dataProvider = "provider", description = "增加交易所信息")
    public void tenderFacade_addExchangeInfo(Params params) {
        String actual = this.tenderFacade_addExchangeInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addLabelInfo", dataProvider = "provider", description = "增加标签")
    public void tenderFacade_addLabelInfo(Params params) {
        String actual = this.tenderFacade_addLabelInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/addTenderBidInfo", dataProvider = "provider", description = "保存标的信息接口")
    public void tenderFacade_addTenderBidInfo(Params params) {
        String actual = this.tenderFacade_addTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/agreeTenderBidInfo", dataProvider = "provider", description = "审核同意标的信息接口")
    public void tenderFacade_agreeTenderBidInfo(Params params) {
        String actual = this.tenderFacade_agreeTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/checkReleaseQueueBidValiad", dataProvider = "provider", description = "校验发布队列标的有效性")
    public void tenderFacade_checkReleaseQueueBidValiad(Params params) {
        String actual = this.tenderFacade_checkReleaseQueueBidValiad(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/createAccountsPayableDetail", dataProvider = "provider", description = "增加融租债转账款信息")
    public void tenderFacade_createAccountsPayableDetail(Params params) {
        String actual = this.tenderFacade_createAccountsPayableDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/createBidToCopy", dataProvider = "provider", description = "根据当前标的复制创建新标的")
    public void tenderFacade_createBidToCopy(Params params) {
        String actual = this.tenderFacade_createBidToCopy(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/deleteAccountsPayableDetail", dataProvider = "provider", description = "删除融租债转账款信息")
    public void tenderFacade_deleteAccountsPayableDetail(Params params) {
        String actual = this.tenderFacade_deleteAccountsPayableDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/deleteAccountsPayableDetailList", dataProvider = "provider", description = "删除融租债转账款信息(根据标的ID)")
    public void tenderFacade_deleteAccountsPayableDetailList(Params params) {
        String actual = this.tenderFacade_deleteAccountsPayableDetailList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/deleteBidLabel", dataProvider = "provider", description = "删除标的的标签")
    public void tenderFacade_deleteBidLabel(Params params) {
        String actual = this.tenderFacade_deleteBidLabel(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/deleteCarBidDetail", dataProvider = "provider", description = "删除车抵押表抵押物信息")
    public void tenderFacade_deleteCarBidDetail(Params params) {
        String actual = this.tenderFacade_deleteCarBidDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/deleteEnclosure", dataProvider = "provider", description = "删除附件")
    public void tenderFacade_deleteEnclosure(Params params) {
        String actual = this.tenderFacade_deleteEnclosure(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/deleteLabelInfo", dataProvider = "provider", description = "删除标签")
    public void tenderFacade_deleteLabelInfo(Params params) {
        String actual = this.tenderFacade_deleteLabelInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/disagreeTenderBidInfo", dataProvider = "provider", description = "审核不同意标的信息接口")
    public void tenderFacade_disagreeTenderBidInfo(Params params) {
        String actual = this.tenderFacade_disagreeTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/discardTenderBidInfo", dataProvider = "provider", description = "作废标的信息接口")
    public void tenderFacade_discardTenderBidInfo(Params params) {
        String actual = this.tenderFacade_discardTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getBidExtraInfo", dataProvider = "provider", description = "查询标的附加信息")
    public void tenderFacade_getBidExtraInfo(Params params) {
        String actual = this.tenderFacade_getBidExtraInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getCarBidDetails", dataProvider = "provider", description = "查询车抵押表抵押物信息")
    public void tenderFacade_getCarBidDetails(Params params) {
        String actual = this.tenderFacade_getCarBidDetails(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getCbpLoanInfoByLoanId", dataProvider = "provider", description = "查询信贷信息")
    public void tenderFacade_getCbpLoanInfoByLoanId(Params params) {
        String actual = this.tenderFacade_getCbpLoanInfoByLoanId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getEnclosure", dataProvider = "provider", description = "查询附件")
    public void tenderFacade_getEnclosure(Params params) {
        String actual = this.tenderFacade_getEnclosure(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getEnclosureTypes", dataProvider = "provider", description = "查询附件类型")
    public void tenderFacade_getEnclosureTypes(Params params) {
        String actual = this.tenderFacade_getEnclosureTypes(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getExchangeInfoByBidId", dataProvider = "provider", description = "根据标的ID获取交易所信息")
    public void tenderFacade_getExchangeInfoByBidId(Params params) {
        String actual = this.tenderFacade_getExchangeInfoByBidId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getExchangeInfoById", dataProvider = "provider", description = "根据交易所ID获取交易所信息")
    public void tenderFacade_getExchangeInfoById(Params params) {
        String actual = this.tenderFacade_getExchangeInfoById(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getLabelInfos", dataProvider = "provider", description = "查询标签")
    public void tenderFacade_getLabelInfos(Params params) {
        String actual = this.tenderFacade_getLabelInfos(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getLabelInfosByBid", dataProvider = "provider", description = "查询标的标签")
    public void tenderFacade_getLabelInfosByBid(Params params) {
        String actual = this.tenderFacade_getLabelInfosByBid(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getRepayPlanPage", dataProvider = "provider", description = "后台查询还款计划（分页）")
    public void tenderFacade_getRepayPlanPage(Params params) {
        String actual = this.tenderFacade_getRepayPlanPage(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getTenderBidInfo", dataProvider = "provider", description = "发标后台标的详情接口")
    public void tenderFacade_getTenderBidInfo(Params params) {
        String actual = this.tenderFacade_getTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getTenderBidList", dataProvider = "provider", description = "发标后台列表接口")
    public void tenderFacade_getTenderBidList(Params params) {
        String actual = this.tenderFacade_getTenderBidList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/getUserLogDetailPageInfo", dataProvider = "provider", description = "获取用户日志分页信息")
    public void tenderFacade_getUserLogDetailPageInfo(Params params) {
        String actual = this.tenderFacade_getUserLogDetailPageInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/miscarryBid", dataProvider = "provider", description = "指定待放款的标的流标")
    public void tenderFacade_miscarryBid(Params params) {
        String actual = this.tenderFacade_miscarryBid(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/preReleaseTenderBidInfo", dataProvider = "provider", description = "预发布标的信息接口")
    public void tenderFacade_preReleaseTenderBidInfo(Params params) {
        String actual = this.tenderFacade_preReleaseTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/queryAccountsPayableDetail", dataProvider = "provider", description = "查询融租债转账款信息")
    public void tenderFacade_queryAccountsPayableDetail(Params params) {
        String actual = this.tenderFacade_queryAccountsPayableDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/queryAllExchangeInfo", dataProvider = "provider", description = "获取全部交易所信息")
    public void tenderFacade_queryAllExchangeInfo(Params params) {
        String actual = this.tenderFacade_queryAllExchangeInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/queryBidCheckList", dataProvider = "provider", description = "查询标的审核信息")
    public void tenderFacade_queryBidCheckList(Params params) {
        String actual = this.tenderFacade_queryBidCheckList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/queryBidListByQueueId", dataProvider = "provider", description = "根据标的发布队列查询标的列表信息")
    public void tenderFacade_queryBidListByQueueId(Params params) {
        String actual = this.tenderFacade_queryBidListByQueueId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/queryBidReleaseQueueByCond", dataProvider = "provider", description = "根据条件查询标的发布队列")
    public void tenderFacade_queryBidReleaseQueueByCond(Params params) {
        String actual = this.tenderFacade_queryBidReleaseQueueByCond(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/releaseTenderBidInfo", dataProvider = "provider", description = "发布标的信息接口")
    public void tenderFacade_releaseTenderBidInfo(Params params) {
        String actual = this.tenderFacade_releaseTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/saveBidReleaseQueue", dataProvider = "provider", description = "新增标的发布队列")
    public void tenderFacade_saveBidReleaseQueue(Params params) {
        String actual = this.tenderFacade_saveBidReleaseQueue(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/settingScheduleReleaseTime", dataProvider = "provider", description = "设置标的定时发布时间")
    public void tenderFacade_settingScheduleReleaseTime(Params params) {
        String actual = this.tenderFacade_settingScheduleReleaseTime(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/submitBidInfo", dataProvider = "provider", description = "提交标的信息")
    public void tenderFacade_submitBidInfo(Params params) {
        String actual = this.tenderFacade_submitBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/updateAccountsPayableDetail", dataProvider = "provider", description = "更新融租债转账款信息")
    public void tenderFacade_updateAccountsPayableDetail(Params params) {
        String actual = this.tenderFacade_updateAccountsPayableDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/updateBidExtraInfo", dataProvider = "provider", description = "更新标的附加信息")
    public void tenderFacade_updateBidExtraInfo(Params params) {
        String actual = this.tenderFacade_updateBidExtraInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/updateBidReleaseQueue", dataProvider = "provider", description = "修改标的发布队列")
    public void tenderFacade_updateBidReleaseQueue(Params params) {
        String actual = this.tenderFacade_updateBidReleaseQueue(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/updateCarBidDetail", dataProvider = "provider", description = "更新车抵押表抵押物信息")
    public void tenderFacade_updateCarBidDetail(Params params) {
        String actual = this.tenderFacade_updateCarBidDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/updateExchangeInfo", dataProvider = "provider", description = "更新交易所信息")
    public void tenderFacade_updateExchangeInfo(Params params) {
        String actual = this.tenderFacade_updateExchangeInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/updateLabel", dataProvider = "provider", description = "更新标签")
    public void tenderFacade_updateLabel(Params params) {
        String actual = this.tenderFacade_updateLabel(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/tenderFacade/updateTenderBidInfo", dataProvider = "provider", description = "更新标的信息")
    public void tenderFacade_updateTenderBidInfo(Params params) {
        String actual = this.tenderFacade_updateTenderBidInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/yyTradeStatFacade/annualInvestmentAmount", dataProvider = "provider", description = "根据投资时间和海融易id,查询该时间段内的年化投资总额")
    public void yyTradeStatFacade_annualInvestmentAmount(Params params) {
        String actual = this.yyTradeStatFacade_annualInvestmentAmount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/yyTradeStatFacade/getInvestmentTotalAmount", dataProvider = "provider", description = "根据投资时间和ID，查询用户该时间段内的投资金额")
    public void yyTradeStatFacade_getInvestmentTotalAmount(Params params) {
        String actual = this.yyTradeStatFacade_getInvestmentTotalAmount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/yyTradeStatFacade/loanCalculate", dataProvider = "provider", description = "贷款/收益计算器")
    public void yyTradeStatFacade_loanCalculate(Params params) {
        String actual = this.yyTradeStatFacade_loanCalculate(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/yyTradeStatFacade/queryBidOrderByBidRecordId", dataProvider = "provider", description = "根据投资记录号（bidRecordId）查询投资订单")
    public void yyTradeStatFacade_queryBidOrderByBidRecordId(Params params) {
        String actual = this.yyTradeStatFacade_queryBidOrderByBidRecordId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/yyTradeStatFacade/queryBidOrderByOrderId", dataProvider = "provider", description = "根据投资订单号（orderId）查询投资订单）")
    public void yyTradeStatFacade_queryBidOrderByOrderId(Params params) {
        String actual = this.yyTradeStatFacade_queryBidOrderByOrderId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/yyTradeStatFacade/totalInvestmentAmount", dataProvider = "provider", description = "根据投资时间和海融易id,查询这段时间内的投资总金额")
    public void yyTradeStatFacade_totalInvestmentAmount(Params params) {
        String actual = this.yyTradeStatFacade_totalInvestmentAmount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/yyTradeStatFacade/twoAnniversary", dataProvider = "provider", description = "根据投资时间和ID，查询用户该时间段内的投资金额(只包含标的期限30天以上)")
    public void yyTradeStatFacade_twoAnniversary(Params params) {
        String actual = this.yyTradeStatFacade_twoAnniversary(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

}
