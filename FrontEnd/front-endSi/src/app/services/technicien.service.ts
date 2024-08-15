

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TechnicienIT } from '../models/technicien-it';

@Injectable({
  providedIn: 'root'
})
export class TechnicienITService {
  private apiUrl = 'http://localhost:8080/api/techniciens';

  constructor(private http: HttpClient) {}

  getAllTechniciens(): Observable<TechnicienIT[]> {
    return this.http.get<TechnicienIT[]>(this.apiUrl);
  }

  getTechnicienById(id: number): Observable<TechnicienIT> {
    return this.http.get<TechnicienIT>(`${this.apiUrl}/${id}`);
  }

  createTechnicien(technicien: TechnicienIT): Observable<TechnicienIT> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<TechnicienIT>(`${this.apiUrl}/addTech`, technicien, { headers });
  }

  updateTechnicien(technicien: TechnicienIT): Observable<TechnicienIT> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.put<TechnicienIT>(`${this.apiUrl}/edit/${technicien.id}`, technicien, { headers });
  }

  deleteTechnicien(id: number): Observable<void> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers });
  }
}
