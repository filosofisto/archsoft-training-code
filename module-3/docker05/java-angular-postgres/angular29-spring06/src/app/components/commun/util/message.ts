import {MessageSeverity} from './message-severity.enum';

export class Message {

  constructor(public text: string, public severity: MessageSeverity) { }
}
