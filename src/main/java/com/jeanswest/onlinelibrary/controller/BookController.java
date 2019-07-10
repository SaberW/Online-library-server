package com.jeanswest.onlinelibrary.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeanswest.onlinelibrary.entity.BookDTO;
import com.jeanswest.onlinelibrary.entity.ResultData;
import com.jeanswest.onlinelibrary.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :肖钊容
 * @date :2019-06-09 21:49
 * @description :书籍控制类
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book/")
@Api(tags = "书籍相关接口")
public class BookController {

    @Autowired
    private BookService bookService;


    @Value("${downloadUrl}")
    private String downloadPath ;

    @ApiOperation("书籍下载")
    @GetMapping("downloadUrl/{id}")
    public ResultData downloadUrl(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
           String downloadUrl = downloadPath+ "/api/book/download/" +id;
            return ResultData.success("请求成功",downloadUrl);
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("书籍下载")
    @GetMapping("download/{id}")
    public ResponseEntity<InputStreamResource> downloadBook(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return bookService.downloadBook(id,request,response);
    }

    @ApiOperation("分页获取书籍")
    @GetMapping("paging/{current}")
    public ResultData getBooksPaging(@PathVariable Integer current) {
        try {
            if (null == current) {
                current = 1;
            }
            Page<BookDTO> page = new Page<BookDTO>(current, 10);
            return ResultData.success("请求成功", bookService.selectUserPage(page, null));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据名字获取书籍带分页")
    @GetMapping("{bookName}/paging/{current}")
    public ResultData getBooksByBookNamePaging(@PathVariable("bookName") String bookName, @PathVariable("current") Integer current) {
        try {
            if (null == current) {
                current = 1;
            }
            Page<BookDTO> page = new Page<BookDTO>(current, 10);
            return ResultData.success("请求成功", bookService.selectUserPage(page, bookName));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("获取全部书籍")
    @GetMapping("list")
    public ResultData getBooks() {
        try {
            return ResultData.success("请求成功", bookService.getBooks());
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据id获取书籍")
    @GetMapping("{id}")
    public ResultData getBookById(@PathVariable Integer id) {
        try {
            return ResultData.success("请求成功", bookService.getBookById(id));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据作者获取书籍")
    @GetMapping("author")
    public ResultData getBookByAuthor(@RequestParam String author) {
        try {
            return ResultData.success("请求成功", bookService.getBookByAuthor(author));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据类别获取书籍")
    @GetMapping("category")
    public ResultData getBookByCategory(@RequestParam String category) {
        try {
            return ResultData.success("请求成功", bookService.getBookByCategory(category));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据名称获取书籍")
    @GetMapping("bookName")
    public ResultData getBookByName(@RequestParam String bookName) {

        try {
            return ResultData.success("请求成功", bookService.getBookByName(bookName));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据书名||类别||作者 获取书籍")
    @GetMapping("{bookName}/{category}/{author}")
    public ResultData getBookByNameOrCategoryOrAuthor(String bookName, String category, String author) {
        try {
            return ResultData.success("请求成功", bookService.getBookByNameOrCategoryOrAuthor(bookName, category, author));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("添加书籍")
    @PostMapping("")
    public ResultData saveBook(@RequestBody BookDTO book) {
        try {
            return ResultData.success("请求成功", bookService.saveBook(book));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据ID删除书籍")
    @DeleteMapping("{id}")
    public ResultData delBookById(@ApiParam("书籍Id") @PathVariable(value = "id", required = true) Integer id) {
        try {
            return ResultData.success("请求成功", bookService.delBookById(id));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据ID更新书籍")
    @PutMapping("")
    public ResultData putBookById(@RequestBody BookDTO book) {
        try {
            return ResultData.success("请求成功", bookService.putBookById(book));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }
}
