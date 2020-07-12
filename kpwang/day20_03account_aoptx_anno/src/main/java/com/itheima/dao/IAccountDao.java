package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-07 20:11
 */
public interface IAccountDao {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);


    Account findAccountByName(String accountName);
}
