import {Component, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {ConfirmNotificationService} from '../../../services/confirm-notification.service';
import {ConfirmConfig} from '../util/confirm-config';

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

  opened = false;
  confirmConfig: ConfirmConfig;
  private subscription: Subscription;

  constructor(private confirmNotificationService: ConfirmNotificationService) { }

  ngOnInit(): void {
    this.subscribe();
  }

  private subscribe(): void {
    this.subscription = this.confirmNotificationService.notificationChange.subscribe(confirmConfig => {
      this.confirmConfig = confirmConfig;
      this.opened = true;
    });
  }


  clickYes(): void {
    if (this.confirmConfig.actionAccept) {
      this.confirmConfig.actionAccept();
    }

    this.opened = false;
  }

  clickNo(): void {
    if (this.confirmConfig.actionReject) {
      this.confirmConfig.actionReject();
    }

    this.opened = false;
  }
}
