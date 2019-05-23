package com.cheer.mybatis.mapper;

import com.cheer.mybatis.po.Order;
import com.cheer.mybatis.po.User;
import com.cheer.mybatis.po.UserCustom;
import com.cheer.mybatis.po.UserQueryVo;
import com.cheer.mybatis.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    @Test
    public void findUserList(){
        SqlSession session= MybatisUtils.getSqlSession();
        UserMapper mapper=  session.getMapper(UserMapper.class);
        System.out.println("123");
        UserCustom userCustom=new UserCustom();
        UserQueryVo userQueryVo=new UserQueryVo();
        userCustom.setSex("1");
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);
        List<UserCustom> list=mapper.findUserList(userQueryVo);
        System.out.println(list);
       MybatisUtils.closeSqlSession(session);

    }

    @Test
    public void findOrderUser(){
        SqlSession session= MybatisUtils.getSqlSession();
        UserMapper mapper=  session.getMapper(UserMapper.class);
       List<Order> list= mapper.findOrderUser();
        System.out.println(list);
        MybatisUtils.closeSqlSession(session);
    }

    @Test
    public void findOrdersAndOrderDetailResultMap(){
        SqlSession session= MybatisUtils.getSqlSession();
        UserMapper mapper=  session.getMapper(UserMapper.class);
       List<Order> list= mapper.findOrdersAndOrderDetailResultMap();
        System.out.println(list);
        MybatisUtils.closeSqlSession(session);
    }

    @Test
    public void findUserAndItemsResultMap(){
        SqlSession session= MybatisUtils.getSqlSession();
        UserMapper mapper=  session.getMapper(UserMapper.class);
       List<User> userList= mapper.findUserAndItemsResultMap();
        System.out.println(userList);

    }



}