package com.github.nut077.aop;

import com.github.nut077.aop.config.AspectConfig;
import com.github.nut077.aop.dao.AccountDao;
import com.github.nut077.aop.dao.MemberDao;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);

        // get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        accountDao.addAccount();
        accountDao.addAccount("Freedom");

        MemberDao memberDao = context.getBean("memberDao", MemberDao.class);
        memberDao.addMember();
    }

}
