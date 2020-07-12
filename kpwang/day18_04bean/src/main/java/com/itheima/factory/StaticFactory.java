package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * @author kpwang
 * @create 2020-07-07 3:49
 */
public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
