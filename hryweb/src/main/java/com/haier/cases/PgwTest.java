package com.haier.cases;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/22 17:50
 */
public class PgwTest {

    private Integer envId;

    @DataProvider(name="CaseDataProvider")
    public Object[][] getCase(Method method){
        return null;
    }

}
