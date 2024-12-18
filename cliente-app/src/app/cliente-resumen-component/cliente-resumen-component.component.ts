import { Component, Input } from '@angular/core';
import { Cliente } from '../models/Cliente';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-cliente-resumen-component',
  standalone: true,
  imports: [NgIf],
  templateUrl: './cliente-resumen-component.component.html'
})
export class ClienteResumenComponentComponent {
  @Input() cliente: Cliente | null = null;
  
}
