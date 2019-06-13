package com.github.nut077.aop.aspect;

import com.github.nut077.aop.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(1)
public class LoggingAspect {

    //@Before("execution(* add*())") //เอาทุก method ที่ขึ้นต้นด้วย add
    //@Before("execution(* addAccount())") //เอาเฉพาะ method ที่ชื่อ addAccount
    //@Before("execution(public void com.github.nut077.aop.dao.AccountDao.addAccount())") // เลือกแบบ full path
    //@Before("execution(* com.github.nut077.aop.dao.*.*(..))") // return type, package, class, method, param type .. คือเอากี่ param ก็ได้
    //@Before("execution(* com.github.nut077.aop.dao.*.*(java.lang.String))") // return type, package, class, method, param type เฉพาะ param ที่เป็น String
    //@Before("execution(* com.github.nut077.aop.dao.*.*(java.lang.String, ..))") // return type, package, class, method, param type เฉพาะ param แรก ที่เป็น String และหลังจากนั้นเป็นอะไรก็ได้
    //@Before("forDaoPackage()") // เราสามารถเรียกใช้ Pointcut ในการประกาศตัวแปร แล้วเราก็เรียกใช้จากชื่อ method
    @Before("com.github.nut077.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()") // เพิ่มเงื่อนไข ไม่เอา method set กับ get
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        log.info("=====>>> Executing @Before advice on method");
        log.info("=====>>> Method  " + signature);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("======>> arg " + arg);
            if (arg instanceof AccountDao) {
                AccountDao accountDao = (AccountDao) arg;
                log.info("=====>>> Account name " + accountDao.getName());
                log.info("=====>>> Account level " + accountDao.getLevel());
            }
        }

    }
}
