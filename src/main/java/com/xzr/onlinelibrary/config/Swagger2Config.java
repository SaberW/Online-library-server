package com.xzr.onlinelibrary.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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

            //添加请求头
            ParameterBuilder ticketPar = new ParameterBuilder();
            List<Parameter> pars = new ArrayList<Parameter>();
            //name表示名称，description表示描述
            ticketPar.name("Authorization").description("登录校验")
                    .modelRef(new ModelRef("string")).parameterType("header")
                    //required表示是否必填，defaultvalue表示默认值
                    .required(false).defaultValue("Bearer ").build();
            //添加完此处一定要把 globalOperationParameters(pars);也加上否则不生效
            pars.add(ticketPar.build());

            return new Docket(DocumentationType.SWAGGER_2)
                    .enable(swagger_is_enable)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com"))
                    .paths(PathSelectors.any())
                    .build()
                    .globalOperationParameters(pars);
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
