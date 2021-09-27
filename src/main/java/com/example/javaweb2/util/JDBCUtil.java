package com.example.javaweb2.util;

import java.sql.*;

/**
 * @author： 吕二宁
 * @date： 2021-09-15 09:59
 */
public class JDBCUtil {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private static String username = "root";
    private static String password = "root123";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql:///jdbc";
    public JDBCUtil() {
    }

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
             e.printStackTrace();
        }
        return conn;
    }
    public PreparedStatement ps(String sql){
        PreparedStatement ps = null;
        Connection conn = getConnection();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    public  void Close(){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    private void Close(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        Close();
    }
}
