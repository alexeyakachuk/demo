package com.example.demo.user.mapper;

import com.example.demo.user.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .surName(resultSet.getString("surname"))
                .age(resultSet.getInt("age"))
                .email(resultSet.getString("email"))
                .login(resultSet.getString("login"))
                .build();
    }
}
