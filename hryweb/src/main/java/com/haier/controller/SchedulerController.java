package com.haier.controller;

import com.haier.enums.JobParam;
import com.haier.po.HryJob;
import com.haier.response.Result;
import com.haier.service.SchedulerService;
import com.haier.service.impl.SchedulerServiceImpl;
import com.haier.util.ResultUtil;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/17 16:26
 */
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Resource
    SchedulerService schedulerService;

//    @PostMapping("/addJob")
//    public Result addJob() throws SchedulerException {
//        JobDataMap jobDataMap=new JobDataMap();
//        jobDataMap.put(JobParam.CUSTOM_ID.getKey(),127);
//        jobDataMap.put(JobParam.EXECUTE_USER_ID.getKey(),193);
//        jobDataMap.put(JobParam.EXECUTE_USER_NAME.getKey(),"scheduler");
//        schedulerServiceImpl.addJob("测试JobName","测试JobGroup",jobDataMap,"*/10 * * * * ?");
//        return null;
//    }
    @PostMapping("/addJob")
    public Result addJob(@RequestBody HryJob hryJob) throws SchedulerException {
        schedulerService.addJob(hryJob.getJobName(),hryJob.getJobGroup(),null,hryJob.getCronExp());
        return ResultUtil.success("success");
    }
    @PostMapping("/pauseJob")
    public Result pauseJob(@RequestBody HryJob hryJob) throws SchedulerException{
        schedulerService.pauseJob(hryJob.getJobName(),hryJob.getJobGroup());
        return ResultUtil.success("success");
    }

    @PostMapping("/resumeJob")
    public Result resumeJob(@RequestBody HryJob hryJob) throws SchedulerException {
        schedulerService.resumeJob(hryJob.getJobName(),hryJob.getJobGroup());
        return ResultUtil.success("success");
    }

    @PostMapping("/updateJob")
    public Result updateJob(@RequestBody HryJob hryJob) throws SchedulerException {
        schedulerService.updateJob(hryJob.getJobName(),hryJob.getJobGroup(),hryJob.getCronExp());
        return ResultUtil.success("success");
    }

    @PostMapping("/deleteJob")
    public Result deleteJob(@RequestBody HryJob hryJob) throws SchedulerException {
        schedulerService.deleteJob(hryJob.getJobName(),hryJob.getJobGroup());
        return ResultUtil.success("success");
    }
}
