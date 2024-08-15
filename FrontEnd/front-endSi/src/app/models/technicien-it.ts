
import {Role} from "./enums/role";
import {Personne} from "./personne";

export interface TechnicienIT {
  id?: number;
  username: string;
  email: string;
  password: string;
  role?: Role;
  ticketsSupport?: { idTicket: number }[];
  reports?: { idRapport: number }[];
}
