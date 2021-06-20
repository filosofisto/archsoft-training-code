import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ArtistsComponent} from './artists.component';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {SpotifyService} from '../spotify.service';
import {RouterTestingModule} from '@angular/router/testing';
import {routes} from '../app-routing.module';

describe('ArtistsComponent', () => {
  let component: ArtistsComponent;
  let fixture: ComponentFixture<ArtistsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule.withRoutes(routes), HttpClientTestingModule],
      declarations: [ArtistsComponent],
      providers: [
        SpotifyService
      ]
    }).compileComponents();
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
