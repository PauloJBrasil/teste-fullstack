import { Plano } from "./plano.model";

export interface Beneficiario {
  id?: number;
  nome: string;
  cpf: string;
  email: string;
  idade: number;
  plano_id: number;
  plano?: Plano;
}
