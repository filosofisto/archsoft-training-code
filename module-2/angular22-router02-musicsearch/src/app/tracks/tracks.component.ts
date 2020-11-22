import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SpotifyService} from '../spotify.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-tracks',
  templateUrl: './tracks.component.html',
  styleUrls: ['./tracks.component.css']
})
export class TracksComponent implements OnInit {
  id: string;
  track: any;

  constructor(private activatedRoute: ActivatedRoute,
              private spotifyService: SpotifyService,
              private location: Location) {
    activatedRoute.params.subscribe(params => { this.id = params['id']; });
  }

  ngOnInit(): void {
    this.spotifyService
      .getTrack(this.id)
      .subscribe((res: any) => this.renderTrack(res));
  }

  back(): void {
    this.location.back();
  }

  renderTrack(res: any): void {
    this.track = res;
  }
}
