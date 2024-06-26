package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // 标识是配置类
//@ComponentScan("com.itheima.controller") // 扫描文件
//@ComponentScan({"com.itheima.service","com.itheima.dao"}) // 扫描文件,不扫描controller的方式
//扫描文件，不扫描controller，把controller排除在外，与另外的config文件的@Configuration互斥
@EnableWebMvc // 开启json对象转换
@ComponentScan(value="com.itheima",
        excludeFilters = @ComponentScan.Filter(   // 过滤文件
                type = FilterType.ANNOTATION, // 过滤类型，默认为注解过滤
                classes = Controller.class  // 包含@Controller的注解
        )
)
public class SpringMvcConfig {
}
