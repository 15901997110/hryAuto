package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: MemberBase
 * @Author: 自动生成
 * @Date: 2018/08/17 14:34:00
 */
@SKey("Member")
public class MemberBase extends Base {
    @Uri(value = "/bankCardFacade/addBankCardForForeigner", desc = "外籍用户添加银行卡(只限港澳台和外籍用户)")
    public String _bankCardFacade_addBankCardForForeigner(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/bindBankCard", desc = "绑定银行卡")
    public String _bankCardFacade_bindBankCard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/bindQuickBankCardSign", desc = "绑定快捷卡签约推进")
    public String _bankCardFacade_bindQuickBankCardSign(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/checkUserBindCard", desc = "查询用户是否绑过银行卡")
    public String _bankCardFacade_checkUserBindCard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/getBankChannel", desc = "根据银行代码和支付金额获取银行渠道")
    public String _bankCardFacade_getBankChannel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/queryBankCardInfoForForeigner", desc = "查询外籍用户最近添加的银行卡(只限港澳台和外籍用户)")
    public String _bankCardFacade_queryBankCardInfoForForeigner(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/queryBankLimits", desc = "收银服务限额限次查询")
    public String _bankCardFacade_queryBankLimits(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/queryBankLimitsWithCunguanBankCode", desc = "收银服务限额限次查询和存管银行代码")
    public String _bankCardFacade_queryBankLimitsWithCunguanBankCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/queryBranch", desc = "查询分支行信息")
    public String _bankCardFacade_queryBranch(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/queryProvinceAndCity", desc = "查询所有省市信息")
    public String _bankCardFacade_queryProvinceAndCity(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/querySupportBank", desc = "查询支持的出款银行")
    public String _bankCardFacade_querySupportBank(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/querySupportedKJCards", desc = "查询支持快捷卡的银行")
    public String _bankCardFacade_querySupportedKJCards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/queryUserBindCards", desc = "查询用户绑定的银行卡")
    public String _bankCardFacade_queryUserBindCards(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumerFinanceFacade/checkConsumerFinanceStatus", desc = "查询消费金融状态")
    public String _consumerFinanceFacade_checkConsumerFinanceStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumerFinanceFacade/getIdCardImages", desc = "下载会员影印件")
    public String _consumerFinanceFacade_getIdCardImages(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumerFinanceFacade/openConsumerFinance", desc = "开通消费金融")
    public String _consumerFinanceFacade_openConsumerFinance(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumerFinanceFacade/queryUserBasicInfo", desc = "查询用户基本信息")
    public String _consumerFinanceFacade_queryUserBasicInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumerFinanceFacade/queryUserCreditLimit", desc = "查询用户贷款额度信息")
    public String _consumerFinanceFacade_queryUserCreditLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/consumerFinanceFacade/updateUserCreditLimit", desc = "更新用户贷款额度信息")
    public String _consumerFinanceFacade_updateUserCreditLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/addBankContact", desc = "添加银行联系人信息")
    public String _customerFacade_addBankContact(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/addKjtContacts", desc = "添加快捷通联系人")
    public String _customerFacade_addKjtContacts(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/applyResetMerchantLoginPassword", desc = "商户登录密码重设申请")
    public String _customerFacade_applyResetMerchantLoginPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/bindEmail", desc = "绑定邮箱")
    public String _customerFacade_bindEmail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/createRegisterContract", desc = "创建注册合同")
    public String _customerFacade_createRegisterContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/createRegisterContractBatch", desc = "批量创建已同意的注册合同")
    public String _customerFacade_createRegisterContractBatch(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/deleteContact", desc = "删除联系人信息")
    public String _customerFacade_deleteContact(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/generateCode", desc = "验证码生成接口")
    public String _customerFacade_generateCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getCapitalAccountInfo", desc = "查询企业资金账户信息")
    public String _customerFacade_getCapitalAccountInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getCorporationInfo", desc = "获取法人信息")
    public String _customerFacade_getCorporationInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getEnterpriseCertificationInfo", desc = "查询企业实名认证信息")
    public String _customerFacade_getEnterpriseCertificationInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getKjtUserInfoByHryId", desc = "根据hryId查询kjt用户信息")
    public String _customerFacade_getKjtUserInfoByHryId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getRiskAssessmentQuestions", desc = "获取风险测评问题")
    public String _customerFacade_getRiskAssessmentQuestions(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getUserAccountListById", desc = "根据某一账户id获取该实名用户所有账户列表")
    public String _customerFacade_getUserAccountListById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getUserIdByToken", desc = "根据token获取用户hryId和kjtId")
    public String _customerFacade_getUserIdByToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/getUserRiskAssessmentLevel", desc = "获取用户风险测评结果")
    public String _customerFacade_getUserRiskAssessmentLevel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/login", desc = "登录接口")
    public String _customerFacade_login(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/loginFinancingMerchant", desc = "商户登录接口")
    public String _customerFacade_loginFinancingMerchant(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/logout", desc = "账号退出")
    public String _customerFacade_logout(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/moveCaptialCalendar", desc = "移动资金日历数据到历史库")
    public String _customerFacade_moveCaptialCalendar(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/queryCaptialCalendar", desc = "获取资金日历")
    public String _customerFacade_queryCaptialCalendar(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/queryContactList", desc = "查询联系人列表")
    public String _customerFacade_queryContactList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/queryRegisterContract", desc = "查询用户注册合同")
    public String _customerFacade_queryRegisterContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/resetMerchantLoginPassword", desc = "重设商户登录密码")
    public String _customerFacade_resetMerchantLoginPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/saveCapitalAccountInfo", desc = "保存企业资金账户信息")
    public String _customerFacade_saveCapitalAccountInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/saveCorporationInfo", desc = "保存法人信息")
    public String _customerFacade_saveCorporationInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/saveEnterpriseCertificationInfo", desc = "保存企业实名认证信息")
    public String _customerFacade_saveEnterpriseCertificationInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/sendEmail", desc = "发送邮件")
    public String _customerFacade_sendEmail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/sendEmailAuthCode", desc = "发送邮箱验证码")
    public String _customerFacade_sendEmailAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/sendMobileAuthCode", desc = "发送手机验证码")
    public String _customerFacade_sendMobileAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/setUserRiskAssessmentLevel", desc = "设置用户风险测评结果")
    public String _customerFacade_setUserRiskAssessmentLevel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/unBindEmail", desc = "解绑邮箱")
    public String _customerFacade_unBindEmail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/updateBindMobile", desc = "修改绑定手机号")
    public String _customerFacade_updateBindMobile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/updateLoginPassword", desc = "修改登录密码")
    public String _customerFacade_updateLoginPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/updateLoginPasswordByAuthToken", desc = "根据验证有效token修改登录密码")
    public String _customerFacade_updateLoginPasswordByAuthToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/updatePayPassword", desc = "修改支付密码")
    public String _customerFacade_updatePayPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/updateRegisterContract", desc = "创建已同意的注册合同")
    public String _customerFacade_updateRegisterContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/uploadBase64Image", desc = "上传图片")
    public String _customerFacade_uploadBase64Image(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/vailedateEmailToken", desc = "验证邮件中的token是否有效")
    public String _customerFacade_vailedateEmailToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/validateEmailAuthCode", desc = "验证邮箱验证码")
    public String _customerFacade_validateEmailAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/validateKjtAccounts", desc = "校验快捷通账号是否存在")
    public String _customerFacade_validateKjtAccounts(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/validateMobileAuthCode", desc = "验证手机验证码")
    public String _customerFacade_validateMobileAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/validatePayPassword", desc = "验证支付密码")
    public String _customerFacade_validatePayPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/validateRealNameNum", desc = "验证实名认证证件号")
    public String _customerFacade_validateRealNameNum(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/dealerFacade/getDealerByDealerId", desc = "根据经销商Id获取经销商信息")
    public String _dealerFacade_getDealerByDealerId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/dealerFacade/getDealerByTaxNo", desc = "根据税务登记证号获取经销商信息")
    public String _dealerFacade_getDealerByTaxNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/enterpriseFacade/getEnterpriseInfoByHryIdFromHry", desc = "根据hryId获取企业用户信息")
    public String _enterpriseFacade_getEnterpriseInfoByHryIdFromHry(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/enterpriseFacade/getEnterpriseKjtAccountInfoByLoginName", desc = "根据登录名查询Kjt账户信息")
    public String _enterpriseFacade_getEnterpriseKjtAccountInfoByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/fundIn", desc = "基金开户并转入")
    public String _fundFacade_fundIn(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/getUserStatisticsProfit", desc = "历史收益查询")
    public String _fundFacade_getUserStatisticsProfit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/getWithdrawCode", desc = "获取提现手机验证码")
    public String _fundFacade_getWithdrawCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/isOpenFund", desc = "判断当前登录用户是否开通基金账户")
    public String _fundFacade_isOpenFund(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/openFundAccount", desc = "基金开户")
    public String _fundFacade_openFundAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/queryAllQuickBankAccount", desc = "查询会员绑定的所有快捷卡信息")
    public String _fundFacade_queryAllQuickBankAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/queryBankAccount", desc = "查询会员绑定的银行卡信息")
    public String _fundFacade_queryBankAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/queryFundOrder", desc = "查询基金交易订单")
    public String _fundFacade_queryFundOrder(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/queryFundRates", desc = "查询年化利率和万份收益信息")
    public String _fundFacade_queryFundRates(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/queryProfitDate", desc = "本次转入后收益发放时间")
    public String _fundFacade_queryProfitDate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/queryWithdrawBankAccount", desc = "查询会员可提现的银行卡信息")
    public String _fundFacade_queryWithdrawBankAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundFacade/withdraw", desc = "提现")
    public String _fundFacade_withdraw(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/kjtGatewayFacade/execute", desc = "kjt会员接口统一封装")
    public String _kjtGatewayFacade_execute(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/kjtGatewayFacade/getKjtIdByLoginName", desc = "根据登录名查询KJT ID")
    public String _kjtGatewayFacade_getKjtIdByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/batchOpenCustodyAccount", desc = "批量开通存管户")
    public String _memberFacade_batchOpenCustodyAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/bindingMobilephone", desc = "绑定手机号(包括外籍用户)")
    public String _memberFacade_bindingMobilephone(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/checkBindingMobilephone", desc = "检查手机号是否能被绑定(包括外籍用户)")
    public String _memberFacade_checkBindingMobilephone(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/checkCustodyAccountStatus", desc = "查询存管户状态")
    public String _memberFacade_checkCustodyAccountStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/checkPayPassword", desc = "验证支付密码")
    public String _memberFacade_checkPayPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/checkWhetherLoginNameExists", desc = "校验登陆名是否已经存在")
    public String _memberFacade_checkWhetherLoginNameExists(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getCompanyAuth", desc = "获取企业会员权限")
    public String _memberFacade_getCompanyAuth(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getHryIdFromMemberId", desc = "根据kjtId查询hryId")
    public String _memberFacade_getHryIdFromMemberId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getIdVerificationStatus", desc = "查询会员的身份认证状态")
    public String _memberFacade_getIdVerificationStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getInvestmentProperty", desc = "获取用户投资资产信息")
    public String _memberFacade_getInvestmentProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getKjtProperty", desc = "获取用户kjt方面资产信息")
    public String _memberFacade_getKjtProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getLcjProperty", desc = "获取用户理财金资产信息")
    public String _memberFacade_getLcjProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getLcjRecord", desc = "获取用户理财金信息")
    public String _memberFacade_getLcjRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getLcjStatisticsByStatus", desc = "根据状态统计理财金信息")
    public String _memberFacade_getLcjStatisticsByStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getMemberByHryId", desc = "根据hryId获取用户信息(从hry数据库获取信息，包括外籍用户)")
    public String _memberFacade_getMemberByHryId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getMemberCount", desc = "获取平台所有用户数")
    public String _memberFacade_getMemberCount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getMemberIdByCardIdAndHryId", desc = "根据用户id获取身份证，然后通过身份证获取对应的绑定用户id(从hry数据库获取信息，包括外籍用户)")
    public String _memberFacade_getMemberIdByCardIdAndHryId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getMemberVerifyInfo", desc = "查询会员的认证信息")
    public String _memberFacade_getMemberVerifyInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getMemberVerifyLevel", desc = "查询会员的认证等级")
    public String _memberFacade_getMemberVerifyLevel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getProperty", desc = "获取用户资产信息,目前只提供理财金、基金份额查询")
    public String _memberFacade_getProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getUserBasicInfoByHryId", desc = "根据用户id获得用户身份信息")
    public String _memberFacade_getUserBasicInfoByHryId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/grantCompanyAuth", desc = "为企业会员授权")
    public String _memberFacade_grantCompanyAuth(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/identifyForeignerInfo", desc = "认证外籍用户身份信息(只限港澳台和外籍用户)")
    public String _memberFacade_identifyForeignerInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/openCustodyAccount", desc = "存管开户")
    public String _memberFacade_openCustodyAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/openCustodyAccountQuick", desc = "快速存管开户")
    public String _memberFacade_openCustodyAccountQuick(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryBankNameByCardNo", desc = "根据卡号查询银行名称")
    public String _memberFacade_queryBankNameByCardNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryCunguanBankInfoByCardNo", desc = "根据卡号查询存管支持银行信息")
    public String _memberFacade_queryCunguanBankInfoByCardNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryForeignerVerifyInfo", desc = "查询外籍用户身份认证情况(只限港澳台和外籍用户)")
    public String _memberFacade_queryForeignerVerifyInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryIdCardHang", desc = "查询身份证是否挂起")
    public String _memberFacade_queryIdCardHang(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryLcjListByStatus", desc = "根据状态获取理财金详情")
    public String _memberFacade_queryLcjListByStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryLcjSyncRecord", desc = "查询理财金同步信息")
    public String _memberFacade_queryLcjSyncRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryMemberBasicInfoFromKjt", desc = "从快捷通查询用户信息(包括外籍用户)")
    public String _memberFacade_queryMemberBasicInfoFromKjt(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryMemberByHryIdList", desc = "根据hryIdList获取批量用户信息")
    public String _memberFacade_queryMemberByHryIdList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryMemberByLoginNameList", desc = "根据LoginNameList获取批量用户信息")
    public String _memberFacade_queryMemberByLoginNameList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryMemberStatusInfo", desc = "查询用户状态信息(包括外籍用户)")
    public String _memberFacade_queryMemberStatusInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryRealNameInfo", desc = "查询实名认证信息")
    public String _memberFacade_queryRealNameInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryUserGroupInfo", desc = "查询用户组的信息")
    public String _memberFacade_queryUserGroupInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/registerUserOnStepOne", desc = "注册页面1点下一步(包括外籍用户)")
    public String _memberFacade_registerUserOnStepOne(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/resetLoginPassword", desc = "重置登陆密码，仅仅限于以QYZH开头的账号")
    public String _memberFacade_resetLoginPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/sendMessage", desc = "发送站内信")
    public String _memberFacade_sendMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/sendMobileVerificationCode", desc = "发送手机校验码")
    public String _memberFacade_sendMobileVerificationCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/setMemberGroupId", desc = "设置用户的用户组Id")
    public String _memberFacade_setMemberGroupId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/setPaymentPassword", desc = "设置支付密码")
    public String _memberFacade_setPaymentPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/updateCustodyAccountStatus", desc = "更新存管户状态")
    public String _memberFacade_updateCustodyAccountStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/uploadPhotocopy", desc = "上传身份证影印件")
    public String _memberFacade_uploadPhotocopy(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/verifyIdCardNumberAgainstRealName", desc = "验证真实姓名与身份证号是否一致,如果一致将其保存")
    public String _memberFacade_verifyIdCardNumberAgainstRealName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/verifyMobileVerificationCode", desc = "验证手机校验码")
    public String _memberFacade_verifyMobileVerificationCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/verifyRealNameAndBindingMobilephote", desc = "实姓认证和手机号绑定")
    public String _memberFacade_verifyRealNameAndBindingMobilephote(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageFacade/deleteMessage", desc = "删除信息")
    public String _messageFacade_deleteMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageFacade/getMessageInfoList", desc = "获取信息列表")
    public String _messageFacade_getMessageInfoList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageFacade/setMessageToRead", desc = "设置信息为已读")
    public String _messageFacade_setMessageToRead(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sessionFacade/authCode", desc = "验证码验证")
    public String _sessionFacade_authCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sessionFacade/authSmsCode", desc = "短信验证码验证")
    public String _sessionFacade_authSmsCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sessionFacade/getCurrentMember", desc = "根据token从Session中获取用户信息")
    public String _sessionFacade_getCurrentMember(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/sessionFacade/initUser", desc = "初始化用户信息")
    public String _sessionFacade_initUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
