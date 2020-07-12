package com.itheima.service;

import com.itheima.domain.Account;

/**
 * @author kpwang
 * @create 2020-07-09 16:25
 */
public interface IAccountService {
    Account findAccountById(Integer id);
    void transfer(String sourceName,String targetName,Float money);
}
