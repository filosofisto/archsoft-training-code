import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PeopleService} from '../../../services/people.service';
import {Person} from '../../../model/person';
import {MessageNotificationService} from '../../../services/message-notification.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent {

  id: number;
  formGroup: FormGroup;
  @Output() onSave: EventEmitter<Person>;

  constructor(private formBuilder: FormBuilder,
              private peopleService: PeopleService,
              private messageNotificationService: MessageNotificationService) {
    this.buildForm();
    this.onSave = new EventEmitter<Person>();
  }

  private buildForm(): void {
    this.formGroup = this.formBuilder.group({
      name: ['', Validators.required],
      age: ['', Validators.required]
    });
  }

  save(formValue: any): void {
    if (!this.formGroup.valid) {
      this.messageNotificationService.notifyError('There are errors on form');
      return;
    }

    this.onSave.emit(new Person(formValue));

    this.clear();
  }

  clear(): boolean {
    this.formGroup.reset();

    return false;
  }
}
