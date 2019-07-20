package com.ward.studymoa.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ExecutionLoggingAspect {

    @Before("execution(* com.ward.studymoa..*Service.*(..))")
    public void beforeExecutionLogging(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("Service >>> " + className + "." + methodName + "(" + args + ")");
    }

    @AfterReturning(value = "execution(* com.ward.studymoa..*Service.*(..))", returning = "returnValue")
    public void afterReturningExecutionLogging(JoinPoint joinPoint, Object returnValue) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Return Value : " + returnValue.toString());
        log.info("Service <<< " + className + "." + methodName + "(" + args + ")");
    }

    @AfterThrowing(value = "execution(* com.ward.studymoa..*Service.*(..))")
    public void afterThrowingExecutionLogging(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.error("[ERROR] Service <<< " + className + "." + methodName + "(" + args + ")");
    }
}
