export class HateoasLinksSelf {

  public href: string;

  constructor(obj?: any) {
    this.href = obj && obj.href ? obj.href : null;
  }
}
