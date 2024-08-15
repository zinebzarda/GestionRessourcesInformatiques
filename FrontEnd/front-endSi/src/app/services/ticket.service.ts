import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TicketDeSupport } from '../models/ticket-de-support';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private apiUrl = 'http://localhost:8080/api/tickets';

  constructor(private http: HttpClient) {}

  private getToken(): string | null {
    if (typeof localStorage !== 'undefined') {
      return localStorage.getItem('token');
    } else {
      console.error('localStorage is not available');
      return null;
    }
  }

  addTicket(ticket: TicketDeSupport): Observable<TicketDeSupport> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<TicketDeSupport>(`${this.apiUrl}/addTicket`, ticket, { headers });
  }

  getAllTickets(): Observable<TicketDeSupport[]> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<TicketDeSupport[]>(`${this.apiUrl}/afficher`, { headers });
  }

  getTicketById(id: number | undefined): Observable<TicketDeSupport> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<TicketDeSupport>(`${this.apiUrl}/${id}`, { headers });
  }

  updateTicket(id: number | undefined, ticket: TicketDeSupport): Observable<TicketDeSupport> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.put<TicketDeSupport>(`${this.apiUrl}/update/${id}`, ticket, { headers });
  }

  deleteTicket(id: number | undefined): Observable<void> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers });
  }
}
