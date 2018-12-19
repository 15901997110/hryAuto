package com.haier.service.impl;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.job.RunCustomJob;
import com.haier.service.SchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/18 13:37
 */
@Service
@Slf4j
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    Scheduler scheduler;

    public Boolean addJob(String jobName, String jobGroup, JobDataMap jobDataMap, String cronExp) {
        if (!CronExpression.isValidExpression(cronExp)) {
            throw new HryException(StatusCodeEnum.CRON_ERROR);
        }
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();

        jobDetail.setName(jobName);
        jobDetail.setGroup(jobGroup);
        jobDetail.setJobClass(RunCustomJob.class);
        jobDetail.setJobDataMap(jobDataMap);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExp).withMisfireHandlingInstructionDoNothing();
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail.getObject())
                .withSchedule(scheduleBuilder)
                .build();

        try {
            scheduler.scheduleJob(jobDetail.getObject(), trigger);
        } catch (SchedulerException e) {
            log.error("添加Job失败", e);
        }


        return null;
    }
}
