import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PagerData} from '../util/pager-data';
import {Subscription} from 'rxjs';
import {PagerService} from '../../../services/pager.service';

@Component({
  selector: 'app-pager',
  templateUrl: './pager.component.html',
  styleUrls: ['./pager.component.css']
})
export class PagerComponent implements OnInit {

  pagerData: PagerData;
  pages: number[] = [];
  private subscription: Subscription;

  @Output() onFirst: EventEmitter<any> = new EventEmitter<any>();
  @Output() onNext: EventEmitter<any> = new EventEmitter<any>();
  @Output() onLast: EventEmitter<any> = new EventEmitter<any>();
  @Output() onBefore: EventEmitter<any> = new EventEmitter<any>();
  @Output() onGoto: EventEmitter<number> = new EventEmitter<number>();

  constructor(private pagerService: PagerService) { }

  ngOnInit(): void {
    this.subscription = this.pagerService.notificationChange.subscribe(data => {
      this.pagerData = new PagerData(data);
      this.calcPages();
    });
  }

  private calcPages(): void {
    if (this.pagerData) {
      this.pages = [];
      for (let i = 0; i < this.pagerData.totalPages(); i++) {
        this.pages.push(i + 1);
      }
    }
  }

  isFirst(): boolean {
    return this.pagerData && this.pagerData.isFirst();
  }

  hasItems(): boolean {
    return this.pagerData && this.pagerData.hasItems();
  }

  first(): void {
    this.onFirst.emit();
  }

  next(): void {
    this.onNext.emit();
  }

  before(): void {
    this.onBefore.emit();
  }

  last(): void {
    this.onLast.emit();
  }

  isLast(): boolean {
    return this.pagerData.isLast();
  }

  gotoPage(page: number): void {
    this.onGoto.emit(page - 1);
  }

  isCurrent(page: number): boolean {
    return this.pagerData.isCurrent(page);
  }
}
