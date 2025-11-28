package com.example.pregunta.controller;

import com.example.pregunta.dto.PreguntaDTO;
import com.example.pregunta.dto.PreguntaRequestDTO;
import com.example.pregunta.entity.Pregunta;
import com.example.pregunta.exception.ResourceNotFoundException;
import com.example.pregunta.mapper.PreguntaMapper;
import com.example.pregunta.service.PreguntaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    private final PreguntaService preguntaService;
    private final PreguntaMapper preguntaMapper;

    public PreguntaController(PreguntaService preguntaService, PreguntaMapper preguntaMapper) {
        this.preguntaService = preguntaService;
        this.preguntaMapper = preguntaMapper;
    }

    @GetMapping
    public List<PreguntaDTO> getAllPreguntas() {
        return preguntaService.findAll().stream()
                .map(preguntaMapper::toPreguntaDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaDTO> getPreguntaById(@PathVariable(value = "id") Long preguntaId) {
        Pregunta pregunta = preguntaService.findById(preguntaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con id: " + preguntaId));
        return ResponseEntity.ok(preguntaMapper.toPreguntaDTO(pregunta));
    }

    @PostMapping
    public ResponseEntity<PreguntaDTO> createPregunta(@Valid @RequestBody PreguntaRequestDTO preguntaRequestDTO) {
        Pregunta pregunta = preguntaMapper.toPregunta(preguntaRequestDTO);
        Pregunta nuevaPregunta = preguntaService.save(pregunta);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nuevaPregunta.getId())
                .toUri();

        return ResponseEntity.created(location).body(preguntaMapper.toPreguntaDTO(nuevaPregunta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaDTO> updatePregunta(@PathVariable(value = "id") Long preguntaId,
                                                      @Valid @RequestBody PreguntaRequestDTO preguntaRequestDTO) {
        Pregunta preguntaExistente = preguntaService.findById(preguntaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con id: " + preguntaId));
        
        preguntaMapper.updatePreguntaFromDTO(preguntaRequestDTO, preguntaExistente);
        Pregunta preguntaActualizada = preguntaService.save(preguntaExistente);
        return ResponseEntity.ok(preguntaMapper.toPreguntaDTO(preguntaActualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable(value = "id") Long preguntaId) {
        preguntaService.findById(preguntaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada con id: " + preguntaId));
        
        preguntaService.deleteById(preguntaId);
        return ResponseEntity.noContent().build();
    }
    
}
