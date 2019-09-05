package com.xzr.onlinelibrary.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzr.onlinelibrary.entity.Book;
import com.xzr.onlinelibrary.mapper.BookMapper;
import com.xzr.onlinelibrary.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzr.onlinelibrary.utils.BookFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xzr
 * @since 2019-08-21
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Value("${booksPath}")
    String fileRoot;

    @Value("${booksImsPath}")
    String imgRoot;

    public IPage<Book> selectBookPage(Page<Book> page, String bookName) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return bookMapper.selectPageVo(page, bookName);
    }

    public List<Book> getBooks(){
        List <Book> books = bookMapper.getBooks();
        return books;
    }

    public List<Book> getBookByName(String bookName) {
        List<Book> books = bookMapper.getBookByName(bookName);
        return books;
    }

    public List<Book> getBookByNumber(Integer number){
        List <Book> books = bookMapper.getBooksByTopNumber(number);
        return books;
    }

    public Integer soldOutBookById(Integer bookId){
        Integer state = bookMapper.updateStatusById(-1,bookId);
        return state;
    }

    /**
     * 推荐书籍
     * @param id
     */
    public Integer recommendBookById(Integer id) {
        Integer state = bookMapper.updateStatusById(2,id);
        return state;
    }

    /**
     * 更新点击量
     * @param id
     */
    public void upClickRate(Integer id) {
        Integer state = bookMapper.upClickRateById(1,id);
    }

    public String getBookImg (Integer bookId, Integer page, HttpServletResponse rp) {
        Book book = bookMapper.selectById(bookId);
        try {
            BookFileUtil.generateImg(book,page);
        } catch (Exception e) {
            return "获取图片出错";
        }

        //String filePath = "E:\\newBooks\\imgs\\[图灵程序设计丛书].C#敏捷开发实践.jpg";
        File imageFile = new File(book.getBookImgPath() + "/" + page + ".png");
        if (imageFile.exists()) {
            FileInputStream fis = null;
            OutputStream os = null;
            try {


                fis = new FileInputStream(imageFile);
                os = rp.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    public String downloadBoot(HttpServletRequest request,
                               HttpServletResponse response, String bookId) throws UnsupportedEncodingException {
        Book book = bookMapper.selectById(bookId);


        String fileName = book.getBookName() + "." + book.getFormat(); //下载的文件名
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = fileRoot;
            File file = new File(realPath, fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                } catch (Exception e) {
                    System.out.println("Download the song failed!");
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }


}
