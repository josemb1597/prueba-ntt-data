package com.company.clienteservice.application.service.cliente;

import com.company.clienteservice.application.dto.response.ClienteResponseDTO;
import com.company.clienteservice.domain.enums.TipoDocumento;

import java.util.Optional;

public interface ClienteService {

    /**
     * Busca un cliente en la base de datos por tipo y número de documento.
     *
     * @param tipoDocumento    Tipo de documento (C o P)
     * @param numeroDocumento  Número de documento
     * @return Cliente si existe, vacío en caso contrario.
     */
    Optional<ClienteResponseDTO> getCliente(TipoDocumento tipoDocumento, String numeroDocumento);
}
