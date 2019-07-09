package com.jeanswest.onlinelibrary.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeanswest.onlinelibrary.entity.BookDTO;

import java.util.List;

public interface BookMapper{

    IPage<BookDTO> selectPageVo(Page page, String bookName);

    List<BookDTO> selectBooks();

    BookDTO selectBookById(Integer id);

    List<BookDTO> selectBookByAuthor(String author);

    List<BookDTO> selectBookByCategory(String category);

    List<BookDTO> selectBookByName(String bookName);

    Integer insertBook(BookDTO bookDTO);

    Integer updateBookById(BookDTO bookDTO);

    Integer deleteBookById(Integer id);
}
