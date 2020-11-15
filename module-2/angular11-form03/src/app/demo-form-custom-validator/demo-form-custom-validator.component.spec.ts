import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoFormCustomValidatorComponent } from './demo-form-custom-validator.component';

describe('DemoFormCustomValidatorComponent', () => {
  let component: DemoFormCustomValidatorComponent;
  let fixture: ComponentFixture<DemoFormCustomValidatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemoFormCustomValidatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoFormCustomValidatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
