package com.github.nut077.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    //@Before("execution(* add*())") เอาทุก method ที่ขึ้นต้นด้วย add
    //@Before("execution(* addAccount())") เอาเฉพาะ method ที่ชื่อ addAccount
    public void beforeAddAccountAdvice() {
        log.info("\n=====>>> Executing @Before advice on method");
    }
}
