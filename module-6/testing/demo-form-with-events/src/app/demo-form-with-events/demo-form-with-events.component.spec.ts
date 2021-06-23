import {ComponentFixture, fakeAsync, TestBed, tick} from '@angular/core/testing';

import { DemoFormWithEventsComponent } from './demo-form-with-events.component';
import {ConsoleSpy} from "../util/console-spy";
import {By} from "@angular/platform-browser";
import {ReactiveFormsModule} from "@angular/forms";

describe('DemoFormWithEventsComponent', () => {
  let component: DemoFormWithEventsComponent;
  let fixture: ComponentFixture<DemoFormWithEventsComponent>;
  let originalConsole: Console;
  let fakeConsole: ConsoleSpy;
  let el: { querySelectorAll: (arg0: string) => any; };
  let input: { value: string; dispatchEvent: (arg0: Event) => void; };
  let form: { dispatchEvent: (arg0: Event) => void; };

  beforeEach(async () => {
    fakeConsole = new ConsoleSpy();
    originalConsole = window.console;
    (window as any).console = fakeConsole;

    await TestBed.configureTestingModule({
      declarations: [ DemoFormWithEventsComponent ],
      imports: [ReactiveFormsModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoFormWithEventsComponent);
    component = fixture.componentInstance;
    el = fixture.debugElement.nativeElement;
    input = fixture.debugElement.query(By.css('input')).nativeElement;
    form = fixture.debugElement.query(By.css('form')).nativeElement;
    fixture.detectChanges();
  });

  afterAll(() => {
    (window as any).console = originalConsole;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('displays errors with no sku', fakeAsync(() => {
    input.value = '';
    input.dispatchEvent(new Event('input'));
    fixture.detectChanges();

    const msgs = el.querySelectorAll('.ui.error.message');

    expect(msgs[0].innerHTML).toContain('SKU is invalid');
    expect(msgs[1].innerHTML).toContain('SKU is required');
  }));

  it('displays no errors when sku is valid', fakeAsync(() => {
    input.value = '123XXX';
    input.dispatchEvent(new Event('input'));
    fixture.detectChanges();

    const msgs = el.querySelectorAll('.ui.error.message');

    expect(msgs.length).toBe(0);
  }));

  it('handles sku value changes', fakeAsync(() => {
    input.value = 'XYZ';
    input.dispatchEvent(new Event('input'));
    tick();

    expect(fakeConsole.logs).toContain('sku changed to: XYZ');
  }));

  it('handles form changes', fakeAsync(() => {
    input.value = 'XYZ';
    input.dispatchEvent(new Event('input'));
    tick();

    expect(fakeConsole.logs).toContain('form changed to: [object Object]');
  }));

  it('handles form submission', fakeAsync(() => {
    input.value = '123XXX';
    input.dispatchEvent(new Event('input'));
    tick();

    fixture.detectChanges();
    form.dispatchEvent(new Event('submit'));
    tick();

    expect(fakeConsole.logs).toContain('you submitted value: 123XXX');
  }));
});


