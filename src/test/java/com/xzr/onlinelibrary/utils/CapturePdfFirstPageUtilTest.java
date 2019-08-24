package com.xzr.onlinelibrary.utils;

import com.xzr.onlinelibrary.entity.Book;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CapturePdfFirstPageUtilTest {

    /**
     * 生成书籍图片
     */
    @Test
    public void generateBookIamge() {
        File filePath = new File("E:/电子书/书籍资料 2019-3-10 - 副本");
        List<Book> books = new ArrayList<>();
        // 过滤前的书籍数
        books = BookFileUtil.getBooks(filePath, books);

        // 过滤后的书籍书数
        books = BookFileUtil.getBookByFormat(books, "pdf");

        for (Book book : books) {
            try {
                String bookPath = book.getBookPath();
                String imgPath =  book.getBookImgPath() ;
                CapturePdfFirstPageUtil.generateBookIamge(bookPath, imgPath + "/" + 10 + ".png" , 10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成书籍图片路径
     */
    @Test
    public void bookImgFileExist() {
        File filePath = new File("E:/电子书/书籍资料 2019-3-10 - 副本");
        List<Book> books = new ArrayList<>();
        // 过滤前的书籍数
        books = BookFileUtil.getBooks(filePath,books);
        // 过滤后的书籍书数
        books = BookFileUtil.getBookByFormat(books,"pdf");

        for (int i = 0 ; i < books.size() ; i++) {
            try {
          //      System.out.println(CapturePdfFirstPageUtil.bookImgFileExist(books.get(i)));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}