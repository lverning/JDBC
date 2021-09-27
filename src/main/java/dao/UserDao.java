package dao;

import bookstore.Books;
import bookstore.User;

import java.sql.Connection;
import java.util.List;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 10:51
 */
public interface UserDao {

    List<User> getUsers(Connection conn);

    User getUser(Connection conn, User user);

    boolean checkUsername(Connection conn, User user);

    void saveUser(Connection conn, User user);
}
