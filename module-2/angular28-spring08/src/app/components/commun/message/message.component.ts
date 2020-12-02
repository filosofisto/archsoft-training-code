import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {MessageNotificationService} from '../../../services/message-notification.service';
import {Message} from '../util/message';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  message: Message;
  private subscription: Subscription;

  constructor(private messageNotificationService: MessageNotificationService) { }

  ngOnInit(): void {
    this.subscribe();
  }

  private subscribe(): void {
    this.subscription = this.messageNotificationService.notificationChange.subscribe(message => {
      this.message = message;
      setTimeout(() => this.message = null, 2500);
    });
  }
}
