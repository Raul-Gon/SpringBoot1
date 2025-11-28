package com.example.pregunta.dto;

// Usamos un 'record' de Java para un DTO inmutable y conciso.
public record PreguntaDTO(
        Long id,
        String enunciado,
        boolean respuesta
) {
}
