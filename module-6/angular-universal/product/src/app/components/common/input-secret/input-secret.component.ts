import {Component} from '@angular/core';
import {InputTextComponent} from "../input-text/input-text.component";

@Component({
  selector: 'app-input-secret',
  templateUrl: './input-secret.component.html',
  styleUrls: ['./input-secret.component.scss']
})
export class InputSecretComponent extends InputTextComponent {

  constructor() {
    super();
  }
}
