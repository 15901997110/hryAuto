package com.haier.controllers;

import com.haier.po.Tservice;
import com.haier.response.Result;
import com.haier.service.TserviceService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lish
 * @Description: 服务信息维护
 * @Data: 2018-05-19 16:16
 * */
@Slf4j
@RestController
@RequestMapping("/tservice")
public class TserviceController {
    @Autowired
    TserviceService tserviceService;

    /**
     * 查询服务列表
     * */
    @PostMapping(value="/tserviceList")
    public Result tserviceList(Tservice tservice, Integer pageNum, Integer pageSize){
        return ResultUtil.success(tserviceService.selectByCondition(null,pageNum,pageSize));
    }



}
