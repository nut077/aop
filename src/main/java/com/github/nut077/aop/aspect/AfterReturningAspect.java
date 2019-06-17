package com.github.nut077.aop.aspect;

import com.github.nut077.aop.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Slf4j
@Component
@Order(3)
public class AfterReturningAspect {

    @AfterReturning(
            pointcut = "com.github.nut077.aop.aspect.AopExpression.afterReturning()",
            returning = "accountDaoList"
    )
    public void afterReturnAspect(JoinPoint joinPoint, List<AccountDao> accountDaoList) {
        log.info("@AfterReturning on method " + joinPoint.getSignature().toShortString());
        log.info("@AfterReturning result before lowercase = " + accountDaoList);
        setLowercase(accountDaoList);
        log.info("@AfterReturning result after lowercase = " + accountDaoList);
    }

    private void setLowercase(List<AccountDao> accountDaoList) {
        for (AccountDao accountDao : accountDaoList) {
            accountDao.setName(accountDao.getName().toLowerCase());
        }
    }
}
