package com.example.repository;

import com.example.domain.Employee;
import com.example.domain.Gender;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeDaoTest {
    @Autowired
    EmployeeDao employeeDao;
    Employee employee;
    List<Employee> employeeList;

    @Before
    public void setup() {
        employee = new Employee("John", "Doe", Gender.MALE, LocalDate.now(), "CST");
    }

    @After
    public void tearDown() { }

    @Test
    public void testSave(){
        employeeDao.save(employee);
        List<Employee> returnedList = (List<Employee>) employeeDao.findAll();
        Assert.assertEquals(employee, returnedList.get(0));
    }

    @Test
    public void testFindAll(){
        employeeDao.save(employee);
        List<Employee> returnedList = (List<Employee>) employeeDao.findAll();
        Assert.assertEquals(1, returnedList.size());
        Assert.assertEquals(employee, returnedList.get(0));
    }
}
