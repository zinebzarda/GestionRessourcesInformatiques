import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPanneComponent } from './edit-panne.component';

describe('EditPanneComponent', () => {
  let component: EditPanneComponent;
  let fixture: ComponentFixture<EditPanneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditPanneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditPanneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
