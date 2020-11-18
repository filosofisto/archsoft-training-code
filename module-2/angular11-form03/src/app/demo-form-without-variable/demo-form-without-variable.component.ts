import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-demo-form-without-variable',
  templateUrl: './demo-form-without-variable.component.html',
  styleUrls: ['./demo-form-without-variable.component.css']
})
export class DemoFormWithoutVariableComponent implements OnInit {

  formGroup: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.formGroup = formBuilder.group({
      sku: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(value: any): void {
    console.log(`value: ${JSON.stringify(value)}`);
  }

  checkControl(controlName): boolean {
    return !this.formGroup.controls[controlName].valid
      && this.formGroup.controls[controlName].touched;
  }
}
