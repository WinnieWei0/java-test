package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 标识是配置类
@ComponentScan("com.itheima.controller") // 扫描文件
public class SpringConfig {
}
