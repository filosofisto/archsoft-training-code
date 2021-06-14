import { Component, OnInit } from '@angular/core';
import {MessageNotificationService} from "./message-notification.service";
import {Message} from "./message";
import {Subscription} from "rxjs";
import {MessageSeverity} from "./message-severity.enum";

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

  constructor(private messageNotificationService: MessageNotificationService) { }

  message: Message | undefined;
  private subscription: Subscription | undefined;

  private static timeoutByType(message: Message): number {
    if (message.severity === MessageSeverity.ERROR) {
      return 3500;
    }

    return 2500;
  }

  ngOnInit(): void {
    this.subscribe();
  }

  private subscribe(): void {
    this.subscription = this.messageNotificationService.notificationChange.subscribe(message => {
      this.message = message;
      setTimeout(() => this.message = undefined, MessageComponent.timeoutByType(message));
    });
  }
}

