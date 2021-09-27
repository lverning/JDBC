import Util.JDBCUtil;
import bookstore.User;
import impl.UserDaoLmal;

import java.sql.SQLException;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 20:30
 */
public class SelectUserTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDaoLmal userDaoLmal = new UserDaoLmal();
        User user = new User("admin");//根据用户名查询用户
        System.out.println(userDaoLmal.getUser(JDBCUtil.getConnection(), user));
    }
}
