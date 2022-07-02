import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SctrendingComponent } from './sctrending.component';

describe('SctrendingComponent', () => {
  let component: SctrendingComponent;
  let fixture: ComponentFixture<SctrendingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SctrendingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SctrendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
