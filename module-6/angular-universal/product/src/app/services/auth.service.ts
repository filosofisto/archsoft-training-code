import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../model/user";
import {environment} from "../../environments/environment";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  currentUserSubject: BehaviorSubject<User|undefined>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User|undefined>(
      // @ts-ignore
      JSON.parse(localStorage.getItem('currentUser'))
    );
  }

  public get currentUser(): User | undefined {
    return this.currentUserSubject.value;
  }

  public login(username: string, password: string): Observable<User> {
    return this.http.post<any>(
      `${environment.auth}/signin`,
      {username, password},
      {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    ).pipe(map(user => {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.currentUserSubject.next(user);
      return user;
    }));
  }

  public logout(): void {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(undefined);
  }
}

export const authServiceInjectables: Array<any> = [
  AuthService
];
