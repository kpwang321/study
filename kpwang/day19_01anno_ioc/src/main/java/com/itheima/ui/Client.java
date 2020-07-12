package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author kpwang
 * @create 2020-07-07 1:51
 */
public class Client {
    //获取spring的ioc核心容器，并根据id获取对象
    public static void main(String[] args) {
        //1获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2根据id获取bean对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        /*IAccountDao accountDao=ac.getBean("accountDao",IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);*/
        accountService.saveAccount();
    }
}
