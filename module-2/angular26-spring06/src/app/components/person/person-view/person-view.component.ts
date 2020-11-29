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
              private messageNotification: MessageNotificationService) { }

  ngOnInit(): void {
    this.loadPeople();
  }

  loadPeople(): void {
    this.peopleService.list().subscribe(
      data => this.people = data,
        error => this.messageNotification.notifyError(error.message));
  }

  removePerson(person: Person): void {
    this.peopleService.delete(person).subscribe(
      () => {
        this.messageNotification.notifyWarn(`Person ${person.name} removed successful`);
        this.loadPeople();
      },
      error => this.messageNotification.notifyError(error.message)
      );
  }
}
