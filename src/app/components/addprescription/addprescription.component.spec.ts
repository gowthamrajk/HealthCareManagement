import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddprescriptionComponent } from './addprescription.component';

describe('AddprescriptionComponent', () => {
  let component: AddprescriptionComponent;
  let fixture: ComponentFixture<AddprescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddprescriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddprescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
