import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.scss']
})
export class ViewEmployeeComponent implements OnInit {

  employees: [Employee];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeService.getAllEmployee()
      .subscribe(data => {
        this.employees = data.sort((e1, e2) => {
          if(e1.firstName.toLowerCase() > e2.firstName.toLowerCase())
            return 1;
          else if(e1.firstName.toLowerCase() < e2.firstName.toLowerCase())
            return -1;
          else
            return 0;
        });
      });
  }

  // sortEmployee(data : [Employee]) : [Employee]{
  //   let sortedData = data.sort
  //   return 
  // }

}
