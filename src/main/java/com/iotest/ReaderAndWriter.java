package com.iotest;

import java.io.*;

/**
 * @author :肖钊容
 * @date :2019-07-08 15:34
 * @description :字符流的相关操作
 */
public class ReaderAndWriter {
    public static void main(String[] args) {
        //demo1();
        //demo2();
        demo3();
    }

    /**
     * 文件夹路径
     */
    private static String folderPath = "C:\\Users\\admin\\Desktop\\IO\\";

    /**
     * 字符流读取数据
     */
    public static void demo1() {
        Reader reader = null;
        try {
            reader = new FileReader(folderPath + "test3.txt");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符流写入数据
     */
    public static void demo2() {
        Writer writer = null;
        try {
            // true 代表在字符串结尾追加字符
            writer = new FileWriter(folderPath + "test3.txt", true);
            writer.write("你好IO流");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用字符缓冲流对文件进行拷贝
     */
    public static void demo3() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(folderPath + "test2.txt"));
            writer = new BufferedWriter(new FileWriter(folderPath + "test3.txt"));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
                writer.write(str);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != writer) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


