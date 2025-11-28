package com.example.pregunta.service.impl;

import com.example.pregunta.dto.ResultadoRespuestaDTO;
import com.example.pregunta.entity.Pregunta;
import com.example.pregunta.exception.ResourceNotFoundException;
import com.example.pregunta.repository.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PreguntaServiceImplTest {

    @Mock
    private PreguntaRepository preguntaRepository;

    @InjectMocks
    private PreguntaServiceImpl preguntaService;

    private Pregunta pregunta;

    @BeforeEach
    void setUp() {
        // Creamos un objeto de ejemplo que se usará en varios tests
        pregunta = new Pregunta("¿Java es un lenguaje de programación?", true);
        pregunta.setId(1L);
    }

    @DisplayName("Test para guardar una pregunta")
    @Test
    void testSavePregunta() {
        // Given
        given(preguntaRepository.save(any(Pregunta.class))).willReturn(pregunta);

        // When
        Pregunta preguntaGuardada = preguntaService.save(pregunta);

        // Then
        assertNotNull(preguntaGuardada);
        assertEquals(pregunta.getEnunciado(), preguntaGuardada.getEnunciado());
        verify(preguntaRepository).save(pregunta);
    }

    @DisplayName("Test para obtener todas las preguntas")
    @Test
    void testFindAllPreguntas() {
        // Given
        Pregunta pregunta2 = new Pregunta("¿La tierra es plana?", false);
        pregunta2.setId(2L);
        given(preguntaRepository.findAll()).willReturn(List.of(pregunta, pregunta2));

        // When
        List<Pregunta> preguntas = preguntaService.findAll();

        // Then
        assertNotNull(preguntas);
        assertEquals(2, preguntas.size());
        verify(preguntaRepository).findAll();
    }

    @DisplayName("Test para eliminar una pregunta")
    @Test
    void testDeletePregunta() {
        // Given
        long preguntaId = 1L;
        // Configuramos el mock para que no haga nada cuando se llame a deleteById
        willDoNothing().given(preguntaRepository).deleteById(preguntaId);

        // When
        preguntaService.deleteById(preguntaId);

        // Then
        // Verificamos que el método deleteById del repositorio fue llamado exactamente una vez.
        verify(preguntaRepository, times(1)).deleteById(preguntaId);
    }

    @DisplayName("Test para verificar una respuesta correcta")
    @Test
    void testVerificarRespuesta_CuandoEsCorrecta() {
        // Given
        given(preguntaRepository.findById(1L)).willReturn(Optional.of(pregunta));

        // When
        boolean respuestaUsuario = true;
        ResultadoRespuestaDTO resultado = preguntaService.verificarRespuesta(1L, respuestaUsuario);

        // Then
        assertNotNull(resultado);
        assertTrue(resultado.esCorrecta());
        assertEquals("¡Respuesta correcta!", resultado.mensaje());
        verify(preguntaRepository).findById(1L);
    }

    @DisplayName("Test para verificar una respuesta incorrecta")
    @Test
    void testVerificarRespuesta_CuandoEsIncorrecta() {
        // Given
        given(preguntaRepository.findById(1L)).willReturn(Optional.of(pregunta));

        // When
        boolean respuestaUsuario = false;
        ResultadoRespuestaDTO resultado = preguntaService.verificarRespuesta(1L, respuestaUsuario);

        // Then
        assertNotNull(resultado);
        assertFalse(resultado.esCorrecta());
        assertEquals("Respuesta incorrecta.", resultado.mensaje());
        verify(preguntaRepository).findById(1L);
    }

    @DisplayName("Test para verificar que se lanza excepción si la pregunta no existe")
    @Test
    void testVerificarRespuesta_CuandoPreguntaNoExiste() {
        // Given
        long preguntaId = 99L;
        given(preguntaRepository.findById(preguntaId)).willReturn(Optional.empty());

        // When & Then
        assertThrows(ResourceNotFoundException.class, () -> {
            preguntaService.verificarRespuesta(preguntaId, true);
        });
        verify(preguntaRepository).findById(preguntaId);
    }
}
