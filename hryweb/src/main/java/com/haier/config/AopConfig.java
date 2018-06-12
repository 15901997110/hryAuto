package com.haier.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 使用aop对发送请求的参数进行前置增加
 * @Author: luqiwei
 * @Date: 2018/6/12 14:11
 */
@Configuration
@Aspect
public class AopConfig {
    //切入点
    @Pointcut("execution(* com.haier.util.HryHttpClientUtil.send(..))")
    public void pointcut(){};


}
