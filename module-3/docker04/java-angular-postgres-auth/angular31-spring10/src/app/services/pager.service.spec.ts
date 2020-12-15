import { TestBed } from '@angular/core/testing';

import { PagerService } from './pager.service';

describe('PagerService', () => {
  let service: PagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
