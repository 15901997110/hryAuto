package com.haier.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description: 使用aop对发送请求的参数进行前置增加
 * @Author: luqiwei
 * @Date: 2018/6/12 20:22
 */
@Component
@Slf4j
@Aspect
public class ParamAspect {
    @Around("execution(* com.haier.util.HryHttpClientUtil.send(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //前置增强,处理入参中有特定意义的字符串比如<!rd>
        Object[] args = proceedingJoinPoint.getArgs();
        Object param=args[2];
        log.debug("aspect-debug:"+param.toString());
        //执行切入点的方法
        proceedingJoinPoint.proceed(args);

        //后置增强,可以有些用例需要数据更新操作
    }
}
