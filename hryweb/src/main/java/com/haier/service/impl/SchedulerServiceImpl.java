package com.haier.service.impl;

import com.haier.job.RunCustomJob;
import com.haier.service.SchedulerService;
import org.quartz.JobDataMap;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/18 13:37
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {

    public Boolean addJob(String jobName, String jobGroup,JobDataMap jobDataMap, String cronExp) {
        JobDetailFactoryBean jobDetail=new JobDetailFactoryBean();

        jobDetail.setName(jobName);
        jobDetail.setGroup(jobGroup);
        jobDetail.setJobClass(RunCustomJob.class);
        jobDetail.setJobDataMap(jobDataMap);



        return null;
    }
}
