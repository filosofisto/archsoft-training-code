import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngif',
  templateUrl: './ng-if.component.html',
  styleUrls: ['./ng-if.component.css']
})
export class NgIfComponent implements OnInit {

  a: number;
  b: number;

  constructor() { }

  ngOnInit(): void {
    this.a = 1;
    this.b = 0;
  }

}
