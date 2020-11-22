import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SpotifyService} from '../spotify.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {
  id: string;
  album: any;

  constructor(private route: ActivatedRoute,
              private spotifyService: SpotifyService, // <-- injected
              private location: Location) {
    route.params.subscribe(params => { this.id = params['id']; });
  }

  ngOnInit(): void {
    this.spotifyService
      .getAlbum(this.id)
      .subscribe((res: any) => this.renderAlbum(res));
  }

  back(): void {
    this.location.back();
  }

  renderAlbum(res: any): void {
    this.album = res;
  }
}

