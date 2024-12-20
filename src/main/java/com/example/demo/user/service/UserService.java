package com.example.demo.user.service;

import com.example.demo.user.model.User;

public interface UserService {
    User create(User user);

    User findUser(long id);
}
