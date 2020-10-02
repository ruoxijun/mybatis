package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.UserPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<UserPojo> getUserList();

    @Select("select * from user where name=#{name} and age=#{age}")
    List<UserPojo> findUserList(@Param("name") String name,@Param("age") int age);

    @Insert("insert into user values(#{id},#{name},#{age})")
    int addUser(@Param("id") int id,@Param("name") String name,@Param("age") int age);

    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    int updateUser(@Param("id") int id,@Param("name") String name,@Param("age") int age);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);
}