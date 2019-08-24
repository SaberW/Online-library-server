package com.xzr.onlinelibrary.utils;

import com.xzr.onlinelibrary.entity.Book;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import static com.xzr.onlinelibrary.utils.BookFileUtil.getBooks;


/**
 * @author :肖钊容
 * @version :1.0.0
 * @date :2019/7/18
 * @description :书籍与数据库的相关操作
 */
public class BookJdbcUtil extends JdbcUtil {
    public static void selectBook(Connection conn) throws Exception {
        //mysql查询语句
        String sql = "SELECT book_name FROM book";
        PreparedStatement prst = conn.prepareStatement(sql);
        //结果集
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            System.out.println("书名:" + rs.getString("book_name"));
        }
        rs.close();
        prst.close();
    }

    public static void insertBook(Connection conn,Book book) throws Exception {
        String sql = "INSERT INTO book (book_name,format,book_img_path,book_path,book_size,new_book_name)" +
                "VALUES (?,?,?,?,?,?)";

        PreparedStatement preStmt = conn.prepareStatement(sql);
        preStmt.setString(1,book.getBookName());
        preStmt.setString(2,book.getFormat());
        preStmt.setString(3,book.getBookImgPath());
        preStmt.setString(4,book.getBookPath());
        preStmt.setString(5,book.getBookSize());
        preStmt.setString(6,book.getNewBookName());
        preStmt.executeUpdate();

        if (null != preStmt){
            preStmt.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Integer i = 1;
        Connection conn = getConnection();
        List<Book> books = new LinkedList<>();
        getBooks(new File("E:/newBooks/"), books);
        for (Book book : books) {
            book.setBookPath(book.getBookPath().replaceAll("\\\\","/"));
            book.setBookName(book.getBookName().replaceAll("\\[图灵程序设计丛书\\].",""));
            book.setBookName(book.getBookName().replaceAll("\\[图灵交互设计丛书\\].",""));
            book.setBookName(book.getBookName().replaceAll("\\[图灵原创\\].",""));
            book.setBookName(book.getBookName().replaceAll("\\[异步图书\\].",""));
            book.setBookName(book.getBookName().replaceAll("\\[大家网\\]",""));
            book.setBookName(book.getBookName().replaceAll("\\[图灵图书\\]",""));
           // book.setBookName(book.getBookName().replaceAll("[ ].",""));
           // book.setBookName(book.getBookName().replaceAll("[web开发CSS系列].",""));
            insertBook(conn,book);
            System.out.println("-----添加 :"+ (i++) + " " + book.getBookName() );
        }
    }
}
