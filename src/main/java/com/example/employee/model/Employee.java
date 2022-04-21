package com.example.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String empId;
    private String name;
    private Address address;
    private Salary salary;
    private Organization organization;
    private List<Project> projectsList;
}