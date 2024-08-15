import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {TicketDeSupport} from "../../../models/ticket-de-support";
import {EtatTicket} from "../../../models/enums/etat-ticket";
import {TicketService} from "../../../services/ticket.service";

@Component({
  selector: 'app-edit-ticket',
  templateUrl: './edit-ticket.component.html',
  styleUrls: ['./edit-ticket.component.css']
})
export class EditTicketComponent implements OnInit {
  editTicketForm: FormGroup;
  ticket: TicketDeSupport | undefined;
  etats = Object.values(EtatTicket);

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private ticketService: TicketService
  ) {
    this.editTicketForm = this.fb.group({
      description: [''],
      etat: [''],
      dateResolution: [''],
      utilisateur: [''],
      technicienIT: [''],
      panne: ['']
    });
  }

  ngOnInit(): void {
    const ticketId = this.route.snapshot.paramMap.get('id');
    if (ticketId) {
      this.ticketService.getTicketById(Number(ticketId)).subscribe((data: TicketDeSupport) => {
        this.ticket = data;
        this.editTicketForm.patchValue({
          description: data.description,
          etat: data.etat,
          dateResolution: data.dateResolution,
          utilisateur: data.utilisateur.id,
          technicienIT: data.technicienIT.id,
          panne: data.panne.description
        });
      });
    }
  }

  onSubmit(): void {
    if (this.ticket) {
      const updatedTicket: TicketDeSupport = {
        ...this.ticket,
        ...this.editTicketForm.value
      };

      this.ticketService.updateTicket(this.ticket.id, updatedTicket).subscribe(() => {
        this.router.navigate(['/admin-dashboard/Ticket-page']);
      });
    }
  }
}
