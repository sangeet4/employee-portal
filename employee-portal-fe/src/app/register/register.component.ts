import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  genderAllowed = ['MALE', 'FEMALE', 'OTHERS'];
  employeeForm: FormGroup;

  constructor(private fb: FormBuilder, private employeeService: EmployeeService, private router: Router) { }

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
    this.employeeService.saveEmployee(submitEmployee)
      .subscribe(data => {
        if(data.firstName === submitEmployee.firstName){
          console.log("POST_SUCCESS");
          this.router.navigate(['/employee']);
        }
        else
          console.log("POST_FAILED")
      })
  }

  convertDateObjectToJacksonExpected(date : any) : String{
    return date === null ? null : date.year.toString() + '-' + (date.month <= 9 ? '0' + date.month.toString() : date.month.toString())
      + '-' + (date.day <= 9 ? '0' + date.day.toString() : date.day.toString());
  }
}
