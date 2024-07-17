package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration  // 标识配置类
@ComponentScan("com.itheima.service") //扫描以下文件，加载相应文件
@PropertySource("jdbc.properties") // 引用jdbc配置源
@Import({JdbcConfig.class, MybaticConfig.class}) // 引入外置配置
public class SpringConfig {
}
