import {Directive, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[appMouseHighlight]'
})
export class MouseHighlightDirective {

  currentColor: string;

  constructor(private el: ElementRef) {
    this.currentColor = el.nativeElement.style.backgroundColor;
  }

  @HostListener('mouseenter')
  onMouseEnter(): void {
    this.highlight('yellow');
  }

  @HostListener('mouseleave')
  onMouseLeave(): void {
    this.highlight(this.currentColor);
  }

  private highlight(color: string): void {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
