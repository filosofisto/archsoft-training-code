import { Component, OnInit } from '@angular/core';
import {User} from '../user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor() {
    this.users = [
      new User('Hanna', 'Bronnemann'),
      new User('Eduardo', 'Silva'),
      new User('Hiago', 'Pauli')
    ];
  }

  ngOnInit(): void {
  }

}
