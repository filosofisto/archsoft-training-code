import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  needsLogin = true;

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    this.authService.isAuthenticated().then(logged => this.needsLogin = !logged);
  }

  login(): void {
    this.authService.login().then(logged => this.needsLogin = !logged);
  }

  logout(): void {
    this.authService.logout().then(logged => this.needsLogin = !logged);
  }
}
