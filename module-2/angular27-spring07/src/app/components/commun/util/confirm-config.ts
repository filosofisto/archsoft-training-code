export class ConfirmConfig {

  public title: string;
  public message: string;
  public actionAccept: any;
  public actionReject: any;

  constructor(obj: any) {
    this.title   = obj && obj.title ? obj.title : 'Confirm';
    this.message = obj.message;
    this.actionAccept = obj && obj.actionAccept ? obj.actionAccept : () => {};
    this.actionReject = obj && obj.actionReject ? obj.actionReject : () => {};
  }
}
