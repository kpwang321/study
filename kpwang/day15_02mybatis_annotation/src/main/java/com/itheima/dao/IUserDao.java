package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-04 1:24
 */
public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
