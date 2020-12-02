import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';
import {PagerData} from '../components/commun/util/pager-data';

@Injectable({
  providedIn: 'root'
})
export class PagerService {

  notificationChange: Subject<PagerData> = new Subject<PagerData>();

  constructor() { }

  notify(pagerData: PagerData): void {
    this.notificationChange.next(pagerData);
  }
}
