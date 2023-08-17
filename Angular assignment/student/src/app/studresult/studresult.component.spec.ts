import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudresultComponent } from './studresult.component';

describe('StudresultComponent', () => {
  let component: StudresultComponent;
  let fixture: ComponentFixture<StudresultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudresultComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
