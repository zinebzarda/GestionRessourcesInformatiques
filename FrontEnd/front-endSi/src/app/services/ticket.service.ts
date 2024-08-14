import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
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

  private handleError(error: HttpErrorResponse) {

    console.error('An error occurred:', error.message);
    return throwError('Something went wrong; please try again later.');
  }

  addTicket(ticket: TicketDeSupport): Observable<TicketDeSupport> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<TicketDeSupport>(`${this.apiUrl}/addTicket`, ticket, { headers })
      .pipe(
        catchError(this.handleError)
      );
  }


  getAllTickets(): Observable<TicketDeSupport[]> {
    const token = this.getToken();
    console.log('Token:', token);
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<TicketDeSupport[]>(`${this.apiUrl}/afficher`, { headers })
      .pipe(
        catchError(this.handleError)
      );


  }

  getTicketById(id: number): Observable<TicketDeSupport> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<TicketDeSupport>(`${this.apiUrl}/${id}`, { headers })
      .pipe(
        catchError(this.handleError)
      );
  }

  updateTicket(id: number, ticket: TicketDeSupport): Observable<TicketDeSupport> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.put<TicketDeSupport>(`${this.apiUrl}/update/${id}`, ticket, { headers })
      .pipe(
        catchError(this.handleError)
      );
  }

  deleteTicket(id: number): Observable<void> {
    const token = this.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers })
      .pipe(
        catchError(this.handleError)
      );
  }
}
