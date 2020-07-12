package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-06 17:47
 */
public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set address=#{address} ,username=#{username},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

    @Select("select count(1) from user")
    int totalUser();
}
