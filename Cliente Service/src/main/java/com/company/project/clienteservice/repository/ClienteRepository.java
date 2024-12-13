package com.company.project.clienteservice.repository;

import com.company.project.clienteservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Busca un cliente por tipo y número de documento.
     *
     * @param tipoDocumento    Tipo de documento (C o P)
     * @param numeroDocumento  Número de documento
     * @return Cliente si existe, vacío en caso contrario.
     */
    Optional<Cliente> findByTipoDocumentoAndNumeroDocumento(Cliente.TipoDocumento tipoDocumento, String numeroDocumento);
}