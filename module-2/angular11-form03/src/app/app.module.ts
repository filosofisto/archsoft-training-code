import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { DemoFormComponent } from './demo-form/demo-form.component';
import { DemoFormWithoutVariableComponent } from './demo-form-without-variable/demo-form-without-variable.component';
import { DemoFormCustomValidatorComponent } from './demo-form-custom-validator/demo-form-custom-validator.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoFormComponent,
    DemoFormWithoutVariableComponent,
    DemoFormCustomValidatorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
