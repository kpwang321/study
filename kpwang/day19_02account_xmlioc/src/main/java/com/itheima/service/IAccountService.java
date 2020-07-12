package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-07 20:06
 */
public interface IAccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);
}
