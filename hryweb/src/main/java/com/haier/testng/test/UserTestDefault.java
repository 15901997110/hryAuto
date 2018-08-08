package com.haier.testng.test;

import com.haier.po.Params;
import com.haier.testng.base.UserBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
/**
 * @Description: UserTestDefault
 * @Author: 自动生成
 * @Date: 2018/08/08 17:35:33
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class UserTestDefault extends UserBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        init(serviceId, envId, caseDesigner, i_c);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/accountFacade/balanceCheckDetail", dataProvider = "provider", description = "日终余额校验明细")
    public void accountFacade_balanceCheckDetail(Params params) {
        String actual = this.accountFacade_balanceCheckDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/queryAccount", dataProvider = "provider", description = "账单查询")
    public void accountFacade_queryAccount(Params params) {
        String actual = this.accountFacade_queryAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/queryAccountBalanceByUserId", dataProvider = "provider", description = "账单查询-根据用户ID查询账户余额")
    public void accountFacade_queryAccountBalanceByUserId(Params params) {
        String actual = this.accountFacade_queryAccountBalanceByUserId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/queryAccountByUserId", dataProvider = "provider", description = "账单查询-根据用户ID按时间倒序查询")
    public void accountFacade_queryAccountByUserId(Params params) {
        String actual = this.accountFacade_queryAccountByUserId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/queryAccountFlowBackEnd", dataProvider = "provider", description = "账单查询-后端使用")
    public void accountFacade_queryAccountFlowBackEnd(Params params) {
        String actual = this.accountFacade_queryAccountFlowBackEnd(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/queryAccountFlowByLoginNameListAndTime", dataProvider = "provider", description = "账单查询-根据登录名列表和账务开始、结束时间")
    public void accountFacade_queryAccountFlowByLoginNameListAndTime(Params params) {
        String actual = this.accountFacade_queryAccountFlowByLoginNameListAndTime(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/queryUserInfoCheckFileResult", dataProvider = "provider", description = "查询对账结果")
    public void accountFacade_queryUserInfoCheckFileResult(Params params) {
        String actual = this.accountFacade_queryUserInfoCheckFileResult(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/queryUserInfoCheckFileResultDetails", dataProvider = "provider", description = "查询对账结果详情")
    public void accountFacade_queryUserInfoCheckFileResultDetails(Params params) {
        String actual = this.accountFacade_queryUserInfoCheckFileResultDetails(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/recheckAccount", dataProvider = "provider", description = "手动发起重新对账")
    public void accountFacade_recheckAccount(Params params) {
        String actual = this.accountFacade_recheckAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/accountFacade/userCheckDetail", dataProvider = "provider", description = "客户信息校验明细")
    public void accountFacade_userCheckDetail(Params params) {
        String actual = this.accountFacade_userCheckDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/activateStockedUser", dataProvider = "provider", description = "会员激活")
    public void lanmaoGatewayFacade_activateStockedUser(Params params) {
        String actual = this.lanmaoGatewayFacade_activateStockedUser(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/auditBindCard", dataProvider = "provider", description = "换卡审核")
    public void lanmaoGatewayFacade_auditBindCard(Params params) {
        String actual = this.lanmaoGatewayFacade_auditBindCard(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/bindCardGeneral", dataProvider = "provider", description = "个人和企业直连换卡")
    public void lanmaoGatewayFacade_bindCardGeneral(Params params) {
        String actual = this.lanmaoGatewayFacade_bindCardGeneral(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/checkPassword", dataProvider = "provider", description = "校验密码")
    public void lanmaoGatewayFacade_checkPassword(Params params) {
        String actual = this.lanmaoGatewayFacade_checkPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/enterpriseBindBankcard", dataProvider = "provider", description = "企业换绑卡")
    public void lanmaoGatewayFacade_enterpriseBindBankcard(Params params) {
        String actual = this.lanmaoGatewayFacade_enterpriseBindBankcard(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/enterpriseInformationUpdate", dataProvider = "provider", description = "企业信息变更")
    public void lanmaoGatewayFacade_enterpriseInformationUpdate(Params params) {
        String actual = this.lanmaoGatewayFacade_enterpriseInformationUpdate(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/enterpriseRegister", dataProvider = "provider", description = "企业绑卡注册")
    public void lanmaoGatewayFacade_enterpriseRegister(Params params) {
        String actual = this.lanmaoGatewayFacade_enterpriseRegister(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/modifyMobile", dataProvider = "provider", description = "预留手机号更新")
    public void lanmaoGatewayFacade_modifyMobile(Params params) {
        String actual = this.lanmaoGatewayFacade_modifyMobile(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/personalBindBankcardExpand", dataProvider = "provider", description = "个人换绑卡")
    public void lanmaoGatewayFacade_personalBindBankcardExpand(Params params) {
        String actual = this.lanmaoGatewayFacade_personalBindBankcardExpand(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/personalRegister", dataProvider = "provider", description = "个人绑卡注册")
    public void lanmaoGatewayFacade_personalRegister(Params params) {
        String actual = this.lanmaoGatewayFacade_personalRegister(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/queryUserInformation", dataProvider = "provider", description = "用户信息查询")
    public void lanmaoGatewayFacade_queryUserInformation(Params params) {
        String actual = this.lanmaoGatewayFacade_queryUserInformation(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/resetPassword", dataProvider = "provider", description = "修改密码")
    public void lanmaoGatewayFacade_resetPassword(Params params) {
        String actual = this.lanmaoGatewayFacade_resetPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/lanmaoGatewayFacade/userAuthorization", dataProvider = "provider", description = "用户授权")
    public void lanmaoGatewayFacade_userAuthorization(Params params) {
        String actual = this.lanmaoGatewayFacade_userAuthorization(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanQuotaFacade/freezeLoanAmount", dataProvider = "provider", description = "冻结借款额度")
    public void loanQuotaFacade_freezeLoanAmount(Params params) {
        String actual = this.loanQuotaFacade_freezeLoanAmount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanQuotaFacade/queryLoanQuota", dataProvider = "provider", description = "借款额度查询")
    public void loanQuotaFacade_queryLoanQuota(Params params) {
        String actual = this.loanQuotaFacade_queryLoanQuota(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanQuotaFacade/returnLoanAmount", dataProvider = "provider", description = "归还额度")
    public void loanQuotaFacade_returnLoanAmount(Params params) {
        String actual = this.loanQuotaFacade_returnLoanAmount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanQuotaFacade/unfreezeLoanAmount", dataProvider = "provider", description = "解冻借款额度")
    public void loanQuotaFacade_unfreezeLoanAmount(Params params) {
        String actual = this.loanQuotaFacade_unfreezeLoanAmount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loanQuotaFacade/useLoanAmount", dataProvider = "provider", description = "使用额度")
    public void loanQuotaFacade_useLoanAmount(Params params) {
        String actual = this.loanQuotaFacade_useLoanAmount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/generateCode", dataProvider = "provider", description = "验证码生成接口")
    public void loginFacade_generateCode(Params params) {
        String actual = this.loginFacade_generateCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/getUserInfoByToken", dataProvider = "provider", description = "根据登录token获取用户信息")
    public void loginFacade_getUserInfoByToken(Params params) {
        String actual = this.loginFacade_getUserInfoByToken(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/inLoginRisk", dataProvider = "provider", description = "登录风险控制内部接口")
    public void loginFacade_inLoginRisk(Params params) {
        String actual = this.loginFacade_inLoginRisk(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/inRegisterRisk", dataProvider = "provider", description = "注册风险控制内部接口")
    public void loginFacade_inRegisterRisk(Params params) {
        String actual = this.loginFacade_inRegisterRisk(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/login", dataProvider = "provider", description = "非投资用户登录")
    public void loginFacade_login(Params params) {
        String actual = this.loginFacade_login(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/logout", dataProvider = "provider", description = "账号退出")
    public void loginFacade_logout(Params params) {
        String actual = this.loginFacade_logout(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/regist", dataProvider = "provider", description = "账号注册")
    public void loginFacade_regist(Params params) {
        String actual = this.loginFacade_regist(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/sendEmailAuthCode", dataProvider = "provider", description = "发送邮箱验证码")
    public void loginFacade_sendEmailAuthCode(Params params) {
        String actual = this.loginFacade_sendEmailAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/sendMobileAuthCode", dataProvider = "provider", description = "发送手机验证码")
    public void loginFacade_sendMobileAuthCode(Params params) {
        String actual = this.loginFacade_sendMobileAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/sendMobileAuthCodeByToken", dataProvider = "provider", description = "根据校验码token发送验证码")
    public void loginFacade_sendMobileAuthCodeByToken(Params params) {
        String actual = this.loginFacade_sendMobileAuthCodeByToken(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/updateBindingMobile", dataProvider = "provider", description = "修改绑定手机号")
    public void loginFacade_updateBindingMobile(Params params) {
        String actual = this.loginFacade_updateBindingMobile(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/updateLoginPassword", dataProvider = "provider", description = "修改登录密码")
    public void loginFacade_updateLoginPassword(Params params) {
        String actual = this.loginFacade_updateLoginPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/updateLoginPasswordByOriginPassword", dataProvider = "provider", description = "根据原密码修改登录密码")
    public void loginFacade_updateLoginPasswordByOriginPassword(Params params) {
        String actual = this.loginFacade_updateLoginPasswordByOriginPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/validateEmailAuthCode", dataProvider = "provider", description = "验证邮箱验证码")
    public void loginFacade_validateEmailAuthCode(Params params) {
        String actual = this.loginFacade_validateEmailAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/validateIdCardNo", dataProvider = "provider", description = "校验身份证号码")
    public void loginFacade_validateIdCardNo(Params params) {
        String actual = this.loginFacade_validateIdCardNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/loginFacade/validateMobileAuthCode", dataProvider = "provider", description = "验证手机验证码")
    public void loginFacade_validateMobileAuthCode(Params params) {
        String actual = this.loginFacade_validateMobileAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/nonInvestorFacade/getPlatformUserInfoByUserNo", dataProvider = "provider", description = "根据平台用户编号查询平台用户信息")
    public void nonInvestorFacade_getPlatformUserInfoByUserNo(Params params) {
        String actual = this.nonInvestorFacade_getPlatformUserInfoByUserNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/nonInvestorFacade/setSubRole", dataProvider = "provider", description = "设置二级角色")
    public void nonInvestorFacade_setSubRole(Params params) {
        String actual = this.nonInvestorFacade_setSubRole(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/nonInvestorFacade/setSubRoleByLoginName", dataProvider = "provider", description = "根据用户名设置二级角色")
    public void nonInvestorFacade_setSubRoleByLoginName(Params params) {
        String actual = this.nonInvestorFacade_setSubRoleByLoginName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/oauthFacade/getAccessCode", dataProvider = "provider", description = "获取access_code")
    public void oauthFacade_getAccessCode(Params params) {
        String actual = this.oauthFacade_getAccessCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/oauthFacade/getUserIdByToken", dataProvider = "provider", description = "根据token获取用户ID")
    public void oauthFacade_getUserIdByToken(Params params) {
        String actual = this.oauthFacade_getUserIdByToken(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/oauthFacade/queryTokenByAccessCode", dataProvider = "provider", description = "根据access_code获取token")
    public void oauthFacade_queryTokenByAccessCode(Params params) {
        String actual = this.oauthFacade_queryTokenByAccessCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/oauthFacade/refreshAccessToken", dataProvider = "provider", description = "根据refreshToken刷新accessToken")
    public void oauthFacade_refreshAccessToken(Params params) {
        String actual = this.oauthFacade_refreshAccessToken(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/oauthFacade/validateOauthClient", dataProvider = "provider", description = "验证客户端")
    public void oauthFacade_validateOauthClient(Params params) {
        String actual = this.oauthFacade_validateOauthClient(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/riskManagermentFacade/cardModigyRiskManager", dataProvider = "provider", description = "银行卡切换风险控制")
    public void riskManagermentFacade_cardModigyRiskManager(Params params) {
        String actual = this.riskManagermentFacade_cardModigyRiskManager(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/riskManagermentFacade/loginRiskManager", dataProvider = "provider", description = "登录风险控制")
    public void riskManagermentFacade_loginRiskManager(Params params) {
        String actual = this.riskManagermentFacade_loginRiskManager(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/riskManagermentFacade/openDepositoryRiskManager", dataProvider = "provider", description = "开通存管风险控制")
    public void riskManagermentFacade_openDepositoryRiskManager(Params params) {
        String actual = this.riskManagermentFacade_openDepositoryRiskManager(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/riskManagermentFacade/registerRiskManager", dataProvider = "provider", description = "注册风险控制")
    public void riskManagermentFacade_registerRiskManager(Params params) {
        String actual = this.riskManagermentFacade_registerRiskManager(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userCommonFacade/clearCache", dataProvider = "provider", description = "根据缓存key清理缓存")
    public void userCommonFacade_clearCache(Params params) {
        String actual = this.userCommonFacade_clearCache(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userCommonFacade/getAllCacheNames", dataProvider = "provider", description = "获取所有的缓存名称")
    public void userCommonFacade_getAllCacheNames(Params params) {
        String actual = this.userCommonFacade_getAllCacheNames(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userCommonFacade/viewCacheDetail", dataProvider = "provider", description = "查看缓存值")
    public void userCommonFacade_viewCacheDetail(Params params) {
        String actual = this.userCommonFacade_viewCacheDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/addUserExtraInfo", dataProvider = "provider", description = "添加借款人附加信息")
    public void userConsoleFacade_addUserExtraInfo(Params params) {
        String actual = this.userConsoleFacade_addUserExtraInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/deleteUserExtraAttachment", dataProvider = "provider", description = "删除借款人附加附件")
    public void userConsoleFacade_deleteUserExtraAttachment(Params params) {
        String actual = this.userConsoleFacade_deleteUserExtraAttachment(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/executeTask", dataProvider = "provider", description = "执行任务")
    public void userConsoleFacade_executeTask(Params params) {
        String actual = this.userConsoleFacade_executeTask(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/getAllAccountType", dataProvider = "provider", description = "查询所有的账务类型")
    public void userConsoleFacade_getAllAccountType(Params params) {
        String actual = this.userConsoleFacade_getAllAccountType(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/getBankAuditDetail", dataProvider = "provider", description = "查询银行卡审核详细信息")
    public void userConsoleFacade_getBankAuditDetail(Params params) {
        String actual = this.userConsoleFacade_getBankAuditDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/queryAccountflow", dataProvider = "provider", description = "账单查询-后端使用")
    public void userConsoleFacade_queryAccountflow(Params params) {
        String actual = this.userConsoleFacade_queryAccountflow(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/queryAuthUsers", dataProvider = "provider", description = "查询授权用户")
    public void userConsoleFacade_queryAuthUsers(Params params) {
        String actual = this.userConsoleFacade_queryAuthUsers(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/queryBankAuditList", dataProvider = "provider", description = "查询银行卡审核记录列表")
    public void userConsoleFacade_queryBankAuditList(Params params) {
        String actual = this.userConsoleFacade_queryBankAuditList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/queryEnterpriseDetail", dataProvider = "provider", description = "根据用户id查询用户详细信息")
    public void userConsoleFacade_queryEnterpriseDetail(Params params) {
        String actual = this.userConsoleFacade_queryEnterpriseDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/queryPersonalDetail", dataProvider = "provider", description = "根据用户id查询用户详细信息")
    public void userConsoleFacade_queryPersonalDetail(Params params) {
        String actual = this.userConsoleFacade_queryPersonalDetail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/queryUserList", dataProvider = "provider", description = "根据条件查询用户列表")
    public void userConsoleFacade_queryUserList(Params params) {
        String actual = this.userConsoleFacade_queryUserList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/resetWrongTimes", dataProvider = "provider", description = "置密码错误次数")
    public void userConsoleFacade_resetWrongTimes(Params params) {
        String actual = this.userConsoleFacade_resetWrongTimes(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/riskAudit", dataProvider = "provider", description = "风控审核")
    public void userConsoleFacade_riskAudit(Params params) {
        String actual = this.userConsoleFacade_riskAudit(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/upateUserState", dataProvider = "provider", description = "更改用户状态")
    public void userConsoleFacade_upateUserState(Params params) {
        String actual = this.userConsoleFacade_upateUserState(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/uploadBankAuditFile", dataProvider = "provider", description = "上传审核附件")
    public void userConsoleFacade_uploadBankAuditFile(Params params) {
        String actual = this.userConsoleFacade_uploadBankAuditFile(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userConsoleFacade/uploadImageFile", dataProvider = "provider", description = "no desc")
    public void userConsoleFacade_uploadImageFile(Params params) {
        String actual = this.userConsoleFacade_uploadImageFile(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/checkBankCardAudit", dataProvider = "provider", description = "检查用户换绑卡审核记录状态")
    public void userFacade_checkBankCardAudit(Params params) {
        String actual = this.userFacade_checkBankCardAudit(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/checkEnterpriseUpdateProcess", dataProvider = "provider", description = "检查企业修改信息审核记录状态")
    public void userFacade_checkEnterpriseUpdateProcess(Params params) {
        String actual = this.userFacade_checkEnterpriseUpdateProcess(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/checkLoginNameExists", dataProvider = "provider", description = "检查用户名是否存在")
    public void userFacade_checkLoginNameExists(Params params) {
        String actual = this.userFacade_checkLoginNameExists(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getAuth", dataProvider = "provider", description = "根据用户id查询授权信息")
    public void userFacade_getAuth(Params params) {
        String actual = this.userFacade_getAuth(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getBankCardBindingList", dataProvider = "provider", description = "根据用户id查询绑卡列表(适用于个人,企业)")
    public void userFacade_getBankCardBindingList(Params params) {
        String actual = this.userFacade_getBankCardBindingList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getBaseInfoByUserIds", dataProvider = "provider", description = "批量查询用户基本信息")
    public void userFacade_getBaseInfoByUserIds(Params params) {
        String actual = this.userFacade_getBaseInfoByUserIds(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getEnterpriseInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询企业信息")
    public void userFacade_getEnterpriseInfoByLoginName(Params params) {
        String actual = this.userFacade_getEnterpriseInfoByLoginName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getEnterpriseInfoByUserId", dataProvider = "provider", description = "根据用户id查询企业信息")
    public void userFacade_getEnterpriseInfoByUserId(Params params) {
        String actual = this.userFacade_getEnterpriseInfoByUserId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getInvestProfit", dataProvider = "provider", description = "获得用户收益")
    public void userFacade_getInvestProfit(Params params) {
        String actual = this.userFacade_getInvestProfit(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getPersonalInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询个人信息")
    public void userFacade_getPersonalInfoByLoginName(Params params) {
        String actual = this.userFacade_getPersonalInfoByLoginName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getPersonalInfoByUserId", dataProvider = "provider", description = "根据用户id查询个人信息")
    public void userFacade_getPersonalInfoByUserId(Params params) {
        String actual = this.userFacade_getPersonalInfoByUserId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getPersonalRealName", dataProvider = "provider", description = "根据用户id查询个人实名信息")
    public void userFacade_getPersonalRealName(Params params) {
        String actual = this.userFacade_getPersonalRealName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getPersonalRealNameByUserIds", dataProvider = "provider", description = "批量查询个人实名信息")
    public void userFacade_getPersonalRealNameByUserIds(Params params) {
        String actual = this.userFacade_getPersonalRealNameByUserIds(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getUnionUserByLoginName", dataProvider = "provider", description = "根据登陆名查询UnionUser")
    public void userFacade_getUnionUserByLoginName(Params params) {
        String actual = this.userFacade_getUnionUserByLoginName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getUserExtraInfo", dataProvider = "provider", description = "获取借款人附加信息")
    public void userFacade_getUserExtraInfo(Params params) {
        String actual = this.userFacade_getUserExtraInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getUserIdWithSameIdCardNo", dataProvider = "provider", description = "根据证件类型+证件号查询全部的个人userId")
    public void userFacade_getUserIdWithSameIdCardNo(Params params) {
        String actual = this.userFacade_getUserIdWithSameIdCardNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getUserInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询基本信息")
    public void userFacade_getUserInfoByLoginName(Params params) {
        String actual = this.userFacade_getUserInfoByLoginName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getUserInfoByUserId", dataProvider = "provider", description = "根据用户id查询基本信息")
    public void userFacade_getUserInfoByUserId(Params params) {
        String actual = this.userFacade_getUserInfoByUserId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getUserProperty", dataProvider = "provider", description = "获得用户资产统计")
    public void userFacade_getUserProperty(Params params) {
        String actual = this.userFacade_getUserProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getZDEnterpriseState", dataProvider = "provider", description = "根据登陆名和银行卡号查询企业状态(适用于显性开户)")
    public void userFacade_getZDEnterpriseState(Params params) {
        String actual = this.userFacade_getZDEnterpriseState(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/getZDPersonalState", dataProvider = "provider", description = "根据用户证件号+银行卡号+渠道标识查询个人状态(适用于显性开户)")
    public void userFacade_getZDPersonalState(Params params) {
        String actual = this.userFacade_getZDPersonalState(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/initInvestorUser", dataProvider = "provider", description = "初始化投资用户")
    public void userFacade_initInvestorUser(Params params) {
        String actual = this.userFacade_initInvestorUser(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/isCunguanTestingUser", dataProvider = "provider", description = "是否是存管测试用户")
    public void userFacade_isCunguanTestingUser(Params params) {
        String actual = this.userFacade_isCunguanTestingUser(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/queryBankList", dataProvider = "provider", description = "查询银行卡列表")
    public void userFacade_queryBankList(Params params) {
        String actual = this.userFacade_queryBankList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/updateEnterpriseBankCardInfo", dataProvider = "provider", description = "新增或更新企业银行卡信息")
    public void userFacade_updateEnterpriseBankCardInfo(Params params) {
        String actual = this.userFacade_updateEnterpriseBankCardInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/updateEnterpriseBaseInfo", dataProvider = "provider", description = "新增或更新企业基本信息")
    public void userFacade_updateEnterpriseBaseInfo(Params params) {
        String actual = this.userFacade_updateEnterpriseBaseInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/updateEnterpriseLegalInfo", dataProvider = "provider", description = "新增或更新企业法人信息")
    public void userFacade_updateEnterpriseLegalInfo(Params params) {
        String actual = this.userFacade_updateEnterpriseLegalInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/updateGroupId", dataProvider = "provider", description = "根据userId更新groupId")
    public void userFacade_updateGroupId(Params params) {
        String actual = this.userFacade_updateGroupId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/updateUserInfo", dataProvider = "provider", description = "更新用户信息(适用于更新绑定手机,企业联系人,企业联系人手机,银行卡,银行预留手机)")
    public void userFacade_updateUserInfo(Params params) {
        String actual = this.userFacade_updateUserInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/userFacade/verifyPasswordByRequestNo", dataProvider = "provider", description = "根据请求号验证密码")
    public void userFacade_verifyPasswordByRequestNo(Params params) {
        String actual = this.userFacade_verifyPasswordByRequestNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

}
