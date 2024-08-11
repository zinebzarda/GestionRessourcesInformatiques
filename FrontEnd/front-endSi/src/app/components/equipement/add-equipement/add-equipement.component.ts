import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipementService } from '../../../services/equipement.service';
import { Router } from '@angular/router';
import { EtatEquipement } from '../../../models/enums/etat-equipement';
import { Equipement } from "../../../models/equipement";

@Component({
  selector: 'app-add-equipement',
  templateUrl: './add-equipement.component.html',
  styleUrls: ['./add-equipement.component.css']
})
export class AddEquipementComponent implements OnInit {
  equipementForm!: FormGroup;
  etatOptions = Object.values(EtatEquipement);

  constructor(
    private fb: FormBuilder,
    private equipementService: EquipementService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.equipementForm = this.fb.group({
      nom: ['', Validators.required],
      description: ['', Validators.required],
      etat: ['', Validators.required],
      dateAcquisition: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.equipementForm.valid) {
      const equipement: Equipement = this.equipementForm.value;
      this.equipementService.addEquipement(equipement).subscribe(
        response => {
          console.log('Equipment added successfully');
          // Redirect to the list page after adding
          this.router.navigate(['/list-equipements']); // Remplace '/list-equipements' par le chemin réel de la liste
        },
        error => {
          console.error('Error creating equipment:', error);
          if (error.status === 403) {
            console.log('Access Denied. Admin privileges required.');
          }
        }
      );
    }
  }
}
