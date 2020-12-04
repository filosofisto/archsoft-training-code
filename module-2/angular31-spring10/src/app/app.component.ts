import {Component, OnInit} from '@angular/core';
import {AuthService} from './services/auth.service';
import {User} from './model/user';
import {Router} from '@angular/router';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular26-spring06';
  currentUser: User;
  private subscription: Subscription;

  constructor(private authService: AuthService,
              private router: Router) {
    this.subscription = this.authService.currentUserSubject.subscribe(
      user => this.currentUser = user);
  }

  ngOnInit(): void {
    if (!this.currentUser) {
      this.router.navigate(['/login']);
    }
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
