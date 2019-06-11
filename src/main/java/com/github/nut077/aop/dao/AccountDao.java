package com.github.nut077.aop.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Getter
@Setter
public class AccountDao {

    private String name;

    public void addAccount() {
        log.info(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public void addAccount(String name) {
        log.info(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT NAME : " + name);
    }
}
