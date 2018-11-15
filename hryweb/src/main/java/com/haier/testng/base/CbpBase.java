package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: CbpBase
 * @Author: 自动生成
 * @Date: 2018/11/12 14:21:00
 */
@SKey("Cbp")
public class CbpBase extends Base {
    public CbpBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/createCfPrepay", desc = "2.3.2-P0010提前还款申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfPrepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/createCfRefund", desc = "2.3.5-P0010退货申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfRefund(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfPrepay", desc = "2.3.1-P0010提前还款资金查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfPrepayResult", desc = "2.3.3-P0010提前还款结果查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepayResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfRefund", desc = "2.3.4-P0010退货资金查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefund(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfRefundResult", desc = "2.3.6-P0010退货结果查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefundResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanRepayResource/cfReclaim", desc = "2.2.5-P0010代偿收回")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanRepayResource_cfReclaim(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanRepayResource/cfRepay", desc = "2.2.3-P0010还款")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanRepayResource_cfRepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanRepayResource/pushCfRepayPlan", desc = "2.2.1-P0010还款计划推送")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanRepayResource_pushCfRepayPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanRepayResource/queryCfRepayPlan", desc = "2.2.6-P0010还款计划查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanRepayResource_queryCfRepayPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanRepayResource/queryCfRepayResult", desc = "2.2.4-P0010还款结果查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanRepayResource_queryCfRepayResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanRepayResource/updateCfRepayPlan", desc = "2.2.2-P0010还款计划更新")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanRepayResource_updateCfRepayPlan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/cfLoanFk", desc = "2.1.3-P0010线上直融放款")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_cfLoanFk(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfLoan", desc = "2.1.1-P0007消金借款申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfXszrLoan", desc = "2.1.1-P0010线上直融借款申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfXszrLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/getCfChannel", desc = "2.1.0-P0007消金渠道获取")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_getCfChannel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/getContractFile", desc = "2.1.4-P0010线上直融代签借款合同文件获取")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_getContractFile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfLoan", desc = "2.1.2-P0007消金借款查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfResidualBookAmount", desc = "2.1.5-P0007消金剩余可借款金额查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfResidualBookAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfXszrLoan", desc = "2.1.2-P0010线上直融借款查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfXszrLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
