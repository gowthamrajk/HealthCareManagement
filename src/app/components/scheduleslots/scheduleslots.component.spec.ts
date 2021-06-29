import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleslotsComponent } from './scheduleslots.component';

describe('ScheduleslotsComponent', () => {
  let component: ScheduleslotsComponent;
  let fixture: ComponentFixture<ScheduleslotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleslotsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleslotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
