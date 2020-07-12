package com.itheima.jdbctemple;

import com.itheima.domain.Account;
import com.sun.rowset.internal.Row;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-09 13:32
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbctemplate = ac.getBean("jdbctemplate", JdbcTemplate.class);

        //保存
       // jdbctemplate.update("insert into account(name,MONEY) VALUES (?,?)","eee",3333f);
        //更新
        //jdbctemplate.update("update  account set name=? ,money=? where ID=?","赵丽颖",2222f,12);
        //删除
        //jdbctemplate.update("delete from account where id=?",11);
        //查询所有
        //List<Account> accounts = jdbctemplate.query("select * from account where money>?", new AccountRowMapper(), 1000f);
        List<Account> accounts = jdbctemplate.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        for (Account account : accounts) {
            System.out.println(account);
        }
        //查询一个
        List<Account> list = jdbctemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 12);
        System.out.println(list.isEmpty()?"没有记录":list.get(0));
        //查询返回一行一列(使用聚合函数，但不加group by字句)
        int count = jdbctemplate.queryForObject("select count(1) from account where money > ? ", Integer.class, 1000f);
        System.out.println(count);
    }
}
class AccountRowMapper implements RowMapper<Account>{

    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account=new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
