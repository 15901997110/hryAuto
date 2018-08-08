package com.haier.testng.test;

import com.haier.po.Params;
import com.haier.testng.base.MemberBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: MemberTestDefault
 * @Author: 自动生成
 * @Date: 2018/08/08 17:27:09
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class MemberTestDefault extends MemberBase {
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        init(serviceId, envId, caseDesigner, i_c);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/bankCardFacade/addBankCardForForeigner", dataProvider = "provider", description = "外籍用户添加银行卡(只限港澳台和外籍用户)")
    public void bankCardFacade_addBankCardForForeigner(Params params) {
        String actual = this.bankCardFacade_addBankCardForForeigner(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/bindBankCard", dataProvider = "provider", description = "绑定银行卡")
    public void bankCardFacade_bindBankCard(Params params) {
        String actual = this.bankCardFacade_bindBankCard(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/bindQuickBankCardSign", dataProvider = "provider", description = "绑定快捷卡签约推进")
    public void bankCardFacade_bindQuickBankCardSign(Params params) {
        String actual = this.bankCardFacade_bindQuickBankCardSign(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/checkUserBindCard", dataProvider = "provider", description = "查询用户是否绑过银行卡")
    public void bankCardFacade_checkUserBindCard(Params params) {
        String actual = this.bankCardFacade_checkUserBindCard(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/queryBankCardInfoForForeigner", dataProvider = "provider", description = "查询外籍用户最近添加的银行卡(只限港澳台和外籍用户)")
    public void bankCardFacade_queryBankCardInfoForForeigner(Params params) {
        String actual = this.bankCardFacade_queryBankCardInfoForForeigner(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/queryBankLimits", dataProvider = "provider", description = "收银服务限额限次查询")
    public void bankCardFacade_queryBankLimits(Params params) {
        String actual = this.bankCardFacade_queryBankLimits(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/queryBankLimitsWithCunguanBankCode", dataProvider = "provider", description = "收银服务限额限次查询和存管银行代码")
    public void bankCardFacade_queryBankLimitsWithCunguanBankCode(Params params) {
        String actual = this.bankCardFacade_queryBankLimitsWithCunguanBankCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/queryBranch", dataProvider = "provider", description = "查询分支行信息")
    public void bankCardFacade_queryBranch(Params params) {
        String actual = this.bankCardFacade_queryBranch(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/queryProvinceAndCity", dataProvider = "provider", description = "查询所有省市信息")
    public void bankCardFacade_queryProvinceAndCity(Params params) {
        String actual = this.bankCardFacade_queryProvinceAndCity(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/querySupportBank", dataProvider = "provider", description = "查询支持的出款银行")
    public void bankCardFacade_querySupportBank(Params params) {
        String actual = this.bankCardFacade_querySupportBank(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/querySupportedKJCards", dataProvider = "provider", description = "查询支持快捷卡的银行")
    public void bankCardFacade_querySupportedKJCards(Params params) {
        String actual = this.bankCardFacade_querySupportedKJCards(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/bankCardFacade/queryUserBindCards", dataProvider = "provider", description = "查询用户绑定的银行卡")
    public void bankCardFacade_queryUserBindCards(Params params) {
        String actual = this.bankCardFacade_queryUserBindCards(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/consumerFinanceFacade/checkConsumerFinanceStatus", dataProvider = "provider", description = "查询消费金融状态")
    public void consumerFinanceFacade_checkConsumerFinanceStatus(Params params) {
        String actual = this.consumerFinanceFacade_checkConsumerFinanceStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/consumerFinanceFacade/getIdCardImages", dataProvider = "provider", description = "下载会员影印件")
    public void consumerFinanceFacade_getIdCardImages(Params params) {
        String actual = this.consumerFinanceFacade_getIdCardImages(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/consumerFinanceFacade/openConsumerFinance", dataProvider = "provider", description = "开通消费金融")
    public void consumerFinanceFacade_openConsumerFinance(Params params) {
        String actual = this.consumerFinanceFacade_openConsumerFinance(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/consumerFinanceFacade/queryUserBasicInfo", dataProvider = "provider", description = "查询用户基本信息")
    public void consumerFinanceFacade_queryUserBasicInfo(Params params) {
        String actual = this.consumerFinanceFacade_queryUserBasicInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/consumerFinanceFacade/queryUserCreditLimit", dataProvider = "provider", description = "查询用户贷款额度信息")
    public void consumerFinanceFacade_queryUserCreditLimit(Params params) {
        String actual = this.consumerFinanceFacade_queryUserCreditLimit(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/consumerFinanceFacade/updateUserCreditLimit", dataProvider = "provider", description = "更新用户贷款额度信息")
    public void consumerFinanceFacade_updateUserCreditLimit(Params params) {
        String actual = this.consumerFinanceFacade_updateUserCreditLimit(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/addBankContact", dataProvider = "provider", description = "添加银行联系人信息")
    public void customerFacade_addBankContact(Params params) {
        String actual = this.customerFacade_addBankContact(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/addKjtContacts", dataProvider = "provider", description = "添加快捷通联系人")
    public void customerFacade_addKjtContacts(Params params) {
        String actual = this.customerFacade_addKjtContacts(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/applyResetMerchantLoginPassword", dataProvider = "provider", description = "商户登录密码重设申请")
    public void customerFacade_applyResetMerchantLoginPassword(Params params) {
        String actual = this.customerFacade_applyResetMerchantLoginPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/bindEmail", dataProvider = "provider", description = "绑定邮箱")
    public void customerFacade_bindEmail(Params params) {
        String actual = this.customerFacade_bindEmail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/createRegisterContract", dataProvider = "provider", description = "创建注册合同")
    public void customerFacade_createRegisterContract(Params params) {
        String actual = this.customerFacade_createRegisterContract(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/createRegisterContractBatch", dataProvider = "provider", description = "批量创建已同意的注册合同")
    public void customerFacade_createRegisterContractBatch(Params params) {
        String actual = this.customerFacade_createRegisterContractBatch(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/deleteContact", dataProvider = "provider", description = "删除联系人信息")
    public void customerFacade_deleteContact(Params params) {
        String actual = this.customerFacade_deleteContact(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/generateCode", dataProvider = "provider", description = "验证码生成接口")
    public void customerFacade_generateCode(Params params) {
        String actual = this.customerFacade_generateCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getCapitalAccountInfo", dataProvider = "provider", description = "查询企业资金账户信息")
    public void customerFacade_getCapitalAccountInfo(Params params) {
        String actual = this.customerFacade_getCapitalAccountInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getCorporationInfo", dataProvider = "provider", description = "获取法人信息")
    public void customerFacade_getCorporationInfo(Params params) {
        String actual = this.customerFacade_getCorporationInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getEnterpriseCertificationInfo", dataProvider = "provider", description = "查询企业实名认证信息")
    public void customerFacade_getEnterpriseCertificationInfo(Params params) {
        String actual = this.customerFacade_getEnterpriseCertificationInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getKjtUserInfoByHryId", dataProvider = "provider", description = "根据hryId查询kjt用户信息")
    public void customerFacade_getKjtUserInfoByHryId(Params params) {
        String actual = this.customerFacade_getKjtUserInfoByHryId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getRiskAssessmentQuestions", dataProvider = "provider", description = "获取风险测评问题")
    public void customerFacade_getRiskAssessmentQuestions(Params params) {
        String actual = this.customerFacade_getRiskAssessmentQuestions(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getUserAccountListById", dataProvider = "provider", description = "根据某一账户id获取该实名用户所有账户列表")
    public void customerFacade_getUserAccountListById(Params params) {
        String actual = this.customerFacade_getUserAccountListById(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getUserIdByToken", dataProvider = "provider", description = "根据token获取用户hryId和kjtId")
    public void customerFacade_getUserIdByToken(Params params) {
        String actual = this.customerFacade_getUserIdByToken(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/getUserRiskAssessmentLevel", dataProvider = "provider", description = "获取用户风险测评结果")
    public void customerFacade_getUserRiskAssessmentLevel(Params params) {
        String actual = this.customerFacade_getUserRiskAssessmentLevel(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/login", dataProvider = "provider", description = "登录接口")
    public void customerFacade_login(Params params) {
        String actual = this.customerFacade_login(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/loginFinancingMerchant", dataProvider = "provider", description = "商户登录接口")
    public void customerFacade_loginFinancingMerchant(Params params) {
        String actual = this.customerFacade_loginFinancingMerchant(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/logout", dataProvider = "provider", description = "账号退出")
    public void customerFacade_logout(Params params) {
        String actual = this.customerFacade_logout(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/moveCaptialCalendar", dataProvider = "provider", description = "移动资金日历数据到历史库")
    public void customerFacade_moveCaptialCalendar(Params params) {
        String actual = this.customerFacade_moveCaptialCalendar(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/queryCaptialCalendar", dataProvider = "provider", description = "获取资金日历")
    public void customerFacade_queryCaptialCalendar(Params params) {
        String actual = this.customerFacade_queryCaptialCalendar(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/queryContactList", dataProvider = "provider", description = "查询联系人列表")
    public void customerFacade_queryContactList(Params params) {
        String actual = this.customerFacade_queryContactList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/queryRegisterContract", dataProvider = "provider", description = "查询用户注册合同")
    public void customerFacade_queryRegisterContract(Params params) {
        String actual = this.customerFacade_queryRegisterContract(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/resetMerchantLoginPassword", dataProvider = "provider", description = "重设商户登录密码")
    public void customerFacade_resetMerchantLoginPassword(Params params) {
        String actual = this.customerFacade_resetMerchantLoginPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/saveCapitalAccountInfo", dataProvider = "provider", description = "保存企业资金账户信息")
    public void customerFacade_saveCapitalAccountInfo(Params params) {
        String actual = this.customerFacade_saveCapitalAccountInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/saveCorporationInfo", dataProvider = "provider", description = "保存法人信息")
    public void customerFacade_saveCorporationInfo(Params params) {
        String actual = this.customerFacade_saveCorporationInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/saveEnterpriseCertificationInfo", dataProvider = "provider", description = "保存企业实名认证信息")
    public void customerFacade_saveEnterpriseCertificationInfo(Params params) {
        String actual = this.customerFacade_saveEnterpriseCertificationInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/sendEmail", dataProvider = "provider", description = "发送邮件")
    public void customerFacade_sendEmail(Params params) {
        String actual = this.customerFacade_sendEmail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/sendEmailAuthCode", dataProvider = "provider", description = "发送邮箱验证码")
    public void customerFacade_sendEmailAuthCode(Params params) {
        String actual = this.customerFacade_sendEmailAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/sendMobileAuthCode", dataProvider = "provider", description = "发送手机验证码")
    public void customerFacade_sendMobileAuthCode(Params params) {
        String actual = this.customerFacade_sendMobileAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/setUserRiskAssessmentLevel", dataProvider = "provider", description = "设置用户风险测评结果")
    public void customerFacade_setUserRiskAssessmentLevel(Params params) {
        String actual = this.customerFacade_setUserRiskAssessmentLevel(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/unBindEmail", dataProvider = "provider", description = "解绑邮箱")
    public void customerFacade_unBindEmail(Params params) {
        String actual = this.customerFacade_unBindEmail(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/updateBindMobile", dataProvider = "provider", description = "修改绑定手机号")
    public void customerFacade_updateBindMobile(Params params) {
        String actual = this.customerFacade_updateBindMobile(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/updateLoginPassword", dataProvider = "provider", description = "修改登录密码")
    public void customerFacade_updateLoginPassword(Params params) {
        String actual = this.customerFacade_updateLoginPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/updateLoginPasswordByAuthToken", dataProvider = "provider", description = "根据验证有效token修改登录密码")
    public void customerFacade_updateLoginPasswordByAuthToken(Params params) {
        String actual = this.customerFacade_updateLoginPasswordByAuthToken(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/updatePayPassword", dataProvider = "provider", description = "修改支付密码")
    public void customerFacade_updatePayPassword(Params params) {
        String actual = this.customerFacade_updatePayPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/updateRegisterContract", dataProvider = "provider", description = "创建已同意的注册合同")
    public void customerFacade_updateRegisterContract(Params params) {
        String actual = this.customerFacade_updateRegisterContract(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/uploadBase64Image", dataProvider = "provider", description = "上传图片")
    public void customerFacade_uploadBase64Image(Params params) {
        String actual = this.customerFacade_uploadBase64Image(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/vailedateEmailToken", dataProvider = "provider", description = "验证邮件中的token是否有效")
    public void customerFacade_vailedateEmailToken(Params params) {
        String actual = this.customerFacade_vailedateEmailToken(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/validateEmailAuthCode", dataProvider = "provider", description = "验证邮箱验证码")
    public void customerFacade_validateEmailAuthCode(Params params) {
        String actual = this.customerFacade_validateEmailAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/validateKjtAccounts", dataProvider = "provider", description = "校验快捷通账号是否存在")
    public void customerFacade_validateKjtAccounts(Params params) {
        String actual = this.customerFacade_validateKjtAccounts(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/validateMobileAuthCode", dataProvider = "provider", description = "验证手机验证码")
    public void customerFacade_validateMobileAuthCode(Params params) {
        String actual = this.customerFacade_validateMobileAuthCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/validatePayPassword", dataProvider = "provider", description = "验证支付密码")
    public void customerFacade_validatePayPassword(Params params) {
        String actual = this.customerFacade_validatePayPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/customerFacade/validateRealNameNum", dataProvider = "provider", description = "验证实名认证证件号")
    public void customerFacade_validateRealNameNum(Params params) {
        String actual = this.customerFacade_validateRealNameNum(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/dealerFacade/getDealerByDealerId", dataProvider = "provider", description = "根据经销商Id获取经销商信息")
    public void dealerFacade_getDealerByDealerId(Params params) {
        String actual = this.dealerFacade_getDealerByDealerId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/dealerFacade/getDealerByTaxNo", dataProvider = "provider", description = "根据税务登记证号获取经销商信息")
    public void dealerFacade_getDealerByTaxNo(Params params) {
        String actual = this.dealerFacade_getDealerByTaxNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/enterpriseFacade/getEnterpriseInfoByHryIdFromHry", dataProvider = "provider", description = "根据hryId获取企业用户信息")
    public void enterpriseFacade_getEnterpriseInfoByHryIdFromHry(Params params) {
        String actual = this.enterpriseFacade_getEnterpriseInfoByHryIdFromHry(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/enterpriseFacade/getEnterpriseKjtAccountInfoByLoginName", dataProvider = "provider", description = "根据登录名查询Kjt账户信息")
    public void enterpriseFacade_getEnterpriseKjtAccountInfoByLoginName(Params params) {
        String actual = this.enterpriseFacade_getEnterpriseKjtAccountInfoByLoginName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/fundIn", dataProvider = "provider", description = "基金开户并转入")
    public void fundFacade_fundIn(Params params) {
        String actual = this.fundFacade_fundIn(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/getUserStatisticsProfit", dataProvider = "provider", description = "历史收益查询")
    public void fundFacade_getUserStatisticsProfit(Params params) {
        String actual = this.fundFacade_getUserStatisticsProfit(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/getWithdrawCode", dataProvider = "provider", description = "获取提现手机验证码")
    public void fundFacade_getWithdrawCode(Params params) {
        String actual = this.fundFacade_getWithdrawCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/isOpenFund", dataProvider = "provider", description = "判断当前登录用户是否开通基金账户")
    public void fundFacade_isOpenFund(Params params) {
        String actual = this.fundFacade_isOpenFund(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/openFundAccount", dataProvider = "provider", description = "基金开户")
    public void fundFacade_openFundAccount(Params params) {
        String actual = this.fundFacade_openFundAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/queryAllQuickBankAccount", dataProvider = "provider", description = "查询会员绑定的所有快捷卡信息")
    public void fundFacade_queryAllQuickBankAccount(Params params) {
        String actual = this.fundFacade_queryAllQuickBankAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/queryBankAccount", dataProvider = "provider", description = "查询会员绑定的银行卡信息")
    public void fundFacade_queryBankAccount(Params params) {
        String actual = this.fundFacade_queryBankAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/queryFundOrder", dataProvider = "provider", description = "查询基金交易订单")
    public void fundFacade_queryFundOrder(Params params) {
        String actual = this.fundFacade_queryFundOrder(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/queryFundRates", dataProvider = "provider", description = "查询年化利率和万份收益信息")
    public void fundFacade_queryFundRates(Params params) {
        String actual = this.fundFacade_queryFundRates(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/queryProfitDate", dataProvider = "provider", description = "本次转入后收益发放时间")
    public void fundFacade_queryProfitDate(Params params) {
        String actual = this.fundFacade_queryProfitDate(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/queryWithdrawBankAccount", dataProvider = "provider", description = "查询会员可提现的银行卡信息")
    public void fundFacade_queryWithdrawBankAccount(Params params) {
        String actual = this.fundFacade_queryWithdrawBankAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundFacade/withdraw", dataProvider = "provider", description = "提现")
    public void fundFacade_withdraw(Params params) {
        String actual = this.fundFacade_withdraw(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/kjtGatewayFacade/execute", dataProvider = "provider", description = "kjt会员接口统一封装")
    public void kjtGatewayFacade_execute(Params params) {
        String actual = this.kjtGatewayFacade_execute(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/kjtGatewayFacade/getKjtIdByLoginName", dataProvider = "provider", description = "根据登录名查询KJT ID")
    public void kjtGatewayFacade_getKjtIdByLoginName(Params params) {
        String actual = this.kjtGatewayFacade_getKjtIdByLoginName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/batchOpenCustodyAccount", dataProvider = "provider", description = "批量开通存管户")
    public void memberFacade_batchOpenCustodyAccount(Params params) {
        String actual = this.memberFacade_batchOpenCustodyAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/bindingMobilephone", dataProvider = "provider", description = "绑定手机号(包括外籍用户)")
    public void memberFacade_bindingMobilephone(Params params) {
        String actual = this.memberFacade_bindingMobilephone(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/checkBindingMobilephone", dataProvider = "provider", description = "检查手机号是否能被绑定(包括外籍用户)")
    public void memberFacade_checkBindingMobilephone(Params params) {
        String actual = this.memberFacade_checkBindingMobilephone(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/checkCustodyAccountStatus", dataProvider = "provider", description = "查询存管户状态")
    public void memberFacade_checkCustodyAccountStatus(Params params) {
        String actual = this.memberFacade_checkCustodyAccountStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/checkPayPassword", dataProvider = "provider", description = "验证支付密码")
    public void memberFacade_checkPayPassword(Params params) {
        String actual = this.memberFacade_checkPayPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/checkWhetherLoginNameExists", dataProvider = "provider", description = "校验登陆名是否已经存在")
    public void memberFacade_checkWhetherLoginNameExists(Params params) {
        String actual = this.memberFacade_checkWhetherLoginNameExists(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getCompanyAuth", dataProvider = "provider", description = "获取企业会员权限")
    public void memberFacade_getCompanyAuth(Params params) {
        String actual = this.memberFacade_getCompanyAuth(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getHryIdFromMemberId", dataProvider = "provider", description = "根据kjtId查询hryId")
    public void memberFacade_getHryIdFromMemberId(Params params) {
        String actual = this.memberFacade_getHryIdFromMemberId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getIdVerificationStatus", dataProvider = "provider", description = "查询会员的身份认证状态")
    public void memberFacade_getIdVerificationStatus(Params params) {
        String actual = this.memberFacade_getIdVerificationStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getInvestmentProperty", dataProvider = "provider", description = "获取用户投资资产信息")
    public void memberFacade_getInvestmentProperty(Params params) {
        String actual = this.memberFacade_getInvestmentProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getKjtProperty", dataProvider = "provider", description = "获取用户kjt方面资产信息")
    public void memberFacade_getKjtProperty(Params params) {
        String actual = this.memberFacade_getKjtProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getLcjProperty", dataProvider = "provider", description = "获取用户理财金资产信息")
    public void memberFacade_getLcjProperty(Params params) {
        String actual = this.memberFacade_getLcjProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getLcjRecord", dataProvider = "provider", description = "获取用户理财金信息")
    public void memberFacade_getLcjRecord(Params params) {
        String actual = this.memberFacade_getLcjRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getLcjStatisticsByStatus", dataProvider = "provider", description = "根据状态统计理财金信息")
    public void memberFacade_getLcjStatisticsByStatus(Params params) {
        String actual = this.memberFacade_getLcjStatisticsByStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getMemberByHryId", dataProvider = "provider", description = "根据hryId获取用户信息(从hry数据库获取信息，包括外籍用户)")
    public void memberFacade_getMemberByHryId(Params params) {
        String actual = this.memberFacade_getMemberByHryId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getMemberCount", dataProvider = "provider", description = "获取平台所有用户数")
    public void memberFacade_getMemberCount(Params params) {
        String actual = this.memberFacade_getMemberCount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getMemberIdByCardIdAndHryId", dataProvider = "provider", description = "根据用户id获取身份证，然后通过身份证获取对应的绑定用户id(从hry数据库获取信息，包括外籍用户)")
    public void memberFacade_getMemberIdByCardIdAndHryId(Params params) {
        String actual = this.memberFacade_getMemberIdByCardIdAndHryId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getMemberVerifyInfo", dataProvider = "provider", description = "查询会员的认证信息")
    public void memberFacade_getMemberVerifyInfo(Params params) {
        String actual = this.memberFacade_getMemberVerifyInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getMemberVerifyLevel", dataProvider = "provider", description = "查询会员的认证等级")
    public void memberFacade_getMemberVerifyLevel(Params params) {
        String actual = this.memberFacade_getMemberVerifyLevel(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getProperty", dataProvider = "provider", description = "获取用户资产信息,目前只提供理财金、基金份额查询")
    public void memberFacade_getProperty(Params params) {
        String actual = this.memberFacade_getProperty(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/getUserBasicInfoByHryId", dataProvider = "provider", description = "根据用户id获得用户身份信息")
    public void memberFacade_getUserBasicInfoByHryId(Params params) {
        String actual = this.memberFacade_getUserBasicInfoByHryId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/grantCompanyAuth", dataProvider = "provider", description = "为企业会员授权")
    public void memberFacade_grantCompanyAuth(Params params) {
        String actual = this.memberFacade_grantCompanyAuth(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/identifyForeignerInfo", dataProvider = "provider", description = "认证外籍用户身份信息(只限港澳台和外籍用户)")
    public void memberFacade_identifyForeignerInfo(Params params) {
        String actual = this.memberFacade_identifyForeignerInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/openCustodyAccount", dataProvider = "provider", description = "存管开户")
    public void memberFacade_openCustodyAccount(Params params) {
        String actual = this.memberFacade_openCustodyAccount(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/openCustodyAccountQuick", dataProvider = "provider", description = "快速存管开户")
    public void memberFacade_openCustodyAccountQuick(Params params) {
        String actual = this.memberFacade_openCustodyAccountQuick(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryBankNameByCardNo", dataProvider = "provider", description = "根据卡号查询银行名称")
    public void memberFacade_queryBankNameByCardNo(Params params) {
        String actual = this.memberFacade_queryBankNameByCardNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryCunguanBankInfoByCardNo", dataProvider = "provider", description = "根据卡号查询存管支持银行信息")
    public void memberFacade_queryCunguanBankInfoByCardNo(Params params) {
        String actual = this.memberFacade_queryCunguanBankInfoByCardNo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryForeignerVerifyInfo", dataProvider = "provider", description = "查询外籍用户身份认证情况(只限港澳台和外籍用户)")
    public void memberFacade_queryForeignerVerifyInfo(Params params) {
        String actual = this.memberFacade_queryForeignerVerifyInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryIdCardHang", dataProvider = "provider", description = "查询身份证是否挂起")
    public void memberFacade_queryIdCardHang(Params params) {
        String actual = this.memberFacade_queryIdCardHang(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryLcjListByStatus", dataProvider = "provider", description = "根据状态获取理财金详情")
    public void memberFacade_queryLcjListByStatus(Params params) {
        String actual = this.memberFacade_queryLcjListByStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryLcjSyncRecord", dataProvider = "provider", description = "查询理财金同步信息")
    public void memberFacade_queryLcjSyncRecord(Params params) {
        String actual = this.memberFacade_queryLcjSyncRecord(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryMemberBasicInfoFromKjt", dataProvider = "provider", description = "从快捷通查询用户信息(包括外籍用户)")
    public void memberFacade_queryMemberBasicInfoFromKjt(Params params) {
        String actual = this.memberFacade_queryMemberBasicInfoFromKjt(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryMemberByHryIdList", dataProvider = "provider", description = "根据hryIdList获取批量用户信息")
    public void memberFacade_queryMemberByHryIdList(Params params) {
        String actual = this.memberFacade_queryMemberByHryIdList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryMemberByLoginNameList", dataProvider = "provider", description = "根据LoginNameList获取批量用户信息")
    public void memberFacade_queryMemberByLoginNameList(Params params) {
        String actual = this.memberFacade_queryMemberByLoginNameList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryMemberStatusInfo", dataProvider = "provider", description = "查询用户状态信息(包括外籍用户)")
    public void memberFacade_queryMemberStatusInfo(Params params) {
        String actual = this.memberFacade_queryMemberStatusInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryRealNameInfo", dataProvider = "provider", description = "查询实名认证信息")
    public void memberFacade_queryRealNameInfo(Params params) {
        String actual = this.memberFacade_queryRealNameInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/queryUserGroupInfo", dataProvider = "provider", description = "查询用户组的信息")
    public void memberFacade_queryUserGroupInfo(Params params) {
        String actual = this.memberFacade_queryUserGroupInfo(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/registerUserOnStepOne", dataProvider = "provider", description = "注册页面1点下一步(包括外籍用户)")
    public void memberFacade_registerUserOnStepOne(Params params) {
        String actual = this.memberFacade_registerUserOnStepOne(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/resetLoginPassword", dataProvider = "provider", description = "重置登陆密码，仅仅限于以QYZH开头的账号")
    public void memberFacade_resetLoginPassword(Params params) {
        String actual = this.memberFacade_resetLoginPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/sendMessage", dataProvider = "provider", description = "发送站内信")
    public void memberFacade_sendMessage(Params params) {
        String actual = this.memberFacade_sendMessage(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/sendMobileVerificationCode", dataProvider = "provider", description = "发送手机校验码")
    public void memberFacade_sendMobileVerificationCode(Params params) {
        String actual = this.memberFacade_sendMobileVerificationCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/setMemberGroupId", dataProvider = "provider", description = "设置用户的用户组Id")
    public void memberFacade_setMemberGroupId(Params params) {
        String actual = this.memberFacade_setMemberGroupId(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/setPaymentPassword", dataProvider = "provider", description = "设置支付密码")
    public void memberFacade_setPaymentPassword(Params params) {
        String actual = this.memberFacade_setPaymentPassword(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/updateCustodyAccountStatus", dataProvider = "provider", description = "更新存管户状态")
    public void memberFacade_updateCustodyAccountStatus(Params params) {
        String actual = this.memberFacade_updateCustodyAccountStatus(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/uploadPhotocopy", dataProvider = "provider", description = "上传身份证影印件")
    public void memberFacade_uploadPhotocopy(Params params) {
        String actual = this.memberFacade_uploadPhotocopy(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/verifyIdCardNumberAgainstRealName", dataProvider = "provider", description = "验证真实姓名与身份证号是否一致,如果一致将其保存")
    public void memberFacade_verifyIdCardNumberAgainstRealName(Params params) {
        String actual = this.memberFacade_verifyIdCardNumberAgainstRealName(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/verifyMobileVerificationCode", dataProvider = "provider", description = "验证手机校验码")
    public void memberFacade_verifyMobileVerificationCode(Params params) {
        String actual = this.memberFacade_verifyMobileVerificationCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/memberFacade/verifyRealNameAndBindingMobilephote", dataProvider = "provider", description = "实姓认证和手机号绑定")
    public void memberFacade_verifyRealNameAndBindingMobilephote(Params params) {
        String actual = this.memberFacade_verifyRealNameAndBindingMobilephote(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/messageFacade/deleteMessage", dataProvider = "provider", description = "删除信息")
    public void messageFacade_deleteMessage(Params params) {
        String actual = this.messageFacade_deleteMessage(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/messageFacade/getMessageInfoList", dataProvider = "provider", description = "获取信息列表")
    public void messageFacade_getMessageInfoList(Params params) {
        String actual = this.messageFacade_getMessageInfoList(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/messageFacade/setMessageToRead", dataProvider = "provider", description = "设置信息为已读")
    public void messageFacade_setMessageToRead(Params params) {
        String actual = this.messageFacade_setMessageToRead(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/sessionFacade/authCode", dataProvider = "provider", description = "验证码验证")
    public void sessionFacade_authCode(Params params) {
        String actual = this.sessionFacade_authCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/sessionFacade/authSmsCode", dataProvider = "provider", description = "短信验证码验证")
    public void sessionFacade_authSmsCode(Params params) {
        String actual = this.sessionFacade_authSmsCode(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/sessionFacade/getCurrentMember", dataProvider = "provider", description = "根据token从Session中获取用户信息")
    public void sessionFacade_getCurrentMember(Params params) {
        String actual = this.sessionFacade_getCurrentMember(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/sessionFacade/initUser", dataProvider = "provider", description = "初始化用户信息")
    public void sessionFacade_initUser(Params params) {
        String actual = this.sessionFacade_initUser(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }
}
