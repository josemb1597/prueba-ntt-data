import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormularioBusquedaComponentComponent } from "./formulario-busqueda-component/formulario-busqueda-component.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormularioBusquedaComponentComponent],
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'cliente-app';
}
