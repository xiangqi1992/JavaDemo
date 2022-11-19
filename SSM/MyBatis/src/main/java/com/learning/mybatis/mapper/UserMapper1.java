package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.User;

import java.util.List;

public interface UserMapper1 {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 删除用户信息
     */
    int deleteUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 查询用户信息
     */
    User getUserById();

    /**
     * 查询用户集合信息
     */
    List<User> getUserList();

}
