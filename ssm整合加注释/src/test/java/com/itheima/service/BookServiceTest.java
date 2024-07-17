package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 指定用哪个运行器进行测试
@ContextConfiguration(classes = SpringConfig.class) //配置测试内容，指定测试业务层代码
public class BookServiceTest {
    @Autowired // 自动装配，controller和service需要装配
    private BookService bookService;

    @Test
    public void testGetBookById() {
        Book book = bookService.getBookById(1);
        System.out.println(book);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> all=bookService.getAllBooks();
        System.out.println(all);
    }
}
