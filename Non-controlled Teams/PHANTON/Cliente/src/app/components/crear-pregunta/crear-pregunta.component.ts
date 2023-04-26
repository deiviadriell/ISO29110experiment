
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Categoria } from 'src/app/models/categoria';
import { Pregunta } from 'src/app/models/pregunta';
import { CategoriaService } from 'src/app/services/categoria.service';
import { PreguntaService } from 'src/app/services/pregunta.service';


@Component({
  selector: 'app-crear-pregunta',
  templateUrl: './crear-pregunta.component.html',
  styleUrls: ['./crear-pregunta.component.css']
})

export class CrearPreguntaComponent implements OnInit {
  listCategorias: Categoria[] = [];
  preguntaForm:FormGroup;
  titulo = 'Crear pregunta';
  id: string | null;
  
  constructor(private fb: FormBuilder,
    private router: Router,
    private toastr: ToastrService,
    private _preguntaService: PreguntaService,
    private aRouter: ActivatedRoute,
    private _categoriaService:CategoriaService) { 
    this.preguntaForm= this.fb.group({
      nombre: [''],
      categoria: ['', Validators.nullValidator],
      pregunta: ['', Validators.required]
    })
    this.id = this.aRouter.snapshot.paramMap.get('id');
    this._categoriaService.getCategorias().subscribe(data => {
      console.log(data);
       this.listCategorias = data;
     }, error => {
       console.log(error);
     })}

  ngOnInit(): void {
  }

  agregarPregunta() {

    const PREGUNTA: Pregunta = {
      nombre: this.preguntaForm.get('nombre')?.value,
      categoria: this.preguntaForm.get('categoria')?.value,
      pregunta: this.preguntaForm.get('pregunta')?.value,
    }

    this._preguntaService.guardarPregunta(PREGUNTA).subscribe(data => {
      this.toastr.success('La pregunta fue registrada con exito!', 'Pregunta Registrada!');
      this.router.navigate(['/']);
    }, error => {
      console.log(error);
      this.preguntaForm.reset();
    })
}
obtenerCategoria() {
  this._categoriaService.getCategorias().subscribe(data => {
 console.log(data);
  this.listCategorias = data;
}, error => {
  console.log(error);
})
}
}
 