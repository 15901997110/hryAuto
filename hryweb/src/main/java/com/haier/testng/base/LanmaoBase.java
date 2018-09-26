package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: LanmaoBase
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@SKey("Lanmao")
public class LanmaoBase extends Base {
    public LanmaoBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }
    @Uri(value = "/accountFacade/accountRecharge", desc = "调账充值接口:一键从天天聚迁移至存管余额使用")
    public String _accountFacade_accountRecharge(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/activateStockedUser", desc = "会员激活")
    public String _accountFacade_activateStockedUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/auditBindCard", desc = "换卡审核")
    public String _accountFacade_auditBindCard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/bindCardGeneral", desc = "个人和企业直连换卡")
    public String _accountFacade_bindCardGeneral(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/checkPassword", desc = "校验密码")
    public String _accountFacade_checkPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/enterpriseBindBankcard", desc = "企业换绑卡")
    public String _accountFacade_enterpriseBindBankcard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/enterpriseEntrustImportUser", desc = "企业委托开户")
    public String _accountFacade_enterpriseEntrustImportUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/enterpriseInformationUpdate", desc = "企业信息变更")
    public String _accountFacade_enterpriseInformationUpdate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/enterpriseRegister", desc = "企业绑卡注册")
    public String _accountFacade_enterpriseRegister(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/entrustImportUser", desc = "个人委托开户")
    public String _accountFacade_entrustImportUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/modifyMobileExpand", desc = "预留手机号更新")
    public String _accountFacade_modifyMobileExpand(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/personalBindBankcardExpand", desc = "个人换绑卡")
    public String _accountFacade_personalBindBankcardExpand(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/personalRegister", desc = "个人绑卡注册")
    public String _accountFacade_personalRegister(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/resetPassword", desc = "修改密码")
    public String _accountFacade_resetPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/unBindBankcard", desc = "解绑银行卡")
    public String _accountFacade_unBindBankcard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/gatewayFacade/notify", desc = "异步回调")
    public String _gatewayFacade_notify(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoReconFacade/download", desc = "获取恒丰原始对账文件")
    public String _lanmaoReconFacade_download(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoReconFacade/manualRecon", desc = "手工对账接口")
    public String _lanmaoReconFacade_manualRecon(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoReconFacade/queryReconInfo", desc = "查询交易对账汇总结果信息")
    public String _lanmaoReconFacade_queryReconInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoReconFacade/queryReconStatusDetail", desc = "查询具体类型的对账状态详情")
    public String _lanmaoReconFacade_queryReconStatusDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryAuthorizationEntrustPayRecord", desc = "委托支付授权记录查询")
    public String _queryFacade_queryAuthorizationEntrustPayRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryCancelTransactionSale", desc = "查询取消预处理")
    public String _queryFacade_queryCancelTransactionSale(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryDebentureSale", desc = "债权出让查询")
    public String _queryFacade_queryDebentureSale(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryGeneralFreeze", desc = "通用冻结查询")
    public String _queryFacade_queryGeneralFreeze(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryInterceptWithdraw", desc = "查询提现拦截")
    public String _queryFacade_queryInterceptWithdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryPreTransaction", desc = "交易预处理查询")
    public String _queryFacade_queryPreTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryProjectInformation", desc = "标的信息查询")
    public String _queryFacade_queryProjectInformation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryRechargeTransaction", desc = "充值交易查询")
    public String _queryFacade_queryRechargeTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryTransactionConfirmation", desc = "交易确认查询")
    public String _queryFacade_queryTransactionConfirmation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryTransactionFreeze", desc = "冻结交易查询")
    public String _queryFacade_queryTransactionFreeze(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryTransactionUnfreeze", desc = "解冻交易查询")
    public String _queryFacade_queryTransactionUnfreeze(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryUpdateBankcardAuditDetail", desc = "查询换卡记录")
    public String _queryFacade_queryUpdateBankcardAuditDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryUserInformation", desc = "用户信息查询")
    public String _queryFacade_queryUserInformation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/queryFacade/queryWithdrawTransaction", desc = "提现交易查询")
    public String _queryFacade_queryWithdrawTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/autoWithdraw", desc = "自动提现")
    public String _rechargeAndWithdrawFacade_autoWithdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/cancelWithdraw", desc = "取消提现")
    public String _rechargeAndWithdrawFacade_cancelWithdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/confirmWithdraw", desc = "提现确认")
    public String _rechargeAndWithdrawFacade_confirmWithdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/directRecharge", desc = "自动充值")
    public String _rechargeAndWithdrawFacade_directRecharge(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/interceptWithdraw", desc = "提现拦截")
    public String _rechargeAndWithdrawFacade_interceptWithdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/recharge", desc = "充值")
    public String _rechargeAndWithdrawFacade_recharge(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/rechargeFundsTransfer", desc = "打款划拨充值")
    public String _rechargeAndWithdrawFacade_rechargeFundsTransfer(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/withdraw", desc = "提现")
    public String _rechargeAndWithdrawFacade_withdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/asyncTransaction", desc = "批量交易")
    public String _tradeFacade_asyncTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/authorizationEntrustPay", desc = "委托支付授权")
    public String _tradeFacade_authorizationEntrustPay(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/cancelDebentureSale", desc = "取消债权出让")
    public String _tradeFacade_cancelDebentureSale(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/cancelPreTransaction", desc = "预处理取消")
    public String _tradeFacade_cancelPreTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/cancelUserAuthorization", desc = "取消用户授权")
    public String _tradeFacade_cancelUserAuthorization(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/confirmCheckfile", desc = "强制对账文件确认，慎用")
    public String _tradeFacade_confirmCheckfile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/debentureSale", desc = "单笔债权出让")
    public String _tradeFacade_debentureSale(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/establishProject", desc = "创建标的")
    public String _tradeFacade_establishProject(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/freeze", desc = "冻结接口")
    public String _tradeFacade_freeze(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/freezePreTransaction", desc = "冻结预处理")
    public String _tradeFacade_freezePreTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/modifyProject", desc = "变更标的")
    public String _tradeFacade_modifyProject(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/unfreeze", desc = "解冻接口")
    public String _tradeFacade_unfreeze(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/unfreezeTradePassword", desc = "交易密码解冻")
    public String _tradeFacade_unfreezeTradePassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/userAuthorization", desc = "用户授权")
    public String _tradeFacade_userAuthorization(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/userAutoPreTransaction", desc = "授权预处理")
    public String _tradeFacade_userAutoPreTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/userPreTransaction", desc = "用户预处理")
    public String _tradeFacade_userPreTransaction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeFacade/verifyDeduct", desc = "验密扣费")
    public String _tradeFacade_verifyDeduct(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
