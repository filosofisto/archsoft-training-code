import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {Message} from '../components/commun/util/message';
import {MessageSeverity} from '../components/commun/util/message-severity.enum';

@Injectable({
  providedIn: 'root'
})
export class MessageNotificationService {

  notificationChange: Subject<Message> = new Subject<Message>();

  notify(message: Message): void {
    this.notificationChange.next(message);
  }

  notifySuccess(text: string): void {
    this.notifySeverity(text, MessageSeverity.SUCCESS);
  }

  notifyInfo(text: string): void {
    this.notifySeverity(text, MessageSeverity.INFO);
  }

  notifyWarn(text: string): void {
    this.notifySeverity(text, MessageSeverity.WARN);
  }

  notifyError(text: string): void {
    this.notifySeverity(text, MessageSeverity.ERROR);
  }

  private notifySeverity(text: string, severity: MessageSeverity): void {
    this.notificationChange.next(new Message(text, severity));
  }
}

export const messageNotificationServiceInjectables: Array<any> = [
  MessageNotificationService
];
