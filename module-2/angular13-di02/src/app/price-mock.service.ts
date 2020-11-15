import {PriceService} from './price-service';

export class MockPriceService implements PriceService {

  calculateTotalPrice(basePrice: number, state: string): number {
    if (state === 'FL') {
      return basePrice + 1.66;
    }

    return basePrice;
  }
}
