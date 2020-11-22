import {Component, OnInit} from '@angular/core';
import {SpotifyService} from '../spotify.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  query: string;
  results: any;

  constructor(private spotifyService: SpotifyService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => this.query = params['query'] || '');
  }

  ngOnInit(): void {
    this.search();
  }

  submit(query: string): void {
    this.router.navigate(['search'], {queryParams: {query: query}})
      .then(_ => this.search());
  }

  search(): void {
    console.log('query: ', this.query);

    if (!this.query) {
      return;
    }

    this.spotifyService.searchTrack(this.query).subscribe((res: any) => this.renderResults(res));
  }

  private renderResults(res: any): void {
    this.results = null;

    if (res && res.tracks && res.tracks.items) {
      this.results = res.tracks.items;
    }
  }
}
