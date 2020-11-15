import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoFormWithoutVariableComponent } from './demo-form-without-variable.component';

describe('DemoFormWithoutVariableComponent', () => {
  let component: DemoFormWithoutVariableComponent;
  let fixture: ComponentFixture<DemoFormWithoutVariableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemoFormWithoutVariableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoFormWithoutVariableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
