package com.haier.controller;

import com.haier.response.Result;
import com.haier.service.AutocodeService;
import com.haier.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/25 20:36
 */
@RestController
@RequestMapping("/autocode")
public class AutocodeController {
    @Autowired
    AutocodeService autocodeService;

/*    @PostMapping("/generate")
    public Result generate() {
        return ResultUtil.success(autocodeService.generate());
    }*/

    @PostMapping("/generateBaseClass")
    public Result generateBaseClass() {
        return ResultUtil.success(autocodeService.generateBaseClass());
    }

    @PostMapping("/generateDefaultClass")
    public Result generateDefaultClass() {
        return ResultUtil.success(autocodeService.generateDefaultTestClass());
    }
}
