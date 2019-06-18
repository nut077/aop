package com.github.nut077.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AroundAspect {

    @Around("com.github.nut077.aop.aspect.AopExpression.around()")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            log.info(e.getMessage() + " -->> Fixed throw by @Around");
            result = "Fixed throw by @Around";
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        log.info("@Around -->> duration process " + duration / 1000.0 + " seconds");
        return result;
    }
}
