package com.example.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ApiModelProperty(notes = "First Name of Employee", required = true)
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    @ApiModelProperty(notes = "Last Name of Employee")
    private String lastName;

    @ApiModelProperty(notes = "Gender of Employee: MALE, FEMALE, OR OTHER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ApiModelProperty(notes = "D.O.B. of Employee. Should always be in format: YYYY-MM-DD")
    private LocalDate dob;

    @ApiModelProperty(notes = "Department of Employee")
    private String department;

    public Employee() { }

    public Employee(@NotBlank(message = "First Name cannot be blank") String firstName, String lastName, Gender gender, LocalDate dob, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", department='" + department + '\'' +
                '}';
    }
}
