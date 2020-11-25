import {Department} from './department';

export class Employee {

  constructor(public name: string, public department: Department, public startAt: Date) { }
}
