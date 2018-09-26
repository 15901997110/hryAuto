package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.CbpBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: CbpDefaultTest
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@Slf4j
public class CbpDefaultTest extends CbpBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    public CbpDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }
    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/createCfPrepay", dataProvider = "provider", description = "消金直融，线上直融提前还款申请")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfPrepay(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfPrepay(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/createCfRefund", dataProvider = "provider", description = "消金直融，线上直融退货申请")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfRefund(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfRefund(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfPrepay", dataProvider = "provider", description = "线上直融提前还款资金查询")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepay(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepay(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfPrepayResult", dataProvider = "provider", description = "消金直融，线上直融提前还款结果查询")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepayResult(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepayResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfRefund", dataProvider = "provider", description = "消金直融，线上直融退货资金查询")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefund(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefund(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfRefundResult", dataProvider = "provider", description = "消金直融，线上直融退货结果查询")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefundResult(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefundResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/cfLoanFk", dataProvider = "provider", description = "消金放款")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_cfLoanFk(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_cfLoanFk(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfCarLoan", dataProvider = "provider", description = "车贷借款申请")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfCarLoan(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfCarLoan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfLoan", dataProvider = "provider", description = "消金借款申请")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfLoan(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfLoan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfXszrLoan", dataProvider = "provider", description = "消金直融，线上直融借款申请")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfXszrLoan(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfXszrLoan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/getContractFile", dataProvider = "provider", description = "消金代签借款合同文件获取")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_getContractFile(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_getContractFile(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfLoan", dataProvider = "provider", description = "消金借款查询")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfLoan(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfLoan(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfResidualBookAmount", dataProvider = "provider", description = "车贷剩余可借款金额查询")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfResidualBookAmount(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfResidualBookAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfXszrLoan", dataProvider = "provider", description = "消金直融，线上直融借款查询")
    public void cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfXszrLoan(HryTest hryTest) {
        String actual = super._cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfXszrLoan(hryTest);
        supperAssert(actual, hryTest);
    }

}
