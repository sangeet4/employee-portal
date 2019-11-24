package com.example.service;

import com.example.domain.Employee;
import com.example.domain.Gender;
import com.example.exception.InvalidEmployeeException;
import com.example.repository.EmployeeDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class EmployeeServiceTest {
    Employee employee;
    List<Employee> employeeList = null;

    @Mock
    EmployeeDao employeeDao;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        employee = new Employee("John", "Doe", Gender.MALE, LocalDate.now(),"IT");
        employeeList = new ArrayList<>();
    }

    @After
    public void tearDown(){ }

    @Test
    public void getAllEmployeeSuccess() {
        employeeList.add(employee);
        when(employeeDao.findAll()).thenReturn(employeeList);
        List<Employee> returnedEmployeeList = employeeService.getAllEmployees();
        Assert.assertEquals(employeeList, returnedEmployeeList);
        verify(employeeDao, times(1)).findAll();
    }

    @Test
    public void saveEmployee() throws InvalidEmployeeException {
        when(employeeDao.save(any())).thenReturn(employee);
        Employee returnedEmployee = employeeService.saveEmployee(employee);
        Assert.assertEquals(employee, returnedEmployee);
        verify(employeeDao, times(1)).save(employee);
    }
}
