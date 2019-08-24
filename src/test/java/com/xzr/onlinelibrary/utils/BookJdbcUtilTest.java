package com.xzr.onlinelibrary.utils;

import com.xzr.onlinelibrary.entity.Book;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import static com.xzr.onlinelibrary.utils.BookFileUtil.getBooks;

public class BookJdbcUtilTest {

    @Test
    public void selectBook() {
        try {
            Connection conn = JdbcUtil.getConnection();
            BookJdbcUtil.selectBook(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加书籍
     */
    @Test
    public void insertBook() {
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            List<Book> books = new LinkedList<>();
            getBooks(new File("E:/library/"), books);
            for (Book book : books) {
                BookJdbcUtil.insertBook(conn, book);
                //System.out.println("-----添加 :" + (i++) + " " + book.getBookName());
                System.out.println(book.getBookImgPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}