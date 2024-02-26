package com.example.studentapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Slf4j
@Aspect
public class LoggerAspect {


    @Before("execution(* com.example.studentapp.services.IStudentService.*(..))")
    public void beforeStudentService(JoinPoint joinPoint) {
        log.info("Entering into " + joinPoint.getSignature() + " with args " + Arrays.toString(joinPoint.getArgs()) + " at " + new Date());
    }

    @After("execution(* com.example.studentapp.services.IStudentService.*(..))")
    public void afterStudentService(JoinPoint joinPoint) {
        log.info("End Execution " + joinPoint.getSignature() + " with args " + Arrays.toString(joinPoint.getArgs()) + " at " + new Date());

    }



}
