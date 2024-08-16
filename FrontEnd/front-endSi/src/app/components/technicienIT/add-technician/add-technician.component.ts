// src/app/components/add-technicien/add-technicien.component.ts

import {Component, OnInit} from '@angular/core';
import {TechnicienITService} from "../../../services/technicien.service";
import {TechnicienIT} from "../../../models/technicien-it";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-add-technician',
  templateUrl: './add-technician.component.html',
  styleUrls: ['./add-technician.component.css']
})
export class AddTechnicianComponent implements OnInit{
  technicienForm!:FormGroup
  constructor(private technicienITService: TechnicienITService, private fb:FormBuilder) {}

  ngOnInit() {
    this.technicienForm=this.fb.group({
      username: '',
      email: '',
      password: '',
      role: ''
    })
  }

  onSubmit() {
    const technicien:TechnicienIT=this.technicienForm.value;
    this.technicienITService.createTechnicien(technicien).subscribe(() => {
      window.location.reload()
    });
  }
}

