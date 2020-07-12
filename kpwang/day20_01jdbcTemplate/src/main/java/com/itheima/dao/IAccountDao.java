package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-09 14:35
 */
public interface IAccountDao {
    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);
}
