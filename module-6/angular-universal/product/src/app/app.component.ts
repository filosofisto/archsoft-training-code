import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {AuthService} from "./services/auth.service";
import {Router} from "@angular/router";
import {MessageNotificationService} from "./components/common/message/message-notification.service";
import {User} from "./model/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title = 'Product CRUD';

  currentUser: User | undefined;

  private subscription: Subscription;

  constructor(private authService: AuthService,
              private router: Router,
              private messageNotificationService: MessageNotificationService) {
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
    this.messageNotificationService.notifyInfo('Have a nice day');
  }
}
