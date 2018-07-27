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
public class Lanmao{
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
        String requestParam = BeforeUtil.replace(tcase.getRequestparam(), tservicedetail.getDbinfo());
        Reporter.log("实际请求参数 : ");
        Reporter.log(requestParam);
        String actual = HryHttpClientUtil.send(url, ti.getIrequestmethod() + 0, ti.getIcontenttype() + 0, ti.getIparamtype() + 0, requestParam);
        return AssertUtil.supperAssert(tcase.getAsserttype() + 0, tcase.getExpected(), actual, ti.getIresponsetype() + 0);
    }
    @Test(testName = "/accountFacade/accountRecharge", dataProvider = "provider", description = "调账充值接口:一键从天天聚迁移至存管余额使用")
    public void accountFacade_accountRecharge(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/activateStockedUser", dataProvider = "provider", description = "会员激活")
    public void accountFacade_activateStockedUser(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/auditBindCard", dataProvider = "provider", description = "换卡审核")
    public void accountFacade_auditBindCard(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/bindCardGeneral", dataProvider = "provider", description = "个人和企业直连换卡")
    public void accountFacade_bindCardGeneral(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/checkPassword", dataProvider = "provider", description = "校验密码")
    public void accountFacade_checkPassword(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/enterpriseBindBankcard", dataProvider = "provider", description = "企业换绑卡")
    public void accountFacade_enterpriseBindBankcard(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/enterpriseEntrustImportUser", dataProvider = "provider", description = "企业委托开户")
    public void accountFacade_enterpriseEntrustImportUser(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/enterpriseInformationUpdate", dataProvider = "provider", description = "企业信息变更")
    public void accountFacade_enterpriseInformationUpdate(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/enterpriseRegister", dataProvider = "provider", description = "企业绑卡注册")
    public void accountFacade_enterpriseRegister(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/entrustImportUser", dataProvider = "provider", description = "个人委托开户")
    public void accountFacade_entrustImportUser(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/modifyMobileExpand", dataProvider = "provider", description = "预留手机号更新")
    public void accountFacade_modifyMobileExpand(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/personalBindBankcardExpand", dataProvider = "provider", description = "个人换绑卡")
    public void accountFacade_personalBindBankcardExpand(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/personalRegister", dataProvider = "provider", description = "个人绑卡注册")
    public void accountFacade_personalRegister(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/resetPassword", dataProvider = "provider", description = "修改密码")
    public void accountFacade_resetPassword(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/accountFacade/unBindBankcard", dataProvider = "provider", description = "解绑银行卡")
    public void accountFacade_unBindBankcard(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/gatewayFacade/notify", dataProvider = "provider", description = "异步回调")
    public void gatewayFacade_notify(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoReconFacade/download", dataProvider = "provider", description = "获取恒丰原始对账文件")
    public void lanmaoReconFacade_download(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoReconFacade/manualRecon", dataProvider = "provider", description = "手工对账接口")
    public void lanmaoReconFacade_manualRecon(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoReconFacade/queryReconInfo", dataProvider = "provider", description = "查询交易对账汇总结果信息")
    public void lanmaoReconFacade_queryReconInfo(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/lanmaoReconFacade/queryReconStatusDetail", dataProvider = "provider", description = "查询具体类型的对账状态详情")
    public void lanmaoReconFacade_queryReconStatusDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryAuthorizationEntrustPayRecord", dataProvider = "provider", description = "委托支付授权记录查询")
    public void queryFacade_queryAuthorizationEntrustPayRecord(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryCancelTransactionSale", dataProvider = "provider", description = "查询取消预处理")
    public void queryFacade_queryCancelTransactionSale(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryDebentureSale", dataProvider = "provider", description = "债权出让查询")
    public void queryFacade_queryDebentureSale(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryGeneralFreeze", dataProvider = "provider", description = "通用冻结查询")
    public void queryFacade_queryGeneralFreeze(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryInterceptWithdraw", dataProvider = "provider", description = "查询提现拦截")
    public void queryFacade_queryInterceptWithdraw(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryPreTransaction", dataProvider = "provider", description = "交易预处理查询")
    public void queryFacade_queryPreTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryProjectInformation", dataProvider = "provider", description = "标的信息查询")
    public void queryFacade_queryProjectInformation(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryRechargeTransaction", dataProvider = "provider", description = "充值交易查询")
    public void queryFacade_queryRechargeTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryTransactionConfirmation", dataProvider = "provider", description = "交易确认查询")
    public void queryFacade_queryTransactionConfirmation(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryTransactionFreeze", dataProvider = "provider", description = "冻结交易查询")
    public void queryFacade_queryTransactionFreeze(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryTransactionUnfreeze", dataProvider = "provider", description = "解冻交易查询")
    public void queryFacade_queryTransactionUnfreeze(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryUpdateBankcardAuditDetail", dataProvider = "provider", description = "查询换卡记录")
    public void queryFacade_queryUpdateBankcardAuditDetail(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryUserInformation", dataProvider = "provider", description = "用户信息查询")
    public void queryFacade_queryUserInformation(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/queryFacade/queryWithdrawTransaction", dataProvider = "provider", description = "提现交易查询")
    public void queryFacade_queryWithdrawTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/autoWithdraw", dataProvider = "provider", description = "自动提现")
    public void rechargeAndWithdrawFacade_autoWithdraw(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/cancelWithdraw", dataProvider = "provider", description = "取消提现")
    public void rechargeAndWithdrawFacade_cancelWithdraw(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/confirmWithdraw", dataProvider = "provider", description = "提现确认")
    public void rechargeAndWithdrawFacade_confirmWithdraw(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/directRecharge", dataProvider = "provider", description = "自动充值")
    public void rechargeAndWithdrawFacade_directRecharge(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/interceptWithdraw", dataProvider = "provider", description = "提现拦截")
    public void rechargeAndWithdrawFacade_interceptWithdraw(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/recharge", dataProvider = "provider", description = "充值")
    public void rechargeAndWithdrawFacade_recharge(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/rechargeFundsTransfer", dataProvider = "provider", description = "打款划拨充值")
    public void rechargeAndWithdrawFacade_rechargeFundsTransfer(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/rechargeAndWithdrawFacade/withdraw", dataProvider = "provider", description = "提现")
    public void rechargeAndWithdrawFacade_withdraw(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/asyncTransaction", dataProvider = "provider", description = "批量交易")
    public void tradeFacade_asyncTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/authorizationEntrustPay", dataProvider = "provider", description = "委托支付授权")
    public void tradeFacade_authorizationEntrustPay(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/cancelDebentureSale", dataProvider = "provider", description = "取消债权出让")
    public void tradeFacade_cancelDebentureSale(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/cancelPreTransaction", dataProvider = "provider", description = "预处理取消")
    public void tradeFacade_cancelPreTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/cancelUserAuthorization", dataProvider = "provider", description = "取消用户授权")
    public void tradeFacade_cancelUserAuthorization(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/confirmCheckfile", dataProvider = "provider", description = "强制对账文件确认，慎用")
    public void tradeFacade_confirmCheckfile(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/debentureSale", dataProvider = "provider", description = "单笔债权出让")
    public void tradeFacade_debentureSale(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/establishProject", dataProvider = "provider", description = "创建标的")
    public void tradeFacade_establishProject(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/freeze", dataProvider = "provider", description = "冻结接口")
    public void tradeFacade_freeze(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/freezePreTransaction", dataProvider = "provider", description = "冻结预处理")
    public void tradeFacade_freezePreTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/modifyProject", dataProvider = "provider", description = "变更标的")
    public void tradeFacade_modifyProject(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/unfreeze", dataProvider = "provider", description = "解冻接口")
    public void tradeFacade_unfreeze(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/unfreezeTradePassword", dataProvider = "provider", description = "交易密码解冻")
    public void tradeFacade_unfreezeTradePassword(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/userAuthorization", dataProvider = "provider", description = "用户授权")
    public void tradeFacade_userAuthorization(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/userAutoPreTransaction", dataProvider = "provider", description = "授权预处理")
    public void tradeFacade_userAutoPreTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/userPreTransaction", dataProvider = "provider", description = "用户预处理")
    public void tradeFacade_userPreTransaction(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
    @Test(testName = "/tradeFacade/verifyDeduct", dataProvider = "provider", description = "验密扣费")
    public void tradeFacade_verifyDeduct(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
}
