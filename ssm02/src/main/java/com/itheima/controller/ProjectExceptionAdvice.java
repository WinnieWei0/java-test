package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.itheima.controller.Code.SYSTEM_UNKNOWN_ERR;

@RestControllerAdvice // Rest风格异常通知，非Rest用ControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class) // 标识拦截异常种类，Exception所有异常
    public Result doSystemException(SystemException ex){
//        记录日志
//        发送消息给运维
//        发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class) // 标识拦截异常种类，Exception所有异常
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(Exception.class) // 标识拦截异常种类，Exception所有异常
    public Result doException(Exception ex){
        System.out.printf("异常：",ex.getMessage());
        return new Result(SYSTEM_UNKNOWN_ERR,null,"系统繁忙");
    }
}
