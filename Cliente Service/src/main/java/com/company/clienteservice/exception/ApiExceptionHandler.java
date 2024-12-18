package com.company.clienteservice.exception;

import com.company.clienteservice.application.dto.error.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

/**
 * Maneja las excepciones generadas en el controlador.
 * Proporciona respuestas apropiadas con los códigos HTTP adecuados (400, 404, 500).
 * Registra mensajes de error relevantes para facilitar el diagnóstico y la depuración.
 */

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequest(BadRequestException ex) {
        log.warn("BadRequestException: {}", ex.getMessage(), ex);
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(NoSuchElementException ex) {
        log.warn("NoSuchElementException: {}", ex.getMessage(), ex);
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleInternalServerError(Exception ex) {
        log.error("Exception: {}", ex.getMessage(), ex);
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponseDTO> buildErrorResponse(Exception ex, HttpStatus status) {
        log.info("Construyendo respuesta de error para el estado HTTP: {} - Mensaje: {}", status, ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(status.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }
}
