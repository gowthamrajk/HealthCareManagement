import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescriptionlistComponent } from './prescriptionlist.component';

describe('PrescriptionlistComponent', () => {
  let component: PrescriptionlistComponent;
  let fixture: ComponentFixture<PrescriptionlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrescriptionlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrescriptionlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
