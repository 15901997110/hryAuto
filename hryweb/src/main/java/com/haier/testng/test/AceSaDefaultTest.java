package com.haier.testng.test;

import com.haier.anno.SKey;
import com.haier.po.HryTest;
import com.haier.testng.base.Base;
import com.haier.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.haier.util.AssertUtil.supperAssert;
@SKey("AceSa")
public class AceSaDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public AceSaDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/sa/login", dataProvider = "provider", description = "SA登录")
    public void sa_login(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
