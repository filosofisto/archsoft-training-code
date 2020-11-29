import {Component, EventEmitter, Output} from '@angular/core';
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

    this.peopleService.create(new Person(formValue)).subscribe(
      data => {
        this.messageNotificationService.notifySuccess('Person saved');
        this.onSave.emit(data);
      },
      error => {
        this.messageNotificationService.notifyError(error.message);
      }
    );
  }
}
