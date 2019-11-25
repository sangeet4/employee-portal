import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  genderAllowed = ['MALE', 'FEMALE', 'OTHERS'];
  employeeForm: FormGroup;

  constructor(private fb: FormBuilder, private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeForm = this.fb.group({
      firstName: ['', [Validators.required]],
      lastName: [''],
      gender: [''],
      dob: [],
      department: ['']
    });
  }

  get firstName() { return this.employeeForm.get('firstName'); }

  get dob() { return this.employeeForm.get('dob'); }

  onSubmit(){
    let submitEmployee = new Employee(this.employeeForm.value.firstName,
      this.employeeForm.value.lastName, this.employeeForm.value.gender.length === 0 
      ? null : this.employeeForm.value.gender,
      this.convertDateObjectToJacksonExpected(this.employeeForm.value.dob), 
      this.employeeForm.value.department);
    console.log(submitEmployee);
    this.employeeService.saveEmployee(submitEmployee)
      .subscribe(data => {
        console.log(data);
      })
    
  }

  convertDateObjectToJacksonExpected(date : any) : String{
    return date === null ? null : date.year.toString() + '-' + (date.month <= 9 ? '0' + date.month.toString() : date.month.toString())
      + '-' + (date.day <= 9 ? '0' + date.day.toString() : date.day.toString());
  }
}
