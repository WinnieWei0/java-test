package com.itheima.service;

import com.itheima.domain.Book;

import java.util.List;

public interface BookService {
    public boolean saveBook(Book book);
    public Book getBookById(Integer id);
    public List<Book> getAllBooks();
    public boolean deleteBookById(Integer id);
    public boolean updateBook(Book book);
}
