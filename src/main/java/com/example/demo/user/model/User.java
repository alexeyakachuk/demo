package com.example.demo.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class User {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surName;
    private Integer age;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String login;
}
