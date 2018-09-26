package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.MemberBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: MemberDefaultTest
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@Slf4j
public class MemberDefaultTest extends MemberBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    public MemberDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }
    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/bankCardFacade/getBankChannel", dataProvider = "provider", description = "根据银行代码和支付金额获取银行渠道")
    public void bankCardFacade_getBankChannel(HryTest hryTest) {
        String actual = super._bankCardFacade_getBankChannel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/queryBankLimitsWithCunguanBankCode", dataProvider = "provider", description = "收银服务限额限次查询和存管银行代码")
    public void bankCardFacade_queryBankLimitsWithCunguanBankCode(HryTest hryTest) {
        String actual = super._bankCardFacade_queryBankLimitsWithCunguanBankCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/createRegisterContract", dataProvider = "provider", description = "创建注册合同")
    public void customerFacade_createRegisterContract(HryTest hryTest) {
        String actual = super._customerFacade_createRegisterContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/createRegisterContractBatch", dataProvider = "provider", description = "批量创建已同意的注册合同")
    public void customerFacade_createRegisterContractBatch(HryTest hryTest) {
        String actual = super._customerFacade_createRegisterContractBatch(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/generateCode", dataProvider = "provider", description = "验证码生成接口")
    public void customerFacade_generateCode(HryTest hryTest) {
        String actual = super._customerFacade_generateCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getKjtUserInfoByHryId", dataProvider = "provider", description = "根据hryId查询kjt用户信息")
    public void customerFacade_getKjtUserInfoByHryId(HryTest hryTest) {
        String actual = super._customerFacade_getKjtUserInfoByHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getRiskAssessmentQuestions", dataProvider = "provider", description = "获取风险测评问题")
    public void customerFacade_getRiskAssessmentQuestions(HryTest hryTest) {
        String actual = super._customerFacade_getRiskAssessmentQuestions(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getUserIdByToken", dataProvider = "provider", description = "根据token获取用户hryId和kjtId")
    public void customerFacade_getUserIdByToken(HryTest hryTest) {
        String actual = super._customerFacade_getUserIdByToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getUserRiskAssessmentLevel", dataProvider = "provider", description = "获取用户风险测评结果")
    public void customerFacade_getUserRiskAssessmentLevel(HryTest hryTest) {
        String actual = super._customerFacade_getUserRiskAssessmentLevel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/login", dataProvider = "provider", description = "登录接口")
    public void customerFacade_login(HryTest hryTest) {
        String actual = super._customerFacade_login(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/logout", dataProvider = "provider", description = "账号退出")
    public void customerFacade_logout(HryTest hryTest) {
        String actual = super._customerFacade_logout(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/moveCaptialCalendar", dataProvider = "provider", description = "移动资金日历数据到历史库")
    public void customerFacade_moveCaptialCalendar(HryTest hryTest) {
        String actual = super._customerFacade_moveCaptialCalendar(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/queryCaptialCalendar", dataProvider = "provider", description = "获取资金日历")
    public void customerFacade_queryCaptialCalendar(HryTest hryTest) {
        String actual = super._customerFacade_queryCaptialCalendar(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/queryRegisterContract", dataProvider = "provider", description = "查询用户注册合同")
    public void customerFacade_queryRegisterContract(HryTest hryTest) {
        String actual = super._customerFacade_queryRegisterContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/sendEmailAuthCode", dataProvider = "provider", description = "发送邮箱验证码")
    public void customerFacade_sendEmailAuthCode(HryTest hryTest) {
        String actual = super._customerFacade_sendEmailAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/sendMobileAuthCode", dataProvider = "provider", description = "发送手机验证码")
    public void customerFacade_sendMobileAuthCode(HryTest hryTest) {
        String actual = super._customerFacade_sendMobileAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/setUserRiskAssessmentLevel", dataProvider = "provider", description = "设置用户风险测评结果")
    public void customerFacade_setUserRiskAssessmentLevel(HryTest hryTest) {
        String actual = super._customerFacade_setUserRiskAssessmentLevel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updateLoginPassword", dataProvider = "provider", description = "修改登录密码")
    public void customerFacade_updateLoginPassword(HryTest hryTest) {
        String actual = super._customerFacade_updateLoginPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updateLoginPasswordByAuthToken", dataProvider = "provider", description = "根据验证有效token修改登录密码")
    public void customerFacade_updateLoginPasswordByAuthToken(HryTest hryTest) {
        String actual = super._customerFacade_updateLoginPasswordByAuthToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updateRegisterContract", dataProvider = "provider", description = "创建已同意的注册合同")
    public void customerFacade_updateRegisterContract(HryTest hryTest) {
        String actual = super._customerFacade_updateRegisterContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/userRegister", dataProvider = "provider", description = "渠道用户注册")
    public void customerFacade_userRegister(HryTest hryTest) {
        String actual = super._customerFacade_userRegister(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/validateEmailAuthCode", dataProvider = "provider", description = "验证邮箱验证码")
    public void customerFacade_validateEmailAuthCode(HryTest hryTest) {
        String actual = super._customerFacade_validateEmailAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/validateMobileAuthCode", dataProvider = "provider", description = "验证手机验证码")
    public void customerFacade_validateMobileAuthCode(HryTest hryTest) {
        String actual = super._customerFacade_validateMobileAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/kjtGatewayFacade/execute", dataProvider = "provider", description = "kjt会员接口统一封装")
    public void kjtGatewayFacade_execute(HryTest hryTest) {
        String actual = super._kjtGatewayFacade_execute(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/kjtGatewayFacade/getKjtIdByLoginName", dataProvider = "provider", description = "根据登录名查询KJT ID")
    public void kjtGatewayFacade_getKjtIdByLoginName(HryTest hryTest) {
        String actual = super._kjtGatewayFacade_getKjtIdByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/batchOpenCustodyAccount", dataProvider = "provider", description = "批量开通存管户")
    public void memberFacade_batchOpenCustodyAccount(HryTest hryTest) {
        String actual = super._memberFacade_batchOpenCustodyAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/checkCustodyAccountStatus", dataProvider = "provider", description = "查询存管户状态")
    public void memberFacade_checkCustodyAccountStatus(HryTest hryTest) {
        String actual = super._memberFacade_checkCustodyAccountStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getHryIdFromMemberId", dataProvider = "provider", description = "根据kjtId查询hryId")
    public void memberFacade_getHryIdFromMemberId(HryTest hryTest) {
        String actual = super._memberFacade_getHryIdFromMemberId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getKjtProperty", dataProvider = "provider", description = "获取用户kjt方面资产信息")
    public void memberFacade_getKjtProperty(HryTest hryTest) {
        String actual = super._memberFacade_getKjtProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getLcjStatisticsByStatus", dataProvider = "provider", description = "根据状态统计理财金信息")
    public void memberFacade_getLcjStatisticsByStatus(HryTest hryTest) {
        String actual = super._memberFacade_getLcjStatisticsByStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getMemberByHryId", dataProvider = "provider", description = "根据hryId获取用户信息(从hry数据库获取信息，包括外籍用户)")
    public void memberFacade_getMemberByHryId(HryTest hryTest) {
        String actual = super._memberFacade_getMemberByHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getProperty", dataProvider = "provider", description = "获取用户资产信息,目前只提供理财金、基金份额查询")
    public void memberFacade_getProperty(HryTest hryTest) {
        String actual = super._memberFacade_getProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryCunguanBankInfoByCardNo", dataProvider = "provider", description = "根据卡号查询存管支持银行信息")
    public void memberFacade_queryCunguanBankInfoByCardNo(HryTest hryTest) {
        String actual = super._memberFacade_queryCunguanBankInfoByCardNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryLcjListByStatus", dataProvider = "provider", description = "根据状态获取理财金详情")
    public void memberFacade_queryLcjListByStatus(HryTest hryTest) {
        String actual = super._memberFacade_queryLcjListByStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryMemberStatusInfo", dataProvider = "provider", description = "查询用户状态信息(包括外籍用户)")
    public void memberFacade_queryMemberStatusInfo(HryTest hryTest) {
        String actual = super._memberFacade_queryMemberStatusInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryUserGroupInfo", dataProvider = "provider", description = "查询用户组的信息")
    public void memberFacade_queryUserGroupInfo(HryTest hryTest) {
        String actual = super._memberFacade_queryUserGroupInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/sendMessage", dataProvider = "provider", description = "发送站内信")
    public void memberFacade_sendMessage(HryTest hryTest) {
        String actual = super._memberFacade_sendMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/sendMobileVerificationCode", dataProvider = "provider", description = "发送手机校验码")
    public void memberFacade_sendMobileVerificationCode(HryTest hryTest) {
        String actual = super._memberFacade_sendMobileVerificationCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageFacade/getMessageInfoList", dataProvider = "provider", description = "获取信息列表")
    public void messageFacade_getMessageInfoList(HryTest hryTest) {
        String actual = super._messageFacade_getMessageInfoList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageFacade/setMessageToRead", dataProvider = "provider", description = "设置信息为已读")
    public void messageFacade_setMessageToRead(HryTest hryTest) {
        String actual = super._messageFacade_setMessageToRead(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sessionFacade/getCurrentMember", dataProvider = "provider", description = "根据token从Session中获取用户信息")
    public void sessionFacade_getCurrentMember(HryTest hryTest) {
        String actual = super._sessionFacade_getCurrentMember(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sessionFacade/initUser", dataProvider = "provider", description = "初始化用户信息")
    public void sessionFacade_initUser(HryTest hryTest) {
        String actual = super._sessionFacade_initUser(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sessionFacade/initUserByUserInfo", dataProvider = "provider", description = "初始化用户信息")
    public void sessionFacade_initUserByUserInfo(HryTest hryTest) {
        String actual = super._sessionFacade_initUserByUserInfo(hryTest);
        supperAssert(actual, hryTest);
    }

}
