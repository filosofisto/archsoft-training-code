import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isAuthenticated(): Promise<boolean> {
    return Promise.resolve(!!localStorage.getItem('token'));
  }

  login(): Promise<boolean> {
    localStorage.setItem('token', 'this is a secret value');
    return Promise.resolve(true);
  }

  logout(): Promise<boolean> {
    localStorage.removeItem('token');
    return Promise.resolve(false);
  }
}
