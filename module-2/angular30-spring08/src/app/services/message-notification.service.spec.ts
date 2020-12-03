import { TestBed } from '@angular/core/testing';

import { MessageNotificationService } from './message-notification.service';

describe('MessageNotificationService', () => {
  let service: MessageNotificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MessageNotificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
