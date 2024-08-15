// src/app/components/list-pannes/list-pannes.component.ts

import { Component } from '@angular/core';
import {Panne} from "../../../models/panne";
import {PanneService} from "../../../services/panne.service";

@Component({
  selector: 'app-list-panne',
  templateUrl: './list-panne.component.html',
  styleUrls: ['./list-panne.component.css']
})
export class ListPanneComponent {
  pannes: Panne[] = [];
  showEditPopup = false;
  selectedPanne: Panne | null = null;

  constructor(private panneService: PanneService) {
    this.loadPannes();
  }

  loadPannes() {
    this.panneService.getAllPannes().subscribe(data => {
      this.pannes = data;
    });
  }

  deletePanne(id: number | undefined) {
    if (id) {
      this.panneService.deletePanne(id).subscribe(() => {
        this.loadPannes();
      });
    }
  }

  openEditPopup(panne: Panne) {
    this.selectedPanne = panne;
    this.showEditPopup = true;
  }

  closeEditPopup() {
    this.showEditPopup = false;
    this.selectedPanne = null;
    this.loadPannes();
  }
}
