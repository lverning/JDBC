import Util.JDBCUtil;
import bookstore.User;
import impl.UserDaoLmal;
import java.sql.SQLException;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 15:12
 */
public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDaoLmal userDao = new UserDaoLmal();
        User urse = new User("admin", "admin123", "123456@qq.com");
        userDao.saveUser(JDBCUtil.getConnection(),urse);
    }
}
