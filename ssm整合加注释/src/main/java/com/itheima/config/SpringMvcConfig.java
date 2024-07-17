package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration  // 标识配置类
@ComponentScan("com.itheima.controller") //扫描以下文件，加载相应文件
@EnableWebMvc //处理返回的JSON请求
public class SpringMvcConfig {
}
