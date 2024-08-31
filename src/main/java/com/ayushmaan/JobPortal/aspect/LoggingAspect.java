package com.ayushmaan.JobPortal.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    private static  final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution( * com.ayushmaan.JobPortal.service.JobService.*(..) )")
    public void logMethodCallBefore(JoinPoint joinPoint){
        LOGGER.info("Job Service Method Before Called- {}", joinPoint.getSignature().getName());
    }

    @After("execution( * com.ayushmaan.JobPortal.service.JobService.*(..) )")
    public void logMethodCallAfter( JoinPoint joinPoint){
        LOGGER.info("Job Service Method After Called- {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution( * com.ayushmaan.JobPortal.service.JobService.*(..) )")
    public void logMethodCallAfterThrowing( JoinPoint joinPoint){
        LOGGER.info("Job Service Method AfterThrowing Called- {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully {}", jp.getSignature().getName());
    }
}
