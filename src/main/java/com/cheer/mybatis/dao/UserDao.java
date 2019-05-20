package com.cheer.mybatis.dao;

import com.cheer.mybatis.po.User;

public interface UserDao {

    public User findUserById(int id);

    public void insertUser(User user);

    public  void deleteUser(int id);
}
