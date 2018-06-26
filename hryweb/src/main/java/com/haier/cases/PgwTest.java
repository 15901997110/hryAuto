package com.haier.cases;

import com.haier.po.Tcase;
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

    }


}
