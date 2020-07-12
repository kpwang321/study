package com.itheima.mapper;

import com.itheima.SpringbootMybatisApplication;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kpwang
 * @create 2020-07-12 0:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void queryUserList() {
        List<User> list = userMapper.queryUserList();
        for (User user : list) {
            System.out.println(user);
        }
    }
}