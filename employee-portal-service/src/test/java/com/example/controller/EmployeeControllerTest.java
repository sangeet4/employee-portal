package com.example.controller;

import com.example.domain.Employee;
import com.example.domain.EmployeeRequest;
import com.example.domain.Gender;
import com.example.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Employee employee;
    private EmployeeRequest employeeRequest;
    private List<Employee> employeeList = null;

    @MockBean
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        employee = new Employee("Jack", "Ryan", Gender.MALE, LocalDate.now(), "ETC");
        employeeRequest = new EmployeeRequest("Jack", "Ryan", Gender.MALE.toString(), LocalDate.now().toString(), "ETC");
        employeeList = new ArrayList<>();
    }

    @After
    public void tearDown(){ }

    @Test
    public void getAllEmployeesTest() throws Exception {
        employeeList.add(employee);
        when(employeeService.getAllEmployees()).thenReturn(employeeList);
        mockMvc.perform(MockMvcRequestBuilders.get("/employee/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void saveEmployeeTest() throws Exception {
        when(employeeService.saveEmployee(any())).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/add")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employeeRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
