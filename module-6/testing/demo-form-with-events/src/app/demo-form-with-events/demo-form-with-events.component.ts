import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-demo-form-with-events',
  templateUrl: './demo-form-with-events.component.html',
  styleUrls: ['./demo-form-with-events.component.scss']
})
export class DemoFormWithEventsComponent implements OnInit {

  myForm: FormGroup;
  sku: FormControl;

  constructor(fb: FormBuilder) {
    this.myForm = fb.group({
      'sku': ['', Validators.required]
    });

    this.sku = this.myForm.controls['sku'] as FormControl;

    this.sku.valueChanges.subscribe((value: string) => {
      console.log('sku changed to:', value)
    });

    this.myForm.valueChanges.subscribe((form: any) => {
      console.log('form changed to:', form);
    })
  }

  ngOnInit(): void {
  }

  onSubmit(form: any): void {
    console.log('you submitted value:', form.sku);
  }
}
