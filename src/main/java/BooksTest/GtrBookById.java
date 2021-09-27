package BooksTest;

import Util.HikarCP;
import bookstore.Books;
import impl.BookDaoImal;

/**
 * @author： 吕二宁
 * @date： 2021-09-24 16:14
 */
public class GtrBookById {
    public static void main(String[] args) {
        /**
         * 根据id查询图书,查询id为2的图书信息
         *   public Books getBookById(Connection conn, String bookId) {
         *       Books books = null;
         *       String sql = "select id,title,author,price,sales,stock from book where id = ?";
         *       books = getBean(conn,sql,bookId);
         *       return books;
         *   }
         */
        BookDaoImal bookDaoImal = new BookDaoImal();
        System.out.println(bookDaoImal.getBookById(HikarCP.getConnection(), "2"));
    }
}


