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

  // person: Person;

  constructor(private peopleService: PeopleService,
              private messageNotificationService: MessageNotificationService) { }

  ngOnInit(): void {
    this.loadPeople();
  }

  loadPeople(): void {
    this.peopleService.list().subscribe(
      data => this.people = data,
        error => this.messageNotificationService.notifyError(error.message));
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
      data => {
        this.messageNotificationService.notifySuccess('Person created');
        this.loadPeople();
      },
      error => {
        this.messageNotificationService.notifyError(error.message);
      }
    );
  }

  private update(person: Person): void {
    this.peopleService.update(person).subscribe(
      () => {
        this.messageNotificationService.notifySuccess('Person updated');
        this.loadPeople();
      },
      error => {
        this.messageNotificationService.notifyError(error.message);
      }
    );
  }

  remove(person: Person): void {
    this.peopleService.delete(person).subscribe(
      () => {
        this.messageNotificationService.notifyWarn(`Person ${person.name} removed successful`);
        this.loadPeople();
      },
      error => this.messageNotificationService.notifyError(error.message)
      );
  }

  read(person: Person): void {
    this.peopleService.read(person.id).subscribe(
      data => {
        // this.person = data;
        this.peopleService.notify(data);
      },
      error => this.messageNotificationService.notifyError(error.message)
    );
  }
}
