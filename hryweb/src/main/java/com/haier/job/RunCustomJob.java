package com.haier.job;

import com.haier.config.SpringContextHolder;
import com.haier.enums.JobParam;
import com.haier.po.User;
import com.haier.service.TcustomService;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/12 13:22
 */

public class RunCustomJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        /**
         * customId,executeUserId,executeUserName 此三个参数要求必填,
         * 此参数将会传到运行定制中去
         */
        Integer customId = jobDataMap.getIntegerFromString(JobParam.CUSTOM_ID.getKey());//定制ID
        Integer executeUserId = jobDataMap.getIntegerFromString(JobParam.EXECUTE_USER_ID.getKey());//执行用户ID
        String executeUserName = jobDataMap.getString(JobParam.EXECUTE_USER_NAME.getKey());//执行用户RealName

        User executeUser = new User();
        executeUser.setId(executeUserId);
        executeUser.setRealname(executeUserName);

        TcustomService tcustomService = SpringContextHolder.getBean(TcustomService.class);
        tcustomService.run(customId, executeUser);
    }
}
