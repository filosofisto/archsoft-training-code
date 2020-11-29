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

  pagerData: PagerData<any>;
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
      this.pagerData = data;
      this.calcPages();
    });
  }

  private calcPages(): void {
    if (this.pagerData) {
      this.pages = [];
      for (let i = 0; i < this.pagerData.totalPages; i++) {
        this.pages.push(i + 1);
      }
    }
  }

  isFirst(): boolean {
    return this.pagerData && this.pagerData.first;
  }

  hasItems(): boolean {
    return this.pagerData && !this.pagerData.empty;
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
    return this.pagerData && this.pagerData.last;
  }

  gotoPage(page: number): void {
    this.onGoto.emit(page - 1);
  }

}
