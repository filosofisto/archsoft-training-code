import {Injectable} from '@angular/core';
import {Observable, Subject} from 'rxjs';
import {PagerData} from '../components/commun/util/pager-data';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PagerService {

  notificationChange: Subject<any> = new Subject<any>();

  constructor(private http: HttpClient) { }

  notify(data: any): void {
    this.notificationChange.next(data);
  }

  first(pagerData: any): Observable<any> {
    return this.request(pagerData['_links']['first']['href']);
  }

  before(pagerData: any): Observable<any> {
    return this.request(pagerData['_links']['prev']['href']);
  }

  next(pagerData: any): Observable<any> {
    return this.request(pagerData['_links']['next']['href']);
  }

  last(pagerData: any): Observable<any> {
    return this.request(pagerData['_links']['last']['href']);
  }

  private request(url: string): Observable<any> {
    return this.http.get<any>(`${url}`);
  }
}
