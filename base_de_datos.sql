-- Script para la creación de la base de datos y tabla correspondiente

-- Creación de la base de datos
CREATE DATABASE cliente_service_db;

-- Seleccionar la base de datos para uso
USE cliente_service_db;

-- Creación de la tabla para almacenar la información de clientes
CREATE TABLE cliente (
    id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_documento ENUM('C', 'P') NOT NULL COMMENT 'C: Cédula de ciudadanía, P: Pasaporte',
    numero_documento VARCHAR(20) NOT NULL UNIQUE COMMENT 'Número único del documento',
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50),
    telefono VARCHAR(15),
    direccion VARCHAR(100),
    ciudad_residencia VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla para almacenar información básica de clientes';

-- Inserción de datos mockeados
INSERT INTO cliente (
    tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, direccion, ciudad_residencia
) VALUES (
    'C', '23445322', 'Juan', 'Carlos', 'Pérez', 'García', '555-1234', 'Calle 123', 'Bogotá'
);
