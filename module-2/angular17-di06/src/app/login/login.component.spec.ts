import {ComponentFixture, inject, TestBed} from '@angular/core/testing';
import {LoginComponent} from './login.component';
import {AuthService} from '../auth.service';

class MockAuthService extends AuthService {

  authenticated = false;

  isAuthenticated(): Promise<boolean> {
    return Promise.resolve(this.authenticated);
  }

  login(): Promise<boolean> {
    this.authenticated = true;
    return this.isAuthenticated();
  }

  logout(): Promise<boolean> {
    this.authenticated = false;
    return this.isAuthenticated();
  }
}

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let testBedService: AuthService;
  let componentService: AuthService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoginComponent], providers: [AuthService]
    }).compileComponents();

    // Configure the component with another set of Providers
    await TestBed.overrideComponent(
      LoginComponent,
      {set: {providers: [{provide: AuthService, useClass: MockAuthService}]}}
    );
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;

    // AuthService provided to the TestBed
    testBedService = TestBed.inject(AuthService);

    // AuthService provided by Component, (should return MockAuthService)
    componentService = fixture.debugElement.injector.get(AuthService);

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('Service injected via inject(...) and TestBed.get(...) should be the same instance',
    inject([AuthService], (injectService: AuthService) => {
      expect(injectService).toBe(testBedService);
    })
  );

  it('Service injected via component should be and instance of MockAuthService', () => {
    expect(componentService instanceof MockAuthService).toBeTruthy();
  });

  // TODO: Test other business
});

// import {ComponentFixture, inject, TestBed} from '@angular/core/testing';
// import { LoginComponent } from './login.component';
// import {AuthService} from '../auth.service';
// import {beforeEach} from 'selenium-webdriver/testing';

// class MockAuthService extends AuthService {
//
//   authenticated = false;
//
//   isAuthenticated(): Promise<boolean> {
//     return Promise.resolve(this.authenticated);
//   }
//
//   login(): Promise<boolean> {
//     this.authenticated = true;
//     return this.isAuthenticated();
//   }
//
//   logout(): Promise<boolean> {
//     this.authenticated = false;
//     return this.isAuthenticated();
//   }
// }

// describe('LoginComponent', () => {
//   let component: LoginComponent;
//   let fixture: ComponentFixture<LoginComponent>;
//   let testBedService: AuthService;
//   let componentService: AuthService;

// beforeEach(async () => {
//   await TestBed.configureTestingModule({
//     declarations: [LoginComponent],
//     providers: [AuthService]
//   }).compileComponents();

// Configure the component with another set of Providers
// TestBed.overrideComponent(
//   LoginComponent,
//   { set: { providers: [{ provide: AuthService, useClass: MockAuthService }] }}
// );

// fixture = TestBed.createComponent(LoginComponent);
//     component = fixture.componentInstance;
//
//     // AuthService provided to the TestBed
//     testBedService = TestBed.get(AuthService);
//
//     // AuthService provided by Component, (should return MockAuthService)
//     componentService = fixture.debugElement.injector.get(AuthService);
//
//     fixture.detectChanges();
//   });
//
//   it('Service injected via inject(...) and TestBed.get(...) should be the same instance',
//     inject([AuthService], (injectService: AuthService) => {
//       expect(injectService).toBe(testBedService);
//     })
//   );
//
//   it('Service injected via component should be and instance of MockAuthService', () => {
//     expect(componentService instanceof MockAuthService).toBeTruthy();
//   });
//
//   it('After login isAuthenticate should be true', () => {
//     componentService.login();
//     expect(componentService.isAuthenticated).toBe(true);
//   });
// });
