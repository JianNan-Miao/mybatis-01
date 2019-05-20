package com.cheer.mybatis.dao;

import com.cheer.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements  UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
       User user= sqlSession.selectOne("test.findUserById",id);
       sqlSession.close();
        return user;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void deleteUser(int id) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();

    }
}
