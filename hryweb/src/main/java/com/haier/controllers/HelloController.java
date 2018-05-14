package com.haier.controllers;

import com.haier.po.Tenv;
import com.haier.service.TenvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @Description: springboot demo
 * @Author: luqiwei
 * @Date: 2018/5/4 16:32
 */
@Slf4j
@Controller
public class HelloController {
    @Autowired
    TenvService tenvService;
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    @ResponseBody
    public Integer index(HttpServletRequest request){
        String name=request.getParameter("userName");
        String password=request.getParameter("password");
        log.info("环境名称="+name+"，描述="+password);

        Tenv tenv=new Tenv();
        tenv.setEnvkey(name);
        tenv.setRemark(password);
        return tenvService.insertOne(tenv);
    }
}
