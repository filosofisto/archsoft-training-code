import { Component, OnInit } from '@angular/core';
import {Person} from '../person';

@Component({
  selector: 'app-ng-for',
  templateUrl: './ng-for.component.html',
  styleUrls: ['./ng-for.component.css']
})
export class NgForComponent implements OnInit {

  cities: string[];
  people: Person[];
  peopleByCity: Object[];

  constructor() { }

  ngOnInit(): void {
    this.cities = ['Miami', 'Sao Paulo', 'New York', 'Krakow'];
    this.people = [
      new Person('Eduardo', 49, 'Krakow'),
      new Person('Zulema', 75, 'Porto Alegre'),
      new Person('Hiago', 24, 'Brasilia'),
      new Person('Hanna', 17, 'Krakow'),
    ];
    this.peopleByCity = [
      {
        city: 'Miami',
        people: [
          { name: 'John', age: 12 },
          { name: 'Angel', age: 22 }
        ]
      },
      {
        city: 'Sao Paulo',
        people: [
          { name: 'Anderson', age: 30 },
          { name: 'Felipe', age: 36 }
        ]
      }
    ];
  }

}
