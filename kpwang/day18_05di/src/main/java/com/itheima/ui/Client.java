package com.itheima.ui;


import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kpwang
 * @create 2020-07-07 1:51
 */
public class Client {
    //获取spring的ioc核心容器，并根据id获取对象
    public static void main(String[] args) {
        //1获取核心容器对象
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2根据id获取bean对象
        IAccountService as1 = (IAccountService) ac.getBean("accountService");
        as1.saveAccount();
        IAccountService as2 = (IAccountService) ac.getBean("accountService2");
        as2.saveAccount();
        IAccountService as3 = (IAccountService) ac.getBean("accountService3");
        as3.saveAccount();



    }
}
