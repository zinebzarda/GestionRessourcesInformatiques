import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipement } from "../models/equipement";

@Injectable({
  providedIn: 'root'
})
export class EquipementService {
  private apiUrl = 'http://localhost:8080/api/equipements/addEqui';

  constructor(private http: HttpClient) {}

  addEquipement(equipement: Equipement): Observable<Equipement> {
    const token = localStorage.getItem('token'); // hna khass token ykoun localStorage
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}` // hna khass tssifti token f header
    });

    return this.http.post<Equipement>(this.apiUrl, equipement, { headers: headers });
  }
}
