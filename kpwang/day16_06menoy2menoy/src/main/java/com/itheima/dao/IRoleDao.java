package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-06 2:44
 */
public interface IRoleDao {
    List<Role> findAll();
}
