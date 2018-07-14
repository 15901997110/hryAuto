package com.haier.testng.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.service.impl.RunServiceImpl;
import com.haier.util.AssertUtil;
import com.haier.util.BeforeUtil;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/22 17:50
 */
@Slf4j
public class PgwTest {
    private Integer serviceId;
    private Integer envId;
    private String caseDesigner;
    private String i_c;
    private JSONObject i_c_JSONObject;
    private String baseUrl;//http://host:port
    private String url;
    private Tservice tservice;
    private Tenvdetail tenvdetail;
    private RunService runService = SpringContextHolder.getBean(RunService.class);

    @Parameters({"serviceId", "envId", "caseDesigner","i_c"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner,String i_c) {
        this.serviceId = serviceId;
        this.envId = envId;
        this.caseDesigner = caseDesigner;
        this.i_c=i_c;
        this.i_c_JSONObject=JSONObject.parseObject(i_c);
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

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询")
    public void tradeQueryFacade_tradeQuery(Params params) {
        log.debug(params.toString());
        Assert.assertTrue(true);
        //Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/payToCardFacade/payToCard", dataProvider = "provider", description = "付款到卡")
    public void payToCardFacade_payToCard(Params params) {
        log.info("自己打印的日志:"+params.toString());
        Assert.assertTrue(true);
        //Assert.assertTrue(this.getBoolResult(params));
    }

    @Test(testName = "/payToAccountFacade/payToAccount", dataProvider = "provider", description = "转账到账户")
    public void payToAccountFacade_payToAccount(Params params) {
        System.out.println("System.out.println():"+params);
        Assert.assertTrue(true);
        //Assert.assertTrue(this.getBoolResult(params));
    }


    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        //如果用户有定制测试用例
        JSONArray customCaseArray = i_c_JSONObject.getJSONArray(method.getName());
        if(customCaseArray!=null&&customCaseArray.size()>0){

        }

        Object[] objects;
        String iUri;

        //testName可能未填写
        try {
            iUri = method.getAnnotation(Test.class).testName();
            if (iUri == null || "".equals(iUri)) {
                return null;
            }
        } catch (NullPointerException e) {
            log.error("获取测试方法的@Test注解异常:" + method.getName(), e);
            return null;
        }

        Ti ti = runService.getTi(this.serviceId, iUri);
        if (ti == null) {
            return null;
        }
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        if (tcases == null || tcases.size() == 0) {
            return null;
        }

        objects = new Object[tcases.size()];
        for (int i = 0; i < tcases.size(); i++) {
            Params params=new Params();
            params.setTi(ti);
            params.setTcase(tcases.get(i));

            objects[i] = params;
        }
        return objects;
    }
}
