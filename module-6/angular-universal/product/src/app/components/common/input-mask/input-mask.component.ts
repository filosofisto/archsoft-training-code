import {Component, Input} from '@angular/core';
import {InputTextComponent} from "../input-text/input-text.component";

@Component({
  selector: 'app-input-mask',
  templateUrl: './input-mask.component.html',
  styleUrls: ['./input-mask.component.scss']
})
export class InputMaskComponent extends InputTextComponent {

  // @ts-ignore
  @Input() mask: string;

  constructor() {
    super();
  }
}
