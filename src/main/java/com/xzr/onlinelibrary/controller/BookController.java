package com.xzr.onlinelibrary.controller;


import com.xzr.onlinelibrary.entity.Book;
import com.xzr.onlinelibrary.entity.ResultData;
import com.xzr.onlinelibrary.service.IBookService;
import com.xzr.onlinelibrary.service.impl.BookServiceImpl;
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
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    IBookService iBookService;
    @Autowired
    BookServiceImpl bookService;


    @GetMapping("/list")
    public List<Book> getBooks() {
        List<Book> books = iBookService.list();
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
        try{
            bookService.getBookImg(bookId, page, rp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
