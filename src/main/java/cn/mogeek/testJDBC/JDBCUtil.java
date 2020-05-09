package cn.mogeek.testJDBC;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    /**
     * 连接数据库
     * @return 返回数据连接
     */
    static Connection connection = null;

    public static Connection getConnection(){
        try {
            InputStream inputstream =  JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputstream);

            String url = properties.getProperty("jdbc.url");
            String user = properties.getProperty("jdbc.user");
            String passwd = properties.getProperty("jdbc.passwd");
            String driverClass = properties.getProperty("jdbc.driverClass");

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, passwd);
        }catch (Exception e){
            System.out.println(e);
        }

        return connection;
    }

    /**
     * 释放数据库资源
     */
    public static void release()
    {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
