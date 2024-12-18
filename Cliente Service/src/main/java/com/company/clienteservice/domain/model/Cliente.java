package com.company.clienteservice.domain.model;

import com.company.clienteservice.domain.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('C', 'P')")
    private TipoDocumento tipoDocumento;

    @Column(nullable = false, unique = true, length = 20)
    private String numeroDocumento;

    @Column(nullable = false, length = 50)
    private String primerNombre;

    @Column(length = 50)
    private String segundoNombre;

    @Column(nullable = false, length = 50)
    private String primerApellido;

    @Column(length = 50)
    private String segundoApellido;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String direccion;

    @Column(length = 50)
    private String ciudadResidencia;

}