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
 * @Description: MemberBase
 * @Author: 自动生成
 * @Date: 2018/08/08 17:35:33
 */
@SuppressWarnings("Duplicates")
@Slf4j
@SKey("Member")
public class MemberBase{
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

    @Uri(value = "/bankCardFacade/addBankCardForForeigner", desc = "外籍用户添加银行卡(只限港澳台和外籍用户)")
    public String bankCardFacade_addBankCardForForeigner(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/bindBankCard", desc = "绑定银行卡")
    public String bankCardFacade_bindBankCard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/bindQuickBankCardSign", desc = "绑定快捷卡签约推进")
    public String bankCardFacade_bindQuickBankCardSign(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/checkUserBindCard", desc = "查询用户是否绑过银行卡")
    public String bankCardFacade_checkUserBindCard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/queryBankCardInfoForForeigner", desc = "查询外籍用户最近添加的银行卡(只限港澳台和外籍用户)")
    public String bankCardFacade_queryBankCardInfoForForeigner(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/queryBankLimits", desc = "收银服务限额限次查询")
    public String bankCardFacade_queryBankLimits(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/queryBankLimitsWithCunguanBankCode", desc = "收银服务限额限次查询和存管银行代码")
    public String bankCardFacade_queryBankLimitsWithCunguanBankCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/queryBranch", desc = "查询分支行信息")
    public String bankCardFacade_queryBranch(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/queryProvinceAndCity", desc = "查询所有省市信息")
    public String bankCardFacade_queryProvinceAndCity(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/querySupportBank", desc = "查询支持的出款银行")
    public String bankCardFacade_querySupportBank(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/querySupportedKJCards", desc = "查询支持快捷卡的银行")
    public String bankCardFacade_querySupportedKJCards(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/bankCardFacade/queryUserBindCards", desc = "查询用户绑定的银行卡")
    public String bankCardFacade_queryUserBindCards(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/consumerFinanceFacade/checkConsumerFinanceStatus", desc = "查询消费金融状态")
    public String consumerFinanceFacade_checkConsumerFinanceStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/consumerFinanceFacade/getIdCardImages", desc = "下载会员影印件")
    public String consumerFinanceFacade_getIdCardImages(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/consumerFinanceFacade/openConsumerFinance", desc = "开通消费金融")
    public String consumerFinanceFacade_openConsumerFinance(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/consumerFinanceFacade/queryUserBasicInfo", desc = "查询用户基本信息")
    public String consumerFinanceFacade_queryUserBasicInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/consumerFinanceFacade/queryUserCreditLimit", desc = "查询用户贷款额度信息")
    public String consumerFinanceFacade_queryUserCreditLimit(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/consumerFinanceFacade/updateUserCreditLimit", desc = "更新用户贷款额度信息")
    public String consumerFinanceFacade_updateUserCreditLimit(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/addBankContact", desc = "添加银行联系人信息")
    public String customerFacade_addBankContact(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/addKjtContacts", desc = "添加快捷通联系人")
    public String customerFacade_addKjtContacts(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/applyResetMerchantLoginPassword", desc = "商户登录密码重设申请")
    public String customerFacade_applyResetMerchantLoginPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/bindEmail", desc = "绑定邮箱")
    public String customerFacade_bindEmail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/createRegisterContract", desc = "创建注册合同")
    public String customerFacade_createRegisterContract(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/createRegisterContractBatch", desc = "批量创建已同意的注册合同")
    public String customerFacade_createRegisterContractBatch(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/deleteContact", desc = "删除联系人信息")
    public String customerFacade_deleteContact(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/generateCode", desc = "验证码生成接口")
    public String customerFacade_generateCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getCapitalAccountInfo", desc = "查询企业资金账户信息")
    public String customerFacade_getCapitalAccountInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getCorporationInfo", desc = "获取法人信息")
    public String customerFacade_getCorporationInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getEnterpriseCertificationInfo", desc = "查询企业实名认证信息")
    public String customerFacade_getEnterpriseCertificationInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getKjtUserInfoByHryId", desc = "根据hryId查询kjt用户信息")
    public String customerFacade_getKjtUserInfoByHryId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getRiskAssessmentQuestions", desc = "获取风险测评问题")
    public String customerFacade_getRiskAssessmentQuestions(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getUserAccountListById", desc = "根据某一账户id获取该实名用户所有账户列表")
    public String customerFacade_getUserAccountListById(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getUserIdByToken", desc = "根据token获取用户hryId和kjtId")
    public String customerFacade_getUserIdByToken(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/getUserRiskAssessmentLevel", desc = "获取用户风险测评结果")
    public String customerFacade_getUserRiskAssessmentLevel(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/login", desc = "登录接口")
    public String customerFacade_login(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/loginFinancingMerchant", desc = "商户登录接口")
    public String customerFacade_loginFinancingMerchant(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/logout", desc = "账号退出")
    public String customerFacade_logout(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/moveCaptialCalendar", desc = "移动资金日历数据到历史库")
    public String customerFacade_moveCaptialCalendar(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/queryCaptialCalendar", desc = "获取资金日历")
    public String customerFacade_queryCaptialCalendar(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/queryContactList", desc = "查询联系人列表")
    public String customerFacade_queryContactList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/queryRegisterContract", desc = "查询用户注册合同")
    public String customerFacade_queryRegisterContract(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/resetMerchantLoginPassword", desc = "重设商户登录密码")
    public String customerFacade_resetMerchantLoginPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/saveCapitalAccountInfo", desc = "保存企业资金账户信息")
    public String customerFacade_saveCapitalAccountInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/saveCorporationInfo", desc = "保存法人信息")
    public String customerFacade_saveCorporationInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/saveEnterpriseCertificationInfo", desc = "保存企业实名认证信息")
    public String customerFacade_saveEnterpriseCertificationInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/sendEmail", desc = "发送邮件")
    public String customerFacade_sendEmail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/sendEmailAuthCode", desc = "发送邮箱验证码")
    public String customerFacade_sendEmailAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/sendMobileAuthCode", desc = "发送手机验证码")
    public String customerFacade_sendMobileAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/setUserRiskAssessmentLevel", desc = "设置用户风险测评结果")
    public String customerFacade_setUserRiskAssessmentLevel(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/unBindEmail", desc = "解绑邮箱")
    public String customerFacade_unBindEmail(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/updateBindMobile", desc = "修改绑定手机号")
    public String customerFacade_updateBindMobile(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/updateLoginPassword", desc = "修改登录密码")
    public String customerFacade_updateLoginPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/updateLoginPasswordByAuthToken", desc = "根据验证有效token修改登录密码")
    public String customerFacade_updateLoginPasswordByAuthToken(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/updatePayPassword", desc = "修改支付密码")
    public String customerFacade_updatePayPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/updateRegisterContract", desc = "创建已同意的注册合同")
    public String customerFacade_updateRegisterContract(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/uploadBase64Image", desc = "上传图片")
    public String customerFacade_uploadBase64Image(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/vailedateEmailToken", desc = "验证邮件中的token是否有效")
    public String customerFacade_vailedateEmailToken(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/validateEmailAuthCode", desc = "验证邮箱验证码")
    public String customerFacade_validateEmailAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/validateKjtAccounts", desc = "校验快捷通账号是否存在")
    public String customerFacade_validateKjtAccounts(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/validateMobileAuthCode", desc = "验证手机验证码")
    public String customerFacade_validateMobileAuthCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/validatePayPassword", desc = "验证支付密码")
    public String customerFacade_validatePayPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/customerFacade/validateRealNameNum", desc = "验证实名认证证件号")
    public String customerFacade_validateRealNameNum(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/dealerFacade/getDealerByDealerId", desc = "根据经销商Id获取经销商信息")
    public String dealerFacade_getDealerByDealerId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/dealerFacade/getDealerByTaxNo", desc = "根据税务登记证号获取经销商信息")
    public String dealerFacade_getDealerByTaxNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/enterpriseFacade/getEnterpriseInfoByHryIdFromHry", desc = "根据hryId获取企业用户信息")
    public String enterpriseFacade_getEnterpriseInfoByHryIdFromHry(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/enterpriseFacade/getEnterpriseKjtAccountInfoByLoginName", desc = "根据登录名查询Kjt账户信息")
    public String enterpriseFacade_getEnterpriseKjtAccountInfoByLoginName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/fundIn", desc = "基金开户并转入")
    public String fundFacade_fundIn(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/getUserStatisticsProfit", desc = "历史收益查询")
    public String fundFacade_getUserStatisticsProfit(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/getWithdrawCode", desc = "获取提现手机验证码")
    public String fundFacade_getWithdrawCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/isOpenFund", desc = "判断当前登录用户是否开通基金账户")
    public String fundFacade_isOpenFund(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/openFundAccount", desc = "基金开户")
    public String fundFacade_openFundAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/queryAllQuickBankAccount", desc = "查询会员绑定的所有快捷卡信息")
    public String fundFacade_queryAllQuickBankAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/queryBankAccount", desc = "查询会员绑定的银行卡信息")
    public String fundFacade_queryBankAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/queryFundOrder", desc = "查询基金交易订单")
    public String fundFacade_queryFundOrder(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/queryFundRates", desc = "查询年化利率和万份收益信息")
    public String fundFacade_queryFundRates(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/queryProfitDate", desc = "本次转入后收益发放时间")
    public String fundFacade_queryProfitDate(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/queryWithdrawBankAccount", desc = "查询会员可提现的银行卡信息")
    public String fundFacade_queryWithdrawBankAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/fundFacade/withdraw", desc = "提现")
    public String fundFacade_withdraw(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/kjtGatewayFacade/execute", desc = "kjt会员接口统一封装")
    public String kjtGatewayFacade_execute(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/kjtGatewayFacade/getKjtIdByLoginName", desc = "根据登录名查询KJT ID")
    public String kjtGatewayFacade_getKjtIdByLoginName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/batchOpenCustodyAccount", desc = "批量开通存管户")
    public String memberFacade_batchOpenCustodyAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/bindingMobilephone", desc = "绑定手机号(包括外籍用户)")
    public String memberFacade_bindingMobilephone(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/checkBindingMobilephone", desc = "检查手机号是否能被绑定(包括外籍用户)")
    public String memberFacade_checkBindingMobilephone(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/checkCustodyAccountStatus", desc = "查询存管户状态")
    public String memberFacade_checkCustodyAccountStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/checkPayPassword", desc = "验证支付密码")
    public String memberFacade_checkPayPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/checkWhetherLoginNameExists", desc = "校验登陆名是否已经存在")
    public String memberFacade_checkWhetherLoginNameExists(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getCompanyAuth", desc = "获取企业会员权限")
    public String memberFacade_getCompanyAuth(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getHryIdFromMemberId", desc = "根据kjtId查询hryId")
    public String memberFacade_getHryIdFromMemberId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getIdVerificationStatus", desc = "查询会员的身份认证状态")
    public String memberFacade_getIdVerificationStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getInvestmentProperty", desc = "获取用户投资资产信息")
    public String memberFacade_getInvestmentProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getKjtProperty", desc = "获取用户kjt方面资产信息")
    public String memberFacade_getKjtProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getLcjProperty", desc = "获取用户理财金资产信息")
    public String memberFacade_getLcjProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getLcjRecord", desc = "获取用户理财金信息")
    public String memberFacade_getLcjRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getLcjStatisticsByStatus", desc = "根据状态统计理财金信息")
    public String memberFacade_getLcjStatisticsByStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getMemberByHryId", desc = "根据hryId获取用户信息(从hry数据库获取信息，包括外籍用户)")
    public String memberFacade_getMemberByHryId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getMemberCount", desc = "获取平台所有用户数")
    public String memberFacade_getMemberCount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getMemberIdByCardIdAndHryId", desc = "根据用户id获取身份证，然后通过身份证获取对应的绑定用户id(从hry数据库获取信息，包括外籍用户)")
    public String memberFacade_getMemberIdByCardIdAndHryId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getMemberVerifyInfo", desc = "查询会员的认证信息")
    public String memberFacade_getMemberVerifyInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getMemberVerifyLevel", desc = "查询会员的认证等级")
    public String memberFacade_getMemberVerifyLevel(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getProperty", desc = "获取用户资产信息,目前只提供理财金、基金份额查询")
    public String memberFacade_getProperty(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/getUserBasicInfoByHryId", desc = "根据用户id获得用户身份信息")
    public String memberFacade_getUserBasicInfoByHryId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/grantCompanyAuth", desc = "为企业会员授权")
    public String memberFacade_grantCompanyAuth(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/identifyForeignerInfo", desc = "认证外籍用户身份信息(只限港澳台和外籍用户)")
    public String memberFacade_identifyForeignerInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/openCustodyAccount", desc = "存管开户")
    public String memberFacade_openCustodyAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/openCustodyAccountQuick", desc = "快速存管开户")
    public String memberFacade_openCustodyAccountQuick(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryBankNameByCardNo", desc = "根据卡号查询银行名称")
    public String memberFacade_queryBankNameByCardNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryCunguanBankInfoByCardNo", desc = "根据卡号查询存管支持银行信息")
    public String memberFacade_queryCunguanBankInfoByCardNo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryForeignerVerifyInfo", desc = "查询外籍用户身份认证情况(只限港澳台和外籍用户)")
    public String memberFacade_queryForeignerVerifyInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryIdCardHang", desc = "查询身份证是否挂起")
    public String memberFacade_queryIdCardHang(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryLcjListByStatus", desc = "根据状态获取理财金详情")
    public String memberFacade_queryLcjListByStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryLcjSyncRecord", desc = "查询理财金同步信息")
    public String memberFacade_queryLcjSyncRecord(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryMemberBasicInfoFromKjt", desc = "从快捷通查询用户信息(包括外籍用户)")
    public String memberFacade_queryMemberBasicInfoFromKjt(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryMemberByHryIdList", desc = "根据hryIdList获取批量用户信息")
    public String memberFacade_queryMemberByHryIdList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryMemberByLoginNameList", desc = "根据LoginNameList获取批量用户信息")
    public String memberFacade_queryMemberByLoginNameList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryMemberStatusInfo", desc = "查询用户状态信息(包括外籍用户)")
    public String memberFacade_queryMemberStatusInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryRealNameInfo", desc = "查询实名认证信息")
    public String memberFacade_queryRealNameInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/queryUserGroupInfo", desc = "查询用户组的信息")
    public String memberFacade_queryUserGroupInfo(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/registerUserOnStepOne", desc = "注册页面1点下一步(包括外籍用户)")
    public String memberFacade_registerUserOnStepOne(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/resetLoginPassword", desc = "重置登陆密码，仅仅限于以QYZH开头的账号")
    public String memberFacade_resetLoginPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/sendMessage", desc = "发送站内信")
    public String memberFacade_sendMessage(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/sendMobileVerificationCode", desc = "发送手机校验码")
    public String memberFacade_sendMobileVerificationCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/setMemberGroupId", desc = "设置用户的用户组Id")
    public String memberFacade_setMemberGroupId(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/setPaymentPassword", desc = "设置支付密码")
    public String memberFacade_setPaymentPassword(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/updateCustodyAccountStatus", desc = "更新存管户状态")
    public String memberFacade_updateCustodyAccountStatus(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/uploadPhotocopy", desc = "上传身份证影印件")
    public String memberFacade_uploadPhotocopy(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/verifyIdCardNumberAgainstRealName", desc = "验证真实姓名与身份证号是否一致,如果一致将其保存")
    public String memberFacade_verifyIdCardNumberAgainstRealName(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/verifyMobileVerificationCode", desc = "验证手机校验码")
    public String memberFacade_verifyMobileVerificationCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/memberFacade/verifyRealNameAndBindingMobilephote", desc = "实姓认证和手机号绑定")
    public String memberFacade_verifyRealNameAndBindingMobilephote(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/messageFacade/deleteMessage", desc = "删除信息")
    public String messageFacade_deleteMessage(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/messageFacade/getMessageInfoList", desc = "获取信息列表")
    public String messageFacade_getMessageInfoList(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/messageFacade/setMessageToRead", desc = "设置信息为已读")
    public String messageFacade_setMessageToRead(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/sessionFacade/authCode", desc = "验证码验证")
    public String sessionFacade_authCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/sessionFacade/authSmsCode", desc = "短信验证码验证")
    public String sessionFacade_authSmsCode(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/sessionFacade/getCurrentMember", desc = "根据token从Session中获取用户信息")
    public String sessionFacade_getCurrentMember(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

    @Uri(value = "/sessionFacade/initUser", desc = "初始化用户信息")
    public String sessionFacade_initUser(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

}
