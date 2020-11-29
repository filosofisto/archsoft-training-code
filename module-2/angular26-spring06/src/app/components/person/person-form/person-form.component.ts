import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PeopleService} from '../../../services/people.service';
import {Person} from '../../../model/person';
import {MessageNotificationService} from '../../../services/message-notification.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit {

  person: Person;
  formGroup: FormGroup;
  editing = false;
  @Output() onSave: EventEmitter<Person>;
  private subscription: Subscription;

  constructor(private formBuilder: FormBuilder,
              private peopleService: PeopleService,
              private messageNotificationService: MessageNotificationService) {
    this.buildForm();
    this.onSave = new EventEmitter<Person>();
  }

  ngOnInit(): void {
    this.subscription = this.peopleService.notificationPerson.subscribe(person => {
      this.person = person;
      this.formGroup.setValue({ id: person.id, name: person.name, age: person.age });
      this.editing = true;
    });
  }

  private buildForm(): void {
    this.formGroup = this.formBuilder.group({
      id: [''],
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
    this.editing = false;

    return false;
  }
}
