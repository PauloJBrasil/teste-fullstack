import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Plano } from 'src/app/core/models/plano.model';
import { ApiServices } from 'src/services/api-services.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss']
})
export class ListarComponent implements OnInit {

  constructor(
    private apiService: ApiServices,
    private router: Router,
  ) { }

  form = new FormGroup({
    nome: new FormControl('', Validators.required),
    valor: new FormControl(0, Validators.required),
  });

  planos: Plano[];
  plano: Plano = {
    id: null,
    nome: null,
    valor: null
  };
  displayVisualizar: boolean = false;
  displayCriar: boolean = false;
  displayEditar: boolean = false;

  ngOnInit(): void {
    this.buscarPlanos();
  }

  buscarPlanos() {
    this.apiService.getPlanos().subscribe(
      (data) => {
        this.planos = data;
      }
    )
  }

  criarPlano() {
    this.apiService.createPlano({
      nome: this.form.get('nome')?.value!,
      valor: this.form.get('valor')?.value!
    }).subscribe(res => {
      this.buscarPlanos();
      this.displayCriar = false;
    });
  }

  visualizarPlano(plano: Plano) {
    this.plano = plano;
    this.displayVisualizar = true;
  }

  editarPlano(plano: Plano) {
    this.plano = plano;
    this.form.setValue({
      nome: plano.nome!,
      valor: plano.valor!
    });
    this.displayEditar = true;
  }

  submitEditarPlano() {
    this.apiService.updateplano({
      id: this.plano.id!,
      nome: this.form.get('nome')?.value!,
      valor: this.form.get('valor')?.value!
    }).subscribe(res => {
      this.buscarPlanos();
      this.displayEditar = false;
    });
  }

  excluirPlano(id: number) {
    this.apiService.deletePlano(id).subscribe(res => {
      this.buscarPlanos();
    })
  }
}
