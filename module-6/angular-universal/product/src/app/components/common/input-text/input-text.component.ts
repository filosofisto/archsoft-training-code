import {Component, Input, OnInit} from '@angular/core';
import {AbstractControl} from "@angular/forms";

@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.scss']
})
export class InputTextComponent implements OnInit {

  @Input() label: string = '';
  // @ts-ignore
  @Input() control: AbstractControl;
  // @ts-ignore
  @Input() id: string;
  // @ts-ignore
  @Input() placeholder: string;
  // @ts-ignore
  @Input() invalidMessage: string;

  constructor() { }

  ngOnInit(): void {
    this.id = this.label.toLowerCase() + 'Input';
    this.invalidMessage = this.invalidMessage || this.label + ' invalid';
  }
}
