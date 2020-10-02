package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.UserPojo;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<UserPojo> getUserList();
    List<UserPojo> getUserLimit(Map<String,Object> map);
}
