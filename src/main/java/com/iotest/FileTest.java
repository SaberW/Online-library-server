package com.iotest;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author :肖钊容
 * @date :2019-07-08 19:44
 * @description :File的相关操作
 */
public class FileTest {
    public static void main(String[] args) {
        //demo1();
        //demo2();
        //demo3();
        demo4(new File(folderPath));
        //demo5(new File("C:\\Users\\admin\\Desktop\\IO"));
    }

    /**
     * 文件夹路径
     */
    private static String folderPath = "C:\\Users\\admin\\Desktop\\IO\\";

    /**
     * File 的相关操作
     */
    public static void demo1() {
        File file = new File(folderPath + "test1.txt");
        System.out.println("文件名称：" + file.getName());
        System.out.println("文件的相对路径:" + file.getPath());
        System.out.println("文件的绝对路径:" + file.getAbsolutePath());
        System.out.println("文件的父路径:" + file.getParent());
        System.out.println("文件是否可读:" + file.canRead());
        System.out.println("文件是否可写：" + file.canWrite());
        System.out.println("文件是否是一个文件：" + file.isFile());
        System.out.println("文件是否是一个文件夹：" + file.isDirectory());
        System.out.println("文件是否是一个绝对路径：" + file.isAbsolute());
        System.out.println("最后修改时间：" + file.lastModified());
        System.out.println("文件大小：" + file.length() + "bytes");
        // 删除文件
        //System.out.println("是否成功删除文件" + file.delete());
    }

    /**
     * 遍历目录下的文件
     */
    public static void demo2() {
        File file = new File(folderPath);

        // 判断目录是否存在
        if (file.isDirectory()) {
            // 获取文件名称
            String[] names = file.list();
            for (String name : names) {
                System.out.println(name);
            }
        }
    }

    /**
     * 文件过滤
     */
    public static void demo3() {
        File file = new File(folderPath);
        // 创建过滤对象
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File currFile = new File(dir, name);
                // 判断文件是否为 pdf
                if (currFile.isFile() && name.endsWith(".pdf")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        // 判断文件是否存在
        if (file.exists()) {
            String[] lists = file.list(filter);
            for (String name : lists) {
                System.out.println(name);
            }
        }
    }

    /**
     * 遍历子目录
     */
    public static void demo4(File dir) {
        // 获取目录下所有的文件和文件夹
        File[] files = dir.listFiles();
        for (File file : files) {
            // 如果是文件夹递归调用
            if (file.isDirectory()) {
                demo4(file);
            } else {
                System.out.println("文件名称：" + file.getName());
                System.out.println("文件地址：" + file.getAbsolutePath());
                System.out.println();
            }
        }
    }

    /**
     * 递归删除文件夹
     */
    public static void demo5(File dir) {
        try {
            // 判断路径是否存在
            if (dir.exists()) {
                File[] files = dir.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                        demo5(file);
                    } else {
                        // 是文件则直接删除
                        file.delete();
                    }
                }
                // 所有文件删除完之后删除目录
                dir.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
