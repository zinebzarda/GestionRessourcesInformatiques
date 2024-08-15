import {TicketDeSupport} from "./ticket-de-support";
import {Personne} from "./personne";
import {Role} from "./enums/role";
export interface Utilisateur {
  id?: number;
  username: string;
  email: string;
  password: string;
  role?: Role;
  ticketsSupport?: { idTicket: number }[];
}
