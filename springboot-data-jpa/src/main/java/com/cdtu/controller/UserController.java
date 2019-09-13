package com.cdtu.controller;

import com.cdtu.dao.UserRepository;
import com.cdtu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @GetMapping({"/user"})
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
