package com.itheima.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kpwang
 * @create 2020-07-08 18:16
 */

public class IAccountServiceTest {

    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
        accountService.updateAccount(0);
        accountService.delectAccount();

    }
}