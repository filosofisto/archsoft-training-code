import {HateoasLinks} from './hateoas-links';

export class Hateoas {

  public _links: HateoasLinks;

  constructor(obj?: any) {
    this._links = obj && obj._links ? obj._links : null;
  }
}
