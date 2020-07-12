package com.itheima.repository;

import com.itheima.SpringbootJpaApplication;
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
 * @create 2020-07-12 0:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void findAll() {
        List<User> list = userRepository.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}