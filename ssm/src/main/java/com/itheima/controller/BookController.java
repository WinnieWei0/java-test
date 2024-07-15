package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
//@EnableWebMvc
public class BookController {
    @PostMapping
    public String save(Book book){
        System.out.println("book save:"+book);
        return "save";
    }

    @GetMapping
    public List<Book> getAll(){
        List<Book> bookList=new ArrayList<Book>();

        Book book1=new Book();
        book1.setType("计算机");
        book1.setName("SpringMVC入门");
        book1.setDescription("小试牛刀");
        bookList.add(book1);

        Book book2=new Book();
        book2.setType("计算机3");
        book2.setName("SpringMVC入门3");
        book2.setDescription("小试牛刀3");
        bookList.add(book2);

        return bookList;
    }
}
