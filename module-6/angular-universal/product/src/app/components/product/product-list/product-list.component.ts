import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../../../model/product";
import {ConfirmNotificationService} from "../../common/confirm/confirm-notification.service";
import {ConfirmConfig} from "../../common/confirm/confirm-config";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent {

  @Input() products: Product[] = [];
  @Output() onRemove: EventEmitter<Product>;
  @Output() onEdit: EventEmitter<Product>;

  constructor(private confirmNotificationService: ConfirmNotificationService) {
    this.onRemove = new EventEmitter<Product>();
    this.onEdit = new EventEmitter<Product>();
  }

  confirmRemove(product: Product): void {
    this.confirmNotificationService.confirm(this.createConfirmConfig(product));
  }

  private createConfirmConfig(product: Product): ConfirmConfig {
    return new ConfirmConfig({
      message: `Confirm remove product ${product.name}?`,
      actionAccept: () => this.onRemove.emit(product)
    });
  }

  edit(product: Product): void {
    this.onEdit.emit(product);
  }
}
