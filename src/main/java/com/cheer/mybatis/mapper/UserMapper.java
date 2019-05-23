package com.cheer.mybatis.mapper;

import com.cheer.mybatis.po.Order;
import com.cheer.mybatis.po.User;
import com.cheer.mybatis.po.UserCustom;
import com.cheer.mybatis.po.UserQueryVo;

import java.util.List;

public interface UserMapper {

    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo);

    public User findUserById(int id);

    public void insertUser(User user);

    public  void deleteUser(int id);

    public List<Order>  findOrderUser();

    public List<Order>  findOrdersAndOrderDetailResultMap();

    public List<User>   findUserAndItemsResultMap();
}
