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
import com.haier.enums.StatusCodeEnum;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
    @PostMapping(value="/tserviceList.do")
    public Result tserviceList(Tservice tservice, Integer pageNum, Integer pageSize){
        log.info("筛选的数据="+tservice.getServicename());
        return ResultUtil.success(tserviceService.selectByCondition(tservice,pageNum,pageSize));
    }

    /**
     *查询单个服务信息
     * */
    @PostMapping(value="/tserviceOne.do")
    public Result tserviceOne(Integer tserviceId){
        Tservice tservice=tserviceService.selectOne(tserviceId);
        log.info("查询单条服务id="+tserviceId);
        return ResultUtil.success(tservice);
    }

    /**
     *添加服务
     * */
    @PostMapping(value="/tserviceAdd.do")
    public Result tserviceAdd(Tservice tservice){
        log.info("新增的服务简称="+tservice.getServicekey()+",服务名称="+tservice.getServicename()+"协议类型="+tservice.getHttptype());
        return ResultUtil.success(tserviceService.insertOne(tservice));
    }

    /**
     * 编辑服务
     * */
    @PostMapping(value = "/tserviceEdit.do")
    public Result tserviceEdit(Tservice tservice){
        if(Objects.isNull(tservice.getServicekey())|| Objects.isNull(tservice.getServicename()) || Objects.isNull(tservice.getHttptype())){
            return ResultUtil.error(StatusCodeEnum.PARAMETER_ERROR);
        }else{
            log.info("更新后服务简称="+tservice.getServicekey()+"更新后的服务名称=" + tservice.getServicename() + "，协议类型=" + tservice.getHttptype());
            tserviceService.updateOne(tservice.getId(),tservice);
            return ResultUtil.success();
        }

    }

    /**
     * 删除服务
     * */
    @PostMapping(value = "/tserviceDel.do")
    public Result tserviceDel(Tservice tservice){
        log.info("要删除的服务id="+tservice.getId());
        Short i=1;
        tservice.setIsdel(i);
        tserviceService.updateOne(tservice.getId(),tservice);
        return ResultUtil.success();
    }



}
