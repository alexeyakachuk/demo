package com.example.demo.user.repository;

import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;
@Repository
@Slf4j
public class UserDbRepository implements UserRepository {

    private final JdbcTemplate template;
    private final UserMapper mapper;

    public UserDbRepository(JdbcTemplate template, UserMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public User create(User user) {
        log.info("Создание пользователя: {}", user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", user.getName());
        params.addValue("surname", user.getName());
        params.addValue("age", user.getAge());
        params.addValue("email", user.getEmail());
        params.addValue("login", user.getLogin());

        template.update("INSERT INTO users1 (name, surname, age, email, login) " +
                "VALUES (:name, :surname, :age, :email, :login)", params, keyHolder);

        log.info("Пользователь {} сохранен", user);

        long userId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findUser(userId);
    }

    @Override
    public User findUser(long id) {
//        String sql = "SELECT * FROM user WHERE id = :id" ;
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", id);
//        return template.queryForObject(sql, mapper, params);

        String sql = "SELECT * FROM users1 WHERE id = ?";
        return template.queryForObject(sql, mapper, id);
    }
}
