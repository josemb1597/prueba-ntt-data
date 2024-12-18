package com.company.clienteservice.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO para encapsular los datos de respuesta de un cliente.
 */

@Data
@AllArgsConstructor
public class ClienteResponseDTO {

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadResidencia;

}
