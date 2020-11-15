import {PriceService} from './price-service';

export class Product {

  service: PriceService;
  basePrice: number;

  constructor(basePrice: number) {
    this.service = new PriceService(); // <-- instancia hardcoded
    this.basePrice = basePrice;
  }

  totalPrice(state: string): number {
    return this.service.calculateTotalPrice(this.basePrice, state);
  }
}
