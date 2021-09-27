package BooksTest;

import Util.HikarCP;
import Util.JDBCUtil;
import bookstore.Books;
import impl.BookDaoImal;
import java.sql.SQLException;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 15:35
 */
public class InsertBookTest {
    public static void main(String[] args){
        /**
         * 添加书本
         * public void saveBooks(Connection conn, Books books) {
         *     String sql = "insert into book(id,title,author,price,sales,stock) values(?,?,?,?,?,?)";
         *     update(conn,sql,books.getId(),books.getTitle(),books.getAuthor(),books.getPrice(),books.getSales(),
         *             books.getStock());
         * }
         */
        BookDaoImal bookDao = new BookDaoImal();
        Books books = new Books("新青年","陈独秀",39.9,20,50);
        bookDao.saveBooks(HikarCP.getConnection(),books);
    }
}
