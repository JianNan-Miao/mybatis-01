package com.cheer.mybatis.mapper;

import com.cheer.mybatis.po.User;

public interface UserMapper {

    public User findUserById(int id);

    public void insertUser(User user);

    public  void deleteUser(int id);
}
