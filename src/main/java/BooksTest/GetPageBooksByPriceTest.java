package BooksTest;
import Util.HikarCP;
import bookstore.Page;
import impl.BookDaoImal;
import java.util.List;
/**
 * @author： 吕二宁
 * @date： 2021-09-25 15:01
 */
public class GetPageBooksByPriceTest {
    public static void main(String[] args) {
        /**获取带分⻚和价格范围的图书信息，
         * 查询第1页书本价格在20--40区间的书本
         * Page<Books> getPageBooksByPrice
         * (Connection conn, double minPrice, double maxPrice, Page<Books> page);
         * 参数顺序与sql？顺序不符，建议将源代码此方法中的参数顺序调整，不然会运行错误
         */
        BookDaoImal bookDaoImal = new BookDaoImal();
        Page page = new Page(1);
        bookDaoImal.getPageBooksByPrice(HikarCP.getConnection(),20,40,page);
        List list = page.getList();
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
