package com.itheima.repository;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-12 0:19
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    List<User> findAll();
}
