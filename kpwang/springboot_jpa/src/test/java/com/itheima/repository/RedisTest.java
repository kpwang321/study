package com.itheima.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.SpringbootJpaApplication;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-12 0:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void test() throws JsonProcessingException {
        //1、从redis中获得数据 数据的形式一般为json字符串
        String jsonUserList = redisTemplate.boundValueOps("user.findAll").get();
        //2、判断redis中是否存在数据
        if (null==jsonUserList){
            //3、不存在数据 从数据库查询
            List<User> userList = userRepository.findAll();
            //将查询出的数据存储到redis中
            ObjectMapper objectMapper=new ObjectMapper();
            jsonUserList= objectMapper.writeValueAsString(userList);
            redisTemplate.boundValueOps("user.findAll").set(jsonUserList);
            System.out.println("-------从数据库中获得user的数据-------");
        }else {
            System.out.println("-------从redis缓存中获得user的数据-------");
        }
        //4、将数据在控制台打印
        System.out.println(jsonUserList);
    }
}
