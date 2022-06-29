import { Owner } from './owner.model';

describe('Owner', () => {
  it('should create an instance', () => {
    expect(new Owner(0, '', '', '', 0)).toBeTruthy();
  });
});
