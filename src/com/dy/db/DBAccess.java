package com.dy.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/*
* 这个是一个专门连接数据库的类
* */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        //通过配置文件获得数据库连接信息
//        String resource = "com/dy/config/Configuration.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
      Reader reader=Resources.getResourceAsReader("com/dy/config/Configuration.xml");
        //通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //通过sqlSessionFactory打开一个数据库会话
        SqlSession sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }

}
