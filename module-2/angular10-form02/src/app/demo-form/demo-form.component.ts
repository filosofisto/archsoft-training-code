import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-demo-form',
  templateUrl: './demo-form.component.html',
  styleUrls: ['./demo-form.component.css']
})
export class DemoFormComponent implements OnInit {

  formGroup: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.formGroup = formBuilder.group({
      sku: ['ABC123']
    });
  }

  ngOnInit(): void {
  }

  onSubmit(value: any): void {
    console.log(`value: ${JSON.stringify(value)}`);
  }
}
