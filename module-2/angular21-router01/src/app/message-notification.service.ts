import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageNotificationService {

  notificationChange: Subject<string> = new Subject<string>();

  notify(message: string): void {
    this.notificationChange.next(message);
  }
}
