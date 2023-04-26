import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import { CrearCategoriaComponent } from './components/crear-categoria/crear-categoria.component';
import { CrearPreguntaComponent } from './components/crear-pregunta/crear-pregunta.component';
import { RegistroUsuarioComponent } from './components/registro-usuario/registro-usuario.component';
import { UsuarioComponent } from './components/usuario/usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    CrearCategoriaComponent,
    CrearPreguntaComponent,
    RegistroUsuarioComponent,
    UsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
  
})
export class AppModule { }
