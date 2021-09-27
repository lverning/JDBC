package impl;

import bookstore.Books;
import bookstore.Page;
import dao.BaseDao;
import dao.BookDao;

import java.sql.Connection;
import java.util.List;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 15:31
 */
public class BookDaoImal extends BaseDao<Books> implements BookDao {
    @Override
    public List<Books> getBooks(Connection conn) {
            List<Books> beanList = null;
            String sql = "select id,title,author,price,sales,stock from book";
            beanList = getBeanList(conn,sql);
            return beanList;
        }

    @Override
    public void saveBooks(Connection conn, Books books) {
        String sql = "insert into book(id,title,author,price,sales,stock) values(?,?,?,?,?,?)";
        update(conn,sql,books.getId(),books.getTitle(),books.getAuthor(),books.getPrice(),books.getSales(),
                books.getStock());
    }
    @Override
    public void deleteBookById(Connection conn, String bookId) {
        String sql = "delete from book where id = ?";
        update(conn,sql,bookId);
    }
    @Override
    public Books getBookById(Connection conn, String bookId) {
        Books books = null;
        String sql = "select id,title,author,price,sales,stock from book where id = ?";
        books = getBean(conn,sql,bookId);
        return books;
    }
    @Override
    public void updateBooks(Connection conn, Books books) {
        String sql = "update book set title = '西游记' , author = '吴承恩' , price = 30.0 , sales = 20  , stock = 30 where id = ?";
        update(conn,sql,books.getId());
    }
    @Override
    public Page<Books> getPageBooks(Connection conn, Page<Books> page) {
        // 获取数据库中图书的总记录数
        String sql = "select count(*) from book";
        // 调⽤BaseDao中获取⼀个单⼀值的⽅法
        long totalRecord = (long) getValue(conn,sql);
        // 将总记录数设置都page对象中
        page.setTotalRecord((int) totalRecord);
//         获取当前⻚中的记录存放的List
        String sql2 = "select id,title,author,price,sales,stock from book limit ?,?";
        // 调⽤BaseDao中获取⼀个集合的⽅法
        List<Books> beanList = getBeanList(conn,sql2,  (page.getPageNo() - 1) *
                Page.PAGE_SIZE, Page.PAGE_SIZE);//4
        // 将这个List设置到page对象中
        page.setList(beanList);
        return page;
    }
    @Override
    public Page<Books> getPageBooksByPrice(Connection conn,double minPrice,double maxPrice, Page<Books> page) {
        // 获取数据库中图书的总记录数
        String sql = "select count(*) from book where price between ? and ?";
        // 调⽤BaseDao中获取⼀个单⼀值的⽅法
        long totalRecord = (long) getValue(conn,sql,minPrice,maxPrice);
        // 将总记录数设置都page对象中
        page.setTotalRecord((int) totalRecord);
        // 获取当前⻚中的记录存放的List
        String sql2 = "select id,title,author,price,sales,stock from book where price between ? and ? group by id asc , price asc limit ?,?";
        // 调⽤BaseDao中获取⼀个集合的⽅法
        List<Books> beanList = getBeanList(conn,sql2, minPrice , maxPrice ,
                (page.getPageNo() - 1) * Page.PAGE_SIZE, Page.PAGE_SIZE);
        // 将这个List设置到page对象中
        page.setList(beanList);
        return page;
    }
}
