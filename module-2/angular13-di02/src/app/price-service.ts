export interface PriceService {

  calculateTotalPrice(basePrice: number, state: string): number;
}
