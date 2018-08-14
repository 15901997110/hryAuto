package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.RmpBase;
import com.haier.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: RmpTestDefault
 * @Author: 自动生成
 * @Date: 2018/08/14 13:32:43
 */
@SuppressWarnings("Duplicates")
@Slf4j
public class RmpTestDefault extends RmpBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy"})
    @BeforeClass
    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/riskManagementFacade/apply", dataProvider = "provider", description = "提交风控申请")
    public void riskManagementFacade_apply(HryTest hryTest) {
        String actual = this._riskManagementFacade_apply(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

    @Test(testName = "/riskManagementFacade/query", dataProvider = "provider", description = "查询风控审核结果")
    public void riskManagementFacade_query(HryTest hryTest) {
        String actual = this._riskManagementFacade_query(hryTest);
        AssertUtil.supperAssert(actual, hryTest);
    }

}
