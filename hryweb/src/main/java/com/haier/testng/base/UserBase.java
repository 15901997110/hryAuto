package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: UserBase
 * @Author: 自动生成
 * @Date: 2018/09/11 19:27:25
 */
@SKey("User")
public class UserBase extends Base {
    @Uri(value = "/accountFacade/balanceCheckDetail", desc = "日终余额校验明细")
    public String _accountFacade_balanceCheckDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryAccount", desc = "账单查询")
    public String _accountFacade_queryAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryAccountBalanceByUserId", desc = "账单查询-根据用户ID查询账户余额")
    public String _accountFacade_queryAccountBalanceByUserId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryAccountByUserId", desc = "账单查询-根据用户ID按时间倒序查询")
    public String _accountFacade_queryAccountByUserId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryAccountFlowBackEnd", desc = "账单查询-后端使用")
    public String _accountFacade_queryAccountFlowBackEnd(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryAccountFlowByLoginNameListAndTime", desc = "账单查询-根据登录名列表和账务开始、结束时间")
    public String _accountFacade_queryAccountFlowByLoginNameListAndTime(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryAccountFlowForApp", desc = "资金流水查询")
    public String _accountFacade_queryAccountFlowForApp(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryUserInfoCheckFileResult", desc = "查询对账结果")
    public String _accountFacade_queryUserInfoCheckFileResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/queryUserInfoCheckFileResultDetails", desc = "查询对账结果详情")
    public String _accountFacade_queryUserInfoCheckFileResultDetails(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/recheckAccount", desc = "手动发起重新对账")
    public String _accountFacade_recheckAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/reorderAccoutFlow", desc = "账单排序")
    public String _accountFacade_reorderAccoutFlow(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/accountFacade/userCheckDetail", desc = "客户信息校验明细")
    public String _accountFacade_userCheckDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/activateStockedUser", desc = "会员激活")
    public String _lanmaoGatewayFacade_activateStockedUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/auditBindCard", desc = "换卡审核")
    public String _lanmaoGatewayFacade_auditBindCard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/bindCardGeneral", desc = "个人和企业直连换卡")
    public String _lanmaoGatewayFacade_bindCardGeneral(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/checkPassword", desc = "校验密码")
    public String _lanmaoGatewayFacade_checkPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/enterpriseBindBankcard", desc = "企业换绑卡")
    public String _lanmaoGatewayFacade_enterpriseBindBankcard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/enterpriseInformationUpdate", desc = "企业信息变更")
    public String _lanmaoGatewayFacade_enterpriseInformationUpdate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/enterpriseRegister", desc = "企业绑卡注册")
    public String _lanmaoGatewayFacade_enterpriseRegister(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/modifyMobile", desc = "预留手机号更新")
    public String _lanmaoGatewayFacade_modifyMobile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/personalBindBankcardExpand", desc = "个人换绑卡")
    public String _lanmaoGatewayFacade_personalBindBankcardExpand(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/personalRegister", desc = "个人绑卡注册")
    public String _lanmaoGatewayFacade_personalRegister(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/queryUserInformation", desc = "用户信息查询")
    public String _lanmaoGatewayFacade_queryUserInformation(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/resetPassword", desc = "修改密码")
    public String _lanmaoGatewayFacade_resetPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/lanmaoGatewayFacade/userAuthorization", desc = "用户授权")
    public String _lanmaoGatewayFacade_userAuthorization(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanQuotaFacade/freezeLoanAmount", desc = "冻结借款额度")
    public String _loanQuotaFacade_freezeLoanAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanQuotaFacade/queryLoanQuota", desc = "借款额度查询")
    public String _loanQuotaFacade_queryLoanQuota(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanQuotaFacade/returnLoanAmount", desc = "归还额度")
    public String _loanQuotaFacade_returnLoanAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanQuotaFacade/unfreezeLoanAmount", desc = "解冻借款额度")
    public String _loanQuotaFacade_unfreezeLoanAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loanQuotaFacade/useLoanAmount", desc = "使用额度")
    public String _loanQuotaFacade_useLoanAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/generateCode", desc = "验证码生成接口")
    public String _loginFacade_generateCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/getUserInfoByToken", desc = "根据登录token获取用户信息")
    public String _loginFacade_getUserInfoByToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/inLoginRisk", desc = "登录风险控制内部接口")
    public String _loginFacade_inLoginRisk(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/inRegisterRisk", desc = "注册风险控制内部接口")
    public String _loginFacade_inRegisterRisk(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/login", desc = "非投资用户登录")
    public String _loginFacade_login(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/logout", desc = "账号退出")
    public String _loginFacade_logout(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/regist", desc = "账号注册")
    public String _loginFacade_regist(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/sendEmailAuthCode", desc = "发送邮箱验证码")
    public String _loginFacade_sendEmailAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/sendMobileAuthCode", desc = "发送手机验证码")
    public String _loginFacade_sendMobileAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/sendMobileAuthCodeByToken", desc = "根据校验码token发送验证码")
    public String _loginFacade_sendMobileAuthCodeByToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/updateBindingMobile", desc = "修改绑定手机号")
    public String _loginFacade_updateBindingMobile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/updateLoginPassword", desc = "修改登录密码")
    public String _loginFacade_updateLoginPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/updateLoginPasswordByOriginPassword", desc = "根据原密码修改登录密码")
    public String _loginFacade_updateLoginPasswordByOriginPassword(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/validateEmailAuthCode", desc = "验证邮箱验证码")
    public String _loginFacade_validateEmailAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/validateIdCardNo", desc = "校验身份证号码")
    public String _loginFacade_validateIdCardNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/loginFacade/validateMobileAuthCode", desc = "验证手机验证码")
    public String _loginFacade_validateMobileAuthCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/nonInvestorFacade/getPlatformUserInfoByUserNo", desc = "根据平台用户编号查询平台用户信息")
    public String _nonInvestorFacade_getPlatformUserInfoByUserNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/nonInvestorFacade/setSubRole", desc = "设置二级角色")
    public String _nonInvestorFacade_setSubRole(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/nonInvestorFacade/setSubRoleByLoginName", desc = "根据用户名设置二级角色")
    public String _nonInvestorFacade_setSubRoleByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oauthFacade/encryptUserId", desc = "userId加密")
    public String _oauthFacade_encryptUserId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oauthFacade/getAccessCode", desc = "获取access_code")
    public String _oauthFacade_getAccessCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oauthFacade/getUserIdByToken", desc = "根据token获取用户ID")
    public String _oauthFacade_getUserIdByToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oauthFacade/queryTokenByAccessCode", desc = "根据access_code获取token")
    public String _oauthFacade_queryTokenByAccessCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oauthFacade/refreshAccessToken", desc = "根据refreshToken刷新accessToken")
    public String _oauthFacade_refreshAccessToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/oauthFacade/validateOauthClient", desc = "验证客户端")
    public String _oauthFacade_validateOauthClient(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/riskManagermentFacade/cardModigyRiskManager", desc = "银行卡切换风险控制")
    public String _riskManagermentFacade_cardModigyRiskManager(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/riskManagermentFacade/loginRiskManager", desc = "登录风险控制")
    public String _riskManagermentFacade_loginRiskManager(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/riskManagermentFacade/openDepositoryRiskManager", desc = "开通存管风险控制")
    public String _riskManagermentFacade_openDepositoryRiskManager(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/riskManagermentFacade/registerRiskManager", desc = "注册风险控制")
    public String _riskManagermentFacade_registerRiskManager(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userCommonFacade/clearCache", desc = "根据缓存key清理缓存")
    public String _userCommonFacade_clearCache(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userCommonFacade/getAllCacheNames", desc = "获取所有的缓存名称")
    public String _userCommonFacade_getAllCacheNames(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userCommonFacade/viewCacheDetail", desc = "查看缓存值")
    public String _userCommonFacade_viewCacheDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/addUserExtraInfo", desc = "添加借款人附加信息")
    public String _userConsoleFacade_addUserExtraInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/deleteUserExtraAttachment", desc = "删除借款人附加附件")
    public String _userConsoleFacade_deleteUserExtraAttachment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/executeTask", desc = "执行任务")
    public String _userConsoleFacade_executeTask(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/getAllAccountType", desc = "查询所有的账务类型")
    public String _userConsoleFacade_getAllAccountType(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/getBankAuditDetail", desc = "查询银行卡审核详细信息")
    public String _userConsoleFacade_getBankAuditDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/queryAccountflow", desc = "账单查询-后端使用")
    public String _userConsoleFacade_queryAccountflow(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/queryAuthUsers", desc = "查询授权用户")
    public String _userConsoleFacade_queryAuthUsers(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/queryBankAuditList", desc = "查询银行卡审核记录列表")
    public String _userConsoleFacade_queryBankAuditList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/queryEnterpriseDetail", desc = "根据用户id查询用户详细信息")
    public String _userConsoleFacade_queryEnterpriseDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/queryPersonalDetail", desc = "根据用户id查询用户详细信息")
    public String _userConsoleFacade_queryPersonalDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/queryUserList", desc = "根据条件查询用户列表")
    public String _userConsoleFacade_queryUserList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/resetWrongTimes", desc = "置密码错误次数")
    public String _userConsoleFacade_resetWrongTimes(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/riskAudit", desc = "风控审核")
    public String _userConsoleFacade_riskAudit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/upateUserState", desc = "更改用户状态")
    public String _userConsoleFacade_upateUserState(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/uploadBankAuditFile", desc = "上传审核附件")
    public String _userConsoleFacade_uploadBankAuditFile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userConsoleFacade/uploadImageFile", desc = "")
    public String _userConsoleFacade_uploadImageFile(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/checkBankCardAudit", desc = "检查用户换绑卡审核记录状态")
    public String _userFacade_checkBankCardAudit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/checkEnterpriseUpdateProcess", desc = "检查企业修改信息审核记录状态")
    public String _userFacade_checkEnterpriseUpdateProcess(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/checkLoginNameExists", desc = "检查用户名是否存在")
    public String _userFacade_checkLoginNameExists(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getAuth", desc = "根据用户id查询授权信息")
    public String _userFacade_getAuth(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getBankCardBindingList", desc = "根据用户id查询绑卡列表(适用于个人,企业)")
    public String _userFacade_getBankCardBindingList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getBaseInfoByUserIds", desc = "批量查询用户基本信息")
    public String _userFacade_getBaseInfoByUserIds(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getEnterpriseInfoByLoginName", desc = "根据登陆名查询企业信息")
    public String _userFacade_getEnterpriseInfoByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getEnterpriseInfoByUserId", desc = "根据用户id查询企业信息")
    public String _userFacade_getEnterpriseInfoByUserId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getInvestProfit", desc = "获得用户收益")
    public String _userFacade_getInvestProfit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getPersonalInfoByLoginName", desc = "根据登陆名查询个人信息")
    public String _userFacade_getPersonalInfoByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getPersonalInfoByUserId", desc = "根据用户id查询个人信息")
    public String _userFacade_getPersonalInfoByUserId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getPersonalRealName", desc = "根据用户id查询个人实名信息")
    public String _userFacade_getPersonalRealName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getPersonalRealNameByUserIds", desc = "批量查询个人实名信息")
    public String _userFacade_getPersonalRealNameByUserIds(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUnionUserByLoginName", desc = "根据登陆名查询UnionUser")
    public String _userFacade_getUnionUserByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUserActionInfoByLoginName", desc = "根据用户名获取用户行为信息")
    public String _userFacade_getUserActionInfoByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUserExtraInfo", desc = "获取借款人附加信息")
    public String _userFacade_getUserExtraInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUserIdWithSameIdCardNo", desc = "根据证件类型+证件号查询全部的个人userId")
    public String _userFacade_getUserIdWithSameIdCardNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUserInfoByLoginName", desc = "根据登陆名查询基本信息")
    public String _userFacade_getUserInfoByLoginName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUserInfoByUserId", desc = "根据用户id查询基本信息")
    public String _userFacade_getUserInfoByUserId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getUserProperty", desc = "获得用户资产统计")
    public String _userFacade_getUserProperty(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getZDPersonalState", desc = "根据用户证件号+银行卡号+渠道标识查询个人状态(适用于显性开户)")
    public String _userFacade_getZDPersonalState(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/getZDUserState", desc = "根据登陆名和银行卡号查询用户状态(适用于显性开户)")
    public String _userFacade_getZDUserState(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/initInvestorUser", desc = "初始化投资用户")
    public String _userFacade_initInvestorUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/isCunguanTestingUser", desc = "是否是存管测试用户")
    public String _userFacade_isCunguanTestingUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/queryBankList", desc = "查询银行卡列表")
    public String _userFacade_queryBankList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/updateEnterpriseBankCardInfo", desc = "新增或更新企业银行卡信息")
    public String _userFacade_updateEnterpriseBankCardInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/updateEnterpriseBaseInfo", desc = "新增或更新企业基本信息")
    public String _userFacade_updateEnterpriseBaseInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/updateEnterpriseLegalInfo", desc = "新增或更新企业法人信息")
    public String _userFacade_updateEnterpriseLegalInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/updateGroupId", desc = "根据userId更新groupId")
    public String _userFacade_updateGroupId(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/updateUserInfo", desc = "更新用户信息(适用于更新绑定手机,企业联系人,企业联系人手机,银行卡,银行预留手机)")
    public String _userFacade_updateUserInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/userFacade/verifyPasswordByRequestNo", desc = "根据请求号验证密码")
    public String _userFacade_verifyPasswordByRequestNo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
