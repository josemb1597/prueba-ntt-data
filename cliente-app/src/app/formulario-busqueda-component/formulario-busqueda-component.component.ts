import { Component } from '@angular/core';
import { ClienteService } from '../services/cliente.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { NgFor, NgIf } from '@angular/common';
import { Cliente } from '../models/Cliente';
import { debounceTime } from 'rxjs';
import { ClienteResumenComponentComponent } from "../cliente-resumen-component/cliente-resumen-component.component";

@Component({
  selector: 'app-formulario-busqueda-component',
  standalone: true,
  imports: [ReactiveFormsModule, NgFor, NgIf, ClienteResumenComponentComponent],
  templateUrl: './formulario-busqueda-component.component.html'
})
export class FormularioBusquedaComponentComponent {

  clienteForm: FormGroup;
  tiposDocumento = [
    { display: 'Cédula de Ciudadanía', value: 'C' },
    { display: 'Pasaporte', value: 'P' },
  ]; // Opciones para el tipo de documento
  cliente: Cliente | null = null;
  isButtonDisabled = true; // Inicialmente el botón está deshabilitado

  constructor(private clienteService: ClienteService, private fb: FormBuilder) {
    this.clienteForm = this.fb.group({
      tipoDocumento: ['', [Validators.required]],
      numeroDocumento: ['', [Validators.required, Validators.pattern(/^\d{8,11}$/)]],
    });

    // Escuchar cambios en el formulario
    this.clienteForm.valueChanges.pipe(debounceTime(300)).subscribe(() => {
      this.toggleBuscarButton();
    });
  }

  toggleBuscarButton() {
    // Habilitar o deshabilitar el botón según si el formulario es válido y ha cambiado
    this.isButtonDisabled = !(this.clienteForm.valid && this.clienteForm.dirty);
  }

  buscarCliente() {
    if (this.clienteForm.valid) {
      const { tipoDocumento, numeroDocumento } = this.clienteForm.value;

      this.isButtonDisabled = true; // Deshabilitar el botón en cuanto se haga la búsqueda

      this.clienteService.getCliente(tipoDocumento, numeroDocumento).subscribe(
        (response) => {
          this.cliente = response;
          this.isButtonDisabled = true; // Botón inactivo si la búsqueda fue exitosa
        },
        (error) => {
          console.error('Error buscando cliente:', error);
          this.cliente = null;
          this.isButtonDisabled = true; // Botón inactivo en caso de error
        }
      );
    }
  }
}