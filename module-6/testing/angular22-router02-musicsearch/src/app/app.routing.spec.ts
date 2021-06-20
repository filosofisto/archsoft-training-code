import {Router} from '@angular/router';
import {fakeAsync, flush, TestBed, tick} from '@angular/core/testing';
import {Location} from '@angular/common';
import {RouterTestingModule} from '@angular/router/testing';
import {routes} from './app-routing.module';
import {AlbumComponent} from './album/album.component';
import {SearchComponent} from './search/search.component';
import {TracksComponent} from './tracks/tracks.component';
import {AppComponent} from './app.component';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {SpotifyService} from './spotify.service';
import {ArtistsComponent} from './artists/artists.component';

describe('Router: App', () => {
  let location: Location;
  let router: Router;
  let fixture;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule.withRoutes(routes), HttpClientTestingModule],
      declarations: [AlbumComponent, SearchComponent, TracksComponent, ArtistsComponent, AppComponent],
      providers: [
        SpotifyService
      ]
    }).compileComponents();

    router = TestBed.inject(Router);
    location = TestBed.inject(Location);
    fixture = TestBed.createComponent(AppComponent);
    router.initialNavigation();
  });

  // it("fakeAsync works", fakeAsync(() => {
  //   let promise = new Promise(resolve => {
  //     setTimeout(resolve, 10);
  //   });
  //   let done = false;
  //   promise.then(() => (done = true));
  //   tick(50);
  //   expect(done).toBeTruthy();
  // }));

  it('navigate to "" redirect to /search', fakeAsync(() => {
    router.navigate(['']).then(() => {
      expect(location.path()).toBe('/search');
    });

    flush();
  }));

  it('navigate to "/search" redirect to /search', fakeAsync(() => {
    router.navigate(['/search']).then(() => {
      expect(location.path()).toBe('/search');
    });

    flush();
  }));

  it('navigate to "/albums/1" redirect to /albums/1', fakeAsync(() => {
    router.navigateByUrl('/albums/1').then(() => {
      expect(location.path()).toBe('/albums/1');
    });

    flush();
  }));

  it('navigate to "/artists/1" redirect to /artists/1', fakeAsync(() => {
    router.navigateByUrl('/artists/1').then(() => {
      expect(location.path()).toBe('/artists/1');
    });

    flush();
  }));
});
