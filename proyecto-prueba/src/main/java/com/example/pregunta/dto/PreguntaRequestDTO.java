package com.example.pregunta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PreguntaRequestDTO(
        @NotBlank(message = "El enunciado no puede estar vacío")
        String enunciado,

        @NotNull(message = "La respuesta no puede ser nula")
        Boolean respuesta
) {
}
