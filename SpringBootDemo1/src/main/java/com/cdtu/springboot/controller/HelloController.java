package com.cdtu.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody //放在类上用于将类中的所有方法返回的数据传递给浏览器
@Controller*/
@RestController //相当于前两个的联合注解
public class HelloController {
    //@ResponseBody //放在方法上用于将方法返回的数据传递给浏览器
    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello world!!！";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello" + name;
    }
}
