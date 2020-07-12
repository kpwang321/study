package com.itheima;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-06 17:56
 */
public class MybatisAnnoTest {
    public static void main(String[] args) throws IOException {
        //1获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2根据字节输入流构建SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //3根据SqlSessionFactory生产一个SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //4使用SqlSession获取Dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5执行Dao的方法
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //6释放资源
        sqlSession.close();
        in.close();
    }
}
