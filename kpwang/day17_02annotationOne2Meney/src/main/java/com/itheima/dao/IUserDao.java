package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-06 17:47
 */
public interface IUserDao {
    @Select("select *  from user ")
    @Results(id="userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts" ,column = "id" ,
                    many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findUserById(Integer id);

    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);

}
