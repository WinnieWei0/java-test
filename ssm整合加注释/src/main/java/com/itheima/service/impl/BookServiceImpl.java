package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 业务层
public class BookServiceImpl implements BookService {
    @Autowired // 自动装配，controller和service需要装配
    private BookDao bookDao; // 获取数据层类

    @Override
    public boolean saveBook(Book book) {
        bookDao.save(book);
        return true;
    }

    @Override
    public Book getBookById(Integer id) {

        return bookDao.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public boolean deleteBookById(Integer id) {
        bookDao.delete(id);
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        bookDao.update(book);
        return true;
    }
}
