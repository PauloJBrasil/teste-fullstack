import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Beneficiario } from 'src/app/core/models/beneficiario.model';
import { Plano } from 'src/app/core/models/plano.model';

@Injectable({
  providedIn: 'root'
})
export class ApiServices {

  config = {
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    }
  }

  constructor(private http: HttpClient) {  }

  login(username: string, password: string): Observable<any> {
    return this.http.post('http://localhost:8080/usuario/login', { login: username, password })
  }

  signup(name: string, username: string, password: string): Observable<any> {
    return this.http.post('http://localhost:8080/usuario/signup', { name, login: username, password })
  }

  getUsuarios(): Observable<any> {
    return this.http.get('http://localhost:8080/usuario', this.config)
  }

  getPlanos(): Observable<Plano[]> {
    return this.http.get<Plano[]>('http://localhost:8080/plano', this.config)
  }

  getPlano(idPlano: number): Observable<Plano> {
    return this.http.get<Plano>('http://localhost:8080/plano/' + idPlano, this.config)
  }

  createPlano(plano: Plano): Observable<any> {
    return this.http.post('http://localhost:8080/plano', plano, this.config)
  }

  updateplano(plano: Plano): Observable<any> {
    return this.http.put('http://localhost:8080/plano/' + plano.id, plano, this.config)
  }

  deletePlano(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/plano/' + id, this.config)
  }

  getBeneficiarios(): Observable<Beneficiario[]> {
    return this.http.get<Beneficiario[]>('http://localhost:8080/beneficiario', this.config)
  }

  getBeneficiario(idBeneficiario: number): Observable<Beneficiario> {
    return this.http.get<Beneficiario>('http://localhost:8080/beneficiario/' + idBeneficiario, this.config)
  }

  createBeneficiario(beneficiario: Beneficiario): Observable<any> {
    return this.http.post('http://localhost:8080/beneficiario', beneficiario, this.config)
  }

  updateBeneficiario(beneficiario: Beneficiario): Observable<any> {
    return this.http.put('http://localhost:8080/beneficiario/' + beneficiario.id, beneficiario, this.config)
  }

  deleteBeneficiario(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/beneficiario/' + id, this.config)
  }

}
