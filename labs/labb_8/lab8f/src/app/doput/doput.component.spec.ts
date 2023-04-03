import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoputComponent } from './doput.component';

describe('DoputComponent', () => {
  let component: DoputComponent;
  let fixture: ComponentFixture<DoputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoputComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
