import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoadingNotificationService {

  notificationChange: Subject<boolean> = new Subject<boolean>();

  loadingMap: Map<string, boolean> = new Map<string, boolean>();

  constructor() { }

  start(url: string): void {
    if (!url) {
      return;
    }

    this.loadingMap.set(url, true);
    this.notificationChange.next(true);
  }

  stop(url: string): void {
    if (!url) {
      return;
    }

    if (this.loadingMap.has(url)) {
      this.loadingMap.delete(url);
    }

    if (this.loadingMap.size === 0) {
      this.notificationChange.next(false);
    }
  }
}
