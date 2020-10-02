package io.github.ruoxijun.mapper;

import io.github.ruoxijun.data.User;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    List<User> getUserList();
    User getUserById(int id);
    int insertUser(User user);
    int updateUser(User user);
    // key为 String，value类型不定采用 Object
    int updateUser2(Map<String,Object> map);
    int deleteUser(int id);
    List<User> findNameList(String name);
}