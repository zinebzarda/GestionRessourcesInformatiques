
import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Panne } from '../../../models/panne';
import { PanneService } from '../../../services/panne.service';

@Component({
  selector: 'app-edit-panne',
  templateUrl: './edit-panne.component.html',
  styleUrls: ['./edit-panne.component.css']
})
export class EditPanneComponent {
  @Input() panne: Panne | null = null;
  @Output() closePopup = new EventEmitter<void>();

  constructor(private panneService: PanneService) {}

  onSubmit() {
    if (this.panne) {
      this.panneService.updatePanne(this.panne).subscribe(() => {
        this.closePopup.emit();
      });
    }
  }

  closePopupMethod() {
    this.closePopup.emit();
  }
}
