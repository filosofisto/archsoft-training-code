export class ConsoleSpy {

  public logs: string[] = [];

  log(...args: any[]): void {
    this.logs.push(args.join(' '));
  }

  warn(...args: any[]): void {
    this.log(...args);
  }
}
