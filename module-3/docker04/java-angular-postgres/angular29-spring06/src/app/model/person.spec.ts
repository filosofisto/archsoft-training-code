import { Person } from './person';

describe('Person', () => {
  it('should save an instance', () => {
    expect(new Person()).toBeTruthy();
  });
});
