// src/app/components/list-techniciens/list-techniciens.component.ts

import { Component } from '@angular/core';
import {TechnicienIT} from "../../../models/technicien-it";
import {TechnicienITService} from "../../../services/technicien.service";

@Component({
  selector: 'app-list-technician',
  templateUrl: './list-technician.component.html',
  styleUrls: ['./list-technician.component.css']
})
export class ListTechnicianComponent {
  techniciens: TechnicienIT[] = [];
  showEditPopup = false;
  selectedTechnicien: TechnicienIT | null = null;

  constructor(private technicienITService: TechnicienITService) {
    this.loadTechniciens();
  }

  loadTechniciens() {
    this.technicienITService.getAllTechniciens().subscribe(data => {
      this.techniciens = data;
    });
  }

  deleteTechnicien(id: number | undefined) {
    if (id) {
      this.technicienITService.deleteTechnicien(id).subscribe(() => {
        this.loadTechniciens();
      });
    }
  }

  openEditPopup(technicien: TechnicienIT) {
    this.selectedTechnicien = technicien;
    this.showEditPopup = true;
  }

  closeEditPopup() {
    this.showEditPopup = false;
    this.selectedTechnicien = null;
    this.loadTechniciens();
  }
}
