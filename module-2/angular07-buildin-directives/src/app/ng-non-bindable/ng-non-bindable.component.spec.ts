import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgNonBindableComponent } from './ng-non-bindable.component';

describe('NgNonBindableComponent', () => {
  let component: NgNonBindableComponent;
  let fixture: ComponentFixture<NgNonBindableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgNonBindableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgNonBindableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
