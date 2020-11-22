import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductsComponent } from './products.component';
import { MainComponent } from './main/main.component';
import { MoreInfoComponent } from './more-info/more-info.component';
import { ProductComponent } from './product/product.component';
import {RouterModule, Routes} from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: 'main', component: MainComponent },
  { path: 'more-info', component: MoreInfoComponent },
  { path: ':id', component: ProductComponent },
];

@NgModule({
  declarations: [ProductsComponent, MainComponent, MoreInfoComponent, ProductComponent],
  exports: [ProductsComponent, MainComponent, MoreInfoComponent, ProductComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class ProductsModule { }
