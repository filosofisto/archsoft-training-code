import {Product} from './product';
import {MockPriceService} from './price-mock.service';

describe('Product', () => {
  let product;

  beforeEach(() => {
    const service = new MockPriceService();
    product = new Product(service, 10);
  });

  describe('price', () => {
    it('is calculates based on the basePrice and the state', () => {
      expect(product.totalPrice('FL')).toBe(11.66);
    });
  });
});
