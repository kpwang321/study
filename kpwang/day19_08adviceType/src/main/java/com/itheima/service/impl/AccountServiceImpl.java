package com.itheima.service.impl;

import com.itheima.service.IAccountService;

/**
 * @author kpwang
 * @create 2020-07-08 17:54
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存。。。。。。");
        //int i=1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新。。。。。。");
    }

    public int delectAccount() {
        System.out.println("执行了删除。。。。。。");
        return 0;
    }
}
