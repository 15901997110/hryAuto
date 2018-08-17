package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.LanmaoBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: LanmaoDefaultTest
 * @Author: 自动生成
 * @Date: 2018/08/17 14:34:00
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class LanmaoDefaultTest extends LanmaoBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/accountFacade/accountRecharge", dataProvider = "provider", description = "调账充值接口:一键从天天聚迁移至存管余额使用")
    public void accountFacade_accountRecharge(HryTest hryTest) {
        String actual = this._accountFacade_accountRecharge(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/activateStockedUser", dataProvider = "provider", description = "会员激活")
    public void accountFacade_activateStockedUser(HryTest hryTest) {
        String actual = this._accountFacade_activateStockedUser(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/auditBindCard", dataProvider = "provider", description = "换卡审核")
    public void accountFacade_auditBindCard(HryTest hryTest) {
        String actual = this._accountFacade_auditBindCard(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/bindCardGeneral", dataProvider = "provider", description = "个人和企业直连换卡")
    public void accountFacade_bindCardGeneral(HryTest hryTest) {
        String actual = this._accountFacade_bindCardGeneral(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/checkPassword", dataProvider = "provider", description = "校验密码")
    public void accountFacade_checkPassword(HryTest hryTest) {
        String actual = this._accountFacade_checkPassword(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/enterpriseBindBankcard", dataProvider = "provider", description = "企业换绑卡")
    public void accountFacade_enterpriseBindBankcard(HryTest hryTest) {
        String actual = this._accountFacade_enterpriseBindBankcard(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/enterpriseEntrustImportUser", dataProvider = "provider", description = "企业委托开户")
    public void accountFacade_enterpriseEntrustImportUser(HryTest hryTest) {
        String actual = this._accountFacade_enterpriseEntrustImportUser(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/enterpriseInformationUpdate", dataProvider = "provider", description = "企业信息变更")
    public void accountFacade_enterpriseInformationUpdate(HryTest hryTest) {
        String actual = this._accountFacade_enterpriseInformationUpdate(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/enterpriseRegister", dataProvider = "provider", description = "企业绑卡注册")
    public void accountFacade_enterpriseRegister(HryTest hryTest) {
        String actual = this._accountFacade_enterpriseRegister(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/entrustImportUser", dataProvider = "provider", description = "个人委托开户")
    public void accountFacade_entrustImportUser(HryTest hryTest) {
        String actual = this._accountFacade_entrustImportUser(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/modifyMobileExpand", dataProvider = "provider", description = "预留手机号更新")
    public void accountFacade_modifyMobileExpand(HryTest hryTest) {
        String actual = this._accountFacade_modifyMobileExpand(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/personalBindBankcardExpand", dataProvider = "provider", description = "个人换绑卡")
    public void accountFacade_personalBindBankcardExpand(HryTest hryTest) {
        String actual = this._accountFacade_personalBindBankcardExpand(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/personalRegister", dataProvider = "provider", description = "个人绑卡注册")
    public void accountFacade_personalRegister(HryTest hryTest) {
        String actual = this._accountFacade_personalRegister(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/resetPassword", dataProvider = "provider", description = "修改密码")
    public void accountFacade_resetPassword(HryTest hryTest) {
        String actual = this._accountFacade_resetPassword(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/unBindBankcard", dataProvider = "provider", description = "解绑银行卡")
    public void accountFacade_unBindBankcard(HryTest hryTest) {
        String actual = this._accountFacade_unBindBankcard(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/gatewayFacade/notify", dataProvider = "provider", description = "异步回调")
    public void gatewayFacade_notify(HryTest hryTest) {
        String actual = this._gatewayFacade_notify(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoReconFacade/download", dataProvider = "provider", description = "获取恒丰原始对账文件")
    public void lanmaoReconFacade_download(HryTest hryTest) {
        String actual = this._lanmaoReconFacade_download(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoReconFacade/manualRecon", dataProvider = "provider", description = "手工对账接口")
    public void lanmaoReconFacade_manualRecon(HryTest hryTest) {
        String actual = this._lanmaoReconFacade_manualRecon(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoReconFacade/queryReconInfo", dataProvider = "provider", description = "查询交易对账汇总结果信息")
    public void lanmaoReconFacade_queryReconInfo(HryTest hryTest) {
        String actual = this._lanmaoReconFacade_queryReconInfo(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoReconFacade/queryReconStatusDetail", dataProvider = "provider", description = "查询具体类型的对账状态详情")
    public void lanmaoReconFacade_queryReconStatusDetail(HryTest hryTest) {
        String actual = this._lanmaoReconFacade_queryReconStatusDetail(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryAuthorizationEntrustPayRecord", dataProvider = "provider", description = "委托支付授权记录查询")
    public void queryFacade_queryAuthorizationEntrustPayRecord(HryTest hryTest) {
        String actual = this._queryFacade_queryAuthorizationEntrustPayRecord(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryCancelTransactionSale", dataProvider = "provider", description = "查询取消预处理")
    public void queryFacade_queryCancelTransactionSale(HryTest hryTest) {
        String actual = this._queryFacade_queryCancelTransactionSale(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryDebentureSale", dataProvider = "provider", description = "债权出让查询")
    public void queryFacade_queryDebentureSale(HryTest hryTest) {
        String actual = this._queryFacade_queryDebentureSale(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryGeneralFreeze", dataProvider = "provider", description = "通用冻结查询")
    public void queryFacade_queryGeneralFreeze(HryTest hryTest) {
        String actual = this._queryFacade_queryGeneralFreeze(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryInterceptWithdraw", dataProvider = "provider", description = "查询提现拦截")
    public void queryFacade_queryInterceptWithdraw(HryTest hryTest) {
        String actual = this._queryFacade_queryInterceptWithdraw(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryPreTransaction", dataProvider = "provider", description = "交易预处理查询")
    public void queryFacade_queryPreTransaction(HryTest hryTest) {
        String actual = this._queryFacade_queryPreTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryProjectInformation", dataProvider = "provider", description = "标的信息查询")
    public void queryFacade_queryProjectInformation(HryTest hryTest) {
        String actual = this._queryFacade_queryProjectInformation(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryRechargeTransaction", dataProvider = "provider", description = "充值交易查询")
    public void queryFacade_queryRechargeTransaction(HryTest hryTest) {
        String actual = this._queryFacade_queryRechargeTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryTransactionConfirmation", dataProvider = "provider", description = "交易确认查询")
    public void queryFacade_queryTransactionConfirmation(HryTest hryTest) {
        String actual = this._queryFacade_queryTransactionConfirmation(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryTransactionFreeze", dataProvider = "provider", description = "冻结交易查询")
    public void queryFacade_queryTransactionFreeze(HryTest hryTest) {
        String actual = this._queryFacade_queryTransactionFreeze(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryTransactionUnfreeze", dataProvider = "provider", description = "解冻交易查询")
    public void queryFacade_queryTransactionUnfreeze(HryTest hryTest) {
        String actual = this._queryFacade_queryTransactionUnfreeze(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryUpdateBankcardAuditDetail", dataProvider = "provider", description = "查询换卡记录")
    public void queryFacade_queryUpdateBankcardAuditDetail(HryTest hryTest) {
        String actual = this._queryFacade_queryUpdateBankcardAuditDetail(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryUserInformation", dataProvider = "provider", description = "用户信息查询")
    public void queryFacade_queryUserInformation(HryTest hryTest) {
        String actual = this._queryFacade_queryUserInformation(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/queryFacade/queryWithdrawTransaction", dataProvider = "provider", description = "提现交易查询")
    public void queryFacade_queryWithdrawTransaction(HryTest hryTest) {
        String actual = this._queryFacade_queryWithdrawTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/autoWithdraw", dataProvider = "provider", description = "自动提现")
    public void rechargeAndWithdrawFacade_autoWithdraw(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_autoWithdraw(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/cancelWithdraw", dataProvider = "provider", description = "取消提现")
    public void rechargeAndWithdrawFacade_cancelWithdraw(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_cancelWithdraw(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/confirmWithdraw", dataProvider = "provider", description = "提现确认")
    public void rechargeAndWithdrawFacade_confirmWithdraw(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_confirmWithdraw(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/directRecharge", dataProvider = "provider", description = "自动充值")
    public void rechargeAndWithdrawFacade_directRecharge(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_directRecharge(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/interceptWithdraw", dataProvider = "provider", description = "提现拦截")
    public void rechargeAndWithdrawFacade_interceptWithdraw(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_interceptWithdraw(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/recharge", dataProvider = "provider", description = "充值")
    public void rechargeAndWithdrawFacade_recharge(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_recharge(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/rechargeFundsTransfer", dataProvider = "provider", description = "打款划拨充值")
    public void rechargeAndWithdrawFacade_rechargeFundsTransfer(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_rechargeFundsTransfer(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/rechargeAndWithdrawFacade/withdraw", dataProvider = "provider", description = "提现")
    public void rechargeAndWithdrawFacade_withdraw(HryTest hryTest) {
        String actual = this._rechargeAndWithdrawFacade_withdraw(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/asyncTransaction", dataProvider = "provider", description = "批量交易")
    public void tradeFacade_asyncTransaction(HryTest hryTest) {
        String actual = this._tradeFacade_asyncTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/authorizationEntrustPay", dataProvider = "provider", description = "委托支付授权")
    public void tradeFacade_authorizationEntrustPay(HryTest hryTest) {
        String actual = this._tradeFacade_authorizationEntrustPay(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/cancelDebentureSale", dataProvider = "provider", description = "取消债权出让")
    public void tradeFacade_cancelDebentureSale(HryTest hryTest) {
        String actual = this._tradeFacade_cancelDebentureSale(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/cancelPreTransaction", dataProvider = "provider", description = "预处理取消")
    public void tradeFacade_cancelPreTransaction(HryTest hryTest) {
        String actual = this._tradeFacade_cancelPreTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/cancelUserAuthorization", dataProvider = "provider", description = "取消用户授权")
    public void tradeFacade_cancelUserAuthorization(HryTest hryTest) {
        String actual = this._tradeFacade_cancelUserAuthorization(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/confirmCheckfile", dataProvider = "provider", description = "强制对账文件确认，慎用")
    public void tradeFacade_confirmCheckfile(HryTest hryTest) {
        String actual = this._tradeFacade_confirmCheckfile(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/debentureSale", dataProvider = "provider", description = "单笔债权出让")
    public void tradeFacade_debentureSale(HryTest hryTest) {
        String actual = this._tradeFacade_debentureSale(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/establishProject", dataProvider = "provider", description = "创建标的")
    public void tradeFacade_establishProject(HryTest hryTest) {
        String actual = this._tradeFacade_establishProject(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/freeze", dataProvider = "provider", description = "冻结接口")
    public void tradeFacade_freeze(HryTest hryTest) {
        String actual = this._tradeFacade_freeze(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/freezePreTransaction", dataProvider = "provider", description = "冻结预处理")
    public void tradeFacade_freezePreTransaction(HryTest hryTest) {
        String actual = this._tradeFacade_freezePreTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/modifyProject", dataProvider = "provider", description = "变更标的")
    public void tradeFacade_modifyProject(HryTest hryTest) {
        String actual = this._tradeFacade_modifyProject(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/unfreeze", dataProvider = "provider", description = "解冻接口")
    public void tradeFacade_unfreeze(HryTest hryTest) {
        String actual = this._tradeFacade_unfreeze(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/unfreezeTradePassword", dataProvider = "provider", description = "交易密码解冻")
    public void tradeFacade_unfreezeTradePassword(HryTest hryTest) {
        String actual = this._tradeFacade_unfreezeTradePassword(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/userAuthorization", dataProvider = "provider", description = "用户授权")
    public void tradeFacade_userAuthorization(HryTest hryTest) {
        String actual = this._tradeFacade_userAuthorization(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/userAutoPreTransaction", dataProvider = "provider", description = "授权预处理")
    public void tradeFacade_userAutoPreTransaction(HryTest hryTest) {
        String actual = this._tradeFacade_userAutoPreTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/userPreTransaction", dataProvider = "provider", description = "用户预处理")
    public void tradeFacade_userPreTransaction(HryTest hryTest) {
        String actual = this._tradeFacade_userPreTransaction(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/tradeFacade/verifyDeduct", dataProvider = "provider", description = "验密扣费")
    public void tradeFacade_verifyDeduct(HryTest hryTest) {
        String actual = this._tradeFacade_verifyDeduct(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

}
