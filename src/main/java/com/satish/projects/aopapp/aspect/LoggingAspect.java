package com.satish.projects.aopapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    @Before("execution(* com.satish.projects.aopapp.service.impl.ShipmentServiceImpl.*(..))")
//    public void beforeShipmentServiceMethods(JoinPoint joinPoint) {
//        log.info("Before method call: {}", joinPoint.getSignature());
//    }

//    @Before("execution(* orderPackage(..))")
//    @Before("execution(* com.satish.projects.aopapp.service.impl.ShipmentServiceImpl.orderPackage(..))") //all overloaded methods
//    @Before("execution(* com.satish.projects.aopapp.service.impl.*.*(..))")
//    public void beforeOrderPackage(JoinPoint joinPoint) {
//        log.info("Before called from LoggingAspect : {}",joinPoint.getKind());
//        log.info("Before called from LoggingAspect : {}",joinPoint.getSignature());
//    }


//    @Before("within(com.satish.projects.aopapp.service.impl.*)")
//    @Before("within(com.satish.projects.aopapp..*)")
//    public void beforeServiceMethodCalls(JoinPoint joinPoint) {
//        log.info("Before Service method calls");
//    }


//    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
//    public void beforeTransactionalMethods(JoinPoint joinPoint) {
//        log.info("Before Transactional method calls");
//    }

    @Before("myLoggingAndAopMethodsPointCut()")
    public void beforeTransactionalMethods(JoinPoint joinPoint) {
        log.info("Before MyLogging method calls");
    }

    @After("myLoggingAndAopMethodsPointCut()")
    public void afterTransactionalMethods(JoinPoint joinPoint) {
        log.info("After MyLogging method calls");
    }


    @Pointcut("@annotation(com.satish.projects.aopapp.aspect.MyLogging) && within(com.satish.projects.aopapp..*)")
    public void myLoggingAndAopMethodsPointCut() {

    }
}
