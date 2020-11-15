import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product-form-one-way',
  templateUrl: './product-form-one-way.component.html',
  styleUrls: ['./product-form-one-way.component.css']
})
export class ProductFormOneWayComponent implements OnInit {

  formGroup: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.formGroup = formBuilder.group({
      productName: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(value: any): void {
    console.log(`value: ${JSON.stringify(value)}`);
  }
}
