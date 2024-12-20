package com.example.demo.trainingProgram.model;

import com.example.demo.exercise.model.Exercise;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Program {
    private Integer id;
    private Map<Integer, Exercise> program;
}
