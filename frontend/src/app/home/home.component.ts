import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  constructor() { }

  images: string[] = [
    'assets/Dia das mães_Banner site.png',
    'assets/regulariza_unimed.png',
    'assets/UNIMED_URGENTE.png',
    'assets/banner_imposto de renda.png',
    'assets/banner_ona.png',
  ];

  responsiveOptions: any[] = [
    {
      breakpoint: '1024px',
      numVisible: 2,
      numScroll: 1
    },
    {
      breakpoint: '768px',
      numVisible: 1,
      numScroll: 1
    }
  ];

  redirect() {
    window.location.href = 'https://www.unimed.coop.br/site/web/unimedbelem';
  }

}
