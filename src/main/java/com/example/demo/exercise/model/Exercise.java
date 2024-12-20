package com.example.demo.exercise.model;

import com.example.demo.exercise.type.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Exercise {
    private Integer id;
    private String name;
    private Type type;
    private String description;
}
