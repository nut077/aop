package com.github.nut077.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpression {

    @Pointcut("execution(* com.github.nut077.aop.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoPackageNoGetterSetter() { }

    @Pointcut("execution(* com.github.nut077.aop.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("execution(* com.github.nut077.aop.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.github.nut077.aop.dao.AccountDao.getAccount())")
    public void afterReturning() {}
}
