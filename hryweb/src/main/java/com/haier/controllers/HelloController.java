package com.haier.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: springboot demo
 * @Author: luqiwei
 * @Date: 2018/5/4 16:32
 */
@Slf4j
@Controller
public class HelloController {
    @RequestMapping(value = "/hello")
    public String index(){
        return"helloworld";
    }
}
