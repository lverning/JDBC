package data0922;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author： 吕二宁
 * @date： 2021-09-22 18:03
 */
public class Util {
    private static String url;
    private static String driver;
    private static String user;
    private static String password;

    public static String getUrl() {
        return url;
    }

    public static String getDriver() {
        return driver;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static void JDBCUtil() throws IOException {
        InputStream resourceAsStream = Demo01.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        url = properties.getProperty("url");
        driver = properties.getProperty("driver");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
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
}
