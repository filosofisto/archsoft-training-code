import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputSecretComponent } from './input-secret.component';

describe('InputSecretComponent', () => {
  let component: InputSecretComponent;
  let fixture: ComponentFixture<InputSecretComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InputSecretComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InputSecretComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
