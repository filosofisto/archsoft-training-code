import {ComponentFixture, fakeAsync, TestBed} from '@angular/core/testing';

import {ArtistsComponent} from './artists.component';
import {Router} from '@angular/router';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {SpotifyService} from '../spotify.service';
import {AppComponent} from '../app.component';
import {Location} from '@angular/common';
import {RouterTestingModule} from '@angular/router/testing';
import {routes} from '../app-routing.module';
import {AlbumComponent} from '../album/album.component';
import {SearchComponent} from '../search/search.component';
import {TracksComponent} from '../tracks/tracks.component';

describe('ArtistsComponent', () => {
  let component: ArtistsComponent;
  let fixture: ComponentFixture<ArtistsComponent>;
  // let location: Location;
  // let router: Router;
  // let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule.withRoutes(routes), HttpClientTestingModule],
      declarations: [ArtistsComponent],
      providers: [
        SpotifyService
      ]
    }).compileComponents();
  //
  //   router = TestBed.inject(Router);
  //   location = TestBed.inject(Location);
  //   fixture = TestBed.createComponent(AppComponent);
  //   router.initialNavigation();
  //   httpMock = TestBed.inject(HttpTestingController);
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtistsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('check artist rendered', () => {
    component.artist = {
      name: 'Metallica',
      images: [
        { url: 'some address' }
      ]
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toBe('Metallica');
    expect(compiled.querySelector('img').attributes.getNamedItem('src').value).toBe('some address');
  });
});
