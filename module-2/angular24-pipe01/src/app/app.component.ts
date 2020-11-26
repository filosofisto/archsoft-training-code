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
      new Employee('Eduardo', it, today, 15000, 0.9),
      new Employee('Joao Paulo', fi, today, 25000, 1.0),
      new Employee('Carlos Chagas', mt, today, 180000, 0.92),
      new Employee('Jose de Souza', it, today, 1500, 0.7),
      new Employee('Geovana Bernoulli', fi, today, 30000, 0.77),
      new Employee('Hanna Silva', mt, today, 48000, 0.99),
      new Employee('Hiago', ad, today, 32000, 0.99),
      new Employee('Francisco Bitencourt', ad, today, 12000, 0.91),
    ];
  }
}
