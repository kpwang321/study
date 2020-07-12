package com.itheima;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-06 18:16
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before
    public void init() throws IOException{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws ParseException {

        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println("-------------");
            //System.out.println(user);
            //System.out.println(user.getAccounts());
        }

    }
    @Test
    public void testFinduserById() throws ParseException {

        User user1 = userDao.findUserById(58);
        System.out.println(user1);
        User user2 = userDao.findUserById(58);
        System.out.println(user2);
    }
    @Test
    public void testFinduserByName() throws ParseException {
        List<User> list = userDao.findUserByName("%王%");
        System.out.println(list);
    }

}
