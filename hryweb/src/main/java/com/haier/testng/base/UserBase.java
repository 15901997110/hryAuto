package com.haier.testng.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.util.HryHttpClientUtil;
import com.haier.config.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
/**
 * @Description: UserBase
 * @Author: 自动生成
 * @Date: 2018/08/08 17:35:33
 */
@SuppressWarnings("Duplicates")
@Slf4j
@SKey("User")
public class UserBase{
    public Integer serviceId;
    public Integer envId;
    public String caseDesigner;
    public JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型
    public String baseUrl;//http://host:port
    public String dbInfo;
    public Tservice tservice;
    public Tservicedetail tservicedetail;
    public RunService runService = SpringContextHolder.getBean(RunService.class);

    public void init(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        this.serviceId = serviceId;
        this.envId = envId;
        this.caseDesigner = caseDesigner;
        if (StringUtils.isNotBlank(i_c)) {
            this.i_c_JSONObject = JSONObject.parseObject(i_c);
        }
        tservice = runService.getTservice(this.serviceId);
        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);
        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + "://" + tservicedetail.getHostinfo();
        dbInfo = tservicedetail.getDbinfo();
    }

    public Object[] provider(Method method) {
        Object[] objects;
        String iUri;
        //testName可能未填写
        try {
            iUri = method.getAnnotation(Test.class).testName();
            if (iUri == null || "".equals(iUri)) {
                Reporter.log("测试方法中没有没有@Test(testName=\"\")注解");
                throw new SkipException("测试方法中没有没有@Test(testName=\"\")注解");
            }
        } catch (NullPointerException e) {
            log.error("获取测试方法的@Test注解异常:" + method.getName(), e);
            throw new SkipException("获取测试方法的@Test注解异常");
        }

        Ti ti = runService.getTi(this.serviceId, iUri);
        if (ti == null) {
            throw new SkipException("测试服务下面没有接口:" + iUri);
        }
        //此接口对应的全部用例
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        if (tcases == null || tcases.size() == 0) {
            throw new SkipException("此接口无可用的测试用例");
        }

        //如果用户有定制测试用例,则使用用户定制的用例来进行测试
        if (this.i_c_JSONObject != null && this.i_c_JSONObject.size() > 0) {
            JSONArray customCaseArray = i_c_JSONObject.getJSONArray(method.getName());
            if (customCaseArray != null && customCaseArray.size() > 0) {
                Iterator<Tcase> iterator = tcases.iterator();
                while (iterator.hasNext()) {
                    Tcase tcase = iterator.next();
                    //数据库中查到的caseid不在定制列表中,则移除掉
                    if (!customCaseArray.contains(tcase.getId())) {
                        iterator.remove();
                    }
                }
            }
        }
        objects = new Object[tcases.size()];
        for (int i = 0; i < tcases.size(); i++) {
            Params params = new Params();
            params.setTi(ti);
            params.setTcase(tcases.get(i));
            objects[i] = params;
        }
        return objects;
    }

    @Uri(value = "/accountFacade/balanceCheckDetail", desc = "日终余额校验明细")
    public String accountFacade_balanceCheckDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/queryAccount", desc = "账单查询")
    public String accountFacade_queryAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/queryAccountBalanceByUserId", desc = "账单查询-根据用户ID查询账户余额")
    public String accountFacade_queryAccountBalanceByUserId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/queryAccountByUserId", desc = "账单查询-根据用户ID按时间倒序查询")
    public String accountFacade_queryAccountByUserId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/queryAccountFlowBackEnd", desc = "账单查询-后端使用")
    public String accountFacade_queryAccountFlowBackEnd(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/queryAccountFlowByLoginNameListAndTime", desc = "账单查询-根据登录名列表和账务开始、结束时间")
    public String accountFacade_queryAccountFlowByLoginNameListAndTime(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/queryUserInfoCheckFileResult", desc = "查询对账结果")
    public String accountFacade_queryUserInfoCheckFileResult(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/queryUserInfoCheckFileResultDetails", desc = "查询对账结果详情")
    public String accountFacade_queryUserInfoCheckFileResultDetails(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/recheckAccount", desc = "手动发起重新对账")
    public String accountFacade_recheckAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/userCheckDetail", desc = "客户信息校验明细")
    public String accountFacade_userCheckDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/activateStockedUser", desc = "会员激活")
    public String lanmaoGatewayFacade_activateStockedUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/auditBindCard", desc = "换卡审核")
    public String lanmaoGatewayFacade_auditBindCard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/bindCardGeneral", desc = "个人和企业直连换卡")
    public String lanmaoGatewayFacade_bindCardGeneral(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/checkPassword", desc = "校验密码")
    public String lanmaoGatewayFacade_checkPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/enterpriseBindBankcard", desc = "企业换绑卡")
    public String lanmaoGatewayFacade_enterpriseBindBankcard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/enterpriseInformationUpdate", desc = "企业信息变更")
    public String lanmaoGatewayFacade_enterpriseInformationUpdate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/enterpriseRegister", desc = "企业绑卡注册")
    public String lanmaoGatewayFacade_enterpriseRegister(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/modifyMobile", desc = "预留手机号更新")
    public String lanmaoGatewayFacade_modifyMobile(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/personalBindBankcardExpand", desc = "个人换绑卡")
    public String lanmaoGatewayFacade_personalBindBankcardExpand(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/personalRegister", desc = "个人绑卡注册")
    public String lanmaoGatewayFacade_personalRegister(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/queryUserInformation", desc = "用户信息查询")
    public String lanmaoGatewayFacade_queryUserInformation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/resetPassword", desc = "修改密码")
    public String lanmaoGatewayFacade_resetPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoGatewayFacade/userAuthorization", desc = "用户授权")
    public String lanmaoGatewayFacade_userAuthorization(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loanQuotaFacade/freezeLoanAmount", desc = "冻结借款额度")
    public String loanQuotaFacade_freezeLoanAmount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loanQuotaFacade/queryLoanQuota", desc = "借款额度查询")
    public String loanQuotaFacade_queryLoanQuota(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loanQuotaFacade/returnLoanAmount", desc = "归还额度")
    public String loanQuotaFacade_returnLoanAmount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loanQuotaFacade/unfreezeLoanAmount", desc = "解冻借款额度")
    public String loanQuotaFacade_unfreezeLoanAmount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loanQuotaFacade/useLoanAmount", desc = "使用额度")
    public String loanQuotaFacade_useLoanAmount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/generateCode", desc = "验证码生成接口")
    public String loginFacade_generateCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/getUserInfoByToken", desc = "根据登录token获取用户信息")
    public String loginFacade_getUserInfoByToken(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/inLoginRisk", desc = "登录风险控制内部接口")
    public String loginFacade_inLoginRisk(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/inRegisterRisk", desc = "注册风险控制内部接口")
    public String loginFacade_inRegisterRisk(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/login", desc = "非投资用户登录")
    public String loginFacade_login(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/logout", desc = "账号退出")
    public String loginFacade_logout(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/regist", desc = "账号注册")
    public String loginFacade_regist(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/sendEmailAuthCode", desc = "发送邮箱验证码")
    public String loginFacade_sendEmailAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/sendMobileAuthCode", desc = "发送手机验证码")
    public String loginFacade_sendMobileAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/sendMobileAuthCodeByToken", desc = "根据校验码token发送验证码")
    public String loginFacade_sendMobileAuthCodeByToken(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/updateBindingMobile", desc = "修改绑定手机号")
    public String loginFacade_updateBindingMobile(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/updateLoginPassword", desc = "修改登录密码")
    public String loginFacade_updateLoginPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/updateLoginPasswordByOriginPassword", desc = "根据原密码修改登录密码")
    public String loginFacade_updateLoginPasswordByOriginPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/validateEmailAuthCode", desc = "验证邮箱验证码")
    public String loginFacade_validateEmailAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/validateIdCardNo", desc = "校验身份证号码")
    public String loginFacade_validateIdCardNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/loginFacade/validateMobileAuthCode", desc = "验证手机验证码")
    public String loginFacade_validateMobileAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/nonInvestorFacade/getPlatformUserInfoByUserNo", desc = "根据平台用户编号查询平台用户信息")
    public String nonInvestorFacade_getPlatformUserInfoByUserNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/nonInvestorFacade/setSubRole", desc = "设置二级角色")
    public String nonInvestorFacade_setSubRole(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/nonInvestorFacade/setSubRoleByLoginName", desc = "根据用户名设置二级角色")
    public String nonInvestorFacade_setSubRoleByLoginName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/oauthFacade/getAccessCode", desc = "获取access_code")
    public String oauthFacade_getAccessCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/oauthFacade/getUserIdByToken", desc = "根据token获取用户ID")
    public String oauthFacade_getUserIdByToken(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/oauthFacade/queryTokenByAccessCode", desc = "根据access_code获取token")
    public String oauthFacade_queryTokenByAccessCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/oauthFacade/refreshAccessToken", desc = "根据refreshToken刷新accessToken")
    public String oauthFacade_refreshAccessToken(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/oauthFacade/validateOauthClient", desc = "验证客户端")
    public String oauthFacade_validateOauthClient(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/riskManagermentFacade/cardModigyRiskManager", desc = "银行卡切换风险控制")
    public String riskManagermentFacade_cardModigyRiskManager(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/riskManagermentFacade/loginRiskManager", desc = "登录风险控制")
    public String riskManagermentFacade_loginRiskManager(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/riskManagermentFacade/openDepositoryRiskManager", desc = "开通存管风险控制")
    public String riskManagermentFacade_openDepositoryRiskManager(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/riskManagermentFacade/registerRiskManager", desc = "注册风险控制")
    public String riskManagermentFacade_registerRiskManager(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userCommonFacade/clearCache", desc = "根据缓存key清理缓存")
    public String userCommonFacade_clearCache(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userCommonFacade/getAllCacheNames", desc = "获取所有的缓存名称")
    public String userCommonFacade_getAllCacheNames(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userCommonFacade/viewCacheDetail", desc = "查看缓存值")
    public String userCommonFacade_viewCacheDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/addUserExtraInfo", desc = "添加借款人附加信息")
    public String userConsoleFacade_addUserExtraInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/deleteUserExtraAttachment", desc = "删除借款人附加附件")
    public String userConsoleFacade_deleteUserExtraAttachment(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/executeTask", desc = "执行任务")
    public String userConsoleFacade_executeTask(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/getAllAccountType", desc = "查询所有的账务类型")
    public String userConsoleFacade_getAllAccountType(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/getBankAuditDetail", desc = "查询银行卡审核详细信息")
    public String userConsoleFacade_getBankAuditDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/queryAccountflow", desc = "账单查询-后端使用")
    public String userConsoleFacade_queryAccountflow(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/queryAuthUsers", desc = "查询授权用户")
    public String userConsoleFacade_queryAuthUsers(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/queryBankAuditList", desc = "查询银行卡审核记录列表")
    public String userConsoleFacade_queryBankAuditList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/queryEnterpriseDetail", desc = "根据用户id查询用户详细信息")
    public String userConsoleFacade_queryEnterpriseDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/queryPersonalDetail", desc = "根据用户id查询用户详细信息")
    public String userConsoleFacade_queryPersonalDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/queryUserList", desc = "根据条件查询用户列表")
    public String userConsoleFacade_queryUserList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/resetWrongTimes", desc = "置密码错误次数")
    public String userConsoleFacade_resetWrongTimes(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/riskAudit", desc = "风控审核")
    public String userConsoleFacade_riskAudit(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/upateUserState", desc = "更改用户状态")
    public String userConsoleFacade_upateUserState(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/uploadBankAuditFile", desc = "上传审核附件")
    public String userConsoleFacade_uploadBankAuditFile(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userConsoleFacade/uploadImageFile", desc = "no desc")
    public String userConsoleFacade_uploadImageFile(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/checkBankCardAudit", desc = "检查用户换绑卡审核记录状态")
    public String userFacade_checkBankCardAudit(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/checkEnterpriseUpdateProcess", desc = "检查企业修改信息审核记录状态")
    public String userFacade_checkEnterpriseUpdateProcess(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/checkLoginNameExists", desc = "检查用户名是否存在")
    public String userFacade_checkLoginNameExists(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getAuth", desc = "根据用户id查询授权信息")
    public String userFacade_getAuth(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getBankCardBindingList", desc = "根据用户id查询绑卡列表(适用于个人,企业)")
    public String userFacade_getBankCardBindingList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getBaseInfoByUserIds", desc = "批量查询用户基本信息")
    public String userFacade_getBaseInfoByUserIds(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getEnterpriseInfoByLoginName", desc = "根据登陆名查询企业信息")
    public String userFacade_getEnterpriseInfoByLoginName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getEnterpriseInfoByUserId", desc = "根据用户id查询企业信息")
    public String userFacade_getEnterpriseInfoByUserId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getInvestProfit", desc = "获得用户收益")
    public String userFacade_getInvestProfit(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getPersonalInfoByLoginName", desc = "根据登陆名查询个人信息")
    public String userFacade_getPersonalInfoByLoginName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getPersonalInfoByUserId", desc = "根据用户id查询个人信息")
    public String userFacade_getPersonalInfoByUserId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getPersonalRealName", desc = "根据用户id查询个人实名信息")
    public String userFacade_getPersonalRealName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getPersonalRealNameByUserIds", desc = "批量查询个人实名信息")
    public String userFacade_getPersonalRealNameByUserIds(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getUnionUserByLoginName", desc = "根据登陆名查询UnionUser")
    public String userFacade_getUnionUserByLoginName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getUserExtraInfo", desc = "获取借款人附加信息")
    public String userFacade_getUserExtraInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getUserIdWithSameIdCardNo", desc = "根据证件类型+证件号查询全部的个人userId")
    public String userFacade_getUserIdWithSameIdCardNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getUserInfoByLoginName", desc = "根据登陆名查询基本信息")
    public String userFacade_getUserInfoByLoginName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getUserInfoByUserId", desc = "根据用户id查询基本信息")
    public String userFacade_getUserInfoByUserId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getUserProperty", desc = "获得用户资产统计")
    public String userFacade_getUserProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getZDEnterpriseState", desc = "根据登陆名和银行卡号查询企业状态(适用于显性开户)")
    public String userFacade_getZDEnterpriseState(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/getZDPersonalState", desc = "根据用户证件号+银行卡号+渠道标识查询个人状态(适用于显性开户)")
    public String userFacade_getZDPersonalState(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/initInvestorUser", desc = "初始化投资用户")
    public String userFacade_initInvestorUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/isCunguanTestingUser", desc = "是否是存管测试用户")
    public String userFacade_isCunguanTestingUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/queryBankList", desc = "查询银行卡列表")
    public String userFacade_queryBankList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/updateEnterpriseBankCardInfo", desc = "新增或更新企业银行卡信息")
    public String userFacade_updateEnterpriseBankCardInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/updateEnterpriseBaseInfo", desc = "新增或更新企业基本信息")
    public String userFacade_updateEnterpriseBaseInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/updateEnterpriseLegalInfo", desc = "新增或更新企业法人信息")
    public String userFacade_updateEnterpriseLegalInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/updateGroupId", desc = "根据userId更新groupId")
    public String userFacade_updateGroupId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/updateUserInfo", desc = "更新用户信息(适用于更新绑定手机,企业联系人,企业联系人手机,银行卡,银行预留手机)")
    public String userFacade_updateUserInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/userFacade/verifyPasswordByRequestNo", desc = "根据请求号验证密码")
    public String userFacade_verifyPasswordByRequestNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

}
