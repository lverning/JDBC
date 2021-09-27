package BooksTest;

import Util.HikarCP;
import Util.JDBCUtil;
import impl.BookDaoImal;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author： 吕二宁
 * @date： 2021-09-24 15:33
 */
public class DeleteBookById {
    public static void main(String[] args){
        /**
         * 删除id为1的图书
         * public void deleteBookById(Connection conn, String bookId) {
         *        String sql = "delete from book where id = ?";
         *        update(conn,sql,bookId);
         *    }
         */
        BookDaoImal bookDaoImal = new BookDaoImal();
        bookDaoImal.deleteBookById(HikarCP.getConnection(),"1");
    }
}
