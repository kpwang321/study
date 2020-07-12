package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-05 15:17
 */
public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User findUserById(Integer id);
    List<User> findByName(String username);
    int findTotal();
    List<User> findUserByVo(QueryVo vo);
}
