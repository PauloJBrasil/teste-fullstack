import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioModule } from './usuario/usuario.module';
import { AuthService } from 'src/services/auth.service';
import { ApiServices } from 'src/services/api-services.service';
import { HttpClientModule } from '@angular/common/http';
import {MenubarModule} from 'primeng/menubar';
import { HomeComponent } from './home/home.component';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { JwtModule } from '@auth0/angular-jwt';
import { CoreModule } from './core/core.module';
import { BeneficiarioComponent } from './beneficiario/beneficiario.component';
import { TableModule } from 'primeng/table';
import { CardModule } from 'primeng/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';
import { DividerModule } from 'primeng/divider';
import { DialogModule } from 'primeng/dialog';
import { InputNumberModule } from 'primeng/inputnumber';
import { ListarComponent } from './plano/listar.component';
import { InputMaskModule } from 'primeng/inputmask';
import { DropdownModule } from 'primeng/dropdown';
import { CarouselModule } from 'primeng/carousel';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BeneficiarioComponent,
    ListarComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    UsuarioModule,
    HttpClientModule,
    MenubarModule,
    InputTextModule,
    ButtonModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: () => {
          return localStorage.getItem('token');
        }
      }
    }),
    CoreModule,
    TableModule,
    CardModule,
    FormsModule,
    ReactiveFormsModule,
    PasswordModule,
    DividerModule,
    DialogModule,
    InputNumberModule,
    InputMaskModule,
    DropdownModule,
    CarouselModule
  ],
  providers: [
    AuthService,
    ApiServices
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
