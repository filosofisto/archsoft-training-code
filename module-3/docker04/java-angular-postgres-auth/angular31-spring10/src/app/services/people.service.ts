import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import {Person} from '../model/person';
import {PagerData} from '../components/commun/util/pager-data';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  notificationPerson: Subject<Person> = new Subject<Person>();

  constructor(private http: HttpClient) { }

  list(page: number): Observable<PagerData> {
    return this.http.get<PagerData>(`${environment.api}/person?page=${page}`);
  }

  create(person: Person): Observable<Person> {
    return this.http.post<Person>(
      `${environment.api}/person`,
      JSON.stringify(person),
      {headers: new HttpHeaders({'Content-Type': 'application/json'})}
      );
  }

  delete(person: Person): Observable<Person> {
    return this.http.delete<Person>(`${environment.api}/person/${person.id}`);
  }

  read(id: number): Observable<Person> {
    return this.http.get<Person>(`${environment.api}/person/${id}`);
  }

  update(person: Person): Observable<Person> {
    return this.http.put<Person>(
      `${environment.api}/person`,
      JSON.stringify(person),
      {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    );
  }

  notify(person: Person): void {
    this.notificationPerson.next(person);
  }
}

export const peopleServiceInjectables: Array<any> = [
  PeopleService
];
