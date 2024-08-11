import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Equipement} from "../models/equipement";

@Injectable({
  providedIn: 'root'
})
export class EquipementService {
  private apiUrl = 'http://localhost:8080/api/equipements';

  constructor(private http: HttpClient) {}

// add
  addEquipement(equipement: Equipement): Observable<Equipement> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });

    return this.http.post<Equipement>(`${this.apiUrl}/addEqui`, equipement, { headers });
  }

// show
  getAllEquipements(): Observable<Equipement[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get<Equipement[]>(`${this.apiUrl}`, { headers });
  }

  // delete

  deleteEquipement(id: number): Observable<void> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers });
  }



}
