package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-07 20:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> list = accountService.findAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }

    }
    @Test
    public void testFindOne() {
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("赵丽颖");
        account.setMoney(12321.2f);
        accountService.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account=new Account();
        account.setName("赵丽颖1");
        account.setMoney(123421.2f);
        account.setId(4);
        accountService.updateAccount(account);
    }
    @Test
    public void testDelete() {
        accountService.deleteAccount(4);
    }
}
