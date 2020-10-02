package io.github.ruoxijun.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSession {
    private static SqlSessionFactory sqlSessionFactory;
    // 让类初始化就加载 SqlSessionFactory 之后就不用重复定义了
    static {
        try {
            String resources="mybatis-config.xml";
            InputStream inputstream = Resources.getResourceAsStream(resources);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 获取 SqlSession 方法
    public static SqlSession open(){
        return sqlSessionFactory.openSession();
    }
}
