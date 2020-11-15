import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductFormOneWayComponent } from './product-form-one-way.component';

describe('ProductFormOneWayComponent', () => {
  let component: ProductFormOneWayComponent;
  let fixture: ComponentFixture<ProductFormOneWayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductFormOneWayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductFormOneWayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
