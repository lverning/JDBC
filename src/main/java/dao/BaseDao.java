package dao;


import bookstore.Books;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 14:33
 */
public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> type;

    public BaseDao() {
        Class Clazz = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType) Clazz.getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        this.type = (Class<T>) types[0];
    }

    public int update(Connection conn, String sql, Object... params) {
        int count = 0;
        try {
            count = queryRunner.update(conn, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public T getBean(Connection conn, String sql, Object... params) {
        T t = null;
        try {
            t = queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return t;
    }

    public List<T> getBeanList(Connection conn, String sql, Object... params) {
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<>(type), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public Object getValue(Connection conn, String sql, Object... params) {
        Object count = null;
        try {
            // 调⽤queryRunner的query⽅法获取⼀个单⼀的值
            count = queryRunner.query(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
