import { TestBed } from '@angular/core/testing';

import { YoutubeSearchService } from './youtube-search.service';

describe('YoutubeSearchService', () => {
  let service: YoutubeSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(YoutubeSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
