import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem, PrimeNGConfig } from 'primeng/api';
import { AuthService } from 'src/services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Unimed Belém';
  items: MenuItem[];

  constructor(
    private primengConfig: PrimeNGConfig,
    public authService: AuthService,
    public router: Router,
    ) {}

  ngOnInit() {
    this.primengConfig.ripple = true;
    this.items = [
      {
        label: 'Home',
        icon: 'pi pi-fw pi-home',
        routerLink: '/home'
      },
      {
        label: 'Plano',
        icon: 'pi pi-fw pi-money-bill',
        routerLink: '/plano'
      },
      {
        label: 'Beneficiário',
        icon: 'pi pi-fw pi-users',
        routerLink: '/beneficiario'
      }
    ]
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/usuario/login']);
  }
}
