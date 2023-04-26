import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//componentes
import { CrearCategoriaComponent } from './components/crear-categoria/crear-categoria.component';
import { CrearPreguntaComponent } from './components/crear-pregunta/crear-pregunta.component';
import { RegistroUsuarioComponent } from './components/registro-usuario/registro-usuario.component';
import { UsuarioComponent } from './components/usuario/usuario.component';


const routes: Routes = [
  {path: '',component: UsuarioComponent},
  {path: 'registro-usuario',component: RegistroUsuarioComponent},
  {path: 'crear-categoria',component: CrearCategoriaComponent},
  {path: 'crear-pregunta',component: CrearPreguntaComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
