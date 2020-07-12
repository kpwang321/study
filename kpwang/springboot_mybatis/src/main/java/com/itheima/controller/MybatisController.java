package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-11 22:02
 */
@RestController
public class MybatisController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/quick")
    public List<User> queryUserList(){
         return userMapper.queryUserList();
    }
}
