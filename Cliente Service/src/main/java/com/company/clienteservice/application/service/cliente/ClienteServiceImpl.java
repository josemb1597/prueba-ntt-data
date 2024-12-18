package com.company.clienteservice.application.service.cliente;

import com.company.clienteservice.application.dto.response.ClienteResponseDTO;
import com.company.clienteservice.application.service.cliente.ClienteService;
import com.company.clienteservice.domain.enums.TipoDocumento;
import com.company.clienteservice.infrastructure.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    /**
     * Busca un cliente en la base de datos por tipo y número de documento.
     *
     * @param tipoDocumento    Tipo de documento (C o P)
     * @param numeroDocumento  Número de documento
     * @return Cliente si existe, vacío en caso contrario.
     */

    @Override
    public Optional<ClienteResponseDTO> getCliente(TipoDocumento tipoDocumento, String numeroDocumento) {
        log.info("Buscando cliente con tipoDocumento={} y numeroDocumento={}", tipoDocumento, numeroDocumento);
        return clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento)
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getPrimerNombre(),
                        cliente.getSegundoNombre(),
                        cliente.getPrimerApellido(),
                        cliente.getSegundoApellido(),
                        cliente.getTelefono(),
                        cliente.getDireccion(),
                        cliente.getCiudadResidencia()
                ));
    }

}
