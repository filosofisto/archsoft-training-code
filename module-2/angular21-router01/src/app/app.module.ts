import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import {ContactComponent} from './contact/contact.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AUTH_PROVIDERS} from './auth.service';
import {LoggedInGuard} from './logged-in.guard';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';
import { ProtectedComponent } from './protected/protected.component';
import { LoginComponent } from './login/login.component';
import {ProductsComponent} from './products/products.component';

import {
  routes as childRoutes,
  ProductsModule
} from './products/products.module';
import { MessageComponent } from './message/message.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'contactus', redirectTo: 'contact'},

  // authentication demo
  { path: 'login', component: LoginComponent },
  {
    path: 'protected',
    component: ProtectedComponent,
    canActivate: [ LoggedInGuard ]
  },

  // nested
  {
    path: 'products',
    component: ProductsComponent,
    children: childRoutes
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    ProtectedComponent,
    LoginComponent,
    MessageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    // added this for our child module
    ProductsModule
  ],
  providers: [
    AUTH_PROVIDERS,
    // Uncomment below line for "hash-bang" routing. The default is PathLocationStrategy (Html5)
    // { provide: LocationStrategy, useClass: HashLocationStrategy },
    LoggedInGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
