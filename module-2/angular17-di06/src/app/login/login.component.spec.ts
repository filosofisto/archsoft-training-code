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

  it('Login should return true', async () => {
    await componentService.login().then(value => expect(value).toBe(true));
  });

  it('Logout should return false', async () => {
    await componentService.logout().then(value => expect(value).toBe(false));
  });

  const checkAfterOfAuthMethod = (execution: Promise<boolean>, expected: boolean) =>
    execution.then(() => componentService.isAuthenticated().then(value => expect(value).toBe(expected)));

  it('After login isAuthenticated should be true', async () => {
    await checkAfterOfAuthMethod(componentService.login(), true);
  });

  it('After logout isAuthenticated should be false', async () => {
    await checkAfterOfAuthMethod(componentService.logout(), false);
  });
});
