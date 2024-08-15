import { EtatTicket } from './enums/etat-ticket';

export interface TicketDeSupport {
  id?: number;
  description: string;
  etat?: EtatTicket;
  dateCreation?: string;
  dateResolution?: string;
  utilisateur?: { id: number };
  technicienIT?: { id: number };
  panne: { idPanne: number };
}
