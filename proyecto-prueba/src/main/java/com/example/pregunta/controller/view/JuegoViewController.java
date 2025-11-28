package com.example.pregunta.controller.view;

import com.example.pregunta.dto.ResultadoRespuestaDTO;
import com.example.pregunta.entity.Pregunta;
import com.example.pregunta.service.PreguntaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/view/jugar")
public class JuegoViewController {

    private final PreguntaService preguntaService;
    private static final int NUMERO_PREGUNTAS_PARTIDA = 5;

    public JuegoViewController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping
    public String jugar(Model model) {
        List<Pregunta> preguntasAleatorias = preguntaService.findRandomPreguntas(1);
        if (preguntasAleatorias.isEmpty()) {
            model.addAttribute("error", "No hay preguntas en la base de datos para poder jugar.");
            return "error";
        }
        model.addAttribute("pregunta", preguntasAleatorias.get(0));
        model.addAttribute("simulacion", false); // Indicamos que no es simulación
        return "juego/jugar";
    }

    @GetMapping("/{id}")
    public String jugarPorId(@PathVariable("id") Long preguntaId, Model model) {
        Pregunta pregunta = preguntaService.findById(preguntaId)
                .orElseThrow(() -> new IllegalArgumentException("No se puede simular. Pregunta no encontrada con id: " + preguntaId));
        model.addAttribute("pregunta", pregunta);
        model.addAttribute("simulacion", true); // Indicamos que SÍ es simulación
        return "juego/jugar";
    }

    @PostMapping("/verificar/{id}")
    public String verificarRespuesta(@PathVariable("id") Long preguntaId,
                                     @RequestParam("respuestaUsuario") boolean respuestaUsuario,
                                     @RequestParam(name = "simulacion", required = false, defaultValue = "false") boolean simulacion,
                                     Model model) {
        ResultadoRespuestaDTO resultado = preguntaService.verificarRespuesta(preguntaId, respuestaUsuario);
        model.addAttribute("resultado", resultado);
        model.addAttribute("simulacion", simulacion); // Pasamos el indicador a la vista de resultado
        return "juego/resultado";
    }

    @GetMapping("/partida")
    public String iniciarPartida(Model model) {
        List<Pregunta> preguntasPartida = preguntaService.findRandomPreguntas(NUMERO_PREGUNTAS_PARTIDA);
        if (preguntasPartida.size() < NUMERO_PREGUNTAS_PARTIDA) {
            model.addAttribute("error", "No hay suficientes preguntas en la base de datos para una partida.");
            return "error";
        }
        model.addAttribute("preguntas", preguntasPartida);
        return "juego/partida";
    }

    @PostMapping("/partida/corregir")
    public String corregirPartida(@RequestParam Map<String, String> respuestas, Model model) {
        AtomicInteger aciertos = new AtomicInteger(0);
        
        respuestas.forEach((preguntaIdStr, respuestaUsuarioStr) -> {
            Long preguntaId = Long.parseLong(preguntaIdStr.replace("respuesta-", ""));
            boolean respuestaUsuario = Boolean.parseBoolean(respuestaUsuarioStr);
            
            ResultadoRespuestaDTO resultado = preguntaService.verificarRespuesta(preguntaId, respuestaUsuario);
            if (resultado.esCorrecta()) {
                aciertos.getAndIncrement();
            }
        });

        model.addAttribute("aciertos", aciertos.get());
        model.addAttribute("total", respuestas.size());
        return "juego/resultado_partida";
    }
}
