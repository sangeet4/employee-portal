import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { EmployeeService } from './employee.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ViewEmployeeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
