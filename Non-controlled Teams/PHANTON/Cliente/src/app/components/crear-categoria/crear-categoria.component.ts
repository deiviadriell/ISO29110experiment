import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Categoria } from 'src/app/models/categoria';
import { CategoriaService } from 'src/app/services/categoria.service';

@Component({
  selector: 'app-crear-categoria',
  templateUrl: './crear-categoria.component.html',
  styleUrls: ['./crear-categoria.component.css']
})
export class CrearCategoriaComponent implements OnInit {

  categoriaForm: FormGroup;


  constructor(private fb: FormBuilder,
              private toastr: ToastrService,
              private _categoriaService:CategoriaService) {
    this.categoriaForm = this.fb.group({
      nombrecategoria: ['',Validators.required],//,Validators.maxLength(15),Validators.minLength(5)],
      descripcioncategoria: ['',Validators.required],
    })
   }

  ngOnInit(): void {
  }
  agregarCategoria(){
    console.log(this.categoriaForm)
    const CATEGORIA: Categoria ={
      nombrecategoria: this.categoriaForm.get('nombrecategoria')?.value,
      descripcioncategoria: this.categoriaForm.get('descripcioncategoria')?.value,
    }
    console.log(CATEGORIA)
    this._categoriaService.guardarCategoria(CATEGORIA).subscribe(data=>{
    this.toastr.success('La categoría se ha registrado de manera correcta', 'Categoría registrada');
    },error =>{
      console.log(error);   
      this.categoriaForm.reset();
    })
  }

}
