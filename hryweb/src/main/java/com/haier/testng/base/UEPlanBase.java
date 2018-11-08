package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: UEPlanBase
 * @Author: 自动生成
 * @Date: 2018/11/08 18:13:29
 */
@SKey("UEPlan")
public class UEPlanBase extends Base {
    public UEPlanBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/p2pToUePlanFacade/getUeAuthOrderInfo", desc = "获取Ue系统授权订单信息")
    public String _p2pToUePlanFacade_getUeAuthOrderInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/p2pToUePlanFacade/getUeProductInfo", desc = "获取优易智投产品详情")
    public String _p2pToUePlanFacade_getUeProductInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/p2pToUePlanFacade/getUeProductRealStatistics", desc = "优易智投实时募集统计")
    public String _p2pToUePlanFacade_getUeProductRealStatistics(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/UeCbpFrontFacade/queryUeProductList", desc = "优易智投产品编号查询接口")
    public String _UeCbpFrontFacade_queryUeProductList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/UeCbpFrontFacade/registerUeProductAmount", desc = "优易智投金额登记接口")
    public String _UeCbpFrontFacade_registerUeProductAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/UeCbpFrontFacade/sumToBeMatchAmount", desc = "获取优易智投待匹配总金额")
    public String _UeCbpFrontFacade_sumToBeMatchAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanAuthInvestFacade/userAuthInvest", desc = "用户授权投资")
    public String _uePlanAuthInvestFacade_userAuthInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanAuthInvestFacade/userCancelAuthInvest", desc = "用户取消授权投资")
    public String _uePlanAuthInvestFacade_userCancelAuthInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/addUeProduct", desc = "新增优易智投产品配置，供后台使用")
    public String _uePlanConsoleFacade_addUeProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/disableUeProduct", desc = "停用优易智投产品")
    public String _uePlanConsoleFacade_disableUeProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/enableUeProduct", desc = "启用优易智投产品")
    public String _uePlanConsoleFacade_enableUeProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/getUeBidInfo", desc = "查看优易智投标的详细信息")
    public String _uePlanConsoleFacade_getUeBidInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/getUeProductConfig", desc = "查看优易智投服务配置信息")
    public String _uePlanConsoleFacade_getUeProductConfig(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/queryUeAuthOrderList", desc = "查询授权订单信息列表")
    public String _uePlanConsoleFacade_queryUeAuthOrderList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/queryUeBidList", desc = "查询优易智投标的信息列表")
    public String _uePlanConsoleFacade_queryUeBidList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/queryUeCancelOrderList", desc = "查询撤销订单信息列表")
    public String _uePlanConsoleFacade_queryUeCancelOrderList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/queryUeMatchAndCancelOrderList", desc = "查看授权订单匹配(撤销)的标的信息")
    public String _uePlanConsoleFacade_queryUeMatchAndCancelOrderList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/queryUeProductConfigList", desc = "查询优易智投服务配置信息列表")
    public String _uePlanConsoleFacade_queryUeProductConfigList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/queryUeProductDailyAmountList", desc = "查看优易智投产品日需求金额列表")
    public String _uePlanConsoleFacade_queryUeProductDailyAmountList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/queryUeProductItemList", desc = "查询优易智投产品每日汇总信息列表")
    public String _uePlanConsoleFacade_queryUeProductItemList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanConsoleFacade/updateUeProduct", desc = "修改优易智投产品配置")
    public String _uePlanConsoleFacade_updateUeProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/getMyUeAuthOrder", desc = "获取我的优易智投详情")
    public String _uePlanFrontFacade_getMyUeAuthOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/getUeInvestRecord", desc = "获取优易智投用户投资记录")
    public String _uePlanFrontFacade_getUeInvestRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/getUeInvestRecordDetail", desc = "交易记录 - 出借记录详情")
    public String _uePlanFrontFacade_getUeInvestRecordDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/getUeProductDetail", desc = "优易智投服务列表 - 获取优易智投详情")
    public String _uePlanFrontFacade_getUeProductDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/listMyCancelUeAuthOrder", desc = "历史记录 - 获取我的优易撤销记录")
    public String _uePlanFrontFacade_listMyCancelUeAuthOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/listMySettledUeAuthOrder", desc = "历史记录 - 获取我的优易智投结清记录")
    public String _uePlanFrontFacade_listMySettledUeAuthOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/listMyUeInvest", desc = "我的出借 - 优易智投列表")
    public String _uePlanFrontFacade_listMyUeInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/listUeAuthOrderContract", desc = "根据授权订单号查询该订单的合同")
    public String _uePlanFrontFacade_listUeAuthOrderContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/listUeInvestRecord", desc = "交易记录 - 出借记录列表")
    public String _uePlanFrontFacade_listUeInvestRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/listUeProduct", desc = "首页AND列表 - 获取优易智投服务列表")
    public String _uePlanFrontFacade_listUeProduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/queryAvailablePlanByCoupon", desc = "根据条件查询可用的券信息")
    public String _uePlanFrontFacade_queryAvailablePlanByCoupon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/uePlanFrontFacade/queryAvailablePlanByLcj", desc = "根据条件查询可用的理财金信息")
    public String _uePlanFrontFacade_queryAvailablePlanByLcj(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
