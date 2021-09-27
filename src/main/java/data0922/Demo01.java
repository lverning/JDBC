package data0922;

import java.io.IOException;
import java.sql.*;

/**
 * @author： 吕二宁
 * @date： 2021-09-22 17:37
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Util.JDBCUtil();
        Class.forName(Util.getDriver());
        Connection connection = DriverManager.getConnection(Util.getUrl(), Util.getUser(), Util.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement("select * from book");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(
                            resultSet.getInt(1) + " " +
                            resultSet.getString(2) + " " +
                            resultSet.getString(3) + " " +
                            resultSet.getDouble(4));
        }
        Util.close(connection, preparedStatement, resultSet);
    }
}
