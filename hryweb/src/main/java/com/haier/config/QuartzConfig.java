package com.haier.config;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/12 10:14
 */
//@Configuration
public class QuartzConfig {
    /*
     * quartz初始化监听器
     * 这个监听器可以监听到工程的启动，在工程停止再启动时可以让已有的定时任务继续进行
     */
/*    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean(){
        SchedulerFactoryBean factoryBean=new SchedulerFactoryBean();
        return factoryBean;
    }*/

/*    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean){

    }*/
}
