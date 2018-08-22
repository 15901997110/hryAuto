package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: P2pBase
 * @Author: 自动生成
 * @Date: 2018/08/22 16:04:42
 */
@SKey("P2p")
public class P2pBase extends Base {
    @Uri(value = "/agreementFacade/addProductInstruction", desc = "增加产品说明书")
    public String _agreementFacade_addProductInstruction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getAgreementTemplate", desc = "根据标的ID获取协议模版")
    public String _agreementFacade_getAgreementTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getBidAgreement", desc = "根据标的ID获取协议")
    public String _agreementFacade_getBidAgreement(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getHuijinAgreementTemplate", desc = "根据债权ID获取拾财计划协议模版")
    public String _agreementFacade_getHuijinAgreementTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getHuijinContract", desc = "获取合同内容")
    public String _agreementFacade_getHuijinContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getProductContract", desc = "获取合同内容")
    public String _agreementFacade_getProductContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getProductInstructionList", desc = "获取产品说明书列表")
    public String _agreementFacade_getProductInstructionList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getProductInstructions", desc = "根据标的ID获取产品说明书")
    public String _agreementFacade_getProductInstructions(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/getTransferOfDebtContract", desc = "获取债转合同内容")
    public String _agreementFacade_getTransferOfDebtContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/queryProductInstruction", desc = "获取产品说明书")
    public String _agreementFacade_queryProductInstruction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/agreementFacade/updateProductInstructions", desc = "更新产品说明书")
    public String _agreementFacade_updateProductInstructions(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/alterNativeRechargeFacade/addAlterNativeRecharge", desc = "代充值")
    public String _alterNativeRechargeFacade_addAlterNativeRecharge(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/alterNativeRechargeFacade/queryAlterNativeList", desc = "查询代充值列表")
    public String _alterNativeRechargeFacade_queryAlterNativeList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/assetsResourceFacade/loan", desc = "线上放款")
    public String _assetsResourceFacade_loan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/assetsResourceFacade/queryAssets", desc = "查询资产信息")
    public String _assetsResourceFacade_queryAssets(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/assetsResourceFacade/updateAssfinance", desc = "线上融资(标的发布/废弃)")
    public String _assetsResourceFacade_updateAssfinance(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/assistFacade/updateBidInfoById", desc = "更改标的信息")
    public String _assistFacade_updateBidInfoById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/assistFacade/updateEnclosureByBid", desc = "更新标的附件")
    public String _assistFacade_updateEnclosureByBid(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/assistFacade/updateSystemVariable", desc = "更改配置")
    public String _assistFacade_updateSystemVariable(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/getAggregatedBidDetail", desc = "查询聚合标的信息，包括标的基础信息、项目描述、借款方信息、风险措施、审核信息")
    public String _bidFacade_getAggregatedBidDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/getBidCategoryList", desc = "获取标的Tag")
    public String _bidFacade_getBidCategoryList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/getBidDetailByIdList", desc = "根据List[Id]查询标的信息(不包含消金标的)")
    public String _bidFacade_getBidDetailByIdList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/getBidRuleConfigById", desc = "根据ID获取标的配置规则")
    public String _bidFacade_getBidRuleConfigById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/getBidTypeList", desc = "获取标的Type")
    public String _bidFacade_getBidTypeList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/getTotalAmountBybidAndUser", desc = "根据用户获取指定标的累计投资金额")
    public String _bidFacade_getTotalAmountBybidAndUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/queryBidDetailByIdList", desc = "根据List[Id]查询标的信息（所有的包含消金标的信息）")
    public String _bidFacade_queryBidDetailByIdList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/queryBidListCond", desc = "根据条件查询标的信息")
    public String _bidFacade_queryBidListCond(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/queryBidRuleConfigByCondition", desc = "根据条件查询标的配置规则")
    public String _bidFacade_queryBidRuleConfigByCondition(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/queryCouponBidListByQueryCond", desc = "根据条件查询标的信息列表(投资券筛选可投标的)")
    public String _bidFacade_queryCouponBidListByQueryCond(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/queryExchangeInfo", desc = "查询所有交易所信息")
    public String _bidFacade_queryExchangeInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/queryLcjBidListByQueryCond", desc = "根据条件查询标的信息列表(理财金筛选可投标的)")
    public String _bidFacade_queryLcjBidListByQueryCond(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/saveBidRuleConfig", desc = "新增标的配置规则")
    public String _bidFacade_saveBidRuleConfig(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/updateBidRuleConfig", desc = "修改标的配置规则")
    public String _bidFacade_updateBidRuleConfig(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bidFacade/updateBidRuleConfigEnabledStatus", desc = "修改标的配置启用状态")
    public String _bidFacade_updateBidRuleConfigEnabledStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/caculateCfRepayPlan", desc = "根据预约计划编号计算还款计划")
    public String _cfFacade_caculateCfRepayPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/createReserveOrder", desc = "预约投资（消金下单）")
    public String _cfFacade_createReserveOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/examineOrAbandonCfPlan", desc = "审批／废弃 预约计划")
    public String _cfFacade_examineOrAbandonCfPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/generateCfReservationPlan", desc = "生成消金预约计划")
    public String _cfFacade_generateCfReservationPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getCfAgreementTemplate", desc = "根据消金协议模版HTML")
    public String _cfFacade_getCfAgreementTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getCfReservationPlan", desc = "查询消金预约计划")
    public String _cfFacade_getCfReservationPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getCfReserveInvestPage", desc = "获取预约资产列表（console 后台专用）")
    public String _cfFacade_getCfReserveInvestPage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getCfReserveOrderDetail", desc = "获取预约记录详情（console 后台专用）")
    public String _cfFacade_getCfReserveOrderDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getCfReserveOrderPage", desc = "获取预约记录列表（console 后台专用）")
    public String _cfFacade_getCfReserveOrderPage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getInvestmentProperty", desc = "获取用户投资资产信息")
    public String _cfFacade_getInvestmentProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getInvestorInfoByBidId", desc = "获取投资人投资信息")
    public String _cfFacade_getInvestorInfoByBidId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getMyInvestPlanRecord", desc = "我的投资-计划")
    public String _cfFacade_getMyInvestPlanRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getMyReservationOrderInfo", desc = "获取我的预约信息，包括订单总数量")
    public String _cfFacade_getMyReservationOrderInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getPlanAssetDetail", desc = "我的预约：获取用户的计划资产详情")
    public String _cfFacade_getPlanAssetDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getPlanTradeDetail", desc = "根据预约订单编码查询预约记录详情")
    public String _cfFacade_getPlanTradeDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getReservationPlanOrder", desc = "根据预约订单号查询预约记录详情")
    public String _cfFacade_getReservationPlanOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getReservationPlanOrderDetail", desc = "根据预约订单编码查询预约记录详情")
    public String _cfFacade_getReservationPlanOrderDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getReserveOrderByRequestNo", desc = "查询预约投资（消金下单）订单及状态")
    public String _cfFacade_getReserveOrderByRequestNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/getReserveOrderDetail", desc = "查询预约订单详情(H5专用)")
    public String _cfFacade_getReserveOrderDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryBiddingOrder", desc = "根据预约计划查询已购买标的")
    public String _cfFacade_queryBiddingOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryCfBidByCfPlan", desc = "根据预约计划查询标的信息（console 后台专用）")
    public String _cfFacade_queryCfBidByCfPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryCfOrderByCfPlan", desc = "根据预约计划查询预约记录（console 后台专用）")
    public String _cfFacade_queryCfOrderByCfPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryCfPlanByCondition", desc = "根据条件查询预约计划(console 后台专用)")
    public String _cfFacade_queryCfPlanByCondition(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryCfPlanDetail", desc = "根据预约计划详情（console 后台专用）")
    public String _cfFacade_queryCfPlanDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryCouponReservationPlanByCond", desc = "根据条件查询预约计划（投资券筛选可预约计划）")
    public String _cfFacade_queryCouponReservationPlanByCond(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryRepayRecord", desc = "根据预约计划查询回款明细")
    public String _cfFacade_queryRepayRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryReservationPlanByStatus", desc = "预约专区:根据预约状态查询预约记录列表，")
    public String _cfFacade_queryReservationPlanByStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryReservationPlanDetail", desc = "预约详情:根据预约计划编号查询详情")
    public String _cfFacade_queryReservationPlanDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryReservationPlanOrder", desc = "我的预约列表：页面：交易记录-出借记录-预约列表")
    public String _cfFacade_queryReservationPlanOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cfFacade/queryUnfreezeOrders", desc = "解冻订单查询，后台管理专用")
    public String _cfFacade_queryUnfreezeOrders(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/frontEndFacade/listReservationPlan", desc = "获取消金计划列表")
    public String _frontEndFacade_listReservationPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/frontEndFacade/queryNoviceBidDetail", desc = "查询首页新手标的")
    public String _frontEndFacade_queryNoviceBidDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/frontEndFacade/queryNoviceBidList", desc = "查询首页新手标的,app专用")
    public String _frontEndFacade_queryNoviceBidList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/getFundRate", desc = "收益率信息查询")
    public String _fundFacade_getFundRate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/applyDebtSale", desc = "申请单笔债权出让")
    public String _huijinPlanFacade_applyDebtSale(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/changeDebtType", desc = "改变债权类型，用于债权转让")
    public String _huijinPlanFacade_changeDebtType(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/freezeAndApplyDebtSale", desc = "冻结债权并且申请单笔债权出让")
    public String _huijinPlanFacade_freezeAndApplyDebtSale(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/freezeDebt", desc = "冻结债权")
    public String _huijinPlanFacade_freezeDebt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/getBidRecordIdByDebtId", desc = "根据债权ID 查询投标记录ID")
    public String _huijinPlanFacade_getBidRecordIdByDebtId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/getDebtInfo", desc = "获取债权信息")
    public String _huijinPlanFacade_getDebtInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/getDebtInfoByBidRecordId", desc = "根据投标记录ID 查询债权信息")
    public String _huijinPlanFacade_getDebtInfoByBidRecordId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/getTradingRepayment", desc = "获取债权转让后P2P还款详细信息")
    public String _huijinPlanFacade_getTradingRepayment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/lockDebt", desc = "锁定/解锁债权")
    public String _huijinPlanFacade_lockDebt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/loseDebt", desc = "债权丧权")
    public String _huijinPlanFacade_loseDebt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/transferDebt", desc = "债权转让接口")
    public String _huijinPlanFacade_transferDebt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/unfreezeAndCancelDebtSale", desc = "解冻债权并且取消单笔债权出让")
    public String _huijinPlanFacade_unfreezeAndCancelDebtSale(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/huijinPlanFacade/unfreezeDebt", desc = "解冻债权")
    public String _huijinPlanFacade_unfreezeDebt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/createInvestOrder", desc = "投资下单")
    public String _investFacade_createInvestOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getBiddingStatusByVoucherNo", desc = "根据凭证号查询投标状态")
    public String _investFacade_getBiddingStatusByVoucherNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getInvestmentInfo", desc = "获取用户投资信息")
    public String _investFacade_getInvestmentInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getInvestmentProperty", desc = "获取用户投资资产信息")
    public String _investFacade_getInvestmentProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getInvestStatusByOrderId", desc = "根据订单号查询投资状态")
    public String _investFacade_getInvestStatusByOrderId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getInvestStatusByRequestNo", desc = "根据用户预处理请求流水号查询投资状态(查询非消金投资)")
    public String _investFacade_getInvestStatusByRequestNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getMyInvestDetail", desc = "查询我的投资交易详情")
    public String _investFacade_getMyInvestDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getNumberOfBidders", desc = "获取标的ID获取该标的已经投资的人数")
    public String _investFacade_getNumberOfBidders(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getOfflineOrder", desc = "获取用户海利计划投资记录")
    public String _investFacade_getOfflineOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getOfflineProperty", desc = "获取用户海利计划资产信息")
    public String _investFacade_getOfflineProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/getUserPurchaseRecordListByHryId", desc = "查询用户所有投资记录信息")
    public String _investFacade_getUserPurchaseRecordListByHryId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/investCountStatistics", desc = "根据hryIdList统计用户投资笔数")
    public String _investFacade_investCountStatistics(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/investCountStatisticsByHryId", desc = "根据hryId统计单个用户投资笔数")
    public String _investFacade_investCountStatisticsByHryId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/noviceCheck", desc = "投标，新手效验")
    public String _investFacade_noviceCheck(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryAllPrincipalAndInterestReceived", desc = "根据hryId查询用户全部待收本息")
    public String _investFacade_queryAllPrincipalAndInterestReceived(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryInvestByCond", desc = "查询条件查询投资列表（console后台）")
    public String _investFacade_queryInvestByCond(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryInvestRecord", desc = "获取我的投资列表信息")
    public String _investFacade_queryInvestRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryMyInvest", desc = "查询我的投资列表")
    public String _investFacade_queryMyInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryPurchaseCondByHryIdList", desc = "批量查询指定用户的投资情况")
    public String _investFacade_queryPurchaseCondByHryIdList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryPurchaseRecordList", desc = "查询投资记录")
    public String _investFacade_queryPurchaseRecordList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryRepaymentRecordList", desc = "根据条件查询用户投资还款信息列表")
    public String _investFacade_queryRepaymentRecordList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investFacade/queryTotalMoney", desc = "根据条件查询用户投资总金额")
    public String _investFacade_queryTotalMoney(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investReservationFacade/addShortMsgBlackList", desc = "添加短信黑名单")
    public String _investReservationFacade_addShortMsgBlackList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investReservationFacade/getInvestReservationList", desc = "获取代客理财")
    public String _investReservationFacade_getInvestReservationList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investReservationFacade/getShortMsgBlackList", desc = "获取短信黑名单列表")
    public String _investReservationFacade_getShortMsgBlackList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/investReservationFacade/removeFromBlackList", desc = "允许短信")
    public String _investReservationFacade_removeFromBlackList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/loanByBid", desc = "标的放款")
    public String _loanFacade_loanByBid(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/loanByCommand", desc = "单独调用一个命令，慎用")
    public String _loanFacade_loanByCommand(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/loanNotify", desc = "异步通知，仅供测试")
    public String _loanFacade_loanNotify(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/queryLoanBid", desc = "查询待放款标的信息")
    public String _loanFacade_queryLoanBid(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/queryLoanBidDetail", desc = "查询放款标的信息")
    public String _loanFacade_queryLoanBidDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/queryLoanOrder", desc = "查询已放款标的信息")
    public String _loanFacade_queryLoanOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/queryUserLoanOrders", desc = "查询放款订单")
    public String _loanFacade_queryUserLoanOrders(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/resendContractMq", desc = "合同系统MQ重发")
    public String _loanFacade_resendContractMq(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanFacade/specifyTransfer", desc = "触发指定交易确认")
    public String _loanFacade_specifyTransfer(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageFacade/messageFacade", desc = "发送消息")
    public String _messageFacade_messageFacade(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/addBatchOfflinePlan", desc = "批量添加计划")
    public String _offlinePlanFacade_addBatchOfflinePlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/addOfflinePlan", desc = "添加计划")
    public String _offlinePlanFacade_addOfflinePlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/getOfflinePlan", desc = "查询计划")
    public String _offlinePlanFacade_getOfflinePlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/getOfflinePlanDetail", desc = "WEB-查询产品详情")
    public String _offlinePlanFacade_getOfflinePlanDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/getUserInvestOrder", desc = "获取用户投资订单")
    public String _offlinePlanFacade_getUserInvestOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/getWhetherInvest", desc = "是否发起投资")
    public String _offlinePlanFacade_getWhetherInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/invalidOrder", desc = "作废订单")
    public String _offlinePlanFacade_invalidOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/listOfflineIssuerAndConsignee", desc = "获取发行人和承销商信息")
    public String _offlinePlanFacade_listOfflineIssuerAndConsignee(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/listOfflineRepayOrder", desc = "获取用户还款订单")
    public String _offlinePlanFacade_listOfflineRepayOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/listReleaseOfflinePlan", desc = "WEB-查询上线产品列表")
    public String _offlinePlanFacade_listReleaseOfflinePlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/queryInvestByPage", desc = "根据条件分页查询投资记录")
    public String _offlinePlanFacade_queryInvestByPage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/queryOfflinePlan", desc = "分页查询计划")
    public String _offlinePlanFacade_queryOfflinePlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/resetOfflineRepayOrder", desc = "重置还款订单")
    public String _offlinePlanFacade_resetOfflineRepayOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/setOnOffOfOfflinePlan", desc = "设置线下理财上下线")
    public String _offlinePlanFacade_setOnOffOfOfflinePlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/updateOfflinePlan", desc = "修改计划")
    public String _offlinePlanFacade_updateOfflinePlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/updateUserInvestOrder", desc = "修改用户投资订单")
    public String _offlinePlanFacade_updateUserInvestOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/userInvest", desc = "后台-用户预约")
    public String _offlinePlanFacade_userInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/offlinePlanFacade/userReservation", desc = "WEB-用户预约")
    public String _offlinePlanFacade_userReservation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/orderFacade/exportPurchaseRecord", desc = "导出查询投资记录")
    public String _orderFacade_exportPurchaseRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/orderFacade/getRealTimePurchaseRecord", desc = "获取首页实时理财信息")
    public String _orderFacade_getRealTimePurchaseRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/orderFacade/getRepaymentStatusByOrderIdList", desc = "批量查询订单还款状态")
    public String _orderFacade_getRepaymentStatusByOrderIdList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/orderFacade/queryPurchaseRecord", desc = "查询投资记录")
    public String _orderFacade_queryPurchaseRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/orderFacade/queryPurchaseRecordDetail", desc = "根据投标记录查询标的信息")
    public String _orderFacade_queryPurchaseRecordDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/platformMarkingFacade/addAlterNativeRecharge", desc = "新增页面获取用户ID")
    public String _platformMarkingFacade_addAlterNativeRecharge(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/platformMarkingFacade/creatPlatformMarking", desc = "平台营销")
    public String _platformMarkingFacade_creatPlatformMarking(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/platformMarkingFacade/queryAlterNativeList", desc = "查询代充值列表")
    public String _platformMarkingFacade_queryAlterNativeList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/platformMarkingFacade/selectUserInfo", desc = "查询用户信息")
    public String _platformMarkingFacade_selectUserInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/productFacade/generateBatchProduct", desc = "批量发标")
    public String _productFacade_generateBatchProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/productFacade/generateProduct", desc = "发标接口")
    public String _productFacade_generateProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/productFacade/getBatchReleaseLog", desc = "批量发标记录查询")
    public String _productFacade_getBatchReleaseLog(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/productFacade/queryEntrustPayOrder", desc = "【console】查询委托支付授权订单")
    public String _productFacade_queryEntrustPayOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/productFacade/queryProductByCreditId", desc = "确认发标是否成功")
    public String _productFacade_queryProductByCreditId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/getMyAssetByTransferOfDebt", desc = "获取我的债转投资资产信息")
    public String _queryTransferOfDebtFacade_getMyAssetByTransferOfDebt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/getRepaymentDetail", desc = "获取回款债转详情")
    public String _queryTransferOfDebtFacade_getRepaymentDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/listMyTransferOfDebt", desc = "获取我的债转投资列表信息")
    public String _queryTransferOfDebtFacade_listMyTransferOfDebt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/listRepaymentDetails", desc = "获取回款债转列表")
    public String _queryTransferOfDebtFacade_listRepaymentDetails(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/createAdjustAccountOrder", desc = "创建调账订单")
    public String _rechargeAndWithdrawFacade_createAdjustAccountOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/createRechargeOrder", desc = "充值")
    public String _rechargeAndWithdrawFacade_createRechargeOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/createWithdrawOrder", desc = "提现")
    public String _rechargeAndWithdrawFacade_createWithdrawOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/directRecharge", desc = "自动充值")
    public String _rechargeAndWithdrawFacade_directRecharge(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/directWithdraw", desc = "自动提现")
    public String _rechargeAndWithdrawFacade_directWithdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryAdjustAccountOrder", desc = "查询调账订单")
    public String _rechargeAndWithdrawFacade_queryAdjustAccountOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryRechargeList", desc = "【console】查询充值订单列表")
    public String _rechargeAndWithdrawFacade_queryRechargeList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryRechargeRecord", desc = "前端查询充值交易记录")
    public String _rechargeAndWithdrawFacade_queryRechargeRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryRechargeRecordDetail", desc = "前端查询充值交易记录详情")
    public String _rechargeAndWithdrawFacade_queryRechargeRecordDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryWithdrawList", desc = "【console】查询所有用户提现列表")
    public String _rechargeAndWithdrawFacade_queryWithdrawList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryWithdrawRecord", desc = "前端查询用户提现订单")
    public String _rechargeAndWithdrawFacade_queryWithdrawRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryWithdrawRecordDetail", desc = "前端查询提现交易详情")
    public String _rechargeAndWithdrawFacade_queryWithdrawRecordDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/sumWithdrawPending", desc = "查询提现中的总金额")
    public String _rechargeAndWithdrawFacade_sumWithdrawPending(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/reconFacade/queryBackrollReconciliation", desc = "查询资金回退充值订单对账信息")
    public String _reconFacade_queryBackrollReconciliation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/reconFacade/queryCommissionInfo", desc = "查询佣金对账信息")
    public String _reconFacade_queryCommissionInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/reconFacade/queryRechargeReconciliation", desc = "查询充值订单对账信息")
    public String _reconFacade_queryRechargeReconciliation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/reconFacade/queryReconInfo", desc = "查询交易对账信息")
    public String _reconFacade_queryReconInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/reconFacade/queryWithdrawReconciliation", desc = "查询提现充值订单对账信息")
    public String _reconFacade_queryWithdrawReconciliation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/regionFacade/getSubRegion", desc = "根据ID查询上级地区信息")
    public String _regionFacade_getSubRegion(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/regionFacade/regionInfo", desc = "查询地区信息接口")
    public String _regionFacade_regionInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/financierRepayment", desc = "融资人还款")
    public String _repaymentFacade_financierRepayment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/financierRepaymentWithExinterest", desc = "融资人还款(无息)。场景：募集成功、放款后，借款人又不借了。")
    public String _repaymentFacade_financierRepaymentWithExinterest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/financierStatistics", desc = "融资统计")
    public String _repaymentFacade_financierStatistics(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/getBidHkjh", desc = "查询标的标还款记录(标的应还款信息查询接口)")
    public String _repaymentFacade_getBidHkjh(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/getFinancierRepaymentOrder", desc = "查询融资人还款记录 详情")
    public String _repaymentFacade_getFinancierRepaymentOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/getInvestorRepaymentDetail", desc = "查询投资人收款明细详情")
    public String _repaymentFacade_getInvestorRepaymentDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/getRepayingDetail", desc = "查询最近一期还款详情")
    public String _repaymentFacade_getRepayingDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/getReserveRepaymentDetail", desc = "查询投资人-预约回款详情")
    public String _repaymentFacade_getReserveRepaymentDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/listFinancierRepaymentOrders", desc = "查询融资人还款记录")
    public String _repaymentFacade_listFinancierRepaymentOrders(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/listFinancierRepaymentOrdersConsole", desc = "查询融资人还款记录（console使用）")
    public String _repaymentFacade_listFinancierRepaymentOrdersConsole(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/listFinancierRepaymentPlans", desc = "查询标的还款明细")
    public String _repaymentFacade_listFinancierRepaymentPlans(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/listInvestorRepaymentDetails", desc = "查询投资人收款明细")
    public String _repaymentFacade_listInvestorRepaymentDetails(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/listInvestorRepaymentDetailsConsole", desc = "查询投资人收款明细（Console使用）")
    public String _repaymentFacade_listInvestorRepaymentDetailsConsole(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/prepayment", desc = "融资人提前还款")
    public String _repaymentFacade_prepayment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/prepaymentApplication", desc = "提前还款申请与审核")
    public String _repaymentFacade_prepaymentApplication(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryBiddersHkjh", desc = "查询用户投标还款计划信息")
    public String _repaymentFacade_queryBiddersHkjh(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryCfBiddingOrderHkjh", desc = "查询用户预约标的还款计划信息")
    public String _repaymentFacade_queryCfBiddingOrderHkjh(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryExistsPrepaymentPlan", desc = "查询已经提前还款的计划详情")
    public String _repaymentFacade_queryExistsPrepaymentPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryPerfectHkjh", desc = "查询标的还款计划")
    public String _repaymentFacade_queryPerfectHkjh(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryPrepaymentApplication", desc = "查询提前还款标的信息")
    public String _repaymentFacade_queryPrepaymentApplication(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryPrepaymentPlan", desc = "查询提前还款计划")
    public String _repaymentFacade_queryPrepaymentPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryRepayingBids", desc = "查询还款中标的")
    public String _repaymentFacade_queryRepayingBids(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryRepaymentBids", desc = "融资查询")
    public String _repaymentFacade_queryRepaymentBids(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryRepaymentDetail", desc = "【console】查询标的还款、代偿详情")
    public String _repaymentFacade_queryRepaymentDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryRepaymentList", desc = "【console】查询标的还款、代偿列表")
    public String _repaymentFacade_queryRepaymentList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryReserveRepaymentDetails", desc = "查询投资人-预约回款列表")
    public String _repaymentFacade_queryReserveRepaymentDetails(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/querySettledBids", desc = "查询已结清标的")
    public String _repaymentFacade_querySettledBids(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/queryUnpaidBidDetail", desc = "【console】查询待还款标的详情")
    public String _repaymentFacade_queryUnpaidBidDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/rebuildInvestorRepaymentDetailsConsole", desc = "重发失败的还款确认明细（Console使用）")
    public String _repaymentFacade_rebuildInvestorRepaymentDetailsConsole(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/repaymentFacade/reserveRepayment", desc = "预约还款")
    public String _repaymentFacade_reserveRepayment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/stockPrepaymentApplyFacade/applyStockPrepayment", desc = "存量数据申请提前还款")
    public String _stockPrepaymentApplyFacade_applyStockPrepayment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/stockPrepaymentApplyFacade/listStockPrepayment", desc = "根据条件查询存量提前还款列表")
    public String _stockPrepaymentApplyFacade_listStockPrepayment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/stockPrepaymentApplyFacade/listStockPrepaymentByIds", desc = "根据条件查询存量提前还款列表")
    public String _stockPrepaymentApplyFacade_listStockPrepaymentByIds(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addBatchEnclosure", desc = "新增批量附件")
    public String _tenderFacade_addBatchEnclosure(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addBidExtraInfo", desc = "新增标的附加信息")
    public String _tenderFacade_addBidExtraInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addBidLabel", desc = "新增标的的标签")
    public String _tenderFacade_addBidLabel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addCarBidDetail", desc = "保存车抵押表抵押物信息")
    public String _tenderFacade_addCarBidDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addCarBidDetailList", desc = "保存车抵押表抵押物列表信息")
    public String _tenderFacade_addCarBidDetailList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addEnclosure", desc = "新增附件")
    public String _tenderFacade_addEnclosure(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addExchangeInfo", desc = "增加交易所信息")
    public String _tenderFacade_addExchangeInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addLabelInfo", desc = "增加标签")
    public String _tenderFacade_addLabelInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/addTenderBidInfo", desc = "保存标的信息接口")
    public String _tenderFacade_addTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/agreeTenderBidInfo", desc = "审核同意标的信息接口")
    public String _tenderFacade_agreeTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/checkReleaseQueueBidValiad", desc = "校验发布队列标的有效性")
    public String _tenderFacade_checkReleaseQueueBidValiad(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/createAccountsPayableDetail", desc = "增加融租债转账款信息")
    public String _tenderFacade_createAccountsPayableDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/createBidToCopy", desc = "根据当前标的复制创建新标的")
    public String _tenderFacade_createBidToCopy(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/deleteAccountsPayableDetail", desc = "删除融租债转账款信息")
    public String _tenderFacade_deleteAccountsPayableDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/deleteAccountsPayableDetailList", desc = "删除融租债转账款信息(根据标的ID)")
    public String _tenderFacade_deleteAccountsPayableDetailList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/deleteBidLabel", desc = "删除标的的标签")
    public String _tenderFacade_deleteBidLabel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/deleteCarBidDetail", desc = "删除车抵押表抵押物信息")
    public String _tenderFacade_deleteCarBidDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/deleteEnclosure", desc = "删除附件")
    public String _tenderFacade_deleteEnclosure(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/deleteLabelInfo", desc = "删除标签")
    public String _tenderFacade_deleteLabelInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/disagreeTenderBidInfo", desc = "审核不同意标的信息接口")
    public String _tenderFacade_disagreeTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/discardTenderBidInfo", desc = "作废标的信息接口")
    public String _tenderFacade_discardTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getBidExtraInfo", desc = "查询标的附加信息")
    public String _tenderFacade_getBidExtraInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getCarBidDetails", desc = "查询车抵押表抵押物信息")
    public String _tenderFacade_getCarBidDetails(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getCbpLoanInfoByLoanId", desc = "查询信贷信息")
    public String _tenderFacade_getCbpLoanInfoByLoanId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getEnclosure", desc = "查询附件")
    public String _tenderFacade_getEnclosure(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getEnclosureTypes", desc = "查询附件类型")
    public String _tenderFacade_getEnclosureTypes(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getExchangeInfoByBidId", desc = "根据标的ID获取交易所信息")
    public String _tenderFacade_getExchangeInfoByBidId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getExchangeInfoById", desc = "根据交易所ID获取交易所信息")
    public String _tenderFacade_getExchangeInfoById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getLabelInfos", desc = "查询标签")
    public String _tenderFacade_getLabelInfos(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getLabelInfosByBid", desc = "查询标的标签")
    public String _tenderFacade_getLabelInfosByBid(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getRepayPlanPage", desc = "后台查询还款计划（分页）")
    public String _tenderFacade_getRepayPlanPage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getTenderBidInfo", desc = "发标后台标的详情接口")
    public String _tenderFacade_getTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getTenderBidList", desc = "发标后台列表接口")
    public String _tenderFacade_getTenderBidList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/getUserLogDetailPageInfo", desc = "获取用户日志分页信息")
    public String _tenderFacade_getUserLogDetailPageInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/miscarryBid", desc = "指定待放款的标的流标")
    public String _tenderFacade_miscarryBid(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/preReleaseTenderBidInfo", desc = "预发布标的信息接口")
    public String _tenderFacade_preReleaseTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/queryAccountsPayableDetail", desc = "查询融租债转账款信息")
    public String _tenderFacade_queryAccountsPayableDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/queryAllExchangeInfo", desc = "获取全部交易所信息")
    public String _tenderFacade_queryAllExchangeInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/queryBidCheckList", desc = "查询标的审核信息")
    public String _tenderFacade_queryBidCheckList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/queryBidListByQueueId", desc = "根据标的发布队列查询标的列表信息")
    public String _tenderFacade_queryBidListByQueueId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/queryBidReleaseQueueByCond", desc = "根据条件查询标的发布队列")
    public String _tenderFacade_queryBidReleaseQueueByCond(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/releaseTenderBidInfo", desc = "发布标的信息接口")
    public String _tenderFacade_releaseTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/saveBidReleaseQueue", desc = "新增标的发布队列")
    public String _tenderFacade_saveBidReleaseQueue(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/settingScheduleReleaseTime", desc = "设置标的定时发布时间")
    public String _tenderFacade_settingScheduleReleaseTime(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/submitBidInfo", desc = "提交标的信息")
    public String _tenderFacade_submitBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/updateAccountsPayableDetail", desc = "更新融租债转账款信息")
    public String _tenderFacade_updateAccountsPayableDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/updateBidExtraInfo", desc = "更新标的附加信息")
    public String _tenderFacade_updateBidExtraInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/updateBidReleaseQueue", desc = "修改标的发布队列")
    public String _tenderFacade_updateBidReleaseQueue(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/updateCarBidDetail", desc = "更新车抵押表抵押物信息")
    public String _tenderFacade_updateCarBidDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/updateExchangeInfo", desc = "更新交易所信息")
    public String _tenderFacade_updateExchangeInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/updateLabel", desc = "更新标签")
    public String _tenderFacade_updateLabel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tenderFacade/updateTenderBidInfo", desc = "更新标的信息")
    public String _tenderFacade_updateTenderBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yyTradeStatFacade/annualInvestmentAmount", desc = "根据投资时间和海融易id,查询该时间段内的年化投资总额")
    public String _yyTradeStatFacade_annualInvestmentAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yyTradeStatFacade/getInvestmentTotalAmount", desc = "根据投资时间和ID，查询用户该时间段内的投资金额")
    public String _yyTradeStatFacade_getInvestmentTotalAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yyTradeStatFacade/loanCalculate", desc = "贷款/收益计算器")
    public String _yyTradeStatFacade_loanCalculate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yyTradeStatFacade/queryBidOrderByBidRecordId", desc = "根据投资记录号（bidRecordId）查询投资订单")
    public String _yyTradeStatFacade_queryBidOrderByBidRecordId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yyTradeStatFacade/queryBidOrderByOrderId", desc = "根据投资订单号（orderId）查询投资订单）")
    public String _yyTradeStatFacade_queryBidOrderByOrderId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yyTradeStatFacade/totalInvestmentAmount", desc = "根据投资时间和海融易id,查询这段时间内的投资总金额")
    public String _yyTradeStatFacade_totalInvestmentAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yyTradeStatFacade/twoAnniversary", desc = "根据投资时间和ID，查询用户该时间段内的投资金额(只包含标的期限30天以上)")
    public String _yyTradeStatFacade_twoAnniversary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
