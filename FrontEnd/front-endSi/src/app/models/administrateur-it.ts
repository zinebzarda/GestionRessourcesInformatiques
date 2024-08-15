
import {Role} from "./enums/role";

export interface AdministrateurIT {
  id?: number;
  username: string;
  email: string;
  password: string;
  role?: Role;
  reports?: { idRapport: number }[];
  notifications?: { idNotification: number }[];
}

