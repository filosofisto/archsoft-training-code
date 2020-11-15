import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  logs: string[] = [];

  constructor() { }

  info(text: string): void {
    this.logs.push(text);
    console.log(text);
  }
}
