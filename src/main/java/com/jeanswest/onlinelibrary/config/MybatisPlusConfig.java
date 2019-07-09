package com.jeanswest.onlinelibrary.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author :肖钊容
 * @date :2019-07-09 11:24
 * @description :mybatis plus 分页配置
 */
@MapperScan(value = {"com.jeanswest.onlinelibrary.mapper","com.demo.mapper"})
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
