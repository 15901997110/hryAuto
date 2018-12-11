package com.haier.controller;

import com.haier.job.HelloJob;
import com.haier.response.Result;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/11 19:12
 */
@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    private Scheduler scheduler;

    @PostMapping("/addJob")
    public Result addJob() throws SchedulerException {
        JobDetail jobDetail= JobBuilder.newJob(HelloJob.class).withIdentity("myClassName","myGroupName")
                .build();
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerName", "triggerGroup").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(10))
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        return null;
    }

}
