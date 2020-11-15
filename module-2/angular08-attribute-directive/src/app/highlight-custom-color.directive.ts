import {Directive, ElementRef, HostListener, Input} from '@angular/core';

@Directive({
  selector: '[appHighlightCustomColor]'
})
export class HighlightCustomColorDirective {

  @Input() color: string;
  @Input() backColor: string;

  constructor(private el: ElementRef) {

  }

  @HostListener('mouseenter')
  onMouseEnter(): void {
    this.highlight(this.color || 'black', this.backColor || 'yellow');
  }

  @HostListener('mouseleave')
  onMouseLeave(): void {
    this.highlight('black', null);
  }

  private highlight(color: string, backColor: string): void {
    this.el.nativeElement.style.color = color;
    this.el.nativeElement.style.backgroundColor = backColor;
  }
}
