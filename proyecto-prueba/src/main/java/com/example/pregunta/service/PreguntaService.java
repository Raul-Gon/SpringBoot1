package com.example.pregunta.service;

import com.example.pregunta.dto.ResultadoRespuestaDTO;
import com.example.pregunta.entity.Pregunta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    List<Pregunta> findAll();
    Page<Pregunta> findAll(Pageable pageable);
    Optional<Pregunta> findById(Long id);
    Pregunta save(Pregunta pregunta);
    void deleteById(Long id);

    // Nuevos métodos para el juego
    List<Pregunta> findRandomPreguntas(int count);
    ResultadoRespuestaDTO verificarRespuesta(Long preguntaId, boolean respuestaUsuario);
}
