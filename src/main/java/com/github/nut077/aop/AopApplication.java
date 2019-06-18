package com.github.nut077.aop;

import com.github.nut077.aop.config.AspectConfig;
import com.github.nut077.aop.dao.AccountDao;
import com.github.nut077.aop.dao.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class AopApplication {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);

        // get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        accountDao.setName("Freedom");
        accountDao.addAccount();
        accountDao.addAccount("Freedom");
        accountDao.addAccount(new AccountDao("eiei", "55"));

        log.info(accountDao.getAccount().toString());

        // get Throwable
        try {
            int throwing = accountDao.afterThrowing();
            log.info("Main -->> " + throwing);
        } catch (NumberFormatException e) {
            log.info(e.getMessage());
        }

        // after
        log.info("Main after " + accountDao.after());

        // around
        log.info("Main around " + accountDao.around());

        MemberDao memberDao = context.getBean("memberDao", MemberDao.class);
        memberDao.addMember();
    }

}
