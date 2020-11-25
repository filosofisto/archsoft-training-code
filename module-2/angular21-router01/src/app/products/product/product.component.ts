import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  id: string;

  constructor(private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(params => { this.id = params['id']; });
  }

}
