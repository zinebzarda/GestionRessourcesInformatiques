import { EtatTicket } from './enums/etat-ticket';
import {Panne} from "./panne";
import {TechnicienIT} from "./technicien-it";
import {Utilisateur} from "./utilisateur";

export interface TicketDeSupport {
  id: number;
  description: string;
  etat: EtatTicket;
  dateCreation: string;
  dateResolution: string;
  utilisateur:Utilisateur ;
  technicienIT:TechnicienIT ;
  panne: Panne;
}
