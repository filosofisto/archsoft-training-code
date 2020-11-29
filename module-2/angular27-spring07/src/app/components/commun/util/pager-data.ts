import {Sort} from './sort';
import {Pageable} from './pageable';

export class PagerData<T> {

  constructor(public context: string,
              public content: Array<T>,
              public pageable: Pageable,
              public totalElements: number,
              public totalPages: number,
              public last: boolean,
              public size: number,
              public sort: Sort,
              public numberOfElements: number,
              public first: boolean,
              // public number_: number,
              public empty: boolean) { }

  static default(context: string): PagerData {
    return new PagerData(
      context,
      [],
      new Pageable(new Sort(false, true, true), 0, 0, 0, true, false),
      0, 0, false, 0, new Sort(false, true, true), 0, false, true
    );
  }
}
