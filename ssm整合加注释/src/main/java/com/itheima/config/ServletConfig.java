package com.itheima.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//设置使用的配置类
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
//    原生配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
//    MVC配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
//    标识只要/链接下的路径都走这个配置类
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
