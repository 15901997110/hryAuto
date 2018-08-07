package com.haier.testng.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.util.AssertUtil;
import com.haier.util.BeforeUtil;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("Duplicates")
@Slf4j
public class User{
private Integer serviceId;
    private Integer envId;
    private String caseDesigner;
    private String i_c;//接收外部传参,定制的用例
    private JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型
    private String baseUrl;//http://host:port
    private String url;
    private Tservice tservice;
    private Tservicedetail tservicedetail;
    private RunService runService = SpringContextHolder.getBean(RunService.class);
@Parameters({"serviceId", "envId", "caseDesigner", "i_c"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        this.serviceId = serviceId;
        this.envId = envId;
        this.caseDesigner = caseDesigner;
        this.i_c = i_c;
        if (this.i_c != null && !"".equals(this.i_c)) {
            this.i_c_JSONObject = JSONObject.parseObject(i_c);
        }
        tservice = runService.getTservice(this.serviceId);
        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);
        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + "://" + tservicedetail.getHostinfo();
    }
  @DataProvider(name = "provider")
    public Object[] getCase(Method method) {

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
            throw new SkipException("测试服务下面没有接口:"+iUri);
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
  public Boolean getBoolResult(Params params) {
        if (params == null || params.getTcase() == null || params.getTcase() == null) {
            return false;
        }
        Ti ti = params.getTi();
        Tcase tcase = params.getTcase();
        url = baseUrl + ti.getIuri();
        String requestParam = BeforeUtil.replace(tcase.getRequestparam(), tservicedetail.getDbinfo(),this);
        Reporter.log("实际请求参数 : ");
        Reporter.log(requestParam);
        String actual = HryHttpClientUtil.send(url, ti.getIrequestmethod(), ti.getIcontenttype(), ti.getIparamtype(), requestParam);
        return AssertUtil.supperAssert(tcase.getAsserttype(), tcase.getExpected(), actual, ti.getIresponsetype());
    }
    @Test(testName = "/accountFacade/balanceCheckDetail", dataProvider = "provider", description = "日终余额校验明细")
    public void accountFacade_balanceCheckDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/queryAccount", dataProvider = "provider", description = "账单查询")
    public void accountFacade_queryAccount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/queryAccountBalanceByUserId", dataProvider = "provider", description = "账单查询-根据用户ID查询账户余额")
    public void accountFacade_queryAccountBalanceByUserId(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/queryAccountByUserId", dataProvider = "provider", description = "账单查询-根据用户ID按时间倒序查询")
    public void accountFacade_queryAccountByUserId(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/queryAccountFlowBackEnd", dataProvider = "provider", description = "账单查询-后端使用")
    public void accountFacade_queryAccountFlowBackEnd(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/queryAccountFlowByLoginNameListAndTime", dataProvider = "provider", description = "账单查询-根据登录名列表和账务开始、结束时间")
    public void accountFacade_queryAccountFlowByLoginNameListAndTime(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/queryUserInfoCheckFileResult", dataProvider = "provider", description = "查询对账结果")
    public void accountFacade_queryUserInfoCheckFileResult(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/queryUserInfoCheckFileResultDetails", dataProvider = "provider", description = "查询对账结果详情")
    public void accountFacade_queryUserInfoCheckFileResultDetails(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/recheckAccount", dataProvider = "provider", description = "手动发起重新对账")
    public void accountFacade_recheckAccount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/userCheckDetail", dataProvider = "provider", description = "客户信息校验明细")
    public void accountFacade_userCheckDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/activateStockedUser", dataProvider = "provider", description = "会员激活")
    public void lanmaoGatewayFacade_activateStockedUser(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/auditBindCard", dataProvider = "provider", description = "换卡审核")
    public void lanmaoGatewayFacade_auditBindCard(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/bindCardGeneral", dataProvider = "provider", description = "个人和企业直连换卡")
    public void lanmaoGatewayFacade_bindCardGeneral(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/checkPassword", dataProvider = "provider", description = "校验密码")
    public void lanmaoGatewayFacade_checkPassword(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/enterpriseBindBankcard", dataProvider = "provider", description = "企业换绑卡")
    public void lanmaoGatewayFacade_enterpriseBindBankcard(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/enterpriseInformationUpdate", dataProvider = "provider", description = "企业信息变更")
    public void lanmaoGatewayFacade_enterpriseInformationUpdate(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/enterpriseRegister", dataProvider = "provider", description = "企业绑卡注册")
    public void lanmaoGatewayFacade_enterpriseRegister(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/modifyMobile", dataProvider = "provider", description = "预留手机号更新")
    public void lanmaoGatewayFacade_modifyMobile(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/personalBindBankcardExpand", dataProvider = "provider", description = "个人换绑卡")
    public void lanmaoGatewayFacade_personalBindBankcardExpand(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/personalRegister", dataProvider = "provider", description = "个人绑卡注册")
    public void lanmaoGatewayFacade_personalRegister(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/queryUserInformation", dataProvider = "provider", description = "用户信息查询")
    public void lanmaoGatewayFacade_queryUserInformation(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/resetPassword", dataProvider = "provider", description = "修改密码")
    public void lanmaoGatewayFacade_resetPassword(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoGatewayFacade/userAuthorization", dataProvider = "provider", description = "用户授权")
    public void lanmaoGatewayFacade_userAuthorization(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loanQuotaFacade/freezeLoanAmount", dataProvider = "provider", description = "冻结借款额度")
    public void loanQuotaFacade_freezeLoanAmount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loanQuotaFacade/queryLoanQuota", dataProvider = "provider", description = "借款额度查询")
    public void loanQuotaFacade_queryLoanQuota(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loanQuotaFacade/returnLoanAmount", dataProvider = "provider", description = "归还额度")
    public void loanQuotaFacade_returnLoanAmount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loanQuotaFacade/unfreezeLoanAmount", dataProvider = "provider", description = "解冻借款额度")
    public void loanQuotaFacade_unfreezeLoanAmount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loanQuotaFacade/useLoanAmount", dataProvider = "provider", description = "使用额度")
    public void loanQuotaFacade_useLoanAmount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/generateCode", dataProvider = "provider", description = "验证码生成接口")
    public void loginFacade_generateCode(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/getUserInfoByToken", dataProvider = "provider", description = "根据登录token获取用户信息")
    public void loginFacade_getUserInfoByToken(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/inLoginRisk", dataProvider = "provider", description = "登录风险控制内部接口")
    public void loginFacade_inLoginRisk(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/inRegisterRisk", dataProvider = "provider", description = "注册风险控制内部接口")
    public void loginFacade_inRegisterRisk(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/login", dataProvider = "provider", description = "非投资用户登录")
    public void loginFacade_login(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/logout", dataProvider = "provider", description = "账号退出")
    public void loginFacade_logout(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/regist", dataProvider = "provider", description = "账号注册")
    public void loginFacade_regist(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/sendEmailAuthCode", dataProvider = "provider", description = "发送邮箱验证码")
    public void loginFacade_sendEmailAuthCode(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/sendMobileAuthCode", dataProvider = "provider", description = "发送手机验证码")
    public void loginFacade_sendMobileAuthCode(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/sendMobileAuthCodeByToken", dataProvider = "provider", description = "根据校验码token发送验证码")
    public void loginFacade_sendMobileAuthCodeByToken(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/updateBindingMobile", dataProvider = "provider", description = "修改绑定手机号")
    public void loginFacade_updateBindingMobile(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/updateLoginPassword", dataProvider = "provider", description = "修改登录密码")
    public void loginFacade_updateLoginPassword(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/updateLoginPasswordByOriginPassword", dataProvider = "provider", description = "根据原密码修改登录密码")
    public void loginFacade_updateLoginPasswordByOriginPassword(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/validateEmailAuthCode", dataProvider = "provider", description = "验证邮箱验证码")
    public void loginFacade_validateEmailAuthCode(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/validateIdCardNo", dataProvider = "provider", description = "校验身份证号码")
    public void loginFacade_validateIdCardNo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/loginFacade/validateMobileAuthCode", dataProvider = "provider", description = "验证手机验证码")
    public void loginFacade_validateMobileAuthCode(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/nonInvestorFacade/getPlatformUserInfoByUserNo", dataProvider = "provider", description = "根据平台用户编号查询平台用户信息")
    public void nonInvestorFacade_getPlatformUserInfoByUserNo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/nonInvestorFacade/setSubRole", dataProvider = "provider", description = "设置二级角色")
    public void nonInvestorFacade_setSubRole(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/nonInvestorFacade/setSubRoleByLoginName", dataProvider = "provider", description = "根据用户名设置二级角色")
    public void nonInvestorFacade_setSubRoleByLoginName(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/oauthFacade/getAccessCode", dataProvider = "provider", description = "获取access_code")
    public void oauthFacade_getAccessCode(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/oauthFacade/getUserIdByToken", dataProvider = "provider", description = "根据token获取用户ID")
    public void oauthFacade_getUserIdByToken(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/oauthFacade/queryTokenByAccessCode", dataProvider = "provider", description = "根据access_code获取token")
    public void oauthFacade_queryTokenByAccessCode(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/oauthFacade/refreshAccessToken", dataProvider = "provider", description = "根据refreshToken刷新accessToken")
    public void oauthFacade_refreshAccessToken(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/oauthFacade/validateOauthClient", dataProvider = "provider", description = "验证客户端")
    public void oauthFacade_validateOauthClient(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/riskManagermentFacade/cardModigyRiskManager", dataProvider = "provider", description = "银行卡切换风险控制")
    public void riskManagermentFacade_cardModigyRiskManager(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/riskManagermentFacade/loginRiskManager", dataProvider = "provider", description = "登录风险控制")
    public void riskManagermentFacade_loginRiskManager(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/riskManagermentFacade/openDepositoryRiskManager", dataProvider = "provider", description = "开通存管风险控制")
    public void riskManagermentFacade_openDepositoryRiskManager(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/riskManagermentFacade/registerRiskManager", dataProvider = "provider", description = "注册风险控制")
    public void riskManagermentFacade_registerRiskManager(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userCommonFacade/clearCache", dataProvider = "provider", description = "根据缓存key清理缓存")
    public void userCommonFacade_clearCache(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userCommonFacade/getAllCacheNames", dataProvider = "provider", description = "获取所有的缓存名称")
    public void userCommonFacade_getAllCacheNames(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userCommonFacade/viewCacheDetail", dataProvider = "provider", description = "查看缓存值")
    public void userCommonFacade_viewCacheDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/addUserExtraInfo", dataProvider = "provider", description = "添加借款人附加信息")
    public void userConsoleFacade_addUserExtraInfo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/deleteUserExtraAttachment", dataProvider = "provider", description = "删除借款人附加附件")
    public void userConsoleFacade_deleteUserExtraAttachment(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/executeTask", dataProvider = "provider", description = "执行任务")
    public void userConsoleFacade_executeTask(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/getAllAccountType", dataProvider = "provider", description = "查询所有的账务类型")
    public void userConsoleFacade_getAllAccountType(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/getBankAuditDetail", dataProvider = "provider", description = "查询银行卡审核详细信息")
    public void userConsoleFacade_getBankAuditDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/queryAccountflow", dataProvider = "provider", description = "账单查询-后端使用")
    public void userConsoleFacade_queryAccountflow(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/queryAuthUsers", dataProvider = "provider", description = "查询授权用户")
    public void userConsoleFacade_queryAuthUsers(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/queryBankAuditList", dataProvider = "provider", description = "查询银行卡审核记录列表")
    public void userConsoleFacade_queryBankAuditList(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/queryEnterpriseDetail", dataProvider = "provider", description = "根据用户id查询用户详细信息")
    public void userConsoleFacade_queryEnterpriseDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/queryPersonalDetail", dataProvider = "provider", description = "根据用户id查询用户详细信息")
    public void userConsoleFacade_queryPersonalDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/queryUserList", dataProvider = "provider", description = "根据条件查询用户列表")
    public void userConsoleFacade_queryUserList(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/resetWrongTimes", dataProvider = "provider", description = "置密码错误次数")
    public void userConsoleFacade_resetWrongTimes(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/riskAudit", dataProvider = "provider", description = "风控审核")
    public void userConsoleFacade_riskAudit(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/upateUserState", dataProvider = "provider", description = "更改用户状态")
    public void userConsoleFacade_upateUserState(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/uploadBankAuditFile", dataProvider = "provider", description = "上传审核附件")
    public void userConsoleFacade_uploadBankAuditFile(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userConsoleFacade/uploadImageFile", dataProvider = "provider", description = "no desc")
    public void userConsoleFacade_uploadImageFile(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/checkBankCardAudit", dataProvider = "provider", description = "检查用户换绑卡审核记录状态")
    public void userFacade_checkBankCardAudit(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/checkEnterpriseUpdateProcess", dataProvider = "provider", description = "检查企业修改信息审核记录状态")
    public void userFacade_checkEnterpriseUpdateProcess(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/checkLoginNameExists", dataProvider = "provider", description = "检查用户名是否存在")
    public void userFacade_checkLoginNameExists(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getAuth", dataProvider = "provider", description = "根据用户id查询授权信息")
    public void userFacade_getAuth(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getBankCardBindingList", dataProvider = "provider", description = "根据用户id查询绑卡列表(适用于个人,企业)")
    public void userFacade_getBankCardBindingList(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getBaseInfoByUserIds", dataProvider = "provider", description = "批量查询用户基本信息")
    public void userFacade_getBaseInfoByUserIds(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getEnterpriseInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询企业信息")
    public void userFacade_getEnterpriseInfoByLoginName(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getEnterpriseInfoByUserId", dataProvider = "provider", description = "根据用户id查询企业信息")
    public void userFacade_getEnterpriseInfoByUserId(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getInvestProfit", dataProvider = "provider", description = "获得用户收益")
    public void userFacade_getInvestProfit(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getPersonalInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询个人信息")
    public void userFacade_getPersonalInfoByLoginName(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getPersonalInfoByUserId", dataProvider = "provider", description = "根据用户id查询个人信息")
    public void userFacade_getPersonalInfoByUserId(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getPersonalRealName", dataProvider = "provider", description = "根据用户id查询个人实名信息")
    public void userFacade_getPersonalRealName(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getPersonalRealNameByUserIds", dataProvider = "provider", description = "批量查询个人实名信息")
    public void userFacade_getPersonalRealNameByUserIds(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getUnionUserByLoginName", dataProvider = "provider", description = "根据登陆名查询UnionUser")
    public void userFacade_getUnionUserByLoginName(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getUserExtraInfo", dataProvider = "provider", description = "获取借款人附加信息")
    public void userFacade_getUserExtraInfo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getUserIdWithSameIdCardNo", dataProvider = "provider", description = "根据证件类型+证件号查询全部的个人userId")
    public void userFacade_getUserIdWithSameIdCardNo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getUserInfoByLoginName", dataProvider = "provider", description = "根据登陆名查询基本信息")
    public void userFacade_getUserInfoByLoginName(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getUserInfoByUserId", dataProvider = "provider", description = "根据用户id查询基本信息")
    public void userFacade_getUserInfoByUserId(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getUserProperty", dataProvider = "provider", description = "获得用户资产统计")
    public void userFacade_getUserProperty(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getZDEnterpriseState", dataProvider = "provider", description = "根据登陆名和银行卡号查询企业状态(适用于显性开户)")
    public void userFacade_getZDEnterpriseState(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/getZDPersonalState", dataProvider = "provider", description = "根据用户证件号+银行卡号+渠道标识查询个人状态(适用于显性开户)")
    public void userFacade_getZDPersonalState(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/initInvestorUser", dataProvider = "provider", description = "初始化投资用户")
    public void userFacade_initInvestorUser(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/isCunguanTestingUser", dataProvider = "provider", description = "是否是存管测试用户")
    public void userFacade_isCunguanTestingUser(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/queryBankList", dataProvider = "provider", description = "查询银行卡列表")
    public void userFacade_queryBankList(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/updateEnterpriseBankCardInfo", dataProvider = "provider", description = "新增或更新企业银行卡信息")
    public void userFacade_updateEnterpriseBankCardInfo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/updateEnterpriseBaseInfo", dataProvider = "provider", description = "新增或更新企业基本信息")
    public void userFacade_updateEnterpriseBaseInfo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/updateEnterpriseLegalInfo", dataProvider = "provider", description = "新增或更新企业法人信息")
    public void userFacade_updateEnterpriseLegalInfo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/updateGroupId", dataProvider = "provider", description = "根据userId更新groupId")
    public void userFacade_updateGroupId(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/updateUserInfo", dataProvider = "provider", description = "更新用户信息(适用于更新绑定手机,企业联系人,企业联系人手机,银行卡,银行预留手机)")
    public void userFacade_updateUserInfo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/userFacade/verifyPasswordByRequestNo", dataProvider = "provider", description = "根据请求号验证密码")
    public void userFacade_verifyPasswordByRequestNo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
}
