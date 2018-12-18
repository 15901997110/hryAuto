package com.haier.service.impl;

import com.haier.service.SchedulerService;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/18 13:37
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {
    @Override
    public Boolean addJob(String jobName, String jobGroup, String cronExp) {
        JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();

        return null;
    }
}
