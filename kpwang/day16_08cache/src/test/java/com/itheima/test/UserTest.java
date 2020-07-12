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
    private SqlSession session;

    private IUserDao userDao;
    @Before
    public void init() throws IOException{
        //1读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3获取sqlSession对象
         session = sqlSessionFactory.openSession(true);
        //4获取dao的代理对象
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {

        //session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFirstLevelCache() throws IOException {

        User user1 = userDao.findUserById(41);
        System.out.println(user1);
        /*session.close();
        session=sqlSessionFactory.openSession();*/
        //userDao = session.getMapper(IUserDao.class);
        session.clearCache();
        User user2 = this.userDao.findUserById(41);
        System.out.println(user2);
        System.out.println(user1==user2);



    }
    @Test
    public void testFirstLevelCache1() throws IOException {

        User user1 = userDao.findUserById(41);
        System.out.println(user1);
    }
    @Test
    public void testFirstLevelCache2() throws IOException {

        User user1 = userDao.findUserById(41);
        System.out.println(user1);
    }
    @Test
    public void testClearCache() throws IOException {

        User user1 = userDao.findUserById(41);
        System.out.println(user1);
        user1.setUsername("赵丽颖");
        user1.setSex("女");
        userDao.updateUser(user1);

        User user2 = this.userDao.findUserById(41);
        System.out.println(user2);
        System.out.println(user1==user2);



    }




}
