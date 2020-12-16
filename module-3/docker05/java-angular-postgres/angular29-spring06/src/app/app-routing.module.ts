import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PersonViewComponent} from './components/person/person-view/person-view.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {peopleServiceInjectables} from './services/people.service';

const routes: Routes = [
  {path: '', redirectTo: 'person', pathMatch: 'full'},
  {path: 'person', component: PersonViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule, HttpClientModule],
  providers: [peopleServiceInjectables],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
