
import {Personne} from "./personne";

export interface AdministrateurIT extends Personne{
  reports: Report;
  notifications: Notification;
}

