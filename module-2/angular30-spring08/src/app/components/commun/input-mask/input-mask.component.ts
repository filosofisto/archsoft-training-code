import {Component, Input, OnInit} from '@angular/core';
import {InputTextComponent} from '../input-text/input-text.component';

@Component({
  selector: 'app-input-mask',
  templateUrl: './input-mask.component.html',
  styleUrls: ['./input-mask.component.css']
})
export class InputMaskComponent extends InputTextComponent {

  @Input() mask: string;

  constructor() {
    super();
  }

}
