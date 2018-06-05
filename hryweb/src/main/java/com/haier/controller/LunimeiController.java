package com.haier.controller;

import com.haier.po.Tservice;
import com.haier.response.Result;
import com.haier.service.TenvService;
import com.haier.service.TserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/24 20:04
 */
@RestController
@RequestMapping("/lunimei")
public class LunimeiController {
   @GetMapping("/test")
    public Integer test(){
       int i=0;
       int j=100/i;
       return j;
   }
}
