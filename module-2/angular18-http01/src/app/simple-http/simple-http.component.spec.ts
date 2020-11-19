import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimpleHttpComponent } from './simple-http.component';

describe('SimpleHttpComponent', () => {
  let component: SimpleHttpComponent;
  let fixture: ComponentFixture<SimpleHttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SimpleHttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SimpleHttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
