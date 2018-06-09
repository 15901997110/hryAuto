package com.haier.controller;

import com.haier.enums.StatusCodeEnum;
import com.haier.po.Tenv;
import com.haier.response.Result;
import com.haier.service.TenvService;
import com.haier.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @Description: 环境维护
 * @Author: luqiwei
 * @Date: 2018/5/8 20:26
 */
@Slf4j
@RestController
@RequestMapping("/tenv")
public class TenvController {
    @Autowired
    TenvService tenvService;

    /**
     * 查询全部环境列表处理
     */
    @PostMapping(value = "/selectAll.do")
    public Result selectAll() {
        return ResultUtil.success(tenvService.selectAll());
    }

    /**
     * 查询单个环境信息
     * update by lish 2018-05-18 17:41
     */

    @PostMapping(value = "/selectOne.do")
    public Result selectOne(Integer id) {
        return ResultUtil.success(tenvService.selectOne(id));
    }

    /**
     * 新增环境处理
     * update by lish 2018-05-18 17:41
     */
    @PostMapping(value = "/insertOne.do")
    public Result insertOne(Tenv tenv) {
        return ResultUtil.success(tenvService.insertOne(tenv));

    }


    @PostMapping(value = "/deleteOne.do")
    public Result deleteOne(Integer id) {
        return ResultUtil.success(tenvService.deleteOne(id));
    }


    @PostMapping(value = "/updateOne.do")
    public Result updateOne(Tenv tenv) {
        return ResultUtil.success(tenvService.updateOne(tenv.getId(), tenv));
    }


}
