import { ApiServices } from './api-services.service';
import { LoginComponent } from './../app/usuario/login/login.component';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { BehaviorSubject } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this._isLoggedIn$.asObservable();

  constructor(
    private apiService: ApiServices,
    public jwtHelper: JwtHelperService
    ) {
    const token = localStorage.getItem('token');
    this._isLoggedIn$.next(!!token);
  }

  isAuthenticated() {
    const token = localStorage.getItem('token');
    return !this.jwtHelper.isTokenExpired(token);
  }

  login(username: string, password: string) {
    return this.apiService.login(username, password).pipe(
      tap(response => {
        localStorage.setItem('token', response.token)
        this._isLoggedIn$.next(true);
      })
    );
  }

  logout() {
    localStorage.removeItem('token');
    this._isLoggedIn$.next(false);
  }
}
