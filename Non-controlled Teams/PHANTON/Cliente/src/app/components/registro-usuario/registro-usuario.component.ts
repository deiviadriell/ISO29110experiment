import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RegistroUsuario} from 'src/app/models/registrousuario'
import { RegistrousuarioService } from 'src/app/services/registrousuario.service';


@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {

  registroForm: FormGroup;


  constructor(private fb: FormBuilder, private router:Router, private toastr: ToastrService, private _registrousuario: RegistrousuarioService) {
    this.registroForm = this.fb.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      correo: ['', Validators.required],
      contrasena: ['', Validators.required],
    })
  }

  ngOnInit(): void {
  }

  agregarUsuario(){


  const REGISTRO: RegistroUsuario = {
    nombre:this.registroForm.get('nombre')?.value,
    apellido:this.registroForm.get('apellido')?.value,
    correo:this.registroForm.get('correo')?.value,
    contrasena:this.registroForm.get('contrasena')?.value,
    }

  console.log(REGISTRO)
  this._registrousuario.guardarRegistro(REGISTRO).subscribe(data => {
  this.toastr.success('El usuario fue registrado exitosamente','Usuario Registrado!')
  this.router.navigate([''])
  }, error => {
    console.log(error);
    this.registroForm.reset();
  } );
  


  }




}
