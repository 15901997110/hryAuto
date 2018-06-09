package com.haier.controller;

import com.haier.po.RealtimeStatistic;
import com.haier.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/9 14:39
 */
@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    StatisticService statisticService;

    /**
     * 实时统计
     * @return
     */
    @GetMapping("/realtime")
    public List<RealtimeStatistic> realtimeStatistics(){
        return statisticService.statisticCurrent();
    }
}
