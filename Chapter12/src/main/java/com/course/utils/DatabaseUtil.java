package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        //获取数据库连接资源配置文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        //使用类加载器加载配置文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //这个session就是能执行sql配置文件中的sql语句了
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }
}
