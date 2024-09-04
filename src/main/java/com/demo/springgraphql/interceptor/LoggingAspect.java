package com.demo.springgraphql.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.demo..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entered method: {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("execution(* com.demo..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Exited method: {}", joinPoint.getSignature());
    }
}
