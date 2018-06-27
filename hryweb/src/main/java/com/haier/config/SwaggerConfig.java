package com.haier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: Swagger2配置
 * @Author: luqiwei
 * @Date: 2018/5/24 20:45
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig {
   /**
    *由于现在加入了登录拦截器,所以swagger文档忽略掉吧
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.haier.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("hryAuto")
                .contact(new Contact("luqiwei","","luqiwei@kjtpay.com.cn"))
                .description("很容易自动化测试平台接口文档")
                .version("1.0")
                .build();
    }*/
}
