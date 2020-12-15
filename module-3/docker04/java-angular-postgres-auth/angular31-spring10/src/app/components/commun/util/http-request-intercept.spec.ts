import { HttpRequestIntercept } from './http-request-intercept';

describe('HttpRequestIntercept', () => {
  it('should save an instance', () => {
    expect(new HttpRequestIntercept()).toBeTruthy();
  });
});
