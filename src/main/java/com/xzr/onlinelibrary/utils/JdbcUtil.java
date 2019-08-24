package com.xzr.onlinelibrary.utils;

import java.sql.*;

/**
 * @author :肖钊容
 * @version :1.0.0
 * @date :2019/7/18
 * @description :JDBC 工具
 */
public class JdbcUtil {
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/online_bookstore?useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "root";

    // 数据库连接
    private static Connection connection = null;

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() throws Exception {
        //加载mysql的驱动类
        Class.forName(DRIVER_NAME);
        //获取数据库连接
        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        return connection;
    }

    /**
     * 关闭数据库连接
     */
    public static boolean closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

