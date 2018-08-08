package com.haier.testng.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
/**
 * @Description: LanmaoBase
 * @Author: 自动生成
 * @Date: 2018/08/08 17:35:33
 */
@SuppressWarnings("Duplicates")
@Slf4j
@SKey("Lanmao")
public class LanmaoBase{
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

    @Uri(value = "/accountFacade/accountRecharge", desc = "调账充值接口:一键从天天聚迁移至存管余额使用")
    public String accountFacade_accountRecharge(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/activateStockedUser", desc = "会员激活")
    public String accountFacade_activateStockedUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/auditBindCard", desc = "换卡审核")
    public String accountFacade_auditBindCard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/bindCardGeneral", desc = "个人和企业直连换卡")
    public String accountFacade_bindCardGeneral(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/checkPassword", desc = "校验密码")
    public String accountFacade_checkPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/enterpriseBindBankcard", desc = "企业换绑卡")
    public String accountFacade_enterpriseBindBankcard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/enterpriseEntrustImportUser", desc = "企业委托开户")
    public String accountFacade_enterpriseEntrustImportUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/enterpriseInformationUpdate", desc = "企业信息变更")
    public String accountFacade_enterpriseInformationUpdate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/enterpriseRegister", desc = "企业绑卡注册")
    public String accountFacade_enterpriseRegister(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/entrustImportUser", desc = "个人委托开户")
    public String accountFacade_entrustImportUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/modifyMobileExpand", desc = "预留手机号更新")
    public String accountFacade_modifyMobileExpand(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/personalBindBankcardExpand", desc = "个人换绑卡")
    public String accountFacade_personalBindBankcardExpand(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/personalRegister", desc = "个人绑卡注册")
    public String accountFacade_personalRegister(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/resetPassword", desc = "修改密码")
    public String accountFacade_resetPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/accountFacade/unBindBankcard", desc = "解绑银行卡")
    public String accountFacade_unBindBankcard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/gatewayFacade/notify", desc = "异步回调")
    public String gatewayFacade_notify(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoReconFacade/download", desc = "获取恒丰原始对账文件")
    public String lanmaoReconFacade_download(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoReconFacade/manualRecon", desc = "手工对账接口")
    public String lanmaoReconFacade_manualRecon(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoReconFacade/queryReconInfo", desc = "查询交易对账汇总结果信息")
    public String lanmaoReconFacade_queryReconInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/lanmaoReconFacade/queryReconStatusDetail", desc = "查询具体类型的对账状态详情")
    public String lanmaoReconFacade_queryReconStatusDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryAuthorizationEntrustPayRecord", desc = "委托支付授权记录查询")
    public String queryFacade_queryAuthorizationEntrustPayRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryCancelTransactionSale", desc = "查询取消预处理")
    public String queryFacade_queryCancelTransactionSale(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryDebentureSale", desc = "债权出让查询")
    public String queryFacade_queryDebentureSale(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryGeneralFreeze", desc = "通用冻结查询")
    public String queryFacade_queryGeneralFreeze(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryInterceptWithdraw", desc = "查询提现拦截")
    public String queryFacade_queryInterceptWithdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryPreTransaction", desc = "交易预处理查询")
    public String queryFacade_queryPreTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryProjectInformation", desc = "标的信息查询")
    public String queryFacade_queryProjectInformation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryRechargeTransaction", desc = "充值交易查询")
    public String queryFacade_queryRechargeTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryTransactionConfirmation", desc = "交易确认查询")
    public String queryFacade_queryTransactionConfirmation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryTransactionFreeze", desc = "冻结交易查询")
    public String queryFacade_queryTransactionFreeze(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryTransactionUnfreeze", desc = "解冻交易查询")
    public String queryFacade_queryTransactionUnfreeze(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryUpdateBankcardAuditDetail", desc = "查询换卡记录")
    public String queryFacade_queryUpdateBankcardAuditDetail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryUserInformation", desc = "用户信息查询")
    public String queryFacade_queryUserInformation(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/queryFacade/queryWithdrawTransaction", desc = "提现交易查询")
    public String queryFacade_queryWithdrawTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/autoWithdraw", desc = "自动提现")
    public String rechargeAndWithdrawFacade_autoWithdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/cancelWithdraw", desc = "取消提现")
    public String rechargeAndWithdrawFacade_cancelWithdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/confirmWithdraw", desc = "提现确认")
    public String rechargeAndWithdrawFacade_confirmWithdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/directRecharge", desc = "自动充值")
    public String rechargeAndWithdrawFacade_directRecharge(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/interceptWithdraw", desc = "提现拦截")
    public String rechargeAndWithdrawFacade_interceptWithdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/recharge", desc = "充值")
    public String rechargeAndWithdrawFacade_recharge(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/rechargeFundsTransfer", desc = "打款划拨充值")
    public String rechargeAndWithdrawFacade_rechargeFundsTransfer(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/rechargeAndWithdrawFacade/withdraw", desc = "提现")
    public String rechargeAndWithdrawFacade_withdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/asyncTransaction", desc = "批量交易")
    public String tradeFacade_asyncTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/authorizationEntrustPay", desc = "委托支付授权")
    public String tradeFacade_authorizationEntrustPay(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/cancelDebentureSale", desc = "取消债权出让")
    public String tradeFacade_cancelDebentureSale(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/cancelPreTransaction", desc = "预处理取消")
    public String tradeFacade_cancelPreTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/cancelUserAuthorization", desc = "取消用户授权")
    public String tradeFacade_cancelUserAuthorization(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/confirmCheckfile", desc = "强制对账文件确认，慎用")
    public String tradeFacade_confirmCheckfile(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/debentureSale", desc = "单笔债权出让")
    public String tradeFacade_debentureSale(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/establishProject", desc = "创建标的")
    public String tradeFacade_establishProject(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/freeze", desc = "冻结接口")
    public String tradeFacade_freeze(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/freezePreTransaction", desc = "冻结预处理")
    public String tradeFacade_freezePreTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/modifyProject", desc = "变更标的")
    public String tradeFacade_modifyProject(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/unfreeze", desc = "解冻接口")
    public String tradeFacade_unfreeze(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/unfreezeTradePassword", desc = "交易密码解冻")
    public String tradeFacade_unfreezeTradePassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/userAuthorization", desc = "用户授权")
    public String tradeFacade_userAuthorization(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/userAutoPreTransaction", desc = "授权预处理")
    public String tradeFacade_userAutoPreTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/userPreTransaction", desc = "用户预处理")
    public String tradeFacade_userPreTransaction(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/tradeFacade/verifyDeduct", desc = "验密扣费")
    public String tradeFacade_verifyDeduct(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

}
