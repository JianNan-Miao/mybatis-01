package com.cheer.mybatis.first;

import org.junit.Test;

import static org.junit.Assert.*;

public class MybatisFirstTest {

    @Test
    public void findUserByIdTest() {
        new MybatisFirst().findUserByIdTest();
    }

    @Test
    public void findUserByNameTest() {
        new MybatisFirst().findUserByNameTest();
    }

    @Test
    public void insertUserTest() {
        new MybatisFirst().insertUserTest();
    }

    @Test
    public void updateUserTest() {
        new MybatisFirst().updateUserTest();
    }

    @Test
    public void deleteUserTest() {
        new MybatisFirst().deleteUserTest();
    }
}