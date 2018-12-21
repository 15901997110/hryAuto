package com.haier.service;

import org.quartz.JobDataMap;
import org.quartz.SchedulerException;

/**
 * @Description: 封装对任务的控制
 * @Author: luqiwei
 * @Date: 2018/12/18 13:26
 */
public interface SchedulerService {
    void addJob(String triggerName, String triggerGroup, JobDataMap jobDataMap, String cronExp) throws SchedulerException;
    void pauseJob(String triggerName, String triggerGroup) throws SchedulerException;
    void resumeJob(String triggerName, String triggerGroup) throws SchedulerException;
    void deleteJob(String triggerName, String triggerGroup) throws SchedulerException;
    void updateJob(String triggerName, String triggerGroup, String cronExp) throws SchedulerException;
}
