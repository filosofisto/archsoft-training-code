import {Component, OnInit} from '@angular/core';
import {PeopleService} from '../../../services/people.service';
import {Person} from '../../../model/person';
import {MessageNotificationService} from '../../../services/message-notification.service';
import {PagerService} from '../../../services/pager.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-person-view',
  templateUrl: './person-view.component.html',
  styleUrls: ['./person-view.component.css']
})
export class PersonViewComponent implements OnInit {

  people: Person[] = [];

  constructor(private peopleService: PeopleService,
              private pagerService: PagerService,
              private messageNotificationService: MessageNotificationService) { }

  ngOnInit(): void {
    this.loadPeopleFirst();
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
        this.loadPeopleFirst();
      });
  }

  private update(person: Person): void {
    this.peopleService.update(person).subscribe(
      () => {
        this.messageNotificationService.notifySuccess('Person updated');
        this.loadPeopleFirst();
      });
  }

  remove(person: Person): void {
    this.peopleService.delete(person).subscribe(
      () => {
        this.messageNotificationService.notifyWarn(`Person ${person.name} removed successful`);
        this.loadPeopleFirst();
      });
  }

  read(person: Person): void {
    this.peopleService.read(person.id).subscribe(data => this.peopleService.notify(data));
  }

  loadPaged(page: number): void {
    this.peopleService.list(page).subscribe(
      data => {
        this.people = data['_embedded']['personTOList'];
        this.pagerService.notify(data);
      });
  }

  loadPeopleFirst(): void {
    this.loadPaged(0);
  }

  updatePagerData(data: any): void {
    this.people = data['_embedded']['personTOList'];
  }
}
