package com.github.nut077.aop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDao {

    private String name;
    private String level;

    public void addAccount() {
        log.info(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public void addAccount(String name) {
        log.info(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT NAME : " + name);
    }

    public void addAccount(AccountDao accountDao) {
        log.info(getClass() + "Add account" + accountDao);
    }
}
