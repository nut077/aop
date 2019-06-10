package com.github.nut077.aop.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MemberDao {

    public void addMember() {
        log.info(getClass().toString() + " : DOING STUFF: ADDING A MEMBER ACCOUNT");
    }
}
