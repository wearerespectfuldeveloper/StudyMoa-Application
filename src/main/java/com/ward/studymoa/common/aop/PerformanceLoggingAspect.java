package com.ward.studymoa.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformanceLoggingAspect {

    @Around("execution(* com.ward.studymoa..*Service.*(..))")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        Object result = null;
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        log.info("수행 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
        log.info("Return Value : " + result.toString());
        return result;
    }
}
