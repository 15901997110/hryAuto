package com.haier.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description: 使用aop对发送请求的参数进行前置增加
 * @Author: luqiwei
 * @Date: 2018/6/12 14:11
 */
@Slf4j
@Component
@Aspect//描述切面类
public class AopConfig {
    //切入点
    @Pointcut("execution(* com.haier.util.HryHttpClientUtil.send(..))")
    public void execute(){};

    @Around("execute()")
    public void doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        for(Object o:args){
            log.debug(o.toString());
        }
        Object proceed = proceedingJoinPoint.proceed();


    }

}
