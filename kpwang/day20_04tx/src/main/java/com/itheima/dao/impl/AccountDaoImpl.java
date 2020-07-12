package com.itheima.dao.impl;



import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-09 14:36
 */

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {



    public Account findAccountById(Integer id) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?new Account():accounts.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where NAME =?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()){
            return new Account();
        }else if (accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }else {
            return accounts.get(0);
        }

    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("UPDATE account SET name=?,MONEY=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
