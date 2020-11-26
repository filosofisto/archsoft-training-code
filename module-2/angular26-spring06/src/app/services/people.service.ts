import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from '../model/person';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) { }

  list(): Observable<Person[]> {
    return this.http.get<Person[]>(this.apiUrl);
  }
}

export const peopleServiceInjectables: Array<any> = [
  PeopleService
];
