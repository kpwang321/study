package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-11 21:57
 */
@Mapper
public interface UserMapper {
    List<User> queryUserList();
}
