import { Component } from '@angular/core';
import {Employee} from './model/employee';
import {Department} from './model/department';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'angular24-pipe01';
  employeeList: Employee[];

  constructor() {
    const it = new Department(1, 'TI');
    const fi = new Department(2, 'Finance');
    const mt = new Department(3, 'Medicina do Trabalho');
    const ad = new Department(4, 'Admin');
    const today = new Date();

    this.employeeList = [
      new Employee('Eduardo', it, today),
      new Employee('Joao Paulo', fi, today),
      new Employee('Carlos Chagas', mt, today),
      new Employee('Jose de Souza', it, today),
      new Employee('Geovana Bernoulli', fi, today),
      new Employee('Hanna Silva', mt, today),
      new Employee('Hiago', ad, today),
      new Employee('Francisco Bitencourt', ad, today),
    ];
  }
}
