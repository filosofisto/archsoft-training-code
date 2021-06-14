export class Product {

  public id!: string;
  public name!: string;
  public description!: string;
  public price!: number;
  public category!: string;

  constructor(partial: Partial<Product>) {
    Object.assign(this, partial);
  }
}
