package com.github.nut077.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(2)
public class ApiAnalyticAspect {

    //@Before("com.github.nut077.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void apiAnalatic() {
        log.info("=====>>> Executing @Before apiAnalatic");
    }
}
