package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 标识Restful风格表现层
@RequestMapping("/books") // 公共请求前缀
public class BookController {
    @Autowired // 自动装配，controller和service需要装配

    private BookService bookService;

    @PostMapping
    public boolean save(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
//    PathVariable解析出路径参数，如/users/{id}
    public boolean delete(@PathVariable Integer id){
        return bookService.deleteBookById(id);
    }

    @PutMapping
    public boolean update(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
