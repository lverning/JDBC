package dao;

import bookstore.Books;
import bookstore.Page;

import java.sql.Connection;
import java.util.List;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 10:50
 */
public interface BookDao {
    //查看所有图书
    List<Books> getBooks(Connection conn);
    //添加图书
    void saveBooks(Connection conn, Books books);
    //根据id删除图书
    void deleteBookById(Connection conn, String bookId);
    //根据id查询图书
    Books getBookById(Connection conn, String bookId);
    //根据id更新图书
    void updateBooks(Connection conn, Books books);
    //获取带分页的图书信息
    Page<Books> getPageBooks(Connection conn, Page<Books> page);
    //获取带分⻚和价格范围的图书信息
    Page<Books> getPageBooksByPrice(Connection conn,double minPrice, double maxPrice,Page<Books> page);
}
