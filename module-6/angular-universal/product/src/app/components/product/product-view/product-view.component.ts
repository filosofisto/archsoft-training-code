import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product";
import {ProductService} from "../../../services/product.service";
import {MessageNotificationService} from "../../common/message/message-notification.service";

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.scss']
})
export class ProductViewComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService: ProductService,
              private messageNotificationService: MessageNotificationService) {
  }

  ngOnInit(): void {
    this.list();
  }

  save(product: Product): void {
    if (product.id) {
      this.update(product);
    } else {
      this.create(product);
    }
  }

  private create(product: Product): void {
    this.productService.create(product).subscribe(
      () => {
        this.messageNotificationService.notifySuccess('Product created');
        this.list();
      });
  }

  private update(product: Product): void {
    this.productService.update(product).subscribe(
      () => {
        this.messageNotificationService.notifySuccess('Product updated');
        this.list();
      });
  }

  remove(product: Product): void {
    this.productService.delete(product).subscribe(
      () => {
        this.messageNotificationService.notifyWarn(`Product ${product.name} removed successful`);
        this.list();
      });
  }

  read(product: Product): void {
    this.productService.read(product.id).subscribe(data => this.productService.notify(data));
  }

  list(): void {
    this.productService.list().subscribe(
      data => {
        if (data) {
          // @ts-ignore
          this.products = data;
        }
      });
  }
}
