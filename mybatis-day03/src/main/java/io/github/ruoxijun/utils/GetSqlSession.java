package io.github.ruoxijun.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSession {
    private static SqlSessionFactory sqlsessionfactory;
    static {
        try {
            String resources= "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resources);
            sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlsessionfactory.openSession();
    }
}
