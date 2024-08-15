// src/app/components/add-technicien/add-technicien.component.ts

import { Component } from '@angular/core';
import {TechnicienITService} from "../../../services/technicien.service";
import {TechnicienIT} from "../../../models/technicien-it";

@Component({
  selector: 'app-add-technician',
  templateUrl: './add-technician.component.html',
  styleUrls: ['./add-technician.component.css']
})
export class AddTechnicianComponent {
  technicien: TechnicienIT = {
    username: '',
    email: '',
    password: '',
    role: undefined
  };

  constructor(private technicienITService: TechnicienITService) {}

  onSubmit() {
    this.technicienITService.createTechnicien(this.technicien).subscribe(() => {
      // Handle success (e.g., redirect or show a success message)
    });
  }
}
