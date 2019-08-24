package com.xzr.onlinelibrary.utils;

import com.xzr.onlinelibrary.entity.Book;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

/**
 * @author : xzr
 * @date :2019-07-11 10:28
 * @description :
 */
public class CapturePdfFirstPageUtil {

    /**
     * 书籍存放的根路径
     */
    static final String BOOKS_ROOT_PATH = "E:\\library\\";

    /**
     * 书籍图片存放的根路径
     */
    static final String BOOK_IMGS_PATH = "E:\\library\\imgs\\";

    /**
     * 生成一本书的缩略图
     *
     * @param inputFile  需要生成缩略图的书籍的完整路径
     * @param outputFile 生成缩略图的放置路径
     * @param pageNumber 需生成第几页（从零开始）
     */
    public static void generateBookIamge(String inputFile, String outputFile, Integer pageNumber) throws Exception {
        Document document = null;
        document = new Document();
        document.setFile(inputFile);
        // maxPages = document.getPageTree().getNumberOfPages();
        File file = new File(outputFile);
        // 图片不存在 创建图片
        if (!file.exists()) {
            try {
                float rotation = 0f;
                //缩略图显示倍数，1表示不缩放，0.5表示缩小到50%
                float zoom = 1f;
                BufferedImage p_w_picpath = (BufferedImage) document.getPageImage(pageNumber, GraphicsRenderingHints.SCREEN,
                        Page.BOUNDARY_CROPBOX, rotation, zoom);

                Iterator iter = ImageIO.getImageWritersBySuffix("jpg");
                ImageWriter writer = (ImageWriter) iter.next();

                FileOutputStream out = new FileOutputStream(new File(outputFile));
                ImageOutputStream outImage = ImageIO.createImageOutputStream(out);

                writer.setOutput(outImage);
                writer.write(new IIOImage(p_w_picpath, null, null));
                System.out.println("生成新图片");
            } catch (Exception e) {
                System.out.println("生成出错" + inputFile);
            }
        }
    }

    /**
     * 生成书籍图片存放目录
     *
     * @return
     */
    public static void bookImgFileExist(Book book) throws Exception {
        File bookImgsPath = new File(CapturePdfFirstPageUtil.BOOK_IMGS_PATH + book.getBookName());
        // 如果文件目录不存在 新建目录
        if (bookImgsPath.isDirectory()) {
            System.out.println("目录不存在 创建：" + bookImgsPath);
            bookImgsPath.mkdir();
        }
    }

    public static void main(String[] args) {
        // CapturePdfFirstPageUtil.generateBookIamge(BOOKS_ROOT_PATH + "[JQuery菜鸟到忍者].Sitepoint.jQuery.Novice.to.Ninja.Feb.2010.pdf", BOOK_IMGS_PATH + "captureImage.jpg", 10);
    }
}
