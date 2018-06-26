package com.haier.cases;

import com.haier.po.Tcase;
import com.haier.po.TenvdetailCustom;
import com.haier.po.Ti;
import com.haier.po.Tservice;
import com.haier.util.AssertUtil;
import com.haier.util.HryHttpClientUtil;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/22 17:50
 */
public class PgwTest {

    private Integer serviceId;
    private Integer envId;
    private String url;
    private Tservice tservice;
    private Ti ti;
    private TenvdetailCustom tenvdetailCustom;


    @DataProvider(name="CaseDataProvider")
    public Object[][] getCase(Method method){
        method.getAnnotation(Test.class);
        return null;
    }

    @BeforeClass
    @Parameters({"envId","serviceId"})
    public void beforeClass(Integer envId,Integer serviceId){
        this.envId=envId;
        this.serviceId=serviceId;
    }
    public void init(){

    }

    @Test(testName = "/tradeQueryFacade/tradeQuery",description = "交易查询")
    public void tradeQueryFacade_tradeQuery(List<Tcase> tcaseList){
        //测试用例
        String actual = HryHttpClientUtil.send("", 1, 1, 1, "");

        AssertUtil.supperAssert(1,"","",1);
    }


}
