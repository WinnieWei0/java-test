package com.itheima.service;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {
    public Boolean save(Book book);

    public Boolean update(Book book);

    public Boolean delete(Integer id);

    public Book getById(Integer id);

    public List<Book> getAll();
}
