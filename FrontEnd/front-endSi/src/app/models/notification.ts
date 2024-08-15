import {AdministrateurIT} from "./administrateur-it";

export interface Notification {
  id?: number;
  message: string;
  dateEnvoi: string;
  lu: boolean;
  administrateurIT: AdministrateurIT;
}

