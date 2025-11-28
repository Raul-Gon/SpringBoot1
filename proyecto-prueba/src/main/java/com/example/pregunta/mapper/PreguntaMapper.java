package com.example.pregunta.mapper;

import com.example.pregunta.dto.PreguntaDTO;
import com.example.pregunta.dto.PreguntaRequestDTO;
import com.example.pregunta.entity.Pregunta;
import org.springframework.stereotype.Component;

@Component
public class PreguntaMapper {

    public PreguntaDTO toPreguntaDTO(Pregunta pregunta) {
        if (pregunta == null) {
            return null;
        }
        return new PreguntaDTO(
                pregunta.getId(),
                pregunta.getEnunciado(),
                pregunta.isRespuesta()
        );
    }

    public Pregunta toPregunta(PreguntaRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        Pregunta pregunta = new Pregunta();
        pregunta.setEnunciado(requestDTO.enunciado());
        pregunta.setRespuesta(requestDTO.respuesta());
        return pregunta;
    }

    public void updatePreguntaFromDTO(PreguntaRequestDTO requestDTO, Pregunta pregunta) {
        if (requestDTO == null || pregunta == null) {
            return;
        }
        pregunta.setEnunciado(requestDTO.enunciado());
        pregunta.setRespuesta(requestDTO.respuesta());
    }
}
