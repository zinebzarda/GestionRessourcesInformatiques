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

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

  getAllPannes(): Observable<Panne[]> {
    return this.http.get<Panne[]>(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  getPanneById(id: number): Observable<Panne> {
    return this.http.get<Panne>(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  createPanne(panne: Panne): Observable<Panne> {
    return this.http.post<Panne>(`${this.apiUrl}/addPanne`, panne, { headers: this.getAuthHeaders() });
  }

  updatePanne(panne: Panne): Observable<Panne> {
    return this.http.put<Panne>(`${this.apiUrl}/edit/${panne.id}`, panne, { headers: this.getAuthHeaders() });
  }

  deletePanne(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers: this.getAuthHeaders() });
  }
}
