package cn.itcast.dao;

import cn.itcast.domain.Account;
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

import static org.junit.Assert.*;

/**
 * @author kpwang
 * @create 2020-07-11 0:48
 */
public class AccountDaoTest {
    InputStream is=null;
    SqlSessionFactory sqlSessionFactory=null;
    SqlSession sqlSession=null;
    AccountDao accountDao=null;
    @Before
    public void init() throws IOException {
        //加载mybatis的配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        accountDao = sqlSession.getMapper(AccountDao.class);


    }
    @After
    public void close() throws IOException {
        sqlSession.close();
        is.close();
    }
    @Test
    public void findAll() {

        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void saveAccount() {
        Account account=new Account();
        account.setName("李沁");
        account.setMoney(39999d);
        accountDao.saveAccount(account);
    }
}