package com.github.nut077.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AfterThrowingAspect {

    @AfterThrowing(
            pointcut = "com.github.nut077.aop.aspect.AopExpression.afterThrowing()",
            throwing = "ex"
    )
    private void afterThrowingAspect(JoinPoint joinPoint, Throwable ex) {
        log.info("@AfterThrowing " + joinPoint.getSignature().toShortString());
        log.info("Throwing -->> " + ex);
    }
}
