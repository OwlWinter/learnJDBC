package cn.mogeek.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class DBTools {
    public static SqlSession getSqlSession(){
        SqlSessionFactory sessionFactory;
        InputStream inputStream;
        inputStream = DBTools.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sessionFactory.openSession();
    }
}
