package com.haier.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: springboot demo
 * @Author: luqiwei
 * @Date: 2018/5/4 16:32
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
