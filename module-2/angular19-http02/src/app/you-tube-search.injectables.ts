import {YoutubeSearchService} from './youtube-search.service';

export const youtubeSearchInjectables: Array<any> = [
  { provide: YoutubeSearchService, useClass: YoutubeSearchService},
  { provide: 'YOUTUBE_API_KEY', useValue: 'AIzaSyCC4efJs572Lgzwk16x3X8-fru9ZlYTgAQ' },
  { provide: 'YOUTUBE_API_URL', useValue: 'https://www.googleapis.com/youtube/v3/search' }
];
