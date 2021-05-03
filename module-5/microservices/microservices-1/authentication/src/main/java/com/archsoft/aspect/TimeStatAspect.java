package com.archsoft.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeStatAspect implements Ordered {

    @Around("execution(public * com.archsoft.controller.*.*(..))")
    public Object logTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();

        Object ret = proceedingJoinPoint.proceed();

        long t2 = System.currentTimeMillis();
        log.info("Time processing: {} (ms)", t2-t1);

        return ret;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
