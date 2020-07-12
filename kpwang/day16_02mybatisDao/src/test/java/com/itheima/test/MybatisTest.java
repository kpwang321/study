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
import java.util.Date;
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
         session = sqlSessionFactory.openSession();
        //4获取dao的代理对象
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {

        session.commit();
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
    public void testSaveUser() throws IOException {

        User user=new User();
        user.setUsername("王凯鹏");
        user.setAddress("重庆市北部区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
        System.out.println(user);
    }
    @Test
    public void testUpdateUser() throws IOException {

        User user=new User();
        user.setUsername("mybatis updateuser");
        user.setAddress("重庆市北碚区");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setId(52);
        userDao.updateUser(user);
    }
    @Test
    public void testDeleteUser() throws IOException {
        userDao.deleteUser(52);
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
    public void testFindTotal() throws IOException {
        System.out.println(userDao.findTotal());
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

}
