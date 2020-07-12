package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-07 20:12
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer id) {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where id=?",new BeanHandler<Account>(Account.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer id) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"delete from account where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where name=?", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts==null||accounts.size()==0){
                return null;
            }else if (accounts.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }else {
                return accounts.get(0);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
