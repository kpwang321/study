package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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
public class MybatisTest {
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
        }


    }



    @Test
    public void testFindUserById() throws IOException {
        User user = userDao.findUserById(54);
        System.out.println(user);
    }
    @Test
    public void testFindUserByName() throws IOException {
        List<User> list = userDao.findByName("王");
        System.out.println(list);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserByVo() throws IOException {
        QueryVo queryVo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> list = userDao.findUserByVo(queryVo);
        for (User user1 : list) {
            System.out.println(user1);
        }
    }
    @Test
    public void testFindUserByCondition() throws IOException {
        User user=new User();
        //user.setUsername("李沁");
        user.setSex("女");
        List<User> list = userDao.findUserByCondition(user);
        for (User user1 : list) {
            System.out.println(user1);
        }

    }
    @Test
    public void testFindUserInIds() throws IOException {
        QueryVo queryVo=new QueryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(41);
        list.add(50);
        list.add(54);
        queryVo.setIds(list);
        List<User> users = userDao.findUserInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }


    }

}
