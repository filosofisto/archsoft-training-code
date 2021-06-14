import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Product} from "../../../model/product";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MessageNotificationService} from "../../common/message/message-notification.service";
import {ProductService} from "../../../services/product.service";
import {Subscription} from "rxjs";
import {Meta, Title} from "@angular/platform-browser";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {

  // @ts-ignore
  product: Product;
  // @ts-ignore
  formGroup: FormGroup;
  editing = false;
  @Output() onSave: EventEmitter<Product>;
  private subscription: Subscription | undefined;

  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private messageNotificationService: MessageNotificationService,
              private title: Title,
              private meta: Meta) {
    this.buildForm();
    this.onSave = new EventEmitter<Product>();
  }

  ngOnInit(): void {
    this.subscription = this.productService.notificationProduct.subscribe(product => {
      this.product = product;
      // @ts-ignore
      this.formGroup.setValue({id: product.id, name: product.name, description: product.description, price: product.price, category: product.category});
      this.editing = true;

      // SEO Optimization
      this.title.setTitle(this.product.name);
      this.meta.addTag({name: 'description', content: this.product.description});

      // Social Media Crawler
      this.meta.addTag({name: 'twitter:card', content: 'summary'});
      this.meta.addTag({name: 'twitter:site', content: '@filosofisto'});
      this.meta.addTag({name: 'twitter:title', content: this.product.name});
      this.meta.addTag({name: 'twitter:description', content: this.product.description});
      this.meta.addTag({name: 'twitter:text:description', content: this.product.description});
      // this.meta.addTag({name: 'twitter:image', content: ''});
    });
  }

  private buildForm(): void {
    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      description: ['', Validators.required],
      price: [0, Validators.required],
      category: ['', Validators.required],
    });
  }

  save(formValue: any): void {
    // @ts-ignore
    if (!this.formGroup.valid) {
      this.messageNotificationService.notifyError('There are errors on form');
      return;
    }

    this.onSave.emit(new Product(formValue));

    this.clear();
  }

  clear(): boolean {
    // @ts-ignore
    this.formGroup.reset();
    this.editing = false;

    return false;
  }
}
