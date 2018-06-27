package com.haier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/27 19:14
 */
@RestController
@RequestMapping("/run")
public class RunController {
    @PostMapping("/pgw")
    public void runPgw(){

    }
}
