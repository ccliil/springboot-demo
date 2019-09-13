package com.cdtu.service;

import com.cdtu.dao.UserDao;
import com.cdtu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> queryUserById(List<Integer> ids) {
        List<User> users = new ArrayList<>();
        if (ids != null && ids.size() > 0) {
            for (Integer id : ids) {
                User user = userDao.queryUserById(id);
                users.add(user);
            }
        }
        return users;

    }
}
