import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from 'src/services/auth.guard';
import { ListarComponent } from './plano/listar.component';
import { BeneficiarioComponent } from './beneficiario/beneficiario.component';

const routes: Routes = [
  { path: "usuario", loadChildren: () => import('src/app/usuario/usuario.module').then(m => m.UsuarioModule) },
  { path: "plano", component: ListarComponent, canActivate: [AuthGuard]},
  { path: "beneficiario", component: BeneficiarioComponent, canActivate: [AuthGuard]},
  { path: "home", component: HomeComponent, canActivate: [AuthGuard]},
  {
    path: "",
    pathMatch: 'full',
    redirectTo: 'usuario/login',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
