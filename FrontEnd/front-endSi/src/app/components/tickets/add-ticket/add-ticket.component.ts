import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EtatTicket } from '../../../models/enums/etat-ticket';
import { TicketService } from '../../../services/ticket.service';
import { TicketDeSupport } from '../../../models/ticket-de-support';
import {Panne} from "../../../models/panne";

@Component({
  selector: 'app-add-ticket',
  templateUrl: './add-ticket.component.html',
  styleUrls: ['./add-ticket.component.css']
})
export class AddTicketComponent implements OnInit {
  ticketForm!: FormGroup;
  etatOptions = Object.values(EtatTicket);

  constructor(
    private fb: FormBuilder,
    private ticketService: TicketService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.ticketForm = this.fb.group({
      description: ['', Validators.required],
      etat: ['', Validators.required],
      dateCreation: [new Date(), Validators.required],
      dateResolution: ['']
    });
  }

  onSubmit(): void {
    if (this.ticketForm.valid) {
      const ticket: TicketDeSupport = this.ticketForm.value;
      console.log('Ticket à envoyer:', ticket);
      this.ticketService.addTicket(ticket).subscribe(
        () => {
          window.location.reload()
        },
      );
    }
  }

}
