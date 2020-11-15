import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

/**
 * Our custom validator
 *
 * A validator:
 * - Takes a `Control` as it's input and
 * - Returns a `StringMap<string, boolean>` where the key is "error code" and
 *   the value is `true` if it fails
 */
function skuValidator(control: FormControl): { [s: string]: boolean } {
  if (!control.value.match(/^123/)) {
    return {invalidSku: true};
  }
}

@Component({
  selector: 'app-demo-form-custom-validator',
  templateUrl: './demo-form-custom-validator.component.html',
  styleUrls: ['./demo-form-custom-validator.component.css']
})
export class DemoFormCustomValidatorComponent implements OnInit {

  formGroup: FormGroup;
  sku: AbstractControl;

  constructor(private formBuilder: FormBuilder) {
    this.formGroup = formBuilder.group({
      sku: ['', Validators.compose([Validators.required, skuValidator])]
    });
    this.sku = this.formGroup.controls.sku;
  }

  ngOnInit(): void {
  }

  onSubmit(value: any): void {
    console.log(`value: ${JSON.stringify(value)}`);
  }

}
