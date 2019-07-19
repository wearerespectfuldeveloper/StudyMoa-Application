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
public class PerformanceAspect {

    @Around("execution(* com.ward.studymoa..*Service.*(..))")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        StopWatch stopWatch = new StopWatch();

        try {
            stopWatch.start();
            result = proceedingJoinPoint.proceed();
            stopWatch.stop();

            log.info("수행 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
        } catch (Throwable throwable) {
            log.info(throwable.getMessage());
        }
        return result;
    }
}
