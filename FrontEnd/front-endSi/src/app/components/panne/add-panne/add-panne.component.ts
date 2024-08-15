// src/app/components/add-panne/add-panne.component.ts

import {Component, OnInit} from '@angular/core';
import {Panne} from "../../../models/panne";
import {PanneService} from "../../../services/panne.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Equipement} from "../../../models/equipement";
import {TicketDeSupport} from "../../../models/ticket-de-support";

@Component({
  selector: 'app-add-panne',
  templateUrl: './add-panne.component.html',
  styleUrls: ['./add-panne.component.css']
})
export class AddPanneComponent implements OnInit{
  panneForm!:FormGroup
  constructor(private panneService: PanneService,private fb:FormBuilder) {}
  ngOnInit(): void {
    this.panneForm=this.fb.group({
        description:'',
        datePanne:'',
        resolu:'',
        equipement:''
    })
  }
  onSubmit() {
    const panne:Panne=this.panneForm.value;
    this.panneService.createPanne(panne).subscribe(() => {
    });
  }
}
