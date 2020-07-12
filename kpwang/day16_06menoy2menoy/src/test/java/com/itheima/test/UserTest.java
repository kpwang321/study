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
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws IOException{
        //1读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
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
    public void testFindAll() throws IOException {

        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
            System.out.println("--------");
        }


    }



}
