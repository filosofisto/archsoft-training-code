import {Component, OnInit, ReflectiveInjector} from '@angular/core';
import {UserService} from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  userName: string;
  userService: UserService;

  constructor() {
    const injector: any = ReflectiveInjector.resolveAndCreate([UserService]);
    this.userService = injector.get(UserService);
  }

  ngOnInit(): void {
  }

  signIn(): boolean {
    this.userService.setUser({ name: 'Eduardo' });

    this.userName = this.userService.getUser().name;
    return false;
  }
}
