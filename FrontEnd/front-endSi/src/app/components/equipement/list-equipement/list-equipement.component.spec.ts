import { ComponentFixture, TestBed } from '@angular/core/testing';
import {ListEquipementsComponent} from "./list-equipement.component";


describe('ListEquipementComponent', () => {
  let component: ListEquipementsComponent;
  let fixture: ComponentFixture<ListEquipementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListEquipementsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListEquipementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
