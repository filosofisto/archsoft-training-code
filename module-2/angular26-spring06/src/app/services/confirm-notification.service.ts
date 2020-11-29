import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {ConfirmConfig} from '../components/commun/util/confirm-config';

@Injectable({
  providedIn: 'root'
})
export class ConfirmNotificationService {

  notificationChange: Subject<ConfirmConfig> = new Subject<ConfirmConfig>();

  constructor() { }

  confirm(config: ConfirmConfig): void {
    this.notificationChange.next(config);
  }
}
