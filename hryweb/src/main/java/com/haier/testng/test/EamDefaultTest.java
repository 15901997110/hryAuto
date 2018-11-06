package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.EamBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: EamDefaultTest
 * @Author: 自动生成
 * @Date: 2018/11/06 16:53:31
 */
@Slf4j
public class EamDefaultTest extends EamBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public EamDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/abolishAss", dataProvider = "provider", description = "废弃一笔资产")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_abolishAss(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_abolishAss(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssets", dataProvider = "provider", description = "新增一笔资产信息")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssets(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssets(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssIncomeAdjust", dataProvider = "provider", description = "资产收益调整")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssIncomeAdjust(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssIncomeAdjust(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssInvest", dataProvider = "provider", description = "新增资产并和标的关联")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssInvest(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssOrg", dataProvider = "provider", description = "新增机构资产和标的")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssOrg(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssOrg(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssrepay", dataProvider = "provider", description = "信贷资产回款")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssrepay(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssrepay(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addAssRepayPlan", dataProvider = "provider", description = "新增资产还款计划")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssRepayPlan(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addAssRepayPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/addRenewAssets", dataProvider = "provider", description = "资产续借接口")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addRenewAssets(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_addRenewAssets(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/queryAssets", dataProvider = "provider", description = "查询单条资产信息")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_queryAssets(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_queryAssets(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssAmount", dataProvider = "provider", description = "资产金额调整")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssAmount(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssets", dataProvider = "provider", description = "资产修改接口")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssets(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssets(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssExtend", dataProvider = "provider", description = "资产展期调整")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssExtend(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssExtend(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssRepayPlan", dataProvider = "provider", description = "更新资产还款计划")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssRepayPlan(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssRepayPlan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.AssetsResource/updAssValue", dataProvider = "provider", description = "更新资产起息日")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssValue(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_AssetsResource_updAssValue(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.BasicInfoResource/addBD", dataProvider = "provider", description = "新增资产BD")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addBD(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addBD(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.BasicInfoResource/addCompany", dataProvider = "provider", description = "新增资产相关方")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addCompany(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addCompany(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.BasicInfoResource/addInsCostManage", dataProvider = "provider", description = "新增机构费用管理")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addInsCostManage(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_BasicInfoResource_addInsCostManage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/addAssfinance", dataProvider = "provider", description = "线上融资(标的发布/废弃)")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_addAssfinance(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_addAssfinance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/addOffinvest", dataProvider = "provider", description = "新增线下投资")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_addOffinvest(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_addOffinvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/investRepay", dataProvider = "provider", description = "标的还款")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_investRepay(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_investRepay(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/offinvestRepay", dataProvider = "provider", description = "线下投资还款")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_offinvestRepay(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_offinvestRepay(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/onlineLending", dataProvider = "provider", description = "线上放款")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_onlineLending(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_onlineLending(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/queryPreInvests", dataProvider = "provider", description = "预发标查询")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_queryPreInvests(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_queryPreInvests(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.InvestResource/updPreInvest", dataProvider = "provider", description = "预发标更新")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_updPreInvest(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_InvestResource_updPreInvest(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/eam-api/resource/com.haier.eam.biz.resource.rs.facade.ListedInvestResource/queryRegion", dataProvider = "provider", description = "查询区域信息")
    public void eam_api_resource_com_haier_eam_biz_resource_rs_facade_ListedInvestResource_queryRegion(HryTest hryTest) {
        String actual = super._eam_api_resource_com_haier_eam_biz_resource_rs_facade_ListedInvestResource_queryRegion(hryTest);
        supperAssert(actual, hryTest);
    }

}
