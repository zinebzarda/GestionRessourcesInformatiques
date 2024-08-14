import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PannePageComponent } from './panne-page.component';

describe('PannePageComponent', () => {
  let component: PannePageComponent;
  let fixture: ComponentFixture<PannePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PannePageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PannePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
