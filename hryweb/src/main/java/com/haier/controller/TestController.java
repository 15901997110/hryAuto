package com.haier.controller;

import com.haier.util.ClassUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/7 19:22
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping("/getClassName")
    public List<String> getClassName(String packageName){
        return ClassUtil.getClassName("com.haier.testng.test",false);
    }
}
