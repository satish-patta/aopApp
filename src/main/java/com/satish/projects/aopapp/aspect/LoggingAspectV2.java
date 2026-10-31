package com.satish.projects.aopapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Before("allServiceMethodPointCut()")  //Advice / named pointcut
    public void beforeServiceMethodCalls(JoinPoint joinPoint) {
       log.info("Before advice method call, {}", joinPoint.getSignature());
    }

//    @After("allServiceMethodPointCut")
//    @AfterReturning(value = "allServiceMethodPointCut()", returning = "returnedObj")  //Advice / named pointcut
    @AfterThrowing("allServiceMethodPointCut()")  //Advice / named pointcut
    public void afterServiceMethodCalls(JoinPoint joinPoint) {
       log.info("AfterThrowing advice method call, {}", joinPoint.getSignature());
    }


    @Around("allServiceMethodPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object returnedValue = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        Long diff = endTime - startTime;
        log.info("Execution time in milliseconds, {}, {}", diff, joinPoint.getSignature());
        return returnedValue;
    }

    @Pointcut("execution(* com.satish.projects.aopapp.service.*.*(..))")
    public void allServiceMethodPointCut() {

    }
}
