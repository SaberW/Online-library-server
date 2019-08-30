package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : xzr
 * @date :2019-06-08 23:50
 * @description :线上图书馆启动类
 */
@MapperScan(value = {"com.xzr.onlinelibrary.mapper"})
@SpringBootApplication
public class OnlineLibrayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineLibrayApplication.class, args);
    }
}
