package BooksTest;

import Util.HikarCP;
import Util.JDBCUtil;
import bookstore.Books;
import impl.BookDaoImal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * @author： 吕二宁
 * @date： 2021-09-24 16:55
 */
public class SelectBookTest {
    public static void main(String[] args){
        /**
         * 查询所有书本
         *   public List<Books> getBooks(Connection conn) {
         *             List<Books> beanList = null;
         *             String sql = "select id,title,author,price,sales,stock from book";
         *             beanList = getBeanList(conn,sql);
         *             return beanList;
         *         }
         */
        BookDaoImal bookDao = new BookDaoImal();
        List<Books> books = bookDao.getBooks(HikarCP.getConnection());
        for (Object obj : books){
            System.out.println(obj);
        }
    }
}
