package com.xzr.onlinelibrary.mapper;

import com.xzr.onlinelibrary.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzr
 * @since 2019-08-21
 */
public interface BookMapper extends BaseMapper<Book> {
    public List<Book> getBookByName(String bookName);
}
