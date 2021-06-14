import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {LoadingNotificationService} from "./loading-notification.service";

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.scss']
})
export class LoadingComponent {

  loading = false;

  private subscription: Subscription | undefined;

  constructor(private loadingNotificationService: LoadingNotificationService) {
    this.subscribe();
  }

  private subscribe(): void {
    this.subscription = this.loadingNotificationService.notificationChange.subscribe(status => {
      this.loading = status;
    });
  }
}
