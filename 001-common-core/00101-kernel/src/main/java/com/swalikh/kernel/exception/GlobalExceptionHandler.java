package com.swalikh.kernel.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * Copyright @2019 nlelpct.
 * @author: 黄磊
 * date:  2019/9/2  14:27
 * use to：异常捕捉类
 * modify：
 */
@SuppressWarnings("all")
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
           if(exception.getResult() == null){
               return Result.build(exception.getCodeMsg().getCode(),exception.getCodeMsg().getMsg(),
                       ExceptionUtils.getFirstStackTrace(exception));//将具体错误信息设置到CodeMsg中返回
           } else {
               return exception.getResult();
           }
        }
        // 其余异常简单返回为服务器异常
        return Result.error(CodeMsg.SERVER_ERROR, ExceptionUtils.getInfo01(e));
    }
}