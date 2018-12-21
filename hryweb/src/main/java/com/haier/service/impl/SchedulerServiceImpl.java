package com.haier.service.impl;

import com.haier.service.SchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/18 13:37
 */
@Service
@Slf4j
public class SchedulerServiceImpl implements SchedulerService {

    @Resource
    Scheduler scheduler;

    @Resource
    JobDetail jobDetail;

    @Override
    public void addJob(String triggerName, String triggerGroup, String desc,JobDataMap jobDataMap, String cronExp) throws SchedulerException {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(cronExp)
                .withMisfireHandlingInstructionDoNothing();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withDescription(desc)
                .usingJobData(jobDataMap)
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(scheduleBuilder)
                .build();

        try {
            scheduler.scheduleJob(trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            log.error("创建Job失败", e);
            throw new RuntimeException("创建Job失败", e);
        }
    }

    @Override
    public void pauseJob(String triggerName, String triggerGroup) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
    }


    @Override
    public void resumeJob(String triggerName, String triggerGroup) throws SchedulerException {
        scheduler.resumeTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
    }


    @Override
    public void deleteJob(String triggerName, String triggerGroup) throws SchedulerException {
        pauseJob(triggerName, triggerGroup);
        scheduler.unscheduleJob(TriggerKey.triggerKey(triggerName, triggerGroup));
    }


    @Override
    public void updateJob(String triggerName, String triggerGroup,String desc, String cronExp) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        trigger = trigger.getTriggerBuilder()
                .withIdentity(triggerKey)
                .withDescription(desc)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExp))
                .build();
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    @Override
    public Boolean checkExists(String triggerName, String triggerGroup) throws SchedulerException {
        return scheduler.checkExists(TriggerKey.triggerKey(triggerName, triggerGroup));
    }


}
