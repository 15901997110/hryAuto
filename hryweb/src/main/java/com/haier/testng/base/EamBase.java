package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: EamBase
 * @Author: 自动生成
 * @Date: 2018/09/11 10:34:39
 */
@SKey("Eam")
public class EamBase extends Base {
    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/abolishAss", desc = "废弃一笔资产")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_abolishAss(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssets", desc = "新增一笔资产信息")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssets(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssIncomeAdjust", desc = "资产收益调整")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssIncomeAdjust(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssInvest", desc = "新增资产并和标的关联")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssOrg", desc = "新增机构资产和标的")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssOrg(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssrepay", desc = "信贷资产回款")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssrepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssRepayPlan", desc = "新增资产还款计划")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssRepayPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addRenewAssets", desc = "资产续借接口")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addRenewAssets(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/queryAssets", desc = "查询单条资产信息")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_queryAssets(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssAmount", desc = "资产金额调整")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssets", desc = "资产修改接口")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssets(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssExtend", desc = "资产展期调整")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssExtend(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssRepayPlan", desc = "更新资产还款计划")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssRepayPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssValue", desc = "更新资产起息日")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssValue(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.BasicInfoResource/addBD", desc = "新增资产BD")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addBD(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.BasicInfoResource/addCompany", desc = "新增资产相关方")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addCompany(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.BasicInfoResource/addInsCostManage", desc = "新增机构费用管理")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addInsCostManage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/addAssfinance", desc = "线上融资(标的发布/废弃)")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_addAssfinance(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/addOffinvest", desc = "新增线下投资")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_addOffinvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/investRepay", desc = "标的还款")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_investRepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/offinvestRepay", desc = "线下投资还款")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_offinvestRepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/onlineLending", desc = "线上放款")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_onlineLending(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/queryPreInvests", desc = "预发标查询")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_queryPreInvests(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/updPreInvest", desc = "预发标更新")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_updPreInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.ListedInvestResource/queryRegion", desc = "查询区域信息")
    public String _eam_api_resource_com_haier_eam_biz_resource_rs_facade_ListedInvestResource_queryRegion(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
