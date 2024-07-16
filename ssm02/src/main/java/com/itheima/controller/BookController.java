package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired

    private BookService bookService;

    @PostMapping
    public boolean save(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
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
