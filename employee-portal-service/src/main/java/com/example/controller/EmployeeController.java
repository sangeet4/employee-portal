package com.example.controller;

import com.example.domain.Employee;
import com.example.exception.InvalidEmployeeException;
import com.example.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @ApiOperation(value="View all Employees' Details", response = Iterable.class)
    @GetMapping(value = "all")
    public ResponseEntity<?> getAllEmployees(){
        try{
            return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="Save Employee's Details", response = Employee.class)
    @PostMapping(value = "add")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee){
        try{
            return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
        } catch(InvalidEmployeeException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
