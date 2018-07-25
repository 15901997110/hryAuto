package com.haier.controller;

import com.haier.response.Result;
import com.haier.service.AutocodeService;
import com.haier.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/25 20:36
 */
@Controller
@RequestMapping("/autocode")
public class AutocodeController {
    @Autowired
    AutocodeService autocodeService;

    @PostMapping("/generate")
    public Result generrate() {
        autocodeService.generate();
        return ResultUtil.success();
    }
}
