import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-demo-form',
  templateUrl: './demo-form.component.html',
  styleUrls: ['./demo-form.component.css']
})
export class DemoFormComponent implements OnInit {

  formGroup: FormGroup;
  sku: AbstractControl;

  constructor(private formBuilder: FormBuilder) {
    this.formGroup = formBuilder.group({
      sku: ['', Validators.required]
    });
    this.sku = this.formGroup.controls.sku;
  }

  ngOnInit(): void {
  }

  onSubmit(value: any): void {
    console.log(`value: ${JSON.stringify(value)}`);
  }
}
