import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-non-bindable',
  templateUrl: './ng-non-bindable.component.html',
  styleUrls: ['./ng-non-bindable.component.css']
})
export class NgNonBindableComponent implements OnInit {

  data: string;

  constructor() { }

  ngOnInit(): void {
    this.data = 'Some text';
  }

}
