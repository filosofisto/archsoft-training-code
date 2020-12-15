import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import {Person} from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  notificationPerson: Subject<Person> = new Subject<Person>();

  constructor(private http: HttpClient, @Inject('API_URL') private apiUrl: string) { }

  list(): Observable<Person[]> {
    return this.http.get<Person[]>(this.apiUrl);
  }

  create(person: Person): Observable<Person> {
    return this.http.post<Person>(
      this.apiUrl,
      JSON.stringify(person),
      {headers: new HttpHeaders({'Content-Type': 'application/json'})}
      );
  }

  delete(person: Person): Observable<Person> {
    return this.http.delete<Person>(`${this.apiUrl}/${person.id}`);
  }

  read(id: number): Observable<Person> {
    return this.http.get<Person>(`${this.apiUrl}/${id}`);
  }

  update(person: Person): Observable<Person> {
    return this.http.put<Person>(
      this.apiUrl,
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
