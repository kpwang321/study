package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;

/**
 * @author kpwang
 * @create 2020-07-07 1:48
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao=new AccountDaoImpl();


    public void saveAccount() {
        int i=1;
        accountDao.saveAccount();
        System.out.println(i++);

    }
}
