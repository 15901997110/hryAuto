package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.UserBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: UserDefaultTest
 * @Author: 自动生成
 * @Date: 2018/10/22 15:52:34
 */
@Slf4j
public class UserDefaultTest extends UserBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public UserDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/accountFacade/authorisedBalance", dataProvider = "provider", description = "余额授权")
    public void accountFacade_authorisedBalance(HryTest hryTest) {
        String actual = super._accountFacade_authorisedBalance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/balanceCheckDetail", dataProvider = "provider", description = "日终余额校验明细")
    public void accountFacade_balanceCheckDetail(HryTest hryTest) {
        String actual = super._accountFacade_balanceCheckDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/cancelAuthorisedBalance", dataProvider = "provider", description = "取消授权余额")
    public void accountFacade_cancelAuthorisedBalance(HryTest hryTest) {
        String actual = super._accountFacade_cancelAuthorisedBalance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAccount", dataProvider = "provider", description = "账单查询")
    public void accountFacade_queryAccount(HryTest hryTest) {
        String actual = super._accountFacade_queryAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAccountBalanceByUserId", dataProvider = "provider", description = "账单查询-根据用户ID查询账户余额")
    public void accountFacade_queryAccountBalanceByUserId(HryTest hryTest) {
        String actual = super._accountFacade_queryAccountBalanceByUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAccountByUserId", dataProvider = "provider", description = "账单查询-根据用户ID按时间倒序查询")
    public void accountFacade_queryAccountByUserId(HryTest hryTest) {
        String actual = super._accountFacade_queryAccountByUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAccountFlowBackEnd", dataProvider = "provider", description = "账单查询-后端使用")
    public void accountFacade_queryAccountFlowBackEnd(HryTest hryTest) {
        String actual = super._accountFacade_queryAccountFlowBackEnd(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAccountFlowByLoginNameListAndTime", dataProvider = "provider", description = "账单查询-根据登录名列表和账务开始、结束时间")
    public void accountFacade_queryAccountFlowByLoginNameListAndTime(HryTest hryTest) {
        String actual = super._accountFacade_queryAccountFlowByLoginNameListAndTime(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAccountFlowForApp", dataProvider = "provider", description = "资金流水查询")
    public void accountFacade_queryAccountFlowForApp(HryTest hryTest) {
        String actual = super._accountFacade_queryAccountFlowForApp(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAuthorisedInfo", dataProvider = "provider", description = "查询授权信息")
    public void accountFacade_queryAuthorisedInfo(HryTest hryTest) {
        String actual = super._accountFacade_queryAuthorisedInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryAuthorisedTransaction", dataProvider = "provider", description = "查询使用授权余额信息")
    public void accountFacade_queryAuthorisedTransaction(HryTest hryTest) {
        String actual = super._accountFacade_queryAuthorisedTransaction(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryUserInfoCheckFileResult", dataProvider = "provider", description = "查询对账结果")
    public void accountFacade_queryUserInfoCheckFileResult(HryTest hryTest) {
        String actual = super._accountFacade_queryUserInfoCheckFileResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/queryUserInfoCheckFileResultDetails", dataProvider = "provider", description = "查询对账结果详情")
    public void accountFacade_queryUserInfoCheckFileResultDetails(HryTest hryTest) {
        String actual = super._accountFacade_queryUserInfoCheckFileResultDetails(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/recheckAccount", dataProvider = "provider", description = "手动发起重新对账")
    public void accountFacade_recheckAccount(HryTest hryTest) {
        String actual = super._accountFacade_recheckAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/reorderAccoutFlow", dataProvider = "provider", description = "账单排序")
    public void accountFacade_reorderAccoutFlow(HryTest hryTest) {
        String actual = super._accountFacade_reorderAccoutFlow(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/useAuthorisedBalance", dataProvider = "provider", description = "匹配授权余额")
    public void accountFacade_useAuthorisedBalance(HryTest hryTest) {
        String actual = super._accountFacade_useAuthorisedBalance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/accountFacade/userCheckDetail", dataProvider = "provider", description = "客户信息校验明细")
    public void accountFacade_userCheckDetail(HryTest hryTest) {
        String actual = super._accountFacade_userCheckDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/externalFacade/confirmProtocolSign", dataProvider = "provider", description = "协议支付签约确认")
    public void externalFacade_confirmProtocolSign(HryTest hryTest) {
        String actual = super._externalFacade_confirmProtocolSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/externalFacade/getHaiLiProjectByOpenId", dataProvider = "provider", description = "根据OpenId查询是否属于海利计划")
    public void externalFacade_getHaiLiProjectByOpenId(HryTest hryTest) {
        String actual = super._externalFacade_getHaiLiProjectByOpenId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/externalFacade/getOpenIdByTpId", dataProvider = "provider", description = "根据第三方ID查询openId")
    public void externalFacade_getOpenIdByTpId(HryTest hryTest) {
        String actual = super._externalFacade_getOpenIdByTpId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/externalFacade/getUserProtocolSign", dataProvider = "provider", description = "查询用户协议支付签约信息")
    public void externalFacade_getUserProtocolSign(HryTest hryTest) {
        String actual = super._externalFacade_getUserProtocolSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/externalFacade/getZDPersonalStateByGateway", dataProvider = "provider", description = "根据用户证件号+银行卡号+渠道标识查询个人状态网关专用(适用于显性开户)")
    public void externalFacade_getZDPersonalStateByGateway(HryTest hryTest) {
        String actual = super._externalFacade_getZDPersonalStateByGateway(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/externalFacade/protocolSign", dataProvider = "provider", description = "协议支付签约(该接口只支持个人身份证用户)")
    public void externalFacade_protocolSign(HryTest hryTest) {
        String actual = super._externalFacade_protocolSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/haierGatewayFacade/haierUserBinding", dataProvider = "provider", description = "海尔用户绑定")
    public void haierGatewayFacade_haierUserBinding(HryTest hryTest) {
        String actual = super._haierGatewayFacade_haierUserBinding(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/haierGatewayFacade/haierUserLogin", dataProvider = "provider", description = "海尔用户登录")
    public void haierGatewayFacade_haierUserLogin(HryTest hryTest) {
        String actual = super._haierGatewayFacade_haierUserLogin(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/activateStockedUser", dataProvider = "provider", description = "会员激活")
    public void lanmaoGatewayFacade_activateStockedUser(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_activateStockedUser(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/auditBindCard", dataProvider = "provider", description = "换卡审核")
    public void lanmaoGatewayFacade_auditBindCard(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_auditBindCard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/bindCardGeneral", dataProvider = "provider", description = "个人和企业直连换卡")
    public void lanmaoGatewayFacade_bindCardGeneral(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_bindCardGeneral(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/checkPassword", dataProvider = "provider", description = "校验密码")
    public void lanmaoGatewayFacade_checkPassword(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_checkPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/confirmProtocolSign", dataProvider = "provider", description = "协议支付签约确认")
    public void lanmaoGatewayFacade_confirmProtocolSign(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_confirmProtocolSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/enterpriseBindBankcard", dataProvider = "provider", description = "企业换绑卡")
    public void lanmaoGatewayFacade_enterpriseBindBankcard(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_enterpriseBindBankcard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/enterpriseInformationUpdate", dataProvider = "provider", description = "企业信息变更")
    public void lanmaoGatewayFacade_enterpriseInformationUpdate(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_enterpriseInformationUpdate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/enterpriseRegister", dataProvider = "provider", description = "企业绑卡注册")
    public void lanmaoGatewayFacade_enterpriseRegister(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_enterpriseRegister(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/modifyMobile", dataProvider = "provider", description = "预留手机号更新")
    public void lanmaoGatewayFacade_modifyMobile(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_modifyMobile(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/personalBindBankcardExpand", dataProvider = "provider", description = "个人换绑卡")
    public void lanmaoGatewayFacade_personalBindBankcardExpand(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_personalBindBankcardExpand(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/personalRegister", dataProvider = "provider", description = "个人绑卡注册")
    public void lanmaoGatewayFacade_personalRegister(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_personalRegister(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/protocolSign", dataProvider = "provider", description = "协议支付签约(该接口只支持个人身份证用户)")
    public void lanmaoGatewayFacade_protocolSign(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_protocolSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/queryProtocolSign", dataProvider = "provider", description = "查询用户的协议签约信息")
    public void lanmaoGatewayFacade_queryProtocolSign(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_queryProtocolSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/queryUserInformation", dataProvider = "provider", description = "用户信息查询")
    public void lanmaoGatewayFacade_queryUserInformation(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_queryUserInformation(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/resetPassword", dataProvider = "provider", description = "修改密码")
    public void lanmaoGatewayFacade_resetPassword(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_resetPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/lanmaoGatewayFacade/userAuthorization", dataProvider = "provider", description = "用户授权")
    public void lanmaoGatewayFacade_userAuthorization(HryTest hryTest) {
        String actual = super._lanmaoGatewayFacade_userAuthorization(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanQuotaFacade/freezeLoanAmount", dataProvider = "provider", description = "冻结借款额度")
    public void loanQuotaFacade_freezeLoanAmount(HryTest hryTest) {
        String actual = super._loanQuotaFacade_freezeLoanAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanQuotaFacade/queryLoanQuota", dataProvider = "provider", description = "借款额度查询")
    public void loanQuotaFacade_queryLoanQuota(HryTest hryTest) {
        String actual = super._loanQuotaFacade_queryLoanQuota(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanQuotaFacade/returnLoanAmount", dataProvider = "provider", description = "归还额度")
    public void loanQuotaFacade_returnLoanAmount(HryTest hryTest) {
        String actual = super._loanQuotaFacade_returnLoanAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanQuotaFacade/unfreezeLoanAmount", dataProvider = "provider", description = "解冻借款额度")
    public void loanQuotaFacade_unfreezeLoanAmount(HryTest hryTest) {
        String actual = super._loanQuotaFacade_unfreezeLoanAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loanQuotaFacade/useLoanAmount", dataProvider = "provider", description = "使用额度")
    public void loanQuotaFacade_useLoanAmount(HryTest hryTest) {
        String actual = super._loanQuotaFacade_useLoanAmount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/generateCode", dataProvider = "provider", description = "验证码生成接口")
    public void loginFacade_generateCode(HryTest hryTest) {
        String actual = super._loginFacade_generateCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/getUserInfoByToken", dataProvider = "provider", description = "根据登录token获取用户信息")
    public void loginFacade_getUserInfoByToken(HryTest hryTest) {
        String actual = super._loginFacade_getUserInfoByToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/inLoginRisk", dataProvider = "provider", description = "登录风险控制内部接口")
    public void loginFacade_inLoginRisk(HryTest hryTest) {
        String actual = super._loginFacade_inLoginRisk(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/inRegisterRisk", dataProvider = "provider", description = "注册风险控制内部接口")
    public void loginFacade_inRegisterRisk(HryTest hryTest) {
        String actual = super._loginFacade_inRegisterRisk(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/login", dataProvider = "provider", description = "非投资用户登录")
    public void loginFacade_login(HryTest hryTest) {
        String actual = super._loginFacade_login(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/logout", dataProvider = "provider", description = "账号退出")
    public void loginFacade_logout(HryTest hryTest) {
        String actual = super._loginFacade_logout(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/regist", dataProvider = "provider", description = "账号注册")
    public void loginFacade_regist(HryTest hryTest) {
        String actual = super._loginFacade_regist(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/sendEmailAuthCode", dataProvider = "provider", description = "发送邮箱验证码")
    public void loginFacade_sendEmailAuthCode(HryTest hryTest) {
        String actual = super._loginFacade_sendEmailAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/sendMobileAuthCode", dataProvider = "provider", description = "发送手机验证码")
    public void loginFacade_sendMobileAuthCode(HryTest hryTest) {
        String actual = super._loginFacade_sendMobileAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/sendMobileAuthCodeByToken", dataProvider = "provider", description = "根据校验码token发送验证码")
    public void loginFacade_sendMobileAuthCodeByToken(HryTest hryTest) {
        String actual = super._loginFacade_sendMobileAuthCodeByToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/updateBindingMobile", dataProvider = "provider", description = "修改绑定手机号")
    public void loginFacade_updateBindingMobile(HryTest hryTest) {
        String actual = super._loginFacade_updateBindingMobile(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/updateLoginPassword", dataProvider = "provider", description = "修改登录密码")
    public void loginFacade_updateLoginPassword(HryTest hryTest) {
        String actual = super._loginFacade_updateLoginPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/updateLoginPasswordByOriginPassword", dataProvider = "provider", description = "根据原密码修改登录密码")
    public void loginFacade_updateLoginPasswordByOriginPassword(HryTest hryTest) {
        String actual = super._loginFacade_updateLoginPasswordByOriginPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/validateEmailAuthCode", dataProvider = "provider", description = "验证邮箱验证码")
    public void loginFacade_validateEmailAuthCode(HryTest hryTest) {
        String actual = super._loginFacade_validateEmailAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/validateIdCardNo", dataProvider = "provider", description = "校验身份证号码")
    public void loginFacade_validateIdCardNo(HryTest hryTest) {
        String actual = super._loginFacade_validateIdCardNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/loginFacade/validateMobileAuthCode", dataProvider = "provider", description = "验证手机验证码")
    public void loginFacade_validateMobileAuthCode(HryTest hryTest) {
        String actual = super._loginFacade_validateMobileAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/nonInvestorFacade/getPlatformUserInfoByUserNo", dataProvider = "provider", description = "根据平台用户编号查询平台用户信息")
    public void nonInvestorFacade_getPlatformUserInfoByUserNo(HryTest hryTest) {
        String actual = super._nonInvestorFacade_getPlatformUserInfoByUserNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/nonInvestorFacade/setSubRole", dataProvider = "provider", description = "设置二级角色")
    public void nonInvestorFacade_setSubRole(HryTest hryTest) {
        String actual = super._nonInvestorFacade_setSubRole(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/nonInvestorFacade/setSubRoleByLoginName", dataProvider = "provider", description = "根据用户名设置二级角色")
    public void nonInvestorFacade_setSubRoleByLoginName(HryTest hryTest) {
        String actual = super._nonInvestorFacade_setSubRoleByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oauthFacade/decryptUserId", dataProvider = "provider", description = "userId解密")
    public void oauthFacade_decryptUserId(HryTest hryTest) {
        String actual = super._oauthFacade_decryptUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oauthFacade/encryptUserId", dataProvider = "provider", description = "userId加密")
    public void oauthFacade_encryptUserId(HryTest hryTest) {
        String actual = super._oauthFacade_encryptUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oauthFacade/getAccessCode", dataProvider = "provider", description = "获取access_code")
    public void oauthFacade_getAccessCode(HryTest hryTest) {
        String actual = super._oauthFacade_getAccessCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oauthFacade/getUserIdByToken", dataProvider = "provider", description = "根据token获取用户ID")
    public void oauthFacade_getUserIdByToken(HryTest hryTest) {
        String actual = super._oauthFacade_getUserIdByToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oauthFacade/queryTokenByAccessCode", dataProvider = "provider", description = "根据access_code获取token")
    public void oauthFacade_queryTokenByAccessCode(HryTest hryTest) {
        String actual = super._oauthFacade_queryTokenByAccessCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oauthFacade/refreshAccessToken", dataProvider = "provider", description = "根据refreshToken刷新accessToken")
    public void oauthFacade_refreshAccessToken(HryTest hryTest) {
        String actual = super._oauthFacade_refreshAccessToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/oauthFacade/validateOauthClient", dataProvider = "provider", description = "验证客户端")
    public void oauthFacade_validateOauthClient(HryTest hryTest) {
        String actual = super._oauthFacade_validateOauthClient(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/riskManagermentFacade/cardModigyRiskManager", dataProvider = "provider", description = "银行卡切换风险控制")
    public void riskManagermentFacade_cardModigyRiskManager(HryTest hryTest) {
        String actual = super._riskManagermentFacade_cardModigyRiskManager(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/riskManagermentFacade/loginRiskManager", dataProvider = "provider", description = "登录风险控制")
    public void riskManagermentFacade_loginRiskManager(HryTest hryTest) {
        String actual = super._riskManagermentFacade_loginRiskManager(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/riskManagermentFacade/openDepositoryRiskManager", dataProvider = "provider", description = "开通存管风险控制")
    public void riskManagermentFacade_openDepositoryRiskManager(HryTest hryTest) {
        String actual = super._riskManagermentFacade_openDepositoryRiskManager(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/riskManagermentFacade/registerRiskManager", dataProvider = "provider", description = "注册风险控制")
    public void riskManagermentFacade_registerRiskManager(HryTest hryTest) {
        String actual = super._riskManagermentFacade_registerRiskManager(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userCommonFacade/getAllCacheNames", dataProvider = "provider", description = "获取所有的缓存名称")
    public void userCommonFacade_getAllCacheNames(HryTest hryTest) {
        String actual = super._userCommonFacade_getAllCacheNames(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/deleteUserExtraAttachment", dataProvider = "provider", description = "删除借款人附加附件")
    public void userConsoleFacade_deleteUserExtraAttachment(HryTest hryTest) {
        String actual = super._userConsoleFacade_deleteUserExtraAttachment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/getAllAccountType", dataProvider = "provider", description = "查询所有的账务类型")
    public void userConsoleFacade_getAllAccountType(HryTest hryTest) {
        String actual = super._userConsoleFacade_getAllAccountType(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/getBankAuditDetail", dataProvider = "provider", description = "查询银行卡审核详细信息")
    public void userConsoleFacade_getBankAuditDetail(HryTest hryTest) {
        String actual = super._userConsoleFacade_getBankAuditDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/queryAccountflow", dataProvider = "provider", description = "账单查询-后端使用")
    public void userConsoleFacade_queryAccountflow(HryTest hryTest) {
        String actual = super._userConsoleFacade_queryAccountflow(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/queryAuthUsers", dataProvider = "provider", description = "查询授权用户")
    public void userConsoleFacade_queryAuthUsers(HryTest hryTest) {
        String actual = super._userConsoleFacade_queryAuthUsers(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/queryBankAuditList", dataProvider = "provider", description = "查询银行卡审核记录列表")
    public void userConsoleFacade_queryBankAuditList(HryTest hryTest) {
        String actual = super._userConsoleFacade_queryBankAuditList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/queryEnterpriseDetail", dataProvider = "provider", description = "根据用户id查询企业详细信息")
    public void userConsoleFacade_queryEnterpriseDetail(HryTest hryTest) {
        String actual = super._userConsoleFacade_queryEnterpriseDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/queryPersonalDetail", dataProvider = "provider", description = "根据用户id查询用户详细信息")
    public void userConsoleFacade_queryPersonalDetail(HryTest hryTest) {
        String actual = super._userConsoleFacade_queryPersonalDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/queryUserList", dataProvider = "provider", description = "根据条件查询用户列表")
    public void userConsoleFacade_queryUserList(HryTest hryTest) {
        String actual = super._userConsoleFacade_queryUserList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/resetWrongTimes", dataProvider = "provider", description = "置密码错误次数")
    public void userConsoleFacade_resetWrongTimes(HryTest hryTest) {
        String actual = super._userConsoleFacade_resetWrongTimes(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/riskAudit", dataProvider = "provider", description = "风控审核")
    public void userConsoleFacade_riskAudit(HryTest hryTest) {
        String actual = super._userConsoleFacade_riskAudit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/upateUserState", dataProvider = "provider", description = "更改用户状态")
    public void userConsoleFacade_upateUserState(HryTest hryTest) {
        String actual = super._userConsoleFacade_upateUserState(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/uploadBankAuditFile", dataProvider = "provider", description = "上传审核附件")
    public void userConsoleFacade_uploadBankAuditFile(HryTest hryTest) {
        String actual = super._userConsoleFacade_uploadBankAuditFile(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userConsoleFacade/uploadImageFile", dataProvider = "provider", description = "")
    public void userConsoleFacade_uploadImageFile(HryTest hryTest) {
        String actual = super._userConsoleFacade_uploadImageFile(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/addUserExtraInfo", dataProvider = "provider", description = "添加借款人附加信息")
    public void userFacade_addUserExtraInfo(HryTest hryTest) {
        String actual = super._userFacade_addUserExtraInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/checkBankCardAudit", dataProvider = "provider", description = "检查用户换绑卡审核记录状态")
    public void userFacade_checkBankCardAudit(HryTest hryTest) {
        String actual = super._userFacade_checkBankCardAudit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/checkEnterpriseUpdateProcess", dataProvider = "provider", description = "检查企业修改信息审核记录状态")
    public void userFacade_checkEnterpriseUpdateProcess(HryTest hryTest) {
        String actual = super._userFacade_checkEnterpriseUpdateProcess(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/checkLoginNameExists", dataProvider = "provider", description = "检查用户名是否存在")
    public void userFacade_checkLoginNameExists(HryTest hryTest) {
        String actual = super._userFacade_checkLoginNameExists(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/filterUserIdByBirthday", dataProvider = "provider", description = "根据生日筛选userId")
    public void userFacade_filterUserIdByBirthday(HryTest hryTest) {
        String actual = super._userFacade_filterUserIdByBirthday(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getAuth", dataProvider = "provider", description = "根据用户id查询授权信息")
    public void userFacade_getAuth(HryTest hryTest) {
        String actual = super._userFacade_getAuth(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getBankCardBindingList", dataProvider = "provider", description = "根据用户id查询绑卡列表(适用于个人,企业)")
    public void userFacade_getBankCardBindingList(HryTest hryTest) {
        String actual = super._userFacade_getBankCardBindingList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getBaseInfoByUserIds", dataProvider = "provider", description = "批量查询用户基本信息")
    public void userFacade_getBaseInfoByUserIds(HryTest hryTest) {
        String actual = super._userFacade_getBaseInfoByUserIds(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getEnterpriseInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询企业信息")
    public void userFacade_getEnterpriseInfoByLoginName(HryTest hryTest) {
        String actual = super._userFacade_getEnterpriseInfoByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getEnterpriseInfoByUserId", dataProvider = "provider", description = "根据用户id查询企业信息")
    public void userFacade_getEnterpriseInfoByUserId(HryTest hryTest) {
        String actual = super._userFacade_getEnterpriseInfoByUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getInvestProfit", dataProvider = "provider", description = "获得用户收益")
    public void userFacade_getInvestProfit(HryTest hryTest) {
        String actual = super._userFacade_getInvestProfit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getPersonalInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询个人信息")
    public void userFacade_getPersonalInfoByLoginName(HryTest hryTest) {
        String actual = super._userFacade_getPersonalInfoByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getPersonalInfoByUserId", dataProvider = "provider", description = "根据用户id查询个人信息")
    public void userFacade_getPersonalInfoByUserId(HryTest hryTest) {
        String actual = super._userFacade_getPersonalInfoByUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getPersonalRealName", dataProvider = "provider", description = "根据用户id查询个人实名信息")
    public void userFacade_getPersonalRealName(HryTest hryTest) {
        String actual = super._userFacade_getPersonalRealName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getPersonalRealNameByUserIds", dataProvider = "provider", description = "批量查询个人实名信息")
    public void userFacade_getPersonalRealNameByUserIds(HryTest hryTest) {
        String actual = super._userFacade_getPersonalRealNameByUserIds(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUnionUserByLoginName", dataProvider = "provider", description = "根据登陆名查询UnionUser")
    public void userFacade_getUnionUserByLoginName(HryTest hryTest) {
        String actual = super._userFacade_getUnionUserByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserActionInfoByLoginName", dataProvider = "provider", description = "根据用户名获取用户行为信息")
    public void userFacade_getUserActionInfoByLoginName(HryTest hryTest) {
        String actual = super._userFacade_getUserActionInfoByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserExtraInfo", dataProvider = "provider", description = "获取借款人附加信息")
    public void userFacade_getUserExtraInfo(HryTest hryTest) {
        String actual = super._userFacade_getUserExtraInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserIdWithSameIdCardNo", dataProvider = "provider", description = "根据证件类型+证件号查询全部的个人userId")
    public void userFacade_getUserIdWithSameIdCardNo(HryTest hryTest) {
        String actual = super._userFacade_getUserIdWithSameIdCardNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询基本信息")
    public void userFacade_getUserInfoByLoginName(HryTest hryTest) {
        String actual = super._userFacade_getUserInfoByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserInfoByUserId", dataProvider = "provider", description = "根据用户id查询基本信息")
    public void userFacade_getUserInfoByUserId(HryTest hryTest) {
        String actual = super._userFacade_getUserInfoByUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserProperty", dataProvider = "provider", description = "获得用户资产统计")
    public void userFacade_getUserProperty(HryTest hryTest) {
        String actual = super._userFacade_getUserProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserPropertyDetail", dataProvider = "provider", description = "获得用户资产详情")
    public void userFacade_getUserPropertyDetail(HryTest hryTest) {
        String actual = super._userFacade_getUserPropertyDetail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getUserProtocolSign", dataProvider = "provider", description = "查询用户协议支付签约信息")
    public void userFacade_getUserProtocolSign(HryTest hryTest) {
        String actual = super._userFacade_getUserProtocolSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getZDPersonalState", dataProvider = "provider", description = "根据用户证件号+银行卡号+渠道标识查询个人状态(适用于显性开户)")
    public void userFacade_getZDPersonalState(HryTest hryTest) {
        String actual = super._userFacade_getZDPersonalState(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/getZDUserState", dataProvider = "provider", description = "根据登陆名和银行卡号查询用户状态(适用于显性开户)")
    public void userFacade_getZDUserState(HryTest hryTest) {
        String actual = super._userFacade_getZDUserState(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/initInvestorUser", dataProvider = "provider", description = "初始化投资用户")
    public void userFacade_initInvestorUser(HryTest hryTest) {
        String actual = super._userFacade_initInvestorUser(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/isCunguanTestingUser", dataProvider = "provider", description = "是否是存管测试用户")
    public void userFacade_isCunguanTestingUser(HryTest hryTest) {
        String actual = super._userFacade_isCunguanTestingUser(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/queryBankList", dataProvider = "provider", description = "查询银行卡列表")
    public void userFacade_queryBankList(HryTest hryTest) {
        String actual = super._userFacade_queryBankList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/updateEnterpriseBankCardInfo", dataProvider = "provider", description = "新增或更新企业银行卡信息")
    public void userFacade_updateEnterpriseBankCardInfo(HryTest hryTest) {
        String actual = super._userFacade_updateEnterpriseBankCardInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/updateEnterpriseBaseInfo", dataProvider = "provider", description = "新增或更新企业基本信息")
    public void userFacade_updateEnterpriseBaseInfo(HryTest hryTest) {
        String actual = super._userFacade_updateEnterpriseBaseInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/updateEnterpriseLegalInfo", dataProvider = "provider", description = "新增或更新企业法人信息")
    public void userFacade_updateEnterpriseLegalInfo(HryTest hryTest) {
        String actual = super._userFacade_updateEnterpriseLegalInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/updateGroupId", dataProvider = "provider", description = "根据userId更新groupId")
    public void userFacade_updateGroupId(HryTest hryTest) {
        String actual = super._userFacade_updateGroupId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/updateUserInfo", dataProvider = "provider", description = "更新用户信息(适用于更新绑定手机,企业联系人,企业联系人手机,银行卡,银行预留手机)")
    public void userFacade_updateUserInfo(HryTest hryTest) {
        String actual = super._userFacade_updateUserInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/userFacade/verifyPasswordByRequestNo", dataProvider = "provider", description = "根据请求号验证密码")
    public void userFacade_verifyPasswordByRequestNo(HryTest hryTest) {
        String actual = super._userFacade_verifyPasswordByRequestNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/weChatFacade/bindOpenIdAndUserId", dataProvider = "provider", description = "绑定微信openId和userId")
    public void weChatFacade_bindOpenIdAndUserId(HryTest hryTest) {
        String actual = super._weChatFacade_bindOpenIdAndUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/weChatFacade/getOpenIdByUserId", dataProvider = "provider", description = "根据userId查询openId")
    public void weChatFacade_getOpenIdByUserId(HryTest hryTest) {
        String actual = super._weChatFacade_getOpenIdByUserId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/weChatFacade/getUserIdByOpenId", dataProvider = "provider", description = "根据openId查询userId")
    public void weChatFacade_getUserIdByOpenId(HryTest hryTest) {
        String actual = super._weChatFacade_getUserIdByOpenId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/weChatFacade/unbindOpenIdAndUserId", dataProvider = "provider", description = "解绑微信openId")
    public void weChatFacade_unbindOpenIdAndUserId(HryTest hryTest) {
        String actual = super._weChatFacade_unbindOpenIdAndUserId(hryTest);
        supperAssert(actual, hryTest);
    }

}
