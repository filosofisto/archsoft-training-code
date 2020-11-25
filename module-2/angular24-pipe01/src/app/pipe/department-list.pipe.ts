import { Pipe, PipeTransform } from '@angular/core';
import {Employee} from '../model/employee';
import {Department} from '../model/department';

@Pipe({
  name: 'departmentList'
})
export class DepartmentListPipe implements PipeTransform {

  transform(employeeList: Employee[]): string {
    const departments: Department[] = [];
    employeeList
      .forEach(employee => {
        if (departments.map(d => d.id).indexOf(employee.department.id) < 0) {
          departments.push(employee.department);
        }
      });

    return departments.map(department => department.name).join(' | ');
  }
}
