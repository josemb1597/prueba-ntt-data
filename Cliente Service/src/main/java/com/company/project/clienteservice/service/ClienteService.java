package com.company.project.clienteservice.service;

import com.company.project.clienteservice.entity.Cliente;

import java.util.Optional;

public interface ClienteService {

    /**
     * Busca un cliente en la base de datos por tipo y número de documento.
     *
     * @param tipoDocumento    Tipo de documento (C o P)
     * @param numeroDocumento  Número de documento
     * @return Cliente si existe, vacío en caso contrario.
     */
    Optional<Cliente> getCliente(Cliente.TipoDocumento tipoDocumento, String numeroDocumento);
}
