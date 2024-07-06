package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Controller
//@ResponseBody
@RestController // @Controller+@ResponseBody的写法
@RequestMapping("/books") // 简化写法，把下列接口提取出来
@EnableWebMvc
public class BookController {
    //    保存
//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String save(){
        System.out.println("保存");
        return "save";
    }
    //    删除
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete2(@PathVariable Integer id){ // PathVariable表示从路径取id参数
        System.out.println("删除："+id);
        return "delete";
    }
    //    修改
//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(){
        System.out.println("修改");
        return "update";
    }
    //    查看
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String view(@PathVariable Integer id){
        System.out.println("查看:"+id);
        return "view";
    }
}
