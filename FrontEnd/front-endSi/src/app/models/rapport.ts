import {TypeRapport} from "./enums/type-rapport";
import {AdministrateurIT} from "./administrateur-it";
import {TechnicienIT} from "./technicien-it";

export interface Rapport {
  id: number;
  type: TypeRapport;
  dateGeneration: Date;
  contenu: string;
  administrateurIT: AdministrateurIT;
  technicienIT: TechnicienIT;
}
