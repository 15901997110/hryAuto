package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.Base;
import com.haier.util.HryHttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.haier.util.AssertUtil.supperAssert;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/11/13 16:15
 */
public class PgwTest extends Base {
    @Parameters({"serviceId", "envId", "tCase", "testId"})
    public PgwTest(Integer serviceId, Integer envId, String tCase, String testId) {
        if (StringUtils.isNotBlank(tCase)) {

        }
    }

    @Test(testName = "/tradeQueryFacade/tradeQuery", dataProvider = "provider", description = "交易查询")
    public void tradeQueryFacade_tradeQuery(HryTest hryTest) {
        String actual = HryHttpClientUtil.send(hryTest, this);
        supperAssert(actual, hryTest);
    }
}

