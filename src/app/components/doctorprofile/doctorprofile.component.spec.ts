import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorprofileComponent } from './doctorprofile.component';

describe('DoctorprofileComponent', () => {
  let component: DoctorprofileComponent;
  let fixture: ComponentFixture<DoctorprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
