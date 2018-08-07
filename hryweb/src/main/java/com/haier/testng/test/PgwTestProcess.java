package com.haier.testng.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.anno.Var;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.testng.base.PgwBase;
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
public class PgwTestProcess extends PgwBase {
    private Integer serviceId;
    private Integer envId;
    private String caseDesigner;
    private String i_c;//接收外部传参,定制的用例
    private JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型
    private String baseUrl;//http://host:port
    private String dbInfo;
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
        dbInfo = tservicedetail.getDbinfo();
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
            throw new SkipException("测试服务下面没有接口:" + iUri);
        }
        //此接口对应的全部用例
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        if (tcases == null || tcases.size() == 0) {
            throw new SkipException("此接口无可用的测试用例");
        }

        //如果用户有定制测试用例,则使用用户定制的用例来进行测试
        if (this.i_c_JSONObject != null && this.i_c_JSONObject.size() > 0) {
            log.debug("i_c:" + i_c);
            log.debug("i_c_JSONObject:" + this.i_c_JSONObject.toJSONString());
            JSONArray customCaseArray = i_c_JSONObject.getJSONArray(method.getName());
            //log.debug("测试方法" + method.getName() + "定制的用例:" + customCaseArray.toJSONString());
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
            log.debug("用例id:" + tcases.get(i).getId());
            objects[i] = params;
        }
        log.debug("测试方法:" + method.getName());
        log.debug("用例个数:" + objects.length);
        return objects;
    }

    /*    @Test(testName = "/accountBalanceQueryFacade/accountBalanceQuery", dataProvider = "provider", description = "账户余额查询")
        public void accountBalanceQueryFacade_accountBalanceQuery(Params params) {
            String actual = this.accountBalanceQueryFacade_accountBalanceQuery(baseUrl, dbInfo, params);
            AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
        }*/
/*

    @Test(testName = "/fundPurchaseFacade/fundPurchase", dataProvider = "provider", description = "基金申购")
    public void fundPurchaseFacade_fundPurchase(Params params) {
        String actual = this.fundPurchaseFacade_fundPurchase(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/fundShareQueryFacade/fundShareQuery", dataProvider = "provider", description = "基金份额查询")
    public void fundShareQueryFacade_fundShareQuery(Params params) {
        String actual = this.fundShareQueryFacade_fundShareQuery(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/gatewayPostNotifyFacade/kjtPayNotify", dataProvider = "provider", description = "快捷通回调")
    public void gatewayPostNotifyFacade_kjtPayNotify(Params params) {
        String actual = this.gatewayPostNotifyFacade_kjtPayNotify(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }

    @Test(testName = "/instantTradeFacade/instantTrade", dataProvider = "provider", description = "即时收单")
    public void instantTradeFacade_instantTrade(Params params) {
        String actual = this.instantTradeFacade_instantTrade(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }
*/
    @Var
    private String requestNo = "037285531df148c882ae66223c4c0df9";

    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "provider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(Params params) {
        String actual = this.payToAccountFacade_payToAccount(baseUrl, dbInfo, params);
        //JSONObject actualJsonObject = JSONObject.parseObject(actual);
        //requestNo = actualJsonObject.getString("requestNo");
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }
/*
    @Test(testName = "/payToCardFacade/payToCard", dataProvider = "provider", description = "付款到卡")
    public void payToCardFacade_payToCard(Params params) {
        String actual = this.payToCardFacade_payToCard(baseUrl, dbInfo, params);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }*/

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询", dependsOnMethods = "payToAccountFacade_payToAccount")
    public void tradeQueryFacade_tradeQuery(Params params) {
        String p = params.getTcase().getRequestparam();
        String replace = BeforeUtil.replace(p, dbInfo, this);
        params.getTcase().setRequestparam(replace);
        String actual = this.tradeQueryFacade_tradeQuery(baseUrl, dbInfo, params);

        log.info(actual);
        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());
    }
}
