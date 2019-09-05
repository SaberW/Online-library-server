package com.xzr.onlinelibrary.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzr.onlinelibrary.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xzr
 * @since 2019-08-21
 */
public interface BookMapper extends BaseMapper<Book> {
    IPage<Book> selectPageVo(Page page, String bookName);

    public List<Book> getBooks();

    public List<Book> getBookByName(@Param("bookName") String bookName);

    public List<Book> getBooksByTopNumber(@Param("number") Integer number);

    public Integer updateStatusById(@Param("status") Integer status,@Param("bookId") Integer bookId);

    public Integer upClickRateById(@Param("hist") Integer hist,@Param("id") Integer id);
}
