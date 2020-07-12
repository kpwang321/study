package com.itheima.jdbctemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author kpwang
 * @create 2020-07-09 13:32
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbctemplate = ac.getBean("jdbctemplate", JdbcTemplate.class);
        jdbctemplate.execute("insert into account(name,money) VALUES ('ddd',1000)");
    }
}
