package com.cdtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && ("123").equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";//登录成功之后进行重定向操作
        } else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
