package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Component;

/**
 * @author kpwang
 * @create 2020-07-07 1:50
 */
@Component("accountDao2")
public class AccountDaoImpl1 implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账号1");
    }
}
