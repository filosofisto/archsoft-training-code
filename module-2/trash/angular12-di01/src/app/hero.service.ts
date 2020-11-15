import {Injectable, Optional} from '@angular/core';
import {HEROES} from './mock-heroes';
import {Hero} from './hero';
import {LoggerService} from './logger.service';

@Injectable({
  // we declare that this service should be created
  // by the root application injector.
  providedIn: 'root'
})
export class HeroService {

  constructor(@Optional() private logger?: LoggerService) { }

  getHeroes(): Hero[] {
    if (this.logger) {
      this.logger.info('Getting heroes...');
    }

    return HEROES;
  }
}
