package com.jeanswest.onlinelibrary.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author :肖钊容
 * @date :2019-06-10 11:00
 * @description :Swagger配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Configuration
    @EnableSwagger2
    public class Swagger2 {

        @Value("${swagger.is.enable}")
        private boolean swagger_is_enable;

       @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .enable(swagger_is_enable)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com"))
                    .paths(PathSelectors.any())
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("在线图书馆Api文档")
                    .description("前端界面请访问：http://localhost:8080/books")
                    .contact("肖钊容")
                    .version("1.0")
                    .build();
        }
    }
}
