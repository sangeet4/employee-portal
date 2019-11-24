package com.example.service;

import com.example.domain.Employee;
import com.example.exception.InvalidEmployeeException;
import com.example.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) { this.employeeDao = employeeDao; }

    @Override
    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeDao.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) throws InvalidEmployeeException {
        return employeeDao.save(employee);
    }
}
