import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngswitch',
  templateUrl: './ng-switch.component.html',
  styleUrls: ['./ng-switch.component.css']
})
export class NgSwitchComponent implements OnInit {

  choice: number;

  constructor() { }

  ngOnInit(): void {
    this.choice = 1;
  }

  nextChoice(): void {
    this.choice += 1;

    if (this.choice > 5) {
      this.choice = 1;
    }
  }
}
