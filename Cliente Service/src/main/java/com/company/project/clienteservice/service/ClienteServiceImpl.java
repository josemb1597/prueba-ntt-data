package com.company.project.clienteservice.service;

import com.company.project.clienteservice.entity.Cliente;
import com.company.project.clienteservice.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Busca un cliente en la base de datos por tipo y número de documento.
     *
     * @param tipoDocumento    Tipo de documento (C o P)
     * @param numeroDocumento  Número de documento
     * @return Cliente si existe, vacío en caso contrario.
     */

    @Override
    public Optional<Cliente> getCliente(Cliente.TipoDocumento tipoDocumento, String numeroDocumento) {
        return clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
    }

}
