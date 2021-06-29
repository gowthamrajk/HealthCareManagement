import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedoctorsComponent } from './approvedoctors.component';

describe('ApprovedoctorsComponent', () => {
  let component: ApprovedoctorsComponent;
  let fixture: ComponentFixture<ApprovedoctorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApprovedoctorsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprovedoctorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
