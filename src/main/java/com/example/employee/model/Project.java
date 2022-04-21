package com.example.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String id;
    private String domain;
    private String name;
    private List<Skill> skill;
}
