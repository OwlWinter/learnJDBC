package cn.mogeek.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class InsertTest3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?characterEncoding=utf8&useSSL=true&useServerPrepStmts=false&rewriteBatchedStatements=true", "root", "mogeek666");

        //记录开始时间
        Long begin = new Date().getTime();

        // sql前缀，无需改变
        String prefix = "insert into jnshu_copy1(qq, name, object, graduated_school, brother, comefrom, daily_report, aims) values ";
        try {

            // sql 语句拼接容器
            StringBuffer suffix = new StringBuffer();

            // 关闭自动提交，打开事务
            conn.setAutoCommit(false);

            // Statement st = conn.createStatement();
            // PreparedStatement 是 Statement 的子接口，预编译的 Statement 对象，允许数据库预编译 SQL 语句，性能更好。
            PreparedStatement pst = conn.prepareStatement("");

            // 外层循环，总提交事务次数
            for (int i = 1; i <= 10000; i++) {

                // 每次拼接 10000 条需要提交的数据
                for (int j = 1; j <= 3000; j++) {
                    // 拼接 sql 字段值
                    suffix.append("('66777', '暗灭', '后端工程师', '郑州大学', '不知道', '大明湖畔', 'https://www.zhihu.com/people/ptteng/activities', '帅就完事了'),");
                }

                // 构建完整sql，去掉末尾多余的逗号
                String sql = prefix + suffix.substring(0, suffix.length() - 1);

                // 加入运行sql
                pst.addBatch(sql);

                // 运行操作
                pst.executeBatch();

                // 提交事务
                conn.commit();

                // 清空上一次加入的数据
                suffix = new StringBuffer();
            }
            // 所有数据库操作结束，关闭 PreparedStatement 与 Connection
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        Long end = new Date().getTime();

        // 打印总耗时
        System.out.println("cast : " + (end - begin) / 1000 + " s");
    }
}
