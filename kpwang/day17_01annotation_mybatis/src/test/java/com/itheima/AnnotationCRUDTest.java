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
    public void testSaveUser() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        User user=new User();
        user.setUsername("古力娜扎");
        user.setAddress("重庆市南岸区");
        user.setBirthday(sdf.parse("1990-03-21"));
        user.setSex("女");
        userDao.saveUser(user);
    }
    @Test
    public void testUpdateUser() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        User user=new User();
        user.setUsername("迪丽热巴");
        user.setAddress("重庆市北碚区");
        user.setBirthday(sdf.parse("1992-02-18"));
        user.setSex("女");
        user.setId(42);
        userDao.updateUser(user);
    }
    @Test
    public void testDeleteUser() throws ParseException {

        userDao.deleteUser(60);
    }
    @Test
    public void testFinduserById() throws ParseException {

        User user = userDao.findUserById(58);
        System.out.println(user);
    }
    @Test
    public void testFinduserByName() throws ParseException {
        List<User> list = userDao.findUserByName("%王%");
        System.out.println(list);
    }
    @Test
    public void testFindTotal() throws ParseException {
        int total = userDao.totalUser();
        System.out.println(total);
    }
}
