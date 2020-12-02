import {Component, Input, OnInit} from '@angular/core';
import {AbstractControl} from '@angular/forms';

@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.css']
})
export class InputTextComponent implements OnInit {

  @Input() label: string;
  @Input() control: AbstractControl;
  @Input() id: string;
  @Input() placeholder: string;
  @Input() invalidMessage: string;

  constructor() { }

  ngOnInit(): void {
    this.id = this.label.toLowerCase() + 'Input';
    this.invalidMessage = this.invalidMessage || this.label + ' invalid';

  }

}
