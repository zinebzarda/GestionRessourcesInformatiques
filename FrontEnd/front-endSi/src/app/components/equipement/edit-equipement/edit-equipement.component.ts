import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Equipement } from "../../../models/equipement";
import { EquipementService } from "../../../services/equipement.service";

@Component({
  selector: 'app-edit-equipement',
  templateUrl: './edit-equipement.component.html',
  styleUrls: ['./edit-equipement.component.css']
})
export class EditEquipementComponent {
  @Input() equipement: Equipement | null = null;
  @Output() closePopup = new EventEmitter<void>();

  constructor(private equipementService: EquipementService) {}

  onSubmit() {
    if (this.equipement) {
      this.equipementService.updateEquipement(this.equipement).subscribe(() => {
        this.closePopup.emit();
      });
    }
  }

  closePopupMethod() {
    this.closePopup.emit();
  }
}
