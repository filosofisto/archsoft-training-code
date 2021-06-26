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

  it('check album without artists', () => {
    component.album = {
      name: 'Nothing Else Matters',
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toBe('Nothing Else Matters');
  });

  it('check album artists empty', () => {
    component.album = {
      name: 'Nothing Else Matters',
      artists: []
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toBe('Nothing Else Matters');
  });

  it('check album images null', () => {
    component.album = {

    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('img')).toBeFalsy();
  });

  it('check album images empty', () => {
    component.album = {
      images: []
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('img')).toBeFalsy();
  });

  it('check album images only one image', () => {
    component.album = {
      images: [{}]
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('img')).toBeFalsy();
  });

  it('check album images render', () => {
    component.album = {
      images: [{}, { url: 'some url' }]
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('img')).toBeTruthy();
    expect(compiled.querySelector('img').attributes.getNamedItem('src').value).toBe('some url');
  });

  it('check album tracks null', () => {
    component.album = {

    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h3')).toBeFalsy();
  });

  it('check album tracks empty', () => {
    component.album = {
      tracks: []
    };
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h3')).toBeFalsy();
  });

  // TODO: Corrigir
  // it('check album tracks render', () => {
  //   component.album = {
  //     tracks: [{ id: '1', name: 'Nothing Else Matters' }]
  //   };
  //   fixture.detectChanges();
  //   const compiled = fixture.debugElement.nativeElement;
  //   expect(compiled.querySelector('#track_link_1').textContent).toBe('Nothing Else Matters');
  // });
});
