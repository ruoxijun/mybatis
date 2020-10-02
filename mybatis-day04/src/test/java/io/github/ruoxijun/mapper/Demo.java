package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.UserPojo;
import io.github.ruoxijun.utils.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Demo {
    @Test
    public void getUserList(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserPojo> userList = mapper.getUserList();
        for(UserPojo user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void findUserList(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserPojo> userList = mapper.findUserList("张帅", 20);
        for (UserPojo user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int add = mapper.addUser(6, "yy", 14);
        if (add==1){
            sqlSession.commit();
            System.out.println("------------数据插入成功------------");
        }
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int add = mapper.updateUser(6, "hh", 18);
        if (add==1){
            sqlSession.commit();
            System.out.println("------------数据修改成功------------");
        }
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int add = mapper.deleteUser(6);
        if (add==1){
            sqlSession.commit();
            System.out.println("------------数据删除成功------------");
        }
        sqlSession.close();
    }
}
