package impl;

import bookstore.Books;
import bookstore.User;
import dao.BaseDao;
import dao.UserDao;

import java.sql.Connection;
import java.util.List;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 11:01
 */
public class UserDaoLmal extends BaseDao<User> implements UserDao {

    @Override
    public List<User> getUsers(Connection conn) {
//        List<User> beanList = null;
        String sql = "select * from users";
        List<User> beanList = getBeanList(conn, sql);
        return beanList;
    }

    @Override
    public User getUser(Connection conn, User user) {
        User users = null;
        String sql = "select id,username,password,email from users where username = ? ";
        users = getBean(conn,sql,user.getUsername());
        return users;
    }

    @Override
    public boolean checkUsername(Connection conn, User user) {
        return false;
    }

//    @Override
//    public boolean checkUsername(Connection conn, User user) {
//        Books bean = null;
//        String sql = "select id,username,password,email from users where username = ?";
//        bean = getBean(conn, sql, user.getUsername());
//        return bean != null;
//    }

    @Override
    public void saveUser(Connection conn, User user) {
        //写sql语句
        String sql = "insert into users(username,password,email) values(?,?,?)";
        //调⽤BaseDao中通⽤的增删改的⽅法
        update(conn, sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}









