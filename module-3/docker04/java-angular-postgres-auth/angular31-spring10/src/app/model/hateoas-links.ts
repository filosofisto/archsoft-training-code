import {HateoasLinksSelf} from './hateoas-links-self';

export class HateoasLinks {

  public self: HateoasLinksSelf;

  constructor(obj?: any) {
    this.self = obj && obj.self ? obj.self : null;
  }
}
