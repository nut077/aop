package com.github.nut077.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AfterAspect {

    @After("com.github.nut077.aop.aspect.AopExpression.after()")
    private void afterAspect(JoinPoint joinPoint) {
        log.info("@After -->> " + joinPoint.getSignature().toShortString());
    }
}
