package com.jeanswest.onlinelibrary.config;

import com.jeanswest.onlinelibrary.interceptor.DownloadInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :肖钊容
 * @date :2019-07-02 14:33
 * @description :拦截器配置类
 */
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DownloadInterceptor())
                .addPathPatterns("/api/DownloadRecords/","/api/book/downloadUrl/**");
    }
}
