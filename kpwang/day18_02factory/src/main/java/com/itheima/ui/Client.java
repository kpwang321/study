package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * @author kpwang
 * @create 2020-07-07 1:51
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as=new AccountServiceImpl();
        for (int i = 0; i <5 ; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
        //as.saveAccount();
    }
}
