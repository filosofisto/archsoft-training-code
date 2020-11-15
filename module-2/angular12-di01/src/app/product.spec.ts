import { Product } from './product';

describe('Product', () => {
  let product;

  beforeEach(() => product = new Product(10));

  describe('price', () => {
    it('is calculates based on the basePrice and the state', () => {
      expect(product.totalPrice('FL')).toBe(11.66); // <-- ???
    });
  });
});
