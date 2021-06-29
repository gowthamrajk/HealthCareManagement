import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookappointmentComponent } from './bookappointment.component';

describe('BookappointmentComponent', () => {
  let component: BookappointmentComponent;
  let fixture: ComponentFixture<BookappointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookappointmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookappointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
