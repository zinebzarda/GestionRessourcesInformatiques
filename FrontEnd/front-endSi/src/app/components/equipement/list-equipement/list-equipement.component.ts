import { Component } from '@angular/core';
import {Equipement} from "../../../models/equipement";
import {EquipementService} from "../../../services/equipement.service";


@Component({
  selector: 'app-list-equipements',
  templateUrl: './list-equipement.component.html',
  styleUrls: ['./list-equipement.component.css']
})
export class ListEquipementsComponent {
  equipements: Equipement[] = [];

  constructor(private equipementService: EquipementService) {
    this.loadEquipements();
  }

  loadEquipements() {
    this.equipementService.getAllEquipements().subscribe(data => {
      this.equipements = data;
    });
  }
//  delete
  deleteEquipement(id: number | undefined) {
    this.equipementService.deleteEquipement(id).subscribe(() => {
      this.loadEquipements();
    });
  }


}
