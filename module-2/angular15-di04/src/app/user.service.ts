import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: any;

  constructor() { }

  setUser(user): void {
    this.user = user;
  }

  getUser(): any {
    return this.user;
  }
}
