import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';
import {PagerData} from '../components/commun/util/pager-data';

@Injectable({
  providedIn: 'root'
})
export class PagerService {

  notificationChange: Subject<PagerData<any>> = new Subject<PagerData<any>>();

  constructor() { }

  notify(pagerData: PagerData<any>): void {
    this.notificationChange.next(pagerData);
  }
}
