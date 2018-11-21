package com.haier.testng.test;

import com.haier.anno.SKey;
import com.haier.po.HryTest;
import com.haier.testng.base.Base;
import com.haier.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.haier.util.AssertUtil.supperAssert;
@SKey("Lanmao")
public class LanmaoDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public LanmaoDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/accountFacade/accountRecharge", dataProvider = "provider", description = "调账充值接口:一键从天天聚迁移至存管余额使用")
    public void accountFacade_accountRecharge(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/activateStockedUser", dataProvider = "provider", description = "会员激活")
    public void accountFacade_activateStockedUser(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/auditBindCard", dataProvider = "provider", description = "换卡审核")
    public void accountFacade_auditBindCard(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/bindCardGeneral", dataProvider = "provider", description = "个人和企业直连换卡")
    public void accountFacade_bindCardGeneral(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/checkPassword", dataProvider = "provider", description = "校验密码")
    public void accountFacade_checkPassword(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/enterpriseBindBankcard", dataProvider = "provider", description = "企业换绑卡")
    public void accountFacade_enterpriseBindBankcard(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/enterpriseEntrustImportUser", dataProvider = "provider", description = "企业委托开户")
    public void accountFacade_enterpriseEntrustImportUser(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/enterpriseInformationUpdate", dataProvider = "provider", description = "企业信息变更")
    public void accountFacade_enterpriseInformationUpdate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/enterpriseRegister", dataProvider = "provider", description = "企业绑卡注册")
    public void accountFacade_enterpriseRegister(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/entrustImportUser", dataProvider = "provider", description = "个人委托开户")
    public void accountFacade_entrustImportUser(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/modifyMobileExpand", dataProvider = "provider", description = "预留手机号更新")
    public void accountFacade_modifyMobileExpand(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/personalBindBankcardExpand", dataProvider = "provider", description = "个人换绑卡")
    public void accountFacade_personalBindBankcardExpand(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/personalRegister", dataProvider = "provider", description = "个人绑卡注册")
    public void accountFacade_personalRegister(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/resetPassword", dataProvider = "provider", description = "修改密码")
    public void accountFacade_resetPassword(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/accountFacade/unBindBankcard", dataProvider = "provider", description = "解绑银行卡")
    public void accountFacade_unBindBankcard(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/gatewayFacade/notify", dataProvider = "provider", description = "异步回调")
    public void gatewayFacade_notify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/lanmaoReconFacade/download", dataProvider = "provider", description = "获取恒丰原始对账文件")
    public void lanmaoReconFacade_download(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/lanmaoReconFacade/manualRecon", dataProvider = "provider", description = "手工对账接口")
    public void lanmaoReconFacade_manualRecon(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/lanmaoReconFacade/queryReconInfo", dataProvider = "provider", description = "查询交易对账汇总结果信息")
    public void lanmaoReconFacade_queryReconInfo(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/lanmaoReconFacade/queryReconStatusDetail", dataProvider = "provider", description = "查询具体类型的对账状态详情")
    public void lanmaoReconFacade_queryReconStatusDetail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryAuthorizationEntrustPayRecord", dataProvider = "provider", description = "委托支付授权记录查询")
    public void queryFacade_queryAuthorizationEntrustPayRecord(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryCancelTransactionSale", dataProvider = "provider", description = "查询取消预处理")
    public void queryFacade_queryCancelTransactionSale(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryDebentureSale", dataProvider = "provider", description = "债权出让查询")
    public void queryFacade_queryDebentureSale(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryGeneralFreeze", dataProvider = "provider", description = "通用冻结查询")
    public void queryFacade_queryGeneralFreeze(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryInterceptWithdraw", dataProvider = "provider", description = "查询提现拦截")
    public void queryFacade_queryInterceptWithdraw(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryPreTransaction", dataProvider = "provider", description = "交易预处理查询")
    public void queryFacade_queryPreTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryProjectInformation", dataProvider = "provider", description = "标的信息查询")
    public void queryFacade_queryProjectInformation(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryRechargeTransaction", dataProvider = "provider", description = "充值交易查询")
    public void queryFacade_queryRechargeTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryTransactionConfirmation", dataProvider = "provider", description = "交易确认查询")
    public void queryFacade_queryTransactionConfirmation(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryTransactionFreeze", dataProvider = "provider", description = "冻结交易查询")
    public void queryFacade_queryTransactionFreeze(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryTransactionUnfreeze", dataProvider = "provider", description = "解冻交易查询")
    public void queryFacade_queryTransactionUnfreeze(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryUpdateBankcardAuditDetail", dataProvider = "provider", description = "查询换卡记录")
    public void queryFacade_queryUpdateBankcardAuditDetail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryUserInformation", dataProvider = "provider", description = "用户信息查询")
    public void queryFacade_queryUserInformation(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/queryFacade/queryWithdrawTransaction", dataProvider = "provider", description = "提现交易查询")
    public void queryFacade_queryWithdrawTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/autoWithdraw", dataProvider = "provider", description = "自动提现")
    public void rechargeAndWithdrawFacade_autoWithdraw(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/cancelWithdraw", dataProvider = "provider", description = "取消提现")
    public void rechargeAndWithdrawFacade_cancelWithdraw(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/confirmWithdraw", dataProvider = "provider", description = "提现确认")
    public void rechargeAndWithdrawFacade_confirmWithdraw(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/directRecharge", dataProvider = "provider", description = "自动充值")
    public void rechargeAndWithdrawFacade_directRecharge(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/interceptWithdraw", dataProvider = "provider", description = "提现拦截")
    public void rechargeAndWithdrawFacade_interceptWithdraw(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/recharge", dataProvider = "provider", description = "充值")
    public void rechargeAndWithdrawFacade_recharge(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/rechargeFundsTransfer", dataProvider = "provider", description = "打款划拨充值")
    public void rechargeAndWithdrawFacade_rechargeFundsTransfer(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/withdraw", dataProvider = "provider", description = "提现")
    public void rechargeAndWithdrawFacade_withdraw(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/asyncTransaction", dataProvider = "provider", description = "批量交易")
    public void tradeFacade_asyncTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/authorizationEntrustPay", dataProvider = "provider", description = "委托支付授权")
    public void tradeFacade_authorizationEntrustPay(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/cancelDebentureSale", dataProvider = "provider", description = "取消债权出让")
    public void tradeFacade_cancelDebentureSale(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/cancelPreTransaction", dataProvider = "provider", description = "预处理取消")
    public void tradeFacade_cancelPreTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/cancelUserAuthorization", dataProvider = "provider", description = "取消用户授权")
    public void tradeFacade_cancelUserAuthorization(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/confirmCheckfile", dataProvider = "provider", description = "强制对账文件确认，慎用")
    public void tradeFacade_confirmCheckfile(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/debentureSale", dataProvider = "provider", description = "单笔债权出让")
    public void tradeFacade_debentureSale(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/establishProject", dataProvider = "provider", description = "创建标的")
    public void tradeFacade_establishProject(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/freeze", dataProvider = "provider", description = "冻结接口")
    public void tradeFacade_freeze(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/freezePreTransaction", dataProvider = "provider", description = "冻结预处理")
    public void tradeFacade_freezePreTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/modifyProject", dataProvider = "provider", description = "变更标的")
    public void tradeFacade_modifyProject(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/unfreeze", dataProvider = "provider", description = "解冻接口")
    public void tradeFacade_unfreeze(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/unfreezeTradePassword", dataProvider = "provider", description = "交易密码解冻")
    public void tradeFacade_unfreezeTradePassword(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/userAuthorization", dataProvider = "provider", description = "用户授权")
    public void tradeFacade_userAuthorization(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/userAutoPreTransaction", dataProvider = "provider", description = "授权预处理")
    public void tradeFacade_userAutoPreTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/userPreTransaction", dataProvider = "provider", description = "用户预处理")
    public void tradeFacade_userPreTransaction(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/tradeFacade/verifyDeduct", dataProvider = "provider", description = "验密扣费")
    public void tradeFacade_verifyDeduct(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
