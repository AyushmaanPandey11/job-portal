package com.ayushmaan.JobPortal.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.ayushmaan.JobPortal.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken for "+ jp.getSignature().getName() + " to execute is- "+ (end-start)+ "ms");
        return obj;
    }
}
