package com.haier.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 访问项目外部的静态页面
 * @Author: luqiwei
 * @Date: 2018/7/3 17:20
 */
@Configuration
public class HryWebMvcConfiguration /*extends WebMvcConfigurerAdapter*/ {
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("../test-output/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }*/

}
