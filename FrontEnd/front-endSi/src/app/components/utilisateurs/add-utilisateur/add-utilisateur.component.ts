import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {UtilisateurService} from "../../../services/utilisateur.service";
import {UtilisateurDTO} from "../../../models/utilisateur-dto";

@Component({
  selector: 'app-add-utilisateur',
  templateUrl: './add-utilisateur.component.html',
  styleUrls: ['./add-utilisateur.component.css']
})
export class AddUtilisateurComponent implements OnInit {
  utilisateurForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private utilisateurService: UtilisateurService
  ) {
    this.utilisateurForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.utilisateurForm.valid) {
      const newUser: UtilisateurDTO = this.utilisateurForm.value;
      this.utilisateurService.addUtilisateur(newUser).subscribe(
        response => {
          window.location.reload();
        },
      );
    }
  }
}
