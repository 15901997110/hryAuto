package com.haier.testng.cases;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/3 13:57
 */
@Slf4j
public class TestTest {
    @BeforeClass
    public void before(){
        log.info("before执行了");
    }
    @Test
    public void addTest(){
        log.info("addtest执行了");
        Assert.assertTrue(true);
    }
    @Test
    public void subtractTest(){
        log.info("subtract执行了");
        Assert.assertTrue(false);
    }
}
