import { Component, OnInit } from '@angular/core';
import {PeopleService} from '../../../services/people.service';
import {Person} from '../../../model/person';
import {MessageNotificationService} from '../../../services/message-notification.service';

@Component({
  selector: 'app-person-view',
  templateUrl: './person-view.component.html',
  styleUrls: ['./person-view.component.css']
})
export class PersonViewComponent implements OnInit {

  people: Person[] = [];

  constructor(private peopleService: PeopleService,
              private messageNotificationService: MessageNotificationService) { }

  ngOnInit(): void {
    this.loadPeople();
  }

  loadPeople(): void {
    this.peopleService.list().subscribe(data => this.people = data);
  }

  save(person: Person): void {
    if (person.id) {
      this.update(person);
    } else {
      this.create(person);
    }
  }

  private create(person: Person): void {
    this.peopleService.create(person).subscribe(
      () => {
        this.messageNotificationService.notifySuccess('Person created');
        this.loadPeople();
      }
    );
  }

  private update(person: Person): void {
    this.peopleService.update(person).subscribe(
      () => {
        this.messageNotificationService.notifySuccess('Person updated');
        this.loadPeople();
      }
    );
  }

  remove(person: Person): void {
    this.peopleService.delete(person).subscribe(
      () => {
        this.messageNotificationService.notifyWarn(`Person ${person.name} removed successful`);
        this.loadPeople();
      });
  }

  read(person: Person): void {
    this.peopleService.read(person.id).subscribe(data => this.peopleService.notify(data));
  }
}
