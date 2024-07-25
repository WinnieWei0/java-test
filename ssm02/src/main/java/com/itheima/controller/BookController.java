package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.itheima.controller.Code.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new Result(flag?SAVE_SUCCESS:SAVE_FAILURE,flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.update(book);
        return new Result(flag?UPDATE_SUCCESS:UPDATE_FAILURE,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = bookService.delete(id);
        return new Result(flag?DELETE_SUCCESS:DELETE_FAILURE,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Book book= bookService.getById(id);
        Integer code=book!=null?GET_SUCCESS:GET_FAILURE;
        String msg=book!=null?"success":"fail";
        return new Result(code,book,msg);
    }

    @GetMapping
    public Result getAll(){
        List<Book> bookList= bookService.getAll();
        Integer code=bookList!=null?GET_SUCCESS:GET_FAILURE;
        String msg=bookList!=null?"success":"fail";
        return new Result(GET_SUCCESS,bookList,"success");
    }
}
