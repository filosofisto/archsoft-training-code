import {Component} from '@angular/core';
import {LoadingNotificationService} from '../../../services/loading-notification.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.css']
})
export class LoadingComponent {

  loading = false;

  private subscription: Subscription;

  constructor(private loadingNotificationService: LoadingNotificationService) {
    this.subscribe();
  }

  private subscribe(): void {
    this.subscription = this.loadingNotificationService.notificationChange.subscribe(status => {
      this.loading = status;
    });
  }
}
