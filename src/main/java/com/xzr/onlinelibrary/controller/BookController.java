package com.xzr.onlinelibrary.controller;


import com.xzr.onlinelibrary.entity.Book;
import com.xzr.onlinelibrary.entity.ResultData;
import com.xzr.onlinelibrary.service.IBookService;
import com.xzr.onlinelibrary.service.impl.BookServiceImpl;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xzr
 * @since 2019-08-21
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    IBookService iBookService;
    @Autowired
    BookServiceImpl bookService;


    @GetMapping("/list")
    public List<Book> getBooks() {
        List<Book> books = bookService.getBooks();
        return books;
    }

    @GetMapping("/top/{number}")
    public List<Book> BookByTopNumber(@PathVariable("number") Integer number) {
        List<Book> books = bookService.getBookByNumber(number);
        return books;
    }

    @GetMapping("/download/{bookId}")
    public String downloadBoot(
            @PathVariable("bookId") String bookId,
            HttpServletRequest request,
            HttpServletResponse response) throws UnsupportedEncodingException {
        return bookService.downloadBoot(request, response, bookId);
    }

    @GetMapping("/{bookName}")
    public List<Book> getBookByName(@PathVariable("bookName") String bookName) {
        List<Book> books = bookService.getBookByName(bookName);
        return books;
    }

    @GetMapping("/{bookId}/image/{page}")
    public void getBookImg(
            @PathVariable("bookId") Integer bookId,
            @PathVariable("page") Integer page,
            HttpServletResponse rp) {
        try {
            System.out.println("获取图片");
            bookService.getBookImg(bookId, page, rp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下架书籍
     * @param bookId
     */
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId){
       bookService.soldOutBookById(bookId);
    }

    /**
     * 推荐书籍
     * @param book
     */
    @PutMapping("/recommend")
    public void recommendBook(@RequestBody Book book){
        bookService.recommendBookById(book.getId());
    }

    /**
     * 更新点击量
     * @param book
     */
    @PutMapping("/click")
    public void upClickRate(@RequestBody Book book){
        bookService.upClickRate(book.getId());
    }
}
