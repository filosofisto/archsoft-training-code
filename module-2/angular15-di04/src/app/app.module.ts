import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import {UserService} from './user.service';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    {provide: UserService, useClass: UserService},
    {provide: 'API_URL', useValue: 'http://my.api.com/v1'}
  ],
  // providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
