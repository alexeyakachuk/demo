package com.example.demo.user.repository;

import com.example.demo.user.model.User;

public interface UserRepository {
    User create(User user);

    User findUser(long id);
}
