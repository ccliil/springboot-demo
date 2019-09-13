package com.cdtu.controller;

import com.cdtu.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自适应响应效果处理且可以带上我们自定义的字段传至页面
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", 500);//只有传入了我们的状态码才会进入定制错误页面的流程，自定义字段才会被传至页面
        map.put("code", "user.notexit");
        map.put("message", e.getMessage());
        return "forward:/error";//达到自适应的效果的关键
    }
}
