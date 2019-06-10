package com.github.nut077.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    //@Before("execution(* add*())") //เอาทุก method ที่ขึ้นต้นด้วย add
    //@Before("execution(* addAccount())") //เอาเฉพาะ method ที่ชื่อ addAccount
    //@Before("execution(public void com.github.nut077.aop.dao.AccountDao.addAccount())") // เลือกแบบ full path
    //@Before("execution(* com.github.nut077.aop.dao.*.*(..))") // return type, package, class, method, param type .. คือเอากี่ param ก็ได้
    //@Before("execution(* com.github.nut077.aop.dao.*.*(java.lang.String))") // return type, package, class, method, param type เฉพาะ param ที่เป็น String
    @Before("execution(* com.github.nut077.aop.dao.*.*(java.lang.String, ..))") // return type, package, class, method, param type เฉพาะ param แรก ที่เป็น String และหลังจากนั้นเป็นอะไรก็ได้
    public void beforeAddAccountAdvice() {
        log.info("\n=====>>> Executing @Before advice on method");
    }
}
