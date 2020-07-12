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
    User findUserById(Integer id);
    List<User> findByName(String username);
    List<User> findUserByVo(QueryVo vo);
    List<User> findUserByCondition(User user);
    List<User> findUserInIds(QueryVo vo);
}
