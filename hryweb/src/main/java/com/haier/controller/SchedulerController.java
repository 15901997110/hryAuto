package com.haier.controller;

import com.haier.response.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/17 16:26
 */
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @PostMapping("/addJob")
    public Result addJob() {
        return null;
    }
}
