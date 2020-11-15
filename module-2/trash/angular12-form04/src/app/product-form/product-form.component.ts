import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  productName: string;

  constructor() {
    this.productName = 'A Republica - Platao';
  }

  ngOnInit(): void {
  }

  onSubmit(value: string): void {
    console.log(`Submitted value: ${value}`);
  }
}
