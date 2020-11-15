export class PriceService {

  calculateTotalPrice(basePrice: number, state: string): number {
    const tax = Math.random();

    return basePrice + tax;
  }
}
