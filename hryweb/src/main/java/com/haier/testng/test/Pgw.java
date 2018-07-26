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
public class Pgw {
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
            return null;
        }
        //此接口对应的全部用例
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        if (tcases == null || tcases.size() == 0) {
            return null;
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

    @Test(testName = "/accountBalanceQueryFacade/accountBalanceQuery", dataProvider = "provider", description = "账户余额查询")
    public void accountBalanceQueryFacade_accountBalanceQuery(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/entryAccountFacade/entryAccount", dataProvider = "provider", description = "登账")
    public void entryAccountFacade_entryAccount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/fundPurchaseFacade/fundPurchase", dataProvider = "provider", description = "基金申购")
    public void fundPurchaseFacade_fundPurchase(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/fundShareQueryFacade/fundShareQuery", dataProvider = "provider", description = "基金份额查询")
    public void fundShareQueryFacade_fundShareQuery(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/gatewayPostNotifyFacade/kjtPayNotify", dataProvider = "provider", description = "快捷通回调")
    public void gatewayPostNotifyFacade_kjtPayNotify(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/instantTradeFacade/instantTrade", dataProvider = "provider", description = "即时收单")
    public void instantTradeFacade_instantTrade(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "provider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/payToCardFacade/payToCard", dataProvider = "provider", description = "付款到卡")
    public void payToCardFacade_payToCard(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询")
    public void tradeQueryFacade_tradeQuery(Params params) {
        Reporter.log("用例设计参数 : ");
        Reporter.log(params.getTcase().getRequestparam());
        Assert.assertTrue(this.getBoolResult(params));
    }
}
