package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBConnection {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url= "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
    String user = "gcs";
    String password = "273869";

    public Connection conn;

    public DBConnection() {

        try {
            Class.forName(driver);// 加载驱动程序
            conn = DriverManager.getConnection(url, user, password);// 连续数据库
            System.out.println("数据库连接成功!");

        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
