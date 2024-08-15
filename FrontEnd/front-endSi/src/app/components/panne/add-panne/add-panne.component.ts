// src/app/components/add-panne/add-panne.component.ts

import { Component } from '@angular/core';
import {Panne} from "../../../models/panne";
import {PanneService} from "../../../services/panne.service";

@Component({
  selector: 'app-add-panne',
  templateUrl: './add-panne.component.html',
  styleUrls: ['./add-panne.component.css']
})
export class AddPanneComponent {
  panne: Panne = {
    description: '',
    datePanne: '',
    resolu: false,
    equipement: { idEquipement: 0 }
  };

  constructor(private panneService: PanneService) {}

  onSubmit() {
    this.panneService.createPanne(this.panne).subscribe(() => {
      // Handle success (e.g., redirect or show a success message)
    });
  }
}
