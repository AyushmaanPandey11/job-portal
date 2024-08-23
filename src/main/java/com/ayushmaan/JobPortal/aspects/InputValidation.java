package com.ayushmaan.JobPortal.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InputValidation {
    private  static  final Logger LOGGER = LoggerFactory.getLogger(InputValidation.class);

    @Around("execution(* com.ayushmaan.JobPortal.service.JobService.getJob(..)) && args(id)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int id) throws Throwable {
        if(id < 0){
            LOGGER.info("PostId given for "+ jp.getSignature().getName() + " is Negative.");
            id = -id;
            LOGGER.info("correct value is "+ id);
        }
        Object obj = jp.proceed(new Object[]{id});
        return obj;
    }
}
