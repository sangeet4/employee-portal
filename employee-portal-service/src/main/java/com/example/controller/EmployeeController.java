package com.example.controller;

import com.example.domain.Employee;
import com.example.exception.InvalidEmployeeException;
import com.example.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @ApiOperation(value="View all Employees' Details", response = Iterable.class)
    @GetMapping(value = "all")
    public ResponseEntity<?> getAllEmployees(){
        try{
            List<Employee> returnedList = employeeService.getAllEmployees();
            LOGGER.info(String.format("Fetched %d Employees", returnedList.size()));
            return new ResponseEntity<List<Employee>>(returnedList, HttpStatus.OK);
        } catch(Exception e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="Save Employee's Details", response = Employee.class)
    @PostMapping(value = "add")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee){
        try{
            Employee returnedEmployee = employeeService.saveEmployee(employee);
            LOGGER.info(String.format("Employee: %s saved successfully", returnedEmployee.toString()));
            return new ResponseEntity<Employee>(returnedEmployee, HttpStatus.OK);
        } catch(InvalidEmployeeException e) {
            LOGGER.warn(String.format("Employee: %s save Exception: %s", employee.toString(), e.getMessage()));
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            LOGGER.warn(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
