import { TestBed } from '@angular/core/testing';

import { CardioService } from './cardio.service';

describe('CardioService', () => {
  let service: CardioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
