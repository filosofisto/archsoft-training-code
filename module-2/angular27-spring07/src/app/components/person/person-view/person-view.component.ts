import {Component, OnInit} from '@angular/core';
import {PeopleService} from '../../../services/people.service';
import {Person} from '../../../model/person';
import {MessageNotificationService} from '../../../services/message-notification.service';
import {PagerData} from '../../commun/util/pager-data';
import {PagerService} from '../../../services/pager.service';

@Component({
  selector: 'app-person-view',
  templateUrl: './person-view.component.html',
  styleUrls: ['./person-view.component.css']
})
export class PersonViewComponent implements OnInit {

  people: Person[] = [];

  private pagerData: PagerData<Person>;

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
        this.loadPeopleFirst();
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
        this.loadPeopleFirst();
      },
      error => this.messageNotificationService.notifyError(error.message)
      );
  }

  read(person: Person): void {
    this.peopleService.read(person.id).subscribe(
      data => {
        this.peopleService.notify(data);
      },
      error => this.messageNotificationService.notifyError(error.message)
    );
  }

  loadPaged(page: number): void {
    this.peopleService.list(page).subscribe(
      data => {
        this.people = data.content;
        this.pagerData = data;
        this.pagerService.notify(data);
      },
      error => this.messageNotificationService.notifyError(error.message)
    );
  }

  loadPeopleFirst(): void {
    this.loadPaged(0);
  }

  loadPeopleBefore(): void {
    if (!this.pagerData.first) {
      this.loadPaged(this.pagerData.pageable.pageNumber - 1);
    }
  }

  loadPeopleNext(): void {
    if (!this.pagerData.last) {
      this.loadPaged(this.pagerData.pageable.pageNumber + 1);
    }
  }

  loadPeopleLast(): void {
    if (!this.pagerData.last) {
      this.loadPaged(this.pagerData.totalPages - 1);
    }
  }
}
