import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimaryloginComponent } from './primarylogin.component';

describe('PrimaryloginComponent', () => {
  let component: PrimaryloginComponent;
  let fixture: ComponentFixture<PrimaryloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrimaryloginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrimaryloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
