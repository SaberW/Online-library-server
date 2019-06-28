package com.jeanswest.onlinelibrary.controller;

import com.jeanswest.onlinelibrary.entity.BookDTO;
import com.jeanswest.onlinelibrary.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :肖钊容
 * @date :2019-06-09 21:49
 * @description :书籍控制类
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(tags = "书籍相关接口")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("获取全部书籍")
    @GetMapping("books")
    public Object getBooks() {
        return bookService.getBooks();
    }

    @ApiOperation("根据id获取书籍")
    @GetMapping("book/{id}")
    public Object getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @ApiOperation("根据作者获取书籍")
    @GetMapping("book/author")
    public List<BookDTO> getBookByAuthor(@RequestParam String author) {
        return bookService.getBookByAuthor(author);
    }

    @ApiOperation("根据类别获取书籍")
    @GetMapping("book/category")
    public List<BookDTO> getBookByCategory(@RequestParam String category) {
        return bookService.getBookByCategory(category);
    }

    @ApiOperation("根据名称获取书籍")
    @GetMapping("book/bookName")
    public List<BookDTO> getBookByName(@RequestParam String bookName) {
        return bookService.getBookByName(bookName);
    }

    @ApiOperation("根据书名||类别||作者 获取书籍")
    @GetMapping("book/{bookName}/{category}/{author}")
    public List<BookDTO> getBookByNameOrCategoryOrAuthor(String bookName, String category, String author) {
        return bookService.getBookByNameOrCategoryOrAuthor(bookName, category, author);
    }

    @ApiOperation("添加书籍")
    @PostMapping("book")
    public Object saveBook(@RequestBody BookDTO book) {
        return bookService.saveBook(book);
    }

    @ApiOperation("根据ID删除书籍")
    @DeleteMapping("book/{id}")
    public Object delBookById(@ApiParam("书籍Id") @PathVariable(value = "id", required = true) Integer id) {
        return bookService.delBookById(id);
    }

    @ApiOperation("根据ID更新书籍")
    @PutMapping("book")
    public Object putBookById(@RequestBody BookDTO book) {
        return bookService.putBookById(book);
    }
}
