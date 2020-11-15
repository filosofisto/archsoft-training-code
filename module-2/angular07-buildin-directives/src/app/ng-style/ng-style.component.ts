import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngstyle',
  templateUrl: './ng-style.component.html',
  styleUrls: ['./ng-style.component.css']
})
export class NgStyleComponent implements OnInit {

  colors: string[];
  forecolors: string[];
  currentColor: string;
  currentForecolor: string;
  color: string;
  fontSize: number;

  constructor() { }

  ngOnInit(): void {
    this.colors = ['red', 'green', 'blue', 'yellow', 'white', 'black', 'brown', 'pink'];
    this.forecolors = ['white', 'white', 'white', 'black', 'black', 'white', 'white', 'black'];
    this.currentColor = this.colors[0];
    this.currentForecolor = this.forecolors[0];
    this.color = 'yellow';
    this.fontSize = 12;
  }

  randomColor(): void {
    const rnd: number = this.randomInt(1, this.colors.length - 1) + 1;
    this.currentColor = this.colors[rnd];
    this.currentForecolor = this.forecolors[rnd];
  }

  randomInt(min: number, max: number): number {
    return min + Math.floor((max - min) * Math.random());
  }

  applyColorAndFontSize(colorInput: HTMLInputElement, fontInput: HTMLInputElement): boolean {
    this.color = colorInput.value;
    this.fontSize = parseInt(fontInput.value, 10);

    return false;
  }
}
