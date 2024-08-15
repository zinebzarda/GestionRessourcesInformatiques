
import {Role} from "./enums/role";
import {Personne} from "./personne";
import {TicketDeSupport} from "./ticket-de-support";

export interface TechnicienIT extends Personne{
  ticketsSupport: TicketDeSupport;
  reports: Report;
}
