package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.MemberBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: MemberDefaultTest
 * @Author: 自动生成
 * @Date: 2018/08/22 17:47:20
 */
@Slf4j
public class MemberDefaultTest extends MemberBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/bankCardFacade/addBankCardForForeigner", dataProvider = "provider", description = "外籍用户添加银行卡(只限港澳台和外籍用户)")
    public void bankCardFacade_addBankCardForForeigner(HryTest hryTest) {
        String actual = this._bankCardFacade_addBankCardForForeigner(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/bindBankCard", dataProvider = "provider", description = "绑定银行卡")
    public void bankCardFacade_bindBankCard(HryTest hryTest) {
        String actual = this._bankCardFacade_bindBankCard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/bindQuickBankCardSign", dataProvider = "provider", description = "绑定快捷卡签约推进")
    public void bankCardFacade_bindQuickBankCardSign(HryTest hryTest) {
        String actual = this._bankCardFacade_bindQuickBankCardSign(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/checkUserBindCard", dataProvider = "provider", description = "查询用户是否绑过银行卡")
    public void bankCardFacade_checkUserBindCard(HryTest hryTest) {
        String actual = this._bankCardFacade_checkUserBindCard(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/getBankChannel", dataProvider = "provider", description = "根据银行代码和支付金额获取银行渠道")
    public void bankCardFacade_getBankChannel(HryTest hryTest) {
        String actual = this._bankCardFacade_getBankChannel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/queryBankCardInfoForForeigner", dataProvider = "provider", description = "查询外籍用户最近添加的银行卡(只限港澳台和外籍用户)")
    public void bankCardFacade_queryBankCardInfoForForeigner(HryTest hryTest) {
        String actual = this._bankCardFacade_queryBankCardInfoForForeigner(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/queryBankLimits", dataProvider = "provider", description = "收银服务限额限次查询")
    public void bankCardFacade_queryBankLimits(HryTest hryTest) {
        String actual = this._bankCardFacade_queryBankLimits(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/queryBankLimitsWithCunguanBankCode", dataProvider = "provider", description = "收银服务限额限次查询和存管银行代码")
    public void bankCardFacade_queryBankLimitsWithCunguanBankCode(HryTest hryTest) {
        String actual = this._bankCardFacade_queryBankLimitsWithCunguanBankCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/queryBranch", dataProvider = "provider", description = "查询分支行信息")
    public void bankCardFacade_queryBranch(HryTest hryTest) {
        String actual = this._bankCardFacade_queryBranch(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/queryProvinceAndCity", dataProvider = "provider", description = "查询所有省市信息")
    public void bankCardFacade_queryProvinceAndCity(HryTest hryTest) {
        String actual = this._bankCardFacade_queryProvinceAndCity(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/querySupportBank", dataProvider = "provider", description = "查询支持的出款银行")
    public void bankCardFacade_querySupportBank(HryTest hryTest) {
        String actual = this._bankCardFacade_querySupportBank(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/querySupportedKJCards", dataProvider = "provider", description = "查询支持快捷卡的银行")
    public void bankCardFacade_querySupportedKJCards(HryTest hryTest) {
        String actual = this._bankCardFacade_querySupportedKJCards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bankCardFacade/queryUserBindCards", dataProvider = "provider", description = "查询用户绑定的银行卡")
    public void bankCardFacade_queryUserBindCards(HryTest hryTest) {
        String actual = this._bankCardFacade_queryUserBindCards(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumerFinanceFacade/checkConsumerFinanceStatus", dataProvider = "provider", description = "查询消费金融状态")
    public void consumerFinanceFacade_checkConsumerFinanceStatus(HryTest hryTest) {
        String actual = this._consumerFinanceFacade_checkConsumerFinanceStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumerFinanceFacade/getIdCardImages", dataProvider = "provider", description = "下载会员影印件")
    public void consumerFinanceFacade_getIdCardImages(HryTest hryTest) {
        String actual = this._consumerFinanceFacade_getIdCardImages(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumerFinanceFacade/openConsumerFinance", dataProvider = "provider", description = "开通消费金融")
    public void consumerFinanceFacade_openConsumerFinance(HryTest hryTest) {
        String actual = this._consumerFinanceFacade_openConsumerFinance(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumerFinanceFacade/queryUserBasicInfo", dataProvider = "provider", description = "查询用户基本信息")
    public void consumerFinanceFacade_queryUserBasicInfo(HryTest hryTest) {
        String actual = this._consumerFinanceFacade_queryUserBasicInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumerFinanceFacade/queryUserCreditLimit", dataProvider = "provider", description = "查询用户贷款额度信息")
    public void consumerFinanceFacade_queryUserCreditLimit(HryTest hryTest) {
        String actual = this._consumerFinanceFacade_queryUserCreditLimit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/consumerFinanceFacade/updateUserCreditLimit", dataProvider = "provider", description = "更新用户贷款额度信息")
    public void consumerFinanceFacade_updateUserCreditLimit(HryTest hryTest) {
        String actual = this._consumerFinanceFacade_updateUserCreditLimit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/addBankContact", dataProvider = "provider", description = "添加银行联系人信息")
    public void customerFacade_addBankContact(HryTest hryTest) {
        String actual = this._customerFacade_addBankContact(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/addKjtContacts", dataProvider = "provider", description = "添加快捷通联系人")
    public void customerFacade_addKjtContacts(HryTest hryTest) {
        String actual = this._customerFacade_addKjtContacts(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/applyResetMerchantLoginPassword", dataProvider = "provider", description = "商户登录密码重设申请")
    public void customerFacade_applyResetMerchantLoginPassword(HryTest hryTest) {
        String actual = this._customerFacade_applyResetMerchantLoginPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/bindEmail", dataProvider = "provider", description = "绑定邮箱")
    public void customerFacade_bindEmail(HryTest hryTest) {
        String actual = this._customerFacade_bindEmail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/createRegisterContract", dataProvider = "provider", description = "创建注册合同")
    public void customerFacade_createRegisterContract(HryTest hryTest) {
        String actual = this._customerFacade_createRegisterContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/createRegisterContractBatch", dataProvider = "provider", description = "批量创建已同意的注册合同")
    public void customerFacade_createRegisterContractBatch(HryTest hryTest) {
        String actual = this._customerFacade_createRegisterContractBatch(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/deleteContact", dataProvider = "provider", description = "删除联系人信息")
    public void customerFacade_deleteContact(HryTest hryTest) {
        String actual = this._customerFacade_deleteContact(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/generateCode", dataProvider = "provider", description = "验证码生成接口")
    public void customerFacade_generateCode(HryTest hryTest) {
        String actual = this._customerFacade_generateCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getCapitalAccountInfo", dataProvider = "provider", description = "查询企业资金账户信息")
    public void customerFacade_getCapitalAccountInfo(HryTest hryTest) {
        String actual = this._customerFacade_getCapitalAccountInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getCorporationInfo", dataProvider = "provider", description = "获取法人信息")
    public void customerFacade_getCorporationInfo(HryTest hryTest) {
        String actual = this._customerFacade_getCorporationInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getEnterpriseCertificationInfo", dataProvider = "provider", description = "查询企业实名认证信息")
    public void customerFacade_getEnterpriseCertificationInfo(HryTest hryTest) {
        String actual = this._customerFacade_getEnterpriseCertificationInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getKjtUserInfoByHryId", dataProvider = "provider", description = "根据hryId查询kjt用户信息")
    public void customerFacade_getKjtUserInfoByHryId(HryTest hryTest) {
        String actual = this._customerFacade_getKjtUserInfoByHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getRiskAssessmentQuestions", dataProvider = "provider", description = "获取风险测评问题")
    public void customerFacade_getRiskAssessmentQuestions(HryTest hryTest) {
        String actual = this._customerFacade_getRiskAssessmentQuestions(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getUserAccountListById", dataProvider = "provider", description = "根据某一账户id获取该实名用户所有账户列表")
    public void customerFacade_getUserAccountListById(HryTest hryTest) {
        String actual = this._customerFacade_getUserAccountListById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getUserIdByToken", dataProvider = "provider", description = "根据token获取用户hryId和kjtId")
    public void customerFacade_getUserIdByToken(HryTest hryTest) {
        String actual = this._customerFacade_getUserIdByToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/getUserRiskAssessmentLevel", dataProvider = "provider", description = "获取用户风险测评结果")
    public void customerFacade_getUserRiskAssessmentLevel(HryTest hryTest) {
        String actual = this._customerFacade_getUserRiskAssessmentLevel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/login", dataProvider = "provider", description = "登录接口")
    public void customerFacade_login(HryTest hryTest) {
        String actual = this._customerFacade_login(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/loginFinancingMerchant", dataProvider = "provider", description = "商户登录接口")
    public void customerFacade_loginFinancingMerchant(HryTest hryTest) {
        String actual = this._customerFacade_loginFinancingMerchant(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/logout", dataProvider = "provider", description = "账号退出")
    public void customerFacade_logout(HryTest hryTest) {
        String actual = this._customerFacade_logout(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/moveCaptialCalendar", dataProvider = "provider", description = "移动资金日历数据到历史库")
    public void customerFacade_moveCaptialCalendar(HryTest hryTest) {
        String actual = this._customerFacade_moveCaptialCalendar(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/queryCaptialCalendar", dataProvider = "provider", description = "获取资金日历")
    public void customerFacade_queryCaptialCalendar(HryTest hryTest) {
        String actual = this._customerFacade_queryCaptialCalendar(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/queryContactList", dataProvider = "provider", description = "查询联系人列表")
    public void customerFacade_queryContactList(HryTest hryTest) {
        String actual = this._customerFacade_queryContactList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/queryRegisterContract", dataProvider = "provider", description = "查询用户注册合同")
    public void customerFacade_queryRegisterContract(HryTest hryTest) {
        String actual = this._customerFacade_queryRegisterContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/resetMerchantLoginPassword", dataProvider = "provider", description = "重设商户登录密码")
    public void customerFacade_resetMerchantLoginPassword(HryTest hryTest) {
        String actual = this._customerFacade_resetMerchantLoginPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/saveCapitalAccountInfo", dataProvider = "provider", description = "保存企业资金账户信息")
    public void customerFacade_saveCapitalAccountInfo(HryTest hryTest) {
        String actual = this._customerFacade_saveCapitalAccountInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/saveCorporationInfo", dataProvider = "provider", description = "保存法人信息")
    public void customerFacade_saveCorporationInfo(HryTest hryTest) {
        String actual = this._customerFacade_saveCorporationInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/saveEnterpriseCertificationInfo", dataProvider = "provider", description = "保存企业实名认证信息")
    public void customerFacade_saveEnterpriseCertificationInfo(HryTest hryTest) {
        String actual = this._customerFacade_saveEnterpriseCertificationInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/sendEmail", dataProvider = "provider", description = "发送邮件")
    public void customerFacade_sendEmail(HryTest hryTest) {
        String actual = this._customerFacade_sendEmail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/sendEmailAuthCode", dataProvider = "provider", description = "发送邮箱验证码")
    public void customerFacade_sendEmailAuthCode(HryTest hryTest) {
        String actual = this._customerFacade_sendEmailAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/sendMobileAuthCode", dataProvider = "provider", description = "发送手机验证码")
    public void customerFacade_sendMobileAuthCode(HryTest hryTest) {
        String actual = this._customerFacade_sendMobileAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/setUserRiskAssessmentLevel", dataProvider = "provider", description = "设置用户风险测评结果")
    public void customerFacade_setUserRiskAssessmentLevel(HryTest hryTest) {
        String actual = this._customerFacade_setUserRiskAssessmentLevel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/unBindEmail", dataProvider = "provider", description = "解绑邮箱")
    public void customerFacade_unBindEmail(HryTest hryTest) {
        String actual = this._customerFacade_unBindEmail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updateBindMobile", dataProvider = "provider", description = "修改绑定手机号")
    public void customerFacade_updateBindMobile(HryTest hryTest) {
        String actual = this._customerFacade_updateBindMobile(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updateLoginPassword", dataProvider = "provider", description = "修改登录密码")
    public void customerFacade_updateLoginPassword(HryTest hryTest) {
        String actual = this._customerFacade_updateLoginPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updateLoginPasswordByAuthToken", dataProvider = "provider", description = "根据验证有效token修改登录密码")
    public void customerFacade_updateLoginPasswordByAuthToken(HryTest hryTest) {
        String actual = this._customerFacade_updateLoginPasswordByAuthToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updatePayPassword", dataProvider = "provider", description = "修改支付密码")
    public void customerFacade_updatePayPassword(HryTest hryTest) {
        String actual = this._customerFacade_updatePayPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/updateRegisterContract", dataProvider = "provider", description = "创建已同意的注册合同")
    public void customerFacade_updateRegisterContract(HryTest hryTest) {
        String actual = this._customerFacade_updateRegisterContract(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/uploadBase64Image", dataProvider = "provider", description = "上传图片")
    public void customerFacade_uploadBase64Image(HryTest hryTest) {
        String actual = this._customerFacade_uploadBase64Image(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/vailedateEmailToken", dataProvider = "provider", description = "验证邮件中的token是否有效")
    public void customerFacade_vailedateEmailToken(HryTest hryTest) {
        String actual = this._customerFacade_vailedateEmailToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/validateEmailAuthCode", dataProvider = "provider", description = "验证邮箱验证码")
    public void customerFacade_validateEmailAuthCode(HryTest hryTest) {
        String actual = this._customerFacade_validateEmailAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/validateKjtAccounts", dataProvider = "provider", description = "校验快捷通账号是否存在")
    public void customerFacade_validateKjtAccounts(HryTest hryTest) {
        String actual = this._customerFacade_validateKjtAccounts(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/validateMobileAuthCode", dataProvider = "provider", description = "验证手机验证码")
    public void customerFacade_validateMobileAuthCode(HryTest hryTest) {
        String actual = this._customerFacade_validateMobileAuthCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/validatePayPassword", dataProvider = "provider", description = "验证支付密码")
    public void customerFacade_validatePayPassword(HryTest hryTest) {
        String actual = this._customerFacade_validatePayPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/customerFacade/validateRealNameNum", dataProvider = "provider", description = "验证实名认证证件号")
    public void customerFacade_validateRealNameNum(HryTest hryTest) {
        String actual = this._customerFacade_validateRealNameNum(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/dealerFacade/getDealerByDealerId", dataProvider = "provider", description = "根据经销商Id获取经销商信息")
    public void dealerFacade_getDealerByDealerId(HryTest hryTest) {
        String actual = this._dealerFacade_getDealerByDealerId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/dealerFacade/getDealerByTaxNo", dataProvider = "provider", description = "根据税务登记证号获取经销商信息")
    public void dealerFacade_getDealerByTaxNo(HryTest hryTest) {
        String actual = this._dealerFacade_getDealerByTaxNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/enterpriseFacade/getEnterpriseInfoByHryIdFromHry", dataProvider = "provider", description = "根据hryId获取企业用户信息")
    public void enterpriseFacade_getEnterpriseInfoByHryIdFromHry(HryTest hryTest) {
        String actual = this._enterpriseFacade_getEnterpriseInfoByHryIdFromHry(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/enterpriseFacade/getEnterpriseKjtAccountInfoByLoginName", dataProvider = "provider", description = "根据登录名查询Kjt账户信息")
    public void enterpriseFacade_getEnterpriseKjtAccountInfoByLoginName(HryTest hryTest) {
        String actual = this._enterpriseFacade_getEnterpriseKjtAccountInfoByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/fundIn", dataProvider = "provider", description = "基金开户并转入")
    public void fundFacade_fundIn(HryTest hryTest) {
        String actual = this._fundFacade_fundIn(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/getUserStatisticsProfit", dataProvider = "provider", description = "历史收益查询")
    public void fundFacade_getUserStatisticsProfit(HryTest hryTest) {
        String actual = this._fundFacade_getUserStatisticsProfit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/getWithdrawCode", dataProvider = "provider", description = "获取提现手机验证码")
    public void fundFacade_getWithdrawCode(HryTest hryTest) {
        String actual = this._fundFacade_getWithdrawCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/isOpenFund", dataProvider = "provider", description = "判断当前登录用户是否开通基金账户")
    public void fundFacade_isOpenFund(HryTest hryTest) {
        String actual = this._fundFacade_isOpenFund(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/openFundAccount", dataProvider = "provider", description = "基金开户")
    public void fundFacade_openFundAccount(HryTest hryTest) {
        String actual = this._fundFacade_openFundAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/queryAllQuickBankAccount", dataProvider = "provider", description = "查询会员绑定的所有快捷卡信息")
    public void fundFacade_queryAllQuickBankAccount(HryTest hryTest) {
        String actual = this._fundFacade_queryAllQuickBankAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/queryBankAccount", dataProvider = "provider", description = "查询会员绑定的银行卡信息")
    public void fundFacade_queryBankAccount(HryTest hryTest) {
        String actual = this._fundFacade_queryBankAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/queryFundOrder", dataProvider = "provider", description = "查询基金交易订单")
    public void fundFacade_queryFundOrder(HryTest hryTest) {
        String actual = this._fundFacade_queryFundOrder(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/queryFundRates", dataProvider = "provider", description = "查询年化利率和万份收益信息")
    public void fundFacade_queryFundRates(HryTest hryTest) {
        String actual = this._fundFacade_queryFundRates(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/queryProfitDate", dataProvider = "provider", description = "本次转入后收益发放时间")
    public void fundFacade_queryProfitDate(HryTest hryTest) {
        String actual = this._fundFacade_queryProfitDate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/queryWithdrawBankAccount", dataProvider = "provider", description = "查询会员可提现的银行卡信息")
    public void fundFacade_queryWithdrawBankAccount(HryTest hryTest) {
        String actual = this._fundFacade_queryWithdrawBankAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/fundFacade/withdraw", dataProvider = "provider", description = "提现")
    public void fundFacade_withdraw(HryTest hryTest) {
        String actual = this._fundFacade_withdraw(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/kjtGatewayFacade/execute", dataProvider = "provider", description = "kjt会员接口统一封装")
    public void kjtGatewayFacade_execute(HryTest hryTest) {
        String actual = this._kjtGatewayFacade_execute(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/kjtGatewayFacade/getKjtIdByLoginName", dataProvider = "provider", description = "根据登录名查询KJT ID")
    public void kjtGatewayFacade_getKjtIdByLoginName(HryTest hryTest) {
        String actual = this._kjtGatewayFacade_getKjtIdByLoginName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/batchOpenCustodyAccount", dataProvider = "provider", description = "批量开通存管户")
    public void memberFacade_batchOpenCustodyAccount(HryTest hryTest) {
        String actual = this._memberFacade_batchOpenCustodyAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/bindingMobilephone", dataProvider = "provider", description = "绑定手机号(包括外籍用户)")
    public void memberFacade_bindingMobilephone(HryTest hryTest) {
        String actual = this._memberFacade_bindingMobilephone(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/checkBindingMobilephone", dataProvider = "provider", description = "检查手机号是否能被绑定(包括外籍用户)")
    public void memberFacade_checkBindingMobilephone(HryTest hryTest) {
        String actual = this._memberFacade_checkBindingMobilephone(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/checkCustodyAccountStatus", dataProvider = "provider", description = "查询存管户状态")
    public void memberFacade_checkCustodyAccountStatus(HryTest hryTest) {
        String actual = this._memberFacade_checkCustodyAccountStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/checkPayPassword", dataProvider = "provider", description = "验证支付密码")
    public void memberFacade_checkPayPassword(HryTest hryTest) {
        String actual = this._memberFacade_checkPayPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/checkWhetherLoginNameExists", dataProvider = "provider", description = "校验登陆名是否已经存在")
    public void memberFacade_checkWhetherLoginNameExists(HryTest hryTest) {
        String actual = this._memberFacade_checkWhetherLoginNameExists(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getCompanyAuth", dataProvider = "provider", description = "获取企业会员权限")
    public void memberFacade_getCompanyAuth(HryTest hryTest) {
        String actual = this._memberFacade_getCompanyAuth(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getHryIdFromMemberId", dataProvider = "provider", description = "根据kjtId查询hryId")
    public void memberFacade_getHryIdFromMemberId(HryTest hryTest) {
        String actual = this._memberFacade_getHryIdFromMemberId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getIdVerificationStatus", dataProvider = "provider", description = "查询会员的身份认证状态")
    public void memberFacade_getIdVerificationStatus(HryTest hryTest) {
        String actual = this._memberFacade_getIdVerificationStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getInvestmentProperty", dataProvider = "provider", description = "获取用户投资资产信息")
    public void memberFacade_getInvestmentProperty(HryTest hryTest) {
        String actual = this._memberFacade_getInvestmentProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getKjtProperty", dataProvider = "provider", description = "获取用户kjt方面资产信息")
    public void memberFacade_getKjtProperty(HryTest hryTest) {
        String actual = this._memberFacade_getKjtProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getLcjProperty", dataProvider = "provider", description = "获取用户理财金资产信息")
    public void memberFacade_getLcjProperty(HryTest hryTest) {
        String actual = this._memberFacade_getLcjProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getLcjRecord", dataProvider = "provider", description = "获取用户理财金信息")
    public void memberFacade_getLcjRecord(HryTest hryTest) {
        String actual = this._memberFacade_getLcjRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getLcjStatisticsByStatus", dataProvider = "provider", description = "根据状态统计理财金信息")
    public void memberFacade_getLcjStatisticsByStatus(HryTest hryTest) {
        String actual = this._memberFacade_getLcjStatisticsByStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getMemberByHryId", dataProvider = "provider", description = "根据hryId获取用户信息(从hry数据库获取信息，包括外籍用户)")
    public void memberFacade_getMemberByHryId(HryTest hryTest) {
        String actual = this._memberFacade_getMemberByHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getMemberCount", dataProvider = "provider", description = "获取平台所有用户数")
    public void memberFacade_getMemberCount(HryTest hryTest) {
        String actual = this._memberFacade_getMemberCount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getMemberIdByCardIdAndHryId", dataProvider = "provider", description = "根据用户id获取身份证，然后通过身份证获取对应的绑定用户id(从hry数据库获取信息，包括外籍用户)")
    public void memberFacade_getMemberIdByCardIdAndHryId(HryTest hryTest) {
        String actual = this._memberFacade_getMemberIdByCardIdAndHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getMemberVerifyInfo", dataProvider = "provider", description = "查询会员的认证信息")
    public void memberFacade_getMemberVerifyInfo(HryTest hryTest) {
        String actual = this._memberFacade_getMemberVerifyInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getMemberVerifyLevel", dataProvider = "provider", description = "查询会员的认证等级")
    public void memberFacade_getMemberVerifyLevel(HryTest hryTest) {
        String actual = this._memberFacade_getMemberVerifyLevel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getProperty", dataProvider = "provider", description = "获取用户资产信息,目前只提供理财金、基金份额查询")
    public void memberFacade_getProperty(HryTest hryTest) {
        String actual = this._memberFacade_getProperty(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/getUserBasicInfoByHryId", dataProvider = "provider", description = "根据用户id获得用户身份信息")
    public void memberFacade_getUserBasicInfoByHryId(HryTest hryTest) {
        String actual = this._memberFacade_getUserBasicInfoByHryId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/grantCompanyAuth", dataProvider = "provider", description = "为企业会员授权")
    public void memberFacade_grantCompanyAuth(HryTest hryTest) {
        String actual = this._memberFacade_grantCompanyAuth(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/identifyForeignerInfo", dataProvider = "provider", description = "认证外籍用户身份信息(只限港澳台和外籍用户)")
    public void memberFacade_identifyForeignerInfo(HryTest hryTest) {
        String actual = this._memberFacade_identifyForeignerInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/openCustodyAccount", dataProvider = "provider", description = "存管开户")
    public void memberFacade_openCustodyAccount(HryTest hryTest) {
        String actual = this._memberFacade_openCustodyAccount(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/openCustodyAccountQuick", dataProvider = "provider", description = "快速存管开户")
    public void memberFacade_openCustodyAccountQuick(HryTest hryTest) {
        String actual = this._memberFacade_openCustodyAccountQuick(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryBankNameByCardNo", dataProvider = "provider", description = "根据卡号查询银行名称")
    public void memberFacade_queryBankNameByCardNo(HryTest hryTest) {
        String actual = this._memberFacade_queryBankNameByCardNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryCunguanBankInfoByCardNo", dataProvider = "provider", description = "根据卡号查询存管支持银行信息")
    public void memberFacade_queryCunguanBankInfoByCardNo(HryTest hryTest) {
        String actual = this._memberFacade_queryCunguanBankInfoByCardNo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryForeignerVerifyInfo", dataProvider = "provider", description = "查询外籍用户身份认证情况(只限港澳台和外籍用户)")
    public void memberFacade_queryForeignerVerifyInfo(HryTest hryTest) {
        String actual = this._memberFacade_queryForeignerVerifyInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryIdCardHang", dataProvider = "provider", description = "查询身份证是否挂起")
    public void memberFacade_queryIdCardHang(HryTest hryTest) {
        String actual = this._memberFacade_queryIdCardHang(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryLcjListByStatus", dataProvider = "provider", description = "根据状态获取理财金详情")
    public void memberFacade_queryLcjListByStatus(HryTest hryTest) {
        String actual = this._memberFacade_queryLcjListByStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryLcjSyncRecord", dataProvider = "provider", description = "查询理财金同步信息")
    public void memberFacade_queryLcjSyncRecord(HryTest hryTest) {
        String actual = this._memberFacade_queryLcjSyncRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryMemberBasicInfoFromKjt", dataProvider = "provider", description = "从快捷通查询用户信息(包括外籍用户)")
    public void memberFacade_queryMemberBasicInfoFromKjt(HryTest hryTest) {
        String actual = this._memberFacade_queryMemberBasicInfoFromKjt(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryMemberByHryIdList", dataProvider = "provider", description = "根据hryIdList获取批量用户信息")
    public void memberFacade_queryMemberByHryIdList(HryTest hryTest) {
        String actual = this._memberFacade_queryMemberByHryIdList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryMemberByLoginNameList", dataProvider = "provider", description = "根据LoginNameList获取批量用户信息")
    public void memberFacade_queryMemberByLoginNameList(HryTest hryTest) {
        String actual = this._memberFacade_queryMemberByLoginNameList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryMemberStatusInfo", dataProvider = "provider", description = "查询用户状态信息(包括外籍用户)")
    public void memberFacade_queryMemberStatusInfo(HryTest hryTest) {
        String actual = this._memberFacade_queryMemberStatusInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryRealNameInfo", dataProvider = "provider", description = "查询实名认证信息")
    public void memberFacade_queryRealNameInfo(HryTest hryTest) {
        String actual = this._memberFacade_queryRealNameInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/queryUserGroupInfo", dataProvider = "provider", description = "查询用户组的信息")
    public void memberFacade_queryUserGroupInfo(HryTest hryTest) {
        String actual = this._memberFacade_queryUserGroupInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/registerUserOnStepOne", dataProvider = "provider", description = "注册页面1点下一步(包括外籍用户)")
    public void memberFacade_registerUserOnStepOne(HryTest hryTest) {
        String actual = this._memberFacade_registerUserOnStepOne(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/resetLoginPassword", dataProvider = "provider", description = "重置登陆密码，仅仅限于以QYZH开头的账号")
    public void memberFacade_resetLoginPassword(HryTest hryTest) {
        String actual = this._memberFacade_resetLoginPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/sendMessage", dataProvider = "provider", description = "发送站内信")
    public void memberFacade_sendMessage(HryTest hryTest) {
        String actual = this._memberFacade_sendMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/sendMobileVerificationCode", dataProvider = "provider", description = "发送手机校验码")
    public void memberFacade_sendMobileVerificationCode(HryTest hryTest) {
        String actual = this._memberFacade_sendMobileVerificationCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/setMemberGroupId", dataProvider = "provider", description = "设置用户的用户组Id")
    public void memberFacade_setMemberGroupId(HryTest hryTest) {
        String actual = this._memberFacade_setMemberGroupId(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/setPaymentPassword", dataProvider = "provider", description = "设置支付密码")
    public void memberFacade_setPaymentPassword(HryTest hryTest) {
        String actual = this._memberFacade_setPaymentPassword(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/updateCustodyAccountStatus", dataProvider = "provider", description = "更新存管户状态")
    public void memberFacade_updateCustodyAccountStatus(HryTest hryTest) {
        String actual = this._memberFacade_updateCustodyAccountStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/uploadPhotocopy", dataProvider = "provider", description = "上传身份证影印件")
    public void memberFacade_uploadPhotocopy(HryTest hryTest) {
        String actual = this._memberFacade_uploadPhotocopy(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/verifyIdCardNumberAgainstRealName", dataProvider = "provider", description = "验证真实姓名与身份证号是否一致,如果一致将其保存")
    public void memberFacade_verifyIdCardNumberAgainstRealName(HryTest hryTest) {
        String actual = this._memberFacade_verifyIdCardNumberAgainstRealName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/verifyMobileVerificationCode", dataProvider = "provider", description = "验证手机校验码")
    public void memberFacade_verifyMobileVerificationCode(HryTest hryTest) {
        String actual = this._memberFacade_verifyMobileVerificationCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/memberFacade/verifyRealNameAndBindingMobilephote", dataProvider = "provider", description = "实姓认证和手机号绑定")
    public void memberFacade_verifyRealNameAndBindingMobilephote(HryTest hryTest) {
        String actual = this._memberFacade_verifyRealNameAndBindingMobilephote(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageFacade/deleteMessage", dataProvider = "provider", description = "删除信息")
    public void messageFacade_deleteMessage(HryTest hryTest) {
        String actual = this._messageFacade_deleteMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageFacade/getMessageInfoList", dataProvider = "provider", description = "获取信息列表")
    public void messageFacade_getMessageInfoList(HryTest hryTest) {
        String actual = this._messageFacade_getMessageInfoList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageFacade/setMessageToRead", dataProvider = "provider", description = "设置信息为已读")
    public void messageFacade_setMessageToRead(HryTest hryTest) {
        String actual = this._messageFacade_setMessageToRead(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sessionFacade/authCode", dataProvider = "provider", description = "验证码验证")
    public void sessionFacade_authCode(HryTest hryTest) {
        String actual = this._sessionFacade_authCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sessionFacade/authSmsCode", dataProvider = "provider", description = "短信验证码验证")
    public void sessionFacade_authSmsCode(HryTest hryTest) {
        String actual = this._sessionFacade_authSmsCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sessionFacade/getCurrentMember", dataProvider = "provider", description = "根据token从Session中获取用户信息")
    public void sessionFacade_getCurrentMember(HryTest hryTest) {
        String actual = this._sessionFacade_getCurrentMember(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/sessionFacade/initUser", dataProvider = "provider", description = "初始化用户信息")
    public void sessionFacade_initUser(HryTest hryTest) {
        String actual = this._sessionFacade_initUser(hryTest);
        supperAssert(actual, hryTest);
    }

}
