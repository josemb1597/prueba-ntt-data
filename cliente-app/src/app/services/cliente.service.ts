import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private baseUrl = 'http://localhost:8090/clientes';

  constructor(private http: HttpClient) {}

  getCliente(tipoDocumento: string, numeroDocumento: string): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.baseUrl}/${tipoDocumento}/${numeroDocumento}`);
}

}
