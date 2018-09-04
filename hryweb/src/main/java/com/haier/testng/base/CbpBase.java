package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: CbpBase
 * @Author: 自动生成
 * @Date: 2018/09/03 20:54:08
 */
@SKey("Cbp")
public class CbpBase extends Base {
    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/createCfPrepay", desc = "消金直融，线上直融提前还款申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfPrepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/createCfRefund", desc = "消金直融，线上直融退货申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_createCfRefund(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfPrepay", desc = "线上直融提前还款资金查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfPrepayResult", desc = "消金直融，线上直融提前还款结果查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfPrepayResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfRefund", desc = "消金直融，线上直融退货资金查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefund(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanPrepayResource/queryCfRefundResult", desc = "消金直融，线上直融退货结果查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanPrepayResource_queryCfRefundResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/cfLoanFk", desc = "消金放款")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_cfLoanFk(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfCarLoan", desc = "车贷借款申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfCarLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfLoan", desc = "消金借款申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/createCfXszrLoan", desc = "消金直融，线上直融借款申请")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_createCfXszrLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/getContractByState", desc = "消金直融，线上直融代签借款合同文件获取")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_getContractByState(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfLoan", desc = "消金借款查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfResidualBookAmount", desc = "车贷剩余可借款金额查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfResidualBookAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-api/resource/com.cbp.biz.cfLoan.facade.rs.CfLoanResource/queryCfXszrLoan", desc = "消金直融，线上直融借款查询")
    public String _cbp_api_resource_com_cbp_biz_cfLoan_facade_rs_CfLoanResource_queryCfXszrLoan(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
