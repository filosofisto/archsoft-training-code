import {Component, EventEmitter, OnInit, Output} from '@angular/core';
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
  private updatePager = (data) => {
    this.onPagerData.emit(data);
    this.initPager(data);
  }

  @Output() onGoto: EventEmitter<number> = new EventEmitter<number>();
  @Output() onPagerData: EventEmitter<any> = new EventEmitter<any>();

  constructor(private pagerService: PagerService) { }

  ngOnInit(): void {
    this.subscription = this.pagerService.notificationChange.subscribe(
      data => this.initPager(data)
    );
  }

  private initPager(data: any): void {
    this.pagerData = new PagerData(data);
    this.calcPages();
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
    this.pagerService.first(this.pagerData.data).subscribe(this.updatePager);
  }

  next(): void {
    this.pagerService.next(this.pagerData.data).subscribe(this.updatePager);
  }

  before(): void {
    this.pagerService.before(this.pagerData.data).subscribe(this.updatePager);
  }

  last(): void {
    this.pagerService.last(this.pagerData.data).subscribe(this.updatePager);
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
