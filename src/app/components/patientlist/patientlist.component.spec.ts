import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientlistComponent } from './patientlist.component';

describe('PatientlistComponent', () => {
  let component: PatientlistComponent;
  let fixture: ComponentFixture<PatientlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
