import { Component, OnInit } from '@angular/core';
import {Person} from '../../../model/person';
import {PeopleService} from '../../../services/people.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  people: Person[] = [];

  constructor(private peopleService: PeopleService) { }

  ngOnInit(): void {
    this.loadPeople();
  }

  private loadPeople(): void {
    this.peopleService.list().subscribe(data => this.people = data, error => console.log(error));
  }
}
