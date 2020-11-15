import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-class',
  templateUrl: './ng-class.component.html',
  styleUrls: ['./ng-class.component.css']
})
export class NgClassComponent implements OnInit {

  bordered: boolean;
  classesObj: any;
  classList: string[];

  constructor() { }

  ngOnInit(): void {
    this.bordered = true;
    this.classList = ['blue', 'round'];
    this.toggleBorder();
  }

  toggleClick(): boolean {
    this.toggleBorder();
    return false;
  }

  private toggleBorder(): void {
    this.bordered = !this.bordered;
    this.classesObj = {
      bordered: this.bordered
    };
  }
}
