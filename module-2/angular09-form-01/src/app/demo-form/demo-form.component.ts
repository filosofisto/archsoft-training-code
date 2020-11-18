import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo-form',
  templateUrl: './demo-form.component.html',
  styleUrls: ['./demo-form.component.css']
})
export class DemoFormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(form: any): void {
    console.log(`form ${JSON.stringify(form)}`);
  }
}
