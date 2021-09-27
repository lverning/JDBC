package bookstore;

import java.util.List;

/**
 * @author： 吕二宁
 * @date： 2021-09-23 10:55
 */
public class Page<T> {
    private List<T> list; // 每⻚查到的记录存放的集合
    public static final int PAGE_SIZE = 4; // 每⻚显示的记录数
    private int pageNo; // 当前⻚
    private int totalPageNo; // 总⻚数，通过计算得到
    private int totalRecord; // 总记录数，通过查询数据库得到

    public Page() {
    }


    public Page(int pageNo) {
        this.pageNo = pageNo;
    }



    public Page(List<T> list, int pageNo, int totalPageNo, int totalRecord) {
        this.list = list;
        this.pageNo = pageNo;
        this.totalPageNo = totalPageNo;
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static int getPageSize() {
        return PAGE_SIZE;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
//
//    @Override
//    public String toString() {
//        return "Page{" +
//                "list=" + list +
//                ", pageNo=" + pageNo +
//                ", totalPageNo=" + totalPageNo +
//                ", totalRecord=" + totalRecord +
//                '}';
//    }
}
