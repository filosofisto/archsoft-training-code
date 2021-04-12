import { Message } from './message';

describe('Message', () => {
  it('should save an instance', () => {
    expect(new Message()).toBeTruthy();
  });
});
