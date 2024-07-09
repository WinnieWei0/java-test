package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration // 添加为配置类，把配置添加入主配置
public class SpringMvcSuport extends WebMvcConfigurationSupport{
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        设置访问pages下的目录时，从pages加载
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }
}
