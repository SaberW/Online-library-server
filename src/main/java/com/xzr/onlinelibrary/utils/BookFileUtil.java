package com.xzr.onlinelibrary.utils;

import com.xzr.onlinelibrary.entity.Book;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookFileUtil {

    //文件移动到新的路径
    private final static String NEW_FILE_PATH = "E:/newBooks/";

    //书籍图片路径
    private final static String IMG_PATH = "E:/libraryImg/imgs/";

    /**
     * 根据文件夹获取所有书籍信息
     */
    public static List<Book> getBooks(File fileRoot, List<Book> books) {
        // 获取路径下所以文件与文件夹
        File[] files = fileRoot.listFiles();
        for (File file : files) {
            // 如果是文件夹 递归调用自身
            if (file.isDirectory()) {
                getBooks(file, books);
            } else {
                Book book = new Book();
                String fileName = file.getName();
                book.setNewBookName(fileName.substring(0, fileName.lastIndexOf(".")));
                book.setBookName(fileName.substring(0, fileName.lastIndexOf(".")));
                book.setFileName(fileName);
                book.setBookPath(file.getAbsolutePath().replaceAll("\\\\", "/"));
                book.setBookSize(byteToMbOrKb(file.length()));
                book.setBookImgPath(IMG_PATH + book.getBookName());
                book.setFormat(new String(fileName.substring(fileName.lastIndexOf(".") + 1)));
                books.add(book);
            }
        }
        return books;
    }

    /**
     * 获取指定格式的书籍
     */
    public static List<Book> getBookByFormat(List<Book> books, String format) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (!book.getFormat().equals(format)) {
                it.remove();
            }
        }
        return books;
    }

    /**
     * 判断文件是否是自己想要的格式
     */
    public static Boolean formatJudge(File filePath, String format) {
        String filename = filePath.getName();
        filename.endsWith(format);
        if (filePath.isFile() && filename.endsWith("." + format)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 文件长度byte转换mb 或者Kb
     */
    public static String byteToMbOrKb(Long length) {
        Long bookSizeToMb = (length / 1024 / 1024);
        if (bookSizeToMb < 1) {
            return (length / 1024) + "K";
        }
        return bookSizeToMb + "M";
    }

    /**
     * 根据文件路径删除文件
     */
    public static Boolean delFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("删除文件：" + file.getName());
            return file.delete();
        }
        return null;
    }

    /**
     * 移动书籍
     */
    public static void moveBook(String oldPath, String newPath) {
        InputStream in = null;
        OutputStream out = null;

        try {
            // 对文件进行操作
            in = new FileInputStream(oldPath);
            out = new FileOutputStream(newPath);
            // 缓冲数组
            byte buff[] = new byte[5024];
            int len;

            // 记录移动文件 开始时间
            Long begintime = System.currentTimeMillis();
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            // 记录移动文件结束时间
            Long endtime = System.currentTimeMillis();
            System.out.println(oldPath);
            System.out.println("复制到");
            System.out.println(newPath);
            System.out.println("花费了：" + (endtime - begintime) + "毫秒");
            System.out.println("--------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 判断书籍图片是否存在 不存在则生成
     */
    public static void generateImg(Book book, Integer pageNumber) throws Exception {
        CapturePdfFirstPageUtil.bookImgFileExist(book);
        String bookPath = book.getBookPath();
        CapturePdfFirstPageUtil.generateBookIamge(bookPath, book.getBookImgPath() + "/" + pageNumber +".png", pageNumber);
    }

    public static void main(String[] args) throws IOException {
        List<Book> books = new LinkedList<>();
        getBooks(new File(NEW_FILE_PATH), books);
        for (Book book : books) {

            System.out.println(book);
        }
    }
}