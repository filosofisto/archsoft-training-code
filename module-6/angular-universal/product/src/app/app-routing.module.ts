import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductViewComponent} from "./components/product/product-view/product-view.component";
import {LoginComponent} from "./components/login/login.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AuthGuard} from "./guard/auth.guard";

const routes: Routes = [
  {path: '', redirectTo: 'product', pathMatch: 'full'},
  {path: 'product', component: ProductViewComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    initialNavigation: 'enabled'
}), FormsModule, HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
