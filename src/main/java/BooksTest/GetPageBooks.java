package BooksTest;

import Util.HikarCP;
import bookstore.Books;
import bookstore.Page;
import impl.BookDaoImal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： 吕二宁
 * @date： 2021-09-24 17:20
 */
public class GetPageBooks {
    public static void main(String[] args) {
        /**获取带分页的图书信息，每页显示4条记录
         * PAGE_SIZE = 4; // 每⻚显示的记录数
         * (第几页 - 1 ) * 每⻚显示的记录数
         * 传入一个查询第几页参数，比如查询第2页 ---> (2 - 1) * 4
         * 那么就会查询id为(5,6,7,8)的图书信息，如果查询第3页就是id为(9,10,11,12)以此类推
         */
        BookDaoImal bookDaoImal = new BookDaoImal();
        Page page = new Page(2);//查询第2页
        bookDaoImal.getPageBooks(HikarCP.getConnection(), page);
        List list = page.getList();
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
