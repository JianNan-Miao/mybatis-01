package com.cheer.mybatis.first;

import com.cheer.mybatis.mapper.UserMapper;
import com.cheer.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisFirst {
    public static void main(String[] args) {
        findUserByNameTest();
    }
    /**
     * 根据id获取user信息
     */
    public  static void findUserByIdTest()  {
        //mybatis配置文件
        String rescource="SqlMapConfig.xml";
        //获取到配置文件流
        InputStream inputStream= null;
        SqlSession sqlSession=null;
        try {
            inputStream = Resources.getResourceAsStream(rescource);
            //创建会话工程
            System.out.println("------");
            SqlSessionFactory  sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            //通过工程得到SqlSession
            sqlSession= sqlSessionFactory.openSession();
            User user= sqlSession.selectOne("test.findUserById",1);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 根据用户名模糊查询用户列表
     */
    public static void findUserByNameTest(){
        String rescource="SqlMapConfig.xml";
        SqlSession sqlSession=null;
        try {
            InputStream inputStream=Resources.getResourceAsStream(rescource);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
          sqlSession= sqlSessionFactory.openSession();
          List<User> list =sqlSession.selectList("test.findUserByName","小明");
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 添加用户信息
     */

    public static void insertUserTest(){
        String rescource="SqlMapConfig.xml";
        SqlSession sqlSession=null;
        try {
            InputStream inputStream=Resources.getResourceAsStream(rescource);
            SqlSessionFactory  sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession();
            User user=new User();
            user.setUsername("李逍遥");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("江苏");
            sqlSession.insert("test.insertUser",user);
            //提交事务
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 更新用户信息
     */
    public static  void updateUserTest(){
        String  rescource="SqlMapConfig.xml";
        SqlSession sqlSession=null;
        try {
            InputStream inputStream=Resources.getResourceAsStream(rescource);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
           sqlSession= sqlSessionFactory.openSession();
           User user=new User();
           user.setId(29);
            user.setUsername("李逍遥2");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("江苏");
           sqlSession.update("test.updateUser",user);
           sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

    /**
     * 删除用户信息
     */
    public static  void deleteUserTest(){
        String  rescource="SqlMapConfig.xml";
        SqlSession sqlSession=null;
        try {
            InputStream inputStream=Resources.getResourceAsStream(rescource);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession= sqlSessionFactory.openSession();

            sqlSession.delete("test.deleteUser",29);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }


}
