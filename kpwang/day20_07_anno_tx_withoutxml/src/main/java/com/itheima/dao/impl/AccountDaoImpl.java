package com.itheima.dao.impl;



import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-09 14:36
 */
@Repository
public class AccountDaoImpl  implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findAccountById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?new Account():accounts.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where NAME =?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()){
            return new Account();
        }else if (accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }else {
            return accounts.get(0);
        }

    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE account SET name=?,MONEY=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
