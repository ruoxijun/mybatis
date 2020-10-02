package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.UserPojo;
import io.github.ruoxijun.utils.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void getUsersListTest(){
        SqlSession sqlsession = GetSqlSession.open();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<UserPojo> usersList = mapper.getUsersList();
        for (UserPojo user : usersList) {
            System.out.println(user);
        }
        sqlsession.close();
    }
}
