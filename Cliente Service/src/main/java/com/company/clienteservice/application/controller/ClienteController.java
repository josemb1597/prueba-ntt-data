package com.company.clienteservice.application.controller;

import com.company.clienteservice.application.dto.response.ClienteResponseDTO;
import com.company.clienteservice.domain.enums.TipoDocumento;
import com.company.clienteservice.application.service.cliente.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    /**
     * Endpoint para consultar un cliente por tipo y número de documento.
     *
     * @param tipoDocumento   Tipo de documento (C o P)
     * @param numeroDocumento Número de documento
     * @return ClienteResponseDTO si existe, o NotFound si no se encuentra.
     */

    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<ClienteResponseDTO> getCliente(@PathVariable("tipoDocumento") TipoDocumento tipoDocumento, @PathVariable("numeroDocumento") String numeroDocumento) {
        Optional<ClienteResponseDTO> clienteOpt = clienteService.getCliente(tipoDocumento, numeroDocumento);
        return clienteOpt.map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}