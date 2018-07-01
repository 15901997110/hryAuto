package com.haier.controller;

import com.haier.service.RunService;
import com.haier.service.TiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/29 18:35
 */
@RestController
@RequestMapping("/run")
public class RunController {
    @Autowired
    RunService runService;
    @PostMapping("/test")
    public void test(){
        runService.getTi(5,"/tradeQueryFacade/tradeQuery");
    }
}
