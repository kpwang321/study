package com.itheima;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
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
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-06 18:16
 */
public class AccountTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
    @Before
    public void init() throws IOException{
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws ParseException {

        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
            System.out.println(account.getUser());
            System.out.println("-------------");
        }

    }


}
