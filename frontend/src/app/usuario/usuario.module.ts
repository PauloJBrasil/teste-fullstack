import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { DividerModule } from 'primeng/divider';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UsuarioRoutingModule } from './usuario-routing.module';


@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent
  ],
  imports: [
    UsuarioRoutingModule,
    CardModule,
    InputTextModule,
    FormsModule,
    ReactiveFormsModule,
    PasswordModule,
    DividerModule,
    ButtonModule,
    CommonModule,
  ],
  exports: [
    UsuarioRoutingModule,
    LoginComponent,
    SignupComponent
  ],
})
export class UsuarioModule { }
