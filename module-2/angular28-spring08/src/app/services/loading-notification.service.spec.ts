import { TestBed } from '@angular/core/testing';

import { LoadingNotificationService } from './loading-notification.service';

describe('LoadingNotificationService', () => {
  let service: LoadingNotificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoadingNotificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
