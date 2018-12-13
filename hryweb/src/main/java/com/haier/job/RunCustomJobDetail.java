package com.haier.job;

import com.haier.service.TcustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/12 20:10
 */
@Component
public class RunCustomJobDetail {
    @Autowired
    TcustomService tcustomService;

    /*@Autowired*/

    public JobDetailFactoryBean createJobDetailFactoryBean(Integer customId, Integer executeUserId) {

/*        JobDetailFactoryBean factory=new JobDetailFactoryBean();
        factory.setName(jobName);
        factory.setGroup(jobGroup);
        Map<>
        factory.set*/
        return null;
    }
}
