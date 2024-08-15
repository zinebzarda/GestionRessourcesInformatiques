// src/app/services/panne.service.ts

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Panne } from '../models/panne';

@Injectable({
  providedIn: 'root'
})
export class PanneService {
  private apiUrl = 'http://localhost:8080/api/pannes';

  constructor(private http: HttpClient) {}

  getAllPannes(): Observable<Panne[]> {
    return this.http.get<Panne[]>(this.apiUrl);
  }

  getPanneById(id: number): Observable<Panne> {
    return this.http.get<Panne>(`${this.apiUrl}/${id}`);
  }

  createPanne(panne: Panne): Observable<Panne> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<Panne>(`${this.apiUrl}/addPanne`, panne, { headers });
  }

  updatePanne(panne: Panne): Observable<Panne> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.put<Panne>(`${this.apiUrl}/edit/${panne.id}`, panne, { headers });
  }

  deletePanne(id: number): Observable<void> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers });
  }
}
