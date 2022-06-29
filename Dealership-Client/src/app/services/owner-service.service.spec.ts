import { TestBed } from '@angular/core/testing';

import { OwnerServiceService } from './owner-service.service';

describe('OwnerServiceService', () => {
  let service: OwnerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OwnerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
