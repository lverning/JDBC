package Util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author： 吕二宁
 * @date： 2021-09-24 12:44
 */
public class HikarCP {
    public static Connection getConnection(){
        HikariConfig config = new HikariConfig("/hikarid.properties");
        HikariDataSource ds = new HikariDataSource(config);
        Connection getconnection = null;
        try {
            getconnection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getconnection;
    }
}
