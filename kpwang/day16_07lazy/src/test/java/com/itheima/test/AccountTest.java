package com.itheima.test;

import com.itheima.dao.IAcountDao;
import com.itheima.domain.Account;
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
public class AccountTest {
    private InputStream in;
    private SqlSession session;
    private IAcountDao acountDao;
    @Before
    public void init() throws IOException{
        //1读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3获取sqlSession对象
         session = sqlSessionFactory.openSession(true);
        //4获取dao的代理对象
        acountDao = session.getMapper(IAcountDao.class);
    }
    @After
    public void destroy() throws IOException {

        //session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAll() throws IOException {

        List<Account> list = acountDao.findAll();
        for (Account account : list) {
            /*System.out.println(account);
            System.out.println(account.getUser());
            System.out.println("-----------------");*/
        }
    }
}
