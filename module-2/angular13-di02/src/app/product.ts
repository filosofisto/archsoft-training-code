import {PriceApiService} from './price-api-service';
import {PriceService} from './price-service';

export class Product {

  service: PriceApiService;
  basePrice: number;

  constructor(service: PriceService, basePrice: number) {
    this.service = service;
    this.basePrice = basePrice;
  }

  totalPrice(state: string): number {
    return this.service.calculateTotalPrice(this.basePrice, state);
  }
}
