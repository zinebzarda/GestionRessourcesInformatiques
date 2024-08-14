import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowPanneComponent } from './show-panne.component';

describe('ShowPanneComponent', () => {
  let component: ShowPanneComponent;
  let fixture: ComponentFixture<ShowPanneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowPanneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowPanneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
