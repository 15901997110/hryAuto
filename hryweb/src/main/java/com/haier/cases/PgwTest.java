package com.haier.cases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/22 17:50
 */
public class PgwTest {

    private Integer serviceId;
    private Integer envId;


    @DataProvider(name="CaseDataProvider")
    public Object[][] getCase(Method method){
        return null;
    }

    @BeforeClass
    @Parameters({"envId","serviceId"})
    public void beforeClass(Integer envId,Integer serviceId){
        this.envId=envId;
        this.serviceId=serviceId;
    }



}
