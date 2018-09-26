package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: MemberBase
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@SKey("Member")
public class MemberBase extends Base {
    public MemberBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }
    @Uri(value = "/bankCardFacade/getBankChannel", desc = "根据银行代码和支付金额获取银行渠道")
    public String _bankCardFacade_getBankChannel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/bankCardFacade/queryBankLimitsWithCunguanBankCode", desc = "收银服务限额限次查询和存管银行代码")
    public String _bankCardFacade_queryBankLimitsWithCunguanBankCode(HryTest test) {
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

    @Uri(value = "/customerFacade/generateCode", desc = "验证码生成接口")
    public String _customerFacade_generateCode(HryTest test) {
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

    @Uri(value = "/customerFacade/queryRegisterContract", desc = "查询用户注册合同")
    public String _customerFacade_queryRegisterContract(HryTest test) {
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

    @Uri(value = "/customerFacade/updateLoginPassword", desc = "修改登录密码")
    public String _customerFacade_updateLoginPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/updateLoginPasswordByAuthToken", desc = "根据验证有效token修改登录密码")
    public String _customerFacade_updateLoginPasswordByAuthToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/updateRegisterContract", desc = "创建已同意的注册合同")
    public String _customerFacade_updateRegisterContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/userRegister", desc = "渠道用户注册")
    public String _customerFacade_userRegister(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/validateEmailAuthCode", desc = "验证邮箱验证码")
    public String _customerFacade_validateEmailAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/customerFacade/validateMobileAuthCode", desc = "验证手机验证码")
    public String _customerFacade_validateMobileAuthCode(HryTest test) {
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

    @Uri(value = "/memberFacade/checkCustodyAccountStatus", desc = "查询存管户状态")
    public String _memberFacade_checkCustodyAccountStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getHryIdFromMemberId", desc = "根据kjtId查询hryId")
    public String _memberFacade_getHryIdFromMemberId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/getKjtProperty", desc = "获取用户kjt方面资产信息")
    public String _memberFacade_getKjtProperty(HryTest test) {
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

    @Uri(value = "/memberFacade/getProperty", desc = "获取用户资产信息,目前只提供理财金、基金份额查询")
    public String _memberFacade_getProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryCunguanBankInfoByCardNo", desc = "根据卡号查询存管支持银行信息")
    public String _memberFacade_queryCunguanBankInfoByCardNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryLcjListByStatus", desc = "根据状态获取理财金详情")
    public String _memberFacade_queryLcjListByStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryMemberStatusInfo", desc = "查询用户状态信息(包括外籍用户)")
    public String _memberFacade_queryMemberStatusInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/memberFacade/queryUserGroupInfo", desc = "查询用户组的信息")
    public String _memberFacade_queryUserGroupInfo(HryTest test) {
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

    @Uri(value = "/messageFacade/getMessageInfoList", desc = "获取信息列表")
    public String _messageFacade_getMessageInfoList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageFacade/setMessageToRead", desc = "设置信息为已读")
    public String _messageFacade_setMessageToRead(HryTest test) {
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

    @Uri(value = "/sessionFacade/initUserByUserInfo", desc = "初始化用户信息")
    public String _sessionFacade_initUserByUserInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
