package com.itheima.jdbctemple;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author kpwang
 * @create 2020-07-09 13:21
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源：spring的内置数据源
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.168.5.106:33306/spring?characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("root");



        //1创建jdbcTemplae对象
        JdbcTemplate jt=new JdbcTemplate(ds);
        //2执行操作
        jt.execute("insert into account(name,money) VALUES ('ccc',1000)");
    }
}
