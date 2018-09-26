package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.LuBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: LuDefaultTest
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@Slf4j
public class LuDefaultTest extends LuBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    public LuDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }
    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/i1", dataProvider = "provider", description = "添加接口测试")
    public void i1(HryTest hryTest) {
        String actual = super._i1(hryTest);
        supperAssert(actual, hryTest);
    }

}
