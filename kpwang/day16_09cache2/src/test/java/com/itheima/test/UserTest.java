package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author kpwang
 * @create 2020-07-05 15:21
 */
public class UserTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;


    @Before
    public void init() throws IOException{
        //1读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

    }
    @After
    public void destroy() throws IOException {

        //session.commit();
        //session.close();
        in.close();
    }
    @Test
    public void testFirstLevelCache() throws IOException {
         //3获取sqlSession对象
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        //4获取dao的代理对象
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findUserById(41);
        System.out.println(user1);
        sqlSession1.close();
         //3获取sqlSession对象
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        //4获取dao的代理对象
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = userDao2.findUserById(41);
        System.out.println(user2);
        sqlSession2.close();
        System.out.println(user1==user2);


    }






}
