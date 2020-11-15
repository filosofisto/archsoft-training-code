import {PriceService} from './price-service';

export class PriceApiService implements PriceService {

  calculateTotalPrice(basePrice: number, state: string): number {
    const tax = Math.random();

    return basePrice + tax;
  }
}
