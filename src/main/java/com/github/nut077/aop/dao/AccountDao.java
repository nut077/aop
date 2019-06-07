package com.github.nut077.aop.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountDao {

    public void addAccount() {
        log.info(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
