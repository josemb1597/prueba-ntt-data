package com.company.project.clienteservice.controller;

import com.company.project.clienteservice.entity.Cliente;
import com.company.project.clienteservice.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Endpoint para consultar un cliente por tipo y número de documento.
     *
     * @param tipoDocumento    Tipo de documento (C o P)
     * @param numeroDocumento  Número de documento
     * @return Cliente si existe, o NotFound si no se encuentra.
     */

    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Cliente> getCliente(
            @PathVariable("tipoDocumento") Cliente.TipoDocumento tipoDocumento,
            @PathVariable("numeroDocumento") String numeroDocumento) {

        Optional<Cliente> clienteOpt = clienteService.getCliente(tipoDocumento, numeroDocumento);

        return clienteOpt.map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}