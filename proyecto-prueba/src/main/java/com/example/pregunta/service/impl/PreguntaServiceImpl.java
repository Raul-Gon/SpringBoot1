package com.example.pregunta.service.impl;

import com.example.pregunta.dto.ResultadoRespuestaDTO;
import com.example.pregunta.entity.Pregunta;
import com.example.pregunta.exception.ResourceNotFoundException;
import com.example.pregunta.repository.PreguntaRepository;
import com.example.pregunta.service.PreguntaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaServiceImpl(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pregunta> findAll() {
        return preguntaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pregunta> findAll(Pageable pageable) {
        return preguntaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pregunta> findById(Long id) {
        return preguntaRepository.findById(id);
    }

    @Override
    @Transactional
    public Pregunta save(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        preguntaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pregunta> findRandomPreguntas(int count) {
        return preguntaRepository.findRandomPreguntas(count);
    }

    @Override
    @Transactional(readOnly = true)
    public ResultadoRespuestaDTO verificarRespuesta(Long preguntaId, boolean respuestaUsuario) {
        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con id: " + preguntaId));

        boolean esCorrecta = pregunta.isRespuesta() == respuestaUsuario;
        String mensaje = esCorrecta ? "¡Respuesta correcta!" : "Respuesta incorrecta.";

        return new ResultadoRespuestaDTO(preguntaId, esCorrecta, mensaje);
    }
}
