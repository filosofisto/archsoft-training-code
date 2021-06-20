import {Router} from '@angular/router';
import {TestBed} from '@angular/core/testing';
import {Location} from '@angular/common';
import {RouterTestingModule} from '@angular/router/testing';
import {routes} from './app-routing.module';
import {AlbumComponent} from './album/album.component';
import {SearchComponent} from './search/search.component';
import {TracksComponent} from './tracks/tracks.component';
import {AppComponent} from './app.component';

describe('Router: App', () => {
  // let location: Location;
  // let router: Router;
  // let fixture;
  //
  // beforeEach(() => {
  //   TestBed.configureTestingModule({
  //     imports: [RouterTestingModule.withRoutes(routes)],
  //     declarations: [AlbumComponent, SearchComponent, TracksComponent]
  //   });
  //
  //   location = TestBed.inject(Location);
  //   router = TestBed.inject(Router);
  //   fixture = TestBed.createComponent(AppComponent);
  //   router.initialNavigation();
  // });
  //
  // it('navigate to "" redirect to /search', () => {
  //   router.navigate(['']).then(() => {
  //     console.log(location.path());
  //     expect(location.path()).toEqual('/xsearch');
  //   });
  // });
  //
  // it('navigate to "/search" redirect to /search', () => {
  //   router.navigate(['/search']).then(() => {
  //     expect(location.path()).toEqual('/xsearch');
  //   });
  // });
  //
  // it('navigate to "/album/1" redirect to /album/1', () => {
  //   router.navigateByUrl('/album/1').then(() => {
  //     expect(location.path()).toEqual('/xalbum/1');
  //   });
  // });
  //
  // it('navigate to "/artists/1" redirect to /artists/1', () => {
  //   router.navigateByUrl('/artists/1').then(() => {
  //     expect(location.path()).toEqual('/xartists/1');
  //   });
  // });

  // it('from artist component click on back link should navigate to /search', () => {
  //   router.navigateByUrl('/artists/1').then(() => {
  //     expect(location.path()).toBe('/artists/1');
  //     const artist = fixture.debugElement.children[1].componentInstance;
  //     artist.back();
  //
  //     expect(location.path()).toBe('/artists/1');
  //   });
  // });
});
