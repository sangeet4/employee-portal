package com.example.controller;

import com.example.domain.Employee;
import com.example.exception.InvalidEmployeeException;
import com.example.service.EmployeeService;
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

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllEmployees(){
        try{
            return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
