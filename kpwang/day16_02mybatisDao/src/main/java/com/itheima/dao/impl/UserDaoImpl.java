package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-05 17:16
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<User> findAll() {
        //1根据factory获取sqlsession对象
        SqlSession session = sqlSessionFactory.openSession();
        List<User> list = session.selectList("com.itheima.dao.IUserDao.findAll");
        session.close();
        return list;
    }

    public void saveUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("com.itheima.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();

    }

    public void updateUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        session.update("com.itheima.dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("com.itheima.dao.IUserDao.deleteUser",id);
        session.commit();
        session.close();
    }

    public User findUserById(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("com.itheima.dao.IUserDao.findUserById",id);
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        List<User> list = session.selectList("com.itheima.dao.IUserDao.findByName",username);
        session.close();
        return list;
    }

    public int findTotal() {
        SqlSession session = sqlSessionFactory.openSession();
        int total = session.selectOne("com.itheima.dao.IUserDao.findTotal");
        session.close();
        return total;
    }

    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }
}
