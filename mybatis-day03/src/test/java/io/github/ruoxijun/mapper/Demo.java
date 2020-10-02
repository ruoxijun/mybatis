package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.UserPojo;
import io.github.ruoxijun.utils.GetSqlSession;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    @Test
    public void getUserList(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserPojo> userList = mapper.getUserList();
        for (UserPojo user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    // 获取日志对象(建议设置为类对象)需要当前类的class对象作为参数
    static Logger logger = Logger.getLogger(Demo.class);
    @Test
    public void testLog(){
        // 三种不同级别的日志打印方式
        logger.info("Log4j日志打印级别：info");
        logger.debug("Log4j日志打印级别：debug");
        logger.error("Log4j日志打印级别：error");
    }

    @Test
    public void getUserLimit(){
        /*Map<String,Object> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",3);

        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserPojo> userLimit = mapper.getUserLimit(map);
        for (UserPojo user : userLimit){
            logger.info(user);
        }
        sqlSession.close();*/

        RowBounds rowBounds = new RowBounds(0,3);
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        List<UserPojo> userPojoList = sqlSession
                .selectList("io.github.io.github.ruoxijun.mapper.UserMapper.getUserList",
                        null, rowBounds);
        for (UserPojo user : userPojoList) {
            logger.info("----------------");
            logger.info(user);
        }
        sqlSession.close();
    }
}
