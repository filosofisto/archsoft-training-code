import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {MessageNotificationService} from '../message-notification.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  message = '';
  private subscription: Subscription;

  constructor(private messageNotificationService: MessageNotificationService) { }

  ngOnInit(): void {
    this.subscribe();
  }

  private subscribe(): void {
    this.subscription = this.messageNotificationService.notificationChange.subscribe(message => {
      this.message = message;
      setTimeout(() => this.message = '', 2000);
    });
  }
}
