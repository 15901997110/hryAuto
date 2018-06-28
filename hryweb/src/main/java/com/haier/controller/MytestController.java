package com.haier.controller;

import com.haier.testng.factory.Factory_5_1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/27 19:14
 */
@RestController
@RequestMapping("/mytest")
public class MytestController {
    @PostMapping("/")
    public void runPgw(){
        TestNG testNG=new TestNG();
        testNG.setTestClasses(new Class[]{Factory_5_1.class});
        testNG.run();
    }
}
