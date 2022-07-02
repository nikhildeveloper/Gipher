import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GifsTrendComponent } from './gifs-trend.component';

describe('GifsTrendComponent', () => {
  let component: GifsTrendComponent;
  let fixture: ComponentFixture<GifsTrendComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GifsTrendComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GifsTrendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
