package com.haier.controller;

import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.enums.RequestMethodTypeEnum;
import com.haier.po.Tservice;
import com.haier.response.Result;
import com.haier.service.TenvService;
import com.haier.service.TserviceService;
import com.haier.util.HryHttpClientUtil;
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
   @GetMapping("/test2")
   public String test2(){
      String result=null;
      try {
         result=HryHttpClientUtil.send("http://www.baidu.com", RequestMethodTypeEnum.REQUEST_METHOD_GET,null);
      } catch (HttpProcessException e) {
         e.printStackTrace();
      }
      return result;
   }
}
