package com.example.service;

import com.example.domain.Employee;
import com.example.exception.InvalidEmployeeException;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee saveEmployee(Employee employee) throws InvalidEmployeeException;
}
