package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
//@RequestMapping("/book")
//@EnableWebMvc
public class BookController {

    @PostMapping("/book/update")
    public String updateBook(@RequestBody Book book) {
        System.out.println(11111);
        if(book.getId()==null||book.getId().isEmpty()){
            return "update success";
        }else{
            return "add success";
        }
    }


    @DeleteMapping("/delet")
    public String deleteBook(String id) {
        return "delete success";
    }

    @GetMapping("/list")
    public String listBook(@RequestBody Book book) {
        return "list success";
    }

    @GetMapping("/allList")
    public String listAllBook() {
        return "all list success";
    }

}
