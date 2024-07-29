package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itheima.controller.Code.*;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    @Override
    public Boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    @Override
    public Book getById(Integer id) {
//        模拟业务异常
        if(id == 1){
            throw new BusinessException(BUSINESS_ERR,"id错误");
        }
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
//       将异常包装成自定义异常
        try {
            int i = 1 / 0;
        }catch (Exception e) {
            throw new SystemException(SYSTEM_TIMEOUT_ERR,"服务器异常，请重试",e);
        }
        return bookDao.getAll();
    }
}
