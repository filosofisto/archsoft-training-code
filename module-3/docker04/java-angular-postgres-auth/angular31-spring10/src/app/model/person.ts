import {Hateoas} from './hateoas';

export class Person extends Hateoas {

  public id: number;
  public name: string;
  public age: number;

  constructor(obj?: any) {
    super(obj);
    this.id   = obj && obj.id ? obj.id : null;
    this.name = obj && obj.name ? obj.name : null;
    this.age  = obj && obj.age ? obj.age : null;
  }
}
