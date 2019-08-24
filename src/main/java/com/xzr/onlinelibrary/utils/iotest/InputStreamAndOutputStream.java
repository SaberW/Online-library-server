package com.xzr.onlinelibrary.utils.iotest;


import java.io.*;

/**
 * @author :肖钊容
 * @date :2019-07-08 09:26
 * @description :字节流的相关操作
 */
public class InputStreamAndOutputStream {

    public static void main(String[] args) throws Exception {
        //demo1();
        //demo2();
        //demo3();
        //demo4();
        //demo5();
    }

    /**
     * 文件夹路径
     */
    private static String folderPath = "C:\\Users\\admin\\Desktop\\IO\\";

    /**
     * FileInputStream 读取文件
     */
    public static void demo1() {
        FileInputStream in = null;
        try {
            in = new FileInputStream(folderPath + "test1.txt");
            int b = 0;
            while (true) {
                b = in.read();
                if (b == -1) {
                    break;
                }
                System.out.println((char) b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * FileOutputStream 写入文件
     */
    public static void demo2() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(folderPath + "OutTest2.txt", true);
            String str = "你好1";
            byte[] b = str.getBytes();
            for (int i = 0; i < b.length; i++) {
                out.write(b[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件拷贝
     */
    public static void demo3() {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(folderPath + "Linux.pdf");
            out = new FileOutputStream(folderPath + "Linux2.pdf");
            int len;
            // 获取开始时间
            long begintime = System.currentTimeMillis();
            while ((len = in.read()) != -1) {
                out.write(len);
            }
            // 结束时间
            long endtime = System.currentTimeMillis();
            System.out.println("拷贝文件所消耗的时间是：" + (endtime - begintime) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
     * 带缓冲区的文件拷贝
     */
    public static void demo4() {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(folderPath + "Linux.pdf");
            out = new FileOutputStream(folderPath + "Linux3.pdf");
            byte[] buff = new byte[1024];
            int len;
            long begintime = System.currentTimeMillis();
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            long endtime = System.currentTimeMillis();
            System.out.println("拷贝文件所需要的时间是：" + (endtime - begintime) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 直接使用缓冲流实现文件复制
     */
    public static void demo5() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(folderPath + ("Linux.pdf")));
            out = new BufferedOutputStream(new FileOutputStream(folderPath + ("Linux4.pdf")));
            int len;
            long begintime = System.currentTimeMillis();
            while((len = in.read()) != -1){
                out.write(len);
            }
            long endtime = System.currentTimeMillis();
            System.out.println("复制文件消耗的时间是"+ ( endtime - begintime) + "毫秒 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
}

