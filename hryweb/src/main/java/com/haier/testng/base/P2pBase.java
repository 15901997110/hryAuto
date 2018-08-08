package com.haier.testng.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: P2pBase
 * @Author: 自动生成
 * @Date: 2018/08/08 16:56:17
 */
@SuppressWarnings("Duplicates")
@Slf4j
@SKey("P2p")
public class P2pBase {
    public Integer serviceId;
    public Integer envId;
    public String caseDesigner;
    public JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型
    public String baseUrl;//http://host:port
    public String dbInfo;
    public Tservice tservice;
    public Tservicedetail tservicedetail;
    public RunService runService = SpringContextHolder.getBean(RunService.class);

    public void init(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        this.serviceId = serviceId;
        this.envId = envId;
        this.caseDesigner = caseDesigner;
        if (StringUtils.isNotBlank(i_c)) {
            this.i_c_JSONObject = JSONObject.parseObject(i_c);
        }
        tservice = runService.getTservice(this.serviceId);
        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);
        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + "://" + tservicedetail.getHostinfo();
        dbInfo = tservicedetail.getDbinfo();
    }

    public Object[] provider(Method method) {
        Object[] objects;
        String iUri;
        //testName可能未填写
        try {
            iUri = method.getAnnotation(Test.class).testName();
            if (iUri == null || "".equals(iUri)) {
                Reporter.log("测试方法中没有没有@Test(testName=\"\")注解");
                throw new SkipException("测试方法中没有没有@Test(testName=\"\")注解");
            }
        } catch (NullPointerException e) {
            log.error("获取测试方法的@Test注解异常:" + method.getName(), e);
            throw new SkipException("获取测试方法的@Test注解异常");
        }

        Ti ti = runService.getTi(this.serviceId, iUri);
        if (ti == null) {
            throw new SkipException("测试服务下面没有接口:" + iUri);
        }
        //此接口对应的全部用例
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        if (tcases == null || tcases.size() == 0) {
            throw new SkipException("此接口无可用的测试用例");
        }

        //如果用户有定制测试用例,则使用用户定制的用例来进行测试
        if (this.i_c_JSONObject != null && this.i_c_JSONObject.size() > 0) {
            JSONArray customCaseArray = i_c_JSONObject.getJSONArray(method.getName());
            if (customCaseArray != null && customCaseArray.size() > 0) {
                Iterator<Tcase> iterator = tcases.iterator();
                while (iterator.hasNext()) {
                    Tcase tcase = iterator.next();
                    //数据库中查到的caseid不在定制列表中,则移除掉
                    if (!customCaseArray.contains(tcase.getId())) {
                        iterator.remove();
                    }
                }
            }
        }
        objects = new Object[tcases.size()];
        for (int i = 0; i < tcases.size(); i++) {
            Params params = new Params();
            params.setTi(ti);
            params.setTcase(tcases.get(i));
            objects[i] = params;
        }
        return objects;
    }

    @Uri(value = "/agreementFacade/addProductInstruction", desc = "增加产品说明书")
    public String agreementFacade_addProductInstruction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getAgreementTemplate", desc = "根据标的ID获取协议模版")
    public String agreementFacade_getAgreementTemplate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getBidAgreement", desc = "根据标的ID获取协议")
    public String agreementFacade_getBidAgreement(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getHuijinAgreementTemplate", desc = "根据债权ID获取拾财计划协议模版")
    public String agreementFacade_getHuijinAgreementTemplate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getHuijinContract", desc = "获取合同内容")
    public String agreementFacade_getHuijinContract(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getProductContract", desc = "获取合同内容")
    public String agreementFacade_getProductContract(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getProductInstructionList", desc = "获取产品说明书列表")
    public String agreementFacade_getProductInstructionList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getProductInstructions", desc = "根据标的ID获取产品说明书")
    public String agreementFacade_getProductInstructions(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/getTransferOfDebtContract", desc = "获取债转合同内容")
    public String agreementFacade_getTransferOfDebtContract(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/queryProductInstruction", desc = "获取产品说明书")
    public String agreementFacade_queryProductInstruction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/agreementFacade/updateProductInstructions", desc = "更新产品说明书")
    public String agreementFacade_updateProductInstructions(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/alterNativeRechargeFacade/addAlterNativeRecharge", desc = "代充值")
    public String alterNativeRechargeFacade_addAlterNativeRecharge(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/alterNativeRechargeFacade/queryAlterNativeList", desc = "查询代充值列表")
    public String alterNativeRechargeFacade_queryAlterNativeList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/assetsResourceFacade/loan", desc = "线上放款")
    public String assetsResourceFacade_loan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/assetsResourceFacade/queryAssets", desc = "查询资产信息")
    public String assetsResourceFacade_queryAssets(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/assetsResourceFacade/updateAssfinance", desc = "线上融资(标的发布/废弃)")
    public String assetsResourceFacade_updateAssfinance(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/assistFacade/updateBidInfoById", desc = "更改标的信息")
    public String assistFacade_updateBidInfoById(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/assistFacade/updateEnclosureByBid", desc = "更新标的附件")
    public String assistFacade_updateEnclosureByBid(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/assistFacade/updateSystemVariable", desc = "更改配置")
    public String assistFacade_updateSystemVariable(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/getAggregatedBidDetail", desc = "查询聚合标的信息，包括标的基础信息、项目描述、借款方信息、风险措施、审核信息")
    public String bidFacade_getAggregatedBidDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/getBidCategoryList", desc = "获取标的Tag")
    public String bidFacade_getBidCategoryList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/getBidDetailByIdList", desc = "根据List[Id]查询标的信息(不包含消金标的)")
    public String bidFacade_getBidDetailByIdList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/getBidRuleConfigById", desc = "根据ID获取标的配置规则")
    public String bidFacade_getBidRuleConfigById(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/getBidTypeList", desc = "获取标的Type")
    public String bidFacade_getBidTypeList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/getTotalAmountBybidAndUser", desc = "根据用户获取指定标的累计投资金额")
    public String bidFacade_getTotalAmountBybidAndUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/queryBidDetailByIdList", desc = "根据List[Id]查询标的信息（所有的包含消金标的信息）")
    public String bidFacade_queryBidDetailByIdList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/queryBidListCond", desc = "根据条件查询标的信息")
    public String bidFacade_queryBidListCond(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/queryBidRuleConfigByCondition", desc = "根据条件查询标的配置规则")
    public String bidFacade_queryBidRuleConfigByCondition(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/queryCouponBidListByQueryCond", desc = "根据条件查询标的信息列表(投资券筛选可投标的)")
    public String bidFacade_queryCouponBidListByQueryCond(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/queryExchangeInfo", desc = "查询所有交易所信息")
    public String bidFacade_queryExchangeInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/queryLcjBidListByQueryCond", desc = "根据条件查询标的信息列表(理财金筛选可投标的)")
    public String bidFacade_queryLcjBidListByQueryCond(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/saveBidRuleConfig", desc = "新增标的配置规则")
    public String bidFacade_saveBidRuleConfig(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/updateBidRuleConfig", desc = "修改标的配置规则")
    public String bidFacade_updateBidRuleConfig(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/bidFacade/updateBidRuleConfigEnabledStatus", desc = "修改标的配置启用状态")
    public String bidFacade_updateBidRuleConfigEnabledStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/caculateCfRepayPlan", desc = "根据预约计划编号计算还款计划")
    public String cfFacade_caculateCfRepayPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/createReserveOrder", desc = "预约投资（消金下单）")
    public String cfFacade_createReserveOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/examineOrAbandonCfPlan", desc = "审批／废弃 预约计划")
    public String cfFacade_examineOrAbandonCfPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/generateCfReservationPlan", desc = "生成消金预约计划")
    public String cfFacade_generateCfReservationPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getCfAgreementTemplate", desc = "根据消金协议模版HTML")
    public String cfFacade_getCfAgreementTemplate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getCfReservationPlan", desc = "查询消金预约计划")
    public String cfFacade_getCfReservationPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getCfReserveInvestPage", desc = "获取预约资产列表（console 后台专用）")
    public String cfFacade_getCfReserveInvestPage(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getCfReserveOrderDetail", desc = "获取预约记录详情（console 后台专用）")
    public String cfFacade_getCfReserveOrderDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getCfReserveOrderPage", desc = "获取预约记录列表（console 后台专用）")
    public String cfFacade_getCfReserveOrderPage(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getInvestmentProperty", desc = "获取用户投资资产信息")
    public String cfFacade_getInvestmentProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getInvestorInfoByBidId", desc = "获取投资人投资信息")
    public String cfFacade_getInvestorInfoByBidId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getMyInvestPlanRecord", desc = "我的投资-计划")
    public String cfFacade_getMyInvestPlanRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getMyReservationOrderInfo", desc = "获取我的预约信息，包括订单总数量")
    public String cfFacade_getMyReservationOrderInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getPlanAssetDetail", desc = "我的预约：获取用户的计划资产详情")
    public String cfFacade_getPlanAssetDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getPlanTradeDetail", desc = "根据预约订单编码查询预约记录详情")
    public String cfFacade_getPlanTradeDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getReservationPlanOrder", desc = "根据预约订单号查询预约记录详情")
    public String cfFacade_getReservationPlanOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getReservationPlanOrderDetail", desc = "根据预约订单编码查询预约记录详情")
    public String cfFacade_getReservationPlanOrderDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getReserveOrderByRequestNo", desc = "查询预约投资（消金下单）订单及状态")
    public String cfFacade_getReserveOrderByRequestNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/getReserveOrderDetail", desc = "查询预约订单详情(H5专用)")
    public String cfFacade_getReserveOrderDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryBiddingOrder", desc = "根据预约计划查询已购买标的")
    public String cfFacade_queryBiddingOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryCfBidByCfPlan", desc = "根据预约计划查询标的信息（console 后台专用）")
    public String cfFacade_queryCfBidByCfPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryCfOrderByCfPlan", desc = "根据预约计划查询预约记录（console 后台专用）")
    public String cfFacade_queryCfOrderByCfPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryCfPlanByCondition", desc = "根据条件查询预约计划(console 后台专用)")
    public String cfFacade_queryCfPlanByCondition(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryCfPlanDetail", desc = "根据预约计划详情（console 后台专用）")
    public String cfFacade_queryCfPlanDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryCouponReservationPlanByCond", desc = "根据条件查询预约计划（投资券筛选可预约计划）")
    public String cfFacade_queryCouponReservationPlanByCond(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryRepayRecord", desc = "根据预约计划查询回款明细")
    public String cfFacade_queryRepayRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryReservationPlanByStatus", desc = "预约专区:根据预约状态查询预约记录列表，")
    public String cfFacade_queryReservationPlanByStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryReservationPlanDetail", desc = "预约详情:根据预约计划编号查询详情")
    public String cfFacade_queryReservationPlanDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryReservationPlanOrder", desc = "我的预约列表：页面：交易记录-出借记录-预约列表")
    public String cfFacade_queryReservationPlanOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/cfFacade/queryUnfreezeOrders", desc = "解冻订单查询，后台管理专用")
    public String cfFacade_queryUnfreezeOrders(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/frontEndFacade/listReservationPlan", desc = "获取消金计划列表")
    public String frontEndFacade_listReservationPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/frontEndFacade/queryNoviceBidDetail", desc = "查询首页新手标的")
    public String frontEndFacade_queryNoviceBidDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/frontEndFacade/queryNoviceBidList", desc = "查询首页新手标的,app专用")
    public String frontEndFacade_queryNoviceBidList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/fundFacade/getFundRate", desc = "收益率信息查询")
    public String fundFacade_getFundRate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/applyDebtSale", desc = "申请单笔债权出让")
    public String huijinPlanFacade_applyDebtSale(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/changeDebtType", desc = "改变债权类型，用于债权转让")
    public String huijinPlanFacade_changeDebtType(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/freezeAndApplyDebtSale", desc = "冻结债权并且申请单笔债权出让")
    public String huijinPlanFacade_freezeAndApplyDebtSale(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/freezeDebt", desc = "冻结债权")
    public String huijinPlanFacade_freezeDebt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/getBidRecordIdByDebtId", desc = "根据债权ID 查询投标记录ID")
    public String huijinPlanFacade_getBidRecordIdByDebtId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/getDebtInfo", desc = "获取债权信息")
    public String huijinPlanFacade_getDebtInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/getDebtInfoByBidRecordId", desc = "根据投标记录ID 查询债权信息")
    public String huijinPlanFacade_getDebtInfoByBidRecordId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/getTradingRepayment", desc = "获取债权转让后P2P还款详细信息")
    public String huijinPlanFacade_getTradingRepayment(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/lockDebt", desc = "锁定/解锁债权")
    public String huijinPlanFacade_lockDebt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/loseDebt", desc = "债权丧权")
    public String huijinPlanFacade_loseDebt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/transferDebt", desc = "债权转让接口")
    public String huijinPlanFacade_transferDebt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/unfreezeAndCancelDebtSale", desc = "解冻债权并且取消单笔债权出让")
    public String huijinPlanFacade_unfreezeAndCancelDebtSale(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/huijinPlanFacade/unfreezeDebt", desc = "解冻债权")
    public String huijinPlanFacade_unfreezeDebt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/createInvestOrder", desc = "投资下单")
    public String investFacade_createInvestOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getBiddingStatusByVoucherNo", desc = "根据凭证号查询投标状态")
    public String investFacade_getBiddingStatusByVoucherNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getInvestmentInfo", desc = "获取用户投资信息")
    public String investFacade_getInvestmentInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getInvestmentProperty", desc = "获取用户投资资产信息")
    public String investFacade_getInvestmentProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getInvestStatusByOrderId", desc = "根据订单号查询投资状态")
    public String investFacade_getInvestStatusByOrderId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getInvestStatusByRequestNo", desc = "根据用户预处理请求流水号查询投资状态(查询非消金投资)")
    public String investFacade_getInvestStatusByRequestNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getMyInvestDetail", desc = "查询我的投资交易详情")
    public String investFacade_getMyInvestDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getNumberOfBidders", desc = "获取标的ID获取该标的已经投资的人数")
    public String investFacade_getNumberOfBidders(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getOfflineOrder", desc = "获取用户海利计划投资记录")
    public String investFacade_getOfflineOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getOfflineProperty", desc = "获取用户海利计划资产信息")
    public String investFacade_getOfflineProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/getUserPurchaseRecordListByHryId", desc = "查询用户所有投资记录信息")
    public String investFacade_getUserPurchaseRecordListByHryId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/investCountStatistics", desc = "根据hryIdList统计用户投资笔数")
    public String investFacade_investCountStatistics(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/investCountStatisticsByHryId", desc = "根据hryId统计单个用户投资笔数")
    public String investFacade_investCountStatisticsByHryId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/noviceCheck", desc = "投标，新手效验")
    public String investFacade_noviceCheck(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryAllPrincipalAndInterestReceived", desc = "根据hryId查询用户全部待收本息")
    public String investFacade_queryAllPrincipalAndInterestReceived(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryInvestByCond", desc = "查询条件查询投资列表（console后台）")
    public String investFacade_queryInvestByCond(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryInvestRecord", desc = "获取我的投资列表信息")
    public String investFacade_queryInvestRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryMyInvest", desc = "查询我的投资列表")
    public String investFacade_queryMyInvest(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryPurchaseCondByHryIdList", desc = "批量查询指定用户的投资情况")
    public String investFacade_queryPurchaseCondByHryIdList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryPurchaseRecordList", desc = "查询投资记录")
    public String investFacade_queryPurchaseRecordList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryRepaymentRecordList", desc = "根据条件查询用户投资还款信息列表")
    public String investFacade_queryRepaymentRecordList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investFacade/queryTotalMoney", desc = "根据条件查询用户投资总金额")
    public String investFacade_queryTotalMoney(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investReservationFacade/addShortMsgBlackList", desc = "添加短信黑名单")
    public String investReservationFacade_addShortMsgBlackList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investReservationFacade/getInvestReservationList", desc = "获取代客理财")
    public String investReservationFacade_getInvestReservationList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investReservationFacade/getShortMsgBlackList", desc = "获取短信黑名单列表")
    public String investReservationFacade_getShortMsgBlackList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/investReservationFacade/removeFromBlackList", desc = "允许短信")
    public String investReservationFacade_removeFromBlackList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/loanByBid", desc = "标的放款")
    public String loanFacade_loanByBid(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/loanByCommand", desc = "单独调用一个命令，慎用")
    public String loanFacade_loanByCommand(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/loanNotify", desc = "异步通知，仅供测试")
    public String loanFacade_loanNotify(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/queryLoanBid", desc = "查询待放款标的信息")
    public String loanFacade_queryLoanBid(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/queryLoanBidDetail", desc = "查询放款标的信息")
    public String loanFacade_queryLoanBidDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/queryLoanOrder", desc = "查询已放款标的信息")
    public String loanFacade_queryLoanOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/queryUserLoanOrders", desc = "查询放款订单")
    public String loanFacade_queryUserLoanOrders(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/resendContractMq", desc = "合同系统MQ重发")
    public String loanFacade_resendContractMq(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/loanFacade/specifyTransfer", desc = "触发指定交易确认")
    public String loanFacade_specifyTransfer(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/messageFacade/messageFacade", desc = "发送消息")
    public String messageFacade_messageFacade(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/addBatchOfflinePlan", desc = "批量添加计划")
    public String offlinePlanFacade_addBatchOfflinePlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/addOfflinePlan", desc = "添加计划")
    public String offlinePlanFacade_addOfflinePlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/getOfflinePlan", desc = "查询计划")
    public String offlinePlanFacade_getOfflinePlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/getOfflinePlanDetail", desc = "WEB-查询产品详情")
    public String offlinePlanFacade_getOfflinePlanDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/getUserInvestOrder", desc = "获取用户投资订单")
    public String offlinePlanFacade_getUserInvestOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/getWhetherInvest", desc = "是否发起投资")
    public String offlinePlanFacade_getWhetherInvest(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/invalidOrder", desc = "作废订单")
    public String offlinePlanFacade_invalidOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/listOfflineIssuerAndConsignee", desc = "获取发行人和承销商信息")
    public String offlinePlanFacade_listOfflineIssuerAndConsignee(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/listOfflineRepayOrder", desc = "获取用户还款订单")
    public String offlinePlanFacade_listOfflineRepayOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/listReleaseOfflinePlan", desc = "WEB-查询上线产品列表")
    public String offlinePlanFacade_listReleaseOfflinePlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/queryInvestByPage", desc = "根据条件分页查询投资记录")
    public String offlinePlanFacade_queryInvestByPage(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/queryOfflinePlan", desc = "分页查询计划")
    public String offlinePlanFacade_queryOfflinePlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/resetOfflineRepayOrder", desc = "重置还款订单")
    public String offlinePlanFacade_resetOfflineRepayOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/setOnOffOfOfflinePlan", desc = "设置线下理财上下线")
    public String offlinePlanFacade_setOnOffOfOfflinePlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/updateOfflinePlan", desc = "修改计划")
    public String offlinePlanFacade_updateOfflinePlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/updateUserInvestOrder", desc = "修改用户投资订单")
    public String offlinePlanFacade_updateUserInvestOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/userInvest", desc = "后台-用户预约")
    public String offlinePlanFacade_userInvest(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/offlinePlanFacade/userReservation", desc = "WEB-用户预约")
    public String offlinePlanFacade_userReservation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/orderFacade/exportPurchaseRecord", desc = "导出查询投资记录")
    public String orderFacade_exportPurchaseRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/orderFacade/getRealTimePurchaseRecord", desc = "获取首页实时理财信息")
    public String orderFacade_getRealTimePurchaseRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/orderFacade/getRepaymentStatusByOrderIdList", desc = "批量查询订单还款状态")
    public String orderFacade_getRepaymentStatusByOrderIdList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/orderFacade/queryPurchaseRecord", desc = "查询投资记录")
    public String orderFacade_queryPurchaseRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/orderFacade/queryPurchaseRecordDetail", desc = "根据投标记录查询标的信息")
    public String orderFacade_queryPurchaseRecordDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/platformMarkingFacade/addAlterNativeRecharge", desc = "新增页面获取用户ID")
    public String platformMarkingFacade_addAlterNativeRecharge(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/platformMarkingFacade/creatPlatformMarking", desc = "平台营销")
    public String platformMarkingFacade_creatPlatformMarking(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/platformMarkingFacade/queryAlterNativeList", desc = "查询代充值列表")
    public String platformMarkingFacade_queryAlterNativeList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/platformMarkingFacade/selectUserInfo", desc = "查询用户信息")
    public String platformMarkingFacade_selectUserInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/productFacade/generateBatchProduct", desc = "批量发标")
    public String productFacade_generateBatchProduct(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/productFacade/generateProduct", desc = "发标接口")
    public String productFacade_generateProduct(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/productFacade/getBatchReleaseLog", desc = "批量发标记录查询")
    public String productFacade_getBatchReleaseLog(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/productFacade/queryEntrustPayOrder", desc = "【console】查询委托支付授权订单")
    public String productFacade_queryEntrustPayOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/productFacade/queryProductByCreditId", desc = "确认发标是否成功")
    public String productFacade_queryProductByCreditId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/getMyAssetByTransferOfDebt", desc = "获取我的债转投资资产信息")
    public String queryTransferOfDebtFacade_getMyAssetByTransferOfDebt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/getRepaymentDetail", desc = "获取回款债转详情")
    public String queryTransferOfDebtFacade_getRepaymentDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/listMyTransferOfDebt", desc = "获取我的债转投资列表信息")
    public String queryTransferOfDebtFacade_listMyTransferOfDebt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/queryTransferOfDebtFacade/listRepaymentDetails", desc = "获取回款债转列表")
    public String queryTransferOfDebtFacade_listRepaymentDetails(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/createAdjustAccountOrder", desc = "创建调账订单")
    public String rechargeAndWithdrawFacade_createAdjustAccountOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/createRechargeOrder", desc = "充值")
    public String rechargeAndWithdrawFacade_createRechargeOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/createWithdrawOrder", desc = "提现")
    public String rechargeAndWithdrawFacade_createWithdrawOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/directRecharge", desc = "自动充值")
    public String rechargeAndWithdrawFacade_directRecharge(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/directWithdraw", desc = "自动提现")
    public String rechargeAndWithdrawFacade_directWithdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryAdjustAccountOrder", desc = "查询调账订单")
    public String rechargeAndWithdrawFacade_queryAdjustAccountOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryRechargeList", desc = "【console】查询充值订单列表")
    public String rechargeAndWithdrawFacade_queryRechargeList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryRechargeRecord", desc = "前端查询充值交易记录")
    public String rechargeAndWithdrawFacade_queryRechargeRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryRechargeRecordDetail", desc = "前端查询充值交易记录详情")
    public String rechargeAndWithdrawFacade_queryRechargeRecordDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryWithdrawList", desc = "【console】查询所有用户提现列表")
    public String rechargeAndWithdrawFacade_queryWithdrawList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryWithdrawRecord", desc = "前端查询用户提现订单")
    public String rechargeAndWithdrawFacade_queryWithdrawRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/queryWithdrawRecordDetail", desc = "前端查询提现交易详情")
    public String rechargeAndWithdrawFacade_queryWithdrawRecordDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/sumWithdrawPending", desc = "查询提现中的总金额")
    public String rechargeAndWithdrawFacade_sumWithdrawPending(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/reconFacade/queryBackrollReconciliation", desc = "查询资金回退充值订单对账信息")
    public String reconFacade_queryBackrollReconciliation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/reconFacade/queryCommissionInfo", desc = "查询佣金对账信息")
    public String reconFacade_queryCommissionInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/reconFacade/queryRechargeReconciliation", desc = "查询充值订单对账信息")
    public String reconFacade_queryRechargeReconciliation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/reconFacade/queryReconInfo", desc = "查询交易对账信息")
    public String reconFacade_queryReconInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/reconFacade/queryWithdrawReconciliation", desc = "查询提现充值订单对账信息")
    public String reconFacade_queryWithdrawReconciliation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/regionFacade/getSubRegion", desc = "根据ID查询上级地区信息")
    public String regionFacade_getSubRegion(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/regionFacade/regionInfo", desc = "查询地区信息接口")
    public String regionFacade_regionInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/financierRepayment", desc = "融资人还款")
    public String repaymentFacade_financierRepayment(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/financierRepaymentWithExinterest", desc = "融资人还款(无息)。场景：募集成功、放款后，借款人又不借了。")
    public String repaymentFacade_financierRepaymentWithExinterest(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/financierStatistics", desc = "融资统计")
    public String repaymentFacade_financierStatistics(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/getBidHkjh", desc = "查询标的标还款记录(标的应还款信息查询接口)")
    public String repaymentFacade_getBidHkjh(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/getFinancierRepaymentOrder", desc = "查询融资人还款记录 详情")
    public String repaymentFacade_getFinancierRepaymentOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/getInvestorRepaymentDetail", desc = "查询投资人收款明细详情")
    public String repaymentFacade_getInvestorRepaymentDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/getRepayingDetail", desc = "查询最近一期还款详情")
    public String repaymentFacade_getRepayingDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/getReserveRepaymentDetail", desc = "查询投资人-预约回款详情")
    public String repaymentFacade_getReserveRepaymentDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/listFinancierRepaymentOrders", desc = "查询融资人还款记录")
    public String repaymentFacade_listFinancierRepaymentOrders(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/listFinancierRepaymentOrdersConsole", desc = "查询融资人还款记录（console使用）")
    public String repaymentFacade_listFinancierRepaymentOrdersConsole(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/listFinancierRepaymentPlans", desc = "查询标的还款明细")
    public String repaymentFacade_listFinancierRepaymentPlans(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/listInvestorRepaymentDetails", desc = "查询投资人收款明细")
    public String repaymentFacade_listInvestorRepaymentDetails(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/listInvestorRepaymentDetailsConsole", desc = "查询投资人收款明细（Console使用）")
    public String repaymentFacade_listInvestorRepaymentDetailsConsole(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/prepayment", desc = "融资人提前还款")
    public String repaymentFacade_prepayment(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/prepaymentApplication", desc = "提前还款申请与审核")
    public String repaymentFacade_prepaymentApplication(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryBiddersHkjh", desc = "查询用户投标还款计划信息")
    public String repaymentFacade_queryBiddersHkjh(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryCfBiddingOrderHkjh", desc = "查询用户预约标的还款计划信息")
    public String repaymentFacade_queryCfBiddingOrderHkjh(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryExistsPrepaymentPlan", desc = "查询已经提前还款的计划详情")
    public String repaymentFacade_queryExistsPrepaymentPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryPerfectHkjh", desc = "查询标的还款计划")
    public String repaymentFacade_queryPerfectHkjh(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryPrepaymentApplication", desc = "查询提前还款标的信息")
    public String repaymentFacade_queryPrepaymentApplication(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryPrepaymentPlan", desc = "查询提前还款计划")
    public String repaymentFacade_queryPrepaymentPlan(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryRepayingBids", desc = "查询还款中标的")
    public String repaymentFacade_queryRepayingBids(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryRepaymentBids", desc = "融资查询")
    public String repaymentFacade_queryRepaymentBids(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryRepaymentDetail", desc = "【console】查询标的还款、代偿详情")
    public String repaymentFacade_queryRepaymentDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryRepaymentList", desc = "【console】查询标的还款、代偿列表")
    public String repaymentFacade_queryRepaymentList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryReserveRepaymentDetails", desc = "查询投资人-预约回款列表")
    public String repaymentFacade_queryReserveRepaymentDetails(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/querySettledBids", desc = "查询已结清标的")
    public String repaymentFacade_querySettledBids(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/queryUnpaidBidDetail", desc = "【console】查询待还款标的详情")
    public String repaymentFacade_queryUnpaidBidDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/rebuildInvestorRepaymentDetailsConsole", desc = "重发失败的还款确认明细（Console使用）")
    public String repaymentFacade_rebuildInvestorRepaymentDetailsConsole(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/repaymentFacade/reserveRepayment", desc = "预约还款")
    public String repaymentFacade_reserveRepayment(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/stockPrepaymentApplyFacade/applyStockPrepayment", desc = "存量数据申请提前还款")
    public String stockPrepaymentApplyFacade_applyStockPrepayment(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/stockPrepaymentApplyFacade/listStockPrepayment", desc = "根据条件查询存量提前还款列表")
    public String stockPrepaymentApplyFacade_listStockPrepayment(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/stockPrepaymentApplyFacade/listStockPrepaymentByIds", desc = "根据条件查询存量提前还款列表")
    public String stockPrepaymentApplyFacade_listStockPrepaymentByIds(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addBatchEnclosure", desc = "新增批量附件")
    public String tenderFacade_addBatchEnclosure(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addBidExtraInfo", desc = "新增标的附加信息")
    public String tenderFacade_addBidExtraInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addBidLabel", desc = "新增标的的标签")
    public String tenderFacade_addBidLabel(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addCarBidDetail", desc = "保存车抵押表抵押物信息")
    public String tenderFacade_addCarBidDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addCarBidDetailList", desc = "保存车抵押表抵押物列表信息")
    public String tenderFacade_addCarBidDetailList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addEnclosure", desc = "新增附件")
    public String tenderFacade_addEnclosure(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addExchangeInfo", desc = "增加交易所信息")
    public String tenderFacade_addExchangeInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addLabelInfo", desc = "增加标签")
    public String tenderFacade_addLabelInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/addTenderBidInfo", desc = "保存标的信息接口")
    public String tenderFacade_addTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/agreeTenderBidInfo", desc = "审核同意标的信息接口")
    public String tenderFacade_agreeTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/checkReleaseQueueBidValiad", desc = "校验发布队列标的有效性")
    public String tenderFacade_checkReleaseQueueBidValiad(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/createAccountsPayableDetail", desc = "增加融租债转账款信息")
    public String tenderFacade_createAccountsPayableDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/createBidToCopy", desc = "根据当前标的复制创建新标的")
    public String tenderFacade_createBidToCopy(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/deleteAccountsPayableDetail", desc = "删除融租债转账款信息")
    public String tenderFacade_deleteAccountsPayableDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/deleteAccountsPayableDetailList", desc = "删除融租债转账款信息(根据标的ID)")
    public String tenderFacade_deleteAccountsPayableDetailList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/deleteBidLabel", desc = "删除标的的标签")
    public String tenderFacade_deleteBidLabel(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/deleteCarBidDetail", desc = "删除车抵押表抵押物信息")
    public String tenderFacade_deleteCarBidDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/deleteEnclosure", desc = "删除附件")
    public String tenderFacade_deleteEnclosure(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/deleteLabelInfo", desc = "删除标签")
    public String tenderFacade_deleteLabelInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/disagreeTenderBidInfo", desc = "审核不同意标的信息接口")
    public String tenderFacade_disagreeTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/discardTenderBidInfo", desc = "作废标的信息接口")
    public String tenderFacade_discardTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getBidExtraInfo", desc = "查询标的附加信息")
    public String tenderFacade_getBidExtraInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getCarBidDetails", desc = "查询车抵押表抵押物信息")
    public String tenderFacade_getCarBidDetails(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getCbpLoanInfoByLoanId", desc = "查询信贷信息")
    public String tenderFacade_getCbpLoanInfoByLoanId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getEnclosure", desc = "查询附件")
    public String tenderFacade_getEnclosure(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getEnclosureTypes", desc = "查询附件类型")
    public String tenderFacade_getEnclosureTypes(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getExchangeInfoByBidId", desc = "根据标的ID获取交易所信息")
    public String tenderFacade_getExchangeInfoByBidId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getExchangeInfoById", desc = "根据交易所ID获取交易所信息")
    public String tenderFacade_getExchangeInfoById(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getLabelInfos", desc = "查询标签")
    public String tenderFacade_getLabelInfos(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getLabelInfosByBid", desc = "查询标的标签")
    public String tenderFacade_getLabelInfosByBid(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getRepayPlanPage", desc = "后台查询还款计划（分页）")
    public String tenderFacade_getRepayPlanPage(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getTenderBidInfo", desc = "发标后台标的详情接口")
    public String tenderFacade_getTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getTenderBidList", desc = "发标后台列表接口")
    public String tenderFacade_getTenderBidList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/getUserLogDetailPageInfo", desc = "获取用户日志分页信息")
    public String tenderFacade_getUserLogDetailPageInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/miscarryBid", desc = "指定待放款的标的流标")
    public String tenderFacade_miscarryBid(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/preReleaseTenderBidInfo", desc = "预发布标的信息接口")
    public String tenderFacade_preReleaseTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/queryAccountsPayableDetail", desc = "查询融租债转账款信息")
    public String tenderFacade_queryAccountsPayableDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/queryAllExchangeInfo", desc = "获取全部交易所信息")
    public String tenderFacade_queryAllExchangeInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/queryBidCheckList", desc = "查询标的审核信息")
    public String tenderFacade_queryBidCheckList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/queryBidListByQueueId", desc = "根据标的发布队列查询标的列表信息")
    public String tenderFacade_queryBidListByQueueId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/queryBidReleaseQueueByCond", desc = "根据条件查询标的发布队列")
    public String tenderFacade_queryBidReleaseQueueByCond(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/releaseTenderBidInfo", desc = "发布标的信息接口")
    public String tenderFacade_releaseTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/saveBidReleaseQueue", desc = "新增标的发布队列")
    public String tenderFacade_saveBidReleaseQueue(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/settingScheduleReleaseTime", desc = "设置标的定时发布时间")
    public String tenderFacade_settingScheduleReleaseTime(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/submitBidInfo", desc = "提交标的信息")
    public String tenderFacade_submitBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/updateAccountsPayableDetail", desc = "更新融租债转账款信息")
    public String tenderFacade_updateAccountsPayableDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/updateBidExtraInfo", desc = "更新标的附加信息")
    public String tenderFacade_updateBidExtraInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/updateBidReleaseQueue", desc = "修改标的发布队列")
    public String tenderFacade_updateBidReleaseQueue(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/updateCarBidDetail", desc = "更新车抵押表抵押物信息")
    public String tenderFacade_updateCarBidDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/updateExchangeInfo", desc = "更新交易所信息")
    public String tenderFacade_updateExchangeInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/updateLabel", desc = "更新标签")
    public String tenderFacade_updateLabel(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/tenderFacade/updateTenderBidInfo", desc = "更新标的信息")
    public String tenderFacade_updateTenderBidInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/yyTradeStatFacade/annualInvestmentAmount", desc = "根据投资时间和海融易id,查询该时间段内的年化投资总额")
    public String yyTradeStatFacade_annualInvestmentAmount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/yyTradeStatFacade/getInvestmentTotalAmount", desc = "根据投资时间和ID，查询用户该时间段内的投资金额")
    public String yyTradeStatFacade_getInvestmentTotalAmount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/yyTradeStatFacade/loanCalculate", desc = "贷款/收益计算器")
    public String yyTradeStatFacade_loanCalculate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/yyTradeStatFacade/queryBidOrderByBidRecordId", desc = "根据投资记录号（bidRecordId）查询投资订单")
    public String yyTradeStatFacade_queryBidOrderByBidRecordId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/yyTradeStatFacade/queryBidOrderByOrderId", desc = "根据投资订单号（orderId）查询投资订单）")
    public String yyTradeStatFacade_queryBidOrderByOrderId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/yyTradeStatFacade/totalInvestmentAmount", desc = "根据投资时间和海融易id,查询这段时间内的投资总金额")
    public String yyTradeStatFacade_totalInvestmentAmount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }

    @Uri(value = "/yyTradeStatFacade/twoAnniversary", desc = "根据投资时间和ID，查询用户该时间段内的投资金额(只包含标的期限30天以上)")
    public String yyTradeStatFacade_twoAnniversary(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params, this);
    }
}
