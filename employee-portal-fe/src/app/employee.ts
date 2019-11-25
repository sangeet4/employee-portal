export class Employee {
    firstName: string;
    lastName: string;
    gender: string;
    dob: string;
    department: string;

    constructor(firstName, lastName, gender, dob, department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.department = department;
    }
}
