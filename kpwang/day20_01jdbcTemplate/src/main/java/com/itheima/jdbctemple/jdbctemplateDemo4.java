package com.itheima.jdbctemple;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kpwang
 * @create 2020-07-09 14:48
 */
public class jdbctemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account account=accountDao.findAccountById(12);
        System.out.println(account);

        Account accountName = accountDao.findAccountByName("赵丽颖");
        System.out.println(accountName);
        accountName.setMoney(99999f);
        accountDao.updateAccount(accountName);

    }
}
