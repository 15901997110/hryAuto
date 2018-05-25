package com.haier.controllers;

import com.haier.po.Tenv;
import com.haier.po.Tservice;
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
    @Autowired
    TenvService tenvService;
    @Autowired
    TserviceService tserviceService;
    @GetMapping("/batchAddEnv.do")
    public String batchAddEnv(){
        for(int i=0;i<100;i++){
/*            Tenv tenv=new Tenv();
            tenv.setEnvkey("servicekey"+i);
            tenv.setRemark("remark"+i);
            tenvService.insertOne(tenv);*/

            Tservice tservice =new Tservice();
            tservice.setServicekey("servkcekey"+i);
            tservice.setServicename("servicename"+i);
            tserviceService.insertOne(tservice);

        }
        return "操作成功";
    }
}
