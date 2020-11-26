import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonFormComponent } from './components/person/person-form/person-form.component';
import { PersonListComponent } from './components/person/person-list/person-list.component';
import { PersonViewComponent } from './components/person/person-view/person-view.component';
import {peopleServiceInjectables} from './services/people.service';

@NgModule({
  declarations: [
    AppComponent,
    PersonFormComponent,
    PersonListComponent,
    PersonViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    peopleServiceInjectables,
    { provide: 'API_URL', useValue: 'http://localhost:8080/api/person' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
