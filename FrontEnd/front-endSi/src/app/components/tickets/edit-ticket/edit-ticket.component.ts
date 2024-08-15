import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {TicketService} from "../../../services/ticket.service";
import {TicketDeSupport} from "../../../models/ticket-de-support";

@Component({
  selector: 'app-edit-ticket',
  templateUrl: './edit-ticket.component.html',
  styleUrls: ['./edit-ticket.component.css']
})
export class EditTicketComponent implements OnInit {
  ticketId!: number;
  ticketForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private ticketService: TicketService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.ticketForm = this.fb.group({
      description: ['', Validators.required],
      etat: [''],
      utilisateur: this.fb.group({
        id: ['', Validators.required],
      }),
      technicienIT: this.fb.group({
        id: ['', Validators.required],
      }),
      panne: this.fb.group({
        idPanne: ['', Validators.required],
      }),
      dateCreation: [''],
      dateResolution: ['']
    });
  }

  ngOnInit(): void {
    this.ticketId = +this.route.snapshot.paramMap.get('id')!;
    this.loadTicket();
  }

  loadTicket(): void {
    this.ticketService.getTicketById(this.ticketId).subscribe(
      (ticket: TicketDeSupport) => {
        this.ticketForm.patchValue(ticket);
      },
      (error) => {
        console.error('Erreur lors du chargement du ticket', error);
      }
    );
  }

  updateTicket(): void {
    if (this.ticketForm.valid) {
      this.ticketService.updateTicket(this.ticketId, this.ticketForm.value).subscribe(
        () => {
          console.log('Ticket mis à jour avec succès');
          this.router.navigate(['/tickets']);
        },
        (error) => {
          console.error('Erreur lors de la mise à jour du ticket', error);
        }
      );
    }
  }
}
