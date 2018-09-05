package com.haier.controller;

import com.haier.po.UnionLoginConfig;
import com.haier.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/7 19:22
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    UnionLoginConfig unionLoginConfig;

    @GetMapping("/get")
    public void get() {

    }

    @PostMapping("/getClassName")
    public List<String> getClassName(String packageName) {
        return ClassUtil.getClassName("com.haier.testng.test", false);
    }
}
