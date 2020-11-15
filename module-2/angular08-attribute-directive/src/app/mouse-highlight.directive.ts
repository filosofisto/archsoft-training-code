import {Directive, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[appMouseHighlight]'
})
export class MouseHighlightDirective {

  constructor(private el: ElementRef) {

  }

  @HostListener('mouseenter')
  onMouseEnter(): void {
    this.highlight('yellow');
  }

  @HostListener('mouseleave')
  onMouseLeave(): void {
    this.highlight(null);
  }

  private highlight(color: string): void {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
