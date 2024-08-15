import {TicketDeSupport} from "./ticket-de-support";
import {Personne} from "./personne";
import {Role} from "./enums/role";
export interface Utilisateur extends Personne{

  ticketsSupport: TicketDeSupport;
}
