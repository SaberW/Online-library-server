package com.jeanswest.onlinelibrary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeanswest.onlinelibrary.entity.BookDTO;
import com.jeanswest.onlinelibrary.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :肖钊容
 * @date :2019-06-10 14:28
 * @description :书籍业务类
 */
@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public IPage<BookDTO> selectUserPage(Page<BookDTO> page, String bookName) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return bookMapper.selectPageVo(page, bookName);
    }

    public List<BookDTO> getBooks() {
        return bookMapper.selectBooks();
    }

    public BookDTO getBookById(Integer id) {
        return bookMapper.selectBookById(id);
    }

    public List<BookDTO> getBookByAuthor(String author) {
        return bookMapper.selectBookByAuthor(author);
    }

    public List<BookDTO> getBookByCategory(String category) {
        return bookMapper.selectBookByCategory(category);
    }

    public List<BookDTO> getBookByName(String bookName) {
        return bookMapper.selectBookByName(bookName);
    }

    public List<BookDTO> getBookByNameOrCategoryOrAuthor(String bookName, String category, String author) {
        if (null != bookName) {
            return bookMapper.selectBookByName(bookName);
        } else if (null != category) {
            return bookMapper.selectBookByCategory(category);
        } else if (null != author) {
            return bookMapper.selectBookByAuthor(author);
        } else {
            return bookMapper.selectBooks();
        }
    }

    public Object saveBook(BookDTO book) {
        Integer addNumber = bookMapper.insertBook(book);
        return addNumber;
    }

    public Integer delBookById(Integer id) {
        Integer delNumber = bookMapper.deleteBookById(id);
        return delNumber;
    }

    public Integer putBookById(BookDTO book) {
        Integer putNumber = bookMapper.updateBookById(book);
        return putNumber;
    }


}
