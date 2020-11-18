import {Component, Inject, OnInit} from '@angular/core';
import {UserService} from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userName: string;
  callApiRequestURL: string;

  constructor(private userService: UserService, @Inject('API_URL') apiUrl: string) {
    this.callApiRequestURL = `${apiUrl}/user`;
  }

  ngOnInit(): void {
  }

  signIn(): boolean {
    this.userService.setUser({ name: 'Eduardo' });

    this.userName = this.userService.getUser().name;
    return false;
  }
}
