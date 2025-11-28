package com.example.pregunta.dto;

public record ResultadoRespuestaDTO(
        Long preguntaId,
        boolean esCorrecta,
        String mensaje
) {
}
