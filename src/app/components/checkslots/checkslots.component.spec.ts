import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckslotsComponent } from './checkslots.component';

describe('CheckslotsComponent', () => {
  let component: CheckslotsComponent;
  let fixture: ComponentFixture<CheckslotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckslotsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckslotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
