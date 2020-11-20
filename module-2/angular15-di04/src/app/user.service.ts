import {Inject, Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: any;

  constructor(@Inject('API_URL') private apiUrl: string) { }

  setUser(user): void {
    this.user = user;
  }

  getUser(): any {
    return this.user;
  }

  getPath(): string {
    return `${this.apiUrl}/user`;
  }
}
