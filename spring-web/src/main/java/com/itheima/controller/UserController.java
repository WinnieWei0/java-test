package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller // 定义controller，定义bean
@RequestMapping("/user") // 设置请求路径前缀
public class UserController {

//    设置当前操作方位路径
    @RequestMapping("/save")
    @ResponseBody // 设置返回值为响应体
    public String save(String name,int age){
        System.out.println("user save1:"+name+','+age);
        return "{'module':'springmvc1'}";
    }

    @RequestMapping("/paramName")
    @ResponseBody
    public String paramName(@RequestParam("name") String name, int age){ // @RequestParam表示把参数name给到userName，关联name和userName之间的映射
        System.out.println("user save1:"+name+','+age);
        return "{'module':'springmvc1'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        System.out.println("user delete");
        return "{'module':'springmvc delete'}";
    }

//    pojo参数
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("user:"+user);
        return "{'module':'pojo param'}";
    }
//    嵌套pojo参数
    @RequestMapping("/pojoContainParam")
    @ResponseBody
    public String pojoContainParam(User user){
        System.out.println("user-cc:"+user);
        return "{'module':'pojo param'}";
    }

//    数组方式传参
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println(likes.toString());
        return "{'module':'array param'}";
    }

//    集合参数
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println(likes);
        return "{'module':'list param'}";
    }

//    集合参数：JSON格式
    @RequestMapping("/listParamJson")
    @ResponseBody
    public String listParamJson(@RequestBody List<String> likes){
        System.out.println(likes);
        return "{'module':'listParamsJson'}";
    }

//    日期参数,DateTimeFormat指定日期格式
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dataParam(Date date,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") Date date2){
        System.out.println("date:"+date);
        System.out.println("date1:"+date1);
        System.out.println("date2:"+date2);
        return "date";
    }
//    -------------------响应------------------------

//    响应页面、跳转页面
    @RequestMapping("/toJumpPage")
    public String toJumpPage(){
        System.out.println("跳转页面");
        return "index.jsp";
    }
//    响应字符串
    @RequestMapping("/toText")
    @ResponseBody
    public String toJText(){
        return "response text";
    }
//    响应POJO对象
    @RequestMapping("/toJsonPojo")
    @ResponseBody // 设置返回值为响应体
    public User toJsonPojo(){
        User user = new User();
        user.setName("af");
        user.setAge(11);
        return user;
    }

//    -----------------Rest风格-----------------
//    保存
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    @ResponseBody
    public String save(){
        System.out.println("保存");
        return "save";
    }
    //    删除
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete2(@PathVariable Integer id){ // PathVariable表示从路径取id参数
        System.out.println("删除："+id);
        return "delete";
    }
    //    修改
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    @ResponseBody
    public String update(){
        System.out.println("修改");
        return "update";
    }
    //    查看
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String view(@PathVariable Integer id){
        System.out.println("查看:"+id);
        return "view";
    }
}
