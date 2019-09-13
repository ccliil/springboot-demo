package com.cdtu.controller;

import com.cdtu.entity.User;
import com.cdtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> consumer(@RequestParam("ids") List<Integer> ids) {
        return userService.queryUserById(ids);
    }
}
