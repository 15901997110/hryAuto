package com.haier.controller;


import com.haier.po.Tenv;
import com.haier.response.Result;
import com.haier.service.TenvService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping(value = "/selectAll")
    public Result selectAll() {
        return ResultUtil.success(tenvService.selectAll());
    }

    @PostMapping(value = "/selectOne")
    public Result selectOne(Integer id) {
        return ResultUtil.success(tenvService.selectOne(id));
    }

    @PostMapping(value = "/insertOne")
    public Result insertOne(@Validated Tenv tenv) {
        return ResultUtil.success(tenvService.insertOne(tenv));

    }

    @PostMapping(value = "/deleteOne")
    public Result deleteOne(Integer id) {
        return ResultUtil.success(tenvService.deleteOne(id));
    }

    @PostMapping(value = "/updateOne")
    public Result updateOne(@Validated Tenv tenv) {
        return ResultUtil.success(tenvService.updateOne(tenv));
    }


}
