package com.example.pregunta.controller;

import com.example.pregunta.dto.PreguntaDTO;
import com.example.pregunta.dto.PreguntaRequestDTO;
import com.example.pregunta.entity.Pregunta;
import com.example.pregunta.exception.ResourceNotFoundException;
import com.example.pregunta.mapper.PreguntaMapper;
import com.example.pregunta.service.PreguntaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PreguntaController.class)
class PreguntaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PreguntaService preguntaService;

    @MockBean
    private PreguntaMapper preguntaMapper;

    @Autowired
    private ObjectMapper objectMapper;

    private Pregunta pregunta1;
    private Pregunta pregunta2;
    private PreguntaDTO preguntaDTO1;
    private PreguntaDTO preguntaDTO2;

    @BeforeEach
    void setUp() {
        pregunta1 = new Pregunta("Pregunta 1", true);
        pregunta1.setId(1L);
        pregunta2 = new Pregunta("Pregunta 2", false);
        pregunta2.setId(2L);

        preguntaDTO1 = new PreguntaDTO(1L, "Pregunta 1", true);
        preguntaDTO2 = new PreguntaDTO(2L, "Pregunta 2", false);
    }

    @DisplayName("Test para listar todas las preguntas")
    @Test
    void testGetAllPreguntas() throws Exception {
        // Given
        given(preguntaService.findAll()).willReturn(List.of(pregunta1, pregunta2));
        given(preguntaMapper.toPreguntaDTO(pregunta1)).willReturn(preguntaDTO1);
        given(preguntaMapper.toPreguntaDTO(pregunta2)).willReturn(preguntaDTO2);

        // When
        ResultActions response = mockMvc.perform(get("/preguntas"));

        // Then
        response.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].enunciado", is(preguntaDTO1.enunciado())))
                .andExpect(jsonPath("$[1].enunciado", is(preguntaDTO2.enunciado())));
    }

    @DisplayName("Test para crear una nueva pregunta")
    @Test
    void testCreatePregunta() throws Exception {
        // Given
        PreguntaRequestDTO requestDTO = new PreguntaRequestDTO("Nueva Pregunta", true);
        Pregunta preguntaGuardada = new Pregunta("Nueva Pregunta", true);
        preguntaGuardada.setId(3L);
        
        given(preguntaMapper.toPregunta(any(PreguntaRequestDTO.class))).willReturn(new Pregunta());
        given(preguntaService.save(any(Pregunta.class))).willReturn(preguntaGuardada);
        given(preguntaMapper.toPreguntaDTO(any(Pregunta.class))).willReturn(new PreguntaDTO(3L, "Nueva Pregunta", true));

        // When
        ResultActions response = mockMvc.perform(post("/preguntas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)));

        // Then
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/preguntas/3"))
                .andExpect(jsonPath("$.enunciado", is("Nueva Pregunta")))
                .andExpect(jsonPath("$.respuesta", is(true)));
    }

    @DisplayName("Test para obtener una pregunta por ID cuando no existe")
    @Test
    void testGetPreguntaById_CuandoNoExiste() throws Exception {
        // Given
        long preguntaId = 99L;
        given(preguntaService.findById(preguntaId)).willThrow(new ResourceNotFoundException("Pregunta no encontrada con id: " + preguntaId));

        // When
        ResultActions response = mockMvc.perform(get("/preguntas/{id}", preguntaId));

        // Then
        response.andExpect(status().isNotFound())
                .andDo(print());
    }
}
