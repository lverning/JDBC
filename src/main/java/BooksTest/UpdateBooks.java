package BooksTest;

import Util.HikarCP;
import bookstore.Books;
import impl.BookDaoImal;

/**
 * @author： 吕二宁
 * @date： 2021-09-24 15:52
 */
public class UpdateBooks {
    public static void main(String[] args) {
        /**
         * 根据id更新书本
         * public void updateBooks(Connection conn, Books books) {
         *     String sql = "update book set title = '西游记' , author = '吴承恩' , price = 30.0 , sales = 20  , stock = 30 where id = ?";
         *     update(conn,sql,books.getId());
         * }
         */
        BookDaoImal bookDaoImal = new BookDaoImal();
        Books books = new Books(2);
        bookDaoImal.updateBooks(HikarCP.getConnection(), books);
    }
}
