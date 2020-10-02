package io.github.ruoxijun.mapper;

import io.github.ruoxijun.data.User;
import io.github.ruoxijun.utils.GetSqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest01 {
    @Test
    public void test(){
//        // 主配置文件相对与resources文件夹的路径
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            // 拿到主配置文件的流。MyBatis的工具类Resources，它加载资源文件更加容易
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 利用SqlSessionFactoryBuilder通过主配置文件的流，获取SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 通过SqlSessionFactory对象拿到操作数据库的对象SqlSession
//        SqlSession sqlSession=sqlSessionFactory.openSession();
        SqlSession sqlSession = GetSqlSession.open();

        // SqlSession对象通过Mapper接口的类对象获取实例对象
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        // 调用实例方法
        List<User> userList = mapper.getUserList();

        System.out.println("---------查询所有-----------");
        for (User user : userList){
            System.out.println(user);
        }

//        System.out.println("---------条件查询-----------");
//        User user = mapper.getUserById(4);
//        System.out.println(user);
//
//        System.out.println("---------插入数据-----------");
//        // 利用获取到的接口实例调用方法，传入一个字段对象
//        int insertNum = mapper.insertUser(new User(6,"哈哈",18));
//        if (insertNum==1){
//            // 对表数据更改的操作，必须 commit 提交事务才能生效
//            sqlSession.commit();
//            System.out.println("插入成功!");
//        }
//
//        System.out.println("---------修改数据-----------");
//        int updateNum = mapper.updateUser(new User(6,"嘻嘻",20));
//        if (updateNum==1){
//            sqlSession.commit();
//            System.out.println("修改成功!");
//        }
//
//        System.out.println("---------删除数据-----------");
//        int deleteNum = mapper.deleteUser(6);
//        if (deleteNum==1){
//            sqlSession.commit();
//            System.out.println("删除成功!");
//        }

        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlsession = GetSqlSession.open();
        // 准备数据
        Map<String,Object> map = new HashMap<>();
        map.put("userId",4);
        map.put("userName","更改");
        // 获取Mapper接口实例
        UsersMapper mapper = sqlsession.getMapper(UsersMapper.class);
        // 调用方法，传入 Map
        mapper.updateUser2(map);
        // 一定要提交事务(commit)
        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void findName(){
        SqlSession sqlsession = GetSqlSession.open();
        UsersMapper mapper = sqlsession.getMapper(UsersMapper.class);
        List<User> nameList = mapper.findNameList("张");
        for (User user : nameList){
            System.out.println(user);
        }
    }
}
