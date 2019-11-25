import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { NgbDatepickerModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { EmployeeService } from './employee.service';
import { RegisterComponent } from './register/register.component';

const appRoutes: Routes = [
  { path: 'employee', component: ViewEmployeeComponent },
  { path: 'employee/register', component: RegisterComponent },
  { path: '', redirectTo: '/employee', pathMatch: 'full' },
  { path: '**', redirectTo: '/employee', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ViewEmployeeComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CommonModule,
    ReactiveFormsModule,
    NgbDatepickerModule,
    FormsModule,
    RouterModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
