import { TestBed } from '@angular/core/testing';

import { ConfirmNotificationService } from './confirm-notification.service';

describe('ConfirmNotificationService', () => {
  let service: ConfirmNotificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConfirmNotificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
