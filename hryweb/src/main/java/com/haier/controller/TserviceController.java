package com.haier.controller;

import com.haier.exception.HryException;
import com.haier.po.Tservice;
import com.haier.response.Result;
import com.haier.service.TserviceService;
import com.haier.util.ReflectUtil;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haier.enums.StatusCodeEnum;

import java.util.List;
import java.util.Objects;

/**
 * @Author: lish
 * @Description: 服务信息维护
 * @Data: 2018-05-19 16:16
 */
@Slf4j
@RestController
@RequestMapping("/tservice")
public class TserviceController {
    @Autowired
    TserviceService tserviceService;

    /**
     * 查询服务列表,返回分页信息
     */
    @PostMapping(value = "/selectByCondition")
    public Result selectByCondition(Tservice tservice, Integer pageNum, Integer pageSize) {
        return ResultUtil.success(tserviceService.selectByCondition(tservice, pageNum, pageSize));
    }

    /**
     * 查询服务列表,不带分页信息
     *
     * @param tservice
     * @return
     */
    @PostMapping("/selectByConditionSimple")
    public Result selectByConditionSimple(Tservice tservice) {
        return ResultUtil.success(tserviceService.selectByCondition(tservice));
    }

    @PostMapping("/selectList")
    public List<Tservice> selectList(Tservice tservice) {
        return tserviceService.selectByCondition(tservice);
    }

    /**
     * 查询单个服务信息
     */
    @PostMapping(value = "/selectOne")
    public Result selectOne(Integer tserviceId) {
        Tservice tservice = tserviceService.selectOne(tserviceId);
        log.info("查询单条服务id=" + tserviceId);
        return ResultUtil.success(tservice);
    }

    /**
     * 添加服务
     */
    @PostMapping(value = "/insertOne")
    public Result insertOne(Tservice tservice) {
        log.info("新增的服务标识=" + tservice.getServicekey() + ",服务描述=" + tservice.getServicename() + "协议类型=" + tservice.getHttptype());
        return ResultUtil.success(tserviceService.insertOne(tservice));
    }

    /**
     * 编辑服务
     */
    @PostMapping(value = "/updateOne")
    public Result updateOne(Tservice tservice) {
        ReflectUtil.setInvalidFieldToNull(tservice, false);
        if (tservice.getId() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必传");
        }
        return ResultUtil.success(tserviceService.updateOne(tservice));
    }

    /**
     * 删除服务
     */
    @PostMapping(value = "/deleteOne")
    public Result deleteOne(Integer id) {
        return ResultUtil.success(tserviceService.deleteOne(id));
    }


}
