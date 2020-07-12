package com.itheima.service;

import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author kpwang
 * @create 2020-07-08 3:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class IAccountServiceTest {
    @Autowired
    private IAccountService accountService;
    @Test
    public void transter() {
        accountService.transfer("aaa","bbb",100f);
    }
}