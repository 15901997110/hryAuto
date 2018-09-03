package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.AceSaBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: AceSaDefaultTest
 * @Author: 自动生成
 * @Date: 2018/09/03 20:16:25
 */
@Slf4j
public class AceSaDefaultTest extends AceSaBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/sa/login", dataProvider = "provider", description = "SA登录")
    public void sa_login(HryTest hryTest) {
        String actual = this._sa_login(hryTest);
        supperAssert(actual, hryTest);
    }

}
