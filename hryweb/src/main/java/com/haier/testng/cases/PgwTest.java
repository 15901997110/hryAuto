package com.haier.testng.cases;

import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.util.AssertUtil;
import com.haier.util.BeforeUtil;
import com.haier.util.HryHttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/22 17:50
 */
@Slf4j
public class PgwTest {
    public PgwTest( Integer serviceId,Integer envId, String caseDesigner){
        this.envId=envId;
        this.serviceId=serviceId;
        this.caseDesigner=caseDesigner;
    }

    private Integer serviceId;
    private Integer envId;
    private String caseDesigner;
    private String baseUrl;//http://host:port
    private String url;
    private Tservice tservice;
    private Tenvdetail tenvdetail;

    @Autowired
    RunService runService;

    @DataProvider(name = "CaseDataProvider")
    public Object[] getCase(Method method) {
        Object[] objects;
        String iUri;

        //testName未填写
        try {
            iUri = method.getAnnotation(Test.class).testName();
            if (iUri == null || "".equals(iUri)) {
                return null;
            }
        } catch (NullPointerException e) {
            log.error("获取测试方法的@Test注解异常:", e);
            return null;
        }
        Integer paramCount = method.getParameterCount();

        //测试方法参数个数为0,返回null
        if (paramCount == 0) {
            return null;
        }
        Ti ti = runService.getTi(this.serviceId, iUri);
        if (ti == null) {
            return null;
        }
        objects = new Object[1][paramCount];
        for (int i = 0; i < paramCount; i++) {

        }
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        objects = new Object[tcases.size()][method.getParameterCount()];
        for (int i = 0; i < tcases.size(); i++) {
            objects[i] = new Object[]{ti, tcases.get(i)};
        }
        return objects;
    }

    @BeforeClass
    //@Parameters({"envId", "serviceId", "caseDesigner"})
    public void beforeClass() {
        tservice = runService.getTservice(this.serviceId);
        tenvdetail = runService.getTenvdetail(this.serviceId, this.envId);
        init();
    }

    public void init() {
        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + "://" + tenvdetail.getHostinfo();
    }

    public Boolean getBoolResult(Params params) {
        if (params == null || params.getTcase() == null || params.getTcase() == null) {
            return false;
        }
        Ti ti = params.getTi();
        Tcase tcase = params.getTcase();
        url = baseUrl + ti.getIuri();
        String actual = HryHttpClientUtil.send(url, ti.getIrequestmethod() + 0, ti.getIcontenttype() + 0, ti.getIparamtype() + 0, BeforeUtil.replace(tcase.getRequestparam(), tenvdetail.getDbinfo()));
        return AssertUtil.supperAssert(tcase.getAsserttype() + 0, tcase.getExpected(), actual, ti.getIresponsetype() + 0);
    }

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "CaseDataProvider", description = "交易查询")
    public void tradeQueryFacade_tradeQuery(Params params) {
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/payToCardFacade/payToCard", dataProvider = "CaseDataProvider", description = "付款到卡")
    public void payToCardFacade_payToCard(Params params) {
        Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "CaseDataProvider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(Params params) {
        Assert.assertTrue(this.getBoolResult(params));
    }

}
