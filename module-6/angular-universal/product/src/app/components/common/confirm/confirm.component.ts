import { Component, OnInit } from '@angular/core';
import {ConfirmConfig} from "./confirm-config";
import {Subscription} from "rxjs";
import {ConfirmNotificationService} from "./confirm-notification.service";

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.scss']
})
export class ConfirmComponent implements OnInit {

  opened = false;
  confirmConfig: ConfirmConfig = new ConfirmConfig({});
  private subscription: Subscription | undefined;

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
