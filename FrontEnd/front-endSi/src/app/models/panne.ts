import {Equipement} from "./equipement";
import {TicketDeSupport} from "./ticket-de-support";

export interface Panne {
  id?: number;
  description: string;
  datePanne: string;
  resolu: boolean;
  equipement: { idEquipement: number };
  tickets?: { idTicket: number }[];
}

