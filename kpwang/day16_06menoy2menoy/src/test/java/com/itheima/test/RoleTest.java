package com.itheima.test;

import com.itheima.dao.IRoleDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
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
import java.util.List;


/**
 * @author kpwang
 * @create 2020-07-05 15:21
 */
public class RoleTest {
    private InputStream in;
    private SqlSession session;
    private IRoleDao roleDao;
    @Before
    public void init() throws IOException{
        //1读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3获取sqlSession对象
         session = sqlSessionFactory.openSession(true);
        //4获取dao的代理对象
        roleDao = session.getMapper(IRoleDao.class);
    }
    @After
    public void destroy() throws IOException {

        //session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAll() throws IOException {

        List<Role> list = roleDao.findAll();
        for (Role role : list) {
            System.out.println(role);
            System.out.println("--------");
        }


    }






}
