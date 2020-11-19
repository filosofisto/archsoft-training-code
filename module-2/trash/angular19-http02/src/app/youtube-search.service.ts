import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SearchResult} from './search-result';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class YoutubeSearchService {

  constructor(private http: HttpClient,
              @Inject('YOUTUBE_API_KEY') private apiKey,
              @Inject('YOUTUBE_API_URL') private apiUrl) { }

  search(query: string): Observable<SearchResult[]> {
    const params: string = [
      `q=${query}`,
      `key=${this.apiKey}`,
      `part=snippet`,
      `type=video`,
      `maxResults=10`
    ].join('&');
    const queryUrl = `${this.apiUrl}?${params}`;

    return this.http.get(queryUrl).pipe(
      map(response => {
        return response['items'].map(item => {
          return new SearchResult({
            id: item.id.videoId,
            title: item.snippet.title,
            description: item.snippet.description,
            thumbnailUrl: item.snippet.thumbnails.high.url
          });
        }) as any;
    }));
  }
}
