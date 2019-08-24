package com.xzr.onlinelibrary.utils;

import com.xzr.onlinelibrary.entity.Book;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookFileUtilTest {

    @Test
    public void getBooks() {
        File filePath = new File("E:/电子书/书籍资料 2019-3-10 - 副本");
        List<Book> books = new ArrayList<>();

        BookFileUtil.getBooks(filePath,books);

        for (int i = 0 ; i < books.size() ; i++) {
            System.out.println(i + ": " + books.get(i).getBookName() + " " + books.get(i).getFileName());
        }
    }
    
    @Test
    public void generateImg(){
        File filePath = new File("E://library");
        List<Book> books = new ArrayList<>();
        // 过滤前的书籍数
        books = BookFileUtil.getBooks(filePath,books);
        System.out.println(books.size());

        // 过滤后的书籍书数
        books = BookFileUtil.getBookByFormat(books,"pdf");
        for (Book book : books) {
            try {
                BookFileUtil.generateImg(book,8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    @Test
    public void getBookByFormat(){
        File filePath = new File("E:/电子书/书籍资料 2019-3-10 - 副本");
        List<Book> books = new ArrayList<>();
        // 过滤前的书籍数
        books = BookFileUtil.getBooks(filePath,books);
        System.out.println(books.size());

        // 过滤后的书籍书数
        books = BookFileUtil.getBookByFormat(books,"pdf");
        System.out.println(books);
    }
    @Test
    public void formatJudge() {

    }

    @Test
    public void byteToMbOrKb() {
    }

    @Test
    public void delFile() {
    }

    @Test
    public void moveBook() {
        File filePath = new File("E:/电子书/书籍资料 2019-3-10 - 副本");
        File newBookPath = new File("E:/library");
        List<Book> books = new ArrayList<>();
        books = BookFileUtil.getBooks(filePath,books);
        books = BookFileUtil.getBookByFormat(books,"pdf");
        for (Book book : books) {
            BookFileUtil.moveBook(book.getBookPath(),newBookPath + "/" +book.getFileName());
        }
    }
}