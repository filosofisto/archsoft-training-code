import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

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
}

export const peopleServiceInjectables: Array<any> = [
  PeopleService
];
