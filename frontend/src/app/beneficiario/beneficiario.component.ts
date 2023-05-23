import { Component, OnInit } from '@angular/core';
import { ApiServices } from 'src/services/api-services.service';
import { Beneficiario } from '../core/models/beneficiario.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Plano } from '../core/models/plano.model';

@Component({
  selector: 'app-beneficiario',
  templateUrl: './beneficiario.component.html',
  styleUrls: ['./beneficiario.component.scss']
})
export class BeneficiarioComponent implements OnInit {

  constructor(
    private apiService: ApiServices,
  ) { }

    form = new FormGroup({
      nome: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      cpf: new FormControl('', Validators.required),
      idade: new FormControl(0, Validators.required),
      plano_id: new FormControl(0, Validators.required),
    });

    displayVisualizar: boolean = false;
    displayCriar: boolean = false;
    displayEditar: boolean = false;
    beneficiarios: Beneficiario[];
    planos: Plano[];
    beneficiario: Beneficiario = {
      id: 0,
      nome: '',
      cpf: '',
      email: '',
      idade: 0,
      plano_id: 0,
    };

    ngOnInit(): void {
      this.buscarBeneficiarios();
      this.buscarPlanos();
  }

  buscarPlanos() {
    this.apiService.getPlanos().subscribe((res) => {
      this.planos = res;
    })
  }

  buscarBeneficiarios() {
    this.apiService.getBeneficiarios().subscribe((res) => {
      this.beneficiarios = res;
    })
  }

  visualizarBeneficiario(beneficiario: Beneficiario) {
    this.beneficiario = beneficiario;
    this.displayVisualizar = true;
  }

  criarBeneficiario() {
    this.apiService.createBeneficiario({
      nome: this.form.get('nome')?.value!,
      email: this.form.get('email')?.value!,
      cpf: this.form.get('cpf')?.value!,
      idade: this.form.get('idade')?.value!,
      plano_id: this.form.get('plano_id')?.value!,
    }).subscribe(res => {
      this.buscarBeneficiarios();
      this.displayCriar = false;
    })
  }

  submitEditarBeneficiario() {
    this.apiService.updateBeneficiario({
      id: this.beneficiario.id!,
      nome: this.form.get('nome')?.value!,
      email: this.form.get('email')?.value!,
      cpf: this.form.get('cpf')?.value!,
      idade: this.form.get('idade')?.value!,
      plano_id: this.form.get('plano_id')?.value!,
    }).subscribe((res) => {
      this.buscarBeneficiarios();
      this.displayEditar = false;
    })
  }

  excluirBeneficiario(idBeneficiario: number) {
    this.apiService.deleteBeneficiario(idBeneficiario).subscribe(res => {
      this.buscarBeneficiarios();
    })
  }

  editarBeneficiario(beneficiario: Beneficiario) {
    this.beneficiario = beneficiario;
    this.form.setValue({
      nome: beneficiario.nome!,
      email: beneficiario.email!,
      cpf: beneficiario.cpf!,
      idade: beneficiario.idade!,
      plano_id: beneficiario.plano?.id || 0,
    });
    this.displayEditar = true;
  }

  formatCPF(cpf: any) {
    return cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
  }

}
