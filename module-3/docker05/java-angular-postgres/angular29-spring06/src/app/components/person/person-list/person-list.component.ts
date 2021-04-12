import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Person} from '../../../model/person';
import {ConfirmNotificationService} from '../../../services/confirm-notification.service';
import {ConfirmConfig} from '../../commun/util/confirm-config';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent {

  @Input() people: Person[] = [];
  @Output() onRemove: EventEmitter<Person>;
  @Output() onEdit: EventEmitter<Person>;

  constructor(private confirmNotificationService: ConfirmNotificationService) {
    this.onRemove = new EventEmitter<Person>();
    this.onEdit = new EventEmitter<Person>();
  }

  confirmRemove(person: Person): void {
    this.confirmNotificationService.confirm(this.createConfirmConfig(person));
  }

  private createConfirmConfig(person: Person): ConfirmConfig {
    return new ConfirmConfig({
      message: `Confirm remove person ${person.name}?`,
      actionAccept: () => this.onRemove.emit(person)
    });
  }

  edit(person: Person): void {
    this.onEdit.emit(person);
  }
}
