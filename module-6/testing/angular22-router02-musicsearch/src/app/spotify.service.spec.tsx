import {fakeAsync, inject, TestBed, tick} from '@angular/core/testing';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient, HttpBackend, HttpRequest, HttpResponse, HttpHandler } from '@angular/common/http';
import { SpotifyService } from './spotify.service';

export const mockTrack = {
  name: 'Nothing Else Matters'
};

export const mockTracks = {
  items: [
    { album: { name: 'Metallica' } },
    { album: { name: 'Inquisition Symphony' } }
  ]
};

export const mockArtist = {
  name: 'Metallica'
};

describe('SpotifyService', () => {
  let service: SpotifyService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [
        SpotifyService
      ]
    });
    service = TestBed.inject(SpotifyService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('http mock infrastructure was created', () => {
    expect(httpMock).toBeTruthy();
  });

  it('service was created', () => {
    expect(service).toBeTruthy();
  });

  it('retrieves using the track ID', () => {
    service.getTrack('TRACK_ID').subscribe((data: any) => {
      expect(data).not.toBe(null);
      expect(JSON.stringify(data)).toEqual(JSON.stringify(mockTrack));
      // expect(JSON.parse(data)['name']).toEqual('Metallica');
    });

    const req = httpMock.expectOne('https://api.spotify.com/v1/tracks/TRACK_ID');

    req.flush(mockTrack);
  });

  it('search tracks by query parameter', () => {
    service.searchTrack('Nothing Else Matters').subscribe((data: any) => {
      expect(data).not.toBe(null);
      expect(JSON.stringify(data)).toEqual(JSON.stringify(mockTracks));
    });

    const req = httpMock.expectOne('https://api.spotify.com/v1/search?q=Nothing Else Matters&type=track');

    req.flush(mockTracks);
  });

  it('retrieves using the artist ID', () => {
    service.getTrack('ARTIST_ID').subscribe((data: any) => {
      expect(data).not.toBe(null);
      expect(JSON.stringify(data)).toEqual(JSON.stringify(mockArtist));
    });

    const req = httpMock.expectOne('https://api.spotify.com/v1/artist/ARTIST_ID');

    req.flush(mockArtist);
  });

  // TODO: getAlbum
  // TODO: Refactor
});


