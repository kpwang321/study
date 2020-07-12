package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-06 1:05
 */
public interface IAcountDao {
    List<Account> findAll();
    List<Account> findAccountByUid(Integer id);
}
