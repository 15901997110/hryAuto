package com.haier.job;

import com.haier.config.SpringContextHolder;
import com.haier.service.TcustomService;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/12 13:22
 */

public class RunCustomJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Integer customId = (Integer) jobDataMap.get("customId");
        Integer executeUserId = (Integer) jobDataMap.get("executeUserId");
        TcustomService tcustomService = SpringContextHolder.getBean(TcustomService.class);
        tcustomService.run(customId, executeUserId);
    }
}
