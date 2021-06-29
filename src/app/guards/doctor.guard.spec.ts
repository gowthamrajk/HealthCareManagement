import { TestBed } from '@angular/core/testing';

import { DoctorGuard } from './doctor.guard';

describe('DoctorGuard', () => {
  let guard: DoctorGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(DoctorGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
