package com.haier.po;

import lombok.Data;
import org.quartz.JobDataMap;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/21 8:55
 */
@Data
public class HryJob {
    private String jobName;
    private String jobGroup;
    private String cronExp;
    private JobDataMap jobDataMap;
}
