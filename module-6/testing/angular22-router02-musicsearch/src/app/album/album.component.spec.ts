import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumComponent } from './album.component';
import {RouterModule} from '@angular/router';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {SpotifyService} from '../spotify.service';

describe('AlbumComponent', () => {
  let component: AlbumComponent;
  let fixture: ComponentFixture<AlbumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlbumComponent ],
      imports: [RouterModule.forRoot([]), HttpClientTestingModule],
      providers: [
        SpotifyService
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('check album rendered', () => {
    component.album = {
      name: 'Nothing Else Matters',
      artists: [

      ]
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toBe('Nothing Else Matters');
  });
});
