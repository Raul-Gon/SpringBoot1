package com.example.pregunta.dto;

import jakarta.validation.constraints.NotNull;

public record RespuestaUsuarioDTO(
        @NotNull(message = "La respuesta no puede ser nula")
        Boolean respuesta
) {
}
