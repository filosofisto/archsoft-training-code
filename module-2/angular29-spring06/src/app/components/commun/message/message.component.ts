import {Component, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {MessageNotificationService} from '../../../services/message-notification.service';
import {Message} from '../util/message';
import {MessageSeverity} from '../util/message-severity.enum';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  constructor(private messageNotificationService: MessageNotificationService) { }

  messages: Message[] = [];
  private subscription: Subscription;

  private static timeoutByType(message: Message): number {
    if (message.severity === MessageSeverity.ERROR) {
      return 5500;
    }

    return 3500;
  }

  ngOnInit(): void {
    this.subscribe();
  }

  private subscribe(): void {
    this.subscription = this.messageNotificationService.notificationChange.subscribe(message => {
      this.messages.push(message);
      setTimeout(() => this.messages.length = 0, MessageComponent.timeoutByType(message));
    });
  }
}
